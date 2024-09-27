CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO public.set_account(
	id, cash_balance, food_balance, meal_balance)
	VALUES (nextval('account_seq'), 1000, 1000, 1000);