#
# TABLE STRUCTURE FOR: shipping_types
#

INSERT INTO `shipping_types` (`id`, `description`, `name`) VALUES ('1', 'Envio directo', 'Directo');
INSERT INTO `shipping_types` (`id`, `description`, `name`) VALUES ('2', 'Mercado envios', 'Mercado Envios');
INSERT INTO `shipping_types` (`id`, `description`, `name`) VALUES ('3', 'Envio por correo', 'Oca');
INSERT INTO `shipping_types` (`id`, `description`, `name`) VALUES ('4', 'Envio por courrier', 'DHL');

#
# TABLE STRUCTURE FOR: stock
#

INSERT INTO `stock` (`id`, `quantity`) VALUES ('0', 50);
INSERT INTO `stock` (`id`, `quantity`) VALUES ('1', 182);
INSERT INTO `stock` (`id`, `quantity`) VALUES ('2', 27);
INSERT INTO `stock` (`id`, `quantity`) VALUES ('3', 42);

#
# TABLE STRUCTURE FOR: providers
#


INSERT INTO `providers` (`id`, `address`, `country`, `name`, `phone`) VALUES ('0', '9217 Cremin Radial Suite 062\nMarcotown, MO 43835', 'Georgia', 'at', '(967)125-2432x700');
INSERT INTO `providers` (`id`, `address`, `country`, `name`, `phone`) VALUES ('1', '664 Little Manor Apt. 129\nPort Zaria, NV 07843', 'Haiti', 'beatae', '(361)707-0104x0774');
INSERT INTO `providers` (`id`, `address`, `country`, `name`, `phone`) VALUES ('2', '06607 Antone Oval\nEast Bretton, NC 60305-4482', 'British Virgin Islands', 'voluptatibus', '410-578-4103');
INSERT INTO `providers` (`id`, `address`, `country`, `name`, `phone`) VALUES ('3', '921 Felicita Stream Suite 310\nEast Americohaven, OR 51223', 'United Arab Emirates', 'nobis', '03742815631');



#
# TABLE STRUCTURE FOR: parts
#


INSERT INTO `parts` (`id`, `description`, `lastModification`, `longDimension`, `netWeight`, `partCode`, `talDimension`, `widthDimenion`, `provider_id`, `stock_id`) VALUES ('0', 'Puertas', '1995-08-10', 8, 6, '00000001', 3, 3, '0', '0');


INSERT INTO `parts` (`id`, `description`, `lastModification`, `longDimension`, `netWeight`, `partCode`, `talDimension`, `widthDimenion`, `provider_id`, `stock_id`) VALUES ('1', 'Paragolpes de Fiat 147', '2000-08-10', 8, 6, '00000002', 3, 3, '0', '1');

INSERT INTO `parts` (`id`, `description`, `lastModification`, `longDimension`, `netWeight`, `partCode`, `talDimension`, `widthDimenion`, `provider_id`, `stock_id`) VALUES ('2', 'Ruedas Pirelli Gt Grand Master', '2002-08-10', 8, 6, '00000003', 3, 3, '0', '2');

#
# TABLE STRUCTURE FOR: discount_types
#

INSERT INTO `discount_types` (`id`, `description`) VALUES ('1', 'Descuento por socio ACA - 10%');
INSERT INTO `discount_types` (`id`, `description`) VALUES ('2', 'Descuento por veterano de malvinas -  15%');
INSERT INTO `discount_types` (`id`, `description`) VALUES ('3', 'Descuento socio YPF ServiClub - 95%');

#
# TABLE STRUCTURE FOR: part_records
#



INSERT INTO `part_records` (`id`, `lastModification`, `normalPrice`, `urgentPrice`, `discount_type_id`, `part_id`) VALUES ('0', '1992-01-28', '5000', '10000', '1', '0');

INSERT INTO `part_records` (`id`, `lastModification`, `normalPrice`, `urgentPrice`, `discount_type_id`, `part_id`) VALUES ('1', '1992-01-28', '5000', '10000', '2', '1');

INSERT INTO `part_records` (`id`, `lastModification`, `normalPrice`, `urgentPrice`, `discount_type_id`, `part_id`) VALUES ('2', '1992-01-28', '5000', '10000', '3', '2');



#
# TABLE STRUCTURE FOR: account_types
#


INSERT INTO `account_types` (`id`, `description`, `name`) VALUES ('1', 'Repuestos', 'R');
INSERT INTO `account_types` (`id`, `description`, `name`) VALUES ('2', 'Garantia', 'G');
#
# TABLE STRUCTURE FOR: central_house
#


INSERT INTO `central_house` (`id`, `address`, `country`, `name`, `phone`) VALUES ('0001', '285 Hahn Canyon Suite 050\nCaspertown, PA 23686-0283', 'Nepal', 'Casa Central 1', 956);

#
# TABLE STRUCTURE FOR: concessionarias
#



INSERT INTO `concessionarias` (`id`, `address`, `country`, `name`, `phone`) VALUES ('0001', '920 Emard Stream Suite 759\nWest Jeffery, TX 24108-6987', 'Grenada', 'ut', 728524);
INSERT INTO `concessionarias` (`id`, `address`, `country`, `name`, `phone`) VALUES ('0002', '27059 King Way\nPort Raoul, CO 92422', 'Jamaica', 'ab', 13);



INSERT INTO `delivery_status` (`id`, `code`, `description`) VALUES ('0', 'P', 'Pendientes de entrega');
INSERT INTO `delivery_status` (`id`, `code`, `description`) VALUES ('1', 'D', 'Demorado');
INSERT INTO `delivery_status` (`id`, `code`, `description`) VALUES ('2', 'F', 'Finalizado');
INSERT INTO `delivery_status` (`id`, `code`, `description`) VALUES ('4', 'C', 'CasaCentral');

#
# TABLE STRUCTURE FOR: orders
#


INSERT INTO `orders` (`id`, `daysDelayed`, `deliveryDate`, `orderDate`, `orderNumberCM`, `central_house_id`, `concessionarie_id`, `delivery_status_id`, `shipping_type_id`) VALUES ('0', 9, '2002-02-15', '1988-06-25', 00000025, '0001', '1', '1', '1');

#
# TABLE STRUCTURE FOR: order_details
#


INSERT INTO `order_details` (`id`, `description`, `quantity`, `reason`, `account_type_id`, `order_id`, `part_id`) VALUES ('0', 'pedido de puertas','1','who reason', '1', '0', '0');

INSERT INTO `stock_central_house` (`id`,`quantity`,`central_house_id`,`part_id`) VALUES ('1', '123', '0001', '0');

#
# TABLE STRUCTURE FOR: user
#
INSERT INTO `user` (`id`,`password`,`username`,`role`) VALUES ('1', '$2a$10$DXK9eG5/tHAwMiAVB.x5vOAE6EVnC2eYtvGo7UiZpHY/rHJcqtsqe', 'gabriel', 'ADMIN');