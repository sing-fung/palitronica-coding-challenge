CREATE DATABASE payment;

USE payment;

CREATE TABLE `customer`  (
  `id` char(36) NOT NULL,
  `name` varchar(50) NOT NULL,
  `country` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `street` varchar(100) NOT NULL,
  `zip` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `item`  (
  `id` char(36) NOT NULL,
  `code` varchar(20) NOT NULL,
  `price` DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `order_overview`  (
  `id` char(36) NOT NULL,
  `customer_id` char(36) NOT NULL,
  `total_taxes` DECIMAL(12,2) NOT NULL,
  `total_price` DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `order_item`  (
  `id` char(36) NOT NULL,
  `order_id` char(36) NOT NULL,
  `item_code` varchar(20) NOT NULL,
  `quantity` int NOT NULL,
  `item_total_price` DECIMAL(12,2) NOT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO customer (id, name, country, city, street, zip) VALUES ('2abf3ecc-1b22-4c91-88ad-8d4e5af55c86', 'David', 'CA', 'Edmonton', '116 St', 'T6G2R3');
INSERT INTO customer (id, name, country, city, street, zip) VALUES ('4391548f-2ceb-4720-93ce-9c2ecfa155d8', 'Cathy', 'CA', 'Vancouver', '510 W Georgia St #14', 'V6B0M3');
INSERT INTO customer (id, name, country, city, street, zip) VALUES ('81a5574a-6cb3-438d-a06a-2ff17f8c51bf', 'Adam', 'US', 'Watts', '123 Test St', '90002');
INSERT INTO customer (id, name, country, city, street, zip) VALUES ('86a27fb4-320a-48c0-a568-e4561697e52a', 'Ethan', 'CA', 'Halifax', '6299 South St', 'B3H4R2');
INSERT INTO customer (id, name, country, city, street, zip) VALUES ('ff195ade-7c6a-47d8-a368-a6139e1274de', 'Bob', 'CA', 'Ottawa', '800 King Edward Ave', 'K1N6N5');


INSERT INTO item (id, code, price) VALUES ('0f16d812-c8af-4d83-9e77-1132f6e8ec45', 'A0001', 12.50);
INSERT INTO item (id, code, price) VALUES ('3a3f37d8-3604-4584-848c-7f344ffa1bb7', 'A0002', 10.75);
INSERT INTO item (id, code, price) VALUES ('a0200349-dae5-41ab-8a31-2b0c601491bb', 'A0003', 13.75);
INSERT INTO item (id, code, price) VALUES ('14828afc-91d7-439d-81d9-41db28410345', 'A0004', 14.25);
INSERT INTO item (id, code, price) VALUES ('fb452d8d-a79b-4347-934c-a51aa35553d3', 'A0005', 14.00);
INSERT INTO item (id, code, price) VALUES ('57fec172-7acf-42ac-b53f-40c4664db8a0', 'A0006', 11.00);
INSERT INTO item (id, code, price) VALUES ('9b031c9a-deaa-4658-ae77-2972b89f65cf', 'A0007', 12.25);
