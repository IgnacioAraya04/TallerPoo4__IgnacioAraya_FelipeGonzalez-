package logica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CrearCarta extends JFrame {
 	private JComboBox<String> comboTipodeCartaBox;
	private JLabel lblInput1, lblInput2, lblInput3, lblInput4;
	private JTextField txtInput1, txtInput2, txtInput3, txtInput4;
	private SistemaImpl sistem;
		
	public CrearCarta(SistemaImpl sistem) {
		this.sistem = sistem;
		configurarVentana();
		iniciar();
	}
	
	private void configurarVentana() {
		setTitle("Crear Carta Nueva");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(10, 10));
		setVisible(true);
	}
	
	private void iniciar() {
		
		JPanel panelFormulario = new JPanel(new GridLayout(6,2));
		panelFormulario.setBorder(BorderFactory.createTitledBorder("Crear Carta Nueva"));
		
		comboTipodeCartaBox = new JComboBox<>(new String[] {"Pokemon","Item","Supporter","Energy"});
		
		lblInput1 = new JLabel("Nombre:");
		txtInput1 = new JTextField();
	
		lblInput2 = new JLabel("Rareza:");
		txtInput2 = new JTextField();
		
		lblInput3 = new JLabel("Daño:");
		txtInput3 = new JTextField();
		
		lblInput4 = new JLabel("Cantidad de Energía");
		txtInput4 = new JTextField();
		
		JButton btnCrear = new JButton("Crear Carta");
		
		panelFormulario.add(new JLabel("Tipo de Carta"));
		panelFormulario.add(comboTipodeCartaBox);
		panelFormulario.add(lblInput1);
		panelFormulario.add(txtInput1);
		panelFormulario.add(lblInput2);
		panelFormulario.add(txtInput2);
		panelFormulario.add(lblInput3);
		panelFormulario.add(txtInput3);
		panelFormulario.add(lblInput4);
		panelFormulario.add(txtInput4);
		panelFormulario.add(new JLabel(""));
		panelFormulario.add(btnCrear);
		
		add(panelFormulario,BorderLayout.CENTER);
		
		JLabel gif = imagenPrincipal();
		add(gif,BorderLayout.EAST);
		
		
		configurarEventos(btnCrear);
	}
	
	private void configurarEventos(JButton btnCrear) {
		comboTipodeCartaBox.addItemListener(e ->{
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String seleccionado = (String) comboTipodeCartaBox.getSelectedItem();
				txtInput1.setText("");
				txtInput2.setText("");
				txtInput3.setText("");
				txtInput4.setText("");
				
				switch (seleccionado) {
				case "Pokemon":
					lblInput1.setText("Nombre:");
					lblInput2.setText("Rareza:");
					lblInput3.setText("Daño");
					lblInput4.setVisible(true);
					lblInput4.setText("Cantidad de Energía");
					txtInput4.setVisible(true);
					break;
				case "Item":
					lblInput1.setText("Nombre:");
					lblInput2.setText("Rareza:");
					lblInput3.setText("Bonifiación");
					lblInput4.setVisible(false);
					lblInput4.setText("");
					txtInput4.setVisible(false);
					break;
				case "Supporter":
					lblInput1.setText("Nombre:");
					lblInput2.setText("Rareza:");
					lblInput3.setText("Efectos por Turnos");
					lblInput4.setVisible(false);
					lblInput4.setText("");
					txtInput4.setVisible(false);
					break;
				case "Energy":
					lblInput1.setText("Nombre:");
					lblInput2.setText("Rareza:");
					lblInput3.setText("Elemento");
					lblInput4.setVisible(false);
					lblInput4.setText("");
					txtInput4.setVisible(false);
					break;				
				}
			}	
		});
		
		btnCrear.addActionListener(e->{
			try {
				String tipo = (String) comboTipodeCartaBox.getSelectedItem();
				String nombre = txtInput1.getText();
				String rareza = txtInput2.getText();
				
				
				if (tipo.equalsIgnoreCase("Pokemon")) {
					String daño = txtInput3.getText();
					String cantEnergia = txtInput4.getText();
					String linea = nombre+";"+rareza+";"+tipo+";"+daño+";"+cantEnergia;
					
					sistem.AgregarCarta(linea);
				}
				else if (tipo.equalsIgnoreCase("Item")) {
					String especial = txtInput3.getText();
					String linea = nombre+";"+rareza+";"+tipo+";"+especial;
					
					sistem.AgregarCarta(linea);
				}
				else if (tipo.equalsIgnoreCase("Supporter")) {
					String especial = txtInput3.getText();
					String linea = nombre+";"+rareza+";"+tipo+";"+especial;
					
					sistem.AgregarCarta(linea);
				}
				else if (tipo.equalsIgnoreCase("Energy")) {
					String especial = txtInput3.getText();
					String linea = nombre+";"+rareza+";"+tipo+";"+especial;
					
					sistem.AgregarCarta(linea);
				}
				
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(this, "Por Favor ingrese valores válidos en los campos correspondientes");
		}
		
		
		
		});
	}
	
	private JLabel imagenPrincipal() {
		ImageIcon imagenOriginal = new ImageIcon("rndomImages/relax.gif");
		Image imagen = imagenOriginal.getImage();
		Image escalado = imagen.getScaledInstance(200, 250, 0);
		ImageIcon imagenFinal = new ImageIcon(escalado);
		
		JLabel label = new JLabel(imagenFinal);
		
		return label;
	}
}
