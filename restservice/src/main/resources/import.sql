### OLD DATABASE ###
INSERT INTO sample (my_string) VALUES ('test1');
INSERT INTO sample (my_string) VALUES ('test2');
INSERT INTO sample (my_string) VALUES ('test3');
INSERT INTO sample (my_string) VALUES ('test4');
INSERT INTO sample (my_string) VALUES ('test5');

INSERT INTO workplace (wording) VALUES ('Chef');
INSERT INTO workplace (wording) VALUES ('Ouvrier');
INSERT INTO workplace (wording) VALUES ('Chauffeur');

INSERT INTO work_entity (wording) VALUES ('Metro 1');
INSERT INTO work_entity (wording) VALUES ('Bus 2');
INSERT INTO work_entity (wording) VALUES ('Tramway 3');

INSERT INTO user (date_of_birth, first_name, last_name, mail, password, pseudo, work_entity_id, workplace_id) VALUES ('27/02/2012', 'Thibault', 'BOURGEOIS', 'titi@titi.fr', SHA2('mypass', 512), 'ncna', 1, 2);
INSERT INTO user (date_of_birth, first_name, last_name, mail, password, pseudo, work_entity_id, workplace_id) VALUES ('06/07/1993', 'Ruben', 'EDERY', 'rub@rub.fr', SHA2('mypass', 512), 'tete', 2, 3);
INSERT INTO user (date_of_birth, first_name, last_name, mail, password, pseudo, work_entity_id, workplace_id) VALUES ('27/02/2012', 'Marie-Laure', 'KOEGEL', 'titi@titi.fr', SHA2('root', 512), 'root', 1, 2);
### END OLD DATABASE ###


### SET VALUE PARAMS ###
INSERT INTO profile_type (wording) VALUES ('Administrateur');
INSERT INTO profile_type (wording) VALUES ('Utilisateur');
INSERT INTO profile_type (wording) VALUES ('Visiteur');
INSERT INTO profile_type (wording) VALUES ('RH');
INSERT INTO profile_type (wording) VALUES ('Manager');

INSERT INTO work_type (wording) VALUES ('Ingénieur');
INSERT INTO work_type (wording) VALUES ('Secretaire');
INSERT INTO work_type (wording) VALUES ('Chargé d''affaire');

### SET VALUE USERS ###
INSERT INTO profile_account (id, pseudo, mail, encrypted_Pass, profile_type_wording) VALUES (1, 'root', 'root@root.fr', SHA2('root', 512), 'Administrateur');
INSERT INTO profile_account (id, pseudo, mail, encrypted_Pass, profile_type_wording) VALUES (2, 'rh', 'root@root.fr', SHA2('root', 512), 'Rh');
INSERT INTO profile_account (id, pseudo, mail, encrypted_Pass, profile_type_wording) VALUES (3, 'manager', 'root@root.fr', SHA2('root', 512), 'Manager');
INSERT INTO profile_account (id, pseudo, mail, encrypted_Pass, profile_type_wording) VALUES (4, 'tibo', 'root@root.fr', SHA2('root', 512), 'Utilisateur');
INSERT INTO profile_account (id, pseudo, mail, encrypted_Pass, profile_type_wording) VALUES (5, 'ruben', 'root@root.fr', SHA2('root', 512), 'Utilisateur');

INSERT INTO profile_info (id, birthday, description, dream_jobs, first_name, last_name, registration, profile_account_id) VALUES (1, '1993-07-06', 'La description', 'AUCUN', 'Admin', 'ISTRATEUR', '2018-05-17 00:27:00', '1');
INSERT INTO profile_info (id, birthday, description, dream_jobs, first_name, last_name, registration, profile_account_id) VALUES (2, '1993-07-06', 'La description', 'To define', 'Humaine', 'RESSOURCE', '2018-05-17 00:27:00', '2');
INSERT INTO profile_info (id, birthday, description, dream_jobs, first_name, last_name, registration, profile_account_id) VALUES (2, '1993-07-06', 'La description', 'To define', 'Manage', 'MANAGER', '2018-05-17 00:27:00', '3');
INSERT INTO profile_info (id, birthday, description, dream_jobs, first_name, last_name, registration, profile_account_id) VALUES (2, '1993-07-06', 'La description', 'To define', 'Thibault', 'BOURGEOIS', '2018-05-17 00:27:00', '4');
INSERT INTO profile_info (id, birthday, description, dream_jobs, first_name, last_name, registration, profile_account_id) VALUES (2, '1993-07-06', 'La description', 'To define', 'Ruben', 'EDERY', '2018-05-17 00:27:00', '5');

INSERT INTO profile_work_info (hiring_date, work_libelle, profile_info_id, work_entity_wording, work_type_wording, working_location_wording) VALUES ('2018-05-08', 'Chauffeur de bus', '4', 'TRAM1', 'Chauffeur', 'Paris');
INSERT INTO profile_work_info (hiring_date, work_libelle, profile_info_id, work_entity_wording, work_type_wording, working_location_wording) VALUES ('2018-05-08', 'Chauffeur de bus', '5', 'TRAM2', 'Chauffeur', 'Paris');

INSERT INTO chat_room (id, room_name) VALUES (1, 'firstRoom');

INSERT INTO chat_room_profile_info_list (chat_room_id, profile_info_list_id) VALUES (1, 1);
INSERT INTO chat_room_profile_info_list (chat_room_id, profile_info_list_id) VALUES (1, 2);

INSERT INTO chat_message (id, date_send, message, sender_id) VALUES (1, '2018-05-17 00:27:00', 'Salut', 1);
INSERT INTO chat_message (id, date_send, message, sender_id) VALUES (2, '2018-05-17 00:30:00', 'Coucou', 2);

INSERT INTO chat_room_chat_message_list (chat_room_id, chat_message_list_id) VALUES (1, 1);
INSERT INTO chat_room_chat_message_list (chat_room_id, chat_message_list_id) VALUES (1, 2);