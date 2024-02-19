-- ********************************************************************************
-- This script creates the database users for the Aviation Management System
-- and grants them the necessary permissions
-- ********************************************************************************

CREATE USER aviation_management_owner
WITH PASSWORD 'MohamedAbdi';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO aviation_management_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO aviation_management_owner;

CREATE USER aviation_management_appuser
WITH PASSWORD 'MohamedAbdi';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO aviation_management_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO aviation_management_appuser;
