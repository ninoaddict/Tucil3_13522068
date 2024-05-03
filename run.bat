@echo off
rem Compile Java files
javac -d bin src/word_ladder/*.java

rem Check if compilation was successful
if %errorlevel% neq 0 (
    echo Compilation failed.
    exit /b
)

rem Run the Main class
java -cp bin word_ladder.WordLadder

rem Pause to see the output before closing the command prompt window
pause