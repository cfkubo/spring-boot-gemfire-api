#!/bin/bash

BASE_URL="http://localhost:8881/api"

echo "Attempting to read all values by iterating through known keys (1 to 1000)..."
echo "------------------------------------------------------------------------"

for i in {1..1000} ; do
    KEY="myKeyarul$i"
    # Execute the curl command to get the value for the current key
    RESPONSE=$(curl -s "$BASE_URL/get?key=$KEY")

    # Print the key and the value retrieved
    echo "Key: $KEY, Value: $RESPONSE"
done

echo "------------------------------------------------------------------------"
echo "Finished reading all values."