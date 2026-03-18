@echo off
setlocal

set JAVA_HOME=C:\Program Files\Java\jdk-21
set MAVEN_HOME=C:\Users\sivag\.maven\maven-3.9.12
set PROJECT_DIR=%~dp0

REM Compile the project
echo Compiling project...
call %MAVEN_HOME%\bin\mvn.cmd clean compile -q
if errorlevel 1 (
    echo Build failed!
    exit /b 1
)

REM Copy dependencies
echo Copying dependencies...
call %MAVEN_HOME%\bin\mvn.cmd dependency:copy-dependencies -q

REM Run XML Configuration Example
echo.
echo ========== Running XML Configuration Example ==========
echo.
"%JAVA_HOME%\bin\java.exe" -cp "%PROJECT_DIR%target\classes;%PROJECT_DIR%target\dependency\*" com.example.XMLConfigMain
echo.

REM Run Annotation Configuration Example
echo.
echo ========== Running Annotation Configuration Example ==========
echo.
"%JAVA_HOME%\bin\java.exe" -cp "%PROJECT_DIR%target\classes;%PROJECT_DIR%target\dependency\*" com.example.AnnotationConfigMain
echo.

echo Done!
endlocal
