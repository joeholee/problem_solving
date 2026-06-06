-- 코드를 작성해주세요
select count(id) as FISH_COUNT, FISH_NAME
from fish_info f
join fish_name_info n
on f.fish_type = n.fish_type
group by f.fish_type
order by 1 desc