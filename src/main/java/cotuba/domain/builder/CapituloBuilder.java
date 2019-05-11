package cotuba.domain.builder;

import cotuba.domain.Capitulo;

public class CapituloBuilder {

    String titulo;

    String conteudoHtml;

    public CapituloBuilder setTitulo(String titulo){
        this.titulo = titulo;
        return this;
    }

    public CapituloBuilder setConteudoHtml(String html){
        this.conteudoHtml = html;
        return this;
    }

    public Capitulo constroi(){
        return new Capitulo(this.titulo, this.conteudoHtml);
    }
}
