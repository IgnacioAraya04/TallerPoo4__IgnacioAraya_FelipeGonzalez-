package logica;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dominio.Carta;

public class ModificarCarta extends JFrame {
	private JComboBox<String> modificarCartaBox;
	private JLabel lblInput1,lblInput2;
	private JTextField txtInput1,txtInput2;
	private String tipo;
	private Carta carta;
	
	public ModificarCarta(String tipo, Carta carta) {
		this.tipo = tipo;
		this.carta = carta;
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
		JPanel panelFormulario = new JPanel(new GridLayout(4,2));
		panelFormulario.setBorder(BorderFactory.createTitledBorder("Modificar Carta"));
		modificarCartaBox = new JComboBox<>(new String[]{"Nombre","Rareza","Atributo Especial"});
		
		lblInput1 = new JLabel("Nombre nuevo:");
		txtInput1 = new JTextField();
		lblInput2 = new JLabel("Cantidad de Energia nuevo:");
		lblInput2.setVisible(false);
		txtInput2 = new JTextField();
		txtInput2.setVisible(false);
		
		JButton btn = new JButton("Modificar");
		
		panelFormulario.add(new JLabel("Que modificar ->"));
		panelFormulario.add(modificarCartaBox);
		panelFormulario.add(lblInput1);
		panelFormulario.add(txtInput1);
		panelFormulario.add(lblInput2);
		panelFormulario.add(txtInput2);
		panelFormulario.add(new JLabel(""));
		panelFormulario.add(btn);
		
		add(panelFormulario,BorderLayout.CENTER);
		
		configurarEventos(btn);
		
	}
	private void configurarEventos(JButton btn) {
		modificarCartaBox.addItemListener(e ->{
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String select = (String) modificarCartaBox.getSelectedItem();
				txtInput1.setText("");
				txtInput2.setText("");
				
				switch (select) {
				case "Nombre":
					lblInput1.setText("Nombre nuevo:");
					lblInput2.setVisible(false);
					txtInput2.setVisible(false);
					break;
				case "Rareza":
					lblInput1.setText("Rareza nueva:");
					lblInput2.setVisible(false);
					txtInput2.setVisible(false);
					break;
				case "Atributo Especial":
					if (tipo.equalsIgnoreCase("Pokemon")) {
						lblInput1.setText("Poder nuevo:");
						lblInput2.setVisible(true);
						txtInput2.setVisible(true);
						break;
					}
					else if (tipo.equalsIgnoreCase("Item")) {
						lblInput1.setText("Bonificación nueva:");
						lblInput2.setVisible(false);
						txtInput2.setVisible(false);
						break;
					}
					else if (tipo.equalsIgnoreCase("Supporter")) {
						lblInput1.setText("Efectos por turno nuevos:");
						lblInput2.setVisible(false);
						txtInput2.setVisible(false);
						break;
					}
					else if (tipo.equalsIgnoreCase("Energy")) {
						lblInput1.setText("Tipo de Energia nueva:");
						lblInput2.setVisible(false);
						txtInput2.setVisible(false);
						break;
					}
				default:
					break;
				}
			}
		});
	
		btn.addActionListener(e->{
			try {
				String tipoM = (String) modificarCartaBox.getSelectedItem();
				
				if (tipoM.equalsIgnoreCase("Nombre")) {
					String nombre = txtInput1.getText();
					carta.setNombre(nombre);
				}
				else if (tipoM.equalsIgnoreCase("Rareza")) {
					int rareza = Integer.valueOf(txtInput1.getText());
					carta.setRareza(rareza);
				}
				else if (tipoM.equalsIgnoreCase("Atributo Especial")) {
					if (tipo.equalsIgnoreCase("Pokemon")) {
						int daño = Integer.valueOf(txtInput1.getText());
						int cE = Integer.valueOf(txtInput2.getText());
						carta.setDaño(daño);
						carta.setCantidadEnergia(cE);
						
					}
					else if (tipo.equalsIgnoreCase("Item")) {
						int bonificacion = Integer.valueOf(lblInput1.getText());
						carta.setBonificacion(bonificacion);
					}
					else if (tipo.equalsIgnoreCase("Supporter")) {
						int efect = Integer.valueOf(lblInput1.getText());
						carta.setEfectorPorTurno(efect);
					}
					else if (tipo.equalsIgnoreCase("Energy")) {
						String energy = lblInput1.getText();
						carta.setElemento(energy);
					}
					
				}
			
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Por Favor ingrese valores válidos en los campos correspondientes");
			}
			
			
			
		});
		
		
	}
}
