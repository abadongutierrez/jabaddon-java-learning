# Polymorphism and Alternatives

Chapter 3 of book - Software Architecture with Kotlin

Just wanted to explore how we can do it with Java

## Sonar

```
docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9002:9000 sonarqube:latest
```

```
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=Test \
  -Dsonar.projectName='Test' \
  -Dsonar.host.url=http://localhost:9002 \
  -Dsonar.token=sqp_cb246d3f6b2a4c5fa551418210157ae673da52df
```