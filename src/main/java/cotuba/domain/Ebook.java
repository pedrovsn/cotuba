package cotuba.domain;

import java.nio.file.Path;
import java.util.List;

public class Ebook implements cotuba.plugin.Ebook {

    private String titulo;

    private List<Capitulo> capitulos;

    private FormatoEbook formatoEbook;

    private Path arquivoSaida;

    @Override
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    @Override
    public FormatoEbook getFormatoEbook() {
        return formatoEbook;
    }

    public void setFormatoEbook(FormatoEbook formatoEbook) {
        this.formatoEbook = formatoEbook;
    }

    @Override
    public Path getArquivoSaida() {
        return arquivoSaida;
    }

    public void setArquivoSaida(Path arquivoSaida) {
        this.arquivoSaida = arquivoSaida;
    }
}
