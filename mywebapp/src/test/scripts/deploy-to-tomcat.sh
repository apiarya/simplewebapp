#!/bin/bash
home_dir=`pwd`
echo "home_dir=$home_dir"

tomcat_host=localhost
tomcat_port=8080
tomcat_login=admin:password
app_context=mywebapp

echo "Firing1: curl -v -u $tomcat_login http://$homcat_host:$tomcat_port/manager/html"
curl -vI -u $tomcat_login http://$homcat_host:$tomcat_port/manager/html

echo "firing2: curl -v -u $tomcat_login http://$homcat_host:$tomcat_port/manager/undeploy?path=/$app_context"
curl -v -u $tomcat_login http://$homcat_host:$tomcat_port/manager/undeploy?path=/$app_context

echo "Firing3: curl -v -u $tomcat_login http://$homcat_host:$tomcat_port/manager/html/upload --form deployWar=@$home_dir/target/mywebapp.war"
curl -v -u $tomcat_login http://$homcat_host:$tomcat_port/manager/html/upload --form deployWar=@$home_dir/target/mywebapp.war

