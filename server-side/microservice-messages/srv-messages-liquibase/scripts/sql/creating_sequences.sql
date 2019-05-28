CREATE SEQUENCE srv_message."message_seq"
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE srv_message."message_seq" OWNER TO "srv_message_role";
COMMIT;

CREATE SEQUENCE srv_message."deleted_message_seq"
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE srv_message."deleted_message_seq" OWNER TO "srv_message_role";
COMMIT;