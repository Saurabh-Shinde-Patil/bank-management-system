package BankManagementSystem;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
import java.io.IOException;
//import static java.lang.Class.forName;

public class BankingApp {
	
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
    	
    	
    	Properties props = new Properties();
    	FileInputStream fis = null;
    	
    	try {
    		fis=new FileInputStream("config.properties");
    		props.load(fis);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}

    	String url = props.getProperty("db.url");
    	String username = props.getProperty("db.username");
    	String password = props.getProperty("db.password");
    	
/***************follow below ******OR below to bellow 
 *   	
 *    if you use above code from after main method to the above one line 
 *      ie from line 15 to 28 and
   	    then create one new file with name config.properties
        and add your Database crediantials in that file  like following
 
           db.url=your own url
           db.username=your username like root
           db.password=your password loke root

    	
 */
//*********************  OR OR OR   **************************** /////	
    	
    	
/*     ***replace above code from line 15 to 28 by below*****	
 *      
 *      String url ="your own url"; 
    	String username ="your username like root"; 
    	String password ="your password loke root"; 
    	
    	***********************************************

 */
    	
    	
    	
    	
    	
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner scanner =  new Scanner(System.in);
            User user = new User(connection, scanner);
            Accounts accounts = new Accounts(connection, scanner);
            AccountManager accountManager = new AccountManager(connection, scanner);

            String email;
            long account_number;

            while(true){
                System.out.println("*** WELCOME TO THE SS BANKING SYSTEM ***");
                System.out.println();
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.println("Enter your choice: ");
                int choice1 = scanner.nextInt();
                switch (choice1){
                    case 1:
                        user.register();
                        break;
                    case 2:
                        email = user.login();
                        if(email!=null){
                            System.out.println();
                            System.out.println("User Logged In!");
                            if(!accounts.account_exist(email)){
                                System.out.println();
                                System.out.println("1. Open a new Bank Account");
                                System.out.println("2. Exit");
                                if(scanner.nextInt() == 1) {
                                    account_number = accounts.open_account(email);
                                    System.out.println("Account Created Successfully");
                                    System.out.println("Your Account Number is: " + account_number);
                                }else{
                                    break;
                                }

                            }
                            account_number = accounts.getAccount_number(email);
                            int choice2 = 0;
                            while (choice2 != 5) {
                                System.out.println();
                                System.out.println("1. Debit Money");
                                System.out.println("2. Credit Money");
                                System.out.println("3. Transfer Money");
                                System.out.println("4. Check Balance");
                                System.out.println("5. delete account");
                                System.out.println("6. update account");
                                
                                System.out.println("7. Log Out");
                                System.out.println("Enter your choice: ");
                                choice2 = scanner.nextInt();
                                switch (choice2) {
                                    case 1:
                                        accountManager.debit_money(account_number);
                                        break;
                                    case 2:
                                        accountManager.credit_money(account_number);
                                        break;
                                    case 3:
                                        accountManager.transfer_money(account_number);
                                        break;
                                    case 4:
                                        accountManager.getBalance(account_number);
                                        break;
                                    case 5:
                                        accountManager.deleteAccount(account_number);
                                        break; 
                                    case 6:
                                        accountManager.updateAccount(account_number);
                                        break;        
                                    case 7:
                                        break;
                                    default:
                                        System.out.println("Enter Valid Choice!");
                                        break;
                                }
                            }

                        }
                        else{
                            System.out.println("Incorrect Email or Password!");
                            
                        }
                        break;
                    case 3:
                        System.out.println("THANK YOU FOR USING BANKING SYSTEM!!!");
                        System.out.println("Exiting System!");
                        return;
                    default:
                        System.out.println("Enter Valid Choice");
                        break;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
