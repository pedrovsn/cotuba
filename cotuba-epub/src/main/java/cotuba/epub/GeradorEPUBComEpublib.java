package cotuba.epub;

import cotuba.application.GeradorEbook;
import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.md.RenderizadorMDParaHTMLComCommonMark;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class GeradorEPUBComEpublib implements GeradorEbook {

	@Override
	public void gera(Ebook ebook) {
		Book epub = new Book();

		RenderizadorMDParaHTMLComCommonMark renderizadorMdParaHtmlComCommonMark = new RenderizadorMDParaHTMLComCommonMark();
		List<Capitulo> capitulos = renderizadorMdParaHtmlComCommonMark.renderiza(ebook.getArquivoSaida());

		for(Capitulo capitulo : capitulos){
			epub.addSection(capitulo.getTitulo(), new Resource(capitulo.getConteudoHtml().getBytes(), MediatypeService.XHTML));
		}

		EpubWriter epubWriter = new EpubWriter();

		try {
			epubWriter.write(epub, Files.newOutputStream(ebook.getArquivoSaida()));
		} catch (IOException ex) {
			throw new RuntimeException("Erro ao criar arquivo EPUB: " + ebook.getArquivoSaida().toAbsolutePath(), ex);
		}

	}
}
