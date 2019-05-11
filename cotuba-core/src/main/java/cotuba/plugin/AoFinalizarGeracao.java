package cotuba.plugin;

import cotuba.domain.Ebook;

import java.util.ServiceLoader;
import java.util.function.Consumer;

public interface AoFinalizarGeracao {

    void aposGeracao(Ebook ebook, Consumer<String> acaoAoFinalizar);

    static void gerou(Ebook ebook, Consumer<String> consumer){
        ServiceLoader<AoFinalizarGeracao> loader = ServiceLoader.load(AoFinalizarGeracao.class);

        for(AoFinalizarGeracao plugin : loader){
            plugin.aposGeracao(ebook, consumer);
        }
    }
}
