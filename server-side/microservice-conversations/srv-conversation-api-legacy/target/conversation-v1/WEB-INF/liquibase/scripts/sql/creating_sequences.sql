CREATE SEQUENCE srv_converse."conversation_seq"
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE srv_converse."conversation_seq" OWNER TO "srv_convers_role";
COMMIT;

CREATE SEQUENCE srv_converse."participant_seq"
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE srv_converse."participant_seq" OWNER TO "srv_convers_role";
COMMIT;

CREATE SEQUENCE srv_converse."role_seq"
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE srv_converse."role_seq" OWNER TO "srv_convers_role";
COMMIT;

CREATE SEQUENCE srv_converse."deleted_conversation_seq"
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER SEQUENCE srv_converse."deleted_conversation_seq" OWNER TO "srv_convers_role";
COMMIT;