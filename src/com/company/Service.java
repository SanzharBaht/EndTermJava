package com.company;
import java.sql.*;
import java.util.Random;
import java.util.Scanner;
import java.sql.ResultSet;

public class Service extends Products{
    int min = 1000;
    int max = 10000;
    int diff = max - min;
    Random random = new Random();
    private int id = random.nextInt(diff+1);
    private String name;
    private String phone;
    int counter = 100;
    Scanner in = new Scanner(System.in);
    Connection connection = null;
    Statement st = null;
    public String getName(){
        return name;
    }
    public  String getPhone(){
        return phone;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setId(){
        this.id += counter++;
    }
    public int getId(){
        return id += counter++;
    }

    public Connection order() {
        Connection connection = null;
        String host = "localhost";
        String port = "5432";
        String db_name = "JDBC";
        String username = "postgres";
        String password = "0000";
        try {
            Class.forName("org.postgresql.Driver");
            // Establish the connection
            //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "0000");
            connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name, username, password);

            st = connection.createStatement();

            ResultSet rs = st.executeQuery("Insert into customer_details(order_id,name,phone) values('"+getId()+"','"+in.next()+"',"+in.nextInt()+")");
            while (rs.next()){
                name = rs.getString("name");
                phone = rs.getString("phone");
                System.out.println("Lists of products: ");
            }
            st.close();
            connection.close();
        }catch(Exception e) {
            System.out.println("List of products: ");
        }
        return connection;
    }
    public Connection seeOrder() {
        Connection connection = null;
        String host = "localhost";
        String port = "5432";
        String db_name = "JDBC";
        String username = "postgres";
        String password = "0000";
        try {
            Class.forName("org.postgresql.Driver");
            // Establish the connection
            //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "0000");
            connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name, username, password);
            //ResultSet rs = st.executeQuery("Create table customer_details(order_id int, name text, phone text, Primary key(order_id))");
            //ResultSet rs = st.executeQuery("Create table product_details(product_id int, name text, price int, Primary key(product_id))");
            //ResultSet rs = st.executeQuery("Create table order_details(order_id int,product_id int, Foreign key(order_id)) References customer_details.order_id, Foreign key(product_id) References products_details.product_id"));

            st = connection.createStatement();

            ResultSet rs = st.executeQuery("Select*from customer_details");
            while (rs.next()){
                String name = rs.getString("name");
                int id = rs.getInt("order_id");
                int phone = rs.getInt("phone");
                System.out.println("Order_id: "+id);
                System.out.println("Name: "+name);
                System.out.println("Phone number: "+phone);
            }
            st.close();
            connection.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}
