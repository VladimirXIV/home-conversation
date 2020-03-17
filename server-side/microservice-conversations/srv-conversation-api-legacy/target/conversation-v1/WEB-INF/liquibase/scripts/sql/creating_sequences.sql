create sequence if not exists srv_converse."conversation_seq"
increment 1
minvalue 1
maxvalue 9223372036854775807
start 1
cache 1;
alter sequence srv_converse."conversation_seq" owner to "srv_convers_role";
commit;

create sequence if not exists srv_converse."participant_seq"
increment 1
minvalue 1
maxvalue 9223372036854775807
start 1
cache 1;
alter sequence srv_converse."participant_seq" owner to "srv_convers_role";
commit;

create sequence if not exists srv_converse."archived_conversation_seq"
increment 1
minvalue 1
maxvalue 9223372036854775807
start 1
cache 1;
alter sequence srv_converse."archived_conversation" owner to "srv_convers_role";
commit;

create sequence if not exists srv_converse."report_seq"
increment 1
minvalue 1
maxvalue 9223372036854775807
start 1
cache 1;
alter sequence srv_converse."report" owner to "srv_convers_role";
commit;
