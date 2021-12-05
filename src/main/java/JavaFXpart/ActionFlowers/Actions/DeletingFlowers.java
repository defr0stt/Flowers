package JavaFXpart.ActionFlowers.Actions;

import JavaFXpart.ActionFlowers.ActionFlowers;
import JavaFXpart.Flowers.FlowerTemplate;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import static JavaFXpart.ActionFlowers.ActionFlowers.flowers;

public class DeletingFlowers
{
    // ===========================================================================================================
    //                                            Deleting flowers part
    // ===========================================================================================================

    FlowerTemplate flowerToDelete;
    ObservableList<FlowerTemplate> deleteList = FXCollections.observableArrayList(flowers);
    ChoiceBox<FlowerTemplate> deleteChoiceBox = new ChoiceBox<FlowerTemplate>(deleteList);
    Button buttonDelete;
    public void deleteFlower()
    {
        Text welcomeDeleteFlower = new StartMenu().textConstructor("Deleting a flower",1,2,80.0,370.0);
        welcomeDeleteFlower.setStyle("-fx-font-size: 24px;");

        StartMenu.pane = new ActionFlowers().flowerMenuView();
        StartMenu.pane.getChildren().add(welcomeDeleteFlower);
        Button confirmButton = new StartMenu().buttonConstructor("Confirm","Confirm the flower deleting",1,2,455.0,425.0);
        confirmButton.setOnAction(actionEvent -> {confirmDeleting();});
        Button backToFlower = new StartMenu().buttonConstructor("Flower menu","Back to 'Flower menu'",1,2,495.0,413.0);
        backToFlower.setOnAction(actionEvent -> {new Receiver().transition(new ActionFlowers());});

        buttonDelete = confirmButton;
        StartMenu.pane.getChildren().add(backToFlower);
        StartMenu.pane.getChildren().add(confirmButton);

        if(!flowers.isEmpty()) {

            deleteChoiceBox = (ChoiceBox<FlowerTemplate>) new StartMenu().positionDetermination(deleteChoiceBox,1,2,150.0,280.0);
            StartMenu.pane.getChildren().add(deleteChoiceBox);

            Text deleteText = new StartMenu().textConstructor("",
                    1,2,280.0,210.0);
            deleteText.setStyle("-fx-font-size: 14px;");
            ChoiceBox<FlowerTemplate> finalDeleteChoiceBox = deleteChoiceBox;
            deleteChoiceBox.setOnAction(event -> { deleteText.setText(finalDeleteChoiceBox.getValue().toString());
                flowerToDelete = finalDeleteChoiceBox.getValue();
                StartMenu.pane.getChildren().add(finalDeleteChoiceBox.getValue().getColor(290));
                if( notCorrectParameters != null) {
                    if(StartMenu.pane.getChildren().contains(notCorrectParameters))
                        StartMenu.pane.getChildren().remove(notCorrectParameters);
                }
            });
            StartMenu.pane.getChildren().add(deleteText);
        }
        else {
            Text example = new StartMenu().textConstructor("There are no flowers to delete", 1, 2, 230.0, 360.0);
            example.setStyle("-fx-font-size: 16px;");
            StartMenu.pane.getChildren().remove(buttonDelete);
            StartMenu.pane.getChildren().add(example);
        }
    }

    Text notCorrectParameters;
    public void confirmDeleting()
    {
        if( notCorrectParameters != null && flowerToDelete == null) {
            StartMenu.pane.getChildren().remove(notCorrectParameters);
        }

        if(flowerToDelete != null){
            if(notCorrectParameters != null)    StartMenu.pane.getChildren().remove(notCorrectParameters);
            StartMenu.pane.getChildren().remove(deleteChoiceBox);
            StartMenu.pane.getChildren().remove(buttonDelete);

            Text lastCreation = new StartMenu().textConstructor("\n\nThe flower :\n\n\n\n\nwas deleted",1,2,170.0,395.0);
            lastCreation.setStyle("-fx-font-size: 18px;");

            StartMenu.pane.getChildren().add(lastCreation);
            flowers.remove(flowerToDelete);
        }
        else{
            notCorrectParameters = new StartMenu().textConstructor("No flower was selected",1,2,210.0,395.0);
            notCorrectParameters.setFill(Color.RED);
            StartMenu.pane.getChildren().add(notCorrectParameters);
        }
    }
}
