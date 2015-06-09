
-- creacion de 3 ordenes de internamiento
insert into internment_order values (1, now(),1,now(),now(),42103543,42103543);

insert into internment_order values (2, now(),1,now(),now(),42103543,42103543);

insert into internment_order values (3, now(),1,now(),now(),42103543,42103543);

-- dos productos, uno por cada marca
insert into product values(1, 'BinBomBum',25,48,180,850,300,20,1,now(),now(),1,'0081500601008',1,42103543,42103543);

insert into product values(2, 'BonoBom',25,48,180,850,300,20,1,now(),now(),1,'0081500601008',1,42103543,42103543);

insert into product values(3, 'Donofrio',20,50,200,900,350,30,1,now(),now(),1,'0081500601008',2,42103543,42103543);

insert into product values(4, 'Sublime',30,35,210,950,400,40,1,now(),now(),1,'0081500601008',2,42103543,42103543);



-- 13 pallets 
insert into pallet values (1, 'Pallet1',1,now(),now(),2,42103543,42103543);

insert into pallet values (2, 'Pallet2',1,now(),now(),2,42103543,42103543);

insert into pallet values (3, 'Pallet3',1,now(),now(),2,42103543,42103543);

insert into pallet values (4, 'Pallet4',1,now(),now(),2,42103543,42103543);

insert into pallet values (5, 'Pallet5',1,now(),now(),2,42103543,42103543);

insert into pallet values (6, 'Pallet6',1,now(),now(),2,42103543,42103543);

insert into pallet values (7, 'Pallet7',1,now(),now(),2,42103543,42103543);

insert into pallet values (8, 'Pallet8',1,now(),now(),2,42103543,42103543);

insert into pallet values (9, 'Pallet9',1,now(),now(),2,42103543,42103543);

insert into pallet values (10, 'Pallet10',1,now(),now(),2,42103543,42103543);

insert into pallet values (11, 'Pallet11',1,now(),now(),2,42103543,42103543);

insert into pallet values (12, 'Pallet12',1,now(),now(),2,42103543,42103543);

insert into pallet values (13, 'Pallet13',1,now(),now(),2,42103543,42103543);

-- asociacion de 8 pallet con productos 
insert into pallet_by_product values (1,1,1,'12345678',1,now()+7,now(),now(),42103543,42103543,1);

insert into pallet_by_product values (2,1,2,'123445678',1,now()+7,now(),now(),42103543,42103543,1);

insert into pallet_by_product values (3,2,1,'124445678',1,now()+7,now(),now(),42103543,42103543,1);

insert into pallet_by_product values (4,2,2,'124445678',1,now()+7,now(),now(),42103543,42103543,1);

insert into pallet_by_product values (5,1,1,'121235678',1,now()+7,now(),now(),42103543,42103543,1);

insert into pallet_by_product values (6,1,2,'121235678',1,now()+7,now(),now(),42103543,42103543,1);

insert into pallet_by_product values (7,2,1,'121235678',1,now()+7,now(),now(),42103543,42103543,1);

insert into pallet_by_product values (8,2,2,'121235678',1,now()+7,now(),now(),42103543,42103543,1);


-- 2 location_cell
insert into location_cell values(1, 'Celda1',20,30,40,10,8,1,now(),now(),1,1,1,1,42103543,42103543);
insert into location_cell values(2, 'Celda2',10,20,35,12,8,1,now(),now(),1,1,1,1,42103543,42103543);


-- 4 detalles de celda por cada celda
insert into location_cell_detail  values(1, 'Posicion1-Celda1',1,now(),now(),1,1,1,1,42103543,42103543 );
insert into location_cell_detail  values(2, 'Posicion2-Celda1',1,now(),now(),1,1,1,1,42103543,42103543 );
insert into location_cell_detail  values(3, 'Posicion3-Celda1',1,now(),now(),1,1,1,1,42103543,42103543 );
insert into location_cell_detail  values(4, 'Posicion4-Celda1',1,now(),now(),1,1,1,1,42103543,42103543 );

insert into location_cell_detail values(1, 'Posicion1-Celda2',1,now(),now(),2,1,1,1,42103543,42103543 );
insert into location_cell_detail values(2, 'Posicion2-Celda2',1,now(),now(),2,1,1,1,42103543,42103543 );
insert into location_cell_detail values(3, 'Posicion3-Celda2',1,now(),now(),2,1,1,1,42103543,42103543 );
insert into location_cell_detail values(4, 'Posicion4-Celda2',1,now(),now(),2,1,1,1,42103543,42103543 );

insert into pallet_by_product_by_location_cell_detail  values(1,  1    ,1 ,1   ,1 ,1 ,  1 ,1 ,1 ,1,now(),now(),42103543,42103543);

insert into pallet_by_product_by_location_cell_detail  values(2,  2    ,1 ,2   ,2 ,1 ,  1 ,1 ,1 ,1,now(),now(),42103543,42103543);

insert into pallet_by_product_by_location_cell_detail  values(3,  3    ,2 ,1   ,3 ,1 ,  1 ,1 ,1 ,1,now(),now(),42103543,42103543);

insert into pallet_by_product_by_location_cell_detail  values(4,  4    ,2 ,2   ,4 ,1 ,  1 ,1 ,1 ,1,now(),now(),42103543,42103543);

insert into pallet_by_product_by_location_cell_detail  values(5,  5    ,1 ,1   ,1 ,2 ,  1 ,1 ,1 ,1,now(),now(),42103543,42103543);

insert into pallet_by_product_by_location_cell_detail  values(6,  6    ,1 ,2  ,2 ,2 ,  1 ,1 ,1 ,1,now(),now(),42103543,42103543);

insert into pallet_by_product_by_location_cell_detail  values(7,  7    ,2 ,1   ,3 ,2 ,  1 ,1 ,1 ,1,now(),now(),42103543,42103543);

insert into pallet_by_product_by_location_cell_detail  values(8,  8    ,2 ,2   ,4 ,2 ,  1 ,1 ,1 ,1,now(),now(),42103543,42103543);

insert into driver (idDriver,name,status) values (1,"Jaime Espíndola",1);
insert into vehicle (idVehicle,license_plate,capacity,dispatch_number,Vehicle_State_idVehicle_State,Driver_idDriver) values (1,"PLACA 1",100000,1,2,1);
insert into driver (idDriver,name,status) values (2,"Michael Schumaher",1);
insert into vehicle (idVehicle,license_plate,capacity,dispatch_number,Vehicle_State_idVehicle_State,Driver_idDriver) values (2,"PLACA 2",100000,1,2,2);
insert into driver (idDriver,name,status) values (3,"Alfonso Lopez",1);
insert into vehicle (idVehicle,license_plate,capacity,dispatch_number,Vehicle_State_idVehicle_State,Driver_idDriver) values (3,"PLACA 3",100000,1,2,3);


