package View;

import javax.swing.JOptionPane;

public class ArquivoView {

    public String informarDiretorio() {
        try {
            return JOptionPane.showInputDialog(null, "Informe o Caminho dos Arquivos!");
        } catch(Exception e){
            return null;
        }
    }
    
    public void retornoOperacao(boolean oRetorno){
        if (oRetorno){
            JOptionPane.showMessageDialog(null, "Arquivo Gerado com Sucesso");
        }else {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar o Arquivo");
        }
            
    }

}
