package com.exercise1.utilities;

import com.exercise1.pages.Values;

public class Pages {
    private Values values;

    public Values values() {
        if (values == null) {
            values = new Values();
        }
        return values;
    }

}
