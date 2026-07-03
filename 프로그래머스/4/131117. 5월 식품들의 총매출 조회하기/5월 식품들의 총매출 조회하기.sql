-- 코드를 입력하세요
# SELECT P.PRODUCT_ID, P.PRODUCT_NAME, SUM(P.PRICE * O.AMOUNT) AS TOTAL_SALES
# FROM FOOD_PRODUCT P
# JOIN FOOD_ORDER O
# ON P.PRODUCT_ID = O.PRODUCT_ID
# WHERE YEAR(O.PRODUCE_DATE) = 2022 AND MONTH(O.PRODUCE_DATE) = 5
# GROUP BY P.PRODUCT_ID
# ORDER BY TOTAL_SALES DESC, P.PRODUCT_ID;

select
    p.product_id,
    p.product_name,
    sum(p.price * o.amount) as total_sales
from food_product p
join food_order o
on p.product_id = o.product_id
where o.produce_date like '2022-05%'
group by p.product_id
order by 3 desc, 1