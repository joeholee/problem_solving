-- 코드를 작성해주세요
SELECT A.ITEM_ID, A.ITEM_NAME
FROM ITEM_INFO AS A
JOIN ITEM_TREE AS B ON B.ITEM_ID = A.ITEM_ID
WHERE B.PARENT_ITEM_ID IS NULL
ORDER BY A.ITEM_ID;