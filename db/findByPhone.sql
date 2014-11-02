DROP PROCEDURE IF EXISTS findByPhone;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `findByPhone`(phone varchar(45))
BEGIN

SET @s = CONCAT('SELECT login, firstName, LastName, phone, email FROM users WHERE phone LIKE \'%', phone, '%\';');
    PREPARE stmt FROM @s;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;

  END$$
DELIMITER ;