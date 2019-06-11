CREATE SEQUENCE srv_auth."accounts_seq"
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE srv_auth."accounts_seq" OWNER TO "srv_auth_role";
COMMIT;

CREATE SEQUENCE srv_auth."user_id_seq"
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE srv_auth."user_id_seq" OWNER TO "srv_auth_role";
COMMIT;