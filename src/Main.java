import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/shopdb";
        String username = "root";
        String password = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();


            statement.executeUpdate("INSERT INTO Humans (FirstName,Age ) VALUES ('KATE', 17)");


            ResultSet resultSetHuman = statement.executeQuery("SELECT * FROM Humans");
            while (resultSetHuman.next()){
                String name = resultSetHuman.getString("FirstName");
                int age = resultSetHuman.getInt("Age");
                System.out.println(name + " " +  age);
            }
            ResultSet resultSetProducts = statement.executeQuery("SELECT ProductName FROM Products");
            while(resultSetProducts.next()){
                System.out.println(resultSetProducts.getString(1));
            }


            statement.executeUpdate("DELETE FROM Humans WHERE HumanID = 3");

            statement.executeUpdate("UPDATE Products SET ProductName = 'shleb' WHERE ProductID = 1");

        }
        catch (Exception ex){
            System.out.println("Connection failed...");
        }
    }
}