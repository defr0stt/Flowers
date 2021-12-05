package JavaFXpart.ActionFlowers;

import JavaFXpart.Flowers.*;
import JavaFXpart.Receiver.Command;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActionFlowers implements Command {

    public static List<FlowerTemplate> flowers = new ArrayList();

    @Override
    public void execute()
    {
        Button createFlower = new StartMenu().buttonConstructor("Create flower","The process of creating flowers",1,2,185.0,417.0);
        createFlower.setOnAction(actionEvent -> {new Receiver().variation(1);});
        Button deleteFlower = new StartMenu().buttonConstructor("Delete flower","The process of deleting flowers",1,2,225.0,417.0);
        deleteFlower.setOnAction(actionEvent -> {new Receiver().variation(2);});
        Button flowerList = new StartMenu().buttonConstructor("Flower list","Detailed information about the created flowers",1,2,265.0,425.0);
        flowerList.setOnAction(actionEvent -> {new Receiver().variation(3);});
        Button changeFlower = new StartMenu().buttonConstructor("Change flower","The process of deleting flowers parameters",1,2,305.0,413.0);
        changeFlower.setOnAction(actionEvent -> {new Receiver().variation(4);});
        Button mainMenu = new StartMenu().buttonConstructor("Main menu","Back 'Main menu'",1,2,375.0,422.0);
        mainMenu.setOnAction(actionEvent -> {
            try {
                new StartMenu().start(StartMenu.defaultStage);
            } catch (IOException e) {
                e.printStackTrace();
            }});

        StartMenu.pane = flowerMenuView();
        StartMenu.pane = new StartMenu().sumAllElements((AnchorPane) StartMenu.pane,
                new Node[]{createFlower, deleteFlower, flowerList, changeFlower, mainMenu});
    }

    public Pane flowerMenuView()
    {
        Text welcomeFlowersText = new StartMenu().textConstructor("Flower  menu",1,2,50.0,385.0);
        welcomeFlowersText.setStyle("-fx-font-size: 24px;");

        ImageView backImageView1 = null;
        ImageView backImageView2 = null;
        ImageView backImageView3 = null;
        ImageView backImageView4 = null;
        try {
            backImageView1 = new StartMenu().imageConstructor("resources/actionFlower2.png",1,2,230.0,60.0);
            backImageView1.setFitHeight(128);
            backImageView1.setFitWidth(128);
            backImageView2 = new StartMenu().imageConstructor("resources/actionFlower2.png",1,2,230.0,710.0);
            backImageView2.setFitHeight(128);
            backImageView2.setFitWidth(128);
            backImageView3 = new StartMenu().imageConstructor("resources/actionFlower3.png",1,2,55.0,555.0);
            backImageView3.setFitHeight(32);
            backImageView3.setFitWidth(12);
            backImageView4 = new StartMenu().imageConstructor("resources/actionFlower3.png",1,2,55.0,340.0);
            backImageView4.setFitHeight(32);
            backImageView4.setFitWidth(12);
            backImageView4.setScaleX(-1);

            StartMenu.pane = new StartMenu().authorPlusImagePulsing(welcomeFlowersText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StartMenu.pane = new StartMenu().sumAllElements((AnchorPane) StartMenu.pane,
                new Node[]{backImageView1, backImageView2, backImageView3, backImageView4});

        new StartMenu().sceneStarter(StartMenu.pane, StartMenu.defaultStage);
        return StartMenu.pane;
    }
}
