-- type category 시퀀스 생성
CREATE SEQUENCE seq_type_category_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- D_category 시퀀스 생성
CREATE SEQUENCE seq_d_category_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- U_category 시퀀스 생성
CREATE SEQUENCE seq_u_category_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 카테고리 값 insert
insert into type_category VALUES(seq_type_category_id.nextval, '뜨개질');
insert into type_category VALUES(seq_type_category_id.nextval, '금속공예');
insert into type_category VALUES(seq_type_category_id.nextval, '목공예');
insert into type_category VALUES(seq_type_category_id.nextval, '도자기공예');
insert into type_category VALUES(seq_type_category_id.nextval, '유리공예');
insert into type_category VALUES(seq_type_category_id.nextval, '가죽공예');
insert into type_category VALUES(seq_type_category_id.nextval, '레진공예');
insert into type_category VALUES(seq_type_category_id.nextval, '식물공예');
insert into type_category VALUES(seq_type_category_id.nextval, '양재공예');
insert into type_category VALUES(seq_type_category_id.nextval, '기타');

-- 상의 카테고라 값
insert into U_CATEGORY VALUES(seq_d_category_id.nextval, '패션잡화');
insert into U_CATEGORY VALUES(seq_d_category_id.nextval, '인테리어 소품');
insert into U_CATEGORY VALUES(seq_d_category_id.nextval, '악세서리');
insert into U_CATEGORY VALUES(seq_d_category_id.nextval, '생활잡화');
insert into U_CATEGORY VALUES(seq_d_category_id.nextval, '기타');

-- 하의 카테고리 값
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 1,'상의');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 1,'하의');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 1,'가방');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 1,'지갑');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 1,'기타(목도리, 모자, 벨트, etc)');

insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 2,'디퓨저,캔들');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 2,'무드등');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 2,'꽃,식물');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 2,'가구');

insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 3,'반지');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 3,'팔찌');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 3,'목걸이');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 3,'키링');

insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 4,'비누');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 4,'그릇');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 4,'식기류');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 4,'컵');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 4,'케이스');

insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 5,'향수');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 5,'인형');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 5,'반려동물');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 5,'문구');

