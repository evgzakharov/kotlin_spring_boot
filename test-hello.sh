#!/bin/sh -ex

curl 'http://localhost:8080/hello?name=Vasia&surname=Pupkin' -s | jq .
