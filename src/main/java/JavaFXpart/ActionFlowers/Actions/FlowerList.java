package JavaFXpart.ActionFlowers.Actions;

import JavaFXpart.ActionFlowers.ActionFlowers;
import JavaFXpart.Flowers.FlowerTemplate;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.scene.control.Button;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

import java.io.IOException;

import static JavaFXpart.ActionFlowers.ActionFlowers.flowers;

public class FlowerList
{
    // ===========================================================================================================
    //                                             List of flowers part
    // ===========================================================================================================

    public void flowerList()    //todo to finish flower list in normal view
    {
        Text welcomeFlowerList = new StartMenu().textConstructor("Flower list",1,2,80.0,400.0);
        welcomeFlowerList.setStyle("-fx-font-size: 24px;");

        StartMenu.pane = new ActionFlowers().flowerMenuView();

        if(!flowers.isEmpty()) {
            Double topBottom = 160.0;
            for (FlowerTemplate a : flowers) {
                Text example = new StartMenu().textConstructor(a.toString(), 1, 2, topBottom, 245.0);
                example.setStyle("-fx-font-size: 14px;");
                Ellipse ellipseExample = a.getColor(topBottom + 10);
                StartMenu.pane.getChildren().add(example);
                StartMenu.pane.getChildren().add(ellipseExample);
                topBottom += 25;
            }
        }
        else {
            Text example = new StartMenu().textConstructor("There are no created flowers", 1, 2, 230.0, 360.0);
            example.setStyle("-fx-font-size: 16px;");
            StartMenu.pane.getChildren().add(example);
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
