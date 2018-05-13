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
INSERT INTO profile_account (pseudo, mail, encrypted_Pass, profile_type_wording) VALUES ('root', 'root@root.fr', SHA2('root', 512), 'Administrateur');

INSERT INTO profile_info (birthday, description, dream_jobs, first_name, last_name, registration, profile_account_id) VALUES ('1993-07-06', 'rtgtr', 'rekvrev', 'Thibault', 'BOURGEOIS', '2018-05-17 00:27:00', '1');

INSERT INTO profile_work_info (hiring_date, work_libelle, profile_info_id, work_entity_wording, work_type_wording, working_location_wording) VALUES ('2018-05-08', 'Chauffeur de bus', '1', 'toto', 'toto', 'paris');