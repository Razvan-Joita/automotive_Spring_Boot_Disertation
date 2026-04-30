INSERT INTO customer (first_name, last_name, email, phone) VALUES
('John', 'Smith', 'john.smith@email.com', '+40721234567'),
('Maria', 'Popescu', 'maria.popescu@email.com', '+40731234568'),
('Alexandru', 'Ionescu', 'alex.ionescu@email.com', '+40741234569'),
('Elena', 'Constantin', 'elena.constantin@email.com', '+40751234570'),
('Mihai', 'Georgescu', 'mihai.georgescu@email.com', '+40761234571');

INSERT INTO dealership (name, location, phone, email) VALUES
('AutoPrime Oradea', 'Str. Republicii 12, Oradea', '+40259123456', 'contact@autoprime.ro'),
('StarMotors Cluj', 'Calea Turzii 88, Cluj-Napoca', '+40264123456', 'office@starmotors.ro'),
('EliteCars Bucuresti', 'Bd. Unirii 45, Bucuresti', '+40212345678', 'info@elitecars.ro');

INSERT INTO employee (name, role, email, phone, dealership_id) VALUES
('Andrei Muresan', 'MECHANIC', 'andrei.muresan@autoprime.ro', '+40721000001', 1),
('Cristian Popa', 'MECHANIC', 'cristian.popa@autoprime.ro', '+40721000002', 1),
('Ioana Dinu', 'SERVICE_ADVISOR', 'ioana.dinu@autoprime.ro', '+40721000003', 1),
('Bogdan Stancu', 'MECHANIC', 'bogdan.stancu@starmotors.ro', '+40721000004', 2),
('Laura Mihai', 'SERVICE_ADVISOR', 'laura.mihai@starmotors.ro', '+40721000005', 2),
('Radu Florea', 'MECHANIC', 'radu.florea@elitecars.ro', '+40721000006', 3);

INSERT INTO manufacturer (name, country) VALUES
('Mercedes-Benz', 'Germany'),
('Volkswagen', 'Germany'),
('Dacia', 'Romania');

INSERT INTO vehicle (vin, license_plate, make, model, year, fuel_type, status, current_odometer, manufacturer_id, customer_id) VALUES
('3VWFE21C04M000001', 'CJ-100-BMW', 'BMW', 'X5', 2022, 'Diesel', 'ACTIVE', 32000, 4, 1),
('WDDGF4HB2FA123456', 'B-200-MRC', 'Mercedes-Benz', 'C200', 2021, 'Gasoline', 'ACTIVE', 47000, 5, 2),
('WVWZZZ1KZ9W123456', 'BH-300-VW', 'Volkswagen', 'Golf', 2020, 'Diesel', 'ACTIVE', 61000, 6, 3),
('UU1LSDAR5GA123456', 'BH-400-DAC', 'Dacia', 'Duster', 2023, 'Gasoline', 'ACTIVE', 12000, 7, 4),
('1FTFW1ET5DFA12345', 'AR-500-FRD', 'Ford', 'F-150', 2021, 'Gasoline', 'IN_SERVICE', 88000, 3, 5);

UPDATE vehicle SET customer_id = 1 WHERE vin = '1HGCM82633A123456';
UPDATE vehicle SET customer_id = 2 WHERE vin = '2HGCM82633A123457';

INSERT INTO part (name, part_number, description, price, quantity) VALUES
('Oil Filter', 'OF-1001', 'Standard oil filter for petrol engines', 45.99, 50),
('Air Filter', 'AF-1002', 'Engine air filter', 38.50, 40),
('Brake Pads Front', 'BP-2001', 'Front brake pads set', 120.00, 30),
('Brake Pads Rear', 'BP-2002', 'Rear brake pads set', 95.00, 30),
('Spark Plug Set', 'SP-3001', 'Set of 4 spark plugs', 65.00, 60),
('Timing Belt', 'TB-4001', 'Timing belt for 1.6L engines', 210.00, 20),
('Engine Oil 5W40 5L', 'EO-5001', 'Synthetic engine oil 5W40', 89.99, 100),
('Cabin Air Filter', 'CA-6001', 'Cabin pollen filter', 29.99, 45),
('Wiper Blades Set', 'WB-7001', 'Front wiper blades pair', 55.00, 35),
('Battery 70Ah', 'BA-8001', '12V 70Ah car battery', 320.00, 15);

INSERT INTO service_record (description, date, vehicle_id, mechanic_id) VALUES
('Full service - oil change, filters replacement, brake inspection', '2025-06-15', 1, 1),
('Brake pads replacement front and rear', '2025-07-20', 2, 2),
('Timing belt replacement and spark plugs', '2025-08-10', 3, 4),
('Annual inspection and oil change', '2025-09-05', 4, 1),
('Battery replacement and wiper blades', '2025-10-12', 5, 6),
('Full service - oil, filters, brakes check', '2025-11-18', 6, 2),
('Engine diagnostic and spark plug replacement', '2026-01-08', 7, 4);

INSERT INTO service_record_parts (service_record_id, part_id, quantity) VALUES
(1, 1, 1),  -- Oil Filter
(1, 2, 1),  -- Air Filter
(1, 7, 1),  -- Engine Oil
(2, 3, 1),  -- Brake Pads Front
(2, 4, 1),  -- Brake Pads Rear
(3, 6, 1),  -- Timing Belt
(3, 5, 1),  -- Spark Plugs
(4, 1, 1),  -- Oil Filter
(4, 7, 1),  -- Engine Oil
(4, 8, 1),  -- Cabin Air Filter
(5, 10, 1), -- Battery
(5, 9, 1),  -- Wiper Blades
(6, 1, 1),  -- Oil Filter
(6, 7, 1),  -- Engine Oil
(6, 2, 1),  -- Air Filter
(7, 5, 1);  -- Spark Plugs

INSERT INTO warranty (start_date, end_date, vehicle_id) VALUES
('2023-01-01', '2026-01-01', 1),
('2024-01-01', '2027-01-01', 2),
('2022-06-15', '2025-06-15', 3),
('2021-03-10', '2025-03-10', 4),
('2020-08-20', '2023-08-20', 5),
('2023-05-01', '2026-05-01', 6),
('2021-11-15', '2024-11-15', 7);

INSERT INTO appointment (date, vehicle_id, customer_id, status) VALUES
('2026-04-01 09:00:00', 1, 1, 'SCHEDULED'),
('2026-04-02 10:30:00', 2, 2, 'SCHEDULED'),
('2026-04-03 11:00:00', 3, 3, 'SCHEDULED'),
('2026-03-15 09:00:00', 4, 4, 'COMPLETED'),
('2026-03-20 14:00:00', 5, 5, 'COMPLETED'),
('2026-04-10 08:30:00', 6, 1, 'SCHEDULED'),
('2026-03-10 16:00:00', 7, 2, 'CANCELLED');

INSERT INTO invoice (amount, service_record_id) VALUES
(285.97, 1),  -- Oil + Air Filter + Engine Oil
(215.00, 2),  -- Front + Rear Brake Pads
(275.00, 3),  -- Timing Belt + Spark Plugs
(159.98, 4),  -- Oil Filter + Engine Oil + Cabin Filter
(375.00, 5),  -- Battery + Wipers
(219.98, 6),  -- Oil Filter + Engine Oil + Air Filter
(65.00,  7);  -- Spark Plugs

INSERT INTO users (username, password, role, email, enabled) VALUES
('mechanic1', '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', 'ROLE_MECHANIC', 'mechanic1@automotive.com', TRUE),
('advisor1',  '$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG', 'ROLE_ADVISOR', 'advisor1@automotive.com',  TRUE);