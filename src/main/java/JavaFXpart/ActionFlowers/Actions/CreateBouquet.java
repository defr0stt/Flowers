package JavaFXpart.ActionFlowers.Actions;

import JavaFXpart.ActionFlowers.ActionFlowers;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import static JavaFXpart.ActionFlowers.ActionFlowers.flowers;

public class CreateBouquet
{
    Button confirmButton;
    public void createBouquet()
    {
        Text welcomeBouquet = new StartMenu().textConstructor("Creating a bouquet",1,2,80.0,350.0);
        welcomeBouquet.setStyle("-fx-font-size: 24px;");

        StartMenu.pane = new ActionFlowers().flowerMenuView();
        StartMenu.pane.getChildren().add(welcomeBouquet);

        confirmButton = new StartMenu().buttonConstructor("Confirm","Confirm the flower deleting",1,2,455.0,425.0);
        confirmButton.setOnAction(actionEvent -> {confirmProcess();});
        Button backToFlower = new StartMenu().buttonConstructor("Flower menu","Back to 'Flower menu'",1,2,495.0,413.0);
        backToFlower.setOnAction(actionEvent -> {new Receiver().transition(new ActionFlowers());});

        StartMenu.pane.getChildren().add(backToFlower);
        StartMenu.pane.getChildren().add(confirmButton);

        rangeAndPackaging();
    }

    Label labelMin;
    Label labelMax;
    int min, max;
    RadioButton buttonYES;
    RadioButton buttonNO;
    Text rangeText;
    ToggleGroup radioButtonGroup;
    Text packaging;
    public void rangeAndPackaging()
    {
        if(!flowers.isEmpty()) {

            if (labelMin == null && labelMax == null && radioButtonGroup == null && rangeText == null) {

                rangeText = new StartMenu().textConstructor("Range of length", 1, 2, 170.0, 395.0);
                rangeText.setStyle("-fx-font-size: 14px;");
                StartMenu.pane.getChildren().add(rangeText);

                Slider minSlider = new Slider(0, 100, 0);
                minSlider.setShowTickMarks(true);
                minSlider.setShowTickLabels(true);

                Slider maxSlider = new Slider(0, 100, 0);
                maxSlider.setShowTickMarks(true);
                maxSlider.setShowTickLabels(true);

                labelMin = new Label("  <- min = " + minSlider.getValue(), minSlider);
                labelMin = (Label) new StartMenu().positionDetermination(labelMin, 1, 2, 220.0, 355.0);

                labelMax = new Label("  <- max = " + maxSlider.getValue(), maxSlider);
                labelMax = (Label) new StartMenu().positionDetermination(labelMax, 1, 2, 270.0, 355.0);

                minSlider.valueProperty().addListener(new ChangeListener<Number>() {
                    public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                        min = newValue.intValue();
                        labelMin.setText("  <- min = " + min);
                    }
                });

                maxSlider.valueProperty().addListener(new ChangeListener<Number>() {
                    public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue) {
                        max = newValue.intValue();
                        labelMax.setText("  <- max = " + max);
                    }
                });
                StartMenu.pane.getChildren().add(labelMin);
                StartMenu.pane.getChildren().add(labelMax);

                buttonYES = new StartMenu().buttonConstructor("YES", 1, 2, 390.0, 400.0);
                buttonNO = new StartMenu().buttonConstructor("NO", 1, 2, 390.0, 470.0);
                radioButtonGroup = new ToggleGroup();
                buttonYES.setToggleGroup(radioButtonGroup);
                buttonNO.setToggleGroup(radioButtonGroup);
                packaging = new StartMenu().textConstructor("Packaging of bouquet = 5 $", 1, 2, 350.0, 370.0);
                packaging.setStyle("-fx-font-size: 14px;");
                StartMenu.pane.getChildren().add(buttonYES);
                StartMenu.pane.getChildren().add(buttonNO);
                StartMenu.pane.getChildren().add(packaging);
            }
        }
        else {
            Text example = new StartMenu().textConstructor("There are no flowers to\n     create bouquet", 1, 2, 230.0, 370.0);
            example.setStyle("-fx-font-size: 16px;");
            StartMenu.pane.getChildren().remove(confirmButton);
            StartMenu.pane.getChildren().add(example);
        }
    }

    Text incorrect;
    public void confirmProcess()
    {
        if( (min != 0 && max != 0 && min<max) && (radioButtonGroup.getSelectedToggle() != null) ){
            RadioButton a = (RadioButton) radioButtonGroup.getSelectedToggle();
            if(a.getText().equals("YES")) pack = 1;
            else pack = 0;
            creatingProcess();
        }
        else{
            if(incorrect == null) {
                incorrect = new StartMenu().textConstructor("Parameters are \nunselected\nor min > max", 1, 2, 190.0, 215.0);
                incorrect.setFill(Color.RED);
                StartMenu.pane.getChildren().add(incorrect);
            }
        }
    }

    int pack;
    public void creatingProcess()
    {
        new StartMenu().deleteElements((AnchorPane) StartMenu.pane,
                new Node[]{confirmButton,labelMin,labelMax,rangeText,buttonYES,buttonNO,packaging});
        if(incorrect != null)   StartMenu.pane.getChildren().remove(incorrect);
    }
}
