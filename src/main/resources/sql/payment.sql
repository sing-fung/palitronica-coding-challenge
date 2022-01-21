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
