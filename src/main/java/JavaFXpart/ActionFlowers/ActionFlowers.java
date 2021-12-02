package JavaFXpart.ActionFlowers;

import JavaFXpart.Flowers.FlowerTemplate;
import JavaFXpart.Flowers.Rose;
import JavaFXpart.Flowers.Chrysanthemum;
import JavaFXpart.Receiver.Command;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
        Button flowerList = new StartMenu().buttonConstructor("Flower list","Detailed information about the created flowers",1,2,335.0,425.0);
        flowerList.setOnAction(actionEvent -> {new Receiver().variation(new ActionFlowers(),3);});
        Button createFlower = new StartMenu().buttonConstructor("Create flower","The process of creating flowers",1,2,275.0,417.0);
        createFlower.setOnAction(actionEvent -> {new Receiver().variation(new ActionFlowers(),1);});

        StartMenu.pane = flowerMenuView();
        StartMenu.pane = new StartMenu().sumAllElements((AnchorPane) StartMenu.pane,
                new Node[]{flowerList, createFlower});
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

        StartMenu.pane = new StartMenu().sumAllElements((AnchorPane) StartMenu.pane,
                new Node[]{welcomeCreateFlower, rose, chrysanthemum, lily, orchid, tulip});
    }

    public void chooseFlowerToCreate(int i)     // todo add some cases
    {
        if( StartMenu.pane.getChildren().get(StartMenu.pane.getChildren().size()-1).getClass().getName()
                != "javafx.scene.control.RadioButton") {
            StartMenu.pane.getChildren().remove(StartMenu.pane.getChildren().size()-1);
            StartMenu.pane.getChildren().remove(StartMenu.pane.getChildren().size()-1);
            StartMenu.pane.getChildren().remove(StartMenu.pane.getChildren().size()-1);
        }
        switch (i){
            case 1: inputToChoose(); createFlowerColor(Color.RED,Color.PINK,Color.WHITE);break;
            case 2: inputToChoose();createFlowerColor(Color.CRIMSON,Color.YELLOW,Color.MEDIUMPURPLE);break;
            case 3: inputToChoose();createFlowerColor(Color.ORANGE,Color.YELLOW,Color.WHITE);break;
            case 4: inputToChoose();createFlowerColor(Color.MEDIUMVIOLETRED,Color.MAGENTA,Color.WHITE);break;
            case 5: inputToChoose();createFlowerColor(Color.MEDIUMVIOLETRED,Color.RED,Color.YELLOW);break;
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
                        colorGlobal = (Color) ellipse1.getFill();
                        finalLabelDays.setText("  <- Color = 2");
                    }
                });

        ellipse3.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent me) {
                        colorGlobal = (Color) ellipse1.getFill();
                        finalLabelDays.setText("  <- Color = 3");
                    }
                });
        StartMenu.pane.getChildren().add(finalLabelDays);
    }
}
