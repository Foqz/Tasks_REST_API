call runcrud.bat
if "%ERRORLEVEL%" == "0" goto startbrowser
echo.
echo There was an error i runcrud script.
goto fail


:startbrowser
START chrome -new-tab "http://localhost:8080/crud/v1/task/getTasks"
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.