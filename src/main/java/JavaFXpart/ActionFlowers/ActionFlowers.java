package JavaFXpart.ActionFlowers;

import JavaFXpart.Flowers.*;
import JavaFXpart.Receiver.Command;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
        Button createFlower = new StartMenu().buttonConstructor("Create flower","The process of creating flowers",1,2,215.0,417.0);
        createFlower.setOnAction(actionEvent -> {new Receiver().variation(new ActionFlowers(),1);});
        Button deleteFlower = new StartMenu().buttonConstructor("Delete flower","The process of deleting flowers",1,2,255.0,417.0);
        deleteFlower.setOnAction(actionEvent -> {new Receiver().variation(new ActionFlowers(),2);});
        Button flowerList = new StartMenu().buttonConstructor("Flower list","Detailed information about the created flowers",1,2,295.0,425.0);
        flowerList.setOnAction(actionEvent -> {new Receiver().variation(new ActionFlowers(),3);});
        Button mainMenu = new StartMenu().buttonConstructor("Main menu","Back 'Main menu'",1,2,375.0,422.0);
        mainMenu.setOnAction(actionEvent -> {
            try {
                new StartMenu().start(StartMenu.defaultStage);
            } catch (IOException e) {
                e.printStackTrace();
            }});

        StartMenu.pane = flowerMenuView();
        StartMenu.pane = new StartMenu().sumAllElements((AnchorPane) StartMenu.pane,
                new Node[]{createFlower, deleteFlower, flowerList , mainMenu});
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

    // ===========================================================================================================
    //                                             Creating flower part
    // ===========================================================================================================

    public void createFlower()
    {
        Text welcomeCreateFlower = new StartMenu().textConstructor("Creating a flower",1,2,80.0,370.0);
        welcomeCreateFlower.setStyle("-fx-font-size: 24px;");

        StartMenu.pane = flowerMenuView();

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
        sliderLength.setSnapToTicks(true);
        sliderLength.setShowTickMarks(true);
        sliderLength.setShowTickLabels(true);

        Slider sliderDays = new Slider(0,15,0);
        sliderDays.setSnapToTicks(true);
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
            Ellipse finalEllipse = flowers.get(flowers.size()-1).getColor(290);

            Text lastCreation = new StartMenu().textConstructor("Created flower :",1,2,170.0,395.0);
            lastCreation.setStyle("-fx-font-size: 18px;");

            StartMenu.pane.getChildren().add(finishToString);
            StartMenu.pane.getChildren().add(finalEllipse);
            StartMenu.pane.getChildren().add(lastCreation);
        }
        else{
            Text notCorrectParameters = new StartMenu().textConstructor("Incorrect parameters or\n nothing were selected",1,2,210.0,235.0);
            notCorrectParameters.setFill(Color.RED);
            StartMenu.pane.getChildren().add(notCorrectParameters);
        }
    }

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

        StartMenu.pane = flowerMenuView();
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
                                                   System.out.println(StartMenu.pane.getChildren().size());
                                                    });
            StartMenu.pane.getChildren().add(deleteText);
            System.out.println(StartMenu.pane.getChildren().size());

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

    // ===========================================================================================================
    //                                             List of flowers part
    // ===========================================================================================================

    public void flowerList()
    {
        Text welcomeFlowerList = new StartMenu().textConstructor("Flower list",1,2,80.0,400.0);
        welcomeFlowerList.setStyle("-fx-font-size: 24px;");

        StartMenu.pane = flowerMenuView();

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
