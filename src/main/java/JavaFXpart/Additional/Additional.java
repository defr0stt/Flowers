package JavaFXpart.Additional;

import JavaFXpart.Receiver.Command;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Additional implements Command
{
    @Override
    public void execute()  {
        additionalMenuView();

        Button infoButton = new StartMenu().buttonConstructor("Information","Info about flowers",1,2,260.0,425.0);
        infoButton.setOnAction(actionEvent -> {new Receiver().variation(new Additional(),2);});
        Button fileButton = new StartMenu().buttonConstructor("Bouquet from file","Info about bouquet from file",1,2,310.0,410.0);
        fileButton.setOnAction(actionEvent -> {new Receiver().variation(new Additional(),1);});
        Button mainMenuButton = new StartMenu().buttonConstructor("Main menu","Back to 'Main menu'",1,2,360.0,425.0);
        mainMenuButton.setOnAction(actionEvent -> {
            try {
                new StartMenu().start(StartMenu.defaultStage);
            } catch (IOException e) {
                e.printStackTrace();
            }});

        StartMenu.pane = new StartMenu().sumAllElements((AnchorPane) StartMenu.pane, new Node[]{ infoButton, fileButton, mainMenuButton});
        new StartMenu().sceneStarter(StartMenu.pane, StartMenu.defaultStage);
    }

    public void additionalMenuView()
    {
        Text welcomeAdditionalText = new StartMenu().textConstructor("Additional  menu",1,2,50.0,365.0);
        welcomeAdditionalText.setStyle("-fx-font-size: 24px;");

        ImageView backImageView = null;
        try {
            backImageView = new StartMenu().imageConstructor("resources/bckt.png",1,2,120.0,50.0);
            backImageView.setFitHeight(432);
            backImageView.setFitWidth(272);

            StartMenu.pane = new StartMenu().authorPlusImagePulsing(welcomeAdditionalText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StartMenu.pane.getChildren().add(backImageView);
    }

    public void information() {

        additionalMenuView();
        Text infoWelcome = new StartMenu().textConstructor("Information",1,2,80.0,400.0);
        infoWelcome.setStyle("-fx-font-size: 24px;");

        Text infoText = new StartMenu().textConstructor("\n\n\tRose" + "   -   such a beautiful flower, costs 10$" +
        "\n\n\tChrysanthemum" + "   -   unbelievable flower, costs 20$" +
        "\n\n\tLily" + "   -   incredible flower, costs 10$" +
        "\n\n\tOrchid" + "   -  cute flower, costs 15$" +
        "\n\n\tTulip" + "   -   sweaty flower, costs 15$\n",1,2,140.0,390.0);
        infoText.setStyle("-fx-font-size: 16px;");

        Ellipse rose1 = new StartMenu().ellipseConstructor(750,193,10,10,Color.RED,Color.BLACK,1);
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

    public void bouquetFromFile()
    {
        String fileCapacity = fromFile("bouquet.txt");
        if(fileCapacity.equals(""))     fileCapacity = "There is no data in file or\n      file not found";

        additionalMenuView();
        Text fileWelcome = new StartMenu().textConstructor("Reading data from file",1,2,80.0,340.0);
        fileWelcome.setStyle("-fx-font-size: 24px;");

        Text fromFileText = new StartMenu().textConstructor(fileCapacity,1,2,120.0,425.0);

        Button mainMenuButton = new StartMenu().buttonConstructor("Main menu","Back to 'Main menu'",1,2,485.0,705.0);
        mainMenuButton.setOnAction(actionEvent -> {
            try {
                new StartMenu().start(StartMenu.defaultStage);
            } catch (IOException e) {
                e.printStackTrace();
            }});
        Button backToAdditional = new StartMenu().buttonConstructor("Additional menu","Back to 'Additional'",1,2,440.0,693.0);
        backToAdditional.setOnAction(actionEvent -> {new Receiver().transition(new Additional());});

        StartMenu.pane = new StartMenu().sumAllElements((AnchorPane) StartMenu.pane,
                new Node[]{fileWelcome, backToAdditional, mainMenuButton, fromFileText});
        new StartMenu().sceneStarter(StartMenu.pane, StartMenu.defaultStage);

    }

    public static int iFile=1;
    public void inFile(String line)
    {
        File file1 = new File("bouquet.txt");
        try {
            if(!file1.exists()) {
                file1.createNewFile();
                PrintWriter obj1 = new PrintWriter(file1);
                obj1.write(line);              // writing an information
                obj1.close();
                iFile--;
            }
            else if(file1.exists() && iFile==1)
            {
                PrintWriter obj1 = new PrintWriter(file1);
                obj1.write("");              // writing an information
                obj1.close();
                iFile--;
            }
            else Files.write(Paths.get("bouquet.txt"), line.getBytes(), StandardOpenOption.APPEND);    // adding in existing file
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String fromFile(String name)
    {
        String line, finLine = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(name));
            while((line = br.readLine())!=null)
            {
                finLine += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finLine;
    }
}
