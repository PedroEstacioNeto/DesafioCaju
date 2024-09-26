CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS public.set_account
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    cash_balance double precision,
    food_balance double precision,
    meal_balance double precision,
    CONSTRAINT set_account_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.set_account
    OWNER to postgres;