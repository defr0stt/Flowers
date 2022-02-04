package JavaFXpart.ActionFlowers.Actions;

import JavaFXpart.ActionFlowers.ActionFlowers;
import JavaFXpart.Flowers.FlowerTemplate;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.Receiver.TextElements;
import JavaFXpart.StartMenu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

import static JavaFXpart.ActionFlowers.ActionFlowers.flowers;
import static JavaFXpart.Logger.Logger.logger;

public class DeletingFlowers
{
    // ===========================================================================================================
    //                                            Deleting flowers part
    // ===========================================================================================================

    FlowerTemplate flowerToDelete;
    ObservableList<FlowerTemplate> deleteList = FXCollections.observableArrayList(flowers);
    ChoiceBox<FlowerTemplate> deleteChoiceBox = new ChoiceBox<FlowerTemplate>(deleteList);
    Button buttonDelete;
    Button deleteAll;
    Ellipse colorEllipse;
    Text deleteText;
    public void deleteFlower()
    {
        logger.info("DELETING A FLOWER");

        Text welcomeDeleteFlower = new StartMenu().textConstructor("Deleting a flower",1,2,80.0,370.0);
        welcomeDeleteFlower.setStyle("-fx-font-size: 24px;");

        StartMenu.pane = new ActionFlowers().flowerMenuView();
        StartMenu.pane.getChildren().add(welcomeDeleteFlower);
        Button confirmButton = new StartMenu().buttonConstructor(TextElements.confirm,"Confirm the flower deleting",1,2,415.0,425.0);
        confirmButton.setOnAction(actionEvent -> {confirmDeleting();});
        Button delAll = new StartMenu().buttonConstructor("Delete all flowers","Delete all created flowers",1,2,455.0,400.0);
        delAll.setOnAction(actionEvent -> {clearAll();});
        Button backToFlower = new StartMenu().buttonConstructor("Flower menu","Back to 'Flower menu'",1,2,495.0,413.0);
        backToFlower.setOnAction(actionEvent -> {new Receiver().transition(new ActionFlowers());});

        buttonDelete = confirmButton;
        deleteAll = delAll;
        StartMenu.pane.getChildren().add(delAll);
        StartMenu.pane.getChildren().add(backToFlower);
        StartMenu.pane.getChildren().add(confirmButton);

        if(!flowers.isEmpty()) {

            deleteChoiceBox = (ChoiceBox<FlowerTemplate>) new StartMenu().positionDetermination(deleteChoiceBox,1,2,150.0,280.0);
            StartMenu.pane.getChildren().add(deleteChoiceBox);

            deleteText = new StartMenu().textConstructor("",
                    1,2,280.0,210.0);
            deleteText.setStyle("-fx-font-size: 14px;");
            ChoiceBox<FlowerTemplate> finalDeleteChoiceBox = deleteChoiceBox;
            deleteChoiceBox.setOnAction(event -> { deleteText.setText(finalDeleteChoiceBox.getValue().toString());
                flowerToDelete = finalDeleteChoiceBox.getValue();
                colorEllipse = finalDeleteChoiceBox.getValue().getColor(670,290);
                StartMenu.pane.getChildren().add(colorEllipse);
                if( notCorrectParameters != null) {
                    if(StartMenu.pane.getChildren().contains(notCorrectParameters))
                        StartMenu.pane.getChildren().remove(notCorrectParameters);
                }
            });
            StartMenu.pane.getChildren().add(deleteText);
        }
        else {
            Text example = new StartMenu().textConstructor(TextElements.noFlowersDelete, 1, 2, 230.0, 360.0);
            example.setStyle("-fx-font-size: 16px;");
            StartMenu.pane.getChildren().remove(buttonDelete);
            StartMenu.pane.getChildren().remove(deleteAll);
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
            new StartMenu().deleteElements((AnchorPane) StartMenu.pane, new Node[]{deleteChoiceBox,buttonDelete,deleteAll});

            Text lastCreation = new StartMenu().textConstructor("\n\nThe flower :\n\n\n\n\nwas deleted",1,2,170.0,395.0);
            lastCreation.setStyle("-fx-font-size: 18px;");

            StartMenu.pane.getChildren().add(lastCreation);
            flowers.remove(flowerToDelete);

            logger.info("FLOWER WAS DELETED");
        }
        else{
            notCorrectParameters = new StartMenu().textConstructor(TextElements.noFlowersSelected,1,2,210.0,395.0);
            notCorrectParameters.setFill(Color.RED);
            StartMenu.pane.getChildren().add(notCorrectParameters);
        }
    }

    public void clearAll()
    {
        if( notCorrectParameters != null && StartMenu.pane.getChildren().contains(notCorrectParameters)) {
            StartMenu.pane.getChildren().remove(notCorrectParameters);
        }
        if (deleteText != null && colorEllipse != null && StartMenu.pane.getChildren().contains(deleteText) &&
                StartMenu.pane.getChildren().contains(colorEllipse)){
            StartMenu.pane.getChildren().remove(deleteText);
            StartMenu.pane.getChildren().remove(colorEllipse);
        }
        new StartMenu().deleteElements((AnchorPane) StartMenu.pane, new Node[]{deleteChoiceBox,buttonDelete,deleteAll});

        Text lastCreation = new StartMenu().textConstructor("All flowers deleted",1,2,270.0,375.0);
        lastCreation.setStyle("-fx-font-size: 18px;");

        StartMenu.pane.getChildren().add(lastCreation);
        flowers.clear();

        logger.info("ALL FLOWERS WERE DELETED");
    }
}
