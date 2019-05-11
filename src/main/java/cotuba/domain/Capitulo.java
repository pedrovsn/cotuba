package cotuba.domain;

public class Capitulo implements cotuba.plugin.Capitulo {

    private String titulo;

    private String conteudoHtml;

    public Capitulo(String titulo, String html) {
        this.titulo = titulo;
        this.conteudoHtml = html;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudoHtml() {
        return conteudoHtml;
    }

    public void setConteudoHtml(String conteudoHtml) {
        this.conteudoHtml = conteudoHtml;
    }
}
