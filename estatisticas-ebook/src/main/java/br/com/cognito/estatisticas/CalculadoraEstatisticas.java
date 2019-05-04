package br.com.cognito.estatisticas;

import cotuba.plugin.AoFinalizarGeracao;
import cotuba.plugin.Capitulo;
import cotuba.plugin.Ebook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.Normalizer;

public class CalculadoraEstatisticas implements AoFinalizarGeracao {

    @Override
    public void aposGeracao(Ebook ebook) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();
        for(Capitulo capitulo : ebook.getCapitulos()){
            String html = capitulo.getConteudoHtml();

            Document document = Jsoup.parse(html);
            String texto = document.body().text();
            String textoSemPontuacao = texto.replaceAll("\\p{Punct}", "");
            textoSemPontuacao = Normalizer.normalize(textoSemPontuacao, Normalizer.Form.NFD);
            texto = textoSemPontuacao.replaceAll("^\\p{ASCII}", "");

            String[] palavras = texto.split("\\s+");

            for(String palavra : palavras){
//                contagemPalavras.put(palavra);
            }
        }
    }
}
