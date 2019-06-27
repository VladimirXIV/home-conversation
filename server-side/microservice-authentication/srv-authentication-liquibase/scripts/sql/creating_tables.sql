CREATE TABLE srv_auth."account"
(
    "id" bigint not null,
    "user_id" bigint not null,
    "login" character varying(32),
    "password" character varying(32),
    "state" character varying(32),
    "created" timestamp,
    "updated" timestamp,

    CONSTRAINT "pk_accounts" PRIMARY KEY ("id")
)
WITH (
    OidS=FALSE
);

ALTER TABLE srv_auth."account" OWNER TO "srv_auth_role";



CREATE TABLE srv_auth."role"
(
    "id" bigint not null,
    "name" character varying(32),
    "created" timestamp,
    "updated" timestamp,
    "state" character varying(32),

    CONSTRAINT "pk_role" PRIMARY KEY ("id")
)
WITH (
    OidS=FALSE
);

ALTER TABLE srv_auth."role" OWNER TO "srv_auth_role";


CREATE TABLE srv_auth."account_role"
(
    "id" bigint,
    "account_id" bigint not null,
    "role_id" bigint not null,

    CONSTRAINT "pk_account_role" PRIMARY KEY ("id"),
    CONSTRAINT "fk_account" FOREIGN KEY ("account_id") REFERENCES srv_auth."account"("id"),
    CONSTRAINT "fk_role" FOREIGN KEY ("role_id") REFERENCES srv_auth."role"("id")
)
WITH (
    OidS=FALSE
);

ALTER TABLE srv_auth."account_role" OWNER TO "srv_auth_role";

COMMIT;