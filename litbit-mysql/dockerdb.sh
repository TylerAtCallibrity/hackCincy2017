#!/bin/bash

    docker run --name dump -p 3307:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql
    docker exec -i dump mysql -uroot -proot < data.sql
