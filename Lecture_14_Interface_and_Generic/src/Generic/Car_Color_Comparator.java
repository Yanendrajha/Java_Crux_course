package Generic;

import java.util.Comparator;

public class Car_Color_Comparator implements Comparator<Demo_Car>{

    @Override
    public int compare(Demo_Car tcar, Demo_Car ocar) {
        return tcar.color.compareTo(ocar.color);
    }
}
