CREATE TABLE user
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    emailLogin VARCHAR(255) NOT NULL ,
    password VARCHAR(50) NOT NULL
);

-- Table: role
CREATE TABLE role
(

    admin VARCHAR(100) NOT NULL,
    user VARCHAR(100) NOT NULL
);


-- Create table hotels
CREATE TABLE hotel
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(50) NOT NULL,
    adress VARCHAR(50)NOT NULL ,
    country VARCHAR (50) NOT NULL
);

-- Create table room
