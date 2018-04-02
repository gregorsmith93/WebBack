@echo off
SET tomcat_host=localhost
SET tomcat_port=8080
SET tomcat_username=admin
SET tomcat_password=password

SET context_path=web-back

curl --upload-file build\libs\%context_path%.war -s "http://%tomcat_username%:%tomcat_password%@%tomcat_host%:%tomcat_port%/manager/text/deploy?path=/%context_path%&update=true