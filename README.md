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

![StartMenu1](https://github.com/defr0stt/Flowers/blob/master/screens/Start1.png)

In the left bottom corner program has an animation of blinking image. There are 2 buttons which help you to move from
one menu item to another.
