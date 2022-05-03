;              
CREATE USER IF NOT EXISTS "SA" SALT '3e7c293939c7ab17' HASH 'f1e7474f8892c79463ad2718d4b677aae7d51e6336da198e954ebf605cc3718d' ADMIN;          
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_BA0C446C_D955_466E_BE2C_21A002BAD234" START WITH 1 BELONGS_TO_TABLE; 
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_BBF31D5F_E7AF_415B_A298_7139C970F56B" START WITH 80 BELONGS_TO_TABLE;
CREATE CACHED TABLE "PUBLIC"."INVOLVEMENT"(
    "ID" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_BA0C446C_D955_466E_BE2C_21A002BAD234" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_BA0C446C_D955_466E_BE2C_21A002BAD234",
    "AGREE_TO_TERMS" BOOLEAN NOT NULL,
    "NAME" VARCHAR(255) NOT NULL
);               
ALTER TABLE "PUBLIC"."INVOLVEMENT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_C" PRIMARY KEY("ID");   
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.INVOLVEMENT;              
CREATE CACHED TABLE "PUBLIC"."INVOLVEMENT_SECTOR_LIST"(
    "INVOLVEMENT_ID" BIGINT NOT NULL,
    "SECTOR_LIST_ID" BIGINT NOT NULL
);          
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.INVOLVEMENT_SECTOR_LIST;  
CREATE CACHED TABLE "PUBLIC"."SECTOR"(
    "ID" BIGINT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_BBF31D5F_E7AF_415B_A298_7139C970F56B" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_BBF31D5F_E7AF_415B_A298_7139C970F56B",
    "NAME" VARCHAR(255) NOT NULL,
    "PARENT_ID" BIGINT
);   
ALTER TABLE "PUBLIC"."SECTOR" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9" PRIMARY KEY("ID");        
-- 79 +/- SELECT COUNT(*) FROM PUBLIC.SECTOR;  
INSERT INTO "PUBLIC"."SECTOR" VALUES
(1, 'Manufacturing', NULL),
(2, 'Construction materials', 1),
(3, 'Electronics and Optics', 1),
(4, 'Food and Beverage', 1),
(5, 'Bakery & confectionery products', 4),
(6, 'Beverages', 4),
(7, 'Fish & fish products', 4),
(8, 'Meat & meat products', 4),
(9, 'Milk & dairy products', 4),
(10, 'Other', 4),
(11, 'Sweets & snack food', 4),
(12, 'Furniture', 1),
(13, 'Bathroom/sauna', 12),
(14, 'Bedroom', 12),
(15, 'Children''s room', 12),
(16, 'Kitchen', 12),
(17, 'Living room', 12),
(18, 'Office', 12),
(19, 'Other (Furniture)', 12),
(20, 'Outdoor', 12),
(21, 'Project furniture', 12),
(22, 'Machinery', 1),
(23, 'Machinery components', 22),
(24, 'Machinery equipment/tools', 22),
(25, 'Manufacture of machinery', 22),
(26, 'Maritime', 22),
(27, 'Aluminium and steel workboats', 26),
(28, 'Boat/Yacht building', 26),
(29, 'Ship repair and conversion', 26),
(30, 'Metal structures', 22),
(31, 'Other', 22),
(32, 'Repair and maintenance service', 22),
(33, 'Metalworking', 1),
(34, 'Construction of metal structures', 33),
(35, 'Houses and buildings', 33),
(36, 'Metal products', 33),
(37, 'Metal works', 33),
(38, 'CNC-machining', 37),
(39, 'Forgings, Fasteners', 37),
(40, 'Gas, Plasma, Laser cutting', 37),
(41, 'MIG, TIG, Aluminum welding', 37),
(42, 'Plastic and Rubber', 1),
(43, 'Packaging', 42),
(44, 'Plastic goods', 42),
(45, 'Plastic processing technology', 42),
(46, 'Blowing', 45),
(47, 'Moulding', 45),
(48, 'Plastics welding and processing', 45),
(49, 'Plastic profiles', 42),
(50, 'Printing', 1),
(51, 'Advertising', 50),
(52, 'Book/Periodicals printing', 50),
(53, 'Labelling and packaging printing', 50),
(54, 'Textile and Clothing', 1),
(55, 'Clothing', 54),
(56, 'Textile', 54),
(57, 'Wood', 1),
(58, 'Other (Wood)', 57),
(59, 'Wooden building materials', 57),
(60, 'Wooden houses', 57),
(61, 'Service', NULL),
(62, 'Business services', 61),
(63, 'Engineering', 61),
(64, 'Information Technology and Telecommunications', 61),
(65, 'Data processing, Web portals, E-marketing', 64),
(66, 'Programming, Consultancy', 64),
(67, 'Software, Hardware', 64),
(68, 'Telecommunications', 64),
(69, 'Tourism', 61),
(70, 'Translation services', 61),
(71, 'Transport and Logistics', 61),
(72, 'Air', 71),
(73, 'Rail', 71),
(74, 'Road', 71),
(75, 'Water', 71),
(76, 'Other', NULL),
(77, 'Creative industries', 76),
(78, 'Energy technology', 76),
(79, 'Environment', 76);    
CREATE CACHED TABLE "PUBLIC"."SECTOR_INVOLVEMENT_LIST"(
    "SECTOR_ID" BIGINT NOT NULL,
    "INVOLVEMENT_LIST_ID" BIGINT NOT NULL
);          
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.SECTOR_INVOLVEMENT_LIST;  
ALTER TABLE "PUBLIC"."SECTOR_INVOLVEMENT_LIST" ADD CONSTRAINT "PUBLIC"."FK5UUP9DD1FUTQKFK2F8UA4BRQC" FOREIGN KEY("INVOLVEMENT_LIST_ID") REFERENCES "PUBLIC"."INVOLVEMENT"("ID") NOCHECK;       
ALTER TABLE "PUBLIC"."INVOLVEMENT_SECTOR_LIST" ADD CONSTRAINT "PUBLIC"."FK27P0S5JGA8HT2PNE8CEBVPO8U" FOREIGN KEY("SECTOR_LIST_ID") REFERENCES "PUBLIC"."SECTOR"("ID") NOCHECK; 
ALTER TABLE "PUBLIC"."SECTOR" ADD CONSTRAINT "PUBLIC"."FKN6JFOE213MLNAFOAIAOLVH5C8" FOREIGN KEY("PARENT_ID") REFERENCES "PUBLIC"."SECTOR"("ID") NOCHECK;       
ALTER TABLE "PUBLIC"."SECTOR_INVOLVEMENT_LIST" ADD CONSTRAINT "PUBLIC"."FKIAXN1E4JRYNVTGUWQ4QCFPX7G" FOREIGN KEY("SECTOR_ID") REFERENCES "PUBLIC"."SECTOR"("ID") NOCHECK;      
ALTER TABLE "PUBLIC"."INVOLVEMENT_SECTOR_LIST" ADD CONSTRAINT "PUBLIC"."FKT7NISAX55NQY5L3GU0X7HGL1A" FOREIGN KEY("INVOLVEMENT_ID") REFERENCES "PUBLIC"."INVOLVEMENT"("ID") NOCHECK;            
