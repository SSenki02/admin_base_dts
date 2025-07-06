Create Database Equipo_pedidos;
use Equipo_pedidos;
/*DDL Lenguaje de descripcion de datos*/
/*Create table*/
Create Table SDJ_Venta(
clave_venta Int not null Primary Key,
fecha_venta varchar(10),
hora_venta varchar (12),
);

create table SDJ_menu(
clave_menu int not null primary key,
nombre_menu varchar (20),
precio_menu float (2),
);

create table SDJ_producto (
clave_producto int not null primary key,
descripcion varchar (25),
precio_producto float (2),
);

create table SDJ_repartidor(
id_repartidor int not null primary key,
nombre_repartidor varchar (30),
matricula varchar (8),
turno varchar (10),
);

create table SDJ_pedido_ventanilla(
clave_ped_ven int not null primary key,
fecha_ped_ven varchar (10),
hora_ped_ven varchar (12),
no_ventanilla int not null,
Clave_venta1 int foreign key references SDJ_Venta (clave_venta)
);

create table SDJ_pedido_domicilio(
clave_ped_dom int not null primary key,
fecha_ped_dom varchar (10),
hora_ped_dom varchar (12),
id_repartidorFK int foreign key references SDJ_repartidor (id_repartidor),
claave_venta2 int foreign key references SDJ_Venta (clave_venta)
);

create table SDJ_menu_ped_dom(
clave_menu1 int foreign key references SDJ_menu (clave_menu),
clave_ped_dom1 int foreign key references SDJ_pedido_domicilio (clave_ped_dom),
cantidad_ped_dom int
);

create table SDJ_ped_ven_producto(
clave_ped_ven1 int foreign key references SDJ_pedido_ventanilla (clave_ped_ven),
clave_producto1 int foreign key references SDJ_producto (clave_producto),
cantidad_ped_vent_prod int,
);

create table SDJ_menu_producto(
clave_menu2 int foreign key references SDJ_menu (clave_menu),
clave_producto2 int foreign key references SDJ_producto (clave_producto),
cantidad_meni_producto int
);

create table SDJ_ped_dom_prod(
clave_ped_dom2 int foreign key references SDJ_pedido_domicilio (clave_ped_dom),
clave_producto3 int foreign key references SDJ_producto (clave_producto),
cantidad_ped_dom_producto int
);

create table SDJ_menu_ped_ven(
clave_menu3 int foreign key references SDJ_menu (clave_menu),
clave_ped_ven2 int foreign key references SDJ_pedido_ventanilla (clave_ped_ven),
cantidad_ped_ven_producto int
);

/*Instruccion del Alter table para agregar un campo a una tabla que ya existe*/
alter table SDJ_menu
add cant_prod int;

alter table SDJ_menu_ped_dom
add hora_entrega_ped_dom varchar(5);

alter table SDJ_menu_ped_ven
add hora_entrega_ped_ven varchar(5);

alter table SDJ_producto
add tamaño varchar(10);

alter table SDJ_repartidor
add telefono varchar(8);

alter table SDJ_Venta
add forma_pago varchar(10);

/*create index*/
CREATE INDEX CI_SDJ_TURNO_REPARTIDOR
ON SDJ_REPARTIDOR (TURNO,NOMBRE_REPARTIDOR)

/*SELECT para realizar consultas*/
SELECT * FROM SDJ_Venta;
SELECT * FROM SDJ_menu;
SELECT * FROM SDJ_menu_ped_dom;
SELECT * FROM SDJ_menu_ped_ven;
SELECT * FROM SDJ_menu_producto;
SELECT * FROM SDJ_ped_dom_prod;
SELECT * FROM SDJ_ped_ven_producto;
SELECT * FROM SDJ_pedido_domicilio;
SELECT * FROM SDJ_pedido_ventanilla;
SELECT * FROM SDJ_producto;
SELECT * FROM SDJ_repartidor;



/*DML instrucciones de lenguaje de manipulacionde datos*/

/*Agregar datos*/
insert into SDJ_Venta(clave_venta, fecha_venta, hora_venta)
values (1,'2025-02-25', '12:30 pm')
insert into SDJ_Venta(clave_venta, fecha_venta, hora_venta)
values (2,'2025-02-26', '12:30 pm')
insert into SDJ_Venta(clave_venta, fecha_venta, hora_venta)
values (3,'2025-02-27', '12:30 pm')

insert into SDJ_menu(clave_menu,nombre_menu,precio_menu)
values (1,'lasaña',50)
insert into SDJ_menu(clave_menu,nombre_menu,precio_menu)
values (2,'pozole',100)
insert into SDJ_menu(clave_menu,nombre_menu,precio_menu)
values (3,'cafe',20)

insert into SDJ_producto
values (1,'botella de agua de 1L',20)
insert into SDJ_producto
values (2,'jugo embotellado',25)
insert into SDJ_producto
values (3,'botella cerveza',45)

insert into SDJ_repartidor
values (2,'Jose Marquez','1122aa3b','matutino', '554466')
insert into SDJ_repartidor
values (3,'Pedro Ramirez','4455cc6d','matutino','44445')
insert into SDJ_repartidor
values (4,'Francisco JImenez','8899ff6j','vesp','4646464')

insert into SDJ_pedido_ventanilla (clave_ped_ven,fecha_ped_ven, hora_ped_ven, no_ventanilla, Clave_venta1)
values (1,'2025-02-25', '12:30', 1,1)
insert into SDJ_pedido_ventanilla (clave_ped_ven,fecha_ped_ven, hora_ped_ven, no_ventanilla, Clave_venta1)
values (2,'2025-02-26', '12:30', 1,2)
insert into SDJ_pedido_ventanilla (clave_ped_ven,fecha_ped_ven, hora_ped_ven, no_ventanilla, Clave_venta1)
values (3,'2025-02-27', '12:30', 2,3)

insert into SDJ_pedido_domicilio
values (1,'2025-02-28','12:45',2,1)
insert into SDJ_pedido_domicilio
values (2,'2025-02-28','15:08',1,2)
insert into SDJ_pedido_domicilio
values (3,'2025-02-28','20:00',3,3)

insert SDJ_menu_ped_dom
values (1,1,1)
insert SDJ_menu_ped_dom
values (2,2,2)
insert SDJ_menu_ped_dom
values (3,3,3)

insert SDJ_ped_ven_producto
values (1,1,1)
insert SDJ_ped_ven_producto
values (2,2,2)
insert SDJ_ped_ven_producto
values (3,3,3)

insert SDJ_menu_producto
values (1,1,1)
insert SDJ_menu_producto
values (2,2,2)
insert SDJ_menu_producto
values (3,3,3)

insert SDJ_ped_dom_prod
values (1,1,1)
insert SDJ_ped_dom_prod
values (2,2,2)
insert SDJ_ped_dom_prod
values (3,3,3)

insert SDJ_menu_ped_ven
values (1,1,1)
insert SDJ_menu_ped_ven
values (2,2,2)
insert SDJ_menu_ped_ven
values (3,3,3)

update SDJ_menu
set cant_prod=1
where clave_menu=1;
update SDJ_menu
set cant_prod=5
where clave_menu=2;
update SDJ_menu
set cant_prod=3
where clave_menu=3;

update SDJ_producto
set tamaño= 'largo'
where clave_producto = 1;
update SDJ_producto
set tamaño= 'pequeño'
where clave_producto =2;
update SDJ_producto
set tamaño= 'largo'
where clave_producto =3;


update SDJ_menu_ped_dom
set hora_entrega_ped_dom = '14:30'
where clave_ped_dom1='1';
update SDJ_menu_ped_dom
set hora_entrega_ped_dom = '14:50'
where clave_ped_dom1='2';
update SDJ_menu_ped_dom
set hora_entrega_ped_dom = '15:00'
where clave_ped_dom1='3';

update SDJ_repartidor
set telefono='56778899'
where id_repartidor=1;
update SDJ_repartidor
set telefono='56778899'
where id_repartidor=2;
update SDJ_repartidor
set telefono='66778899'
where id_repartidor=3;

update SDJ_Venta
set forma_pago='efectivo'
where clave_venta=1;
update SDJ_Venta
set forma_pago='efectivo'
where clave_venta=2;
update SDJ_Venta
set forma_pago='tarjeta'
where clave_venta=3;

update SDJ_menu_ped_ven
set hora_entrega_ped_ven= '15:00'
where clave_ped_ven2 =1;
update SDJ_menu_ped_ven
set hora_entrega_ped_ven= '15:30'
where clave_ped_ven2 =2;
update SDJ_menu_ped_ven
set hora_entrega_ped_ven= '16:00'
where clave_ped_ven2 =3;

delete from SDJ_menu
where clave_menu=2;

--Precio maximo producto
create view SDJ_vista_precio_maximo as(
SELECT descripcion,precio_producto
FROM  SDJ_producto
WHERE precio_producto = (select MAX(precio_producto) from SDJ_producto));

--precio minimo
Create view SDJ_VISTA_PRECIO_minimo as(
SELECT descripcion,precio_producto
FROM  SDJ_producto
WHERE precio_producto = (select min(precio_producto) from SDJ_producto));
--precio minimo y maximo
create view SDJ_vista_precio_minimo_y_maximo as(
SELECT descripcion,precio_producto
FROM  SDJ_producto
WHERE precio_producto = (select min(precio_producto) from SDJ_producto) or precio_producto = (select max(precio_producto) from SDJ_producto));
--Suma total de los precios de los productos
create view SDJ_vista_suma_total as(
select descripcion, precio_producto,(select sum (precio_producto) from SDJ_producto) as suma_total
from SDJ_producto);
--vista menu
create view SDJ_vista_promedio_menu as(
select nombre_menu,descripcion,precio_producto, (select avg(precio_producto) from SDJ_menu) AS promedio
from SDJ_menu,SDJ_producto, SDJ_menu_producto
where clave_menu2=clave_menu and clave_producto2 =clave_producto);
--vista
create view SDJ_Vista_pedido_repartidor_prod as(
select fecha_ped_dom, nombre_repartidor, descripcion, cantidad_ped_dom_producto
from SDJ_pedido_domicilio, SDJ_repartidor, SDJ_producto, SDJ_ped_dom_prod
where id_repartidor=id_repartidorFK and clave_producto=clave_ped_dom2 and clave_producto=clave_producto3);

select * FROM SDJ_Vista_pedido_repartidor_prod
select * from SDJ_vista_precio_minimo_y_maximo
select * from SDJ_vista_suma_total
select * from SDJ_VISTA_PRECIO_minimo
select * from SDJ_vista_precio_maximo

/*DCL- LENGUAJE DE CONTROL DE DATOS*/

/*CREACION DE USUARIO*/

CREATE LOGIN USUARIO_FINAL_FRANCISCOBALTAZAR WITH PASSWORD='1234'; /*CREAR USUARIO Y CONTRASEÑA*/
CREATE USER USUARIO_FINAL_FRANCISCOBALTAZAR FOR LOGIN USUARIO_FINAL_FRANCISCOBALTAZAR;
CREATE LOGIN USUARIO_FINAL_MOISES_H WITH PASSWORD='9876';
CREATE USER USUARIO_FINAL_MOISES_H FOR LOGIN USUARIO_FINAL_MOISES_H;
CREATE LOGIN USUARIO_FINAL_SHANATLDOMINGUEZ WITH PASSWORD='9876';
CREATE USER USUARIO_FINAL_SHANATLDOMINGUEZ FOR LOGIN USUARIO_FINAL_SHANATLDOMINGUEZ;

USE Equipo_pedidos;
GRANT INSERT, SELECT,UPDATE
ON SDJ_Venta
TO USUARIO_FINAL_FRANCISCOBALTAZAR
WITH GRANT OPTION;

REVOKE INSERT, SELECT,UPDATE
ON SDJ_Venta
TO USUARIO_FINAL_FRANCISCOBALTAZAR
CASCADE; /*CASCADE QUITA LOS PRIVILEGIOS A TODOS LOS USUARIOS QUE EL PRIMER USUARIO OTORGO AL TENER GRANT OPTION*/


/*Procedures*/

CREATE PROCEDURE CP_SDJ_INSERT_VENTA
@clave_venta Int,
@fecha_venta varchar(10),
@hora_venta varchar (12),
@forma_pago varchar (10)
AS
INSERT INTO SDJ_Venta
VALUES (@clave_venta,@fecha_venta,@hora_venta,@forma_pago);

SELECT * FROM SDJ_Venta
EXECUTE CP_SDJ_INSERT_VENTA 5,'2025-04-08','22:30','tarjeta';


CREATE PROCEDURE CP_SDJ_SELECT_VENTA
@fecha_venta varchar(10)
AS
SELECT fecha_venta,hora_venta, forma_pago
FROM SDJ_Venta
WHERE fecha_venta=@fecha_venta

SELECT * FROM SDJ_Venta
EXECUTE CP_SDJ_SELECT_VENTA '2025-04-08';


CREATE PROCEDURE CP_SDJ_DELETE_VENTA
@clave_venta Int
AS
DELETE FROM SDJ_Venta
WHERE clave_venta=@clave_venta

SELECT * FROM SDJ_Venta
EXECUTE CP_SDJ_DELETE_VENTA

CREATE PROCEDURE CP_SDJ_UPDATE_FORMA_PAGO
@clave_venta Int,
@forma_pago varchar (10)
AS 
UPDATE SDJ_Venta
SET forma_pago=@forma_pago
WHERE clave_venta=@clave_venta

SELECT * FROM SDJ_Venta
EXECUTE CP_SDJ_UPDATE_FORMA_PAGO 2, 'tarjeta';


------Crear usuario------


CREATE LOGIN USUARIO_PRODUCTO WITH PASSWORD = '12345';
CREATE USER USUARIO_PRODUCTO FOR LOGIN USUARIO_PRODUCTO;

/*-----Crear privilegios-----*/

USE Equipo_pedidos
GRANT INSERT, DELETE, UPDATE, SELECT
ON SDJ_producto
TO USUARIO_PRODUCTO
WITH GRANT OPTION;


/*------------06052025---------*/
CREATE TABLE SDJ_HISTORIAL(
DNI_REPARTIDOR INT,
FECHA_REGISTRO VARCHAR(15),
USUARIO VARCHAR(10),
VALOR_ANTERIOR_TURNO VARCHAR(15)
);
SELECT* FROM SDJ_HISTORIAL
SELECT * FROM SDJ_repartidor

--Procedure Insert procedure

CREATE PROCEDURE CP_DJS_INSERTAR_REPARTIDOR
@ID INT,
@NOMBRE VARCHAR (30),
@MATRICULA VARCHAR (8),
@TURNO VARCHAR (10),
@TELEFONO VARCHAR (10)
AS
INSERT INTO SDJ_repartidor(id_repartidor,nombre_repartidor,matricula, turno, telefono)
VALUES (@ID, @NOMBRE, @MATRICULA, @TURNO,@TELEFONO);


EXEC CP_DJS_INSERTAR_REPARTIDOR 5, 'juan perez', '1144455', 'matutino','00112233';

CREATE TRIGGER CT_SDJ_REPARTIDOR_INSERTADO
ON SDJ_repartidor
FOR INSERT
AS
SELECT * FROM inserted;

CREATE PROCEDURE CP_SDJ_UPDATE_REPARTIDOR
@TURNO VARCHAR (10),
@ID_REPARTIDOR INT
AS
UPDATE SDJ_repartidor
SET turno=@TURNO
WHERE id_repartidor= @ID_REPARTIDOR;

EXEC CP_SDJ_UPDATE_REPARTIDOR 'VESPERTINO', 2;

CREATE TRIGGER CT_SDJ_REPARTIDOR_ACTUALIZADO
ON SDJ_repartidor
FOR UPDATE
AS
INSERT INTO  SDJ_HISTORIAL (DNI_REPARTIDOR,FECHA_REGISTRO,USUARIO,VALOR_ANTERIOR_TURNO)
SELECT inserted.id_repartidor, SYSDATETIME(), USER_NAME(),deleted.turno from inserted, deleted
SELECT* FROM inserted
SELECT* FROM deleted
SELECT* FROM SDJ_HISTORIAL;

SELECT * FROM SDJ_pedido_domicilio


CREATE PROCEDURE CP_SDJ_ELIMINAR_REPARTIDOR 
@ID_REPARTIDOR INT
AS
DELETE FROM SDJ_repartidor
WHERE id_repartidor= @ID_REPARTIDOR;

EXEC CP_SDJ_ELIMINAR_REPARTIDOR 1;

CREATE TRIGGER CT_SDJ_REPARTIDOR_ELIMINADO
ON SDJ_repartidor
INSTEAD OF DELETE
AS 
UPDATE SDJ_pedido_domicilio
SET id_repartidorFK = NULL
FROM deleted
WHERE id_repartidorFK = id_repartidor

DELETE
FROM SDJ_repartidor
FROM deleted
WHERE SDJ_repartidor.id_repartidor=deleted.id_repartidor

SELECT* FROM SDJ_repartidor
SELECT * FROM SDJ_pedido_domicilio
SELECT* FROM deleted;




