@echo off
title build
echo Starting build ...

mysql -u root -p -e "source build.sql";

echo Build complete!

pause