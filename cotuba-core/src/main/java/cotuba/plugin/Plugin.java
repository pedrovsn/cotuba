package cotuba.plugin;

import cotuba.domain.Ebook;

import java.util.ServiceLoader;

public interface Plugin {
    String css();
    void gerou(Ebook ebook);

    static void acoesPosGeracao(Ebook ebook) {
        ServiceLoader<Plugin> serviceLoader = ServiceLoader.load(Plugin.class);

        for(Plugin plugin : serviceLoader){
            plugin.gerou(ebook);
        }
    }
}