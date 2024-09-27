CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO public.merchant(id, merchant, merchant_mcc)VALUES (nextval('merchant_seq'), 'PADARIA DO ZE', '5811');
INSERT INTO public.merchant(id, merchant, merchant_mcc)VALUES (nextval('merchant_seq'), 'UBER TRIP', '5910');
INSERT INTO public.merchant(id, merchant, merchant_mcc)VALUES (nextval('merchant_seq'), 'UBER EATS', '5811');
INSERT INTO public.merchant(id, merchant, merchant_mcc)VALUES (nextval('merchant_seq'), 'PAG*JoseDaSilva', '5412');
INSERT INTO public.merchant(id, merchant, merchant_mcc)VALUES (nextval('merchant_seq'), 'PICPAY*BILHETEUNICO  ', '5910');