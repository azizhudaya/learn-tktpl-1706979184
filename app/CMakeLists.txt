cmake_minimum_required(VERSION 3.10.2)

project("learntktpl")

add_library(lab6-1706979184
       SHARED
       src/main/cpp/lab6-1706979184.cpp)

find_library(
        log-lib
        log )

target_link_libraries(
        lab6-1706979184
        ${log-lib} )