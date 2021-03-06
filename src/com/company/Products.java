package com.company;

import java.sql.*;
import java.util.Scanner;
public class Products extends ConnectDB{
    Scanner in = new Scanner(System.in);
    protected int price;
    private String name;
    private int sum = 0;
    Connection connection = null;
    Statement st = null;


    public Connection start() {
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
            ResultSet rs = st.executeQuery("SELECT * FROM product_details");
            while (rs.next()) {
                price = rs.getInt("price");
                name = rs.getString("name");
                System.out.println(name+" costs: "+price);
            }

            for (int i = 0; i < 3; i++) {
                int n = 1;
                ResultSet qr = st.executeQuery("Select price from product_details where name='"+in.next()+"'");
                while (qr.next()){
                    price=qr.getInt("price");
                    sum+=price;
                    System.out.println("Total cost: "+sum);
                    System.out.println("Are you going to continue shopping?(y/n)");
                    String stop = in.next();
                    if (stop.equals("n")){
                        n = 2;
                    }
                    else {
                        System.out.println("Anything else?");
                    }
                }
                if (n==2){
                    break;
                }
            }

            st.close();

            connection.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
