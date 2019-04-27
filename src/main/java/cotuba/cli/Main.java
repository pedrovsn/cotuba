package cotuba;

import cotuba.application.Cotuba;

import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		LeitorDeOpcoes leitorDeOpcoes = new LeitorDeOpcoes(args);

		Path diretorioDosMD = leitorDeOpcoes.getDiretorioDosMD();
		String formato = leitorDeOpcoes.getFormato();
		Path arquivoDeSaida = leitorDeOpcoes.getArquivoDeSaida();
		boolean modoVerboso = leitorDeOpcoes.isModoVerboso();

		try {
			Cotuba cotuba = new Cotuba();
			cotuba.executa(formato, diretorioDosMD, arquivoDeSaida);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			if (modoVerboso) {
				ex.printStackTrace();
			}
			System.exit(1);
		}
	}

}
