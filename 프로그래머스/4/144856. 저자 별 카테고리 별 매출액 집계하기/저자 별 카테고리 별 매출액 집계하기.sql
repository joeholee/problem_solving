-- 코드를 입력하세요
SELECT B.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(B.PRICE*S.SALES) AS TOTAL_SALES
FROM BOOK_SALES AS S
JOIN BOOK AS B ON B.BOOK_ID = S.BOOK_ID
JOIN AUTHOR AS A ON A.AUTHOR_ID = B.AUTHOR_ID
WHERE YEAR(S.SALES_DATE) = 2022 AND MONTH(S.SALES_DATE) = 01
GROUP BY A.AUTHOR_ID, B.CATEGORY
ORDER BY A.AUTHOR_ID, B.CATEGORY DESC;