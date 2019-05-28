CREATE TABLE srv_message."message"
(
"id" bigint not null,
"conversation_id" bigint not null,
"participant_id" bigint not null,
"message_type" character varying(128),
"message" character varying(4096),
"created_at" date,
"deleted_at" date,
CONSTRAINT "pk_srv_messages" PRIMARY KEY ("id")
)
WITH (
OidS=FALSE
);
ALTER TABLE srv_message."message" OWNER TO "srv_message";

CREATE TABLE srv_messages."deleted_message"
(
"id" bigint not null,
"message_id" bigint not null,
"participant_id" bigint not null,
"deleted_at" date,
CONSTRAINT "pk_srv_messages" PRIMARY KEY ("id")
)
WITH (
OidS=FALSE
);
ALTER TABLE srv_message."deleted_message" OWNER TO "deleted_message";