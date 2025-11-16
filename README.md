Bank Management System (Java + MySQL + JDBC)

A console-based Bank Management System built using Java, MySQL, and JDBC.
This project runs entirely on the terminal (no GUI).

✨ Features

After login

1.Debit Money

2. Credit Money
3. Transfer Money
4. Check Balance
5. delete account
6. update account
7. Log Out


Persistent storage using MySQL

Simple and clean menu-driven program

 Technologies Used

Java

MySQL Database

JDBC (Java Database Connectivity)

Eclipse IDE

 Project Structure
 
├──BankmanagementSystem

    ├──mysqlconnector    
       ├──mySqlConnectorj
    ├──src/
       ├──BankManagementSystem
           ├── AccountManager.java
           ├── Accounts.java
           ├── BankingApp.java
           ├──user.java
      
  

 How to Run the Project
1. git clone 
2. Add MySQL JDBC Connector (mysql-connector.jar)
3. Create MySQL Database

<b>********database table image is attached*********


 Update DB credentials in code

Set your MySQL:

String url = "jdbc:mysql://localhost:3306/bank";

String user = "root";

String pass = "your_password";


 Run the program

Run Main.java

 Future Enhancements

Add GUI using JavaFX / Swing

Add transaction history

Add admin panel

 Author
Saurabh shinde
B.Tech (Electronics & Computer Science)
