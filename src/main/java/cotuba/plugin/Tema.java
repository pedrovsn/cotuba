package cotuba.plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public interface Tema {

    String cssDoTema();

    static List<String> carregaTemas() {
        List<String> list = new ArrayList<>();

        ServiceLoader<Tema> serviceLoader = ServiceLoader.load(Tema.class);

        for(Tema tema : serviceLoader){
            list.add(tema.cssDoTema());
        }

        return list;
    }
}
