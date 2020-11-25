/*==============================================================*/
/* Index: OWNED_BY_FK                                           */
/*==============================================================*/
create  index OWNED_BY_FK on vehicle (
vehicle_owner
);


alter table VEHICLE
   add constraint FK_VEHICLE_OWNED_BY_USERS foreign key (vehicle_owner)
      references "user" (ID_USER)
      on delete restrict on update restrict;
