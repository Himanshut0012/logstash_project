# logstash_project
- In this project, I will guide you through the process of setting up a centralized logging solution using the ELK(Elasticsearch, Logstash, Kibana) stack on your local machine and also guide in configurations by setting up the ELK stack locally.

### What is ELK?
<sub>ELK is an acronym that stands for Elasticsearch, Logstash, and Kibana. It is a powerful open-source software stack used for centralized logging, log analysis, and visualization. Each component of ELK serves a specific purpose:</sub>

- **Elasticsearch:** It is a distributed search and analytics engine that stores and indexes data. Elasticsearch allows for fast and efficient searching, aggregating, and analyzing of large volumes of data.

- **Logstash:** It is a data processing pipeline that ingests, filters, and transforms data from various sources before sending it to Elasticsearch for indexing. Logstash can handle different types of data, such as logs, metrics, and other event data.

- **Kibana:** It is a web-based data visualization and exploration tool that works in conjunction with Elasticsearch. Kibana provides a user-friendly interface for searching, analyzing, and visualizing data stored in Elasticsearch. It offers various visualizations, dashboards, and tools to help gain insights from the data.

  Together, these three components form the ELK stack, which is widely used for log management, monitoring, and troubleshooting in various applications and systems.
  
![1_gg4lsZCO1QQbhpV7DsP8vA](https://github.com/Himanshut0012/logstash_project/assets/89704266/efd43ef3-255d-4be6-ba2c-d37f6942b660)
### 1. Build Springboot Application
- Download this springboot project and basic logs created for each request.

### 2. Set up Elastic Search
- [Download](https://www.elastic.co/downloads/elasticsearch) as per your system and unzip Elasticsearch. In my case downloading for mac.
- After unzip go inside bin folder and run elasticsearch executabke file in command or double press on that, start installing autometically.
- Scroll down a bit, you can see the Elasticsearch security features have been automatically configured! message on the CMD output.
- here is password <img width="686" alt="Screenshot 2024-05-18 at 12 10 49 AM" src="https://github.com/Himanshut0012/logstash_project/assets/89704266/726fdb0c-05cd-41ae-9b34-f03145943a36">

- here is security token, we use both in kibana configuration for connecting with elastic.<img width="1195" alt="Screenshot 2024-05-18 at 12 10 57 AM" src="https://github.com/Himanshut0012/logstash_project/assets/89704266/d4b18235-df4c-43a3-b006-8e16adf836e3">
- To check the status of the Elasticsearch cluster connection, hit https://localhost:9200/ on your browser and provide the Username as “elastic” and use the password above one. Then you see <img width="1280" alt="Screenshot 2024-05-16 at 11 10 34 PM" src="https://github.com/Himanshut0012/logstash_project/assets/89704266/19869003-d416-48b2-b07f-52da02978258"> 

### 3. Set up Kibana
- [Download](https://www.elastic.co/downloads/kibana) as per your system and unzip Kibana. In my case downloading for mac.
-  After unzip go inside bin folder and run Kibana executabke file in command or double press on that, start installing autometically.
- after installing you will see <img width="1110" alt="Screenshot 2024-05-18 at 12 23 54 AM" src="https://github.com/Himanshut0012/logstash_project/assets/89704266/d5068904-80a2-4068-9308-48048f1be48e"> now open this link.
- Provide the Enrollment token which is generated in elasticsearch 
<img width="1239" alt="Screenshot 2024-05-18 at 12 27 14 AM" src="https://github.com/Himanshut0012/logstash_project/assets/89704266/7007b6f7-5cb3-4126-b756-ca60b50b480c"> Click Configure Elastic.

### 4. Set up Logstash
- [Download](https://www.elastic.co/downloads/logstash) as per your system and unzip Kibana. In my case downloading for mac.
- Open the logstash-sample.conf & replace the input & output plugins as mentioned below.

```
# Sample Logstash configuration for creating a simple
# Beats -> Logstash -> Elasticsearch pipeline.

input {
  file {
    path => "<Log File Full Path>"
    start_position => "beginning"
  }
}

output {
 stdout {
    codec => rubydebug
  }
  elasticsearch {
    hosts => ["https://localhost:9200"]
    ssl_certificate_verification => false
    ssl => true
    index => "elkdemoindex"
    user => "elastic"
    password => "<Elastic Search Password>"
  }
}
```
- Replace the <Log File Full Path> with your log file location. (Make sure to use forward slashes).
- Replace <Elastic Search Password> with the password, you saved in “Set up Elastic Search”
- Go to the logstrash bin folder and run below command.
  ```
  ./logstash -f ../config/logstash-sample.conf
  ```

- After runing above commandn now you can see on terminal json format <img width="1280" alt="Screenshot 2024-05-17 at 12 23 19 AM" src="https://github.com/Himanshut0012/logstash_project/assets/89704266/870cd915-8508-42e8-9f62-628ac544ec2c">
#### All thing successfully installed, now see logs and managing logs using ELK.

## Configure Kibana Dashboard for managing logs
- Go to http://localhost:5601/
- Click the burger button on the left side and go to _Management > Stack Management_
- Inside the Management portal, go to _Data > Index Management_, if the Logstash to Elastic search connection working properly you should get the _elkdemoindex_ value on the indices list. <img width="1280" alt="Screenshot 2024-05-18 at 12 52 21 AM" src="https://github.com/Himanshut0012/logstash_project/assets/89704266/77c714f8-9f49-421e-aff7-f9874bde62bf"> like this.
-  Again click the burger button on the left side and go to _Analytics > Discover_, here you can discover your logs <img width="1280" alt="Screenshot 2024-05-18 at 12 54 11 AM" src="https://github.com/Himanshut0012/logstash_project/assets/89704266/31c666cd-d589-4527-a8d4-4a47c58d3cee 'this is primary blog https://medium.com/cloud-native-daily/elk-spring-boot-a-guide-to-local-configuration-b6d9fa7790f6'" >

#### Congratulations! Now you are successfully configured ELK + Spring boot stack on your local.
