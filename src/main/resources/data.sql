#
# TABLE STRUCTURE FOR: shipping_types
#

INSERT INTO `shipping_types` (`id`, `description`, `name`) VALUES ('1', 'Laborum at soluta iusto. Occaecati sit voluptas quae enim recusandae harum. Magnam voluptates aut quo voluptatem exercitationem possimus.', 'quis');
INSERT INTO `shipping_types` (`id`, `description`, `name`) VALUES ('2', 'Nostrum aut eum et quibusdam dolore nihil. Nesciunt esse incidunt consequatur dignissimos. Laudantium eum doloribus earum earum ipsa illum debitis. Ut architecto asperiores soluta deserunt distinctio. Est consequatur qui dicta dolor reprehenderit blanditi', 'quisquam');
INSERT INTO `shipping_types` (`id`, `description`, `name`) VALUES ('3', 'Deserunt ut debitis aut error non. Nisi nihil in quod quis architecto. Dolorem dolores nobis occaecati deleniti enim. Placeat enim dolores corrupti et et cupiditate qui.', 'voluptatem');
INSERT INTO `shipping_types` (`id`, `description`, `name`) VALUES ('4', 'Corporis facilis dolorum deserunt assumenda aut minus et. Deserunt ut autem ut natus saepe quos. Velit doloribus sunt repudiandae quia maiores.', 'ipsam');

#
# TABLE STRUCTURE FOR: stock
#

INSERT INTO `stock` (`id`, `quantity`) VALUES ('0', 21368);
INSERT INTO `stock` (`id`, `quantity`) VALUES ('1', 8822);
INSERT INTO `stock` (`id`, `quantity`) VALUES ('2', 369563);
INSERT INTO `stock` (`id`, `quantity`) VALUES ('3', 45112);

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

#
# TABLE STRUCTURE FOR: discount_types
#

INSERT INTO `discount_types` (`id`, `description`) VALUES ('1', 'Quia ut non odit ipsa aut est suscipit. Iste sint perferendis temporibus corrupti vel exercitationem. Debitis praesentium animi qui ut qui assumenda. Et provident dolor laudantium. Facere ex dicta ut voluptatem.');
INSERT INTO `discount_types` (`id`, `description`) VALUES ('2', 'Laudantium veniam aliquam non eum eum. Qui nam animi consectetur illum nihil perferendis.');
INSERT INTO `discount_types` (`id`, `description`) VALUES ('3', 'Omnis dignissimos odit deserunt omnis unde. Vel praesentium ipsa eos aspernatur voluptatibus eum aperiam. Officiis consequatur ipsa est ut placeat et modi. Aut provident odio totam accusantium impedit saepe voluptatem.');

#
# TABLE STRUCTURE FOR: part_records
#



INSERT INTO `part_records` (`id`, `lastModification`, `normalPrice`, `urgentPrice`, `discount_type_id`, `part_id`) VALUES ('0', '1992-01-28', '5000', '10000', '1', '0');

#
# TABLE STRUCTURE FOR: account_types
#


INSERT INTO `account_types` (`id`, `description`, `name`) VALUES ('1', 'Repuestos', 'R');
INSERT INTO `account_types` (`id`, `description`, `name`) VALUES ('2', 'Garantia', 'G');
#
# TABLE STRUCTURE FOR: central_houses
#


INSERT INTO `central_houses` (`id`, `address`, `country`, `name`, `phone`) VALUES ('0001', '285 Hahn Canyon Suite 050\nCaspertown, PA 23686-0283', 'Nepal', 'Casa Central 1', 956);

#
# TABLE STRUCTURE FOR: concessionaries
#



INSERT INTO `concessionaries` (`id`, `address`, `country`, `name`, `phone`) VALUES ('0001', '920 Emard Stream Suite 759\nWest Jeffery, TX 24108-6987', 'Grenada', 'ut', 728524);
INSERT INTO `concessionaries` (`id`, `address`, `country`, `name`, `phone`) VALUES ('0002', '27059 King Way\nPort Raoul, CO 92422', 'Jamaica', 'ab', 13);



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


INSERT INTO `order_details` (`id`, `description`, `quantity`, `reason`, `account_type_id`, `order_id`, `part_id`) VALUES ('0', 'pedido de puerts','1','who reason', '1', '0', '0');

INSERT INTO `stock_central_house` (`id`,`quantity`,`central_house_id`,`part_id`) VALUES ('1', '123', '0001', '0');
