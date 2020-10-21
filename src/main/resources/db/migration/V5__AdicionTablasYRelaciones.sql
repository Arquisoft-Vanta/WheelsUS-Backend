/*==============================================================*/
/* Table: PASSANGER                                             */
/*==============================================================*/
create table PASSANGER (
   ID_USER              INT4                 not null,
   ID_RIDE              INT4                 not null,
   DATETIME_START       TIMESTAMP                 not null,
   DESTINATION_COORDINATES VARCHAR(50)          not null,
   CALIFICATION_PASSANGER INT4                 null,
   CALIFICATION_RIDE    INT4                 null,
   PRICE                INT4                 not null,
   OPTIONAL_COMMENT     VARCHAR(100)         null,
   constraint PK_PASSANGER primary key (ID_USER, ID_RIDE)
);

/*==============================================================*/
/* Index: PASSANGERS_PK                                         */
/*==============================================================*/
create unique index PASSANGERS_PK on PASSANGER (
ID_USER,
ID_RIDE
);

/*==============================================================*/
/* Table: RIDE                                                  */
/*==============================================================*/
create table RIDE (
   ID_RIDE              INT4                 not null,
   ID_VEHICLE           INT4                 null,
   RIDE_START_DATETIME  TIMESTAMP                 not null,
   RIDE_END_DATETIME    TIMESTAMP                 not null,
   RIDE_START_COORDINATES VARCHAR(50)          not null,
   RIDE_END_COORDINATES VARCHAR(50)          not null,
   RIDE_CAPACITY        INT4                 not null,
   constraint PK_RIDE primary key (ID_RIDE)
);

/*==============================================================*/
/* Index: RIDES_PK                                              */
/*==============================================================*/
create unique index RIDES_PK on RIDE (
ID_RIDE
);

/*==============================================================*/
/* Index: VEHICLE_RIDES_FK                                      */
/*==============================================================*/
create  index VEHICLE_RIDES_FK on RIDE (
ID_VEHICLE
);

/*==============================================================*/
/* Table: SERVICE_WAIT                                          */
/*==============================================================*/
create table SERVICE_WAIT (
   ID_SERVICE_WAIT      INT4                 not null,
   ID_USER              INT4                 null,
   USER_ID              INT4                 not null,
   START_COORDINATES    VARCHAR(50)          null,
   END_COORDINATES      VARCHAR(50)          null,
   START_DATETIME       TIMESTAMP                 null,
   DATETIME             TIMESTAMP                 null,
   constraint PK_SERVICE_WAIT primary key (ID_SERVICE_WAIT)
);

/*==============================================================*/
/* Index: SERVICE_WAIT_PK                                       */
/*==============================================================*/
create unique index SERVICE_WAIT_PK on SERVICE_WAIT (
ID_SERVICE_WAIT
);

/*==============================================================*/
/* Index: IS_WAITING_FOR_SERVICE_FK                             */
/*==============================================================*/
create  index IS_WAITING_FOR_SERVICE_FK on SERVICE_WAIT (
ID_USER
);

alter table PASSANGER
   add constraint FK_PASSANGE_ARE_PASSA_USER foreign key (ID_USER)
      references "user" (ID_USER)
      on delete restrict on update restrict;

alter table PASSANGER
   add constraint FK_PASSANGE_ARE_RIDES_RIDE foreign key (ID_RIDE)
      references RIDE (ID_RIDE)
      on delete restrict on update restrict;

alter table RIDE
   add constraint FK_RIDE_VEHICLE_R_VEHICLE foreign key (ID_VEHICLE)
      references VEHICLE (ID_VEHICLE)
      on delete restrict on update restrict;

alter table SERVICE_WAIT
   add constraint FK_SERVICE__IS_WAITIN_USER foreign key (ID_USER)
      references "user" (ID_USER)
      on delete restrict on update restrict;