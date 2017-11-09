package lab07.lab07;

import java.util.Scanner;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class menu {
	 private static Scanner scanner = new Scanner(System.in);
	
	 public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, MySQLSyntaxErrorException {
		 
		 String pass="";
		 String name="root";
		//Register JDBC driver
		 Class.forName("com.mysql.jdbc.Driver");
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecafe",name,pass);
	        
	        java.sql.CallableStatement callableStatement = null;
	        
		    //for initializing the items
	        //Statement statement5 = connection.createStatement();
	        //ResultSet items = statement5.executeQuery("SELECT * FROM item");
	        
	        //for initializing the items 
		    String query1 = "SELECT * FROM item";
		    PreparedStatement items1 = (PreparedStatement) connection.prepareStatement(query1);
		    ResultSet items = items1.executeQuery();
	        
	        //for inserting orders data in database
	       String insert_order = "Insert into orders(user_id,order_time,order_type,total) values(?,?,?,?)";
	       PreparedStatement statement6 = (PreparedStatement) connection.prepareStatement(insert_order);
	       
	    
	       //PreparedStatement statement7 = (PreparedStatement) connection.prepareStatement(insert_user);   
		 
	       //get user TABLE
	       String query2 = "SELECT * FROM users";
		   PreparedStatement user_TABLE1 = (PreparedStatement) connection.prepareStatement(query2);
		   ResultSet user_TABLE = user_TABLE1.executeQuery();
	       
	       //get user TABLE
	       //Statement statement8 = connection.createStatement();
	       //ResultSet user_TABLE = statement8.executeQuery("SELECT * FROM users");
	       
		 set_item[] item = new set_item[15];
		 for ( int i=0; i<item.length; i++) {
			 item[i]=new set_item();
			 }
		 
		 for(int i=0;items.next();i++) {
			 item[i].setValues(items.getString(3), items.getInt(4), items.getInt(5));
		 }
		 
		 
		   System.out.print("--------Welcome to CAFE ISLAMABAD----------\n");
		   System.out.print("-----------------MENU----------------------\n\n");
		   System.out.print("-------------1.Appetizers------------------\n");
		 
		   for (int x=0;x<4;x++)
		   {
			    System.out.print(x+1);
    			System.out.print(". ");
			    System.out.print(item[x].getItem());
     			System.out.print("\n   Rs ");
     			System.out.print(item[x].getPrice());
     			System.out.print("\n   ");
     			System.out.print(item[x].getTime());
     			System.out.print(" mins \n");
     			System.out.print("\n");
			   
		   }
		 
		   System.out.print("\n----------------2.Soups-------------------\n");
		   for (int x=4;x<6;x++)
		   {
			    System.out.print(x+1);
    			System.out.print(". ");
			    System.out.print(item[x].getItem());
     			System.out.print("\n   Rs ");
     			System.out.print(item[x].getPrice());
     			System.out.print("\n   ");
     			System.out.print(item[x].getTime());
     			System.out.print(" mins \n");
     			System.out.print("\n");
			   
		   }
		   
		   System.out.print("\n--------------3.Main Course Dishes----------\n");
		   for (int x=6;x<12;x++)
		   {
			    System.out.print(x+1);
    			System.out.print(". ");
			    System.out.print(item[x].getItem());
     			System.out.print("\n   Rs ");
     			System.out.print(item[x].getPrice());
     			System.out.print("\n   ");
     			System.out.print(item[x].getTime());
     			System.out.print(" mins \n");
     			System.out.print("\n");
			   
		   }
		   
		   System.out.print("\n------------------4.Side Dishes-------------\n");   
		   for (int x=12;x<15;x++)
		   {
			    System.out.print(x+1);
    			System.out.print(". ");
			    System.out.print(item[x].getItem());
     			System.out.print("\n   Rs ");
     			System.out.print(item[x].getPrice());
     			System.out.print("\n   ");
     			System.out.print(item[x].getTime());
     			System.out.print(" mins \n");
     			System.out.print("\n");   
		   }
		   
		   String end="continue";
		   int total_bill=0;
		   int total_time=0;
		   
		   while (end.equals("continue"))
		   {
			   System.out.print("\n-----------------------");
			   System.out.print("\n\n");
			   System.out.print("SELECT COURSE NO \n");
			   System.out.print("1 for Appetizer \n");
			   System.out.print("2 for Soups \n");
			   System.out.print("3 for Main Course Dishes \n");
			   System.out.print("4 for Side Dishes\n"); 
			   System.out.print("E for BILL\n");
			   System.out.print("\n\n");
			   scanner.nextLine();
			   System.out.print("ENTER COURSE NO: ");
			   String course_no = scanner.nextLine();
			   int item_no=1;
			   if (!course_no.equals("E"))
			   { System.out.print("\nENTER FOOD ITEM NO: ");
			   item_no = scanner.nextInt();}
			   
			   switch(course_no) {
		         case "1" :
		        	 for (int i=0; i<4;i++)
		        	 {
		        		 if (item_no==(i+1))
		        		 {
		        			 total_bill=total_bill+item[i].getPrice();
		        			 total_time=total_time+item[i].getTime();
		        		 }
		        	 }
		            break;
		            
		         case "2" :
		        	 for (int i=4; i<6;i++)
		        	 {
		        		 if (item_no==(i+1))
		        		 {
		        			 total_bill=total_bill+item[i].getPrice();
		        			 total_time=total_time+item[i].getTime();
		        		 }
		        	 }
				        
			            break;
			            
		         case "3" :
		        	 for (int i=6; i<12;i++)
		        	 {
		        		 if (item_no==(i+1))
		        		 {
		        			 total_bill=total_bill+item[i].getPrice();
		        			 total_time=total_time+item[i].getTime();
		        		 }
		        	 }
				        
			            break;
			            
		         case "4" :
		        	 for (int i=12; i<15;i++)
		        	 {
		        		 if (item_no==(i+1))
		        		 {
		        			 total_bill=total_bill+item[i].getPrice();
		        			 total_time=total_time+item[i].getTime();
		        		 }
		        	 }
			            break;
		       
		         case "E" :
		        	 end="end";
			            break;
			            
		         default :
		            System.out.println("INVALID OPTION ! RE-ENTER CORRECT VALUE !!!");
		      }			  
		   }
		   
		   System.out.print("\n\nWould you like to takeaway or delivery ?\n");
		   System.out.print("Enter Y for TAKE AWAY, N for DELIVERY \n");
		   
		   String n, ad,type;
		   int ph;
		
		   String user_op = scanner.nextLine();
		   if (user_op.equals("N")) {
			   System.out.print("\nEnter your name: ");
			   n= scanner.nextLine();
			   System.out.print("Enter your address: ");
			   ad= scanner.nextLine();
			   System.out.print("Enter your phone: ");
			   ph= scanner.nextInt();
			   type="dy"; //delivery
		   }
		   else 
		   {
			   System.out.print("\nEnter your name: ");
			   n= scanner.nextLine();
			   ad= "N/A";
			   System.out.print("Enter your phone: ");
			   ph= scanner.nextInt();
			   type="ta"; //takeaway
		   }
		   

      	 System.out.println("Total Bill: Rs"+total_bill);
      	 System.out.println("Total Time: "+total_time+" mins"); 
      	 
      	//Bind values into the parameters.
      	// statement7.setString(1, n);
      	 //statement7.setString(2, ad);
      	// statement7.setInt(3, ph);
      // int rows = statement7.executeUpdate();
      	 
      	//callable Statement
         String setUser = "{call setUser(?,?,?)}";
         callableStatement = connection.prepareCall(setUser);
      	
         callableStatement.setString(1, n);
         callableStatement.setString(2, ad);
         callableStatement.setInt(3, ph);
 		
 		// execute getDBUSERByUserId store procedure
 		callableStatement.executeUpdate();
      	 
      	 user_TABLE.last();
      	int user=user_TABLE.getInt(1)+1;
      	   	 
      	statement6.setInt(1, user);
     	statement6.setInt(2, total_time);
     	statement6.setString(3, type);
     	statement6.setInt(4, total_bill);
     	
     	int rows1 = statement6.executeUpdate();
     	
		   System.out.print("\nThankyou for ordering to our CAFE !");
		   
		   connection.close();
	 }
}
