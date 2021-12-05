package JavaFXpart.ActionFlowers.Actions;

import JavaFXpart.ActionFlowers.ActionFlowers;
import JavaFXpart.Flowers.FlowerTemplate;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

import static JavaFXpart.ActionFlowers.ActionFlowers.flowers;

public class ChangeParameters
{
    // ===========================================================================================================
    //                                         Changing flower parameters part
    // ===========================================================================================================

    ObservableList<FlowerTemplate> changeList = FXCollections.observableArrayList(flowers);
    ChoiceBox<FlowerTemplate> changeChoiceBox = new ChoiceBox<FlowerTemplate>(changeList);
    Button confirmChange;
    FlowerTemplate flowerToChange;
    Text changeText;
    Ellipse currentColor;
    public void changeFlowerParameters()
    {
        Text welcomeChangeFlower = new StartMenu().textConstructor("Changing a flower",1,2,80.0,370.0);
        welcomeChangeFlower.setStyle("-fx-font-size: 24px;");

        StartMenu.pane = new ActionFlowers().flowerMenuView();
        StartMenu.pane.getChildren().add(welcomeChangeFlower);
        Button confirmButton = new StartMenu().buttonConstructor("Confirm","Confirm the flower deleting",1,2,455.0,425.0);
        confirmButton.setOnAction(actionEvent -> {confirmChanging();});
        Button backToFlower = new StartMenu().buttonConstructor("Flower menu","Back to 'Flower menu'",1,2,495.0,413.0);
        backToFlower.setOnAction(actionEvent -> {new Receiver().transition(new ActionFlowers());});

        confirmChange = confirmButton;
        StartMenu.pane.getChildren().add(backToFlower);
        StartMenu.pane.getChildren().add(confirmButton);

        if(!flowers.isEmpty()) {

            changeChoiceBox = (ChoiceBox<FlowerTemplate>) new StartMenu().positionDetermination(changeChoiceBox,1,2,150.0,280.0);
            StartMenu.pane.getChildren().add(changeChoiceBox);

            changeText = new StartMenu().textConstructor("",
                    1,2,280.0,210.0);
            changeText.setStyle("-fx-font-size: 14px;");
            ChoiceBox<FlowerTemplate> finalDeleteChoiceBox = changeChoiceBox;
            changeChoiceBox.setOnAction(event -> { changeText.setText(finalDeleteChoiceBox.getValue().toString());
                flowerToChange = finalDeleteChoiceBox.getValue();
                currentColor = finalDeleteChoiceBox.getValue().getColor(290);
                StartMenu.pane.getChildren().add(finalDeleteChoiceBox.getValue().getColor(290));
                checkFunction();
                buttonsToChange();
            });
            StartMenu.pane.getChildren().add(changeText);
        }
        else {
            Text example = new StartMenu().textConstructor("There are no flowers to change", 1, 2, 230.0, 360.0);
            example.setStyle("-fx-font-size: 16px;");
            StartMenu.pane.getChildren().remove(confirmChange);
            StartMenu.pane.getChildren().add(example);
        }
    }

    Text notCorrectParameters;
    public void confirmChanging()
    {
        if( notCorrectParameters != null && flowerToChange == null) {
            if(StartMenu.pane.getChildren().contains(notCorrectParameters))
                StartMenu.pane.getChildren().remove(notCorrectParameters);
        }

        if(flowerToChange != null){         //todo
            insertParameters();
            if(paramText == null) {
                if (notCorrectParameters != null) StartMenu.pane.getChildren().remove(notCorrectParameters);
                StartMenu.pane.getChildren().remove(changeChoiceBox);
                StartMenu.pane.getChildren().remove(confirmChange);
                StartMenu.pane.getChildren().remove(length);
                StartMenu.pane.getChildren().remove(days);
                StartMenu.pane.getChildren().remove(color);
                StartMenu.pane.getChildren().remove(changeText);
                StartMenu.pane.getChildren().remove(currentColor);

                changeText = new StartMenu().textConstructor(flowerToChange.toString(),
                        1, 2, 280.0, 210.0);
                changeText.setStyle("-fx-font-size: 14px;");
                currentColor = flowerToChange.getColor(290);

                StartMenu.pane.getChildren().add(changeText);
                StartMenu.pane.getChildren().add(currentColor);

                checkFunction();

                Text lastCreation = new StartMenu().textConstructor("\n\nThe flower :\n\n\n\n\nwas changed", 1, 2, 170.0, 395.0);
                lastCreation.setStyle("-fx-font-size: 18px;");

                StartMenu.pane.getChildren().add(lastCreation);
            }
        }
        else{
            notCorrectParameters = new StartMenu().textConstructor("No flower was selected",1,2,210.0,395.0);
            notCorrectParameters.setFill(Color.RED);
            StartMenu.pane.getChildren().add(notCorrectParameters);
        }
    }

    RadioButton length;
    RadioButton days;
    RadioButton color;
    public void buttonsToChange()
    {
        if( length != null && days != null && color != null) {
            StartMenu.pane.getChildren().remove(length);
            StartMenu.pane.getChildren().remove(days);
            StartMenu.pane.getChildren().remove(color);
        }

        length = new StartMenu().buttonConstructor("Length",1,2,210.0,400.0);
        length.setOnAction(actionEvent -> {parametersToChange(1);});
        days = new StartMenu().buttonConstructor("Days",1,2,230.0,400.0);
        days.setOnAction(actionEvent -> {parametersToChange(2);});
        color = new StartMenu().buttonConstructor("Color",1,2,250.0,400.0);
        color.setOnAction(actionEvent -> {colorToChange(flowerToChange.getName());});

        ToggleGroup radioButtonGroup = new ToggleGroup();
        length.setToggleGroup(radioButtonGroup);
        days.setToggleGroup(radioButtonGroup);
        color.setToggleGroup(radioButtonGroup);

        StartMenu.pane.getChildren().add(length);
        StartMenu.pane.getChildren().add(days);
        StartMenu.pane.getChildren().add(color);
    }

    int len, day;
    Label labelLength;
    Label labelDays;
    public void parametersToChange(int i)
    {
        checkFunction();

        Slider sliderLength = new Slider(0,100,0);
        sliderLength.setShowTickMarks(true);
        sliderLength.setShowTickLabels(true);

        Slider sliderDays = new Slider(0,15,0);
        sliderDays.setShowTickMarks(true);
        sliderDays.setShowTickLabels(true);
        sliderDays.setMinorTickCount(5);
        sliderDays.setMajorTickUnit(5);


        labelLength = new Label("   <- Length = " + sliderLength.getValue(),sliderLength);
        labelLength = (Label) new StartMenu().positionDetermination(labelLength,1,2,350.0,370.0);

        labelDays = new Label("   <- Days = " + sliderDays.getValue(),sliderDays);
        labelDays = (Label) new StartMenu().positionDetermination(labelDays,1,2,350.0,370.0);

        Label finalLabelLength = labelLength;
        sliderLength.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue){
                len = newValue.intValue();
                finalLabelLength.setText("   <- Length = " + len);
            }
        });

        Label finalLabelDays = labelDays;
        sliderDays.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue){
                day = newValue.intValue();
                finalLabelDays.setText("   <- Days = " + day);
            }
        });

        switch (i){
            case 1: StartMenu.pane.getChildren().add(finalLabelLength);break;
            case 2: StartMenu.pane.getChildren().add(finalLabelDays);break;
        }
    }

    Color colorGlobal;
    Label ellipseLabel;
    public void colorToChange(String name)
    {
        checkFunction();

        Color a = null, b = null, c = null;
        switch (name){
            case "Rose": a = Color.RED; b = Color.PINK; c = Color.WHITE;break;
            case "Chrysanthemum": a = Color.CRIMSON; b = Color.YELLOW; c = Color.MEDIUMPURPLE;break;
            case "Lily": a = Color.ORANGE; b = Color.YELLOW; c = Color.WHITE;break;
            case "Orchid": a = Color.MEDIUMVIOLETRED; b = Color.MAGENTA; c = Color.WHITE;break;
            case "Tulip": a = Color.MEDIUMVIOLETRED; b = Color.RED; c = Color.YELLOW;break;
        }
        Ellipse ellipse1 = new StartMenu().ellipseConstructor(370,400,10,10,a,Color.BLACK,1);
        Ellipse ellipse2 = new StartMenu().ellipseConstructor(395,400,10,10,b,Color.BLACK,1);
        Ellipse ellipse3 = new StartMenu().ellipseConstructor(420,400,10,10,c,Color.BLACK,1);

        Group group = new Group();
        group.getChildren().add(ellipse1);
        group.getChildren().add(ellipse2);
        group.getChildren().add(ellipse3);

        ellipseLabel = new Label("  <- Colors",group);
        ellipseLabel = (Label) new StartMenu().positionDetermination(ellipseLabel,1,2,350.0,400.0);

        Label finalLabelDays = ellipseLabel;

        ellipse1.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent me) {
                        colorGlobal = (Color) ellipse1.getFill();
                        finalLabelDays.setText("  <- Color = 1");
                    }
                });

        ellipse2.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent me) {
                        colorGlobal = (Color) ellipse2.getFill();
                        finalLabelDays.setText("  <- Color = 2");
                    }
                });

        ellipse3.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent me) {
                        colorGlobal = (Color) ellipse3.getFill();
                        finalLabelDays.setText("  <- Color = 3");
                    }
                });

        StartMenu.pane.getChildren().add(finalLabelDays);
    }

    public void checkFunction()
    {
        if( notCorrectParameters != null) {
            if(StartMenu.pane.getChildren().contains(notCorrectParameters))
                StartMenu.pane.getChildren().remove(notCorrectParameters);
        }
        if (labelLength != null){
            StartMenu.pane.getChildren().remove(labelLength);
            labelLength = null;
            len = 0;
        }
        if (labelDays != null){
            StartMenu.pane.getChildren().remove(labelDays);
            labelDays = null;
            day = 0;
        }
        if (ellipseLabel != null) {
            StartMenu.pane.getChildren().remove(ellipseLabel);
            ellipseLabel = null;
            colorGlobal = null;
        }
        if(paramText != null){
            StartMenu.pane.getChildren().remove(paramText);
            paramText = null;
        }
    }

    Text paramText;
    public void insertParameters()
    {
        if(len != 0 || day != 0 || colorGlobal != null){
            if(len != 0 && len != flowerToChange.getLen()) {
                flowerToChange.setLen(len);
                StartMenu.pane.getChildren().remove(paramText);
                paramText = null;
            }
            else if(day != 0 && day != flowerToChange.getDays()) {
                flowerToChange.setDays(day);
                StartMenu.pane.getChildren().remove(paramText);
                paramText = null;
            }
            else if (colorGlobal != null && colorGlobal != currentColor.getFill()) {
                flowerToChange.setColor(colorGlobal);
                StartMenu.pane.getChildren().remove(paramText);
                paramText = null;
            }
            else {
                if(paramText != null){
                    StartMenu.pane.getChildren().remove(paramText);
                    paramText = null;
                }
                paramText = new StartMenu().textConstructor("Parameter is unselected\nor parameter is similar\n   to previous one",1,2,210.0,235.0);
                paramText.setFill(Color.RED);
                StartMenu.pane.getChildren().add(paramText);
            }
        }
    }
}
