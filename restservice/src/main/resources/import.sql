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

### SET VALUE USERS ###
INSERT INTO profile_account (pseudo, mail, encrypted_Pass) VALUES ('root', 'root@root.fr', SHA2('root', 512));
