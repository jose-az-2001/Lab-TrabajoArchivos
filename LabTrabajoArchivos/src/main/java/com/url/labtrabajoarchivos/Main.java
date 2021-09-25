package com.url.labtrabajoarchivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {


    public static void main(String[] args) {
        byte salir = 1, opcion = 0;
        Main main = new Main();
        do{
            System.out.println("Ingrese opcion");
            System.out.println("1. Ingresar a la agenda");
            System.out.println("2. Mostrar agenda");
            System.out.println("3. Salir");
            Scanner entrada = new Scanner(System.in);
            Scanner nomb = new Scanner(System.in);
            Scanner telef = new Scanner(System.in);
            Scanner edad = new Scanner(System.in);
            opcion = entrada.nextByte();
            if(opcion == 1){
                System.out.println("Ingrese nombre");
                String nombre = nomb.nextLine();
                System.out.println("Ingrese Telefono");
                int tel = telef.nextInt();
                System.out.println("Ingrese Edad");
                byte ed = edad.nextByte();
                main.AleatoryWritingSpaces(nombre, tel, ed);
            }
            if(opcion == 2){
                //main.AleatoryReading();
            }
            if(opcion == 3){
                salir = 0;
            }
        }while(salir != 0);
        
        
        
    }
    
    private void AleatoryWritingBS(String nombre, int tel, byte edad ){
        try {
            char Separador = '|';
            RandomAccessFile archivo = new RandomAccessFile("AgendaSeparadores.bin", "rw");
            archivo.seek(archivo.length());
            archivo.writeChars(nombre);
            archivo.writeInt(tel);
            archivo.write(edad);
            archivo.writeChar(Separador);
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void AleatoryWritingSpaces(String nombre, int tel, byte edad ){
        try {
            RandomAccessFile archivo = new RandomAccessFile("AgendaEspacios.bin", "rw");
            archivo.seek(archivo.length());
            StringBuffer sb = new StringBuffer(nombre);
            sb.setLength(30);
            archivo.writeChars(sb.toString());
            archivo.writeInt(tel);
            archivo.writeByte(edad);
            
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
