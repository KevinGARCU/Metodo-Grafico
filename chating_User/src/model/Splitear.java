/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Braya
 */
public class Splitear {
    public String[] SplitearPuntos(String miau,int x) {
        String split1[] = miau.split("::");
        String split2[] = split1[x].split(":");
        return split2;
    }

}
