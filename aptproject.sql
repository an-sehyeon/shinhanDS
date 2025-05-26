select * from applicant_info;
select * from unit_price_by_area where housing_area = 24;
select * from view_all_area_rank where housing_area = 48;
select * from applicant_info;
select * from view_all_list where bno = 349;
--------------------------------
select distinct address from address_score;
select dependent_count from dependent_score;
select non_home_start_date from non_home_ownership_score;
select Account_open_date from subscription_account_score;
select distinct housing_area from applicant_info;



INSERT INTO user_info VALUES (seq_bno.nextval,'안', 'an', '1111', '111111-1111111', '010-1111-1111', '대구', 0, 15, 12, 'N', 34);
select * from user_info;


-- 사용자 회원가입 테이블 생성
create sequence seq_bno;
create table user_info(
    bno number primary key,
    role varchar2(10) not null,
    name varchar2(10) not null,
    id varchar2(30) not null,
    password varchar2(50) not null,
    reg_no varchar2(20) not null,
    phone varchar2(20) not null,
    address varchar2(7) not null,
    dependent_count number not null,
    non_home_start_date number not null,
    account_open_date varchar2(15) not null,
    is_married char(1) not null,
    housing_area number not null
);

-- 관리자 회원가입 테이블 생성
create table admin_info(
    name varchar2(10) not null,
    id varchar2(30) not null,
    password varchar2(50) not null,
    s_key varchar2(15) not null
);



-- view_all_rank 해당 사용자의 bno를 통해 순위 확인 뷰
create view view_all_rank as
select info.bno, info.name, info.reg_no, info.phone, info.address, info.housing_area, office.total_score, office.area_rank
from applicant_info info join application_office office on info.bno = office.bno;


--기존의 view_all_list 삭제하고 순위자동재정렬 view_all_list 재생성
DROP VIEW view_all_rank;

CREATE OR REPLACE VIEW view_all_list AS
SELECT
    ai.bno,
    ai.name,
    ai.reg_no,
    ai.phone,
    ai.address,
    ai.housing_area,
    ao.total_score,
    ROW_NUMBER() OVER (
        PARTITION BY ai.housing_area
        ORDER BY ao.total_score DESC
    ) AS area_rank
FROM 
    applicant_info ai
JOIN 
    application_office ao
ON 
    ai.bno = ao.bno;





-- 분양금 납부 일정 정보 뷰 생성
create view  view_area_payment_plan as
select ap.bno, ap.name, ap.reg_no, ap.phone, ap.housing_area, un.down_payment, un.interim_payment, un.balace_payment, un.total_price
from unit_price_by_area un join applicant_info ap on un.housing_area = ap.housing_area;

select * from view_area_payment_plan where name='이지연';


------------------------------------------------------------------------------------

--프로시저 생성 권한 부여 명령어
conn system/1234
--프로시저 생성 권한 부여
GRANT CREATE PROCEDURE TO 사용자명;



-- 사용자 삭제 프로시저 생성
CREATE OR REPLACE PROCEDURE delete_applicant(
    p_bno     IN NUMBER,
    p_name    IN VARCHAR2,
    p_reg_no  IN VARCHAR2
)
AS
BEGIN
    -- 먼저 application_office 테이블에서 삭제 (외래키 참조 먼저 삭제)
    DELETE FROM application_office
    WHERE bno = p_bno;

    -- 그 다음 applicant_info에서 삭제 (기본 정보 삭제)
    DELETE FROM applicant_info
    WHERE bno = p_bno
      AND name = p_name
      AND reg_no = p_reg_no;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END;
/

-- 프로시저 테스트
BEGIN
  delete_applicant(342, '윤정희', '820409-3202262');
END;
/


-- 사용자가 한명 삭제되면 application_office테이블에서 해당 사용자의 데이터가 삭제되고 순위 재정렬 트리거 생성
CREATE OR REPLACE TRIGGER trg_delete_applicant_info
AFTER DELETE ON applicant_info
FOR EACH ROW
DECLARE
    v_old_rank NUMBER;
    v_housing_area NUMBER;
BEGIN
    -- 1. 삭제될 사용자의 순위와 주거 면적(housing_area) 조회
    BEGIN
        SELECT area_rank, housing_area INTO v_old_rank, v_housing_area
        FROM application_office
        WHERE bno = :OLD.bno;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            v_old_rank := NULL;
            v_housing_area := NULL;
    END;

    -- 2. application_office 테이블에서 삭제
    DELETE FROM application_office
    WHERE bno = :OLD.bno;

    -- 3. 순위 재정렬
    IF v_old_rank IS NOT NULL THEN
        UPDATE application_office
        SET area_rank = area_rank - 1
        WHERE housing_area = v_housing_area
          AND area_rank > v_old_rank;
    END IF;
END;
/

commit;









