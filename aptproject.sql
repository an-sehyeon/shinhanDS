select * from applicant_info;
select * from unit_price_by_area where housing_area = 24;
select * from view_all_area_rank;
select * from applicant_info;



create view  view_area_payment_plan as
select ap.bno, ap.name, ap.reg_no, ap.phone, ap.housing_area, un.down_payment, un.interim_payment, un.balace_payment, un.total_price
from unit_price_by_area un join applicant_info ap on un.housing_area = ap.housing_area;

select * from view_area_payment_plan where name='이지연';