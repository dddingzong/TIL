-- 코드를 입력하세요
SELECT MCDP_CD as '진료과 코드', count(*) as '5월예약건수' from appointment where YEAR(APNT_YMD) = 2022 and MONTH(APNT_YMD) = 5 group by MCDP_CD order by COUNT(*) asc, MCDP_CD asc;