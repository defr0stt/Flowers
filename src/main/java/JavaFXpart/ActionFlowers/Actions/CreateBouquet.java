package JavaFXpart.ActionFlowers.Actions;

import JavaFXpart.ActionFlowers.ActionFlowers;
import JavaFXpart.Additional.Actions.FileActions;
import JavaFXpart.Additional.Additional;
import JavaFXpart.Flowers.FlowerTemplate;
import JavaFXpart.Receiver.Receiver;
import JavaFXpart.StartMenu;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static JavaFXpart.Additional.Actions.FileActions.iFile;

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
        if( ( max != 0 && min<=max) && (radioButtonGroup.getSelectedToggle() != null) ){
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

    List<FlowerTemplate> copyArray = new ArrayList();
    ObservableList<FlowerTemplate> bouquetList;
    ChoiceBox<FlowerTemplate> rangeChoiceBox;
    int pack;
    Ellipse ellipseBouquet;
    String inFile;
    public void creatingProcess()
    {
        sorting();
        new StartMenu().deleteElements((AnchorPane) StartMenu.pane,
                new Node[]{confirmButton,labelMin,labelMax,rangeText,buttonYES,buttonNO,packaging});
        if(incorrect != null)   StartMenu.pane.getChildren().remove(incorrect);

        String bouquetInfo = flowers.toString();
        bouquetInfo += "Colors : \n\n";

        inFile = flowers.toString();

        int heightCoefficient = (flowers.size()-1) / 5;
        int counter = 0;
        int width = 285;
        int height = 210 + (16*heightCoefficient) ;
        for (FlowerTemplate a : flowers)
        {
             StartMenu.pane.getChildren().add(flowers.get(counter).getColor(width, height));
             width += 25;
            if(++counter % 10 == 0){
                height += 25;
                width = 285;
                bouquetInfo += "\n\n";
            }
        }

        bouquetInfo += "Flowers in range ( min = " + min +"; max = " + max + " ) :\n\n";
        inFile += "Flowers in range ( min = " + min +"; max = " + max + " ) :\n\n";
        int rangeCheck = 0;
        for (FlowerTemplate a : flowers) {
            if( a.getLen() >= min && a.getLen() <= max ){
                inFile += a.toString() + " Color : " + a.getColor(0,0).getFill() + "\n";
                copyArray.add(a);
                rangeCheck++;
            }
        }
        if(rangeCheck == 0){
            bouquetInfo += "There are no flowers in this range\n";
            inFile += "There are no flowers in this range";
        }
        else{
            height += 60;
            bouquetList = FXCollections.observableArrayList(copyArray);
            rangeChoiceBox = new ChoiceBox<FlowerTemplate>(bouquetList);
            rangeChoiceBox = (ChoiceBox<FlowerTemplate>) new StartMenu().positionDetermination(rangeChoiceBox,1,2, Double.valueOf(height),260.0);

            int finalHeight = height;
            rangeChoiceBox.setOnAction(event -> {
                if( ellipseBouquet != null) {
                    if(StartMenu.pane.getChildren().contains(ellipseBouquet))
                        StartMenu.pane.getChildren().remove(ellipseBouquet);
                }
                ellipseBouquet = rangeChoiceBox.getValue().getColor(670,Double.valueOf(finalHeight+12));
                StartMenu.pane.getChildren().add(ellipseBouquet);
            });
        }

        Map<Integer,String> funcResult = flowersInBouquet();
        bouquetInfo += "\n\n" + funcResult.get(sum);
        inFile += funcResult.get(sum);
        new FileActions().inFile("");
        new FileActions().inFile(inFile);
        iFile=1;

        Text bouquet = new StartMenu().textConstructor(bouquetInfo,1,2,120.0,215.0);
        StartMenu.pane.getChildren().add(bouquet);
        if(bouquetList != null) StartMenu.pane.getChildren().add(rangeChoiceBox);
    }

    public void sorting()   // selection sort (max elem goes last place in array)
    {
        int flowerSize = flowers.size();
        while (flowerSize>0)
        {
            int max = flowers.get(0).getDays(), i = 0, index=0;
            while(i!=flowerSize) {
                if(max < flowers.get(i).getDays()) {
                    max = flowers.get(i).getDays();
                    index = i;
                }
                i++;
            }
            if(index != flowerSize-1)   // if the max elem is not the last in array
            {
                FlowerTemplate temp = flowers.get(flowerSize-1);
                flowers.set(flowerSize-1,flowers.get(index));
                flowers.set(index,temp);
            }
            flowerSize--;
        }
    }

    int sum = 0;
    public Map<Integer,String> flowersInBouquet()
    {
        int counter = 1, money=0;
        String forFile = "\nFlowers :\n\n";
        Map<Integer, String> result = new HashMap<>();

        int[] array = new int [5];
        for (FlowerTemplate obj : flowers){
            if(obj.getName().equals("Rose"))                  array[0] ++;
            else if(obj.getName().equals("Chrysanthemum"))    array[1] ++;
            else if(obj.getName().equals("Lily"))             array[2] ++;
            else if(obj.getName().equals("Tulip"))            array[3] ++;
            else if(obj.getName().equals("Orchid"))           array[4] ++;
        }

        for (int a:array) {
            if(a!=0) {
                switch (counter) {
                    case 1: money = 10*a;
                            forFile += "\tRose - " + a + " flower(s) - "+money+"$\n"; break;
                    case 2: money = 20*a;
                            forFile += "\tChrysanthemum - " + a + " flower(s) - "+money+"$\n"; break;
                    case 3: money = 10*a;
                            forFile += "\tLily - " + a + " flower(s) - "+money+"$\n"; break;
                    case 4: money = 15*a;
                            forFile += "\tOrchid - " + a + " flower(s) - "+money+"$\n"; break;
                    case 5: money = 15*a;
                            forFile += "\tTulip - " + a + " flower(s) - "+money+"$\n"; break;
                }
                sum += money;
            }
            counter++;
        }
        if(pack == 1) sum += 5;
        forFile += "\nTotal sum : " + sum + " $";

        result.put(sum,forFile);
        return result;
    }
}
