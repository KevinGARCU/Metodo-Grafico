
package model;

import java.util.ArrayList;

public class Splitear {
    public String[] SplitearPuntos(String miau,int x) {
        String split1[] = miau.split("::");
        String split2[] = split1[x].split(":");
        return split2;
    }

}
