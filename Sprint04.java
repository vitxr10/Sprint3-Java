import java.util.Scanner;

public class Sprint04 {

	public static void main(String[] args) {
		// ENTRADA
		Scanner entrada = new Scanner(System.in);

		// VARIAVEIS
		int QtdEquipes = 0, numeroEquipes = 11, QtdCombates = 0, auxiliarP = 0, auxiliarE = 0;
		char resultado;

		// INICIO
		// 1.CARREGANDO VETOR DAS EQUIPES
		System.out.println(
				"-------------------------------------QUANTIDADE DE EQUIPES---------------------------------------");
		System.out.println("");

		System.out.println("Digite a quantidade de equipes na competi��o: ");
		QtdEquipes = entrada.nextInt();

		while (QtdEquipes > 89) {
			System.out.println(
					"A quantidade de equipes ultrapassou o limite de 89 participantes, Digite o n�mero correto novamente: ");
			QtdEquipes = entrada.nextInt();
		}

		// DECLARA��O DE VETORES
		int[] arrayEquipes = new int[QtdEquipes];
		int[] arrayPontuacao = new int[QtdEquipes];
		int[] arrayNotas = new int[QtdEquipes];

		for (int i = 0; i < arrayEquipes.length; i++) {
			arrayEquipes[i] = numeroEquipes;
			numeroEquipes++;
		}

		// 2.CARREGANDO OS COMBATES DAS EQUIPES
		System.out.println("");
		System.out.println("-------------------------------------COMBATES---------------------------------------");
		System.out.println("");

		System.out.println("Digite quantos combates cada equipe ir� realizar: ");
		QtdCombates = entrada.nextInt();

		System.out.println("");

		// MATRIZ ONDE AS LINHAS S�O AS EQUIPES E AS COLUNAS S�O OS COMBATES
		int[][] arrayCombates = new int[QtdCombates][3];

		for (int i = 0; i < arrayEquipes.length; i++) {
			for (int j = 0; j < arrayCombates.length; j++) {
				System.out
						.println("Digite o resultado do " + (j + 1) + "o combate da equipe " + arrayEquipes[i] + ": ");
				resultado = entrada.next().charAt(0);
				resultado = Character.toUpperCase(resultado);

				// VERIFICA��O DO RESULTADO
				while (resultado != 'V' && resultado != 'E' && resultado != 'D') {
					System.out.println("Resultado inv�lido, digite o resultado do combate novamente: ");
					resultado = entrada.next().charAt(0);
					resultado = Character.toUpperCase(resultado);
				}

				if (resultado == 'V') {
					arrayPontuacao[i] += 5;
				} else {
					if (resultado == 'E') {
						arrayPontuacao[i] += 3;
					} else {
						arrayPontuacao[i] += 0;
					}
				}

			}
		}

		// 3.NOTAS DE DESIGN DAS EQUIPES
		System.out.println("");
		System.out
				.println("-------------------------------------NOTAS DE DESIGN---------------------------------------");
		System.out.println("");

		for (int i = 0; i < arrayNotas.length; i++) {
			System.out.println("Digite a nota de design da equipe " + arrayEquipes[i] + ": ");
			arrayNotas[i] = entrada.nextInt();
			
			while (arrayNotas[i]>10) {
				System.out.println("Nota inv�lida! Digite a nota (de 0 a 10) de design da equipe " + arrayEquipes[i] + "novamente : ");
				arrayNotas[i] = entrada.nextInt();
			}
		}

		// 4.PONTUA��O FINAL
		System.out.println("");
		System.out.println(
				"-------------------------------------CLASSIFICA��O FINAL---------------------------------------");
		System.out.println("");

		for (int i = 0; i < arrayEquipes.length; i++) {
			for (int j = 0; j < arrayEquipes.length; j++) {

				if (arrayPontuacao[i] > arrayPontuacao[j]) {
					// ORDENA��O PONTOS
					auxiliarP = arrayPontuacao[i];
					arrayPontuacao[i] = arrayPontuacao[j];
					arrayPontuacao[j] = auxiliarP;

					// ORDENA��O EQUIPES
					auxiliarE = arrayEquipes[i];
					arrayEquipes[i] = arrayEquipes[j];
					arrayEquipes[j] = auxiliarE;

				} else if (arrayPontuacao[i] == arrayPontuacao[j]) {
					// DESEMPATE
					if (arrayNotas[j] > arrayNotas[i]) {
						// ORDENA��O PONTOS
						auxiliarP = arrayPontuacao[j];
						arrayPontuacao[j] = arrayPontuacao[i];
						arrayPontuacao[i] = auxiliarP;

						// ORDENA��O EQUIPES
						auxiliarE = arrayEquipes[j];
						arrayEquipes[j] = arrayEquipes[i];
						arrayEquipes[i] = auxiliarE;

					}
				}

			}

		}

		for (int j = 0; j < arrayEquipes.length; j++) {
			System.out.println("Equipe: " + arrayEquipes[j] + "\t Pontua��o: " + arrayPontuacao[j]);
		}

	}

}
