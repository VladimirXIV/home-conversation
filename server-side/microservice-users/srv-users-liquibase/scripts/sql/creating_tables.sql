CREATE TABLE srv_users."users"
(
"id" bigint not null,
"phone" character varying(16),
"email" character varying(32),
"first_name" character varying(32),
"middle_name" character varying(32),
"last_name" character varying(32),
"is_active" boolean,
"is_reported" boolean,
"is_blocked" boolean,
"created_at" date,
"updated_at" date,
"verification_code" character varying(16),
CONSTRAINT "pk_users" PRIMARY KEY ("id")
)
WITH (
OidS=FALSE
);
ALTER TABLE srv_users."users"
OWNER TO "srv_users_role";
COMMIT;

CREATE TABLE srv_users."reports"
(
"id" bigint not null,
"users_id" bigint not null,
"participant_id" bigint not null,
"report_type" character varying(32),
"notes" character varying(512),
"created_at" date,
CONSTRAINT "pk_reports" PRIMARY KEY ("id"),
CONSTRAINT "fk_users" FOREIGN KEY ("users_id")
REFERENCES srv_users."users" ("id") MATCH SIMPLE
ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
OidS=FALSE
);
ALTER TABLE srv_users."reports"
OWNER TO "srv_users_role";
COMMIT;

CREATE TABLE srv_users."block_list"
(
"id" bigint not null,
"users_id" bigint not null,
"participant_id" bigint not null,
CONSTRAINT "pk_block_list" PRIMARY KEY ("id"),
CONSTRAINT "fk_users" FOREIGN KEY ("users_id")
REFERENCES srv_users."users" ("id") MATCH SIMPLE
ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
OidS=FALSE
);
ALTER TABLE srv_users."block_list"
OWNER TO "srv_users_role";
COMMIT;