/* Cleanup */
DROP DATABASE IF EXISTS web_test_db;

/* Initialise database */
CREATE DATABASE web_test_db;

USE web_test_db;

/* Create tables */
CREATE TABLE test_table (message VARCHAR(500));

CREATE TABLE users (
    user_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	name VARCHAR(64),
	username VARCHAR(64) NOT NULL,
	password VARCHAR(64),
	salt VARCHAR(32));

INSERT INTO test_table (message) VALUES ("Hello");