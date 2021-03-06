SET SESSION sql_mode = 'ANSI_QUOTES';
--
-- Database: "trainbenchmark"
--

-- 512 Mb
SET max_heap_table_size=536870912;

DROP DATABASE IF EXISTS "trainbenchmark";
CREATE DATABASE "trainbenchmark";
USE "trainbenchmark";

START TRANSACTION;
-- --------------------------------------------------------

--
-- Table structure: "Route"
--

CREATE TABLE IF NOT EXISTS "Route" (
  "id" int NOT NULL AUTO_INCREMENT,
  "entry" int,
  "exit" int,
  PRIMARY KEY  ("id")
) DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ENGINE=MEMORY;

-- --------------------------------------------------------

--
-- Table structure: "Region"
--

CREATE TABLE IF NOT EXISTS "Region" (
  "id" int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY  ("id")
) DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ENGINE=MEMORY;

-- --------------------------------------------------------

--
-- Table structure: "Segment"
--

CREATE TABLE IF NOT EXISTS "Segment" (
  "id" int NOT NULL AUTO_INCREMENT,
  "length" int NOT NULL DEFAULT 1,
  PRIMARY KEY  ("id")
) DEFAULT CHARSET=utf8 ENGINE=MEMORY;

-- --------------------------------------------------------
--
-- Table structure: "Sensor"
--

CREATE TABLE IF NOT EXISTS "Sensor" (
  "id" int NOT NULL AUTO_INCREMENT,
  "route" int, -- inverse of the "gathers" edge
  "region" int NOT NULL, -- inverse of the "sensors" edge
  PRIMARY KEY  ("id")
) DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ENGINE=MEMORY;

-- --------------------------------------------------------

--
-- Table structure: "Semaphore"
--

CREATE TABLE IF NOT EXISTS "Semaphore" (
  "id" int NOT NULL AUTO_INCREMENT,
  "segment" int NOT NULL, -- inverse of the "semaphores" edge
  "signal" int NOT NULL,
  PRIMARY KEY  ("id")
) DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ENGINE=MEMORY;

-- --------------------------------------------------------


--
-- Table structure: "Switch"
--

CREATE TABLE IF NOT EXISTS "Switch" (
  "id" int NOT NULL AUTO_INCREMENT,
  "currentPosition" int NOT NULL,
  PRIMARY KEY  ("id")
) DEFAULT CHARSET=utf8 ENGINE=MEMORY;

-- --------------------------------------------------------

--
-- Table structure: "SwitchPosition"
--

CREATE TABLE IF NOT EXISTS "SwitchPosition" (
  "id" int NOT NULL AUTO_INCREMENT,
  "route" int, -- inverse of the "follows" edge
  "target" int,
  "position" int NOT NULL,
  PRIMARY KEY  ("id")
) DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ENGINE=MEMORY;

-- --------------------------------------------------------

--
-- Table structure: "TrackElement"
--

CREATE TABLE IF NOT EXISTS "TrackElement" (
  "id" int NOT NULL AUTO_INCREMENT,
  "region" int NOT NULL, -- inverse of the "elements" edge
  PRIMARY KEY  ("id")
) DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ENGINE=MEMORY;

-- --------------------------------------------------------

--
-- Table structure: "TrackElement_connectsTo"
--

CREATE TABLE IF NOT EXISTS "connectsTo" (
  "TrackElement1_id" int NOT NULL,
  "TrackElement2_id" int NOT NULL,
  PRIMARY KEY  ("TrackElement1_id", "TrackElement2_id")
) DEFAULT CHARSET=utf8 ENGINE=MEMORY;

-- --------------------------------------------------------

--
-- Table structure: "TrackElement_monitoredBy"
--

CREATE TABLE IF NOT EXISTS "monitoredBy" (
  "TrackElement_id" int NOT NULL,
  "Sensor_id" int NOT NULL,
  PRIMARY KEY  ("TrackElement_id", "Sensor_id")
) DEFAULT CHARSET=utf8 ENGINE=MEMORY;
INSERT INTO "Region" ("id") VALUES (1);
INSERT INTO "TrackElement" ("id") VALUES (2);
INSERT INTO "Segment" ("id") VALUES (2);
UPDATE "TrackElement" SET "region" = 1 WHERE "id" = 2;
INSERT INTO "Semaphore" ("id", "signal") VALUES (3, 2);
UPDATE "Semaphore" SET "segment" = 2 WHERE "id" = 3;
INSERT INTO "Route" ("id", "entry") VALUES (4, 3);
INSERT INTO "TrackElement" ("id") VALUES (5);
INSERT INTO "Switch" ("id", "currentPosition") VALUES (5, 2);
UPDATE "TrackElement" SET "region" = 1 WHERE "id" = 5;
INSERT INTO "SwitchPosition" ("id", "position", "target") VALUES (6, 1, 5);
UPDATE "SwitchPosition" SET "route" = 4 WHERE "id" = 6;

COMMIT;
CREATE INDEX segment_length_idx ON "Segment" ("length");
CREATE INDEX monitoredBy_idx ON "monitoredBy" ("Sensor_id", "TrackElement_id");
CREATE INDEX connectsTo_idx1 ON "connectsTo" ("TrackElement1_id");
CREATE INDEX connectsTo_idx2 ON "connectsTo" ("TrackElement2_id");
