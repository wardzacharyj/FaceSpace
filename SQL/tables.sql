drop table UserTable cascade constraints;
-- UserTable(email, firstName, lastName, birthday, lastLoginTime)
create table UserTable (
	-- userID number(10) not null,
	email varchar2(128) not null,
	firstName varchar2(64) not null,
	lastName varchar2(64) not null,
	birthday date,
	lastLoginTime timestamp,
	constraints pk_users primary key(email)
);


drop table Friendship cascade constraints;
-- Friendship(person1, person2, timeInitiated, timeEstablished)
create table Friendship (
	person1 varchar2(128) not null,
	person2 varchar2(128) not null,
	timeInitiated timestamp not null,
	timeEstablished timestamp,
	constraints pk_friendship primary key(person1, person2),
	constraints fk_person1 foreign key(person1) references UserTable(email)
		 ON DELETE CASCADE,
	constraints fk_person2 foreign key(person2) references UserTable(email)
		 ON DELETE CASCADE
);



drop table GroupTable cascade constraints;
-- GroupTable(groupID, name, description, mLimit)
create table GroupTable (
	groupID number(10) not null,
	name varchar2(64) not null,
	description varchar2(1024),
	mLimit number not null,
	constraints pk_groups primary key(groupID)
);

DROP SEQUENCE group_seq;
Create sequence group_seq start with 1
increment by 1
minvalue 1
maxvalue 10000;

CREATE OR REPLACE TRIGGER make_group_id
BEFORE INSERT ON GroupTable
FOR EACH ROW
BEGIN
  SELECT group_seq.NEXTVAL
  INTO   :new.groupID
  FROM   dual;
END;
/




drop table Membership cascade constraints;
-- Membership(groupID, member)
create table Membership (
	groupID number(10) not null,
	member varchar2(128) not null,
	constraints pk_membership primary key(groupID, member),
	constraints fk_m_group foreign key(groupID) references GroupTable(groupID),
	constraints fk_m_user foreign key(member) references UserTable(email)
	 ON DELETE CASCADE  -- remove the user info. from group table when the user is deleted
);



drop table Message cascade constraints;
-- Message(msgID, senderEmail, recipientEmail, time_sent, msg_subject, msg_body)
create table Message (
	msgID number(10) not null,
	senderEmail varchar2(128) not null,
	recipientEmail varchar2(128) not null,
	time_sent timestamp,
	msg_subject varchar2(1024),
	msg_body varchar2(1024),
	constraints pk_message primary key(msgID) );



-- ALTER TABLE Message
-- DROP CONSTRAINT FK_SENDER;
-- ALTER TABLE Message
-- DROP  CONSTRAINT FK_RECIPIENT;



-- auto generate msgID
DROP SEQUENCE msg_seq;
Create sequence msg_seq start with 1
increment by 1
minvalue 1
maxvalue 10000;
CREATE OR REPLACE TRIGGER make_msg_id
BEFORE INSERT ON Message
FOR EACH ROW
BEGIN
  SELECT msg_seq.NEXTVAL
  INTO   :new.msgID
  FROM   dual;
END;
/


--A message is deleted only when both the sender and all receivers are deleted
CREATE OR REPLACE TRIGGER del_msg_when_drop_user
AFTER DELETE ON UserTable
BEGIN
	DELETE FROM Message
		WHERE 	senderEmail NOT IN (SELECT email FROM UserTable)
			AND  recipientEmail NOT IN (SELECT email FROM UserTable);
END;
/



