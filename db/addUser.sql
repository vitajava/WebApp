DROP PROCEDURE IF EXISTS addUser;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addUser`(
 `login` VARCHAR(40),
  `password` VARCHAR(45),
  `firstName` VARCHAR(45),
  `lastName` VARCHAR(45),
  `sex` VARCHAR(6),
  `phone` VARCHAR(45),
`email`	varchar(50),
  `address` VARCHAR(45)
)
BEGIN
START TRANSACTION;
SET AUTOCOMMIT = 0;

INSERT INTO users (login, password, firstName, lastName, sex, phone, email, address)
VALUES (login, password, firstName, lastName, sex, phone, email, address);

COMMIT;
SET AUTOCOMMIT = 1;
END$$
DELIMITER ;
