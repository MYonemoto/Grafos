/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.Scanner;

/**
 *
 * @author mateus
 */
public class Read {
    
    private static Scanner read;
    
    public static void Ler(){
    read = new Scanner(System.in);

        String file_input;
        
        file_input = read.nextLine();

    }
//    public List<String> abrirArquivo(String caminho) {
//        List<String> texto = new ArrayList<>();
//        File arq = new File(caminho);
//        if (arq.exists()) {
//            try {
//                //OpenFile
//                FileReader arquivo = new FileReader(caminho);
//                BufferedReader conteudoDoArquivo = new BufferedReader(arquivo);
//                String linha = conteudoDoArquivo.readLine();
//                while (linha != null) {
//                    texto.add(linha);
//                    linha = conteudoDoArquivo.readLine();
//                }
//                conteudoDoArquivo.close();
//            } catch (Exception e) {//Catch exception if any
//                System.err.println("Error: " + e.getMessage());
//            }
//        } else {
//            texto.add("");
//        }
//        return texto;
//    }
}
