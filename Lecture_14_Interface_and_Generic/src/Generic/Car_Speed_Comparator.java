package Generic;

import java.util.Comparator;

public class Car_Speed_Comparator implements Comparator<Demo_Car> {

    @Override
    public int compare(Demo_Car tcar, Demo_Car ocar) {
        return tcar.speed - ocar.speed;
    }
}
