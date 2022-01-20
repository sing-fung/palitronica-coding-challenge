CREATE DATABASE payment;

USE payment;

CREATE TABLE `customer`  (
  `id` char(36) NOT NULL,
  `name` varchar(50) NOT NULL,
  `country` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `street` varchar(100) NOT NULL,
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
