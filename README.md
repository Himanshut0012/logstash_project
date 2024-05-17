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
