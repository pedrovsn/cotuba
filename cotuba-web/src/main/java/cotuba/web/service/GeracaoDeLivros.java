package cotuba.web.service;

import cotuba.application.Cotuba;
import cotuba.application.ParametrosCotuba;
import cotuba.domain.FormatoEbook;
import cotuba.web.application.CadastroDeLivros;
import cotuba.web.domain.Livro;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class GeracaoDeLivros {

    private final CadastroDeLivros livros;

    public GeracaoDeLivros(CadastroDeLivros livros) {
        this.livros = livros;
    }

    public Path geraLivro(Long id, FormatoEbook formatoEbook) {
        Livro livro = livros.detalha(id);

        ParametrosCotuba parametros = new ParametrosCotuba() {
            @Override
            public Path getDiretorioDosMD() {
                return null;
            }

            @Override
            public FormatoEbook getFormato() {
                return null;
            }

            @Override
            public Path getArquivoSaida() {
                return null;
            }
        };

        Cotuba cotuba = new Cotuba();
        cotuba.executa(parametros, null);
    }

    private static class ParametrosCotubaWeb implements ParametrosCotuba {

        private Livro livro;

        @Override
        public Path getDiretorioDosMD() {
            return null;
        }

        @Override
        public FormatoEbook getFormato() {
            return null;
        }

        @Override
        public Path getArquivoSaida() {
            return null;
        }
    }
}
