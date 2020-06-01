# food_truck
SanFrancisco Food Truck API

Import the collection using: https://www.getpostman.com/collections/89c81a780261c3a6576e


Using H2 in memory DB
data model consist of master_db for food_truck management
CREATE TABLE IF NOT EXISTS `food_truck_master`(
`location_id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
`applicant` varchar(60) NOT NULL,
`facility_type` varchar(20) DEFAULT NULL,
`cnn` int(11) NOT NULL,
`location_description` varchar(64) NOT NULL,
`address` varchar(50) NOT NULL,
`blocklot` varchar(50) NOT NULL,
`block` varchar(50) NOT NULL,
`lot` varchar(50) NOT NULL,
`permit` varchar(50) NOT NULL,
`status` varchar(50) NOT NULL,
`food_items` varchar(50) NOT NULL,
`latitude` DECIMAL(10, 8) NOT NULL,
`longitude` DECIMAL(10, 8) NOT NULL,
`X` DECIMAL(10, 8) NOT NULL,
`Y` DECIMAL(10, 8) NOT NULL,
`schedule` varchar(255) NOT NULL,
`dayshours` varchar(50) DEFAULT NULL,
`noi_sent` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`approved` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`received` varchar(50) NOT NULL,
`prior_permit` int(11) NOT NULL,
`expiration_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`location` varchar(50) DEFAULT NULL
);


Spring boot MVC framework with JPA as ORM

Server running on port : 9090
H2 configurations in application.properties
