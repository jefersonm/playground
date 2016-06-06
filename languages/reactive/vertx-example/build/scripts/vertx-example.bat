@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  vertx-example startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and VERTX_EXAMPLE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windowz variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\vertx-example-1.0-SNAPSHOT.jar;%APP_HOME%\lib\vertx-core-3.2.1.jar;%APP_HOME%\lib\vertx-web-3.2.1.jar;%APP_HOME%\lib\netty-common-4.0.33.Final.jar;%APP_HOME%\lib\netty-buffer-4.0.33.Final.jar;%APP_HOME%\lib\netty-transport-4.0.33.Final.jar;%APP_HOME%\lib\netty-handler-4.0.33.Final.jar;%APP_HOME%\lib\netty-codec-http-4.0.33.Final.jar;%APP_HOME%\lib\jackson-core-2.6.1.jar;%APP_HOME%\lib\jackson-databind-2.6.1.jar;%APP_HOME%\lib\vertx-auth-common-3.2.1.jar;%APP_HOME%\lib\netty-codec-4.0.33.Final.jar;%APP_HOME%\lib\jackson-annotations-2.6.0.jar

@rem Execute vertx-example
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %VERTX_EXAMPLE_OPTS%  -classpath "%CLASSPATH%" helloWorld.HelloWorld %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable VERTX_EXAMPLE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%VERTX_EXAMPLE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
