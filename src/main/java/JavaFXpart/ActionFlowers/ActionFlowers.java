package JavaFXpart.ActionFlowers;

import JavaFXpart.Additional.Additional;
import JavaFXpart.Flowers.Chrysanthemum;
import JavaFXpart.Flowers.FlowerTemplate;
import JavaFXpart.Flowers.Rose;
import JavaFXpart.Receiver.Command;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
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
        Button flowerList = new StartMenu().buttonConstructor("Flower list","Detailed information about the created flowers",1,2,335.0,425.0);
        flowerList.setOnAction(actionEvent -> {new Receiver().variation(new ActionFlowers(),3);});

        StartMenu.pane = flowerMenuView();
        StartMenu.pane.getChildren().add(flowerList);
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

    public void flowerList()
    {
        Text welcomeFlowerList = new StartMenu().textConstructor("Flower list",1,2,80.0,400.0);
        welcomeFlowerList.setStyle("-fx-font-size: 24px;");

        StartMenu.pane = flowerMenuView();

        Double topBottom = 160.0;
        for (FlowerTemplate a : flowers){
            Text example;
            example = new StartMenu().textConstructor(a.toString(),1,2,topBottom,245.0);
            example.setStyle("-fx-font-size: 14px;");
            Ellipse ellipseExample = a.getColor(topBottom+10);
            StartMenu.pane.getChildren().add(example);
            StartMenu.pane.getChildren().add(ellipseExample);
            topBottom += 25;
        }

        Button backToFlower = new StartMenu().buttonConstructor("Flower menu","Back to 'Flower menu'",1,2,440.0,422.0);
        backToFlower.setOnAction(actionEvent -> {new Receiver().transition(new ActionFlowers());});
        Button backToMainMenu = new StartMenu().buttonConstructor("Main menu","Back to 'Main menu'",1,2,485.0,425.0);
        backToMainMenu.setOnAction(actionEvent -> {
            try {
                new StartMenu().start(StartMenu.defaultStage);
            } catch (IOException e) {
                e.printStackTrace();
            }});

        StartMenu.pane.getChildren().add(welcomeFlowerList);
        StartMenu.pane.getChildren().add(backToFlower);
        StartMenu.pane.getChildren().add(backToMainMenu);
    }
}
