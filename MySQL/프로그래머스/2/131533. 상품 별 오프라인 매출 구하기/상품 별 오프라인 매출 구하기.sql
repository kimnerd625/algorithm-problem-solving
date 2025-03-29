SELECT P.PRODUCT_CODE, (SUM(O.SALES_AMOUNT) * P.PRICE) AS SALES
FROM PRODUCT P
RIGHT JOIN OFFLINE_SALE O
ON P.PRODUCT_ID = O.PRODUCT_ID
GROUP BY O.PRODUCT_ID
ORDER BY SALES DESC, P.PRODUCT_CODE ASC;