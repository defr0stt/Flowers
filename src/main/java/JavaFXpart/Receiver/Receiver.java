package JavaFXpart.Receiver;

import JavaFXpart.ActionFlowers.Actions.*;
import JavaFXpart.Additional.Actions.*;

import java.sql.SQLException;

public class Receiver {

    public void transition(Command obj) {
        obj.execute();
    }

    public void variation(int i)
    {
        switch (i){
            case 1: new CreateFlower().createFlower();break;
            case 2: new DeletingFlowers().deleteFlower();break;
            case 3: new FlowerList().flowerList();break;
            case 4: new ChangeParameters().changeFlowerParameters();break;
            case 5: new CreateBouquet().createBouquet();break;
            case 11: new FileActions().bouquetFromFile();break;
            case 12: new Information().information();break;
            case 13: new Database().flowersFromDB();break;
        }
    }

    public void variation(Database db, int i, String query)
    {
        switch (i){
            case 1:
                try {
                    db.deleteData();
                } catch (SQLException e) {
                    e.printStackTrace();
                }break;

            case 2:
                try {
                    db.newData(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }break;
        }
    }
}

