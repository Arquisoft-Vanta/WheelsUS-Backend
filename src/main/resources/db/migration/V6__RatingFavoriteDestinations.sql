/*==============================================================*/
/* Table: FAVORITE_DESTINATION                                  */
/*==============================================================*/
create table FAVORITE_DESTINATION (
   ID_FAV_DEST          INT4                 not null,
   ID_USER_FAV          INT4                 not null,
   FAV_LATITUDE         VARCHAR(50)          not null,
   FAV_LONGITUDE        VARCHAR(50)          not null,
   FAV_ADDRESS          VARCHAR(50)          not null,
   DATETIME_CREATION_FAV TIMESTAMP                 not null,
   NAME_FD              VARCHAR(50)          not null,
   constraint PK_FAVORITE_DESTINATION primary key (ID_FAV_DEST)
);

/*==============================================================*/
/* Index: FAVORITE_DESTINATIONS_PK                              */
/*==============================================================*/
create unique index FAVORITE_DESTINATIONS_PK on FAVORITE_DESTINATION (
ID_FAV_DEST
);

/*==============================================================*/
/* Index: ARE_FAVORITE_FK                                       */
/*==============================================================*/
create  index ARE_FAVORITE_FK on FAVORITE_DESTINATION (
ID_USER_FAV
);

/*==============================================================*/
/* Table: RATING                                                */
/*==============================================================*/
create table RATING (
   ID_RATING            SERIAL                 not null,
   GRADER               INT4                 null,
   GRADED               INT4                 not null,
   GRADE                INT2                 null,
   RIDE_ID              VARCHAR(50)          not null,
   constraint PK_RATING primary key (ID_RATING)
);

/*==============================================================*/
/* Index: RATING_PK                                             */
/*==============================================================*/
create unique index RATING_PK on RATING (
ID_RATING
);

alter table FAVORITE_DESTINATION
   add constraint FK_FAVORITE_ARE_FAVOR_USER foreign key (ID_USER_FAV)
      references "user" (ID_USER)
      on delete restrict on update restrict;

alter table RATING
   add constraint FK_RATING_HAS_GRADE_USER foreign key (GRADER)
      references "user" (ID_USER)
      on delete restrict on update restrict;
    
alter table RATING
   add constraint FK_RATING_HAS_GRADED_USER foreign key (GRADED)
      references "user" (ID_USER)
      on delete restrict on update restrict;