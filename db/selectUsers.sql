DROP PROCEDURE IF EXISTS selectUsers;

DELIMITER //
CREATE DEFINER =`root`@`localhost` PROCEDURE `selectUsers`()
  BEGIN
    SELECT
      login, password, firstName, lastName, phone, email, address

    FROM users;
  END//