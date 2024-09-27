CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
-- Table: public.merchant

CREATE TABLE IF NOT EXISTS public.merchant
(
    id character varying COLLATE pg_catalog."default" NOT NULL,
    merchant character varying COLLATE pg_catalog."default",
    merchant_mcc character varying COLLATE pg_catalog."default",
    CONSTRAINT merchant_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.merchant
    OWNER to postgres;