
INSERT INTO CABINS (NAME, TYPE, PRICE, DATE, BOOKED, DETAILS)
VALUES ('Stuga1', 'Stor', 2000, TIMESTAMP '1999-01-31', true, 'Antal rum: 3 | Badrum: Ja | Kök: Fullt utrustat | Utsikt: Sjöutsikt'),
       ('Stuga2', 'Stor', 1800, TIMESTAMP '1999-01-31', false, 'Antal rum: 4 | Badrum: Ja | Kök: Spis och kylskåp | Utsikt: Skog'),
       ('Stuga3', 'Liten', 1200, TIMESTAMP '1999-01-31', false, 'Antal rum: 2 | Badrum: Nej | Kök: Enkel spis | Utsikt: Berg'),
       ('Stuga4', 'Mellan', 1500, TIMESTAMP '1999-01-31', false, 'Antal rum: 3 | Badrum: Ja | Kök: Mikrovågsugn och kylskåp | Utsikt: Trädgård'),
       ('Stuga5', 'Liten', 1000, TIMESTAMP '1999-01-31', false, 'Antal rum: 1 | Badrum: Nej | Kök: Grundläggande kokplatta | Utsikt: Ingen specifik'),
       ('Stuga6', 'Mellan', 1600, TIMESTAMP '1999-01-31', false, 'Antal rum: 2 | Badrum: Ja | Kök: Gas spis och ugn | Utsikt: Sjöutsikt'),
       ('Stuga7', 'Stor', 2200, TIMESTAMP '1999-01-31', false, 'Antal rum: 5 | Badrum: Ja | Kök: Fullt utrustat kök | Utsikt: Havet'),
       ('Stuga8', 'Liten', 800, TIMESTAMP '1999-01-31', false, 'Antal rum: 1 | Badrum: Nej | Kök: Enkel spis | Utsikt: Skog och sjö');

INSERT INTO CUSTOMER (FIRSTNAME, LASTNAME, ADDRESS, PHONE, USERNAME,RENT_TIMES)
VALUES ('Hawkwind','Greger', 'Brandstation 666', 696969, 'Greger',1)
