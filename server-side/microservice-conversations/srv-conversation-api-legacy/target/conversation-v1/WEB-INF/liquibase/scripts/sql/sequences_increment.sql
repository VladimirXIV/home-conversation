select setval('srv_converse.conversation_seq', (select max(id) from srv_converse."conversation"));
select setval('srv_converse.archived_conversation_id_seq', (select max(id) from srv_converse."archived_conversation"));
select setval('srv_converse.participant_id_seq', (select max(id) from srv_converse."participant"));
select setval('srv_converse.report_id_seq', (select max(id) from srv_converse."report"));
