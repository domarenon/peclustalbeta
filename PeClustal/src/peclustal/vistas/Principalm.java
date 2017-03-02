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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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
                
                //visualizarFasta(strFasta,conf);
                
            }
            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public String analizarFasta(String fasta){
    
        String strNormal="ATG GAG GAG CCG CAG TCA GAT CCT AGC GTC GAG CCC CCT CTG AGT CAG GAA ACA TTT TCA " +
"GAC CTA TGG AAA CTA CTT CCT GAA AAC AAC GTT CTG TCC CCC TTG CCG TCC CAA GCA ATG " +
"GAT GAT TTG ATG CTG TCC CCG GAC GAT ATT GAA CAA TGG TTC ACT GAA GAC CCA GGT CCA " +
"GAT GAA GCT CCC AGA ATG CCA GAG GCT GCT CCC CGC GTG GCC CCT GCA CCA GCA GCT CCT " +
"ACA CCG GCG GCC CCT GCA CCA GCC CCC TCC TGG CCC CTG TCA TCT TCT GTC CCT TCC CAG " +
"AAA ACC TAC CAG GGC AGC TAC GGT TTC CGT CTG GGC TTC TTG CAT TCT GGG ACA GCC AAG " +
"TCT GTG ACT TGC ACG TAC TCC CCT GCC CTC AAC AAG ATG TTT TGC CAA CTG GCC AAG ACC " +
"TGC CCT GTG CAG CTG TGG GTT GAT TCC ACA CCC CCG CCC GGC ACC CGC GTC CGC GCC ATG " +
"GCC ATC TAC AAG CAG TCA CAG CAC ATG ACG GAG GTT GTG AGG CGC TGC CCC CAC CAT GAG " +
"CGC TGC TCA GAT AGC GAT GGT CTG GCC CCT CCT CAG CAT CTT ATC CGA GTG GAA GGA AAT " +
"TTG CGT GTG GAG TAT TTG GAT GAC AGA AAC ACT TTT CGA CAT AGT GTG GTG GTG CCC TAT " +
"GAG CCG CCT GAG GTT GGC TCT GAC TGT ACC ACC ATC CAC TAC AAC TAC ATG TGT AAC AGT " +
"TCC TGC ATG GGC GGC ATG AAC CGG AGG CCC ATC CTC ACC ATC ATC ACA CTG GAA GAC TCC " +
"AGT GGT AAT CTA CTG GGA CGG AAC AGC TTT GAG GTG CGT GTT TGT GCC TGT CCT GGG AGA " +
"GAC CGG CGC ACA GAG GAA GAG AAT CTC CGC AAG AAA GGG GAG CCT CAC CAC GAG CTG CCC " +
"CCA GGG AGC ACT AAG CGA GCA CTG CCC AAC AAC ACC AGC TCC TCT CCC CAG CCA AAG AAG " +
"AAA CCA CTG GAT GGA GAA TAT TTC ACC CTT CAG ATC CGT GGG CGT GAG CGC TTC GAG ATG " +
"TTC CGA GAG CTG AAT GAG GCC TTG GAA CTC AAG GAT GCC CAG GCT GGG AAG GAG CCA GGG " +
"GGG AGC AGG GCT CAC TCC AGC CAC CTG AAG TCC AAA AAG GGT GAG TCT ACC TCC CGC CAT " +
"AAA AAA CTC ATG TTC AAG ACA GAA GGG CCT GAC TCA GAC TGA";
        fasta = "tta";
        int cont = 0;
        int contAux = 0, posicionCorrecta = 0;
        String cadenaAux[] = strNormal.split(" ");
        String aminoacid[] = new  String[cadenaAux.length];
        
        strNormal = strNormal.replaceAll("GCT", "A");
        strNormal = strNormal.replaceAll("GCC", "A");
        strNormal = strNormal.replaceAll("GCG", "A");
        strNormal = strNormal.replaceAll("GCA", "A");
        strNormal = strNormal.replaceAll("CGT", "R");
        strNormal = strNormal.replaceAll("CGC", "R");
        strNormal = strNormal.replaceAll("CGG", "R");
        strNormal = strNormal.replaceAll("CGA", "R");
        strNormal = strNormal.replaceAll("AGA", "R");
        strNormal = strNormal.replaceAll("AGG", "R");
        strNormal = strNormal.replaceAll("AAC", "N");
        strNormal = strNormal.replaceAll("AAT", "N");
        strNormal = strNormal.replaceAll("GAC", "D");
        strNormal = strNormal.replaceAll("GAT", "D");
        strNormal = strNormal.replaceAll("TGC", "C");
        strNormal = strNormal.replaceAll("TGT", "C");
        strNormal = strNormal.replaceAll("GAA", "E");
        strNormal = strNormal.replaceAll("GAG", "E");
        strNormal = strNormal.replaceAll("CAG", "Q");
        strNormal = strNormal.replaceAll("CAA", "Q");
        strNormal = strNormal.replaceAll("GGT", "G");
        strNormal = strNormal.replaceAll("GGC", "G");
        strNormal = strNormal.replaceAll("GGG", "G");
        strNormal = strNormal.replaceAll("GGA", "G");
        strNormal = strNormal.replaceAll("CAT", "H");
        strNormal = strNormal.replaceAll("CAC", "H");
        strNormal = strNormal.replaceAll("ATC", "I");
        strNormal = strNormal.replaceAll("ATT", "I");
        strNormal = strNormal.replaceAll("CTG", "L");
        strNormal = strNormal.replaceAll("CTA", "L");
        strNormal = strNormal.replaceAll("CTT", "L");
        strNormal = strNormal.replaceAll("CTC", "L");
        strNormal = strNormal.replaceAll("TTG", "L");
        strNormal = strNormal.replaceAll("AAG", "K");
        strNormal = strNormal.replaceAll("AAA", "K");
        strNormal = strNormal.replaceAll("ATG", "M");
        strNormal = strNormal.replaceAll("TTC", "F");
        strNormal = strNormal.replaceAll("TTT", "F");
        strNormal = strNormal.replaceAll("CCT", "P");
        strNormal = strNormal.replaceAll("CCG", "P");
        strNormal = strNormal.replaceAll("CCA", "P");
        strNormal = strNormal.replaceAll("CCC", "P");
        strNormal = strNormal.replaceAll("TCA", "S");
        strNormal = strNormal.replaceAll("AGC", "S");
        strNormal = strNormal.replaceAll("AGT", "S");
        strNormal = strNormal.replaceAll("TCC", "S");
        strNormal = strNormal.replaceAll("TCT", "S");
        strNormal = strNormal.replaceAll("ACG", "S");
        strNormal = strNormal.replaceAll("ACC", "T");
        strNormal = strNormal.replaceAll("ACA", "T");
        strNormal = strNormal.replaceAll("ACT", "T");
        strNormal = strNormal.replaceAll("TGG", "W");
        strNormal = strNormal.replaceAll("TAC", "Y");
        strNormal = strNormal.replaceAll("TAT", "Y");
        strNormal = strNormal.replaceAll("GTG", "V");
        strNormal = strNormal.replaceAll("GTC", "V");
        strNormal = strNormal.replaceAll("GTT", "V");
        
        System.out.println(strNormal);
        for (int i = 0; i < cadenaAux.length; i++) {
            System.out.print(i + " ");
        }
        
        for (int i = 0; i < (strNormal.length() - fasta.length()); i++) {

            cont=0;
            for (int j = 0; j < fasta.length(); j++) {

                if (strNormal.toCharArray()[i + j] == fasta.toCharArray()[j]) {
                    cont++;
                }

            }
            if (cont > contAux) {
                contAux = cont;
                posicionCorrecta = i;
            }

        }

        String cambios = new String();
        int contadorC = 0;
        for (int i = posicionCorrecta; i < (posicionCorrecta + fasta.length()); i++) {
            
            if(strNormal.toCharArray()[i] == fasta.toCharArray()[contadorC])
                cambios = cambios.concat(" ");
            else
                cambios = cambios.concat("*");
            contadorC++;
        }
        System.out.println(cambios);
        String strAux="";
        for (int i = 0; i < posicionCorrecta; i++) {
            strAux += " ";
        }
        fasta = strAux.concat(fasta);
        cambios = strAux.concat(cambios);

        jTextArea1.setText(strNormal.toUpperCase()+"\n"+fasta.toUpperCase()+"\n"+cambios);
        
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
            String strNormal="acttgtcatggcgactgtccagctttgtgccaggagcctcgcaggggttgatgggattggggttttcccctcccatgtgctcaagactggcgctaaaagttttgagcttctcaaaagtctagagccaccgtccagggagcaggtagctgctgggctccggggacactttgcgttcgggctgggagcgtgctttccacgacggtgacacgcttccctggattgggtaagctcctgactgaacttgatgagtcctctctgagtcacgggctctcggctccgtgtattttcagctcgggaaaatcgctggggctgggggtggggcagtggggacttagcgagtttgggggtgagtgggatggaagcttggctagagggatcatcataggagttgcattgttgggagacctgggtgtagatgatggggatgttaggaccatccgaactcaaagttgaacgcctaggcagaggagtggagctttggggaaccttgagccggcctaaagcgtacttctttgcacatccacccggtgctgggcgtagggaatccctgaaataaaagatgcacaaagcattgaggtctgagacttttggatctcgaaacattgagaactcatagctgtatattttagagcccatggcatcctagtgaaaactggggctccattccgaaatgatcatttgggggtgatccggggagcccaagctgctaaggtcccacaacttccggacctttgtccttcctggagcgatctttccaggcagcccccggctccgctagatggagaaaatccaattgaaggctgtcagtcgtggaagtgagaagtgctaaaccaggggtttgcccgccaggccgaggaggaccgtcgcaatctgagaggcccggcagccctgttattgtttggctccacatttacatttctgcctcttgcagcagcatttccggtttctttttgccggagcagctcactattcacccgatgagaggggaggagagagagagaaaatgtcctttaggccggttcctcttacttggcagagggaggctgctattctccgcctgcatttctttttctggattacttagttatggcctttgcaaaggcaggggtatttgttttgatgcaaacctcaatccctccccttctttgaatggtgtgccccaccccgcgggtcgcctgcaacctaggcggacgctaccatggcgtgagacagggagggaaagaagtgtgcagaaggcaagcccggaggtattttcaagaatgagtatatctcatcttcccggaggaaaaaaaaaaagaatgggtacgtctgagaatcaaattttgaaagagtgcaatgatgggtcgtttgataatttgtcggaaaaacaatctacctgttatctagctttgggctaggccattccagttccagacgcaggctgaacgtcgtgaagcggaaggggcgggcccgcaggcgtccgtgtggtcctccgtgcagccctccggcccgagccggttcttcctggtaggaggcggaactcgaattcatttctcccgctgccccatctcttagctcgcggttgtttcattccgcagtttcttcccatgcacctgccgcgtaccggccactttgtgccgtacttacgtcatctttttcctaaatcgaggtggcatttacacacagcgccagtgcacacagcaagtgcacaggaagatgagttttggcccctaaccgctccgtgatgcctaccaagtcacagacccttttcatcgtcccagaaacgtttcatcacgtctcttcccagtcgattcccgaccccacctttattttgatctccataaccattttgcctgttggagaacttcatatagaatggaatcaggctgggcgctgtggctcacgcctgcactttgggaggccgaggcgggcggattacttgaggataggagttccagaccagcgtggccaacgtggtgaatccccgtctctactaaaaaatacaaaaattagctgggcgtggtgggtgcctgtaatcccagctattcgggagggtgaggcaggagaatcgcttgaacccgggaggcagaggttgcagtgagccaagatcgtgccactacactccagcctgggcgacaagaacgaaactccgtctcaaaaaaaaggggggaatcatacattatgtgctcatttttgtcgggcttctgtccttcaatgtactgtctgacattcgttcatgttgtatatatcagtattttgctccttttcatttagtatagtccatcgattgtatatccgtccttttgatggccttttgagttgtttcccatttgcggttatgaaataaagctgctataaacattcttgtacaattctttttgtgatcatatgttttcgtgtttcttggagaaatacttaggaggggaattgcgagtttggaagtaaaaagtagctgtattttgaactttttcagaagctctgagttttccagagcggttgtaccattttacactccaactagcaaggtatgggagttattatggttgtgccacagccttccggacattaggtattgtcagtctttctaatgtggtatatccttgtggttgtaatttacagttctctattgactaaggatgttcagcattttttcatgtgcctattggccattcgtattttgtttgtaaagtagctcttcgagtcttttacctgttattttggttttttgtttgtttttattgttcagttgtgggactgctttatacattctggatacaagtcctttatcagatccatgtgtcgtgaatgttttcttctgatctgttgcttgcctatttgtttgctttacagagtttacagtatcttaagaggagtggatttatcttttttatgttcagtatttgccttgtcctgtttaggacatctttttttttttttttaaccccagggtcatgaagatattatcttacattttcttttaggacctttatggttgtaagttttacagtaaggtccttgagccattaattaattcttaaaattaattgtttatggtgtgaggtgtaggagtcagtctctggtatctttcctgtatggaaatccagttattctgtctccacttgttgaaataggcttcctttctctactgaatgcttttaattttaattattttacagttggagtatagggctaccattttagtgctattttctttttttctttgttaatttttgagacagggactcacactgttgcccaggctagagtacaatggcacaatcaaggcttactgcagcctcgaacccctgggctcaagcagtcctctagcagcctcacgagtagctgggattactccaccacacccagctaactattttatttttttgtattgacaggatctcactatgttgcccaggctggtctcaaactgctggcctcaagctttcatcccatctcggcctcccaaagtgctgggattacaggtgtgagccaccatgcctgacctcttagtgctattttctatttatctcctctgttctctgctctctttaaacgttggaggaagaaacagtacccatcttacacaaactcttcagaaaacagaggaacagactgggcgcggtggctcatacctgtaatctcagcactttggtacgctgaggcaggggatcatttgaggtcgggagttcgagaccagcctggccaacacggcgaaaccccatctctactaaaaatacaaaaagtagctaggcgtggtgacacatacctgtaatgccagttactcaggaggctgaggcacaagaatcccttgaacctgggaagcggaggttgcagtgagccgagattgcgccactgcactccagcctgggcaacagagtgagaccctgtctcagaaaaaaaaagaaagaaagaaaaaatagaggaatatttcccaacttgttttcgaagccagcataatcctggtaccaaaaccaaacaaggacattataagaaaagaaaatatagaccaatattcctgttagcatagacatgcaacagctaaccaattttagcaaaccaaacctggtaatatagaaaaaaggataaataggccagtcgcggtggctcacgcctgtaatcccagcactttgggaggctgaggcaggcagatcacttgaggtcaggagtttgagaccagcctgaccaacatggtgaaaccccgtttctaataaaaatacaaaaatcaggctgggcacggtggctcacgcctgtaatcccagcactttgggaggccgaggtgggcagatcacgaggtcaggagttcaagaccagcctgaccaatgtggtgaaacgccatctctactaaaaatacaaaaatcagccggtgtggtggcacctgcctgtaatcccagctactcaggaggctgaggcagaattgcttgaacccgggaggcagaggttgcagtgagccaagatcgtgccactgcactccagcctgggcgacagagcaagacttcatctcaaaaaaaaaaaaaaattagctgggcatggtggtgggcacctgaaatcccagctactcgggagtctgaggcaggagaatcgcttgaacccaggaggcagaagttgcactgagctgggatcacaccattgcactccagcctgggcaacagagtgagactccatctcaaaaaaagaaaaagaaaaaggataaatacattctaaccaaataatgtttatctcatgattgtagctgattcaacattcaaaaattggcctggtgcagtagctcaggcctgtaatcccaacattttaggaggctgaggcaggaagatctcttgagcccaggatttcaagaccagcctgggcaacatagtcagactggtctttactggggggaaaaaaatcagtctgtgtaattcaccacattaacaaagggaaacataaaaaccctatgatcatttcaacagatgtagcaaaagcagttaatgatattcaacacatatgcatgattacaaaccaaccaacctcctagcaaactagggaaaggaaacttaacctagtttgataacagggcgtccacagtcggagttccactagcagcatacataatggtagaaaactcagtgctgccgggcgcggtggctcacgcctgtaatgccagcactttgggaggcctaggcgggcggatcacgaggtcaggagatcgagactgtcctgactagcatgctgaaaccccgtctctactaaaaatacaaaaacaaaaaattagccgggcatggtggcgggcgcctatagtcccagctactcgggaggctgaggcgagagaatggcgtgaacccgggaggcggagcttgcagagcctagatcgtgccactgcactccagcctgggtgacagagtgagacttcgtctcaaaaaaaaaaaaaaaaaaaaaagaaaagaaaactcaacgctttttcctctaagatcaggaactagaaaaggatttgactctcacaacgttgataccatactggaggttttaaccaggcaagaaaaagaaataatgagggccgggtgcggtggctcaggcctgtaatcccagcactttgggaagccgagacgggtggatcacgaggtcaggagatcgagaccatcctggctaacacggtgaaaccctgtctctactaaatatacaaaaaattagccgggcgtagtggcgggcgcctgtagtcccagctactcgggaggctgaggcaggagaatggcgtgaactcagggggcggagcttgcagtgagctgagatcgagccactgcactccagcctgggcgacagagcaagactgtgtctcaaaaaaaaaaaaagaaaaagaaataatgattagtggcccgatgtctcacgcctataatcccagcactttgggaggccgaggtgggcagatcacctgaggtctggagttggagaccagcctgacaaagatggtgaaacctcgtctctattaaaatattaaaaaaatagccaggcgttggccgggtacagtggctcatgcctgtaatcccagcactttgggaggccgaggtgggtggatcacctgaggtcaggagttcaacaccagcctggccaacatggtgaaaccccatctctactaaaaatacaaaaattagccgggcgtagtggcgggcgcctgtaatcccagctacttgggaggcttaggcaggagaatcgcttgaacctgggaggcggaggttgtagtgagccgagattgcaccattgcactccagcctgggtgacaaaagcaaaaactccgtctcaaaaaaaaaagaattagccaggggtagtggtgaacgcctgtagtcccagctactcaggaggcagaggcaggagaatcacttgaacccaggaggcagaggttgcagtgagccgagattgtcccattgcactccagcctaggcgacaagagcaaaattccatgtcaaaaaaaaaaaaaaaaaaggaaagaaaaaaaataacgattagaaaggaagaaataaaacacattcacagccagtatgattctatacatacatgtcctaatggggccaggcgtggtggctcatgcctgtaatcctagcacttttaggaggctgaggcaggtggcttccctgggaccagcctggccaacatggtgaaaccccaactctaataaaaatacaaaaaatcagccaggcgtggtgacgggcacctctaatcccagctactcaggaggctgaggcaggagaattgcttggacctgggaggcagaggttgcagtgagccgagatcgcgctattgcactccagcctgggcaacaagagtgaaactccggcagggtgtggtggcttacgcctgtaatcccagcacttcgggaggctgaggcaggccgatcacctgaggtcaggagtttgagaccaacctaacatggtgaaaccccgtctctactaaaaatacaagaattagctgggtgtagtggtgggcgcctgtaatcccagctacttgggaggctgagacagaagaattgcttgaacccaggaggtggaggttgcagtgagctgagatcatgccattgcacaccacgccgggcaacagagcgagattccgtctcaaaaaaaaaaaaaaagagtgaaactctatctcaaaaaaaaaaaaaagtcctaatggaaaatccataaaaagctaccaaaactaataaataaatatagcagggttgcaggttacagggcaatatagttatccctctatctgtaggggcttggttctgggactcctcacacaccaaacccacagatgtctaagtcccatatataagacggtatagtatttggatttaacctacacatatcctcccatatagtttaaattatctctagattacttacattacccccatacaatgaaaatgctaatgtacatgcaagtatgtatgtaagtacttgtactatattgtttagggaatcactggacatataggccttcaagactgataccagcagccactgttaagattctggtcaggcctgcccctgtttggggtctcagttgatctcattgccttcccacccagccaagggcacctgcatttctcttggctccctggccatttggaaggcctagttcagcctggcacatttgtatcctggcccactgatgctggtacccctgggaaggtcctgctctgaaaaacacggagattttagttgctactgaagatttgagagataaagacagggagacctgtctgtagacctgtgtccctccaagtgggattgagactttgggccccccatttcaggacagcacctcctggcctgttgactgaatagatccctgaaggaggtgtacttgcattaatggagtgggggtgggagcagtaccacagatccgcactaacaatcacacagttctctctagaataataatatagaacaagtgaaatagaacaattgcagaaagagctaacctttgttgagctcttactgtgtgcccagcactttcctcaactctacatttcccataatacacagagtactaggtaggccaggcttggtggctcacgcctgtaatcccagcactttaggaggccaaggggggtggatcacctgaggtcgggagttcaagaccagcctgaccaacatggtgaaaccccgtctctactagaagtacaaaattagccaggtgtggtggcacatgcttgtagtcctagctactcagcaggctgaggcaggagaatcatttgaatccgggaggaggttgcagtaagcggagatagtgccactgtactccagcctgggcaataagagctgagactccgtctcaaaataaaataaaataaaataaaataaaataaaataaaataaaaaaagaaaagagcctgccattaaaggagctgtttggtaggggatgttttgtcagtgcaaacaacagaaaagtgggctgggcacagtggttcatgcctgtaatcccagcactttgggaggccaaggcgggcggatcacctgaagttgggagttcaagaccagcctgaccaatatggagaaaccccgtctctactaaaaatacaaaattagccgggcgcagtggcgcatgcctgtaatcccagctactcgggaggctgaggcaggagaatcgcttgaacctgggaggcagaggttgcggtgagccgagatcgcaccattgcactccagcctggacgagagcaaaactctgtctcaaaaaaaaaaaaaaacagaaaagtgtaacaaacacttacagtaggcatgtttcttagcaaatctgatgacaaatttggcataaagaaagagagcatccctgaaaaaaaaaaaaagaaaaagaaagagagcatcctgcctgggcaacatagtgaaaccctgcctctacaaaaaaactcaaaaattggccgggtgcagtggctcacacctgtaatcccagcactttgggagtcggaggcgggaggatcacctgaggtcaggagttcgaaaccagcctggccaacatggcaaaaccccatctctactaaaaatacaaaaaattaatcaggcgcattggtgggcgcctgtaatcccagctactcaggaagttgaggcaagaggatcgcttgaatctgggaggtggaggttacagtgagtcgagatcacaccactgcactctagcctgggtgacagggcgagactccgtctccaaaaaaaaaaagaaaaagaaaaagactaaaaaattagccaggcaggcctctgtggtcccagctacttgggaggctgaggcaggagaatcactgagcccaggagtccgaggctgtagtgagccatgattgcaccactgtaccctagcttgggcaacaaagcaagaccctgcctcaaaagaaaaaagaaagaaagaaagaacatggcgggccaggcacagtggctcacacctgtaatcccagcgctttgagaggccgaggcaggtggatcacaaggtcaggagttccacaccagcctggccaacatggtgaaaccctgtctctactaaaaatacaaaaaatcagccaggcatggtggcaggggcctgtaatcccagctactcgggaggctgaggcaggagaattgcttgaaaccagaaggcagaggttgcagtgagcctagactgcaccactgcactccagcctgggcgaaaagagccaaactccatctcaaaaaacaaacaaaaaaacaaaacaaaagaaaacatggcaaagcctttgaaagcttgtctgggagaaggtgcgatgatagttgcataacttcgtgcaagatgctggtccacacaggggctgccccttgctctttctcgctctcttaacctctcatataacaggcttgtgtgttattcacatttattgagcccaagcaggtgcaaggcattgtgatctaatactttggtcagcaagacaacaagatagatcactgccctgcccttaggaagtgtatatgctattagaggaaacagataaaataaacaaggaaaagtatcagacaatgtaagtgctatgagaatgcaaatgaggtgatgtgaattaaaataggatgacttaaagtctgcacgggaaggagcctacccccatgttcctggctagccaaggaaccaccagttgattagcagagaagggcagccagtctagctagagcttttggggaagagggagtggttgttaagagatgagattaaagaagccgagacgggccattcgtgaggggtttgtaatgcagggctgaggagtgtccgaagagaatgggcaggtgagcggtgagacagttgttcttccagaagctttgcagtgaaaggaatcaaagaaatggagccgtgtatcaggtggggaagggtgggggccaagggggtgtccttccccatacagagattgcaggctgagaatgactatatccttgttaacaggaggtgggagcagggcacggtagctcacacctgtaatcttggcactttaggaggctgaggcgggccgatcacctgaagtaaggagttcgagaccagcctggccaacatgcaaagccctgtctctactaaaaatacaaaaattagctgggtgtggtggtactcgcctgtaatcccagctactcgggagactgaggcaggagaatggcttgaacccggaaggtagaggttgcagtgagctgagatcatgccactgtgctccagcctaggtgacagagagagactccatctcaaaaaaaaaaaaaaaatacaggaagggagttgggaatagggtgcacatttaggaagtcttggggatttagtggtgggaaggttggaagtccctctctgattgtcttttcctcaaagaagtgcatggctggtgaggggtggggcaggagtgcttgggttgtggtgaaacattggaagagagaatgtgaagcagccattcttttcctgctccacaggaagccgagctgtctcagacactggcatggtgttgggggagggggttccttctctgcaggcccaggtgacccagggttggaagtgtctcatgctggatccccacttttcctcttgcagcagccagactgccttccgggtcactgccatggaggagccgcagtcagatcctagcgtcgagccccctctgagtcaggaaacattttcagacctatggaaactgtgagtggatccattggaagggcaggcccaccacccccaccccaaccccagccccctagcagagacctgtgggaagcgaaaattccatgggactgactttctgctcttgtctttcagacttcctgaaaacaacgttctggtaaggacaagggttgggctggggacctggagggctggggacctggagggctggggggctggggggctgaggacctggtcctctgactgctcttttcacccatctacagtcccccttgccgtcccaagcaatggatgatttgatgctgtccccggacgatattgaacaatggttcactgaagacccaggtccagatgaagctcccagaatgccagaggctgctccccccgtggcccctgcaccagcagctcctacaccggcggcccctgcaccagccccctcctggcccctgtcatcttctgtcccttcccagaaaacctaccagggcagctacggtttccgtctgggcttcttgcattctgggacagccaagtctgtgacttgcacggtcagttgccctgaggggctggcttccatgagacttcaatgcctggccgtatccccctgcatttcttttgtttggaactttgggattcctcttcaccctttggcttcctgtcagtgtttttttatagtttacccacttaatgtgtgatctctgactcctgtcccaaagttgaatattccccccttgaatttgggcttttatccatcccatcacaccctcagcatctctcctggggatgcagaacttttctttttcttcatccacgtgtattccttggcttttgaaaataagctcctgaccaggcttggtggctcacacctgcaatcccagcactctcaaagaggccaaggcaggcagatcacctgagcccaggagttcaagaccagcctgggtaacatgatgaaacctcgtctctacaaaaaaatacaaaaaattagccaggcatggtggtgcacacctatagtcccagccacttaggaggctgaggtgggaagatcacttgaggccaggagatggaggctgcagtgagctgtgatcacaccactgtgctccagcctgagtgacagagcaagaccctatctcaaaaaaaaaaaaaaaaaagaaaagctcctgaggtgtagacgccaactctctctagctcgctagtgggttgcaggaggtgcttacgcatgtttgtttctttgctgccgtcttccagttgctttatctgttcacttgtgccctgactttcaactctgtctccttcctcttcctacagtactcccctgccctcaacaagatgttttgccaactggccaagacctgccctgtgcagctgtgggttgattccacacccccgcccggcacccgcgtccgcgccatggccatctacaagcagtcacagcacatgacggaggttgtgaggcgctgcccccaccatgagcgctgctcagatagcgatggtgagcagctggggctggagagacgacagggctggttgcccagggtccccaggcctctgattcctcactgattgctcttaggtctggcccctcctcagcatcttatccgagtggaaggaaatttgcgtgtggagtatttggatgacagaaacacttttcgacatagtgtggtggtgccctatgagccgcctgaggtctggtttgcaactggggtctctgggaggaggggttaagggtggttgtcagtggccctccaggtgagcagtaggggggctttctcctgctgcttatttgacctccctataaccccatgagatgtgcaaagtaaatgggtttaactattgcacagttgaaaaaactgaagcttacagaggctaagggcctcccctgcttggctgggcgcagtggctcatgcctgtaatcccagcactttgggaggccaaggcaggcggatcacgaggttgggagatcgagaccatcctggctaacggtgaaaccccgtctctactgaaaaatacaaaaaaaaattagccgggcgtggtgctgggcacctgtagtcccagctactcgggaggctgaggaaggagaatggcgtgaacctgggcggtggagcttgcagtgagctgagatcacgccactgcactccagcctgggcgacagagcgagattccatctcaaaaaaaaaaaaaaaaggcctcccctgcttgccacaggtctccccaaggcgcactggcctcatcttgggcctgtgttatctcctaggttggctctgactgtaccaccatccactacaactacatgtgtaacagttcctgcatgggcggcatgaaccggaggcccatcctcaccatcatcacactggaagactccaggtcaggagccacttgccaccctgcacactggcctgctgtgccccagcctctgcttgcctctgacccctgggcccacctcttaccgatttcttccatactactacccatccacctctcatcacatccccggcggggaatctccttactgctcccactcagttttcttttctctggctttgggacctcttaacctgtggcttctcctccacctacctggagctggagcttaggctccagaaaggacaagggtggttgggagtagatggagcctggttttttaaatgggacaggtaggacctgatttccttactgcctcttgcttctcttttcctatcctgagtagtggtaatctactgggacggaacagctttgaggtgcgtgtttgtgcctgtcctgggagagaccggcgcacagaggaagagaatctccgcaagaaaggggagcctcaccacgagctgcccccagggagcactaagcgaggtaagcaagcaggacaagaagcggtggaggagaccaagggtgcagttatgcctcagattcacttttatcacctttccttgcctctttcctagcactgcccaacaacaccagctcctctccccagccaaagaagaaaccactggatggagaatatttcacccttcaggtactaagtcttgggacctcttatcaagtggaaagtttccagtctaacactcaaaatgccgttttcttcttgactgttttacctgcaattggggcatttgccatcagggggcagtgatgcctcaaagacaatggctcctggttgtagctaactaacttcagaacaccaacttataccataatatatattttaaaggaccagaccagctttcaaaaagaaaattgttaaagagagcatgaaaatggttctatgactttgcctgatacagatgctacttgacttacgatggtgttacttcctgataaactcgtcgtaagttgaaaatattgtaagttgaaaatggatttaatacacctaatctaaggaacatcatagcttagcctagcctgctttttttttttttttttttggagacagagtctcactctgtcacccaggctggagtgcagtggcgggatctcggctcactgcaacctccgccttctgggttcaagcgattctcctgcctcagcccactgagtagctgggattacaggcacctgccccgacgcccagctaattttttgttatttatttatttttttttttagtagagatgaggtttcaccatgttggccaggctagtctcgaactcctgaccttgtgatctgcctgccttggcctcccaaagtgctgggattacaggcgtgagccaccgcacccggcctgcctagcctacttttattttatttttaatggagacagcatcttgctctgttgcccaggctggattacagtgatgtgatcatagctcattataccctcctgggctcaagcaatccccctaactctgcctccccagtagctaggaccacaggcatacaccaccatacccagctaatttttaaaattttttgtagatagatagagtctcactatgttgcccaggctggtctctagcctacttttttgagacaaggtcttgctctgtcacccaggctggatagagtgcagtagtgcagtcacagctcactgcagcctccacctcccaggctccatccatcctcccagctcagcctcccaagttgcttcaactacaggcctgcaccaccatgcctggctaatttttatttatttatttttattttattttattttatttttttgagactcagtctcactctgtcgcccaggctggagtgcagtggcatgatctcggctcactgcaacctctgcctcctgggttcaagtgattctcctgcctcagcctcccgaatagctaggactacaagcgcctgctaccacgcccagctaatttttgtatttttagtagagacagggtttcaccatgttggccaggctggtctcgaacttctgaccatgtgatccgcccgcctcggcctcccaaagtgctgggattacaggtgtgagccaccacgcccggctaatttttatttatttatttaaagacagagtctcactctgtcactcaggctagagtgcagtggcaccatctcagctcactgcagccttgacctccctgggctccggtgatttcaccctcccaagtagctaggactacaggcacatgccacgacacccagctaattttttattttctgtgaagtcaaggtcttgctacgttgcccatgctggtatcaaacccctgggctcaatcaatccttccacctcagcctccccaagtattggggttacaggcatgagctaccacactcagccctagcctacttgaaacgtgttcagagcatttaagttaccctacagttgggcaaagtcatctaacacaaagccctttttatagtaataaaatgttgtatatctcatgtgatttattgaatattgttactgaaagtgagaaacagcatggttgcatgaaaggaggcacagtcgagccaggcacagcctgggcgcagagcgagactcaaaaaaagaaaaggccaggcgcactggctcacgcctgtaatcccagcatttcgggaggctgaggcgggtggatcacctgaggtcaggagttcaagaccagcctagccaacatggtgaaaccccgtctctactaaaatacaaaaattaaccgggcgtgatggcaggtgcctgtaatcccagctacttgggaggctgaggcaggagaatcgcttgaaccaggaggcggaggttgcagggagccaagatggcgccactgcactccagcctgggcgatagagtgagactccgtctcagaaaaaaaagaaaagaaacgaggcacagtcgcatgcacatgtagtcccagttacttgagaggctaaggcaggaggatctcttgagcccaagagtttgagtccagcctgaacaacatagcaagacatcatctctaaaatttaaaaaagggccgggcacagtggctcacacctgtaatcccagcactttgggaggtggaggtgggtagatcacctgacgtcaggagttggaaaccagcctggctaacatggtgaagccccatctctactaaaaacacaaaaattagccaggtgtggtagcacacgcctgtagtcccagctactcgggaggctgaggcacaagaatcacttgaaccccagaggcggagattgcaatcagccaagattgcaccattgcactcccgcctgggcaacagagtgagaccccatctcaaaataaataaataaatatttttaaaagtcagctgtataggtacttgaagtgcagtttctactaaatgcatgttgcttttgtaccgtcataaagtcaaacaattgtaacttgaaccatcttttaactcaggtactgtgtatatacttacttctccccctcctctgttgctgcagatccgtgggcgtgagcgcttcgagatgttccgagagctgaatgaggccttggaactcaaggatgcccaggctgggaaggagccaggggggagcagggctcactccaggtgagtgacctcagccccttcctggccctactcccctgccttcctaggttggaaagccataggattccattctcatcctgccttcatggtcaaaggcagctgaccccatctcattgggtcccagccctgcacagacatttttttagtcttcctccggttgaatcctataaccacattcttgcctcagtgtatccacagaacatccaaacccagggacgagtgtggatacttctttgccattctccgcaactcccagcccagagctggagggtctcaaggaggggcctaataattgtgtaatactgaatacagccagagtttcaggtcatatactcagccctgccatgcaccggcaggtcctaggtgacccccgtcaaactcagtttccttatatataaaatggggtaagggggccgggcgcagtggctcacgaatcccacactctgggaggccaaggcgagtggatcacctgaggtcgggagtttgagcccagcctgaccaacatggagaaaccccatctctactaaaaatacaaaagtagccgggcgtggtgatgcatgcctgtaatcccagctacctactcgggaggctgaggcaggagaatcgcttgaacccgggaggcagaggttgcggtgagctgagatctcaccattacactccagcctgggcaacaagagtgaaactccgtctcaaaaaagataaataaagtaaaatggggtaagggaagattacgagactaatacacactaatactctgaggtgctcagtaaacatatttgcatggggtgtggccaccatcttgatttgaattcccgttgtcccagccttaggcccttcaaagcattggtcagggaaaaggggcacagaccctctcactcatgtgatgtcatctctcctccctgcttctgtctcctacagccacctgaagtccaaaaagggtcagtctacctcccgccataaaaaactcatgttcaagacagaagggcctgactcagactgacattctccacttcttgttccccactgacagcctcccacccccatctctccctcccctgccattttgggttttgggtctttgaacccttgcttgcaataggtgtgcgtcagaagcacccaggacttccatttgctttgtcccggggctccactgaacaagttggcctgcactggtgttttgttgtggggaggaggatggggagtaggacataccagcttagattttaaggtttttactgtgagggatgtttgggagatgtaagaaatgttcttgcagttaagggttagtttacaatcagccacattctaggtaggggcccacttcaccgtactaaccagggaagctgtccctcactgttgaattttctctaacttcaaggcccatatctgtgaaatgctggcatttgcacctacctcacagagtgcattgtgagggttaatgaaataatgtacatctggccttgaaaccaccttttattacatggggtctagaacttgacccccttgagggtgcttgttccctctccctgttggtcggtgggttggtagtttctacagttgggcagctggttaggtagagggagttgtcaagtctctgctggcccagccaaaccctgtctgacaacctcttggtgaaccttagtacctaaaaggaaatctcaccccatcccacaccctggaggatttcatctcttgtatatgatgatctggatccaccaagacttgttttatgctcagggtcaatttcttttttcttttttttttttttttttctttttctttgagactgggtctcgctttgttgcccaggctggagtggagtggcgtgatcttggcttactgcagcctttgcctccccggctcgagcagtcctgcctcagcctccggagtagctgggaccacaggttcatgccaccatggccagccaacttttgcatgttttgtagagatggggtctcacagtgttgcccaggctggtctcaaactcctgggctcaggcgatccacctgtctcagcctcccagagtgctgggattacaattgtgagccaccacgtccagctggaagggtcaacatcttttacattctgcaagcacatctgcattttcaccccacccttcccctccttctccctttttatatcccatttttatatcgatctcttattttacaataaaactttgctgccacctgtgtgtctgaggggtg";
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
            jTextArea2.setText(">Gen en estado normal\n"+conf);
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
        jTextArea2.setText(">Gen en estado normal");
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
        String strNormal="acttgtcatggcgactgtccagctttgtgccaggagcctcgcaggggttgatgggattggggttttcccctcccatgtgctcaagactggcgctaaaagttttgagcttctcaaaagtctagagccaccgtccagggagcaggtagctgctgggctccggggacactttgcgttcgggctgggagcgtgctttccacgacggtgacacgcttccctggattgggtaagctcctgactgaacttgatgagtcctctctgagtcacgggctctcggctccgtgtattttcagctcgggaaaatcgctggggctgggggtggggcagtggggacttagcgagtttgggggtgagtgggatggaagcttggctagagggatcatcataggagttgcattgttgggagacctgggtgtagatgatggggatgttaggaccatccgaactcaaagttgaacgcctaggcagaggagtggagctttggggaaccttgagccggcctaaagcgtacttctttgcacatccacccggtgctgggcgtagggaatccctgaaataaaagatgcacaaagcattgaggtctgagacttttggatctcgaaacattgagaactcatagctgtatattttagagcccatggcatcctagtgaaaactggggctccattccgaaatgatcatttgggggtgatccggggagcccaagctgctaaggtcccacaacttccggacctttgtccttcctggagcgatctttccaggcagcccccggctccgctagatggagaaaatccaattgaaggctgtcagtcgtggaagtgagaagtgctaaaccaggggtttgcccgccaggccgaggaggaccgtcgcaatctgagaggcccggcagccctgttattgtttggctccacatttacatttctgcctcttgcagcagcatttccggtttctttttgccggagcagctcactattcacccgatgagaggggaggagagagagagaaaatgtcctttaggccggttcctcttacttggcagagggaggctgctattctccgcctgcatttctttttctggattacttagttatggcctttgcaaaggcaggggtatttgttttgatgcaaacctcaatccctccccttctttgaatggtgtgccccaccccgcgggtcgcctgcaacctaggcggacgctaccatggcgtgagacagggagggaaagaagtgtgcagaaggcaagcccggaggtattttcaagaatgagtatatctcatcttcccggaggaaaaaaaaaaagaatgggtacgtctgagaatcaaattttgaaagagtgcaatgatgggtcgtttgataatttgtcggaaaaacaatctacctgttatctagctttgggctaggccattccagttccagacgcaggctgaacgtcgtgaagcggaaggggcgggcccgcaggcgtccgtgtggtcctccgtgcagccctccggcccgagccggttcttcctggtaggaggcggaactcgaattcatttctcccgctgccccatctcttagctcgcggttgtttcattccgcagtttcttcccatgcacctgccgcgtaccggccactttgtgccgtacttacgtcatctttttcctaaatcgaggtggcatttacacacagcgccagtgcacacagcaagtgcacaggaagatgagttttggcccctaaccgctccgtgatgcctaccaagtcacagacccttttcatcgtcccagaaacgtttcatcacgtctcttcccagtcgattcccgaccccacctttattttgatctccataaccattttgcctgttggagaacttcatatagaatggaatcaggctgggcgctgtggctcacgcctgcactttgggaggccgaggcgggcggattacttgaggataggagttccagaccagcgtggccaacgtggtgaatccccgtctctactaaaaaatacaaaaattagctgggcgtggtgggtgcctgtaatcccagctattcgggagggtgaggcaggagaatcgcttgaacccgggaggcagaggttgcagtgagccaagatcgtgccactacactccagcctgggcgacaagaacgaaactccgtctcaaaaaaaaggggggaatcatacattatgtgctcatttttgtcgggcttctgtccttcaatgtactgtctgacattcgttcatgttgtatatatcagtattttgctccttttcatttagtatagtccatcgattgtatatccgtccttttgatggccttttgagttgtttcccatttgcggttatgaaataaagctgctataaacattcttgtacaattctttttgtgatcatatgttttcgtgtttcttggagaaatacttaggaggggaattgcgagtttggaagtaaaaagtagctgtattttgaactttttcagaagctctgagttttccagagcggttgtaccattttacactccaactagcaaggtatgggagttattatggttgtgccacagccttccggacattaggtattgtcagtctttctaatgtggtatatccttgtggttgtaatttacagttctctattgactaaggatgttcagcattttttcatgtgcctattggccattcgtattttgtttgtaaagtagctcttcgagtcttttacctgttattttggttttttgtttgtttttattgttcagttgtgggactgctttatacattctggatacaagtcctttatcagatccatgtgtcgtgaatgttttcttctgatctgttgcttgcctatttgtttgctttacagagtttacagtatcttaagaggagtggatttatcttttttatgttcagtatttgccttgtcctgtttaggacatctttttttttttttttaaccccagggtcatgaagatattatcttacattttcttttaggacctttatggttgtaagttttacagtaaggtccttgagccattaattaattcttaaaattaattgtttatggtgtgaggtgtaggagtcagtctctggtatctttcctgtatggaaatccagttattctgtctccacttgttgaaataggcttcctttctctactgaatgcttttaattttaattattttacagttggagtatagggctaccattttagtgctattttctttttttctttgttaatttttgagacagggactcacactgttgcccaggctagagtacaatggcacaatcaaggcttactgcagcctcgaacccctgggctcaagcagtcctctagcagcctcacgagtagctgggattactccaccacacccagctaactattttatttttttgtattgacaggatctcactatgttgcccaggctggtctcaaactgctggcctcaagctttcatcccatctcggcctcccaaagtgctgggattacaggtgtgagccaccatgcctgacctcttagtgctattttctatttatctcctctgttctctgctctctttaaacgttggaggaagaaacagtacccatcttacacaaactcttcagaaaacagaggaacagactgggcgcggtggctcatacctgtaatctcagcactttggtacgctgaggcaggggatcatttgaggtcgggagttcgagaccagcctggccaacacggcgaaaccccatctctactaaaaatacaaaaagtagctaggcgtggtgacacatacctgtaatgccagttactcaggaggctgaggcacaagaatcccttgaacctgggaagcggaggttgcagtgagccgagattgcgccactgcactccagcctgggcaacagagtgagaccctgtctcagaaaaaaaaagaaagaaagaaaaaatagaggaatatttcccaacttgttttcgaagccagcataatcctggtaccaaaaccaaacaaggacattataagaaaagaaaatatagaccaatattcctgttagcatagacatgcaacagctaaccaattttagcaaaccaaacctggtaatatagaaaaaaggataaataggccagtcgcggtggctcacgcctgtaatcccagcactttgggaggctgaggcaggcagatcacttgaggtcaggagtttgagaccagcctgaccaacatggtgaaaccccgtttctaataaaaatacaaaaatcaggctgggcacggtggctcacgcctgtaatcccagcactttgggaggccgaggtgggcagatcacgaggtcaggagttcaagaccagcctgaccaatgtggtgaaacgccatctctactaaaaatacaaaaatcagccggtgtggtggcacctgcctgtaatcccagctactcaggaggctgaggcagaattgcttgaacccgggaggcagaggttgcagtgagccaagatcgtgccactgcactccagcctgggcgacagagcaagacttcatctcaaaaaaaaaaaaaaattagctgggcatggtggtgggcacctgaaatcccagctactcgggagtctgaggcaggagaatcgcttgaacccaggaggcagaagttgcactgagctgggatcacaccattgcactccagcctgggcaacagagtgagactccatctcaaaaaaagaaaaagaaaaaggataaatacattctaaccaaataatgtttatctcatgattgtagctgattcaacattcaaaaattggcctggtgcagtagctcaggcctgtaatcccaacattttaggaggctgaggcaggaagatctcttgagcccaggatttcaagaccagcctgggcaacatagtcagactggtctttactggggggaaaaaaatcagtctgtgtaattcaccacattaacaaagggaaacataaaaaccctatgatcatttcaacagatgtagcaaaagcagttaatgatattcaacacatatgcatgattacaaaccaaccaacctcctagcaaactagggaaaggaaacttaacctagtttgataacagggcgtccacagtcggagttccactagcagcatacataatggtagaaaactcagtgctgccgggcgcggtggctcacgcctgtaatgccagcactttgggaggcctaggcgggcggatcacgaggtcaggagatcgagactgtcctgactagcatgctgaaaccccgtctctactaaaaatacaaaaacaaaaaattagccgggcatggtggcgggcgcctatagtcccagctactcgggaggctgaggcgagagaatggcgtgaacccgggaggcggagcttgcagagcctagatcgtgccactgcactccagcctgggtgacagagtgagacttcgtctcaaaaaaaaaaaaaaaaaaaaaagaaaagaaaactcaacgctttttcctctaagatcaggaactagaaaaggatttgactctcacaacgttgataccatactggaggttttaaccaggcaagaaaaagaaataatgagggccgggtgcggtggctcaggcctgtaatcccagcactttgggaagccgagacgggtggatcacgaggtcaggagatcgagaccatcctggctaacacggtgaaaccctgtctctactaaatatacaaaaaattagccgggcgtagtggcgggcgcctgtagtcccagctactcgggaggctgaggcaggagaatggcgtgaactcagggggcggagcttgcagtgagctgagatcgagccactgcactccagcctgggcgacagagcaagactgtgtctcaaaaaaaaaaaaagaaaaagaaataatgattagtggcccgatgtctcacgcctataatcccagcactttgggaggccgaggtgggcagatcacctgaggtctggagttggagaccagcctgacaaagatggtgaaacctcgtctctattaaaatattaaaaaaatagccaggcgttggccgggtacagtggctcatgcctgtaatcccagcactttgggaggccgaggtgggtggatcacctgaggtcaggagttcaacaccagcctggccaacatggtgaaaccccatctctactaaaaatacaaaaattagccgggcgtagtggcgggcgcctgtaatcccagctacttgggaggcttaggcaggagaatcgcttgaacctgggaggcggaggttgtagtgagccgagattgcaccattgcactccagcctgggtgacaaaagcaaaaactccgtctcaaaaaaaaaagaattagccaggggtagtggtgaacgcctgtagtcccagctactcaggaggcagaggcaggagaatcacttgaacccaggaggcagaggttgcagtgagccgagattgtcccattgcactccagcctaggcgacaagagcaaaattccatgtcaaaaaaaaaaaaaaaaaaggaaagaaaaaaaataacgattagaaaggaagaaataaaacacattcacagccagtatgattctatacatacatgtcctaatggggccaggcgtggtggctcatgcctgtaatcctagcacttttaggaggctgaggcaggtggcttccctgggaccagcctggccaacatggtgaaaccccaactctaataaaaatacaaaaaatcagccaggcgtggtgacgggcacctctaatcccagctactcaggaggctgaggcaggagaattgcttggacctgggaggcagaggttgcagtgagccgagatcgcgctattgcactccagcctgggcaacaagagtgaaactccggcagggtgtggtggcttacgcctgtaatcccagcacttcgggaggctgaggcaggccgatcacctgaggtcaggagtttgagaccaacctaacatggtgaaaccccgtctctactaaaaatacaagaattagctgggtgtagtggtgggcgcctgtaatcccagctacttgggaggctgagacagaagaattgcttgaacccaggaggtggaggttgcagtgagctgagatcatgccattgcacaccacgccgggcaacagagcgagattccgtctcaaaaaaaaaaaaaaagagtgaaactctatctcaaaaaaaaaaaaaagtcctaatggaaaatccataaaaagctaccaaaactaataaataaatatagcagggttgcaggttacagggcaatatagttatccctctatctgtaggggcttggttctgggactcctcacacaccaaacccacagatgtctaagtcccatatataagacggtatagtatttggatttaacctacacatatcctcccatatagtttaaattatctctagattacttacattacccccatacaatgaaaatgctaatgtacatgcaagtatgtatgtaagtacttgtactatattgtttagggaatcactggacatataggccttcaagactgataccagcagccactgttaagattctggtcaggcctgcccctgtttggggtctcagttgatctcattgccttcccacccagccaagggcacctgcatttctcttggctccctggccatttggaaggcctagttcagcctggcacatttgtatcctggcccactgatgctggtacccctgggaaggtcctgctctgaaaaacacggagattttagttgctactgaagatttgagagataaagacagggagacctgtctgtagacctgtgtccctccaagtgggattgagactttgggccccccatttcaggacagcacctcctggcctgttgactgaatagatccctgaaggaggtgtacttgcattaatggagtgggggtgggagcagtaccacagatccgcactaacaatcacacagttctctctagaataataatatagaacaagtgaaatagaacaattgcagaaagagctaacctttgttgagctcttactgtgtgcccagcactttcctcaactctacatttcccataatacacagagtactaggtaggccaggcttggtggctcacgcctgtaatcccagcactttaggaggccaaggggggtggatcacctgaggtcgggagttcaagaccagcctgaccaacatggtgaaaccccgtctctactagaagtacaaaattagccaggtgtggtggcacatgcttgtagtcctagctactcagcaggctgaggcaggagaatcatttgaatccgggaggaggttgcagtaagcggagatagtgccactgtactccagcctgggcaataagagctgagactccgtctcaaaataaaataaaataaaataaaataaaataaaataaaataaaaaaagaaaagagcctgccattaaaggagctgtttggtaggggatgttttgtcagtgcaaacaacagaaaagtgggctgggcacagtggttcatgcctgtaatcccagcactttgggaggccaaggcgggcggatcacctgaagttgggagttcaagaccagcctgaccaatatggagaaaccccgtctctactaaaaatacaaaattagccgggcgcagtggcgcatgcctgtaatcccagctactcgggaggctgaggcaggagaatcgcttgaacctgggaggcagaggttgcggtgagccgagatcgcaccattgcactccagcctggacgagagcaaaactctgtctcaaaaaaaaaaaaaaacagaaaagtgtaacaaacacttacagtaggcatgtttcttagcaaatctgatgacaaatttggcataaagaaagagagcatccctgaaaaaaaaaaaaagaaaaagaaagagagcatcctgcctgggcaacatagtgaaaccctgcctctacaaaaaaactcaaaaattggccgggtgcagtggctcacacctgtaatcccagcactttgggagtcggaggcgggaggatcacctgaggtcaggagttcgaaaccagcctggccaacatggcaaaaccccatctctactaaaaatacaaaaaattaatcaggcgcattggtgggcgcctgtaatcccagctactcaggaagttgaggcaagaggatcgcttgaatctgggaggtggaggttacagtgagtcgagatcacaccactgcactctagcctgggtgacagggcgagactccgtctccaaaaaaaaaaagaaaaagaaaaagactaaaaaattagccaggcaggcctctgtggtcccagctacttgggaggctgaggcaggagaatcactgagcccaggagtccgaggctgtagtgagccatgattgcaccactgtaccctagcttgggcaacaaagcaagaccctgcctcaaaagaaaaaagaaagaaagaaagaacatggcgggccaggcacagtggctcacacctgtaatcccagcgctttgagaggccgaggcaggtggatcacaaggtcaggagttccacaccagcctggccaacatggtgaaaccctgtctctactaaaaatacaaaaaatcagccaggcatggtggcaggggcctgtaatcccagctactcgggaggctgaggcaggagaattgcttgaaaccagaaggcagaggttgcagtgagcctagactgcaccactgcactccagcctgggcgaaaagagccaaactccatctcaaaaaacaaacaaaaaaacaaaacaaaagaaaacatggcaaagcctttgaaagcttgtctgggagaaggtgcgatgatagttgcataacttcgtgcaagatgctggtccacacaggggctgccccttgctctttctcgctctcttaacctctcatataacaggcttgtgtgttattcacatttattgagcccaagcaggtgcaaggcattgtgatctaatactttggtcagcaagacaacaagatagatcactgccctgcccttaggaagtgtatatgctattagaggaaacagataaaataaacaaggaaaagtatcagacaatgtaagtgctatgagaatgcaaatgaggtgatgtgaattaaaataggatgacttaaagtctgcacgggaaggagcctacccccatgttcctggctagccaaggaaccaccagttgattagcagagaagggcagccagtctagctagagcttttggggaagagggagtggttgttaagagatgagattaaagaagccgagacgggccattcgtgaggggtttgtaatgcagggctgaggagtgtccgaagagaatgggcaggtgagcggtgagacagttgttcttccagaagctttgcagtgaaaggaatcaaagaaatggagccgtgtatcaggtggggaagggtgggggccaagggggtgtccttccccatacagagattgcaggctgagaatgactatatccttgttaacaggaggtgggagcagggcacggtagctcacacctgtaatcttggcactttaggaggctgaggcgggccgatcacctgaagtaaggagttcgagaccagcctggccaacatgcaaagccctgtctctactaaaaatacaaaaattagctgggtgtggtggtactcgcctgtaatcccagctactcgggagactgaggcaggagaatggcttgaacccggaaggtagaggttgcagtgagctgagatcatgccactgtgctccagcctaggtgacagagagagactccatctcaaaaaaaaaaaaaaaatacaggaagggagttgggaatagggtgcacatttaggaagtcttggggatttagtggtgggaaggttggaagtccctctctgattgtcttttcctcaaagaagtgcatggctggtgaggggtggggcaggagtgcttgggttgtggtgaaacattggaagagagaatgtgaagcagccattcttttcctgctccacaggaagccgagctgtctcagacactggcatggtgttgggggagggggttccttctctgcaggcccaggtgacccagggttggaagtgtctcatgctggatccccacttttcctcttgcagcagccagactgccttccgggtcactgccatggaggagccgcagtcagatcctagcgtcgagccccctctgagtcaggaaacattttcagacctatggaaactgtgagtggatccattggaagggcaggcccaccacccccaccccaaccccagccccctagcagagacctgtgggaagcgaaaattccatgggactgactttctgctcttgtctttcagacttcctgaaaacaacgttctggtaaggacaagggttgggctggggacctggagggctggggacctggagggctggggggctggggggctgaggacctggtcctctgactgctcttttcacccatctacagtcccccttgccgtcccaagcaatggatgatttgatgctgtccccggacgatattgaacaatggttcactgaagacccaggtccagatgaagctcccagaatgccagaggctgctccccccgtggcccctgcaccagcagctcctacaccggcggcccctgcaccagccccctcctggcccctgtcatcttctgtcccttcccagaaaacctaccagggcagctacggtttccgtctgggcttcttgcattctgggacagccaagtctgtgacttgcacggtcagttgccctgaggggctggcttccatgagacttcaatgcctggccgtatccccctgcatttcttttgtttggaactttgggattcctcttcaccctttggcttcctgtcagtgtttttttatagtttacccacttaatgtgtgatctctgactcctgtcccaaagttgaatattccccccttgaatttgggcttttatccatcccatcacaccctcagcatctctcctggggatgcagaacttttctttttcttcatccacgtgtattccttggcttttgaaaataagctcctgaccaggcttggtggctcacacctgcaatcccagcactctcaaagaggccaaggcaggcagatcacctgagcccaggagttcaagaccagcctgggtaacatgatgaaacctcgtctctacaaaaaaatacaaaaaattagccaggcatggtggtgcacacctatagtcccagccacttaggaggctgaggtgggaagatcacttgaggccaggagatggaggctgcagtgagctgtgatcacaccactgtgctccagcctgagtgacagagcaagaccctatctcaaaaaaaaaaaaaaaaaagaaaagctcctgaggtgtagacgccaactctctctagctcgctagtgggttgcaggaggtgcttacgcatgtttgtttctttgctgccgtcttccagttgctttatctgttcacttgtgccctgactttcaactctgtctccttcctcttcctacagtactcccctgccctcaacaagatgttttgccaactggccaagacctgccctgtgcagctgtgggttgattccacacccccgcccggcacccgcgtccgcgccatggccatctacaagcagtcacagcacatgacggaggttgtgaggcgctgcccccaccatgagcgctgctcagatagcgatggtgagcagctggggctggagagacgacagggctggttgcccagggtccccaggcctctgattcctcactgattgctcttaggtctggcccctcctcagcatcttatccgagtggaaggaaatttgcgtgtggagtatttggatgacagaaacacttttcgacatagtgtggtggtgccctatgagccgcctgaggtctggtttgcaactggggtctctgggaggaggggttaagggtggttgtcagtggccctccaggtgagcagtaggggggctttctcctgctgcttatttgacctccctataaccccatgagatgtgcaaagtaaatgggtttaactattgcacagttgaaaaaactgaagcttacagaggctaagggcctcccctgcttggctgggcgcagtggctcatgcctgtaatcccagcactttgggaggccaaggcaggcggatcacgaggttgggagatcgagaccatcctggctaacggtgaaaccccgtctctactgaaaaatacaaaaaaaaattagccgggcgtggtgctgggcacctgtagtcccagctactcgggaggctgaggaaggagaatggcgtgaacctgggcggtggagcttgcagtgagctgagatcacgccactgcactccagcctgggcgacagagcgagattccatctcaaaaaaaaaaaaaaaaggcctcccctgcttgccacaggtctccccaaggcgcactggcctcatcttgggcctgtgttatctcctaggttggctctgactgtaccaccatccactacaactacatgtgtaacagttcctgcatgggcggcatgaaccggaggcccatcctcaccatcatcacactggaagactccaggtcaggagccacttgccaccctgcacactggcctgctgtgccccagcctctgcttgcctctgacccctgggcccacctcttaccgatttcttccatactactacccatccacctctcatcacatccccggcggggaatctccttactgctcccactcagttttcttttctctggctttgggacctcttaacctgtggcttctcctccacctacctggagctggagcttaggctccagaaaggacaagggtggttgggagtagatggagcctggttttttaaatgggacaggtaggacctgatttccttactgcctcttgcttctcttttcctatcctgagtagtggtaatctactgggacggaacagctttgaggtgcgtgtttgtgcctgtcctgggagagaccggcgcacagaggaagagaatctccgcaagaaaggggagcctcaccacgagctgcccccagggagcactaagcgaggtaagcaagcaggacaagaagcggtggaggagaccaagggtgcagttatgcctcagattcacttttatcacctttccttgcctctttcctagcactgcccaacaacaccagctcctctccccagccaaagaagaaaccactggatggagaatatttcacccttcaggtactaagtcttgggacctcttatcaagtggaaagtttccagtctaacactcaaaatgccgttttcttcttgactgttttacctgcaattggggcatttgccatcagggggcagtgatgcctcaaagacaatggctcctggttgtagctaactaacttcagaacaccaacttataccataatatatattttaaaggaccagaccagctttcaaaaagaaaattgttaaagagagcatgaaaatggttctatgactttgcctgatacagatgctacttgacttacgatggtgttacttcctgataaactcgtcgtaagttgaaaatattgtaagttgaaaatggatttaatacacctaatctaaggaacatcatagcttagcctagcctgctttttttttttttttttttggagacagagtctcactctgtcacccaggctggagtgcagtggcgggatctcggctcactgcaacctccgccttctgggttcaagcgattctcctgcctcagcccactgagtagctgggattacaggcacctgccccgacgcccagctaattttttgttatttatttatttttttttttagtagagatgaggtttcaccatgttggccaggctagtctcgaactcctgaccttgtgatctgcctgccttggcctcccaaagtgctgggattacaggcgtgagccaccgcacccggcctgcctagcctacttttattttatttttaatggagacagcatcttgctctgttgcccaggctggattacagtgatgtgatcatagctcattataccctcctgggctcaagcaatccccctaactctgcctccccagtagctaggaccacaggcatacaccaccatacccagctaatttttaaaattttttgtagatagatagagtctcactatgttgcccaggctggtctctagcctacttttttgagacaaggtcttgctctgtcacccaggctggatagagtgcagtagtgcagtcacagctcactgcagcctccacctcccaggctccatccatcctcccagctcagcctcccaagttgcttcaactacaggcctgcaccaccatgcctggctaatttttatttatttatttttattttattttattttatttttttgagactcagtctcactctgtcgcccaggctggagtgcagtggcatgatctcggctcactgcaacctctgcctcctgggttcaagtgattctcctgcctcagcctcccgaatagctaggactacaagcgcctgctaccacgcccagctaatttttgtatttttagtagagacagggtttcaccatgttggccaggctggtctcgaacttctgaccatgtgatccgcccgcctcggcctcccaaagtgctgggattacaggtgtgagccaccacgcccggctaatttttatttatttatttaaagacagagtctcactctgtcactcaggctagagtgcagtggcaccatctcagctcactgcagccttgacctccctgggctccggtgatttcaccctcccaagtagctaggactacaggcacatgccacgacacccagctaattttttattttctgtgaagtcaaggtcttgctacgttgcccatgctggtatcaaacccctgggctcaatcaatccttccacctcagcctccccaagtattggggttacaggcatgagctaccacactcagccctagcctacttgaaacgtgttcagagcatttaagttaccctacagttgggcaaagtcatctaacacaaagccctttttatagtaataaaatgttgtatatctcatgtgatttattgaatattgttactgaaagtgagaaacagcatggttgcatgaaaggaggcacagtcgagccaggcacagcctgggcgcagagcgagactcaaaaaaagaaaaggccaggcgcactggctcacgcctgtaatcccagcatttcgggaggctgaggcgggtggatcacctgaggtcaggagttcaagaccagcctagccaacatggtgaaaccccgtctctactaaaatacaaaaattaaccgggcgtgatggcaggtgcctgtaatcccagctacttgggaggctgaggcaggagaatcgcttgaaccaggaggcggaggttgcagggagccaagatggcgccactgcactccagcctgggcgatagagtgagactccgtctcagaaaaaaaagaaaagaaacgaggcacagtcgcatgcacatgtagtcccagttacttgagaggctaaggcaggaggatctcttgagcccaagagtttgagtccagcctgaacaacatagcaagacatcatctctaaaatttaaaaaagggccgggcacagtggctcacacctgtaatcccagcactttgggaggtggaggtgggtagatcacctgacgtcaggagttggaaaccagcctggctaacatggtgaagccccatctctactaaaaacacaaaaattagccaggtgtggtagcacacgcctgtagtcccagctactcgggaggctgaggcacaagaatcacttgaaccccagaggcggagattgcaatcagccaagattgcaccattgcactcccgcctgggcaacagagtgagaccccatctcaaaataaataaataaatatttttaaaagtcagctgtataggtacttgaagtgcagtttctactaaatgcatgttgcttttgtaccgtcataaagtcaaacaattgtaacttgaaccatcttttaactcaggtactgtgtatatacttacttctccccctcctctgttgctgcagatccgtgggcgtgagcgcttcgagatgttccgagagctgaatgaggccttggaactcaaggatgcccaggctgggaaggagccaggggggagcagggctcactccaggtgagtgacctcagccccttcctggccctactcccctgccttcctaggttggaaagccataggattccattctcatcctgccttcatggtcaaaggcagctgaccccatctcattgggtcccagccctgcacagacatttttttagtcttcctccggttgaatcctataaccacattcttgcctcagtgtatccacagaacatccaaacccagggacgagtgtggatacttctttgccattctccgcaactcccagcccagagctggagggtctcaaggaggggcctaataattgtgtaatactgaatacagccagagtttcaggtcatatactcagccctgccatgcaccggcaggtcctaggtgacccccgtcaaactcagtttccttatatataaaatggggtaagggggccgggcgcagtggctcacgaatcccacactctgggaggccaaggcgagtggatcacctgaggtcgggagtttgagcccagcctgaccaacatggagaaaccccatctctactaaaaatacaaaagtagccgggcgtggtgatgcatgcctgtaatcccagctacctactcgggaggctgaggcaggagaatcgcttgaacccgggaggcagaggttgcggtgagctgagatctcaccattacactccagcctgggcaacaagagtgaaactccgtctcaaaaaagataaataaagtaaaatggggtaagggaagattacgagactaatacacactaatactctgaggtgctcagtaaacatatttgcatggggtgtggccaccatcttgatttgaattcccgttgtcccagccttaggcccttcaaagcattggtcagggaaaaggggcacagaccctctcactcatgtgatgtcatctctcctccctgcttctgtctcctacagccacctgaagtccaaaaagggtcagtctacctcccgccataaaaaactcatgttcaagacagaagggcctgactcagactgacattctccacttcttgttccccactgacagcctcccacccccatctctccctcccctgccattttgggttttgggtctttgaacccttgcttgcaataggtgtgcgtcagaagcacccaggacttccatttgctttgtcccggggctccactgaacaagttggcctgcactggtgttttgttgtggggaggaggatggggagtaggacataccagcttagattttaaggtttttactgtgagggatgtttgggagatgtaagaaatgttcttgcagttaagggttagtttacaatcagccacattctaggtaggggcccacttcaccgtactaaccagggaagctgtccctcactgttgaattttctctaacttcaaggcccatatctgtgaaatgctggcatttgcacctacctcacagagtgcattgtgagggttaatgaaataatgtacatctggccttgaaaccaccttttattacatggggtctagaacttgacccccttgagggtgcttgttccctctccctgttggtcggtgggttggtagtttctacagttgggcagctggttaggtagagggagttgtcaagtctctgctggcccagccaaaccctgtctgacaacctcttggtgaaccttagtacctaaaaggaaatctcaccccatcccacaccctggaggatttcatctcttgtatatgatgatctggatccaccaagacttgttttatgctcagggtcaatttcttttttcttttttttttttttttttctttttctttgagactgggtctcgctttgttgcccaggctggagtggagtggcgtgatcttggcttactgcagcctttgcctccccggctcgagcagtcctgcctcagcctccggagtagctgggaccacaggttcatgccaccatggccagccaacttttgcatgttttgtagagatggggtctcacagtgttgcccaggctggtctcaaactcctgggctcaggcgatccacctgtctcagcctcccagagtgctgggattacaattgtgagccaccacgtccagctggaagggtcaacatcttttacattctgcaagcacatctgcattttcaccccacccttcccctccttctccctttttatatcccatttttatatcgatctcttattttacaataaaactttgctgccacctgtgtgtctgaggggtg";
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
