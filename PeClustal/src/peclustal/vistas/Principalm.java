/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peclustal.vistas;

import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.TableColumn;

/**
 *
 * @author DANIEL OROZCO
 */
public class Principalm extends javax.swing.JFrame {
    
    
    /**
     * Creates new form Principalm
     */
    public Principalm() {
        
        initComponents();
        
    }
    
    public void importarArchivo(){
        try{
            JFileChooser Ventana = new JFileChooser(System.getProperty("user.dir"));
            Ventana.showOpenDialog(this);
            File Abrir = Ventana.getSelectedFile();
            if (Abrir != null){
                FileReader fichero = new FileReader(Abrir);
                BufferedReader leer = new BufferedReader(fichero);
                String a;
                String b ="";
                String conf="";
                int i = 0;
                while((a = leer.readLine()) != null){
                    if (i==0){
                        conf=a;
                    }
                        
                    if (i>0){
                        b=b+a;
                    }
                    i++;
                    
                }
                
                String strFasta = analizarFasta(b);
                
                visualizarFasta(strFasta,conf);
                
            }
            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public String analizarFasta(String fasta){
        
        return fasta;
    }
    
    public void visualizarFasta(String strFasta, String conf){
        
            //imprimir cadenaFasta
            
            /*Iterator<Character> nombreIterator = cadenaFasta.iterator();
            while(nombreIterator.hasNext()){
                Character elemento = nombreIterator.next();
                System.out.print(elemento);
            }*/    
            ArrayList<Character> cadenaFasta= new ArrayList<>();
            //String strNormal="acttgtcatggcgactgtccagctttgtgccaggagcctcgcaggggttgatgggattggggttttcccctcccatgtgctcaagactggcgctaaaagttttgagcttctcaaaagtctagagccaccgtccagggagcaggtagctgctgggctccggggacactttgcgttcgggctgggagcgtgctttccacgacggtgacacgcttccctggattgggtaagctcctgactgaacttgatgagtcctctctgagtcacgggctctcggctccgtgtattttcagctcgggaaaatcgctggggctgggggtggggcagtggggacttagcgagtttgggggtgagtgggatggaagcttggctagagggatcatcataggagttgcattgttgggagacctgggtgtagatgatggggatgttaggaccatccgaactcaaagttgaacgcctaggcagaggagtggagctttggggaaccttgagccggcctaaagcgtacttctttgcacatccacccggtgctgggcgtagggaatccctgaaataaaagatgcacaaagcattgaggtctgagacttttggatctcgaaacattgagaactcatagctgtatattttagagcccatggcatcctagtgaaaactggggctccattccgaaatgatcatttgggggtgatccggggagcccaagctgctaaggtcccacaacttccggacctttgtccttcctggagcgatctttccaggcagcccccggctccgctagatggagaaaatccaattgaaggctgtcagtcgtggaagtgagaagtgctaaaccaggggtttgcccgccaggccgaggaggaccgtcgcaatctgagaggcccggcagccctgttattgtttggctccacatttacatttctgcctcttgcagcagcatttccggtttctttttgccggagcagctcactattcacccgatgagaggggaggagagagagagaaaatgtcctttaggccggttcctcttacttggcagagggaggctgctattctccgcctgcatttctttttctggattacttagttatggcctttgcaaaggcaggggtatttgttttgatgcaaacctcaatccctccccttctttgaatggtgtgccccaccccgcgggtcgcctgcaacctaggcggacgctaccatggcgtgagacagggagggaaagaagtgtgcagaaggcaagcccggaggtattttcaagaatgagtatatctcatcttcccggaggaaaaaaaaaaagaatgggtacgtctgagaatcaaattttgaaagagtgcaatgatgggtcgtttgataatttgtcggaaaaacaatctacctgttatctagctttgggctaggccattccagttccagacgcaggctgaacgtcgtgaagcggaaggggcgggcccgcaggcgtccgtgtggtcctccgtgcagccctccggcccgagccggttcttcctggtaggaggcggaactcgaattcatttctcccgctgccccatctcttagctcgcggttgtttcattccgcagtttcttcccatgcacctgccgcgtaccggccactttgtgccgtacttacgtcatctttttcctaaatcgaggtggcatttacacacagcgccagtgcacacagcaagtgcacaggaagatgagttttggcccctaaccgctccgtgatgcctaccaagtcacagacccttttcatcgtcccagaaacgtttcatcacgtctcttcccagtcgattcccgaccccacctttattttgatctccataaccattttgcctgttggagaacttcatatagaatggaatcaggctgggcgctgtggctcacgcctgcactttgggaggccgaggcgggcggattacttgaggataggagttccagaccagcgtggccaacgtggtgaatccccgtctctactaaaaaatacaaaaattagctgggcgtggtgggtgcctgtaatcccagctattcgggagggtgaggcaggagaatcgcttgaacccgggaggcagaggttgcagtgagccaagatcgtgccactacactccagcctgggcgacaagaacgaaactccgtctcaaaaaaaaggggggaatcatacattatgtgctcatttttgtcgggcttctgtccttcaatgtactgtctgacattcgttcatgttgtatatatcagtattttgctccttttcatttagtatagtccatcgattgtatatccgtccttttgatggccttttgagttgtttcccatttgcggttatgaaataaagctgctataaacattcttgtacaattctttttgtgatcatatgttttcgtgtttcttggagaaatacttaggaggggaattgcgagtttggaagtaaaaagtagctgtattttgaactttttcagaagctctgagttttccagagcggttgtaccattttacactccaactagcaaggtatgggagttattatggttgtgccacagccttccggacattaggtattgtcagtctttctaatgtggtatatccttgtggttgtaatttacagttctctattgactaaggatgttcagcattttttcatgtgcctattggccattcgtattttgtttgtaaagtagctcttcgagtcttttacctgttattttggttttttgtttgtttttattgttcagttgtgggactgctttatacattctggatacaagtcctttatcagatccatgtgtcgtgaatgttttcttctgatctgttgcttgcctatttgtttgctttacagagtttacagtatcttaagaggagtggatttatcttttttatgttcagtatttgccttgtcctgtttaggacatctttttttttttttttaaccccagggtcatgaagatattatcttacattttcttttaggacctttatggttgtaagttttacagtaaggtccttgagccattaattaattcttaaaattaattgtttatggtgtgaggtgtaggagtcagtctctggtatctttcctgtatggaaatccagttattctgtctccacttgttgaaataggcttcctttctctactgaatgcttttaattttaattattttacagttggagtatagggctaccattttagtgctattttctttttttctttgttaatttttgagacagggactcacactgttgcccaggctagagtacaatggcacaatcaaggcttactgcagcctcgaacccctgggctcaagcagtcctctagcagcctcacgagtagctgggattactccaccacacccagctaactattttatttttttgtattgacaggatctcactatgttgcccaggctggtctcaaactgctggcctcaagctttcatcccatctcggcctcccaaagtgctgggattacaggtgtgagccaccatgcctgacctcttagtgctattttctatttatctcctctgttctctgctctctttaaacgttggaggaagaaacagtacccatcttacacaaactcttcagaaaacagaggaacagactgggcgcggtggctcatacctgtaatctcagcactttggtacgctgaggcaggggatcatttgaggtcgggagttcgagaccagcctggccaacacggcgaaaccccatctctactaaaaatacaaaaagtagctaggcgtggtgacacatacctgtaatgccagttactcaggaggctgaggcacaagaatcccttgaacctgggaagcggaggttgcagtgagccgagattgcgccactgcactccagcctgggcaacagagtgagaccctgtctcagaaaaaaaaagaaagaaagaaaaaatagaggaatatttcccaacttgttttcgaagccagcataatcctggtaccaaaaccaaacaaggacattataagaaaagaaaatatagaccaatattcctgttagcatagacatgcaacagctaaccaattttagcaaaccaaacctggtaatatagaaaaaaggataaataggccagtcgcggtggctcacgcctgtaatcccagcactttgggaggctgaggcaggcagatcacttgaggtcaggagtttgagaccagcctgaccaacatggtgaaaccccgtttctaataaaaatacaaaaatcaggctgggcacggtggctcacgcctgtaatcccagcactttgggaggccgaggtgggcagatcacgaggtcaggagttcaagaccagcctgaccaatgtggtgaaacgccatctctactaaaaatacaaaaatcagccggtgtggtggcacctgcctgtaatcccagctactcaggaggctgaggcagaattgcttgaacccgggaggcagaggttgcagtgagccaagatcgtgccactgcactccagcctgggcgacagagcaagacttcatctcaaaaaaaaaaaaaaattagctgggcatggtggtgggcacctgaaatcccagctactcgggagtctgaggcaggagaatcgcttgaacccaggaggcagaagttgcactgagctgggatcacaccattgcactccagcctgggcaacagagtgagactccatctcaaaaaaagaaaaagaaaaaggataaatacattctaaccaaataatgtttatctcatgattgtagctgattcaacattcaaaaattggcctggtgcagtagctcaggcctgtaatcccaacattttaggaggctgaggcaggaagatctcttgagcccaggatttcaagaccagcctgggcaacatagtcagactggtctttactggggggaaaaaaatcagtctgtgtaattcaccacattaacaaagggaaacataaaaaccctatgatcatttcaacagatgtagcaaaagcagttaatgatattcaacacatatgcatgattacaaaccaaccaacctcctagcaaactagggaaaggaaacttaacctagtttgataacagggcgtccacagtcggagttccactagcagcatacataatggtagaaaactcagtgctgccgggcgcggtggctcacgcctgtaatgccagcactttgggaggcctaggcgggcggatcacgaggtcaggagatcgagactgtcctgactagcatgctgaaaccccgtctctactaaaaatacaaaaacaaaaaattagccgggcatggtggcgggcgcctatagtcccagctactcgggaggctgaggcgagagaatggcgtgaacccgggaggcggagcttgcagagcctagatcgtgccactgcactccagcctgggtgacagagtgagacttcgtctcaaaaaaaaaaaaaaaaaaaaaagaaaagaaaactcaacgctttttcctctaagatcaggaactagaaaaggatttgactctcacaacgttgataccatactggaggttttaaccaggcaagaaaaagaaataatgagggccgggtgcggtggctcaggcctgtaatcccagcactttgggaagccgagacgggtggatcacgaggtcaggagatcgagaccatcctggctaacacggtgaaaccctgtctctactaaatatacaaaaaattagccgggcgtagtggcgggcgcctgtagtcccagctactcgggaggctgaggcaggagaatggcgtgaactcagggggcggagcttgcagtgagctgagatcgagccactgcactccagcctgggcgacagagcaagactgtgtctcaaaaaaaaaaaaagaaaaagaaataatgattagtggcccgatgtctcacgcctataatcccagcactttgggaggccgaggtgggcagatcacctgaggtctggagttggagaccagcctgacaaagatggtgaaacctcgtctctattaaaatattaaaaaaatagccaggcgttggccgggtacagtggctcatgcctgtaatcccagcactttgggaggccgaggtgggtggatcacctgaggtcaggagttcaacaccagcctggccaacatggtgaaaccccatctctactaaaaatacaaaaattagccgggcgtagtggcgggcgcctgtaatcccagctacttgggaggcttaggcaggagaatcgcttgaacctgggaggcggaggttgtagtgagccgagattgcaccattgcactccagcctgggtgacaaaagcaaaaactccgtctcaaaaaaaaaagaattagccaggggtagtggtgaacgcctgtagtcccagctactcaggaggcagaggcaggagaatcacttgaacccaggaggcagaggttgcagtgagccgagattgtcccattgcactccagcctaggcgacaagagcaaaattccatgtcaaaaaaaaaaaaaaaaaaggaaagaaaaaaaataacgattagaaaggaagaaataaaacacattcacagccagtatgattctatacatacatgtcctaatggggccaggcgtggtggctcatgcctgtaatcctagcacttttaggaggctgaggcaggtggcttccctgggaccagcctggccaacatggtgaaaccccaactctaataaaaatacaaaaaatcagccaggcgtggtgacgggcacctctaatcccagctactcaggaggctgaggcaggagaattgcttggacctgggaggcagaggttgcagtgagccgagatcgcgctattgcactccagcctgggcaacaagagtgaaactccggcagggtgtggtggcttacgcctgtaatcccagcacttcgggaggctgaggcaggccgatcacctgaggtcaggagtttgagaccaacctaacatggtgaaaccccgtctctactaaaaatacaagaattagctgggtgtagtggtgggcgcctgtaatcccagctacttgggaggctgagacagaagaattgcttgaacccaggaggtggaggttgcagtgagctgagatcatgccattgcacaccacgccgggcaacagagcgagattccgtctcaaaaaaaaaaaaaaagagtgaaactctatctcaaaaaaaaaaaaaagtcctaatggaaaatccataaaaagctaccaaaactaataaataaatatagcagggttgcaggttacagggcaatatagttatccctctatctgtaggggcttggttctgggactcctcacacaccaaacccacagatgtctaagtcccatatataagacggtatagtatttggatttaacctacacatatcctcccatatagtttaaattatctctagattacttacattacccccatacaatgaaaatgctaatgtacatgcaagtatgtatgtaagtacttgtactatattgtttagggaatcactggacatataggccttcaagactgataccagcagccactgttaagattctggtcaggcctgcccctgtttggggtctcagttgatctcattgccttcccacccagccaagggcacctgcatttctcttggctccctggccatttggaaggcctagttcagcctggcacatttgtatcctggcccactgatgctggtacccctgggaaggtcctgctctgaaaaacacggagattttagttgctactgaagatttgagagataaagacagggagacctgtctgtagacctgtgtccctccaagtgggattgagactttgggccccccatttcaggacagcacctcctggcctgttgactgaatagatccctgaaggaggtgtacttgcattaatggagtgggggtgggagcagtaccacagatccgcactaacaatcacacagttctctctagaataataatatagaacaagtgaaatagaacaattgcagaaagagctaacctttgttgagctcttactgtgtgcccagcactttcctcaactctacatttcccataatacacagagtactaggtaggccaggcttggtggctcacgcctgtaatcccagcactttaggaggccaaggggggtggatcacctgaggtcgggagttcaagaccagcctgaccaacatggtgaaaccccgtctctactagaagtacaaaattagccaggtgtggtggcacatgcttgtagtcctagctactcagcaggctgaggcaggagaatcatttgaatccgggaggaggttgcagtaagcggagatagtgccactgtactccagcctgggcaataagagctgagactccgtctcaaaataaaataaaataaaataaaataaaataaaataaaataaaaaaagaaaagagcctgccattaaaggagctgtttggtaggggatgttttgtcagtgcaaacaacagaaaagtgggctgggcacagtggttcatgcctgtaatcccagcactttgggaggccaaggcgggcggatcacctgaagttgggagttcaagaccagcctgaccaatatggagaaaccccgtctctactaaaaatacaaaattagccgggcgcagtggcgcatgcctgtaatcccagctactcgggaggctgaggcaggagaatcgcttgaacctgggaggcagaggttgcggtgagccgagatcgcaccattgcactccagcctggacgagagcaaaactctgtctcaaaaaaaaaaaaaaacagaaaagtgtaacaaacacttacagtaggcatgtttcttagcaaatctgatgacaaatttggcataaagaaagagagcatccctgaaaaaaaaaaaaagaaaaagaaagagagcatcctgcctgggcaacatagtgaaaccctgcctctacaaaaaaactcaaaaattggccgggtgcagtggctcacacctgtaatcccagcactttgggagtcggaggcgggaggatcacctgaggtcaggagttcgaaaccagcctggccaacatggcaaaaccccatctctactaaaaatacaaaaaattaatcaggcgcattggtgggcgcctgtaatcccagctactcaggaagttgaggcaagaggatcgcttgaatctgggaggtggaggttacagtgagtcgagatcacaccactgcactctagcctgggtgacagggcgagactccgtctccaaaaaaaaaaagaaaaagaaaaagactaaaaaattagccaggcaggcctctgtggtcccagctacttgggaggctgaggcaggagaatcactgagcccaggagtccgaggctgtagtgagccatgattgcaccactgtaccctagcttgggcaacaaagcaagaccctgcctcaaaagaaaaaagaaagaaagaaagaacatggcgggccaggcacagtggctcacacctgtaatcccagcgctttgagaggccgaggcaggtggatcacaaggtcaggagttccacaccagcctggccaacatggtgaaaccctgtctctactaaaaatacaaaaaatcagccaggcatggtggcaggggcctgtaatcccagctactcgggaggctgaggcaggagaattgcttgaaaccagaaggcagaggttgcagtgagcctagactgcaccactgcactccagcctgggcgaaaagagccaaactccatctcaaaaaacaaacaaaaaaacaaaacaaaagaaaacatggcaaagcctttgaaagcttgtctgggagaaggtgcgatgatagttgcataacttcgtgcaagatgctggtccacacaggggctgccccttgctctttctcgctctcttaacctctcatataacaggcttgtgtgttattcacatttattgagcccaagcaggtgcaaggcattgtgatctaatactttggtcagcaagacaacaagatagatcactgccctgcccttaggaagtgtatatgctattagaggaaacagataaaataaacaaggaaaagtatcagacaatgtaagtgctatgagaatgcaaatgaggtgatgtgaattaaaataggatgacttaaagtctgcacgggaaggagcctacccccatgttcctggctagccaaggaaccaccagttgattagcagagaagggcagccagtctagctagagcttttggggaagagggagtggttgttaagagatgagattaaagaagccgagacgggccattcgtgaggggtttgtaatgcagggctgaggagtgtccgaagagaatgggcaggtgagcggtgagacagttgttcttccagaagctttgcagtgaaaggaatcaaagaaatggagccgtgtatcaggtggggaagggtgggggccaagggggtgtccttccccatacagagattgcaggctgagaatgactatatccttgttaacaggaggtgggagcagggcacggtagctcacacctgtaatcttggcactttaggaggctgaggcgggccgatcacctgaagtaaggagttcgagaccagcctggccaacatgcaaagccctgtctctactaaaaatacaaaaattagctgggtgtggtggtactcgcctgtaatcccagctactcgggagactgaggcaggagaatggcttgaacccggaaggtagaggttgcagtgagctgagatcatgccactgtgctccagcctaggtgacagagagagactccatctcaaaaaaaaaaaaaaaatacaggaagggagttgggaatagggtgcacatttaggaagtcttggggatttagtggtgggaaggttggaagtccctctctgattgtcttttcctcaaagaagtgcatggctggtgaggggtggggcaggagtgcttgggttgtggtgaaacattggaagagagaatgtgaagcagccattcttttcctgctccacaggaagccgagctgtctcagacactggcatggtgttgggggagggggttccttctctgcaggcccaggtgacccagggttggaagtgtctcatgctggatccccacttttcctcttgcagcagccagactgccttccgggtcactgccatggaggagccgcagtcagatcctagcgtcgagccccctctgagtcaggaaacattttcagacctatggaaactgtgagtggatccattggaagggcaggcccaccacccccaccccaaccccagccccctagcagagacctgtgggaagcgaaaattccatgggactgactttctgctcttgtctttcagacttcctgaaaacaacgttctggtaaggacaagggttgggctggggacctggagggctggggacctggagggctggggggctggggggctgaggacctggtcctctgactgctcttttcacccatctacagtcccccttgccgtcccaagcaatggatgatttgatgctgtccccggacgatattgaacaatggttcactgaagacccaggtccagatgaagctcccagaatgccagaggctgctccccccgtggcccctgcaccagcagctcctacaccggcggcccctgcaccagccccctcctggcccctgtcatcttctgtcccttcccagaaaacctaccagggcagctacggtttccgtctgggcttcttgcattctgggacagccaagtctgtgacttgcacggtcagttgccctgaggggctggcttccatgagacttcaatgcctggccgtatccccctgcatttcttttgtttggaactttgggattcctcttcaccctttggcttcctgtcagtgtttttttatagtttacccacttaatgtgtgatctctgactcctgtcccaaagttgaatattccccccttgaatttgggcttttatccatcccatcacaccctcagcatctctcctggggatgcagaacttttctttttcttcatccacgtgtattccttggcttttgaaaataagctcctgaccaggcttggtggctcacacctgcaatcccagcactctcaaagaggccaaggcaggcagatcacctgagcccaggagttcaagaccagcctgggtaacatgatgaaacctcgtctctacaaaaaaatacaaaaaattagccaggcatggtggtgcacacctatagtcccagccacttaggaggctgaggtgggaagatcacttgaggccaggagatggaggctgcagtgagctgtgatcacaccactgtgctccagcctgagtgacagagcaagaccctatctcaaaaaaaaaaaaaaaaaagaaaagctcctgaggtgtagacgccaactctctctagctcgctagtgggttgcaggaggtgcttacgcatgtttgtttctttgctgccgtcttccagttgctttatctgttcacttgtgccctgactttcaactctgtctccttcctcttcctacagtactcccctgccctcaacaagatgttttgccaactggccaagacctgccctgtgcagctgtgggttgattccacacccccgcccggcacccgcgtccgcgccatggccatctacaagcagtcacagcacatgacggaggttgtgaggcgctgcccccaccatgagcgctgctcagatagcgatggtgagcagctggggctggagagacgacagggctggttgcccagggtccccaggcctctgattcctcactgattgctcttaggtctggcccctcctcagcatcttatccgagtggaaggaaatttgcgtgtggagtatttggatgacagaaacacttttcgacatagtgtggtggtgccctatgagccgcctgaggtctggtttgcaactggggtctctgggaggaggggttaagggtggttgtcagtggccctccaggtgagcagtaggggggctttctcctgctgcttatttgacctccctataaccccatgagatgtgcaaagtaaatgggtttaactattgcacagttgaaaaaactgaagcttacagaggctaagggcctcccctgcttggctgggcgcagtggctcatgcctgtaatcccagcactttgggaggccaaggcaggcggatcacgaggttgggagatcgagaccatcctggctaacggtgaaaccccgtctctactgaaaaatacaaaaaaaaattagccgggcgtggtgctgggcacctgtagtcccagctactcgggaggctgaggaaggagaatggcgtgaacctgggcggtggagcttgcagtgagctgagatcacgccactgcactccagcctgggcgacagagcgagattccatctcaaaaaaaaaaaaaaaaggcctcccctgcttgccacaggtctccccaaggcgcactggcctcatcttgggcctgtgttatctcctaggttggctctgactgtaccaccatccactacaactacatgtgtaacagttcctgcatgggcggcatgaaccggaggcccatcctcaccatcatcacactggaagactccaggtcaggagccacttgccaccctgcacactggcctgctgtgccccagcctctgcttgcctctgacccctgggcccacctcttaccgatttcttccatactactacccatccacctctcatcacatccccggcggggaatctccttactgctcccactcagttttcttttctctggctttgggacctcttaacctgtggcttctcctccacctacctggagctggagcttaggctccagaaaggacaagggtggttgggagtagatggagcctggttttttaaatgggacaggtaggacctgatttccttactgcctcttgcttctcttttcctatcctgagtagtggtaatctactgggacggaacagctttgaggtgcgtgtttgtgcctgtcctgggagagaccggcgcacagaggaagagaatctccgcaagaaaggggagcctcaccacgagctgcccccagggagcactaagcgaggtaagcaagcaggacaagaagcggtggaggagaccaagggtgcagttatgcctcagattcacttttatcacctttccttgcctctttcctagcactgcccaacaacaccagctcctctccccagccaaagaagaaaccactggatggagaatatttcacccttcaggtactaagtcttgggacctcttatcaagtggaaagtttccagtctaacactcaaaatgccgttttcttcttgactgttttacctgcaattggggcatttgccatcagggggcagtgatgcctcaaagacaatggctcctggttgtagctaactaacttcagaacaccaacttataccataatatatattttaaaggaccagaccagctttcaaaaagaaaattgttaaagagagcatgaaaatggttctatgactttgcctgatacagatgctacttgacttacgatggtgttacttcctgataaactcgtcgtaagttgaaaatattgtaagttgaaaatggatttaatacacctaatctaaggaacatcatagcttagcctagcctgctttttttttttttttttttggagacagagtctcactctgtcacccaggctggagtgcagtggcgggatctcggctcactgcaacctccgccttctgggttcaagcgattctcctgcctcagcccactgagtagctgggattacaggcacctgccccgacgcccagctaattttttgttatttatttatttttttttttagtagagatgaggtttcaccatgttggccaggctagtctcgaactcctgaccttgtgatctgcctgccttggcctcccaaagtgctgggattacaggcgtgagccaccgcacccggcctgcctagcctacttttattttatttttaatggagacagcatcttgctctgttgcccaggctggattacagtgatgtgatcatagctcattataccctcctgggctcaagcaatccccctaactctgcctccccagtagctaggaccacaggcatacaccaccatacccagctaatttttaaaattttttgtagatagatagagtctcactatgttgcccaggctggtctctagcctacttttttgagacaaggtcttgctctgtcacccaggctggatagagtgcagtagtgcagtcacagctcactgcagcctccacctcccaggctccatccatcctcccagctcagcctcccaagttgcttcaactacaggcctgcaccaccatgcctggctaatttttatttatttatttttattttattttattttatttttttgagactcagtctcactctgtcgcccaggctggagtgcagtggcatgatctcggctcactgcaacctctgcctcctgggttcaagtgattctcctgcctcagcctcccgaatagctaggactacaagcgcctgctaccacgcccagctaatttttgtatttttagtagagacagggtttcaccatgttggccaggctggtctcgaacttctgaccatgtgatccgcccgcctcggcctcccaaagtgctgggattacaggtgtgagccaccacgcccggctaatttttatttatttatttaaagacagagtctcactctgtcactcaggctagagtgcagtggcaccatctcagctcactgcagccttgacctccctgggctccggtgatttcaccctcccaagtagctaggactacaggcacatgccacgacacccagctaattttttattttctgtgaagtcaaggtcttgctacgttgcccatgctggtatcaaacccctgggctcaatcaatccttccacctcagcctccccaagtattggggttacaggcatgagctaccacactcagccctagcctacttgaaacgtgttcagagcatttaagttaccctacagttgggcaaagtcatctaacacaaagccctttttatagtaataaaatgttgtatatctcatgtgatttattgaatattgttactgaaagtgagaaacagcatggttgcatgaaaggaggcacagtcgagccaggcacagcctgggcgcagagcgagactcaaaaaaagaaaaggccaggcgcactggctcacgcctgtaatcccagcatttcgggaggctgaggcgggtggatcacctgaggtcaggagttcaagaccagcctagccaacatggtgaaaccccgtctctactaaaatacaaaaattaaccgggcgtgatggcaggtgcctgtaatcccagctacttgggaggctgaggcaggagaatcgcttgaaccaggaggcggaggttgcagggagccaagatggcgccactgcactccagcctgggcgatagagtgagactccgtctcagaaaaaaaagaaaagaaacgaggcacagtcgcatgcacatgtagtcccagttacttgagaggctaaggcaggaggatctcttgagcccaagagtttgagtccagcctgaacaacatagcaagacatcatctctaaaatttaaaaaagggccgggcacagtggctcacacctgtaatcccagcactttgggaggtggaggtgggtagatcacctgacgtcaggagttggaaaccagcctggctaacatggtgaagccccatctctactaaaaacacaaaaattagccaggtgtggtagcacacgcctgtagtcccagctactcgggaggctgaggcacaagaatcacttgaaccccagaggcggagattgcaatcagccaagattgcaccattgcactcccgcctgggcaacagagtgagaccccatctcaaaataaataaataaatatttttaaaagtcagctgtataggtacttgaagtgcagtttctactaaatgcatgttgcttttgtaccgtcataaagtcaaacaattgtaacttgaaccatcttttaactcaggtactgtgtatatacttacttctccccctcctctgttgctgcagatccgtgggcgtgagcgcttcgagatgttccgagagctgaatgaggccttggaactcaaggatgcccaggctgggaaggagccaggggggagcagggctcactccaggtgagtgacctcagccccttcctggccctactcccctgccttcctaggttggaaagccataggattccattctcatcctgccttcatggtcaaaggcagctgaccccatctcattgggtcccagccctgcacagacatttttttagtcttcctccggttgaatcctataaccacattcttgcctcagtgtatccacagaacatccaaacccagggacgagtgtggatacttctttgccattctccgcaactcccagcccagagctggagggtctcaaggaggggcctaataattgtgtaatactgaatacagccagagtttcaggtcatatactcagccctgccatgcaccggcaggtcctaggtgacccccgtcaaactcagtttccttatatataaaatggggtaagggggccgggcgcagtggctcacgaatcccacactctgggaggccaaggcgagtggatcacctgaggtcgggagtttgagcccagcctgaccaacatggagaaaccccatctctactaaaaatacaaaagtagccgggcgtggtgatgcatgcctgtaatcccagctacctactcgggaggctgaggcaggagaatcgcttgaacccgggaggcagaggttgcggtgagctgagatctcaccattacactccagcctgggcaacaagagtgaaactccgtctcaaaaaagataaataaagtaaaatggggtaagggaagattacgagactaatacacactaatactctgaggtgctcagtaaacatatttgcatggggtgtggccaccatcttgatttgaattcccgttgtcccagccttaggcccttcaaagcattggtcagggaaaaggggcacagaccctctcactcatgtgatgtcatctctcctccctgcttctgtctcctacagccacctgaagtccaaaaagggtcagtctacctcccgccataaaaaactcatgttcaagacagaagggcctgactcagactgacattctccacttcttgttccccactgacagcctcccacccccatctctccctcccctgccattttgggttttgggtctttgaacccttgcttgcaataggtgtgcgtcagaagcacccaggacttccatttgctttgtcccggggctccactgaacaagttggcctgcactggtgttttgttgtggggaggaggatggggagtaggacataccagcttagattttaaggtttttactgtgagggatgtttgggagatgtaagaaatgttcttgcagttaagggttagtttacaatcagccacattctaggtaggggcccacttcaccgtactaaccagggaagctgtccctcactgttgaattttctctaacttcaaggcccatatctgtgaaatgctggcatttgcacctacctcacagagtgcattgtgagggttaatgaaataatgtacatctggccttgaaaccaccttttattacatggggtctagaacttgacccccttgagggtgcttgttccctctccctgttggtcggtgggttggtagtttctacagttgggcagctggttaggtagagggagttgtcaagtctctgctggcccagccaaaccctgtctgacaacctcttggtgaaccttagtacctaaaaggaaatctcaccccatcccacaccctggaggatttcatctcttgtatatgatgatctggatccaccaagacttgttttatgctcagggtcaatttcttttttcttttttttttttttttttctttttctttgagactgggtctcgctttgttgcccaggctggagtggagtggcgtgatcttggcttactgcagcctttgcctccccggctcgagcagtcctgcctcagcctccggagtagctgggaccacaggttcatgccaccatggccagccaacttttgcatgttttgtagagatggggtctcacagtgttgcccaggctggtctcaaactcctgggctcaggcgatccacctgtctcagcctcccagagtgctgggattacaattgtgagccaccacgtccagctggaagggtcaacatcttttacattctgcaagcacatctgcattttcaccccacccttcccctccttctccctttttatatcccatttttatatcgatctcttattttacaataaaactttgctgccacctgtgtgtctgaggggtg";
            String strNormal="MEEPQSDPSVEPPLSQETFSDLWKLLPENNVLSPLPSQAMDDLMLSPDDIEQWFTEDPGPDEAPRMPEAAPRVAPAPAAPTPAAPAPAPSWPLSSSVPSQKTYQGSYGFRLGFLHSGTAKSVTCTYSPALNKMFCQLAKTCPVQLWVDSTPPPGTRVRAMAIYKQSQHMTEVVRRCPHHERCSDSDGLAPPQHLIRVEGNLRVEYLDDRNTFRHSVVVPYEPPEVGSDCTTIHYNYMCNSSCMGGMNRRPILTIITLEDSSGNLLGRNSFEVHVCACPGRDRRTEEENLRKKGEPHHELPPGSTKRALSNNTSSSPQPKKKPLDGEYFTLQIRGRERFEMFRELNEALELKDAQAGKEPGGSRAHSSHLKSKKGQSTSRHKKLMFKTEGPDSD";
            for (char c : strFasta.toCharArray()) {
                    cadenaFasta.add(c);
                }
            ArrayList<Character> cadenaNormal =new ArrayList<>();
            for (char c : strNormal.toCharArray()) {
                    cadenaNormal.add(c);
                }
            
            ArrayList<Integer> cambios=neighborJoining(cadenaNormal, cadenaFasta);
            String str="";
            for(int i=0; i< cambios.get(cambios.size()-1); i++){
                
                str=str+" ";
                
            }
            strFasta=str+strFasta;
            
            for(int i=0; i<cambios.size();i++){
                str=str+cambios.get(i).toString();
            }
            /*for(int i=0; i<strFasta.length();i++)
            {
                if (i%3 == 0){
                    tribase = strFasta.charAt(i)+strFasta.charAt(i+1)+strFasta.charAt(i+3);
                    
                }
            }*/
            jTextArea2.setText(">>BAC16799.1 P53 [Homo sapiens]\n"+conf);
            jTextArea1.setText(strNormal.toUpperCase()+"\n"+strFasta.toUpperCase()+"\n"+str);
    }

    public ArrayList<Integer> neighborJoining(
            ArrayList<Character> cadenaN, ArrayList<Character> cadenaM){
        
        int  variante = 0, aux=0, cont=0, contAux=999999999;
        
        ArrayList<Integer> cadenaAux = new ArrayList<>(cadenaM.size());
        
        for(int i=0; i<7; i++){
            
            cont=0;
            for (int j = 0; j < cadenaM.size(); j++) {
                
                if(!cadenaM.get(j).equals(cadenaN.get(aux))){
                    cont++;
                }
                
                aux++;
            }
            if(cont < contAux){
                
                variante=aux - cadenaM.size();
                contAux = cont;
            }
        }
        
        for(int i = 0; i < cadenaM.size(); i++){
            
            
            if(cadenaM.get(i) != cadenaN.get(i+variante)){
                cadenaAux.add(1);
            }else{
                cadenaAux.add(0);
            }
            
        }
        
        cadenaAux.add(variante);
        
        return cadenaAux;
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PeClustal (Beta)");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText(">BAC16799.1 P53 [Homo sapiens]");
        jScrollPane3.setViewportView(jTextArea2);

        jMenu1.setText("File");

        jMenuItem1.setText("Import");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator2);

        jMenuItem4.setText("Exit");
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        importarArchivo();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String strNormal="MEEPQSDPSVEPPLSQETFSDLWKLLPENNVLSPLPSQAMDDLMLSPDDIEQWFTEDPGPDEAPRMPEAAPRVAPAPAAPTPAAPAPAPSWPLSSSVPSQKTYQGSYGFRLGFLHSGTAKSVTCTYSPALNKMFCQLAKTCPVQLWVDSTPPPGTRVRAMAIYKQSQHMTEVVRRCPHHERCSDSDGLAPPQHLIRVEGNLRVEYLDDRNTFRHSVVVPYEPPEVGSDCTTIHYNYMCNSSCMGGMNRRPILTIITLEDSSGNLLGRNSFEVHVCACPGRDRRTEEENLRKKGEPHHELPPGSTKRALSNNTSSSPQPKKKPLDGEYFTLQIRGRERFEMFRELNEALELKDAQAGKEPGGSRAHSSHLKSKKGQSTSRHKKLMFKTEGPDSD";
        jTextArea1.setText(strNormal.toUpperCase());
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principalm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principalm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principalm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principalm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principalm().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
