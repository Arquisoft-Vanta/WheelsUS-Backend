/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     1/10/2020 2:42:29 a. m.                      */
/*==============================================================*/

/*==============================================================*/
/* Table: VEHICLE                                               */
/*==============================================================*/
create table VEHICLE (
   ID_VEHICLE           SERIAL		     not null,
   ID_USER              INT4                 null,
   ID_VEHICLE_TYPE      INT4                 null,
   VEHICLE_OWNER        INT4                 not null,
   VEHICLE_LICENSEPLATE VARCHAR(10)          not null,
   VEHICLE_TYPE         INT4                 not null,
   VEHICLE_MODEL        VARCHAR(50)          not null,
   VEHICLE_YEAR         INT4                 not null,
   VEHICLE_COLOR        VARCHAR(50)          not null,
   VEHICLE_REGISTRY_DATETIME TIMESTAMP                 not null,
   VEHICLE_PICTURE      VARCHAR(50)          not null,
   VEHICLE_CAPACITY     INT4                 not null,
   constraint PK_VEHICLE primary key (ID_VEHICLE)
);

/*==============================================================*/
/* Index: VEHICLE_PK                                            */
/*==============================================================*/
create unique index VEHICLE_PK on VEHICLE (
ID_VEHICLE
);
