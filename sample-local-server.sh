#!/bin/sh

# Usage:
# copy this script to "local-server.sh" so your username/password
# are out of git's version control:
# cp sample-local-server.sh local-server.sh

# change schemaverse_user and schemaverse_password to match
# your schemaverse.com credentials
USER=username
PASS=password

export DATABASE_URL=postgres://${USER}:${PASS}@db.schemaverse.com/schemaverse

lein run
