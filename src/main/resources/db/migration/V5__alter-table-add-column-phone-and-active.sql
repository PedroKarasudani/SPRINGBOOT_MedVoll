alter table patients add phone varchar(20) not null;
alter table patients add active tinyint;
update patients set active = 1;