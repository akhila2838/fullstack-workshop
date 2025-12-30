#!/bin/bash

set -e

# Analyze log file for errors
LOG_FILE=${1:-"C:\Users\DELL\Desktop\Sample-log\sample.txt"}

#validate file existence
if [ ! -f "$LOG_FILE" ]; then
    echo "Error: Log file not found: $LOG_FILE"
    exit 1
fi

echo "====== Log Analysis Report ======="
echo "File: $LOG_FILE"
echo ""

#total lines
total_lines=$(awk 'END {print NR}' "$LOG_FILE")
echo "Total Lines: $total_lines"
echo "-------------------------------"

#log levels
echo "INFO: $(grep -c 'INFO' "$LOG_FILE")"
echo "ERROR: $(grep -c  'ERROR' "$LOG_FILE")"
echo "WARNING: $(grep -c  'WARNING' "$LOG_FILE")"

echo ""
echo "--------------------------------"

#extract unique IPs.
IP_LIST=$(grep -oE '[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}' "$LOG_FILE" | sort | uniq)

echo "Unique IP Addresses Found:"
for ip in $IP_LIST;
do 
	echo " -$ip"
done

echo "==================================="



cd