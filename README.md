# ipDb
This will be an application to run on AWS lambda, function will be get the ip address and analysis it.
The detail need to be add as developing.

Data structure:
1. DynamoDb 
    1. table name: ipDb
    2. structure:
        ```json
        {
        "ipSubnet": "1.1.1",
        "ipLocation": "China, Dalian",
        "hit": "99999",
        "LastHit": "2018/01/01 1:10"
        }    
    
        ```

2. One lambda triggered with IP address as input, the lambda will store the IP subnet (/24) to dynamoDb.
    1. function name: inputIp
    2. input:
        ```array
        106.15.25.132
        114.54.23.116
        123.125.103.82
        139.224.172.121
        140.205.203.107
        140.205.203.108
        140.205.203.93
        163.177.72.156
        255.255.255.255
        ```
    


    