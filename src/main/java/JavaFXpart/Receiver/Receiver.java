package JavaFXpart.Receiver;

import JavaFXpart.Additional.Additional;

public class Receiver {

    public void transition(Command obj) {
        obj.execute();
    }

    public void variation(Additional a, int i) {
        switch (i) {
            case 1: a.bouquetFromFile();break;
            case 2: a.information();break;
        }
    }
//    public void variation(ActionFlowers a, int i)
//    {
//        switch (i){
//            case 1: a.bouquet();break;
//            case 2: a.delete();break;
//            case 3: a.flowList();break;
//            case 4: a.create_b();break;
//            case 5: a.changePar();break;
//        }
//    }
}

