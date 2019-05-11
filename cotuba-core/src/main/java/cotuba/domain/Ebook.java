package cotuba.domain;

import java.nio.file.Path;
import java.util.List;

public class Ebook {

    private final String titulo;

    private final List<Capitulo> capitulos;

    private final FormatoEbook formatoEbook;

    private final Path arquivoSaida;

    public Ebook(String titulo, List<Capitulo> capitulos, FormatoEbook formatoEbook, Path arquivoSaida) {
        this.titulo = titulo;
        this.capitulos = capitulos;
        this.formatoEbook = formatoEbook;
        this.arquivoSaida = arquivoSaida;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public FormatoEbook getFormatoEbook() {
        return formatoEbook;
    }

    public Path getArquivoSaida() {
        return arquivoSaida;
    }
}
