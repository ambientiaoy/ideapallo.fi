FROM java:8
MAINTAINER Aki Salmi <aki.salmi@ambientia.fi>

MKDIR /www/sites/ideapallo_1
COPY ../ideapallo/target/ideapallo.war /ideapallo.war

CD /www/sites/ideapallo_1
CMD [ "jar", "-xvf", "/ideapallo.war" ]
