/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Model;
import visual.VisualAlgebra;

/**
 *
 * @author Maria Fernanda
 */
public class Controller {

    
    Model model;

    public Controller(VisualAlgebra va)  {
        
        ArrayList<String> c = new ArrayList();
        System.out.println(va.getX());
        for (int i = 0; i < va.getX(); i++) {
            c.add(va.getText1().get(i).toString());
        }
        model= new Model();
        model.setC(c);
    }



    

}
