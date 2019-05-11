package cotuba.web.controller;

import cotuba.domain.FormatoEbook;
import cotuba.web.SpringFileUtils;
import cotuba.web.service.GeracaoDeLivros;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.nio.file.Path;

@Controller
public class GeradorLivrosController {

    private final GeracaoDeLivros geracaoDeLivros;

    public GeradorLivrosController(GeracaoDeLivros geracaoDeLivros) {
        this.geracaoDeLivros = geracaoDeLivros;
    }

    @GetMapping("/livros/{id}/pdf")
    public ResponseEntity<ByteArrayResource> GerarPdf(@PathVariable("id") Integer id, Model model){

        Path path = geracaoDeLivros.geraLivro(Long.valueOf(id), FormatoEbook.PDF);
        return SpringFileUtils.montaResponseArquivo(path, "application/pdf");
    }

    @GetMapping("/livros/{id}/pdf")
    public ResponseEntity<ByteArrayResource> GerarEPub(@PathVariable("id") Integer id, Model model){

        Path path = geracaoDeLivros.geraLivro(Long.valueOf(id), FormatoEbook.EPUB);

        return SpringFileUtils.montaResponseArquivo(path, "application/epub+zip");
    }
}
