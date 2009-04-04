CREATE TABLE public.user_info
(
  user_id character varying(20) NOT NULL,
  user_nm character varying(50) NOT NULL,
  pwd character varying(20) NOT NULL,
  CONSTRAINT con_pri PRIMARY KEY (user_id)
)