package JavaFXpart.Flowers;

import JavaFXpart.StartMenu;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class FlowerTemplate
{
    public  String name;
    public Color color;
    public  int value;
    public  int len;
    public int days;

    public String getName(){return name;}
    public int getValue(){return value;}
    public int getLen(){return len;}
    public int getDays(){return days;}
    public Ellipse getColor(double height)
    {
        return new StartMenu().ellipseConstructor(700,height,10,10,color,Color.BLACK,1);
    }

    public void setLen(int l){len = l;}
    public void setDays(int d){days = d;}
    public void setColor(Color c){color = c;}

    @Override
    public String toString() {
        return getName() + " : value = " + getValue() + " $, length = " + getLen() + ", freshness : " + getDays();
    }
}
