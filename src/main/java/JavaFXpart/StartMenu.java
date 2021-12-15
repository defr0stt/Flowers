package JavaFXpart;

import JavaFXpart.ActionFlowers.ActionFlowers;
import JavaFXpart.Additional.Additional;
import JavaFXpart.Logger.Logger;
import JavaFXpart.Receiver.Receiver;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

import static JavaFXpart.Logger.Logger.logger;

public class StartMenu extends Application {

    public static void main(String[] args) {
        Handler fileHandler = null;
        try {
            fileHandler = new FileHandler("%h/LoggerFlowers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileHandler.setFormatter(new Logger.MyFormatter());
        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);
        logger.info("START OF THE PROGRAM");

        new Receiver().variation(14);

        launch();
    }

    public static Pane pane;
    public static Stage defaultStage;

    @Override
    public void start(Stage stage) throws IOException {

        logger.info("MAIN MENU");
        defaultStage = stage;
        // ===========================================================================================================
        //                                   Main menu greeting and imagine of flower
        // ===========================================================================================================

        Text welcomeText = textConstructor("Welcome  to  the  program  'Flowers' !",1,2,50.0,250.0);
        welcomeText.setStyle("-fx-font-size: 24px;");

        ImageView welcomeImageView = imageConstructor("resources/flower.png",1,2,110.0,385.0);

        // ===========================================================================================================
        //                                                  Main menu buttons
        // ===========================================================================================================

        Button flower = buttonConstructor("Flower","Flower menu",1,2,290.0,425.0);                 // button 'Flower'
        flower.setOnAction(actionEvent -> {new Receiver().transition(new ActionFlowers());});

        Button additional = buttonConstructor("Additional","Additional menu",1,2,335.0,415.0);     // button 'Additional'
        additional.setOnAction(actionEvent -> {new Receiver().transition(new Additional());});

        Button exit = buttonConstructor("Exit","Finishes the program",1,2,380.0,430.0);
        exit.setOnAction(actionEvent -> {logger.info("END OF THE PROGRAM");System.exit(0);});

        // ===========================================================================================================
        //                                                  Connecting all parts
        // ===========================================================================================================

        AnchorPane anchorPane = authorPlusImagePulsing(welcomeText);
        anchorPane = (AnchorPane) sumAllElements(anchorPane, new Node[]{welcomeImageView,flower,additional,exit});

        sceneStarter(anchorPane,stage);
    }

    public AnchorPane authorPlusImagePulsing(Text text) throws FileNotFoundException {

        Text textAuthorRightBottomPage = new Text("Program 'Flowers' by Dmytro Dykyi CS-203");      // author int the right bottom
        textAuthorRightBottomPage.setStyle("-fx-font-weight: bold");                                  // bold text
        AnchorPane.setRightAnchor(textAuthorRightBottomPage,10.0);                            //
        AnchorPane.setBottomAnchor(textAuthorRightBottomPage,10.0);                           //

        Image pulseLeftBottomImage = new Image(new FileInputStream ("resources/flower.png"));
        ImageView pulseLeftBottomImageView = new ImageView(pulseLeftBottomImage);
        pulseLeftBottomImageView.setFitHeight(35);
        pulseLeftBottomImageView.setFitWidth(35);
        AnchorPane.setBottomAnchor(pulseLeftBottomImageView,10.0);
        AnchorPane.setLeftAnchor(pulseLeftBottomImageView,10.0);

        FadeTransition fadeOut = new FadeTransition (Duration.millis(1000), pulseLeftBottomImageView);  // pulsing of image left bottom
        fadeOut.setToValue(0.3);                                                                        // finish value of pulsing
        fadeOut.setFromValue(1.0);                                                                      // start value of pulsing
        fadeOut.setCycleCount (Timeline. INDEFINITE);                                                   // times of pulsing
        fadeOut.setAutoReverse(true);                                                                   // repeats of pulsing in 2 ways
        fadeOut.play();

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(textAuthorRightBottomPage);
        anchorPane.getChildren().add(pulseLeftBottomImageView);
        anchorPane.getChildren().add(text);
        return anchorPane;
    }

    public void sceneStarter (Pane pane, Stage stage)
    {
        Scene scene = new Scene(pane, 900, 550);
        stage.setResizable(false);
        stage.setTitle("Flowers");
        stage.getIcons().add(new Image("file:resources/flower.png"));
        stage.setScene(scene);
        stage.show();
    }

    public Button buttonConstructor (String buttonName, String mouseOnButtonName, int leveling1, int leveling2, Double paramTB, Double paramRL)
    {
        Button buttonExample = new Button(buttonName);
        buttonExample = (Button) positionDetermination(buttonExample,leveling1,leveling2,paramTB,paramRL);
        Tooltip exitTooltip = new Tooltip();
        exitTooltip.setText(mouseOnButtonName);
        buttonExample.setTooltip(exitTooltip);
        return buttonExample;
    }

    public RadioButton buttonConstructor (String buttonName, int leveling1, int leveling2, Double paramTB, Double paramRL)
    {
        RadioButton buttonExample = new RadioButton(buttonName);
        buttonExample = (RadioButton) positionDetermination(buttonExample,leveling1,leveling2,paramTB,paramRL);
        return buttonExample;
    }

    public Ellipse ellipseConstructor(double v1, double v2, double v3, double v4, Color fill, Color width, double strokeWidth)
    {
        Ellipse ellipseExample = new Ellipse(v1,v2,v3,v4);
        ellipseExample.setFill(fill);
        ellipseExample.setStrokeWidth(strokeWidth);
        ellipseExample.setStroke(width);
        return ellipseExample;
    }

    public Text textConstructor(String textName, int leveling1, int leveling2, Double paramTB, Double paramRL )
    {
        Text textExample = new Text(textName);
        textExample = (Text) positionDetermination(textExample,leveling1,leveling2,paramTB,paramRL);
        return textExample;
    }

    public ImageView imageConstructor(String wayToImage, int leveling1, int leveling2, Double paramTB, Double paramRL) throws FileNotFoundException {
        Image exampleImage = new Image(new FileInputStream (wayToImage));
        ImageView exampleImageView = new ImageView(exampleImage);
        exampleImageView = (ImageView) positionDetermination(exampleImageView,leveling1,leveling2,paramTB,paramRL);
        return exampleImageView;
    }

    public Node positionDetermination (Node node, int leveling1, int leveling2, Double paramTB, Double paramRL)
    {
        switch (leveling1){
            case 1:AnchorPane.setTopAnchor(node,paramTB);
            case 2:AnchorPane.setTopAnchor(node,paramTB);
        }
        switch (leveling2){
            case 1:AnchorPane.setRightAnchor(node,paramRL);
            case 2:AnchorPane.setLeftAnchor(node,paramRL);
        }
        return node;
    }

    public Pane sumAllElements(AnchorPane anchorPane, Node[] obj)
    {
        for (Node a: obj) anchorPane.getChildren().add(a);
        return anchorPane;
    }

    public Pane deleteElements(AnchorPane anchorPane, Node[] obj)
    {
        for (Node a: obj) anchorPane.getChildren().remove(a);
        return anchorPane;
    }
}