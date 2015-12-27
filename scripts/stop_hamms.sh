#!/bin/bash
ps ax | grep -i 'hamms' | grep -v grep | awk '{print $1}' | xargs kill -SIGTERM
