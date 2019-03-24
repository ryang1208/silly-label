#!/bin/bash

set -o errexit
set -o nounset

clientPath="$(dirname ${BASH_SOURCE[0]})/../../client"

diff=$(${clientPath}/node_modules/.bin/tsc 2>&1 || true)
rm -rf "${clientPath}/.tmp/"
if [[ -n "${diff}" ]]; then
  echo "${diff}"
  exit 1
fi
