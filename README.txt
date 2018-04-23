===== INSTRUCTIONS =====

- This project runs on Gradle.

- To execute it please go to the root and run:
   "./gradlew run"     if on Linux or Unix Based OS.
   "gradle.bat run"   if on Windows.

 - This example stores data inside a Map called "sales", eventually it can be configured to use Relational databases
   like MySQL, Oracle, Db2, etc... or NoSQL databases like MongoDB. In that case it would be better to create domain objects,
   for example you can create a class named "Sale" and another one named "Message" and map them to your preferred
   database using Hibernate.

 - There are 3 files with data for testing under the folder "/sampleFiles", you can choose between them by commenting or uncommenting the lines
   13, 14 and 15 on the file "Main.groovy"

- You can see the status of the data in real time thanks to the code on the lines 41 to 48 on the "SaleController.groovy".

- If you have any questions please don't hesitate to ping me at "ricvargas@hotmail.com"

======================
