create table if not exists srv_converse."conversation"
(
    "id" bigint,

    "title"      character varying(128),
    "creator_id" bigint not null,
    "created_at" timestamptz,
    "updated_at" timestamptz,

    constraint "pk_conversation" primary key ("id")
)
with (
    oids=false
);
alter table srv_converse."conversation" owner to "srv_convers_role";

create table if not exists srv_converse."archived_conversation"
(
    "id" bigint,

    "user_id"         bigint,
    "created_at"      timestamptz,
    "conversation_id" bigint ,

    constraint "pk_archived_conversation" primary key ("id"),
    constraint "fk_conversation" foreign key ("conversation_id") references srv_converse."conversation" ("id")
)
with (
    oids=false
);
alter table srv_converse."archived_conversation" owner to "srv_convers_role";

create table if not exists srv_converse."participant"
(
    "id" bigint,

    "user_id"         bigint,
    "role_id"         bigint,
    "created_at"      timestamptz,
    "updated_at"      timestamptz,
    "conversation_id" bigint,

    constraint "pk_participant" primary key ("id"),
    constraint "fk_conversation" foreign key ("conversation_id") references srv_converse."conversation" ("id")
)
with (
    oids=false
);
alter table srv_converse."participant" owner to "srv_convers_role";

create table if not exists srv_converse."report"
(
    "id" bigint,

    "note"           character varying(128),
    "report_type"    character varying(128),
    "user_id"        bigint,
    "created_at"     timestamptz,
    "updated_at"     timestamptz,
    "participant_id" bigint,

    constraint "pk_report" primary key ("id"),
    constraint "fk_participant" foreign key ("participant_id") references srv_converse."participant" ("id")
)
with (
    oids=false
);
alter table srv_converse."report" owner to "srv_convers_role";

commit;
