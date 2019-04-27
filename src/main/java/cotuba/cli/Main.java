package cotuba.cli;

import cotuba.application.Cotuba;

public class Main {

	public static void main(String[] args) {
		LeitorDeOpcoesCLI leitorDeOpcoes = new LeitorDeOpcoesCLI(args);

		boolean modoVerboso = leitorDeOpcoes.isModoVerboso();

		try {
			Cotuba cotuba = new Cotuba();
			cotuba.executa(leitorDeOpcoes);

			System.out.println("Arquivo gerado com sucesso: " + leitorDeOpcoes.getArquivoSaida());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			if (modoVerboso) {
				ex.printStackTrace();
			}
			System.exit(1);
		}
	}
}
