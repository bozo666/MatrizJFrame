package Calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.AbstractListModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField A11;
	private JTextField A12;
	private JTextField A13;
	private JTextField A21;
	private JTextField A22;
	private JTextField A23;
	private JTextField A31;
	private JTextField A32;
	private JTextField A33;
	// -----extra
	private JLabel lblTipo;
	private JTextField jtext;
	// ---------------end
	// botões
	private JButton Calcular;
	private JButton Ajuda;
	@SuppressWarnings("rawtypes")
	private static JList list;
	// textpane para calculos
	private static JTextPane matrizes;
	private static JTextPane respostas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewJFrame frame = new NewJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	public NewJFrame() {
		setTitle("Opera\u00E7\u00F5es com Matrizes 3x3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 300, 865, 369);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		A11 = new JTextField();
		A11.setBounds(96, 31, 87, 32);
		A11.setHorizontalAlignment(SwingConstants.CENTER);
		A11.setColumns(10);

		A12 = new JTextField();
		A12.setBounds(195, 31, 87, 32);
		A12.setHorizontalAlignment(SwingConstants.CENTER);
		A12.setColumns(10);

		A13 = new JTextField();
		A13.setBounds(294, 31, 87, 32);
		A13.setHorizontalAlignment(SwingConstants.CENTER);
		A13.setColumns(10);

		A21 = new JTextField();
		A21.setBounds(96, 64, 87, 32);
		A21.setHorizontalAlignment(SwingConstants.CENTER);
		A21.setColumns(10);

		A22 = new JTextField();
		A22.setBounds(195, 64, 87, 32);
		A22.setHorizontalAlignment(SwingConstants.CENTER);
		A22.setColumns(10);

		A23 = new JTextField();
		A23.setBounds(294, 64, 87, 32);
		A23.setHorizontalAlignment(SwingConstants.CENTER);
		A23.setColumns(10);

		A31 = new JTextField();
		A31.setBounds(96, 97, 87, 32);
		A31.setHorizontalAlignment(SwingConstants.CENTER);
		A31.setColumns(10);

		A32 = new JTextField();
		A32.setBounds(195, 97, 87, 32);
		A32.setHorizontalAlignment(SwingConstants.CENTER);
		A32.setColumns(10);

		A33 = new JTextField();
		A33.setBounds(294, 97, 87, 32);
		A33.setHorizontalAlignment(SwingConstants.CENTER);
		A33.setColumns(10);

		JLabel lblMatrizx = new JLabel("Matriz 3x3");
		lblMatrizx.setBackground(Color.WHITE);
		lblMatrizx.setBounds(101, 5, 81, 22);
		lblMatrizx.setFont(new Font("Arial", Font.PLAIN, 18));

		jtext = new JTextField();
		jtext.setBounds(400, 98, 46, 31);
		jtext.setHorizontalAlignment(SwingConstants.CENTER);
		jtext.setColumns(10);

		JLabel indicadorOP = new JLabel("?");
		indicadorOP.setBounds(387, 101, 8, 23);
		indicadorOP.setFont(new Font("Arial", Font.PLAIN, 18));

		JButton Limpar = new JButton("Limpar");
		Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Evento botão limpar
				limpar();
				limpar2();
			}
		});
		Limpar.setBounds(96, 142, 87, 25);

		JButton Adicionar = new JButton("Adicionar");
		Adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String retorno = null;
					if (!list.isSelectionEmpty())
						switch (list.getSelectedValue().toString()) {
						// ----------------------------------------------------------------------------------
						case "Transposta":
							retorno = " Transposta ";
							break;
						case "Oposta":
							retorno = " Oposta ";
							break;
						case "Inversa":
							retorno = " Inversa ";
							break;
						case "Adição":
							retorno = " + ";
							indicadorOP.setText("+");
							break;
						case "Subtração":
							retorno = " - ";
							indicadorOP.setText("-");
							break;
						case "Multiplicação":
							retorno = " * ";
							indicadorOP.setText("*");
							break;
						case "Potência":
							retorno = " Potência ";
							indicadorOP.setText("^");
							break;
						case "Determinante":
							retorno = " Determinante ";
							break;
						default:
							JOptionPane.showMessageDialog(null, "Erro: Valor selecionado não consta!", "Aviso",
									JOptionPane.WARNING_MESSAGE);
							break;
						}
					else
						JOptionPane.showMessageDialog(null, "Operação não selecionada", "Aviso",
								JOptionPane.WARNING_MESSAGE);
					if (retorno != null) {
						// evento botão adicionar
						int[][] mat = new int[3][3];
						Operacoes op = new Operacoes();
						mat[0][0] = Integer.parseInt(A11.getText().trim());
						mat[0][1] = Integer.parseInt(A12.getText().trim());
						mat[0][2] = Integer.parseInt(A13.getText().trim());
						mat[1][0] = Integer.parseInt(A21.getText().trim());
						mat[1][1] = Integer.parseInt(A22.getText().trim());
						mat[1][2] = Integer.parseInt(A23.getText().trim());
						mat[2][0] = Integer.parseInt(A31.getText().trim());
						mat[2][1] = Integer.parseInt(A32.getText().trim());
						mat[2][2] = Integer.parseInt(A33.getText().trim());
						op.setList(mat);
						op.Exibicao_Matrizes(matrizes, retorno,
								jtext.getText().trim().length() != 0 ? jtext.getText().trim() : "");
						limpar();
					}
				} catch (Exception ev) {
					JOptionPane.showMessageDialog(null, "Preencha os campos corretamente!", "AVISO!",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		});
		Adicionar.setBounds(195, 142, 87, 25);

		Calcular = new JButton("Calcular");
		Calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// evento botão calcular
				Operacoes resultado = new Operacoes();
				resultado.operacao(respostas, list);
			}
		});
		Calcular.setBounds(294, 142, 87, 25);

		Ajuda = new JButton("Ajuda");
		Ajuda.setBounds(387, 3, 68, 25);

		list = new JList<String[]>();
		list.setBounds(5, 23, 84, 144);
		list.setBackground(new java.awt.Color(0, 204, 204));
		list.setForeground(new java.awt.Color(255, 255, 255));
		list.setModel(new AbstractListModel() {
			String[] strings = { "Transposta", "Oposta", "Inversa", "Adição", "Subtração", "Multiplicação", "Potência",
					"Determinante" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});

		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		lblTipo = new JLabel("Operações:");
		lblTipo.setBackground(Color.WHITE);
		lblTipo.setBounds(5, 5, 66, 16);
		contentPane.setLayout(null);
		contentPane.add(list);
		contentPane.add(lblTipo);
		contentPane.add(Limpar);
		contentPane.add(Adicionar);
		contentPane.add(Calcular);
		contentPane.add(lblMatrizx);
		contentPane.add(A21);
		contentPane.add(A11);
		contentPane.add(A31);
		contentPane.add(A12);
		contentPane.add(A13);
		contentPane.add(A22);
		contentPane.add(A23);
		contentPane.add(A32);
		contentPane.add(A33);
		contentPane.add(indicadorOP);
		contentPane.add(Ajuda);
		contentPane.add(jtext);

		matrizes = new JTextPane();
		matrizes.setText("Sem matrizes...");
		matrizes.setForeground(new Color(255, 255, 255));
		matrizes.setFont(new Font("Arial", Font.PLAIN, 13));
		matrizes.setBackground(new Color(0, 0, 0));
		matrizes.setBounds(5, 170, 443, 144);
		matrizes.setEnabled(false);
		contentPane.add(matrizes);

		respostas = new JTextPane();
		respostas.setText("Sem resultados...");
		respostas.setForeground(new Color(255, 255, 255));
		respostas.setFont(new Font("Arial", Font.PLAIN, 13));
		respostas.setBackground(Color.BLACK);
		respostas.setBounds(458, 5, 383, 309);
		respostas.setEnabled(false);
		contentPane.add(respostas);
	}

	private void limpar() {
		A11.setText("");
		A12.setText("");
		A13.setText("");
		A21.setText("");
		A22.setText("");
		A23.setText("");
		A31.setText("");
		A32.setText("");
		A33.setText("");
		jtext.setText("");
	}

	private void limpar2() {
		matrizes.setText("Sem matrizes...");
		respostas.setText("Sem resultados...");
		Operacoes comando = new Operacoes();
		comando.limpaList();
	}

}