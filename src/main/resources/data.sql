INSERT INTO user (user_id,address,birthdate,email,name,password,username) VALUES (1,'Tunis','1998-10-10','ahmed@ahmed.com','ahmed','ahmed','ahmed');
INSERT INTO user (user_id,address,birthdate,email,name,password,username) VALUES (2,'Tunis','1997-05-07','wael@wael.com','wael','wael','wael');
INSERT INTO user (user_id,address,birthdate,email,name,password,username) VALUES (3,'Bezert','1995-05-07','achref@achref.com','achref','achref','achref');
INSERT INTO user (user_id,address,birthdate,email,name,password,username) VALUES (4,'Djerba','1997-06-07','imed@imed.com','imed','imed','imed');
INSERT INTO user (user_id,address,birthdate,email,name,password,username) VALUES (5,'Djerba','1997-8-12','wassim@wassim.com','wassim','wassim','wassim');
INSERT INTO role (role_id,name) VALUES (1,'ADMIN');
INSERT INTO role (role_id,name) VALUES (2,'USER');
INSERT INTO user_roles (user_id,role_id) VALUES (1,1);
INSERT INTO user_roles (user_id,role_id) VALUES (2,1);
INSERT INTO user_roles (user_id,role_id) VALUES (3,2);
INSERT INTO user_roles (user_id,role_id) VALUES (4,2);
INSERT INTO user_roles (user_id,role_id) VALUES (5,2);
INSERT INTO tournoi (tournoi_id,name_tournoi) VALUES (1,'super leage');
INSERT INTO tournoi (tournoi_id,name_tournoi) VALUES (2,'super leage');
INSERT INTO tournoi (tournoi_id,name_tournoi) VALUES (3,'super leage');

INSERT INTO phase (phase_id,name,tournoi_id) VALUES (1,'PHASE_DE_POOL',1);
INSERT INTO phase (phase_id,name,tournoi_id) VALUES (2,'SEIZIEME',1);
INSERT INTO phase (phase_id,name,tournoi_id) VALUES (3,'HUITIEME',1);
INSERT INTO phase (phase_id,name,tournoi_id) VALUES (4,'QUART_DE_FINALE',1);
INSERT INTO phase (phase_id,name,tournoi_id) VALUES (5,'DEMI_FINALE',1);
INSERT INTO phase (phase_id,name,tournoi_id) VALUES (6,'FINALE',1);

INSERT INTO matchs (match_id,name,phase_id,status) VALUES (1,'match name 1 ',1,"SOON");
INSERT INTO matchs (match_id,name,phase_id,status) VALUES (2,'name 2 match ',1,"LIVE");
INSERT INTO matchs (match_id,name,phase_id,status) VALUES (3,'third match 3',2,"LIVE");
INSERT INTO matchs (match_id,name,phase_id,status) VALUES (4,'forth name 4 ',2,"PLAYED");
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (1,'VIP','512',10,1);
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (2,'VIP','551',10,1);
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (3,'normal','854',10,1);
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (4,'normal','321',10,1);
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (5,'normal','741',10,1);
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (6,'VIP','741',10,2);
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (7,'VIP','521',10,2);
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (8,'normal','742',10,2);
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (9,'normal','120',10,2);
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (10,'normal','25',10,2);
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (11,'VIP','12',10,3);
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (12,'VIP','52',10,4);
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (13,'normal','74',10,3);
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (14,'normal','321',10,4);
INSERT INTO billet (billet_id,categorie,num_place,prix,match_id) VALUES (15,'normal','52',10,4);

INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (1,'20','98524152',1);
INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (2,'25','74185296',2);
INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (3,'25','74118555',3);
INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (4,'84','14253652',4);
INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (5,'32','32154252',5);
INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (6,'14','74125412',6);
INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (7,'32','25123224',7);
INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (8,'21','23524105',8);
INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (9,'12','25152212',9);
INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (10,'21','25785242',10);
INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (11,'74','52428253',11);
INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (12,'63','21521521',12);
INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (13,'52','79658668',13);
INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (14,'74','27554522',14);
INSERT INTO spectateur (spectateur_id,age,cin,billet_id) VALUES (15,'22','24772572',15);

INSERT INTO equipe (equipe_id,name) VALUES (1,'Tunis');
INSERT INTO equipe (equipe_id,name) VALUES (2,'USA');

INSERT INTO equipe (equipe_id,name) VALUES (3,'Palestine');
INSERT INTO equipe (equipe_id,name) VALUES (4,'Ghana');

INSERT INTO equipe (equipe_id,name) VALUES (5,'Japan');
INSERT INTO equipe (equipe_id,name) VALUES (6,'Qatar');

INSERT INTO equipe (equipe_id,name) VALUES (7,'Russia');
INSERT INTO equipe (equipe_id,name) VALUES (8,'UK');

INSERT INTO match_equipes (match_id,equipe_id) VALUES (1,1);
INSERT INTO match_equipes (match_id,equipe_id) VALUES (1,2);
INSERT INTO match_equipes (match_id,equipe_id) VALUES (2,3);
INSERT INTO match_equipes (match_id,equipe_id) VALUES (2,4);
INSERT INTO match_equipes (match_id,equipe_id) VALUES (3,5);
INSERT INTO match_equipes (match_id,equipe_id) VALUES (3,6);

INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (1,'Msakni',1);
INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (2,'Khasri',1);
INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (3,'Akaychi',1);
INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (4,'Darraji',1);


INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (5,'Daniel',2);
INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (6,'Michel',2);
INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (7,'Garen',2);
INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (8,'Wahib',2);

INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (9,'amin',3);
INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (10,'fouad',3);
INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (11,'osama',3);
INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (12,'moayed',3);

INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (13,'mamdo',4);
INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (14,'eto',4);

INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (15,'son',5);
INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (16,'ekko',5);

INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (17,'ahmed',6);
INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (18,'mahmoud',6);

INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (19,'mohamadouf',7);
INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (20,'charaf',7);

INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (21,'Deen',7);
INSERT INTO joueur (joueur_id,	name,equipe_id) VALUES (22,'rahim',7);

INSERT INTO arbitre (arbitre_id,	name,match_id) VALUES (1,'achref',1);
INSERT INTO arbitre (arbitre_id,	name,match_id) VALUES (2,'walid',2);
INSERT INTO arbitre (arbitre_id,	name,match_id) VALUES (3,'karim',3);
INSERT INTO arbitre (arbitre_id,	name,match_id) VALUES (4,'farid',4);
