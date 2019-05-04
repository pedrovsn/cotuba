package br.com.paradizo.TemaParadizo;

import cotuba.plugin.Tema;

public class Tema1 implements Tema {

    @Override
    public String cssDoTema() {
        return FileUtils.getResourceContents("/tema.css");
    }
}
