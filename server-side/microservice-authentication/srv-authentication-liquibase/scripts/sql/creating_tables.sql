CREATE TABLE srv_auth."account"
(
    "id" bigint not null,
    "user_id" bigint not null,
    "login" character varying(32),
    "password" character varying(32),
    "state" character varying(32),

    CONSTRAINT "pk_accounts" PRIMARY KEY ("id")
)
WITH (
    OidS=FALSE
);

ALTER TABLE srv_auth."account" OWNER TO "srv_auth_role";
COMMIT;