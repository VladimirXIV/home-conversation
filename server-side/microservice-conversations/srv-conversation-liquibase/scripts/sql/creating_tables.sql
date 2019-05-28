CREATE TABLE srv_converse."conversation"
(
"id" bigint not null,
"title" character varying(128),
"creator_id" bigint not null,
"created_at" date,
"updated_at" date,
CONSTRAINT "pk_conversation" PRIMARY KEY ("id")
)
WITH (
OidS=FALSE
);
ALTER TABLE srv_converse."conversation" OWNER TO "srv_convers_role";

CREATE TABLE srv_converse."participant"
(
"id" bigint not null,
"conversation_id" bigint ,
"user_id" bigint,
"role_id" bigint,
CONSTRAINT "pk_participant" PRIMARY KEY ("id")
)
WITH (
OidS=FALSE
);
ALTER TABLE srv_converse."participant" OWNER TO "srv_convers_role";

CREATE TABLE srv_converse."role"
(
"id" bigint not null,
"type" character varying(128),
CONSTRAINT "pk_role" PRIMARY KEY ("id")
)
WITH (
OidS=FALSE
);
ALTER TABLE srv_converse."role" OWNER TO "srv_convers_role";

CREATE TABLE srv_converse."deleted_conversation"
(
"id" bigint not null,
"conversation_id" bigint ,
"participant_id" bigint,
"created_at" date,
CONSTRAINT "pk_deleted_conversation" PRIMARY KEY ("id")
)
WITH (
OidS=FALSE
);
ALTER TABLE srv_converse."deleted_conversation" OWNER TO "srv_convers_role";

COMMIT;