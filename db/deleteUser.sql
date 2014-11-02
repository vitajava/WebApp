DROP PROCEDURE IF EXISTS deleteUser;

DELIMITER //
CREATE DEFINER =`root`@`localhost` PROCEDURE `deleteUser`(login varchar(40))
  BEGIN
    DELETE FROM users
    WHERE users.login = login;
END//
