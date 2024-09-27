CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- SEQUENCE: public.account_seq

CREATE SEQUENCE IF NOT EXISTS public.account_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY set_account.id;

ALTER SEQUENCE public.account_seq
    OWNER TO postgres;