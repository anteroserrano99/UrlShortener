-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler version: 0.9.4
-- PostgreSQL version: 13.0
-- Project Site: pgmodeler.io
-- Model Author: ---

-- Database creation must be performed outside a multi lined SQL file. 
-- These commands were put in this file only as a convenience.
-- 
-- object: new_database | type: DATABASE --
-- DROP DATABASE IF EXISTS new_database;
--CREATE USER docker;
--CREATE DATABASE docker;
GRANT ALL PRIVILEGES ON DATABASE docker TO docker;

-- ddl-end --


-- object: "URL_SHORTENER" | type: SCHEMA --
-- DROP SCHEMA IF EXISTS "URL_SHORTENER" CASCADE;
CREATE SCHEMA "URL_SHORTENER";
-- ddl-end --
ALTER SCHEMA "URL_SHORTENER" OWNER TO docker;
-- ddl-end --

SET search_path TO pg_catalog,public,"URL_SHORTENER";
-- ddl-end --

-- object: "URL_SHORTENER"."URL" | type: TABLE --
-- DROP TABLE IF EXISTS "URL_SHORTENER"."URL" CASCADE;
CREATE TABLE "URL_SHORTENER"."URL" (
	"ID" integer NOT NULL GENERATED ALWAYS AS IDENTITY ,
	"SHORT_URL" varchar(100),
	"LONG_URL" varchar(100)

);
-- ddl-end --
ALTER TABLE "URL_SHORTENER"."URL" OWNER TO docker;
-- ddl-end --


