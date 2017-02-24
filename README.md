# beautycarbar

## Install
* JDk 1.7
* MySQL 5
* Tomcat 7+
* Git 1.9+

## Build
1. Enter {workdir}.
2. Run command 'git clone https://github.com/qingfeng0820/beautycarebar.git'.
3. Enter {workdir}/beautycarebar, which is your workspace.
3. Run command './gradlew build'.
4. Built jar of bcb-core is located in {workdir}/beautycarebar/bcb-core/build/libs.
5. Built bcb-interfaces.war of bcb-interfaces is located in {workdir}/beautycarebar/bcb-interfaces/build/libs.

## Deploy
1. Start MySQL on port 3306, and create a database 'bcb'.
2. Run command './gradlew generateSchema' under {workdir}/beautycarebar.
3. You can get schema script bcb.sql under {workdir}/beautycarebar/bcb-interfaces/build/schema.
4. Import bcb.sql to database 'bcb'.
5. Copy bcb-interfaces.war under {workdir}/beautycarebar/bcb-interfaces/build/libs to tomcat webapps folder.
6. Set variable'spring.profiles.active' to 'develop' in your system environment or start tomcat with JVM argument -Dspring.profiles.active=develop.
7. Start tomcat on 8080, and try to visit http://localhost:8080/bcb-interfaces/hello.

## Set up develop environment
1. Enter {workdir}/beautycarebar, run command './gradlew build' if you use Intellij or './gradleEclipse' if you use Eclipse.
2. Install plugin lombok for your IDE (Please refer https://projectlombok.org/download.html).
3. Import your workspace to your IDE (import as gradle project if you use Intellij).

## Feature development
1. Develop entity and repositroy under bcb-core/src/main/java/com/shm/bcb/entity of your workspace
2. Develop service and pojo under bcb-core/src/main/java/com/shm/bcb/service
3. Develop rest controller under bcb-interfaces/src/main/java/com/shm/bcb/service/api if you want to export as rest api
4. Develop web controller under bcb-interfaces/src/main/java/com/shm/bcb/service/web and web page (*.hbs) under bcb-interfaces/src/main/webapp/WEB-INF/views, if you want to export a web page.
5. Please take 'Hello' as example
