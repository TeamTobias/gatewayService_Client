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