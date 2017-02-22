@echo off
cd /d %~dp0
call gradlew build eclipse
echo "#######################################"
echo "#### Please Refresh(F5) Workspace. ####"
echo "#######################################"
pause