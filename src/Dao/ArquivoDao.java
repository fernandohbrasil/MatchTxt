package Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ArquivoDao {

    public String leDiretorio(String diretorio) {
        String textoNovo = "";
        String textoAntigo;

        try {
            File oDiretorio = new File(diretorio);
            File[] arquivos = oDiretorio.listFiles();

            for (int i = 0; i < arquivos.length; i++) {
                FileReader arquivo = new FileReader(arquivos[i]);
                BufferedReader leitor = new BufferedReader(arquivo);
                textoAntigo = "";

                while (leitor.ready()) {
                    textoAntigo = textoAntigo + leitor.readLine() + "\n";
                }

                if (!"".equals(textoAntigo)) {
                    textoNovo = textoNovo + textoAntigo;
                }
            }
            return textoNovo;

        } catch (Exception e) {
            return "";
        }
    }

    public boolean escreveTxt(String texto, String diretorio) {
        try {
            File arquivo = new File(diretorio + "\\novo.txt");

            arquivo.createNewFile();
            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.close();
            fw.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deletaArquivo(String diretorio) {
        try {
            File arquivo = new File(diretorio + "\\novo.txt");
            boolean existe = arquivo.exists();
            boolean confirma = true;
            if (existe) {
                try {
                    confirma = arquivo.delete();
                } catch (Exception e){
                    confirma = false;
                }
            }
            return confirma;
        } catch (Exception e) {
            return false;
        }
    }
}
