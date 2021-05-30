INSERT INTO categoria (id, nombre) VALUES (4, 'NOMINAS');


insert into cuenta (id,numerocuenta,codpais,digitocontrol,entidad,oficina,tipocuenta,estado, fechaactual, fechaapertura,fechacontable, saldo_actual,saldo_inicial)
values (1,12345678,11,01,1234,03,"Cuenta Seguro Plus",0,NOW(),'2018-01-01',NOW(),1000,2000);

insert into cuenta (id,numerocuenta,codpais,digitocontrol,entidad,oficina,tipocuenta,estado, fechaactual, fechaapertura,fechacontable, saldo_actual,saldo_inicial)
values (2,12345679,11,01,1234,03,"Cuenta Seguro Plus",0,NOW(),'2018-01-01',NOW(),1000,2000);

insert into tarjeta(id,ccv, estado_tarjeta,fecha_expedicion, fecha_expiracion, limite, tipo,cuenta_id)
values (444441,124,0,'2021-05-12 13:47:39.000000','2023-05-12 13:47:39.000000',500,'debito',1);

insert into movimiento(id,concepto,descripcion,fecha,fecha_valor,importe,id_categoria,id_cuenta,id_tarjeta)
values (1,'Ingreso','ingreso',NOW(),NOW(),1000,4,1,444441);

insert into movimiento(id,concepto,descripcion,fecha,fecha_valor,importe,id_categoria,id_cuenta,id_tarjeta)
values (2,'Ingreso','ingreso',NOW(),NOW(),2000,4,1,444441);

insert into movimiento(id,concepto,descripcion,fecha,fecha_valor,importe,id_categoria,id_cuenta,id_tarjeta)
values (3,'Ingreso','ingreso',NOW(),NOW(),3000,4,1,444441);

insert into movimiento(id,concepto,descripcion,fecha,fecha_valor,importe,id_categoria,id_cuenta,id_tarjeta)
values (4,'Ingreso','ingreso',NOW(),NOW(),1000,4,1,444441);

insert into movimiento(id,concepto,descripcion,fecha,fecha_valor,importe,id_categoria,id_cuenta,id_tarjeta)
values (5,'Ingreso','ingreso',NOW(),NOW(),2000,4,1,444441);

insert into movimiento(id,concepto,descripcion,fecha,fecha_valor,importe,id_categoria,id_cuenta,id_tarjeta)
values (6,'Ingreso','ingreso',NOW(),NOW(),3000,4,1,444441);

insert into movimiento(id,concepto,descripcion,fecha,fecha_valor,importe,id_categoria,id_cuenta,id_tarjeta)
values (7,'Ingreso','ingreso',NOW(),NOW(),1000,4,1,444441);

insert into movimiento(id,concepto,descripcion,fecha,fecha_valor,importe,id_categoria,id_cuenta,id_tarjeta)
values (8,'Ingreso','ingreso',NOW(),NOW(),2000,4,1,444441);

insert into movimiento(id,concepto,descripcion,fecha,fecha_valor,importe,id_categoria,id_cuenta,id_tarjeta)
values (9,'Ingreso','ingreso',NOW(),NOW(),3000,4,1,444441);











