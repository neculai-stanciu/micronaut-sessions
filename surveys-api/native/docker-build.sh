#!/bin/sh
docker build ../ --file ./Dockerfile -t surveysapi
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8080:8080 surveysapi"
