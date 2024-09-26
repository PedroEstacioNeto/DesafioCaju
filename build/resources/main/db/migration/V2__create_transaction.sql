CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS public.transaction
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    account character varying(255) COLLATE pg_catalog."default",
    data_transaction timestamp(6) without time zone,
    mcc character varying(255) COLLATE pg_catalog."default",
    merchant character varying(255) COLLATE pg_catalog."default",
    total_amount double precision,
    CONSTRAINT transaction_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transaction
    OWNER to postgres;