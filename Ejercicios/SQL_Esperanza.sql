Create database RBV_Esperanza
use RBV_Esperanza
                    /*INSTRUCCIONES DEL DDL*/
                         /*CREATE TABLE*/

create table RBV_Sucursal
(
Id_sucursal int Primary Key identity (1,1),
Direccion_Sucursal varchar(35),
Telefono_Sucursal varchar(10),
Horario_apertura varchar(10),
no_de_empleados int
);

create table RBV_Empleado(
Id_empleado int Primary key identity (2,2),
Nombre_empleado varchar(15),
Telefono_empleado varchar (10),
puesto_empleado varchar (10),
Edad_Empleado int,
Id_sucursal1 int FOREIGN KEY  REFERENCES RBV_Sucursal(Id_sucursal)
);


create table RBV_Venta(
ID_Venta int Primary Key identity (3,3),
Fecha_Venta varchar(20),
Hora_Venta varchar (10),
Id_empleado1 int FOREIGN KEY REFERENCES RBV_Empleado(Id_empleado)
);



create table RBV_Proveedor(
Id_proveedor int Primary Key identity (4,4),
Nombre_proveedor varchar(20),
Telefono_Proveedor varchar(10),
correo_Proveedor varchar(20),
Direccion_Proveedor varchar(25)
);



create table RBV_Compra(
ID_Compra int Primary Key identity (5,5),
Fecha_Compra varchar(20),
Hora_Compra varchar (10),
Id_empleado2 int FOREIGN KEY  REFERENCES RBV_Empleado(Id_empleado),
Id_proveedor1 int FOREIGN KEY  REFERENCES RBV_Proveedor(Id_proveedor)
);


create table RBV_Producto(
Id_Producto int Primary Key identity (6,6),
Nombre_Producto varchar(15),
Descripcion_Producto varchar(30),
Precio_Venta float(2),
Precio_Compra float(2)
);



create table RBV_compra_producto(

Id_Producto1 int foreign key references RBV_Producto (Id_Producto),

ID_Compra1 int foreign key references RBV_Compra (ID_Compra),

Cantidad_Comprada int

);



create table RBV_venta_producto(

Id_venta1 int foreign key references RBV_Venta (ID_Venta),

Id_Producto2 int foreign key references RBV_Producto (Id_Producto),

Cantidad_Vendida int
);

                         

          

                            /*INSTRUCCIONES DML*/
                                 /*INSERT*/

INSERT INTO RBV_Sucursal (Direccion_Sucursal, Telefono_Sucursal, Horario_apertura, no_de_empleados)
VALUES 
('Av. Siempre Viva 123', '5551234567', '08 a.m', 10),
('Calle Falsa 456', '5557654321', '09 a.m', 8),
('Boulevard de los Sue os 789', '5559876543', '07 a.m', 12);


INSERT INTO RBV_Empleado ( Nombre_empleado, Telefono_empleado, 
puesto_empleado, Edad_Empleado, Id_sucursal1)
VALUES 
('Juan Perez', '5551112222', 'Cajero', 25, 1),
('Maria Lopez', '5553334444', 'Panadero', 30, 2),
('Carlos Ruiz', '5555556666', 'Repostero', 28, 3);

INSERT INTO RBV_Producto (Nombre_Producto, Descripcion_Producto, Precio_Venta, Precio_Compra)
VALUES 
('Pastel Choco', 'Pastel de chocolate Relleno', 200, 150),
('Pan Integral', 'Pan integral con semillas', 50, 30),
('Galletas', 'Galletas de avena y pasas', 30, 20);

INSERT INTO RBV_Proveedor (Nombre_proveedor, Telefono_Proveedor, correo_Proveedor, Direccion_Proveedor)
VALUES 
('Dolores Delgado', '5557778888', 'contacto@provee.com', 'Calle Principal 123'),
('Juan Erminio', '5559990000', 'ventas@dismx.com', 'Avenida Central 456'),
('Pedro Zaragoza', '5552223333', 'info@suminis.com', 'Boulevard Industrial 789');



INSERT INTO RBV_Compra (Fecha_Compra, Hora_Compra, Id_empleado2, Id_proveedor1)
VALUES 
('10 Agosto de 2024', '11 hrs', 2, 4),
('10 Sep de 2024', '13 hrs', 4, 8),
('10 Octubre de 2024', '9 hrs', 6, 12);


INSERT INTO RBV_compra_producto (Id_Producto1, ID_Compra1, Cantidad_Comprada)
VALUES 
(6, 10, 10),
(12, 15, 20),
(18, 20, 15);


INSERT INTO RBV_Venta (Fecha_Venta, Hora_Venta, Id_empleado1)
VALUES 
('18 junio de 2024', '10 hrs', 2),
('20 junio de 2024', '13 hrs', 4),
('25 junio de 2024', '12hrs', 6);

INSERT INTO RBV_venta_producto (Id_venta1, Id_Producto2, Cantidad_Vendida)
VALUES 
(3, 6, 5),
(6, 12, 10),
(9, 18, 8);



select * from RBV_Sucursal
select * from RBV_Compra
select * from RBV_Empleado
select * from RBV_Producto
select * from RBV_Proveedor
select * from RBV_Venta
select * from RBV_compra_producto
select * from RBV_venta_producto

		/*Procedure sucursal*/

/*Insert*/
Create procedure CP_RBV_Insertar_sucursal
@Direccion_sucursal varchar(35),
@Telefono_sucursal varchar(10),
@Horario_sucursal varchar(10),
@no_empleados int
As
Insert into RBV_Sucursal
Values (@Direccion_sucursal,@Telefono_sucursal,@Horario_sucursal,@no_empleados)
Select * from RBV_Sucursal

Exec CP_RBV_Insertar_sucursal 'av the','5566778899','07:00',20;

Select * from RBV_Sucursal

/*update*/
Create procedure CP_RBV_Actualizar_sucursal
@id_sucursal int,
@Tel_sucursal varchar(10)
As
Update RBV_Sucursal
Set Telefono_Sucursal = @Tel_sucursal
Where Id_sucursal = @id_sucursal
Select * from RBV_Sucursal

Exec CP_RBV_Actualizar_sucursal 6,'5544332211';

Select * from RBV_Sucursal

/*delete*/
Create procedure CP_RBV_Delete_sucursal
@id_sucursal int
As
Delete from RBV_Sucursal
Where Id_sucursal = @id_sucursal
Select * from RBV_Sucursal

Exec CP_RBV_Delete_sucursal 2;


select * from RBV_Sucursal
select * from RBV_Empleado
select * from RBV_Venta
/*select*/
create procedure CP_consulta_sucursal_empleado
@id_sucursal int
As
Select Direccion_Sucursal, Horario_apertura as Apertura, Nombre_empleado as Empleado, Fecha_Venta, Hora_Venta 
From RBV_Sucursal, RBV_Empleado, RBV_Venta
Where Id_sucursal = Id_sucursal1 and Id_empleado = Id_empleado1 and Id_sucursal = @id_sucursal


Exec CP_consulta_sucursal_empleado 1;

