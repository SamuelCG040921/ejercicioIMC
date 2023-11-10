package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Logica;
import clases.PersonaVO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtPeso;
	private JTextField txtTalla;
	JTextArea areaTexto;
	JButton btnRegistrar,btnCalcularIMC,btnMostrarLista;
	Logica miLogica;

	public VentanaPrincipal() {
		miLogica = new Logica();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("CALCULAR IMC");
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTitulo.setBounds(249, 17, 118, 16);
		contentPane.add(lblTitulo);
		
		JLabel lblTitulo2 = new JLabel("Datos Basicos");
		lblTitulo2.setBounds(39, 36, 88, 16);
		contentPane.add(lblTitulo2);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblDocumento.setBounds(24, 64, 81, 16);
		contentPane.add(lblDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(93, 58, 107, 26);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(208, 63, 61, 16);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(264, 58, 130, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(403, 63, 61, 16);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(440, 58, 93, 26);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblTitulo3 = new JLabel("Datos IMC");
		lblTitulo3.setBounds(39, 96, 88, 16);
		contentPane.add(lblTitulo3);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblPeso.setBounds(24, 124, 36, 16);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(63, 118, 107, 26);
		contentPane.add(txtPeso);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblTalla.setBounds(196, 123, 36, 16);
		contentPane.add(lblTalla);
		
		txtTalla = new JTextField();
		txtTalla.setBounds(228, 118, 130, 26);
		contentPane.add(txtTalla);
		txtTalla.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(39, 183, 66, 16);
		contentPane.add(lblResultado);
		
		areaTexto=new JTextArea();
		areaTexto.setLineWrap(true);
		areaTexto.setText("Info");
		
		JScrollPane scrollArea = new JScrollPane();
		scrollArea.setViewportView(areaTexto);
		scrollArea.setBounds(36, 211, 497, 164);
		contentPane.add(scrollArea);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(73, 407, 117, 29);
		btnRegistrar.addActionListener(this);
		contentPane.add(btnRegistrar);
		
		btnCalcularIMC = new JButton("CalcularIMC");
		btnCalcularIMC.setBounds(241, 407, 117, 29);
		btnCalcularIMC.addActionListener(this);
		contentPane.add(btnCalcularIMC);
		
		btnMostrarLista = new JButton("Mostrar lista");
		btnMostrarLista.setBounds(403, 407, 117, 29);
		btnMostrarLista.addActionListener(this);
		contentPane.add(btnMostrarLista);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegistrar) {
			PersonaVO miPersona = new PersonaVO();
	
			miPersona.setDocumento(txtDocumento.getText());
			miPersona.setNombre(txtNombre.getText());
			miPersona.setEdad(Integer.parseInt(txtEdad.getText()));
			miPersona.setPeso(Double.parseDouble(txtPeso.getText()));
			miPersona.setTalla(Double.parseDouble(txtTalla.getText()));
			
			String res = miLogica.registrarPersona(miPersona);
			areaTexto.setText(res);
		}else if(e.getSource()==btnMostrarLista) {
			String resultado = miLogica.consultarListaPersonas();	
			areaTexto.setText(resultado);
		}else if(e.getSource()==btnCalcularIMC) {
			String res = miLogica.consultarPromedio();
			areaTexto.setText(res);
		}
		
	}
}
