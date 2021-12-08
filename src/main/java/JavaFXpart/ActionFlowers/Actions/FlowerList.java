package JavaFXpart.ActionFlowers.Actions;

import JavaFXpart.ActionFlowers.ActionFlowers;
import JavaFXpart.Flowers.FlowerTemplate;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

import static JavaFXpart.ActionFlowers.ActionFlowers.flowers;

public class FlowerList
{
    // ===========================================================================================================
    //                                             List of flowers part
    // ===========================================================================================================

    FlowerTemplate flowerListObject;
    ObservableList<FlowerTemplate> flowerList = FXCollections.observableArrayList(flowers);
    ChoiceBox<FlowerTemplate> changeChoiceBox = new ChoiceBox<FlowerTemplate>(flowerList);
    public void flowerList()
    {
        Text welcomeFlowerList = new StartMenu().textConstructor("Flower list",1,2,80.0,400.0);
        welcomeFlowerList.setStyle("-fx-font-size: 24px;");

        StartMenu.pane = new ActionFlowers().flowerMenuView();

        if(!flowers.isEmpty()) {
            changeChoiceBox = (ChoiceBox<FlowerTemplate>) new StartMenu().positionDetermination(changeChoiceBox,1,2,150.0,280.0);
            StartMenu.pane.getChildren().add(changeChoiceBox);

            Text deleteText = new StartMenu().textConstructor("",
                    1,2,280.0,210.0);
            deleteText.setStyle("-fx-font-size: 14px;");
            ChoiceBox<FlowerTemplate> finalDeleteChoiceBox = changeChoiceBox;
            changeChoiceBox.setOnAction(event -> { deleteText.setText(finalDeleteChoiceBox.getValue().toString());
                flowerListObject = finalDeleteChoiceBox.getValue();
                StartMenu.pane.getChildren().add(finalDeleteChoiceBox.getValue().getColor(670,290));
            });
            StartMenu.pane.getChildren().add(deleteText);
        }
        else {
            Text example = new StartMenu().textConstructor("There are no created flowers", 1, 2, 230.0, 360.0);
            example.setStyle("-fx-font-size: 16px;");
            StartMenu.pane.getChildren().add(example);
        }

        Button backToFlower = new StartMenu().buttonConstructor("Flower menu","Back to 'Flower menu'",1,2,440.0,422.0);
        backToFlower.setOnAction(actionEvent -> {new Receiver().transition(new ActionFlowers());});

        StartMenu.pane.getChildren().add(welcomeFlowerList);
        StartMenu.pane.getChildren().add(backToFlower);
    }
}
