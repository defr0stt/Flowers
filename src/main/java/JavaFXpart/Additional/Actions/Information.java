package JavaFXpart.Additional.Actions;

import JavaFXpart.Additional.Additional;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

import java.io.IOException;

public class Information
{
    public void information() {

        new Additional().additionalMenuView();
        Text infoWelcome = new StartMenu().textConstructor("Information",1,2,80.0,400.0);
        infoWelcome.setStyle("-fx-font-size: 24px;");

        Text infoText = new StartMenu().textConstructor("\n\n\tRose" + "   -   such a beautiful flower, costs 10$" +
                "\n\n\tChrysanthemum" + "   -   unbelievable flower, costs 20$" +
                "\n\n\tLily" + "   -   incredible flower, costs 10$" +
                "\n\n\tOrchid" + "   -  cute flower, costs 15$" +
                "\n\n\tTulip" + "   -   sweaty flower, costs 15$\n",1,2,140.0,390.0);
        infoText.setStyle("-fx-font-size: 16px;");

        Ellipse rose1 = new StartMenu().ellipseConstructor(750,193,10,10, Color.RED,Color.BLACK,1);
        Ellipse rose2 = new StartMenu().ellipseConstructor(775,193,10,10,Color.PINK,Color.BLACK,1);
        Ellipse rose3 = new StartMenu().ellipseConstructor(800,193,10,10,Color.WHITE,Color.BLACK,1);

        Ellipse chrysanthemum1 = new StartMenu().ellipseConstructor(807,237,10,10,Color.CRIMSON,Color.BLACK,1);
        Ellipse chrysanthemum2 = new StartMenu().ellipseConstructor(832,237,10,10,Color.YELLOW,Color.BLACK,1);
        Ellipse chrysanthemum3 = new StartMenu().ellipseConstructor(857,237,10,10,Color.MEDIUMPURPLE,Color.BLACK,1);

        Ellipse lily1 = new StartMenu().ellipseConstructor(697,279,10,10,Color.ORANGE,Color.BLACK,1);
        Ellipse lily2 = new StartMenu().ellipseConstructor(722,279,10,10,Color.YELLOW,Color.BLACK,1);
        Ellipse lily3 = new StartMenu().ellipseConstructor(747,279,10,10,Color.WHITE,Color.BLACK,1);

        Ellipse orchid1 = new StartMenu().ellipseConstructor(680,321,10,10,Color.MEDIUMVIOLETRED,Color.BLACK,1);
        Ellipse orchid2 = new StartMenu().ellipseConstructor(705,321,10,10,Color.MAGENTA,Color.BLACK,1);
        Ellipse orchid3 = new StartMenu().ellipseConstructor(730,321,10,10,Color.WHITE,Color.BLACK,1);

        Ellipse tulip1 = new StartMenu().ellipseConstructor(693,363,10,10,Color.MEDIUMVIOLETRED,Color.BLACK,1);
        Ellipse tulip2 = new StartMenu().ellipseConstructor(718,363,10,10,Color.RED,Color.BLACK,1);
        Ellipse tulip3 = new StartMenu().ellipseConstructor(743,363,10,10,Color.YELLOW,Color.BLACK,1);

        Button backToAdditional = new StartMenu().buttonConstructor("Additional menu","Back to 'Additional'",1,2,440.0,413.0);
        backToAdditional.setOnAction(actionEvent -> {new Receiver().transition(new Additional());});
        Button backToMainMenu = new StartMenu().buttonConstructor("Main menu","Back to 'Main menu'",1,2,485.0,425.0);
        backToMainMenu.setOnAction(actionEvent -> {
            try {
                new StartMenu().start(StartMenu.defaultStage);
            } catch (IOException e) {
                e.printStackTrace();
            }});


        StartMenu.pane = new StartMenu().sumAllElements((AnchorPane) StartMenu.pane,
                new Node[]{infoWelcome, infoText, rose1, rose2, rose3, chrysanthemum1, chrysanthemum2, chrysanthemum3,
                        lily1, lily2, lily3, orchid1, orchid2, orchid3, tulip1, tulip2, tulip3, backToAdditional, backToMainMenu});
        new StartMenu().sceneStarter(StartMenu.pane, StartMenu.defaultStage);
    }
}
