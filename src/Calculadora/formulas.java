package Calculadora;

public class formulas {

	public int[][] Transposta(int[][] a) {
		int[][] retorno = new int[3][3];
		retorno[0][0] = a[0][0];
		retorno[0][1] = a[1][0];
		retorno[0][2] = a[2][0];

		retorno[1][0] = a[0][1];
		retorno[1][1] = a[1][1];
		retorno[1][2] = a[2][1];

		retorno[2][0] = a[0][2];
		retorno[2][1] = a[1][2];
		retorno[2][2] = a[2][2];

		return retorno;
	}

	public int[][] Oposta(int[][] a) {
		int[][] retorno = new int[3][3];
		retorno[0][0] = a[0][0] * (-1);
		retorno[0][1] = a[0][1] * (-1);
		retorno[0][2] = a[0][2] * (-1);

		retorno[1][0] = a[1][0] * (-1);
		retorno[1][1] = a[1][1] * (-1);
		retorno[1][2] = a[1][2] * (-1);

		retorno[2][0] = a[2][0] * (-1);
		retorno[2][1] = a[2][1] * (-1);
		retorno[2][2] = a[2][2] * (-1);
		return retorno;
	}

	public int[][] Multiplicacao(int[][] a, int[][] b, int mult) {
		int[][] retorno = new int[3][3];
		if (mult == 0 && b != null) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					for (int k = 0; k <= 2; k++) {
						retorno[i][j] = retorno[i][j] + (a[i][k] * b[k][j]);
					}
				}
			}
		} else {
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					retorno[i][j] = a[i][j] * mult;
				}
			}
		}
		return retorno;
	}

	public int[][] Soma(int[][] a, int[][] b, int soma) {
		int[][] retorno = new int[3][3];
		if (soma == 0 && b != null) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					retorno[i][j] = a[i][j] + b[i][j];
				}
			}
		} else {
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					retorno[i][j] = a[i][j] + soma;
				}
			}
		}
		return retorno;
	}

	public int[][] Subtracao(int[][] a, int[][] b, int sub) {
		int[][] retorno = new int[3][3];
		if (sub == 0 && b != null) {
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					retorno[i][j] = a[i][j] - b[i][j];
				}
			}
		} else {
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					retorno[i][j] = a[i][j] - sub;
				}
			}
		}
		return retorno;
	}

	// Regra de Sarrus
	public int Determinante(int[][] a) {
		int primaria, secundaria;
		// primária
		primaria = (a[0][0] * a[1][1] * a[2][2]) + (a[0][1] * a[1][2] * a[2][0]) + (a[0][2] * a[1][0] * a[2][1]);
		// secundária
		secundaria = (a[0][2] * a[1][1] * a[2][0]) + (a[0][0] * a[1][2] * a[2][1]) + (a[0][1] * a[1][0] * a[2][2]);
		return primaria - secundaria;
	}

	// observar~~~~~~~~~~~~~~~~~~~~~~~~
	// Retorna uma matriz identidade n x n
	public int[][] Identidade(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("n <= 0");
		}
		int[][] I = new int[n][n];
		for (int i = 0; i < n; i++) {
			I[i][i] = 1;
		}
		return I;
	}

	// Calcula A elevado a N. A matriz precisa ser quadrada
	public int[][] Potenciacao(int A[][], int n) {
		if (n < 0)
			throw new IllegalArgumentException("n < 0");
		if (n == 0)
			return Identidade(A.length);

		int[][] p = Potenciacao(A, n / 2);
		if (n % 2 == 0) {
			return Multiplicacao(p, p, 0);
		} else {
			int[][] p2 = Multiplicacao(p, p, 0);
			return Multiplicacao(A, p2, 0);
		}
	}

	// ===============================================================================
	// Matriz inversa
	// -------------------------------------------------------------------------
	public int[][] Inversa(int[][] M) {
		if (Determinante(M) != 0) {
			int[][] cofatores = new int[3][3];
			// Exibição da matriz
			// M[0][0] M[0][1] M[0][2]
			// M[1][0] M[1][1] M[1][2]
			// M[2][0] M[2][1] M[2][2]

			// Elementos ---------------------------
			// A11
			cofatores[0][0] = (M[1][1] * M[2][2]) - (M[2][1] * M[1][2]);
			// A12
			cofatores[0][1] = ((M[1][0] * M[2][2]) - (M[2][0] * M[1][2])) * (-1);
			// A13
			cofatores[0][2] = (M[1][0] * M[2][1]) - (M[2][0] * M[1][1]);
			// A21
			cofatores[1][0] = ((M[0][1] * M[2][2]) - (M[2][1] * M[0][2])) * (-1);
			// A22
			cofatores[1][1] = (M[0][0] * M[2][2]) - (M[2][0] * M[0][2]);
			// A23
			cofatores[1][2] = ((M[0][0] * M[2][1]) - (M[2][0] * M[0][1])) * (-1);
			// A31
			cofatores[2][0] = (M[0][1] * M[1][2]) - (M[1][1] * M[0][2]);
			// A32
			cofatores[2][1] = ((M[0][0] * M[1][2]) - (M[1][0] * M[0][2])) * (-1);
			// A33
			cofatores[2][2] = (M[0][0] * M[1][1]) - (M[0][1] * M[1][0]);
			// end elementos ----------------------
			cofatores = Transposta(cofatores);
			int D = Determinante(M);
			for (int i = 0; i <= 2; i++)
				for (int j = 0; j <= 2; j++)
					cofatores[i][j] = (cofatores[i][j]) / D;
			// retornando a inversa
			return cofatores;
		} else {
			return null;
		}
	}
	// end matriz inversa
	// ----------------------------------------------------------------------

}