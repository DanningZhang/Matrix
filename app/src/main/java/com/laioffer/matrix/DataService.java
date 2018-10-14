package com.laioffer.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danningzhang on 9/10/18.
 */

public class DataService {
    public static List<Event> getEventData() {
        List<Event> eventData = new ArrayList<Event>();
        for (int i = 0; i < 10; ++i) {
            eventData.add(
                    new Event("Event", "1184 W valley Blvd, CA 90101",
                            "This is a huge event"));
        }
        return eventData;
    }
}
