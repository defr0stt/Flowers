package JavaFXpart.Flowers;

import javafx.scene.paint.Color;

public class Chrysanthemum extends FlowerTemplate
{
    public Chrysanthemum(int len, int days, Color color)
    {
        this.name = "Chrysanthemum";
        this.color = color;
        value = 20;
        this.len = len;
        this.days = days;
    }
}
