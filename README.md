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

### <-> Create flower

This function can create flowers with special parameters.

![CreateFlower1](https://github.com/defr0stt/Flowers/blob/master/screens/Flower/create/create1.png)

![CreateFlower2](https://github.com/defr0stt/Flowers/blob/master/screens/Flower/create/create2.PNG)

- **_createFlower()_** it's the main method of creating flowers.
- **_chooseFlowerToCreate()_** refreshes interface element when you choose flowers.
- **_inputToChoose()_ , _createFlowerColor()_** methods for visualising sliders and ellipses with colors.
- **_confirmingCreation()_** method for checking that all parameters are choosen.

### <-> Delete flower

This function can delete created flower (if it exists).

