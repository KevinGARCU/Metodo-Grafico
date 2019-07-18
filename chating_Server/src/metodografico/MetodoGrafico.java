package metodografico;

import java.util.ArrayList;

/**
 *
 * @author Mateo
 */
public class MetodoGrafico {

    public double[] xdd;
    public double[] xdd2;
    public int inf;
    
    public MetodoGrafico() {

    }

    public String Devolver(ArrayList miau) {
        Calcular cal = new Calcular();
        String f=cal.PuntosRegionFactible(miau);
        
        xdd=cal.getPuntosX();
        xdd2=cal.getPuntosY();
        inf=cal.AreaInfinita;
        
        for (int i = 0; i < xdd.length; i++) {
            System.out.print(xdd[i]+" ");
            System.out.println(xdd2[i]+" miau ");
        }
        
        return f;
    }

    


}
