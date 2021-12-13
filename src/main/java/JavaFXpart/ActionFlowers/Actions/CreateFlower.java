package JavaFXpart.ActionFlowers.Actions;

import JavaFXpart.ActionFlowers.ActionFlowers;
import JavaFXpart.Flowers.*;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

import static JavaFXpart.ActionFlowers.ActionFlowers.flowers;
import static JavaFXpart.Logger.Logger.logger;

public class CreateFlower
{
    // ===========================================================================================================
    //                                             Creating flower part
    // ===========================================================================================================

    public void createFlower()
    {
        logger.info("CREATING A FLOWER");

        Text welcomeCreateFlower = new StartMenu().textConstructor("Creating a flower",1,2,80.0,370.0);
        welcomeCreateFlower.setStyle("-fx-font-size: 24px;");

        StartMenu.pane = new ActionFlowers().flowerMenuView();

        RadioButton rose = new StartMenu().buttonConstructor("Rose",1,2,170.0,400.0);
        rose.setOnAction(actionEvent -> {chooseFlowerToCreate(1);});
        RadioButton chrysanthemum = new StartMenu().buttonConstructor("Chrysanthemum",1,2,190.0,400.0);
        chrysanthemum.setOnAction(actionEvent -> {chooseFlowerToCreate(2);});
        RadioButton lily = new StartMenu().buttonConstructor("Lily",1,2,210.0,400.0);
        lily.setOnAction(actionEvent -> {chooseFlowerToCreate(3);});
        RadioButton orchid = new StartMenu().buttonConstructor("Orchid",1,2,230.0,400.0);
        orchid.setOnAction(actionEvent -> {chooseFlowerToCreate(4);});
        RadioButton tulip = new StartMenu().buttonConstructor("Tulip",1,2,250.0,400.0);
        tulip.setOnAction(actionEvent -> {chooseFlowerToCreate(5);});

        ToggleGroup radioButtonGroup = new ToggleGroup();
        rose.setToggleGroup(radioButtonGroup);
        chrysanthemum.setToggleGroup(radioButtonGroup);
        lily.setToggleGroup(radioButtonGroup);
        orchid.setToggleGroup(radioButtonGroup);
        tulip.setToggleGroup(radioButtonGroup);

        Button confirmButton = new StartMenu().buttonConstructor("Confirm","Confirm the flower creation",1,2,455.0,425.0);
        confirmButton.setOnAction(actionEvent -> {confirmingCreation();});
        Button backToFlower = new StartMenu().buttonConstructor("Flower menu","Back to 'Flower menu'",1,2,495.0,413.0);
        backToFlower.setOnAction(actionEvent -> {new Receiver().transition(new ActionFlowers());});

        StartMenu.pane = new StartMenu().sumAllElements((AnchorPane) StartMenu.pane,
                new Node[]{welcomeCreateFlower, backToFlower, rose, chrysanthemum, lily, orchid, tulip, confirmButton});
    }

    int createNumber;
    public void chooseFlowerToCreate(int i)
    {
        createNumber = i;
        if( StartMenu.pane.getChildren().get(StartMenu.pane.getChildren().size()-1).getClass().getName()
                == "javafx.scene.text.Text") {
            StartMenu.pane.getChildren().remove(StartMenu.pane.getChildren().size() - 1);
        }
        if( StartMenu.pane.getChildren().get(StartMenu.pane.getChildren().size()-1).getClass().getName()
                != "javafx.scene.control.Button") {
            StartMenu.pane.getChildren().remove(StartMenu.pane.getChildren().size()-1);
            StartMenu.pane.getChildren().remove(StartMenu.pane.getChildren().size()-1);
            StartMenu.pane.getChildren().remove(StartMenu.pane.getChildren().size()-1);
        }
        colorGlobal = null;
        day = 0;
        len = 0;
        switch (i){
            case 1: inputToChoose(); createFlowerColor(Color.RED,Color.PINK,Color.WHITE);break;
            case 2: inputToChoose(); createFlowerColor(Color.CRIMSON,Color.YELLOW,Color.MEDIUMPURPLE);break;
            case 3: inputToChoose(); createFlowerColor(Color.ORANGE,Color.YELLOW,Color.WHITE);break;
            case 4: inputToChoose(); createFlowerColor(Color.MEDIUMVIOLETRED,Color.MAGENTA,Color.WHITE);break;
            case 5: inputToChoose(); createFlowerColor(Color.MEDIUMVIOLETRED,Color.RED,Color.YELLOW);break;
        }
    }

    int len, day;
    public void inputToChoose()
    {
        Slider sliderLength = new Slider(0,100,0);
        sliderLength.setShowTickMarks(true);
        sliderLength.setShowTickLabels(true);

        Slider sliderDays = new Slider(0,15,0);
        sliderDays.setShowTickMarks(true);
        sliderDays.setShowTickLabels(true);
        sliderDays.setMinorTickCount(5);
        sliderDays.setMajorTickUnit(5);


        Label labelLength = new Label("  <- Length = " + sliderLength.getValue(),sliderLength);
        labelLength = (Label) new StartMenu().positionDetermination(labelLength,1,2,350.0,370.0);

        Label labelDays = new Label("  <- Days = " + sliderDays.getValue(),sliderDays);
        labelDays = (Label) new StartMenu().positionDetermination(labelDays,1,2,395.0,370.0);

        Label finalLabelLength = labelLength;
        sliderLength.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue){
                len = newValue.intValue();
                finalLabelLength.setText("  <- Length = " + len);
            }
        });

        Label finalLabelDays = labelDays;
        sliderDays.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue){
                day = newValue.intValue();
                finalLabelDays.setText("  <- Days = " + day);
            }
        });

        StartMenu.pane.getChildren().add(finalLabelLength);
        StartMenu.pane.getChildren().add(finalLabelDays);
    }

    Color colorGlobal;
    public void createFlowerColor(Color a, Color b, Color c)
    {
        Ellipse ellipse1 = new StartMenu().ellipseConstructor(370,325,10,10,a,Color.BLACK,1);
        Ellipse ellipse2 = new StartMenu().ellipseConstructor(395,325,10,10,b,Color.BLACK,1);
        Ellipse ellipse3 = new StartMenu().ellipseConstructor(420,325,10,10,c,Color.BLACK,1);

        Group group = new Group();
        group.getChildren().add(ellipse1);
        group.getChildren().add(ellipse2);
        group.getChildren().add(ellipse3);

        Label ellipseLabel = new Label("  <- Colors",group);
        ellipseLabel = (Label) new StartMenu().positionDetermination(ellipseLabel,1,2,310.0,375.0);

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

    public void confirmingCreation()
    {
        if( StartMenu.pane.getChildren().get(StartMenu.pane.getChildren().size()-1).getClass().getName()
                == "javafx.scene.text.Text") {
            StartMenu.pane.getChildren().remove(StartMenu.pane.getChildren().size() - 1);
        }

        if(len != 0 && day !=0 && colorGlobal != null){
            for (int i =0; i<9; i++) {
                StartMenu.pane.getChildren().remove(StartMenu.pane.getChildren().size() - 1);
            }
            switch (createNumber){
                case 1: flowers.add(new Rose(len,day,colorGlobal));break;
                case 2: flowers.add(new Chrysanthemum(len,day,colorGlobal));break;
                case 3: flowers.add(new Lily(len,day,colorGlobal));break;
                case 4: flowers.add(new Orchid(len,day,colorGlobal));break;
                case 5: flowers.add(new Tulip(len,day,colorGlobal));break;
            }
            Text finishToString = new StartMenu().textConstructor(flowers.get(flowers.size()-1).toString(),
                    1,2,280.0,210.0);
            finishToString.setStyle("-fx-font-size: 14px;");
            Ellipse finalEllipse = flowers.get(flowers.size()-1).getColor(670,290);

            Text lastCreation = new StartMenu().textConstructor("Created flower :",1,2,170.0,395.0);
            lastCreation.setStyle("-fx-font-size: 18px;");

            StartMenu.pane.getChildren().add(finishToString);
            StartMenu.pane.getChildren().add(finalEllipse);
            StartMenu.pane.getChildren().add(lastCreation);

            logger.info("END OF CREATING");
        }
        else{
            Text notCorrectParameters = new StartMenu().textConstructor("Incorrect parameters or\n nothing were selected",1,2,210.0,235.0);
            notCorrectParameters.setFill(Color.RED);
            StartMenu.pane.getChildren().add(notCorrectParameters);
        }
    }
}
