package br.com.cognito.estatisticas;

import java.util.HashMap;

public class ContagemPalavras extends HashMap<String, Integer> {

    public void adicionaPalavra(String key, Integer value) {
        Integer qtdExistente;
        if(containsKey(key)){
            qtdExistente = get(key);

            super.put(key, ++qtdExistente);
        }else{
            put(key, 1);
        }
    }
}
