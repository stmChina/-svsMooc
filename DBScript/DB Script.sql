-- Database: "TestSys"

-- DROP DATABASE "TestSys";

CREATE DATABASE "TestSys"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Chinese (Simplified)_China.936'
       LC_CTYPE = 'Chinese (Simplified)_China.936'
       CONNECTION LIMIT = -1;


-- Table: Answer

-- DROP TABLE Answer;

CREATE TABLE Answer
(
  aid integer NOT NULL,
  acontent character varying(200) NOT NULL,
  correctf character(1) NOT NULL DEFAULT 0,
  ins_dt timestamp with time zone,
  ins_userid character varying(50),
  upd_dt timestamp with time zone,
  upd_userid character varying(50),
  CONSTRAINT pri_aid PRIMARY KEY (aid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE Answer
  OWNER TO postgres;

CREATE SEQUENCE answer_id_seq  
START WITH 41  
INCREMENT BY 1  
NO MINVALUE  
NO MAXVALUE  
CACHE 1; 

alter table answer alter column aid set default nextval('answer_id_seq');  

-- Table: Q_A_Relation

-- DROP TABLE Q_A_Relation;

CREATE TABLE Q_A_Relation
(
  aid integer NOT NULL,
  qid integer NOT NULL,
  ins_dt timestamp with time zone,
  ins_userid character varying(50),
  upd_dt timestamp with time zone,
  upd_userid character varying(50),
  CONSTRAINT pri_qaid PRIMARY KEY (aid, qid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE Q_A_Relation
  OWNER TO postgres;

-- Table: Question

-- DROP TABLE Question;

CREATE TABLE Question
(
  qid integer NOT NULL,
  qcontent character varying(200) NOT NULL,
  ins_dt timestamp with time zone,
  ins_userid character varying(50),
  upd_dt timestamp with time zone,
  upd_userid character varying(50),
  schtime integer,
  score numeric,
  multiselect character(1) NOT NULL DEFAULT 0,
  CONSTRAINT pri_qid PRIMARY KEY (qid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE Question
  OWNER TO postgres;

CREATE SEQUENCE quest_id_seq  
START WITH 11  
INCREMENT BY 1  
NO MINVALUE  
NO MAXVALUE  
CACHE 1; 

alter table question alter column qid set default nextval('quest_id_seq');  

-- Table: TestResult

-- DROP TABLE TestResult;

CREATE TABLE TestResult
(
  rid integer NOT NULL,
  schtime integer,
  casttime integer,
  ins_dt timestamp with time zone,
  ins_userid character varying(50),
  upd_dt timestamp with time zone,
  upd_userid character varying(50),
  score numeric,
  CONSTRAINT pri_rid PRIMARY KEY (rid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE TestResult
  OWNER TO postgres;

CREATE SEQUENCE TestResult_id_seq  
START WITH 41  
INCREMENT BY 1  
NO MINVALUE  
NO MAXVALUE  
CACHE 1; 

alter table TestResult alter column rid set default nextval('TestResult_id_seq');  
  
-- Table: TestResultDDtl

-- DROP TABLE TestResultDDtl;

CREATE TABLE TestResultDDtl
(
  rdid integer NOT NULL,
  aid integer NOT NULL,
  disorder character(1) NOT NULL,
  selected character(1) NOT NULL DEFAULT 0,
  ins_dt timestamp with time zone,
  ins_userid character varying(50),
  upd_dt timestamp with time zone,
  upd_userid character varying(50),
  CONSTRAINT pri_ardid PRIMARY KEY (aid, rdid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE TestResultDDtl
  OWNER TO postgres;


-- Table: TestResultDtl

-- DROP TABLE TestResultDtl;

CREATE TABLE TestResultDtl
(
  rdid integer NOT NULL,
  rid integer NOT NULL,
  qid integer NOT NULL,
  casttime integer,
  correct character(1),
  disorder int NOT NULL,
  ins_dt timestamp with time zone,
  ins_userid character varying(50),
  upd_dt timestamp with time zone,
  upd_userid character varying(50),
  CONSTRAINT pri_rdid PRIMARY KEY (rdid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE TestResultDtl
  OWNER TO postgres;

CREATE SEQUENCE TestResultDtl_id_seq  
START WITH 41  
INCREMENT BY 1  
NO MINVALUE  
NO MAXVALUE  
CACHE 1; 

alter table TestResultDtl alter column rdid set default nextval('TestResultDtl_id_seq');  
