package HomeWork9;

import java.sql.*;

public class DataBase {
    public static Connection connection;
    public static Statement statement;
    public static PreparedStatement addCat;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:cats.db");
        statement = connection.createStatement();
    }

    public static void disconnect() {
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (addCat != null) addCat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addCat(Cat cat) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO cats(id, name, color, age, info) VALUES (?,?,?,?,?);");
        ps.setInt(1, cat.getId());
        ps.setString(2, cat.getName());
        ps.setString(3, cat.getColor());
        ps.setInt(4, cat.getAge());
        ps.setString(5, cat.getInfo());
        ps.executeUpdate();
    }

    public static void printCats() throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM cats;");
    }
}
