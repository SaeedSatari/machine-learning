# `machine-learning-service` Repository

[![pipeline status](https://gitlab.com/johnjvester/machine-learning-service/badges/master/pipeline.svg)](https://gitlab.com/johnjvester/machine-learning-service/commits/master)


> The `machine-learning-service` repository is a [Spring Boot](https://spring.io/projects/spring-boot) RESTful API service 
> which employs the [Deep Java Library](https://djl.ai/) framework in order to classify images provided via a standard 
> POST request.  This example attempts to classify a limited type of animal (`CAT`, `DOG`, `ELEPHANT`, `LION` or `ZEBRA`) 
> and any other classification found will be listed as `UNKNOWN`.

## Publications

This repository is related to a DZone.com publication:

* TBD

To read more of my publications, please review one of the following URLs:

* https://dzone.com/users/1224939/johnjvester.html
* https://johnjvester.gitlab.io/dZoneStatistics/WebContent/#/stats?id=1224939

## Starting the `machine-learning-service` Repository

Simply run the Spring Boot service by using the instructions listed below:

https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-running-your-application.html

Once started, the following console information should appear:

```shell

                             dP       oo
                             88
88d8b.d8b. .d8888b. .d8888b. 88d888b. dP 88d888b. .d8888b.
88'`88'`88 88'  `88 88'  `"" 88'  `88 88 88'  `88 88ooood8
88  88  88 88.  .88 88.  ... 88    88 88 88    88 88.  ...
dP  dP  dP `88888P8 `88888P' dP    dP dP dP    dP `88888P'


dP                                     oo
88
88 .d8888b. .d8888b. 88d888b. 88d888b. dP 88d888b. .d8888b.
88 88ooood8 88'  `88 88'  `88 88'  `88 88 88'  `88 88'  `88
88 88.  ... 88.  .88 88       88    88 88 88    88 88.  .88
dP `88888P' `88888P8 dP       dP    dP dP dP    dP `8888P88
                                                        .88
                                                    d8888P
                                    oo

.d8888b. .d8888b. 88d888b. dP   .dP dP .d8888b. .d8888b.
Y8ooooo. 88ooood8 88'  `88 88   d8' 88 88'  `"" 88ooood8
      88 88.  ... 88       88 .88'  88 88.  ... 88.  ...
`88888P' `88888P' dP       8888P'   dP `88888P' `88888P'


:: machine-learning-service :: Running Spring Boot 2.6.2 :: Port #8585 ::

2022-01-02 12:25:33.223  INFO 16498 --- [           main] .g.j.m.MachineLearningServiceApplication : Starting MachineLearningServiceApplication using Java 11.0.11 on john-112.lan with PID 16498
2022-01-02 12:25:33.225  INFO 16498 --- [           main] .g.j.m.MachineLearningServiceApplication : No active profile set, falling back to default profiles: default
2022-01-02 12:25:33.755  INFO 16498 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8585 (http)
2022-01-02 12:25:33.760  INFO 16498 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-01-02 12:25:33.760  INFO 16498 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.56]
2022-01-02 12:25:33.812  INFO 16498 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-01-02 12:25:33.812  INFO 16498 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 559 ms
2022-01-02 12:25:33.847  INFO 16498 --- [           main] c.g.j.mls.configs.CriteriaConfig         : Establishing Criteria<Image, Classifications>
2022-01-02 12:25:33.852  INFO 16498 --- [           main] c.g.j.mls.configs.CriteriaConfig         : Service will utilize criteria=Criteria:
	Application: CV.IMAGE_CLASSIFICATION
	Input: interface ai.djl.modality.cv.Image
	Output: class ai.djl.modality.Classifications
	Filter: {"layers":"50"}

2022-01-02 12:25:34.066  INFO 16498 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8585 (http) with context path ''
2022-01-02 12:25:34.075  INFO 16498 --- [           main] .g.j.m.MachineLearningServiceApplication : Started MachineLearningServiceApplication in 1.123 seconds (JVM running for 1.574)
```

## Using the `machine-learning-service` Repository

With the service running (on default port 8585), run the following cURL command from the `samples` folder in this 
repository:

```shell
curl --location --request POST 'http://localhost:8585/classify' \
--form 'file=@"./cat.jpg"'
```

The `machine-learning-service` will respond with the following `INFO` logs:

```shell
Loading:     100% |████████████████████████████████████████|
[12:25:43] ../src/nnvm/legacy_json_util.cc:209: Loading symbol saved by previous version v1.6.0. Attempting to upgrade...
[12:25:43] ../src/nnvm/legacy_json_util.cc:217: Symbol successfully upgraded!
2022-01-02 12:25:44.769  INFO 16498 --- [nio-8585-exec-2] c.g.j.m.services.ClassificationService   : classificationDTO=ClassificationDTO(fileName=cat.jpg, value=n02123045 tabby, tabby cat, probability=8.376285552978516, type=CAT)
```

Using the `cat.jpg` image, the `machine-learning-service` correctly classified the image as a feline (cat) and returned 
a `202 Accepted` status code along the following `ClassificationDTO` JSON payload response:

```json
{
    "fileName": "cat.jpg",
    "value": "n02123045 tabby, tabby cat",
    "probability": 8.376285552978516,
    "type": "CAT"
}
```

## Additional Information

Please review the `/samples/sample-curl-commands.sh` file for more commands which can be executed against the stock images provided in
this repository.

The default log level can be changed from `INFO` to `DEBUG` by updating the `application.yml` file.

Made with <span style="color:red;">♥</span> &nbsp;by johnjvester@gmail.com, because I enjoy writing code.