select product_code as PRODUCT_CODE, sum(o.sales_amount * p.price) as SALES
from offline_sale o
join product p on o.product_id = p.product_id
group by p.product_code
order by sum(o.sales_amount * p.price) desc, p.product_code asc;