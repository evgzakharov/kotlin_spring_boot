#!/bin/sh -ex

curl 'http://localhost:8080/sort?values=5,4,3,123,144' -s | jq .
