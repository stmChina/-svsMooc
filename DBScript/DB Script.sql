-- Database: "TestSys"

-- DROP DATABASE "TestSys";

CREATE DATABASE "TestSys"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Chinese (Simplified)_China.936'
       LC_CTYPE = 'Chinese (Simplified)_China.936'
       CONNECTION LIMIT = -1;


-- Table: public."Answer"

-- DROP TABLE public."Answer";

CREATE TABLE public."Answer"
(
  aid integer NOT NULL,
  acontent character varying(200) NOT NULL,
  ins_dt timestamp with time zone,
  ins_userid character varying(50),
  upd_dt timestamp with time zone,
  upd_userid character varying(50),
  CONSTRAINT pri_aid PRIMARY KEY (aid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Answer"
  OWNER TO postgres;


-- Table: public."Q_A_Relation"

-- DROP TABLE public."Q_A_Relation";

CREATE TABLE public."Q_A_Relation"
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
ALTER TABLE public."Q_A_Relation"
  OWNER TO postgres;


-- Table: public."Q_CA_Relation"

-- DROP TABLE public."Q_CA_Relation";

CREATE TABLE public."Q_CA_Relation"
(
  aid integer NOT NULL,
  qid integer NOT NULL,
  ins_dt timestamp with time zone,
  ins_userid character varying(50),
  upd_dt timestamp with time zone,
  upd_userid character varying(50),
  CONSTRAINT pri_qcaid PRIMARY KEY (aid, qid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Q_CA_Relation"
  OWNER TO postgres;


-- Table: public."Question"

-- DROP TABLE public."Question";

CREATE TABLE public."Question"
(
  qid integer NOT NULL,
  qcontent character varying(200) NOT NULL,
  ins_dt timestamp with time zone,
  ins_userid character varying(50),
  upd_dt timestamp with time zone,
  upd_userid character varying(50),
  schtime integer,
  score numeric,
  CONSTRAINT pri_qid PRIMARY KEY (qid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Question"
  OWNER TO postgres;


-- Table: public."TestResult"

-- DROP TABLE public."TestResult";

CREATE TABLE public."TestResult"
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
ALTER TABLE public."TestResult"
  OWNER TO postgres;


-- Table: public."TestResultDDtl"

-- DROP TABLE public."TestResultDDtl";

CREATE TABLE public."TestResultDDtl"
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
ALTER TABLE public."TestResultDDtl"
  OWNER TO postgres;


-- Table: public."TestResultDtl"

-- DROP TABLE public."TestResultDtl";

CREATE TABLE public."TestResultDtl"
(
  rdid integer NOT NULL,
  rid integer NOT NULL,
  qid integer NOT NULL,
  casttime integer,
  correct character(1),
  ins_dt timestamp with time zone,
  ins_userid character varying(50),
  upd_dt timestamp with time zone,
  upd_userid character varying(50),
  CONSTRAINT pri_rdid PRIMARY KEY (rdid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."TestResultDtl"
  OWNER TO postgres;
