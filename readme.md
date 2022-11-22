```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '2.7.5'
    id 'io.spring.dependency-management' version '1.0.15.RELEASE'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '17'

repositories {
    mavenCentral()
}

ext {
    set('springCloudVersion', "2021.0.5")
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-webflux'
    implementation 'org.springframework.cloud:spring-cloud-starter-gateway'
    implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-client'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'io.projectreactor:reactor-test'
    implementation 'org.springframework.boot:spring-boot-starter-actuator'
}

dependencyManagement {
    imports {
        mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
    }
}

tasks.named('test') {
    useJUnitPlatform()
}

```

- ``spring-boot-starter-webflux``: 스트링 부트에서 제공하는 웹플럭스를 사용하기 위한 의존성
- ``spring-cloud-starter-gateway``: 스프링 클라우드에서 제공하는 게이트웨이를 사용하기 위한 의존성
- ``spring-cloud-starter-netflix-eureka-client``: 스프링 클라우드에서 제공하는 Eureka 클라이언트를 사용하기 위한 의존성
- ``spring-boot-devtools``: 스프링 부트에서 제공하는 개발자 도구를 사용하기 위한 의존성
- ``spring-boot-starter-test``: 스프링 부트에서 제공하는 테스트를 사용하기 위한 의존성
- ``reactor-test``: 리액터에서 제공하는 테스트를 사용하기 위한 의존성
- ``spring-boot-starter-actuator``: 스프링 부트에서 제공하는 액추에이터를 사용하기 위한 의존성
- ``spring-cloud-dependencies``: 스프링 클라우드에서 제공하는 의존성 관리를 사용하기 위한 의존성

<br/>

## 2.2. application.yml

```yaml
server:
  port: 80

eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8761/eureka




spring:
  application:
    name: gatewayService_Client
  cloud:
    gateway:
      routes:
        - id: client-login-service
          uri: lb://client-login-service
          predicates:
            - Path=/client-login-service/**
        - id: client-service
          uri: lb://client-service
          predicates:
            - Path=/client-service/**
        - id: coupon-service
          uri: lb://coupon-service
          predicates:
            - Path=/coupon-service/**
        - id: point-service
          uri: lb://point-service
          predicates:
            - Path=/point-service/**
        - id: basket-service
          uri: lb://basket-service
          predicates:
            - Path=/basket-service/**
        - id: recently-viewed-service
          uri: lb://recently-viewed-service
          predicates:
            - Path=/recently-viewed-service/**
        - id: review-cud-service
          uri: lb://review-cud-service
          predicates:
            - Path=/review-cud-service/**
        - id: review-read-service
          uri: lb://review-read-service
          predicates:
            - Path=/review-read-service/**
        - id: product-cud-service
          uri: lb://product-cud-service
          predicates:
            - Path=/product-cud-service/**
        - id: product-read-service
          uri: lb://product-read-service
          predicates:
            - Path=/product-read-service/**
        - id: delivery-service
          uri: lb://delivery-service
          predicates:
            - Path=/delivery-service/**
        - id: order-service
          uri: lb://order-service
          predicates:
            - Path=/order-service/**
      discovery:
        locator:
          enabled: true
          lower-case-service-id: true


management:
  endpoints:
    web:
    exposure:
      include: "*"
  endpoint:
    health:
    show-details: always
```

- ``server.port``: 서버 포트를 80으로 설정
- ``eureka.instance.hostname``: Eureka 서버의 호스트 이름을 localhost로 설정
- ``eureka.client.register-with-eureka``: Eureka 서버에 등록할지 여부를 true로 설정
- ``eureka.client.fetch-registry``: Eureka 서버에서 레지스트리를 가져올지 여부를 true로 설정
- ``eureka.client.service-url.defaultZone``: Eureka 서버의 기본 URL을 설정
- ``spring.application.name``: 스프링 애플리케이션 이름을 gatewayService_Client로 설정
- ``spring.cloud.gateway.routes``: 라우팅 정보를 설정
- ``spring.cloud.gateway.discovery.locator.enabled``: 서비스 디스커버리를 사용할지 여부를 true로 설정
- ``spring.cloud.gateway.discovery.locator.lower-case-service-id``: 서비스 디스커버리에서 가져온 서비스 ID를 소문자로 설정할지 여부를 true로 설정
- ``management.endpoints.web.exposure.include``: 액추에이터의 모든 엔드포인트를 노출
- ``management.endpoint.health.show-details``: 액추에이터의 헬스 엔드포인트에서 상세 정보를 노출
