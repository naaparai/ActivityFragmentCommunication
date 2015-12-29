package awesome.kunsang.activityfragmentcommunication;

import com.squareup.otto.Bus;

/**
 * Created by kunsang on 12/30/2015.
 */
public class BusStation {
    private static Bus bus=new Bus();

    public static Bus getBus() {
        return bus;
    }
}
