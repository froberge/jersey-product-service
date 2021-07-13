FROM tomcat:jdk11-adoptopenjdk-hotspot
LABEL maintainer="froberge@redhat.com"

# Add the context.xml file
ADD dependencies/. /usr/local/tomcat/lib/
ADD target/productservice.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]