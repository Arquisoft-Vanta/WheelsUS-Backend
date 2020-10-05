/*==============================================================*/
/* Index: OWNED_BY_FK                                           */
/*==============================================================*/
create  index OWNED_BY_FK on vehicle (
ID_USER
);


alter table VEHICLE
   add constraint FK_VEHICLE_OWNED_BY_USERS foreign key (ID_USER)
      references "user" (ID_USER)
      on delete restrict on update restrict;
