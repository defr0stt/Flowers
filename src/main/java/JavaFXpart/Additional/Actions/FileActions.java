package JavaFXpart.Additional.Actions;

import JavaFXpart.Additional.Additional;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static JavaFXpart.Logger.Logger.logger;

public class FileActions
{
    public void bouquetFromFile()
    {
        logger.info("INFO ABOUT BOUQUET FROM FILE");

        String fileCapacity = fromFile("bouquet.txt");
        if(fileCapacity.equals(""))     fileCapacity = "There is no data in file or\n      file not found";

        new Additional().additionalMenuView();
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
