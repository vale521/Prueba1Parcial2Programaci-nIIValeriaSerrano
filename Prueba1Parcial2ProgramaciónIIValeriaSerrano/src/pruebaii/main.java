/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaii;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author valer
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFileChooser chooser= new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        int resultado = chooser.showOpenDialog(null);
        if(resultado==JFileChooser.APPROVE_OPTION)
        {
          File carpeta= chooser.getSelectedFile();
          int[] cantidades= cantidades(carpeta);
          System.out.println("RESUMEN TOTAL DE ARCHIVOS ENCONTRADOS");
          System.out.println("TXT: "+cantidades[0]+"\nJAVA: "+cantidades[1]+"\nPDF: "+cantidades[2]+"\nOTROS: "+cantidades[3]);
        }
        else
        {
            System.out.println("No se seleccionó una carpeta. ");
        }
    }
    
    public static int[] cantidades(File file)
    {
        
        int contOtros=0, contTxt=0, contJava=0, contPdf=0;
        if(file.isDirectory()==true)
        {
            File[] archivos= file.listFiles();
            if(archivos!=null)
            {
                for (File archivo : archivos) 
                {
                    int[] resultado= cantidades(archivo);
                    
                    contOtros+=resultado[3];
                    contTxt+=resultado[0];
                    contJava+=resultado[1];
                    contPdf+=resultado[2];
                }
            }
        }
        else
        {
            String nombre= file.getName().toLowerCase();

            if(nombre.endsWith(".txt")==true)
            {
                contTxt++;
            }
            else if(nombre.endsWith(".java")==true)
            {
                contJava++;
            }
            else if(nombre.endsWith(".pdf")==true)
            {
                contPdf++;
            }
            else
            {
                contOtros++;
            }
        }
        return new int[]{contTxt, contJava, contPdf, contOtros};
    }
            
}
