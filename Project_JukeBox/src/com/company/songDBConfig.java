package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class songDBConfig
{

    static Connection con=null;


    //connects the database to this program.
    public static Connection getConnection() throws SQLException
    {


        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Arjunsingh1#");
        return con;


    }




}

