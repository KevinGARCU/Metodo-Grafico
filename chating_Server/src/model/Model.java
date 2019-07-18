/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import metodografico.MetodoGrafico;
import view.View;

/**
 *
 * @author Maria Fernanda
 */
public class Model {

    View v;
    public Scanner sc = new Scanner(System.in);
    public Socket cliente = null;
    public final int PUERTO1 = 5353;
    public ServerSocket ss;
    public InputStream it;
    public OutputStream ot;
    public InputStreamReader e1;
    public OutputStreamWriter s;
    public BufferedReader entrada;
    public PrintWriter salida;
    public String mensage, aux;
    public double n;
    public ByteArrayOutputStream baos;
    public BufferedImage originalImage;
    public byte[] imageInByte;
    public ArrayList<String> c = new ArrayList<>();
    public DataOutputStream output;
    public BufferedInputStream buffIn;
    public BufferedOutputStream buffOut;
    public int in;
    File localFile;
    MetodoGrafico metod;
    String xy;
    ArrayList<double[]> xyx = new ArrayList<>();

    public Model() {
        
        try {
            //establece conexion con el usuario
            ss = new ServerSocket(PUERTO1);
            cliente = ss.accept();
            it = cliente.getInputStream();
            e1 = new InputStreamReader(it);
            entrada = new BufferedReader(e1);
            ot = cliente.getOutputStream();
            s = new OutputStreamWriter(ot);
            salida = new PrintWriter(s, true);
            //recibe los datos de la parte grafica del usuario
            for (;;) {
                mensage = entrada.readLine();
                c.add(mensage);
                salida.println("1");
                if (Objects.equals(c.get(c.size() - 1), "0")) {
                    break;
                }
            }
            //se crea aqui con el fin de pasarle los datos a la parte grafica de ferr y crear la imagen
            v = new View();
            
            //quita el 0 restante del arraylist para que mateo no estalle
            c.remove(c.size()-1);
            
            for (int i = 0; i < c.size(); i++) {
                System.out.println(c.get(i));
            }
            
            //parte logica de mateo que recibe mis datos bergas y se los manda a ferr
            metod = new MetodoGrafico();
            Splitear split = new Splitear();
            String meow=metod.Devolver(c);
            xyx=split.SplitearPuntos(meow);
            salida.println(meow);
            salida.println("0");
            v.takePhoto(metod.inf,xyx.get(0), xyx.get(1),metod.xdd,metod.xdd2);
            //toma la imagen y la manda al user
            Send_Nudes();
            entrada.close();
            salida.close();
            cliente.close();
            it.close();
            ss.close();

        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
    }

    public void Send_Nudes() {
        //parte de ferr que no entiendo del todo  o-_(o.o)_-o x2
        localFile = new File("C:\\Users\\Estudiantes\\Documents\\NetBeansProjects\\CAPITULO 3\\chating_Server\\src\\view\\GraficaPRO.jpg");
        try {
            buffIn = new BufferedInputStream(new FileInputStream(localFile));
            buffOut = new BufferedOutputStream(cliente.getOutputStream());

            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
            dos.writeUTF(localFile.getName());
            imageInByte = new byte[6000];
            while ((in = buffIn.read(imageInByte)) != -1) {
                buffOut.write(imageInByte, 0, in);
            }

            buffIn.close();
            buffOut.close();

        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
