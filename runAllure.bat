set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.9.8.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%extendReportV5\*;%ProjectPath%libLog4j\*;%ProjectPath%libraries\*;%ProjectPath%libTestNG\*;%ProjectPath%libWebBrowsers\*;%ProjectPath%extendReportV2\*;%ProjectPath%libaries\*" org.testng.TestNG "%ProjectPath%bin\runFacebook.xml"
pause