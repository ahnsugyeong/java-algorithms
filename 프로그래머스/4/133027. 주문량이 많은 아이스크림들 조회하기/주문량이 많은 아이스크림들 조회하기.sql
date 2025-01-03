SELECT 
    FH.FLAVOR
FROM 
    FIRST_HALF FH
JOIN 
    JULY J ON FH.FLAVOR = J.FLAVOR
GROUP BY
    FH.FLAVOR
ORDER BY
    SUM(FH.TOTAL_ORDER + J.TOTAL_ORDER) DESC
LIMIT 3;