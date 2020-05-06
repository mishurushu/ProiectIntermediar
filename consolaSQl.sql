create schema bug_tracking;

create table Project
(
    projectId int(5) unsigned auto_increment primary key ,
    nameProject varchar(30) not null ,
    identifierProject varchar(10) not null ,
    description varchar(200) not null
);

create table  Status
(
    statusId int(5) unsigned auto_increment primary key ,
    statusName varchar(30) not null
);

create table Type
(
    typeId int(5) unsigned auto_increment primary key ,
    typeName varchar(30) not null
);

create table User
(
    userId int (5) unsigned auto_increment primary key ,
    userName varchar(50) not null
);

create table Issue
(
    issueId     int(5) unsigned auto_increment primary key,
    title       varchar(50)  not null,
    description varchar(200) not null,
    projectId   int(5) unsigned,
    foreign key (projectId) references bug_tracking.project (projectId),
    dateCreated varchar(50) not null ,
    statusId int(5) unsigned,
    foreign key (statusId) references bug_tracking.status(statusId),
    submitterId int(5) unsigned,
    foreign key (submitterId) references bug_tracking.user(userId),
    typeId int(5) unsigned,
    foreign key (typeId) references bug_tracking.type(typeId)
);

create table Comment
(
    commentId int(5) unsigned auto_increment primary key ,
    commentText varchar(10000) not null,
    dateTimeCreated varchar(50) not null ,
    submitterId int (5) unsigned,
    foreign key (submitterId) references bug_tracking.user(userId),
    issueId int (5) unsigned,
    foreign key (issueID) references bug_tracking.issue(issueId)
);

insert into bug_tracking.type(typeName) value ('FixBug');
insert into bug_tracking.type(typeName) value ('Feature');
insert into bug_tracking.type(typeName) value ('Change Request');

insert into bug_tracking.status(statusName) value ('Open');
insert into bug_tracking.status(statusName) value ('In Progress');
insert into bug_tracking.status(statusName) value ('Done');