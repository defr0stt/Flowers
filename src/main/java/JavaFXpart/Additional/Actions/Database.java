package JavaFXpart.Additional.Actions;

import JavaFXpart.Additional.Additional;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.sql.*;

import static JavaFXpart.Logger.Logger.logger;

public class Database
{

    public void flowersFromDB()
    {
        logger.info("READING DATA FROM DATABASE");

        new Receiver().variation(14);

        Text welcomeBouquet = new StartMenu().textConstructor("Bouquet from database",1,2,80.0,350.0);
        welcomeBouquet.setStyle("-fx-font-size: 24px;");

        Button backToFlower = new StartMenu().buttonConstructor("Additional menu","Back to 'Additional menu'",1,2,495.0,413.0);
        backToFlower.setOnAction(actionEvent -> {new Receiver().transition(new Additional());});
        Text dbFlowerText = null;
        try {
            checkConnection();
            dbFlowerText = new StartMenu().textConstructor(readingDataFromDB(),1,2,160.0,380.0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        new Additional().additionalMenuView();
        StartMenu.pane.getChildren().add(welcomeBouquet);
        StartMenu.pane.getChildren().add(backToFlower);
        StartMenu.pane.getChildren().add(dbFlowerText);
        new StartMenu().sceneStarter(StartMenu.pane, StartMenu.defaultStage);

        new Receiver().variation(15);
    }

    private static final String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "qwerty1122";
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public void checkConnection(){
        if(connection == null){
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                connection = DriverManager.getConnection(jdbcURL, username, password);
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection() throws SQLException {
        if(!connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }

    public void newData(String queryData) throws SQLException {
        String query = "INSERT INTO flower(name,color,length,freshness,price) VALUES (" + queryData + ")";
        statement.executeUpdate(query);
    }

    public void deleteData() throws SQLException {
        String query = "TRUNCATE TABLE flower";
        statement.executeUpdate(query);
    }

    public String readingDataFromDB() throws SQLException {
        String infoLine = "\t\t\t\tFlowers in bouquet:\n\n";
        String query = "SELECT * FROM flower";
        resultSet = statement.executeQuery(query);

        while(resultSet.next()){
            infoLine += "" + resultSet.getString("name") + " : value = " + resultSet.getInt("price") + " $, " +
                    "length = " + resultSet.getString("length") + " sm, freshness = " + resultSet.getString("freshness")
                    + "day(s), color = " + resultSet.getString("color") + "\n";
        }
        return infoLine;
    }
}
