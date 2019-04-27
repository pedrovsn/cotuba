package cotuba.cli;

import cotuba.application.Cotuba;

public class Main {

	public static void main(String[] args) {
		LeitorDeOpcoesCLI opcoesCLI = new LeitorDeOpcoesCLI(args);

		boolean modoVerboso = opcoesCLI.isModoVerboso();

		try {
			Cotuba cotuba = new Cotuba();
			cotuba.executa(opcoesCLI);

			System.out.println("Arquivo gerado com sucesso: " + opcoesCLI.getArquivoSaida());
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			if (modoVerboso) {
				ex.printStackTrace();
			}
			System.exit(1);
		}
	}
}
