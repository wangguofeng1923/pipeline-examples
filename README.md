# pipeline simple examples

This project contains one pipe demo (helloWorld)!

please build this project and install the plugin in jenkins.
after that you can use this plugin in pipeline as:
def result=helloWorld (name:"wangguofeng");
echo result.greeting

result=helloWorld (name:"wangguofeng",age:30);
echo result.greeting