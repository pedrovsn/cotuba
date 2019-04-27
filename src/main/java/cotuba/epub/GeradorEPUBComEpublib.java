package cotuba.epub;

import cotuba.application.GeradorEPUB;
import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.md.RenderizadorMDParaHTMLImpl;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class GeradorEPUBImpl implements GeradorEPUB {

	@Override
	public void gera(Ebook ebook) {
		Book epub = new Book();

		RenderizadorMDParaHTMLImpl renderizadorMdParaHtmlImpl = new RenderizadorMDParaHTMLImpl();
		List<Capitulo> capitulos = renderizadorMdParaHtmlImpl.renderiza(ebook.getArquivoSaida());

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
