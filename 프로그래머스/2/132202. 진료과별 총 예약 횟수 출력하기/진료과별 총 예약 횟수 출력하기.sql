select mcdp_cd as 진료과코드, count(*) as 5월예약건수
from appointment
where month(apnt_ymd) = 5
group by MCDP_CD
order by count(*) asc, mcdp_cd asc