/*==============================================================*/
create table NOTIFICATION (
   ID_NOTIFICATION      SERIAL               not null,
   ID_USER              INT4                 null,
   DATA                 VARCHAR(50)          not null,
   DESTINATION          VARCHAR(50)          not null,
   constraint PK_NOTIFICATION primary key (ID_NOTIFICATION)
);

/*==============================================================*/
/* Index: NOTIFICATION_PK                                       */
/*==============================================================*/
create unique index NOTIFICATION_PK on NOTIFICATION (
ID_NOTIFICATION
);

/*==============================================================*/
/* Index: RELATIONSHIP_6_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_6_FK on NOTIFICATION (
ID_USER
);

alter table NOTIFICATION
   add constraint FK_NOTIFICA_RELATIONS_USER foreign key (ID_USER)
      references "user" (ID_USER)
      on delete restrict on update restrict;

alter table "user"
 add constraint NOMAILDUP
 unique (USER_MAIL)