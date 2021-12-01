package JavaFXpart.Flowers;
import javafx.scene.paint.Color;

public class Tulip extends FlowerTemplate
{
    public Tulip(int len, int days, Color color)
    {
        name = "Tulip";
        this.color = color;
        value = 15;
        this.len = len;
        this.days = days;
    }
}
