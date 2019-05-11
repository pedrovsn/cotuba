package cotuba.domain;

public class Capitulo {

    private final String titulo;

    private final String conteudoHtml;

    public Capitulo(String titulo, String html) {
        this.titulo = titulo;
        this.conteudoHtml = html;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudoHtml() {
        return conteudoHtml;
    }

}
