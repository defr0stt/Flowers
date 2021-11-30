package JavaFXpart.ActionFlowers;

import JavaFXpart.Receiver.Command;
import JavaFXpart.StartMenu;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;

public class ActionFlowers implements Command {

    @Override
    public void execute()
    {
        Text welcomeFlowersText = new StartMenu().textConstructor("Flowers  menu",1,2,50.0,385.0);
        welcomeFlowersText.setStyle("-fx-font-size: 24px;");

        ImageView backImageView = null;
        try {


            StartMenu.pane = new StartMenu().authorPlusImagePulsing(welcomeFlowersText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StartMenu.pane = new StartMenu().sumAllElements((AnchorPane) StartMenu.pane, new Node[]{});
        new StartMenu().sceneStarter(StartMenu.pane, StartMenu.defaultStage);
    }
}
