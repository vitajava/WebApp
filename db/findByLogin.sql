DROP PROCEDURE IF EXISTS findByLogin;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `findByLogin`(login varchar(40))
BEGIN

SET @s = CONCAT('SELECT login, firstName, LastName, phone, email FROM users WHERE login LIKE \'%', login, '%\';');
    PREPARE stmt FROM @s;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;

  END$$
DELIMITER ;