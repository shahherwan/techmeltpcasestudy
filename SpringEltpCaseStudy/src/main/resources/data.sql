INSERT INTO 
    EMPLOYEES (first_name, last_name, email) 
VALUES
      ('Sree', 'Krishna','jsk@gmail.com'),
      ('Sriman', 'Narayana', 'smn@email.com'); 
 
INSERT INTO 
    USERS (username, password, enabled)
VALUES
      ('admin@email.com','$2a$04$gzZGRDn6705lKtUU694nxug9t155..0f1Dwc54YlANEKBuM5iHCfy',1),
      ('user@email.com','$2y$04$hbITFucG2a0KLK98FZ445ea6RiksbAlXZ27nLfDP1IdL5mBWzwpY.',1);
 
INSERT INTO 
    AUTHORITIES (username, authority)
 VALUES
      ('admin@email.com', 'ROLE_ADMIN'),
      ('user@email.com', 'ROLE_USER');
      
      
      
 -- Admin User admin@email.com/admin123
 -- Normal User user@email.com/password123