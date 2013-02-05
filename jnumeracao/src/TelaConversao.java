
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

import numeracao.Numeracao;
import numeracao.NumeroNaoBinarioException;
import numeracao.NumeroNaoDecimalException;
import numeracao.NumeroNaoHexadecimalException;
import numeracao.NumeroNaoOctalException;
import numeracao.NumeroVazioException;

import javax.swing.JLabel;

public class TelaConversao extends JFrame {

	private JPanel jContentPane = null;
	private JTextField txtNumero = null;
	private JButton cmdBinario = null;
	private JButton cmdOctal = null;
	private JButton cmdDecimal = null;
	private JButton cmdHexadecimal = null;
	private int tipoNumeracao;
	private JLabel lblTipoNumero = null;
	private JLabel lblAutor = null;

	public TelaConversao() {
		super();
		initialize();
		this.setarNumeracao(Numeracao.TIPO_ENTRADA_DECIMAL);
	}
	
	private void setarNumeracao(int tipoNumeracao) {
		switch (tipoNumeracao) {
		case Numeracao.TIPO_ENTRADA_DECIMAL:
			this.tipoNumeracao = tipoNumeracao;
			lblTipoNumero.setText("Decimal");
			cmdDecimal.setEnabled(false);
			cmdOctal.setEnabled(true);
			cmdBinario.setEnabled(true);
			cmdHexadecimal.setEnabled(true);
			break;
		case Numeracao.TIPO_ENTRADA_OCTAL:
			this.tipoNumeracao = tipoNumeracao;
			lblTipoNumero.setText("Octal");
			cmdDecimal.setEnabled(true);
			cmdOctal.setEnabled(false);
			cmdBinario.setEnabled(true);
			cmdHexadecimal.setEnabled(true);
			break;
		case Numeracao.TIPO_ENTRADA_HEXADECIMAL:
			this.tipoNumeracao = tipoNumeracao;
			lblTipoNumero.setText("Hexadecimal");
			cmdDecimal.setEnabled(true);
			cmdOctal.setEnabled(true);
			cmdBinario.setEnabled(true);
			cmdHexadecimal.setEnabled(false);
			break;
		case Numeracao.TIPO_ENTRADA_BINARIO:
			this.tipoNumeracao = tipoNumeracao;
			lblTipoNumero.setText("Binário");
			cmdDecimal.setEnabled(true);
			cmdOctal.setEnabled(true);
			cmdBinario.setEnabled(false);
			cmdHexadecimal.setEnabled(true);
			break;
		}
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e){
            System.out.println("Erro na seleção do visual do sistema");
        }
		this.setSize(476, 175);
		this.setContentPane(getJContentPane());
		this.setTitle("Sistema de Numeração (números inteiros e não negativos)");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblAutor = new JLabel();
			lblAutor.setBounds(new java.awt.Rectangle(174,121,290,17));
			lblAutor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			lblAutor.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 10));
			lblAutor.setText("Leonardo Melo Santos - leonardomelosantos@gmail.com");
			lblTipoNumero = new JLabel();
			lblTipoNumero.setBounds(new java.awt.Rectangle(307,46,149,22));
			lblTipoNumero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			lblTipoNumero.setText("");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getTxtNumero(), null);
			jContentPane.add(getCmdBinario(), null);
			jContentPane.add(getCmdOctal(), null);
			jContentPane.add(getCmdDecimal(), null);
			jContentPane.add(getCmdHexadecimal(), null);
			jContentPane.add(lblTipoNumero, null);
			jContentPane.add(lblAutor, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes txtNumero	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNumero() {
		if (txtNumero == null) {
			txtNumero = new JTextField();
			txtNumero.setBounds(new java.awt.Rectangle(12,7,445,37));
			txtNumero.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
			txtNumero.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 18));
			txtNumero.setText("");
		}
		return txtNumero;
	}

	/**
	 * This method initializes cmdBinario	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCmdBinario() {
		if (cmdBinario == null) {
			cmdBinario = new JButton();
			cmdBinario.setText("para Binário");
			cmdBinario.setSize(new java.awt.Dimension(140,28));
			cmdBinario.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			cmdBinario.setLocation(new java.awt.Point(14,51));


			cmdBinario.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) throws NumberFormatException {
					
					try {
						Numeracao numeracao = new Numeracao();
						switch (tipoNumeracao) {
						case Numeracao.TIPO_ENTRADA_HEXADECIMAL:
							try {
								txtNumero.setText(numeracao.converteHexadecimalParaBinario(txtNumero.getText()));
								setarNumeracao(Numeracao.TIPO_ENTRADA_BINARIO);
							} catch (NumeroNaoHexadecimalException e1) {
								JOptionPane.showMessageDialog(null, e1.getMensagem(), "Atenção", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case Numeracao.TIPO_ENTRADA_DECIMAL:
							try {
								txtNumero.setText(numeracao.converteDecimalParaBinario(txtNumero.getText()));
								setarNumeracao(Numeracao.TIPO_ENTRADA_BINARIO);
							} catch (NumeroNaoDecimalException e1) {
								JOptionPane.showMessageDialog(null, e1.getMensagem(), "Atenção", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case Numeracao.TIPO_ENTRADA_OCTAL:
							try {
								txtNumero.setText(numeracao.converteOctalParaBinario(txtNumero.getText()));
								setarNumeracao(Numeracao.TIPO_ENTRADA_BINARIO);
							} catch (NumeroNaoOctalException e1) {
								JOptionPane.showMessageDialog(null, e1.getMensagem(), "Atenção", JOptionPane.WARNING_MESSAGE);
							}
							break;
						}
						numeracao = null;						
					} catch (NumeroVazioException nve) {
						// Faz nada
					}
				}
			});
		}
		return cmdBinario;
	}

	/**
	 * This method initializes cmdOctal	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCmdOctal() {
		if (cmdOctal == null) {
			cmdOctal = new JButton();
			cmdOctal.setText("para Octal");
			cmdOctal.setSize(new java.awt.Dimension(140,28));
			cmdOctal.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			cmdOctal.setLocation(new java.awt.Point(14,88));
			cmdOctal.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						Numeracao numeracao = new Numeracao();
						switch (tipoNumeracao) {
						case Numeracao.TIPO_ENTRADA_HEXADECIMAL:
							try {
								txtNumero.setText(numeracao.converteHexadecimalParaOctal(txtNumero.getText()));
								setarNumeracao(Numeracao.TIPO_ENTRADA_OCTAL);
							} catch (NumeroNaoHexadecimalException e1) {
								JOptionPane.showMessageDialog(null, e1.getMensagem(), "Atenção", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case Numeracao.TIPO_ENTRADA_BINARIO:
							try {
								txtNumero.setText(numeracao.converteBinarioParaOctal(txtNumero.getText()));
								setarNumeracao(Numeracao.TIPO_ENTRADA_OCTAL);
							} catch (NumeroNaoBinarioException e1) {
								JOptionPane.showMessageDialog(null, e1.getMensagem(), "Atenção", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case Numeracao.TIPO_ENTRADA_DECIMAL:
							try {
								txtNumero.setText(numeracao.converteDecimalParaOctal(txtNumero.getText()));
								setarNumeracao(Numeracao.TIPO_ENTRADA_OCTAL);
							} catch (NumeroNaoDecimalException e1) {
								JOptionPane.showMessageDialog(null, e1.getMensagem(), "Atenção", JOptionPane.WARNING_MESSAGE);
							}
							break;
						}
						
						numeracao = null;						
					} catch (NumeroVazioException nve) {
						
					}
				}
			});
		}
		return cmdOctal;
	}

	private JButton getCmdDecimal() {
		if (cmdDecimal == null) {
			cmdDecimal = new JButton();
			cmdDecimal.setText("para Decimal");
			cmdDecimal.setSize(new java.awt.Dimension(140,28));
			cmdDecimal.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			cmdDecimal.setLocation(new java.awt.Point(160,51));
			cmdDecimal.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					try {
						String retorno = new String();
						Numeracao numeracao = new Numeracao();
						switch (tipoNumeracao) {
						case Numeracao.TIPO_ENTRADA_HEXADECIMAL:
							try {
								retorno = Long.toString(numeracao.converteHexadecimalParaDecimal(txtNumero.getText()));
								txtNumero.setText(retorno);
								setarNumeracao(Numeracao.TIPO_ENTRADA_DECIMAL);
							} catch (NumeroNaoHexadecimalException e1) {
								JOptionPane.showMessageDialog(null, e1.getMensagem(), "Atenção", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case Numeracao.TIPO_ENTRADA_BINARIO:
							try {
								retorno = Long.toString(numeracao.converteBinarioParaDecimal(txtNumero.getText()));
								txtNumero.setText(retorno);
								setarNumeracao(Numeracao.TIPO_ENTRADA_DECIMAL);
							} catch (NumeroNaoBinarioException e1) {
								JOptionPane.showMessageDialog(null, e1.getMensagem(), "Atenção", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case Numeracao.TIPO_ENTRADA_OCTAL:
							try {
								retorno = Long.toString(numeracao.converteOctalParaDecimal(txtNumero.getText()));
								txtNumero.setText(retorno);
								setarNumeracao(Numeracao.TIPO_ENTRADA_DECIMAL);
							} catch (NumeroNaoOctalException e1) {
								JOptionPane.showMessageDialog(null, e1.getMensagem(), "Atenção", JOptionPane.WARNING_MESSAGE);
							}
							break;
						}
						numeracao = null;						
					} catch (NumeroVazioException nve) {
						
					}
				}
			});
		}
		return cmdDecimal;
	}

	private JButton getCmdHexadecimal() {
		if (cmdHexadecimal == null) {
			cmdHexadecimal = new JButton();
			cmdHexadecimal.setText("para Hexadecimal");
			cmdHexadecimal.setSize(new java.awt.Dimension(140,28));
			cmdHexadecimal.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 12));
			cmdHexadecimal.setLocation(new java.awt.Point(160,88));
			cmdHexadecimal.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					try {
						String retorno = new String();
						Numeracao numeracao = new Numeracao();
						switch (tipoNumeracao) {
						case Numeracao.TIPO_ENTRADA_OCTAL:
							try {
								retorno = numeracao.converteOctalParaHexadecimal(txtNumero.getText());
								txtNumero.setText(retorno);
								setarNumeracao(Numeracao.TIPO_ENTRADA_HEXADECIMAL);
							} catch (NumeroNaoOctalException e1) {
								JOptionPane.showMessageDialog(null, e1.getMensagem(), "Atenção", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case Numeracao.TIPO_ENTRADA_BINARIO:
							try {
								retorno = numeracao.converteBinarioParaHexadecimal(txtNumero.getText());
								txtNumero.setText(retorno);
								setarNumeracao(Numeracao.TIPO_ENTRADA_HEXADECIMAL);
							} catch (NumeroNaoBinarioException e1) {
								JOptionPane.showMessageDialog(null, e1.getMensagem(), "Atenção", JOptionPane.WARNING_MESSAGE);
							}
							break;
						case Numeracao.TIPO_ENTRADA_DECIMAL:
							try {
								retorno = numeracao.converteDecimalParaHexadecimal(txtNumero.getText());
								txtNumero.setText(retorno);
								setarNumeracao(Numeracao.TIPO_ENTRADA_HEXADECIMAL);
							} catch (NumeroNaoDecimalException e1) {
								JOptionPane.showMessageDialog(null, e1.getMensagem(), "Atenção", JOptionPane.WARNING_MESSAGE);
							}
							break;
						}
						numeracao = null;
					} catch (NumeroVazioException nve) {
						// Faz nada
					}
				}
			});
		}
		return cmdHexadecimal;
	}

}
