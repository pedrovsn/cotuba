package cotuba.epub;

import cotuba.domain.Ebook;
import cotuba.pdf.GeradorPDF;
import cotuba.pdf.GeradorPDFImpl;

public interface GeradorEbook {

    static GeradorEbook cria(String formato){
        if ("pdf".equals(formato)) {
            return GeradorPDF.cria();
        } else if ("epub".equals(formato)) {
            return GeradorEPUB.cria();
        } else {
            throw new RuntimeException("Formato do ebook inválido: " + formato);
        }
    }

    void gera(Ebook ebook);
}
