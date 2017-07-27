import	AssemblyKeys._	
assemblySettings	

name	:=	"hello-world-sbt"	
	
version	:=	"1.0"	
	
scalaVersion	:=	"2.12.2"	
scalaVersion	in	ThisBuild	:=	"2.12.2"	

libraryDependencies += "junit" % "junit" % "4.12" % Test
libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")

enablePlugins(JavaAppPackaging)
