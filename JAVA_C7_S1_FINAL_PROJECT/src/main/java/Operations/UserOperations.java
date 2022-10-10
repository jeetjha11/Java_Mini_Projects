package Operations;

import connectionApp.ConnectToDatabase;
import Exception.UserNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class UserOperations
{
    Connection con= ConnectToDatabase.establishconnection();
    Scanner sc=new Scanner(System.in);

    String userName,password;
    int userId=0;

    public UserOperations() throws SQLException, ClassNotFoundException
    {
    }
    public int UserValidate() throws UserNotFoundException, SQLException {
        System.out.println("Please choose");
        System.out.println("................");
        System.out.println("................");
        System.out.println("Press 1 for Login\nPress 2 for new user");
        int choice=sc.nextInt();
        if (choice==1)
        {
            System.out.println("...................................");
            System.out.println("Please enter your UserName");
            userName=sc.next();
            System.out.println("Please Enter the password");
            password=sc.next();

                Statement statement=con.createStatement();
                ResultSet rs=statement.executeQuery("select userid from user where username='"+userName+"' and password='"+password+"'");
                 if (rs.next())
                 {
                     userId=rs.getInt(1);
                     System.out.println("............................WELCOME TO THE JUKEBOX MUSIC PLAYER...........................");
                 }
                 else
                 {
                    throw new UserNotFoundException("No active User found // Please enter the valid User and Password");
                 }



        }
        else if (choice==2)
        {
            createAccount();
        }
        return userId;
    }
    public int createAccount()
    {
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("                        Please complete your profile                                     ");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Enter user name to create account: ");
        userName=sc.next();
        System.out.println("Enter the password: ");
        password=sc.next();
        try
        {
            PreparedStatement ps=con.prepareStatement("insert into User (username,password) values(?,?)");
            ps.setString(1,userName);
            ps.setString(2,password);
            ps.executeUpdate();
            System.out.println(".....................Account created successfully....................::)\n");

            Statement statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery("select userid from user where username='"+userName+"'");
            while(resultSet.next())
            {
                userId=resultSet.getInt(1);
            }
        }
        catch(SQLException se){
            se.printStackTrace();
            System.out.println("User name already exists :(\n\n Please try different UserName");
            createAccount();
        }
        return userId;
    }

//    public static void main(String[] args) throws Exception {
//        UserOperations u=new UserOperations();
//        int n=u.UserValidate();
//    }
}
