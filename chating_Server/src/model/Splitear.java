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
    public ArrayList SplitearPuntos(String miau) {
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        ArrayList<double[]> xy = new ArrayList<>();
        String split1[] = miau.split("::");
        String split2[] = split1[0].split(":");
        String split3[];
        

        for (int i = 1; i < split2.length; i++) {
            split3 = split2[i].split(",");
            x.add(Double.parseDouble(split3[0]));
            y.add(Double.parseDouble(split3[1]));
        }
        double[] xs=new double[x.size()];
        double[] ys=new double[y.size()];
        for (int i = 0; i < x.size(); i++) {
            xs[i]=x.get(i);
            ys[i]=y.get(i);
        }
        xy.add(xs);
        xy.add(ys);
        return xy;
    }

}
