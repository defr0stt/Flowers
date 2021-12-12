package JavaFXpart.Additional.Actions;

import JavaFXpart.ActionFlowers.ActionFlowers;
import JavaFXpart.Additional.Additional;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.sql.*;

public class Database
{

    public void flowersFromDB()
    {
        Text welcomeBouquet = new StartMenu().textConstructor("Bouquet from database",1,2,80.0,350.0);
        welcomeBouquet.setStyle("-fx-font-size: 24px;");

        Button backToFlower = new StartMenu().buttonConstructor("Additional menu","Back to 'Additional menu'",1,2,495.0,413.0);
        backToFlower.setOnAction(actionEvent -> {new Receiver().transition(new ActionFlowers());});

        new Additional().additionalMenuView();
        StartMenu.pane.getChildren().add(welcomeBouquet);
        StartMenu.pane.getChildren().add(backToFlower);
        new StartMenu().sceneStarter(StartMenu.pane, StartMenu.defaultStage);
    }

    private static final String jdbcURL = "jdbc:mysql://localhost: 3306/flower";
    private static final String username = "root";
    private static final String password = "Dima";
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public void checkConnection() throws SQLException {
        connection = DriverManager.getConnection(jdbcURL,username,password);
        statement = connection.createStatement();
    }

    public void newData(String queryData) throws SQLException {
        checkConnection();
        String query = "INSERT INTO bouquet(name,color,length,freshness,price) VALUES (" + queryData + ")";
        statement.executeUpdate(query);
        connection.close();
    }

    public void deleteData() throws SQLException {
        checkConnection();
        String query = "TRUNCATE TABLE bouquet";
        statement.executeUpdate(query);
        connection.close();
    }
}
