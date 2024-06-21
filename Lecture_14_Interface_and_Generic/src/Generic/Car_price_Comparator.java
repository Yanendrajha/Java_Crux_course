package Generic;

import java.util.Comparator;

public class Car_price_Comparator implements Comparator<Demo_Car> {

    @Override
    public int compare(Demo_Car tcar, Demo_Car ocar) {
        return ocar.price - tcar.price;
    }
}
