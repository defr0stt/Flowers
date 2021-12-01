package JavaFXpart.Flowers;

import javafx.scene.paint.Color;

public class Orchid extends FlowerTemplate
{
    public Orchid( int len, int days, Color color)
    {
        this.name = "Orchid";
        this.color = color;
        value = 15;
        this.len = len;
        this.days = days;
    }
}
