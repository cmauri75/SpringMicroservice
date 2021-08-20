#!/bin/bash

set -e
set -u

echo "  Creating user and database '$DB_USERNAME'"
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE USER $DB_USERNAME WITH PASSWORD '$DB_PWD';
    CREATE DATABASE $DB_USERNAME;
    GRANT ALL PRIVILEGES ON DATABASE $DB_USERNAME TO $DB_USERNAME;
    GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO $DB_USERNAME;
EOSQL


