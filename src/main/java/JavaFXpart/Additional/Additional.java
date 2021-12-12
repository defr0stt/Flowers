package JavaFXpart.Additional;

import JavaFXpart.Receiver.Command;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.*;

public class Additional implements Command
{
    @Override
    public void execute()  {
        additionalMenuView();

        Button infoButton = new StartMenu().buttonConstructor("Information","Info about flowers",1,2,260.0,425.0);
        infoButton.setOnAction(actionEvent -> {new Receiver().variation(12);});
        Button fileButton = new StartMenu().buttonConstructor("Bouquet from file","Info about bouquet from file",1,2,310.0,410.0);
        fileButton.setOnAction(actionEvent -> {new Receiver().variation(11);});
        Button dbButton = new StartMenu().buttonConstructor("Bouquet from database","Info about flower(s) in bouquet from database",1,2,360.0,395.0);
        dbButton.setOnAction(actionEvent -> {new Receiver().variation(13);});
        Button mainMenuButton = new StartMenu().buttonConstructor("Main menu","Back to 'Main menu'",1,2,410.0,425.0);
        mainMenuButton.setOnAction(actionEvent -> {
            try {
                new StartMenu().start(StartMenu.defaultStage);
            } catch (IOException e) {
                e.printStackTrace();
            }});

        StartMenu.pane = new StartMenu().sumAllElements((AnchorPane) StartMenu.pane, new Node[]{ infoButton, fileButton, dbButton, mainMenuButton});
        new StartMenu().sceneStarter(StartMenu.pane, StartMenu.defaultStage);
    }

    public void additionalMenuView()
    {
        Text welcomeAdditionalText = new StartMenu().textConstructor("Additional  menu",1,2,50.0,365.0);
        welcomeAdditionalText.setStyle("-fx-font-size: 24px;");

        ImageView backImageView = null;
        try {
            backImageView = new StartMenu().imageConstructor("resources/bckt.png",1,2,120.0,50.0);
            backImageView.setFitHeight(432);
            backImageView.setFitWidth(272);

            StartMenu.pane = new StartMenu().authorPlusImagePulsing(welcomeAdditionalText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StartMenu.pane.getChildren().add(backImageView);
    }
}
