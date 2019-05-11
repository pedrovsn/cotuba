package br.com.cognito.estatisticas;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ContagemPalavras implements Iterable<ContagemPalavras.Contagem> {

    private Map<String, Integer> map = new HashMap<>();

    public void adicionaPalavra(String key) {
        Integer qtdExistente = map.get(key);

        if(qtdExistente != null){
            qtdExistente++;
        }else{
            qtdExistente = 1;
        }

        map.put(key, qtdExistente);
    }

    public Set<Map.Entry<String, Integer>> entrySet(){
        return map.entrySet();
    }

    @Override
    public Iterator<Contagem> iterator() {
        Iterator<Map.Entry<String, Integer>> iterator = this.map.entrySet().iterator();

        return new Iterator<Contagem>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Contagem next() {
                Map.Entry<String, Integer> entry = iterator.next();
                return new Contagem(entry.getKey(), entry.getValue());
            }
        };
    }


    public static class Contagem {

        private final String palavra;
        private final Integer ocorrencias;

        public Contagem(String palavra, Integer ocorrencias) {
            this.palavra = palavra;
            this.ocorrencias = ocorrencias;
        }

        public String getPalavra() {
            return palavra;
        }

        public Integer getOcorrencias() {
            return ocorrencias;
        }
    }
}
