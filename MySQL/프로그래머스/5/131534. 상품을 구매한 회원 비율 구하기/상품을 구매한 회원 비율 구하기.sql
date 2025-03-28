SELECT YEAR(O.SALES_DATE) AS YEAR, MONTH(O.SALES_DATE) AS MONTH, COUNT(DISTINCT O.USER_ID) AS PURCHASED_USERS, ROUND(COUNT(DISTINCT O.USER_ID) / (SELECT COUNT(*) FROM USER_INFO WHERE YEAR(JOINED) = 2021), 1) AS PURCHASED_RATIO
FROM ONLINE_SALE O
JOIN USER_INFO U
ON O.USER_ID = U.USER_ID
WHERE YEAR(U.JOINED) = 2021
GROUP BY YEAR(O.SALES_DATE), MONTH(O.SALES_DATE)
ORDER BY YEAR, MONTH;