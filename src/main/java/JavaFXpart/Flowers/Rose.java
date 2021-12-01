package JavaFXpart.Flowers;

import javafx.scene.paint.Color;

public class Rose extends FlowerTemplate
{
    public Rose(int len, int days, Color color)
    {
        this.name = "Rose";
        this.color = color;
        value = 10;
        this.len = len;
        this.days = days;
    }
}
