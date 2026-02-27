-- 코드를 입력하세요
SELECT FLAVOR from FIRST_HALF where total_order > 3000 and flavor in (select flavor from ICECREAM_INFO where ingredient_type = 'fruit_based') order by total_order desc;