package JavaFXpart.Flowers;

import javafx.scene.paint.Color;

public class Lily extends FlowerTemplate
{
    public Lily(int len, int days, Color color)
    {
        this.name = "Lily";
        this.color = color;
        value = 10;
        this.len = len;
        this.days = days;
    }
}
