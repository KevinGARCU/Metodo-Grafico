/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.Model;
import model.Splitear;

/**
 *
 * @author Braya
 */
public class VisualAlgebra extends javax.swing.JFrame {

    /**
     * Creates new form VisualAlgebra
     */
    // arraylist de coef x, coef y y num
    ArrayList<JTextField> text1 = new ArrayList();
    ArrayList<JTextField> text2 = new ArrayList();
    ArrayList<JTextField> text3 = new ArrayList();
    // arraylist puntos que forman region y evaluacion de funcion objetivo   
    ArrayList<JLabel> text4 = new ArrayList();
    ArrayList<JLabel> text5 = new ArrayList();
    ArrayList<JLabel> text6 = new ArrayList();
    ArrayList<JLabel> text7 = new ArrayList();
    // arraylist de opcion <,>...
    ArrayList<JComboBox> electext = new ArrayList();
    //min o max    
    JComboBox jComboBox2;
    //estos dos sepa la berga    
    int x;
    String hola;
    // se invoca el modelo desde aqui para manejar cuando se toma la foto    
    public Model model = new Model();
    //se guardan los puntos para mandarselos a la parte logica    
    ArrayList<String> c = new ArrayList();
    //el string con los puntos y mamadas
    String d;
    //string[] con los puntos
    String[] puntos;
    //string[] con los puntos evaluados
    String[] evaluar;

    public VisualAlgebra() {
        initComponents();
        setVisible(true);
        Vector v1 = new Vector();
        v1.add("MAX");
        v1.add("MIN");
        jComboBox2 = new JComboBox<>(v1);
        jComboBox2.setBounds(80, 115, 100, 25);
        Recibir.add(jComboBox2);
    }

    public void Llenar_ecuaciones() {
        Vector v = new Vector();
        v.add("<");
        v.add("<=");
        v.add(">");
        v.add(">=");
        for (int i = 0; i < x; i++) {
            text1.add(new JTextField());
            text1.get(i).setBounds(10, (30 + 27 * i), 80, 25);
            text1.get(i).setText("");
            Recibir_Cuadro.add(text1.get(i));
        }
        for (int i = 0; i < x; i++) {
            text2.add(new JTextField());
            text2.get(i).setBounds(100, (30 + 27 * i), 80, 25);
            text2.get(i).setText("");
            Recibir_Cuadro.add(text2.get(i));
        }
        for (int i = 0; i < x; i++) {
            text3.add(new JTextField());
            text3.get(i).setBounds(300, (30 + 27 * i), 80, 25);
            text3.get(i).setText("");
            Recibir_Cuadro.add(text3.get(i));
        }
        for (int i = 0; i < x; i++) {
            electext.add(new JComboBox(v));
            electext.get(i).setBounds(210, (30 + 27 * i), 50, 25);
            Recibir_Cuadro.add(electext.get(i));
        }
    }

    public void Llenar_puntos(String[] puntos) {

        for (int i = 0; i < puntos.length; i++) {
            text4.add(new JLabel());
            text4.get(i).setBounds(50, 10 + 27 * i, 80, 25);
            text4.get(i).setText((char) (64 + (i + 1)) + "=");
            jPanel2.add(text4.get(i));
        }
        for (int i = 1; i < puntos.length; i++) {
            text5.add(new JLabel());
            text5.get(i - 1).setBounds(80, 10 + 27 * (i - 1), 200, 25);
            text5.get(i - 1).setText(puntos[i]);
            jPanel2.add(text5.get(i - 1));
        }

    }

    public void Llenar_Evaluar(String[] evaluar) {
        String res[]= new String[evaluar.length*2];
        double numeros[] = new double[evaluar.length];
        double resultado;
        int k=0;
        for (int i = 0; i < evaluar.length; i++) {
            res = evaluar[i].split("=");
            numeros[k]= Double.parseDouble(res[1]);
            k++;
        }
        
        hola = String.valueOf(jComboBox2.getSelectedItem());

        if (hola == "MAX") {
            resultado = numeros[0];
            for (int i = 0; i < evaluar.length; i++) {
                if(resultado>= numeros[i]){
                    
                }else{
                    resultado=numeros[i];
                    i=0;
                }
            }
        }else{
            resultado = numeros[0];
            for (int i = 0; i < evaluar.length; i++) {
                if(resultado>= numeros[i]){
                    
                }else{
                    resultado=numeros[i];
                    i=0;
                }
            }
        }
        for (int i = 0; i < evaluar.length; i++) {
            text6.add(new JLabel());
            text6.get(i).setBounds(50, 10 + 27 * i, 80, 25);
            text6.get(i).setText((char) (64 + (i + 1)) + "=");
            jPanel3.add(text6.get(i));
        }
        int i=0;
        for ( i = 0; i < evaluar.length; i++) {
            text7.add(new JLabel());
            text7.get(i).setBounds(80, 10 + 27 * (i), 2000, 25);
            text7.get(i).setText(evaluar[i]);
            jPanel3.add(text7.get(i));
        }
        text7.add(new JLabel());
        text7.get(i).setBounds(80, 10 + 27 * (i), 2000, 25);
        text7.get(i).setText("El resultado de la funcion objetivo es z= " +resultado);
        jPanel3.add(text7.get(i));
        
    }

    public void Poner_Imagen() {
        ImageIcon icon = new ImageIcon("C:\\Users\\estudiantes\\Documents\\Metodo-Grafico-master\\chating_Server\\src\\view\\GraficaPRO.jpg");
        Image scaleImage = icon.getImage().getScaledInstance(517, 401, Image.SCALE_DEFAULT);
        Icon iconx = new ImageIcon(scaleImage);
        foto_label.setIcon(iconx);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dar = new javax.swing.JPanel();
        Puntos_que_forman_la_region_factible_tittle = new javax.swing.JLabel();
        Evaluacion_de_puntos_en_la_funcion_objetivo_tittle = new javax.swing.JLabel();
        valor_maximo_tittle = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        foto_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        Recibir = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        coefX = new javax.swing.JTextField();
        coefY = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        No_Ecuaciones = new javax.swing.JTextField();
        Recibir_Cuadro = new javax.swing.JPanel();
        coefX_tittle = new javax.swing.JLabel();
        coefY_tittle = new javax.swing.JLabel();
        num_tittle = new javax.swing.JLabel();
        mostrar_resultados_button = new javax.swing.JButton();
        crear_campos_button = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Dar.setBackground(new java.awt.Color(204, 204, 204));
        Dar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Puntos_que_forman_la_region_factible_tittle.setBackground(new java.awt.Color(0, 0, 0));
        Puntos_que_forman_la_region_factible_tittle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Puntos_que_forman_la_region_factible_tittle.setText("Puntos de interseccion");

        Evaluacion_de_puntos_en_la_funcion_objetivo_tittle.setBackground(new java.awt.Color(0, 0, 0));
        Evaluacion_de_puntos_en_la_funcion_objetivo_tittle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Evaluacion_de_puntos_en_la_funcion_objetivo_tittle.setText("Puntos en la funcion objetivo");

        valor_maximo_tittle.setBackground(new java.awt.Color(0, 0, 0));
        valor_maximo_tittle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        valor_maximo_tittle.setText("Grafica");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(foto_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(foto_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setMinimumSize(new java.awt.Dimension(100, 1000));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 600));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel3.setPreferredSize(new java.awt.Dimension(500, 800));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel3);

        javax.swing.GroupLayout DarLayout = new javax.swing.GroupLayout(Dar);
        Dar.setLayout(DarLayout);
        DarLayout.setHorizontalGroup(
            DarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DarLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DarLayout.createSequentialGroup()
                .addGroup(DarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DarLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(Puntos_que_forman_la_region_factible_tittle))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(DarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Evaluacion_de_puntos_en_la_funcion_objetivo_tittle)
                        .addGap(132, 132, 132))
                    .addGroup(DarLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(67, Short.MAX_VALUE))))
            .addGroup(DarLayout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(valor_maximo_tittle, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DarLayout.setVerticalGroup(
            DarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Puntos_que_forman_la_region_factible_tittle)
                    .addComponent(Evaluacion_de_puntos_en_la_funcion_objetivo_tittle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valor_maximo_tittle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Recibir.setBackground(new java.awt.Color(204, 204, 204));
        Recibir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Funcion Objetivo");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Coef x");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Coef y");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Maximizar o minimizar");

        coefX.setMinimumSize(new java.awt.Dimension(59, 20));
        coefX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coefXActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Digite N° de ecuaciones");

        Recibir_Cuadro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        coefX_tittle.setText("X1");

        coefY_tittle.setText("X2");

        num_tittle.setText("Restricciones");

        mostrar_resultados_button.setText("Mostrar Resusltado");
        mostrar_resultados_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_resultados_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Recibir_CuadroLayout = new javax.swing.GroupLayout(Recibir_Cuadro);
        Recibir_Cuadro.setLayout(Recibir_CuadroLayout);
        Recibir_CuadroLayout.setHorizontalGroup(
            Recibir_CuadroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Recibir_CuadroLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(coefX_tittle)
                .addGap(61, 61, 61)
                .addGroup(Recibir_CuadroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Recibir_CuadroLayout.createSequentialGroup()
                        .addComponent(mostrar_resultados_button, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(162, Short.MAX_VALUE))
                    .addGroup(Recibir_CuadroLayout.createSequentialGroup()
                        .addComponent(coefY_tittle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(num_tittle)
                        .addGap(49, 49, 49))))
        );
        Recibir_CuadroLayout.setVerticalGroup(
            Recibir_CuadroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Recibir_CuadroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Recibir_CuadroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coefX_tittle)
                    .addComponent(coefY_tittle)
                    .addComponent(num_tittle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(mostrar_resultados_button, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        crear_campos_button.setText("Ingresar ecuaciones");
        crear_campos_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_campos_buttonActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setText("Maximiar y Minimizar Metodo grafico");

        javax.swing.GroupLayout RecibirLayout = new javax.swing.GroupLayout(Recibir);
        Recibir.setLayout(RecibirLayout);
        RecibirLayout.setHorizontalGroup(
            RecibirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RecibirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RecibirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(RecibirLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(coefX, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(coefY, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11)
                    .addGroup(RecibirLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(55, 55, 55)
                        .addComponent(No_Ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(crear_campos_button)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Recibir_Cuadro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        RecibirLayout.setVerticalGroup(
            RecibirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RecibirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RecibirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RecibirLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(34, 34, 34)
                        .addGroup(RecibirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(coefX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(coefY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(RecibirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(No_Ecuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(crear_campos_button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(RecibirLayout.createSequentialGroup()
                        .addComponent(Recibir_Cuadro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Recibir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Dar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Recibir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Dar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crear_campos_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_campos_buttonActionPerformed
        if (Integer.parseInt(No_Ecuaciones.getText()) > 20) {
            JOptionPane.showMessageDialog(this, "menor que 20");
        } else {
            Recibir.repaint();
            x = Integer.parseInt(No_Ecuaciones.getText());
            Llenar_ecuaciones();
        }

    }//GEN-LAST:event_crear_campos_buttonActionPerformed

    private void mostrar_resultados_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_resultados_buttonActionPerformed

        System.out.println(getX());
        hola = String.valueOf(jComboBox2.getSelectedItem());
        c.add(coefX.getText() + "," + coefY.getText() + "," + hola);
        for (int i = 0; i < getX(); i++) {
            hola = String.valueOf(electext.get(i).getSelectedItem());
            c.add(text1.get(i).getText() + "," + text2.get(i).getText() + "," + hola + "," + text3.get(i).getText());
        }
        c.add("0");
        model.setC(c);
        try {
            d = model.Connect();
        } catch (InterruptedException ex) {
            Logger.getLogger(VisualAlgebra.class.getName()).log(Level.SEVERE, null, ex);
        }
        Splitear split = new Splitear();
        puntos = split.SplitearPuntos(d, 0);
        evaluar = split.SplitearPuntos(d, 1);
        Llenar_puntos(puntos);
        Llenar_Evaluar(evaluar);
        Poner_Imagen();
        Dar.repaint();
    }//GEN-LAST:event_mostrar_resultados_buttonActionPerformed

    private void coefXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coefXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coefXActionPerformed

    public ArrayList<JTextField> getText1() {
        return text1;
    }

    public void setText1(ArrayList<JTextField> text1) {
        this.text1 = text1;
    }

    public ArrayList<JTextField> getText2() {
        return text2;
    }

    public void setText2(ArrayList<JTextField> text2) {
        this.text2 = text2;
    }

    public ArrayList<JTextField> getText3() {
        return text3;
    }

    public void setText3(ArrayList<JTextField> text3) {
        this.text3 = text3;
    }

    public ArrayList<JLabel> getText4() {
        return text4;
    }

    public void setText4(ArrayList<JLabel> text4) {
        this.text4 = text4;
    }

    public ArrayList<JLabel> getText5() {
        return text5;
    }

    public void setText5(ArrayList<JLabel> text5) {
        this.text5 = text5;
    }

    public ArrayList<JLabel> getText6() {
        return text6;
    }

    public void setText6(ArrayList<JLabel> text6) {
        this.text6 = text6;
    }

    public ArrayList<JLabel> getText7() {
        return text7;
    }

    public void setText7(ArrayList<JLabel> text7) {
        this.text7 = text7;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public JTextField getjTextField1() {
        return coefX;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.coefX = jTextField1;
    }

    public JTextField getjTextField2() {
        return coefY;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.coefY = jTextField2;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dar;
    private javax.swing.JLabel Evaluacion_de_puntos_en_la_funcion_objetivo_tittle;
    private javax.swing.JTextField No_Ecuaciones;
    private javax.swing.JLabel Puntos_que_forman_la_region_factible_tittle;
    private javax.swing.JPanel Recibir;
    private javax.swing.JPanel Recibir_Cuadro;
    private javax.swing.JTextField coefX;
    private javax.swing.JLabel coefX_tittle;
    private javax.swing.JTextField coefY;
    private javax.swing.JLabel coefY_tittle;
    private javax.swing.JButton crear_campos_button;
    private javax.swing.JLabel foto_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton mostrar_resultados_button;
    private javax.swing.JLabel num_tittle;
    private javax.swing.JLabel valor_maximo_tittle;
    // End of variables declaration//GEN-END:variables
}
