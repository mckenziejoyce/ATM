import OOP.*;
import java.sql.Connection;
import java.sql.*;

class DataDriver{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ATM?serverTimezone=EST","root","password");
            con.close();
        }catch(Exception ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
    }
    public StockMarket getStockMarket(){
        try{
            StockMarket sm = new StockMarket();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ATM?serverTimezone=EST","root","password");
            Statement stmt= con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from emp");
            while(rs.next()){
                boolean available = rs.getInt(3)==1?true:false;
                sm.getStockList().add(new Stock(rs.getString(1),Double.valueOf(rs.getInt(2)),available));
            }
            con.close();
        }catch(Exception ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
    }
}
