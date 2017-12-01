#Sample Google Maps Test
This project compare API and UI response of Google maps 
for direction between two locations

##Dependencies
 - Windows machine 
   (To run in linux, chromedirver and path need to be changed. Rest should be fine)
 - Java 8 (32 bit)
 - Chrome (32 bit)
 - IDE is not needed
 
To view results, check ```/reports``` folder. 
This has both Junit report and Serenity report (simplified versions). 
You can observe test failed as the esitmated duration mismatch by 1 min,
between UI & API

##To run locally (Windows)
Before running the script, take note of following things

 - If you are behind proxy, you need to update Serenity & WebDriver
   properties accordingly
   
 - Maps  API key is not commited to git, this has to be updated in
   ```src/test/java/com/discover/test/config/Config.java```
 
 - To run the script from command line, from project root folder, run
   ```gradlew clean test```
   
 - Script is not disable Chrome security flags, which might lead to
   warning popups in corporate settings