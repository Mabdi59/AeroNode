-- **************************************************************
-- This script destroys the database and associated users for the Aviation Management System
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'aviation_management_system';

DROP DATABASE aviation_management_system;

DROP USER aviation_management_owner;
DROP USER aviation_management_appuser;
