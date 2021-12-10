package JavaFXpart.Receiver;

import JavaFXpart.ActionFlowers.Actions.*;
import JavaFXpart.Additional.Actions.FileActions;
import JavaFXpart.Additional.Actions.Information;
import JavaFXpart.Additional.Additional;

public class Receiver {

    public void transition(Command obj) {
        obj.execute();
    }

    public void variation(Additional a, int i) {
        switch (i) {
            case 1: new FileActions().bouquetFromFile();break;
            case 2: new Information().information();break;
        }
    }
    public void variation(int i)
    {
        switch (i){
            case 1: new CreateFlower().createFlower();break;
            case 2: new DeletingFlowers().deleteFlower();break;
            case 3: new FlowerList().flowerList();break;
            case 4: new ChangeParameters().changeFlowerParameters();break;
            case 5: new CreateBouquet().createBouquet();break;
        }
    }
}

