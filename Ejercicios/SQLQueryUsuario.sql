use Equipo_pedidos;
SELECT * FROM SDJ_Venta;

INSERT INTO SDJ_Venta(clave_venta, fecha_venta, hora_venta, forma_pago)
values (4,'2025-03-18', '13:42 pm','efectivo')


GRANT INSERT, SELECT
ON SDJ_Venta
TO USUARIO_FINAL_MOISES_H;