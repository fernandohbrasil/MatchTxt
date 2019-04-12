package Modell;

public class Arquivo {

    private String texto;

    public Arquivo(String texto) {
        this.texto = texto;
    }

    public Arquivo() {
        texto = null;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
