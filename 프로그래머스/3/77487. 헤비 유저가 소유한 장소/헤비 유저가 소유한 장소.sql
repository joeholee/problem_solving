-- 코드를 입력하세요
with cte as (
    select id, name, host_id, count(*) over (partition by host_id) as cnt
    from places
)

select id, name, host_id
from cte
where cnt>=2
order by id