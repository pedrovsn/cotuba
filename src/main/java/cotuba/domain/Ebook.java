package cotuba;

import java.nio.file.Path;
import java.util.List;

public class Ebook {

    private String titulo;

    private List<Capitulo> capitulos;

    private String formato;

    private Path arquivoSaida;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Path getArquivoSaida() {
        return arquivoSaida;
    }

    public void setArquivoSaida(Path arquivoSaida) {
        this.arquivoSaida = arquivoSaida;
    }
}
