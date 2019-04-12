package Controller;

import Dao.ArquivoDao;
import Modell.Arquivo;
import View.ArquivoView;

public class ArquivoController {
    
    private Arquivo oArquivo;
    private ArquivoView vwArquivo;
    private ArquivoDao daoArquivo;
    
    public ArquivoController(Arquivo oArquivo, ArquivoView vwArquivo, ArquivoDao daoArquivo) {
        this.oArquivo = oArquivo;
        this.vwArquivo = vwArquivo;
        this.daoArquivo = daoArquivo;
    }
    
    public ArquivoController() {
        oArquivo = new Arquivo();
        vwArquivo = new ArquivoView();
        daoArquivo = new ArquivoDao();
    }
    
    public void executar() {
        novoArquivo();
    }
    
    private void novoArquivo() {
        String diretorio = vwArquivo.informarDiretorio();
        if (diretorio != null) {
            if (daoArquivo.deletaArquivo(diretorio)) {
                String novoTexto = daoArquivo.leDiretorio(diretorio);
                if (novoTexto != null) {
                    boolean confirma = daoArquivo.escreveTxt(novoTexto, diretorio);
                    vwArquivo.retornoOperacao(confirma);
                }
            }
        }
        System.exit(0);
        
    }
}
