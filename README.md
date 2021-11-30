# Flowers
Desktop app for florists 🌸

Hello everyone! This is the program called "Flowers" to create flowers, make a bouquet of them and do other actions.
"Flowers" can be so useful for florists since this is the range of their work. There are some classes in my program 
so I'm going to tell about them below :

> StartMenu

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
which can lead to ```FileNotFoundException```.
