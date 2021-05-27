insert into cuenta (id,numerocuenta,codpais,digitocontrol,entidad,oficina,tipocuenta,estado, fechaactual, fechaapertura,fechacontable, saldo_actual,saldo_inicial)
values (1,12345678,11,01,1234,03,"Cuenta Seguro Plus",0,NOW(),'2018-01-01',NOW(),1000,2000);

insert into cuenta (id,numerocuenta,codpais,digitocontrol,entidad,oficina,tipocuenta,estado, fechaactual, fechaapertura,fechacontable, saldo_actual,saldo_inicial)
values (2,12345679,11,01,1234,03,"Cuenta Seguro Plus",0,NOW(),'2018-01-01',NOW(),1000,2000);

insert into movimiento(concepto,descripcion,fecha,fecha_valor,importe,id_categoria,numerocuenta)
values ('Ingreso','ingreso',NOW(),NOW(),50,null,1);






