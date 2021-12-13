# Flowers
Desktop app for florists 🌸

Hello everyone! This is the program called "Flowers" to create flowers, make a bouquet of them and do other actions.
"Flowers" can be so useful for florists since this is the range of their work. There are some classes in my program 
so I'm going to tell about them below :

## > Receiver and Command

For start I want you to tell about them. The patern "Command" realized in my program so the method **_execute()_**
is default for it. Every class implements interface Command and it's need to override method **_execute()_**.
```
public interface Command {
    void execute();
}
```
```
@Override
    public void execute()  {
            ...
    }
```
As the "Command" mentioned for incapsulating an information so class Receiver does this work. This class has
2 methods : **_transition()_** and **_variation()_**. The first class serves for creating a new object of the class
and the second specified for calling methods what realized in this class.
```
public void transition(Command obj) {
        obj.execute();
    }

    public void variation(Additional a, int i) {
        switch (i) {
            case 1: a.bouquetFromFile();break;
            case 2: a.information();break;
        }
    }
```

## > StartMenu

This class is the main in the program. It starts method **_launch()_** which in turns method **_start(Stage stage)_**.
```
public class StartMenu extends Application {

    public static void main(String[] args) {
           ...
        launch();
    }
    
    @Override
    public void start(Stage stage) throws IOException {
                ...
    }
}
```
It throws IOException because of that method calling other methods in which contained ```FileInputStream (wayToImage)```
which can lead to ```FileNotFoundException```. Start menu of my program has the next view : 

![StartMenu1](https://github.com/defr0stt/Flowers/blob/master/screens/Start/Start1.png)

In the left bottom corner program has an animation of blinking image. There are 2 buttons which help you to move from
one menu item to another and 1 button to close this program.

 - **_authorPlusImagePulsing(Text text)_** it's a default view of my scene with blinking image, author's signature
and text on the top of the scene.
 - **_sceneStarter (Pane pane, Stage stage)_** it's a process of scene creation in the start stage without creating new
windows.
 - **_buttonConstructor(...)_** , **_textConstructor(...)_** , **_imageConstructor(...)_** , **_ellipseConstructor(...)_** 
are created for useful creating of the objects like text, ellipse etc.
 - **_sumAllElements(AnchorPane anchorPane, Node[] obj)_** , **_deleteElements(AnchorPane anchorPane, Node[] obj)_** 
are created for adding or deleting objects from the scene.
 - **_positionDetermination(...)_** created for determinating position of the objects on the screen.

## > Flower menu

This menu intended for actions with flowers like creating, deleteng flowers, displaying list of created flowers,
changing flower parameters and creating bouquet of created flowers. To do this actions there are some buttons.

![FlowerMenu1](https://github.com/defr0stt/Flowers/blob/master/screens/Flower/Flower1.PNG)

### <-> Create flower <->

This function can create flowers with special parameters.

![CreateFlower1](https://github.com/defr0stt/Flowers/blob/master/screens/Flower/create/create1.png)

![CreateFlower2](https://github.com/defr0stt/Flowers/blob/master/screens/Flower/create/create2.PNG)

- **_createFlower()_** it's the main method of creating flowers.
- **_chooseFlowerToCreate()_** refreshes interface element when you choose flowers.
- **_inputToChoose()_ , _createFlowerColor()_** methods for visualising sliders and ellipses with colors.
- **_confirmingCreation()_** method for checking that all parameters are choosen.

### <-> Delete flower <->

This function can delete created flower (if it exists).

![DeleteFlower1](https://github.com/defr0stt/Flowers/blob/master/screens/Flower/delete/delete1.png)

![DeleteFlower2](https://github.com/defr0stt/Flowers/blob/master/screens/Flower/delete/delete2.PNG)

- **_deleteFlower()_** the main method of the process of deleting.
- **_confirmDeleting()_** it's the process of confirming of flower deleting.
- **_clearAll()_** deletes all created flowers.

### <-> Flower list <->

This function can show all created flowers.

![FlowerList1](https://github.com/defr0stt/Flowers/blob/master/screens/Flower/list/list1.png)

- **_flowerList()_** shows all created flowers and their information.

### <-> Change flower parameters <->

This function can change parameters in the list of created flowers.

![ChangePar1](https://github.com/defr0stt/Flowers/blob/master/screens/Flower/changePar/change1.PNG)

![ChangePar2](https://github.com/defr0stt/Flowers/blob/master/screens/Flower/changePar/change2.PNG)

- **_changeFlowerParameters()_** the main method of the process of changing.
- **_buttonsToChange()_** specialized for showing buttons of parameters which user can change.
- **_parametersToChange()_** creates sliders.
- **_colorsToChange()_** creates ellipses from available colors.
- **_checkFunction()_** method checkes some objects on the screen which needed to be deleted.
- **_insertParameters()_** changes selected parameter.
- **_message()_** informs you about incorrect selecting of parameters.

### <-> Create bouquet <->

This function can create bouquet of created flowers.

![Bouquet1](https://github.com/defr0stt/Flowers/blob/master/screens/Flower/bouquet/bouquet1.PNG)

![Bouquet2](https://github.com/defr0stt/Flowers/blob/master/screens/Flower/bouquet/bouquet2.PNG)

- **_createBouquet()_** the main method of the process of creating a bouquet.
- **_rangeAndPackaging()_** devided for creating range length sliders and demand of packaging.
- **_confirmProcess()_** checking whether all paramrters are selected.
- **_creatingProcess()_** it's creating of bouquet.
- **_sorting()_** it's a type of sorting for freshness.
- **_flowersInBouquet()_** method for showing type and count of flowers in bouquet.
- **_databaseActions()_** for writting data to database.

## > Additional menu

This menu intended for showing information about flowers, created bouquet from file and showes info from database.
To do this actions there are some buttons.

![Additional1](https://github.com/defr0stt/Flowers/blob/master/screens/Additional/Additional1.png)

### <-> Information about flowers <->

This function can show information about flowers.

![Information1](https://github.com/defr0stt/Flowers/blob/master/screens/Additional/info/info1.png)

- **_information()_** showes infromation about all types of flowers.

### <-> Bouquet from file <->

This function can show information about bouquet from the file.

![FromFile1](https://github.com/defr0stt/Flowers/blob/master/screens/Additional/fromFlie/fromFile1.PNG)

- **_bouquetFromFile()_** showes created bouquet from file.
- **_inFile(...)_** writes info in file.
- **_information()_** writes info from file into String variable.

### <-> Bouquet from database <->

This function can show information about bouquet from the database.

![FromDB](https://github.com/defr0stt/Flowers/blob/master/screens/Additional/fromDB/fromDB1.png)

- **_flowersFromDB()_** created for showes info from DB.
- **_checkConnection()_** checks the connection to DB.
- **_newData()_** writes new data to database.
- **_deleteData()_** deletes data from database.
- **_readingDataFromDB()_** reads all data to dataset.

## > Logger

Realized with the default functionalities without connection libraries.
```
public class Logger
{
    public static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());

    public static class MyFormatter extends Formatter {

        @Override
        public String format(LogRecord record)
        {
            LocalDateTime localDateTime = LocalDateTime.now();
            String time = localDateTime.getDayOfMonth() + "-" + localDateTime.getMonthValue() + "-" + localDateTime.getYear() +
                    " " + localDateTime.getHour() + ":" + localDateTime.getMinute() + ":" + localDateTime.getSecond();
            return time + " -- " + record.getLevel() + " : " + record.getMessage() + "\n";
        }
    }
}
```
Logger file saves in home derectory. Logger file has the special pattern of writing data.
```
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
                ...
    }
```
