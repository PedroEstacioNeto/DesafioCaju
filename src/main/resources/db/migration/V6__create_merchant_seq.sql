CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
-- SEQUENCE: public.merchant_seq

CREATE SEQUENCE IF NOT EXISTS public.merchant_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY merchant.id;

ALTER SEQUENCE public.merchant_seq
    OWNER TO postgres;