package Calculadora;

import javax.swing.*;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public class Operacoes {
	private static String op = null;

	public String getOP() {
		return op;
	}

	private static ArrayList<int[][]> list = new ArrayList<int[][]>();

	public void setList(int[][] matriz) {
		list.add(matriz);
	}

	public void Exibicao_Matrizes(JTextPane matrizes, String op, String v) {
		valor = v == "" ? 0 : Integer.parseInt(v);
		StringWriter sw = new StringWriter();
		PrintWriter out = new PrintWriter(sw);
		for (int i = 0; i <= 2; i++) {// quantidade de linhas
			for (int Array = 0; Array < list.size(); Array++) { // quantidade de arraylist
				for (int j = 0; j <= 2; j++) { // quantidade de colunas
					out.printf("%d ", list.get(Array)[i][j]);
					out.printf(j == 2 ? "|" : "");
					if (i == 2 && j == 2 && Array == list.size() - 1) {
						if (v != "") {
							out.printf("%s%s", op, v);
						} else {
							out.printf("%s", op);
						}
					}
				}

			}

			out.printf("\n");
		}
		matrizes.setText(sw.toString());
	}

	private void Exibicao_Resultados(int[][] R, int r, JTextPane resultado) {
		StringWriter sw = new StringWriter();
		PrintWriter out = new PrintWriter(sw);
		if (r == 0 && R != null) {
			for (int i = 0; i <= 2; i++) {// quantidade de linhas
				for (int j = 0; j <= 2; j++) { // quantidade de colunas
					out.printf("%d ", R[i][j]);
					out.printf(j == 2 ? "|" : "");
				}
				out.printf("\n");
			}
		} else {
			out.printf("Resultado: %d", r);
		}
		resultado.setText(sw.toString());
		limpaList();
	}

	public void limpaList() {
		list.clear();
	}

	private static int valor = 0;

	@SuppressWarnings("rawtypes")
	public void operacao(JTextPane resultado, JList a) {
		formulas formula = new formulas();
		if (!a.isSelectionEmpty())
			switch (a.getSelectedValue().toString()) {
			case "Transposta":
				Exibicao_Resultados(formula.Transposta(list.get(0)), 0, resultado);
				break;
			case "Oposta":
				Exibicao_Resultados(formula.Oposta(list.get(0)), 0, resultado);
				break;
			case "Inversa":
				Exibicao_Resultados(formula.Inversa(list.get(0)), 0, resultado);
				break;
			case "Adição":
				if (list.size() > 1 && valor == 0) {
					while (list.size() > 1) {
						list.set(0, formula.Soma(list.get(0), list.get(1), valor));
						list.remove(1);
					}
					Exibicao_Resultados(list.get(0), 0, resultado);
				} else if (list.size() < 2 && valor != 0) {
					Exibicao_Resultados(formula.Soma(list.get(0), null, valor), 0, resultado);
				}

				break;
			case "Subtração":
				if (list.size() > 1 && valor == 0) {
					while (list.size() > 1) {
						list.set(0, formula.Subtracao(list.get(0), list.get(1), valor));
						list.remove(1);
					}
					Exibicao_Resultados(list.get(0), 0, resultado);
				} else if (list.size() < 2 && valor != 0) {
					Exibicao_Resultados(formula.Subtracao(list.get(0), null, valor), 0, resultado);
				}
				break;
			case "Multiplicação":
				if (list.size() > 1 && valor == 0) {
					while (list.size() > 1) {
						list.set(0, formula.Multiplicacao(list.get(0), list.get(1), valor));
						list.remove(1);
					}
					Exibicao_Resultados(list.get(0), 0, resultado);
				} else if (list.size() < 2 && valor != 0) {
					Exibicao_Resultados(formula.Multiplicacao(list.get(0), null, valor), 0, resultado);
				}
				break;
			case "Potência":
				Exibicao_Resultados(formula.Potenciacao(list.get(0), valor), 0, resultado);
				break;
			case "Determinante":
				Exibicao_Resultados(null, formula.Determinante(list.get(0)), resultado);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Erro: Valor selecionado não consta!", "Aviso",
						JOptionPane.WARNING_MESSAGE);
				break;
			}
		else
			JOptionPane.showMessageDialog(null, "Operação não selecionada", "Aviso", JOptionPane.WARNING_MESSAGE);
		valor = 0;
	}

}