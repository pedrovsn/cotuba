package cotuba.plugin;

import cotuba.domain.Capitulo;
import cotuba.domain.FormatoEbook;

import java.nio.file.Path;
import java.util.List;

public interface Ebook {
    String getTitulo();

    List<? extends Capitulo> getCapitulos();

    FormatoEbook getFormatoEbook();

    Path getArquivoSaida();
}
