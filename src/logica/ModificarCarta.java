package logica;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dominio.Carta;

/**
 * Ventana que dependiendo el tipo de carta entregada, pregurna al usuario por la modificacion de un atributo de la carta
 */
public class ModificarCarta extends JDialog {
	
	/**
	 * Constructor de la clase
	 * @param carta La carta a modificar
	 */
	public ModificarCarta(Carta carta) {
		iniciar(carta);
		
	}
	
	/**
	 * Metodo que inicia los componentes de la ventana, selecciona cuales y como mostrarlos de acuerdo al tipo
	 * de carta y activa el evento al precionar un boton para guardar las modificaciones hechas a las cartas
	 * 
	 * @param carta
	 */
	private void iniciar(Carta carta) {
		
		JTextField txtfield = new JTextField("");
		JTextField txtfield2 = new JTextField("");
		JLabel lblfield = new JLabel("");
		JLabel lblfield2 = new JLabel("Nueva Cantidad de Energia");
		JButton btn = new JButton("Guardar");
		
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		
		add(lblfield);
		add(txtfield);
		add(lblfield2);
		add(txtfield2);
		add(btn);
		
		
		switch (carta.getTipo()) {
		case "Pokemon":
			lblfield.setText("Nuevo Daño");
			lblfield2.setVisible(true);
			txtfield2.setVisible(true);

			break;
		case "Item":
			lblfield.setText("Nueva Bonificación");
			lblfield2.setVisible(false);
			txtfield2.setVisible(false);
			break;
		case "Supporter":
			lblfield.setText("Nuevos Efectos por Turno");
			lblfield2.setVisible(false);
			txtfield2.setVisible(false);
			break;
		case "Energy":
			lblfield.setText("Nuevo Elemento");
			lblfield2.setVisible(false);
			txtfield2.setVisible(false);
			
			break;
		
		}
		btn.addActionListener(e -> {
			try {
				String tipo = carta.getTipo();
				
				if (tipo.equalsIgnoreCase("Pokemon")) {
					int daño = Integer.valueOf(txtfield.getText());
					int cE = Integer.valueOf(txtfield2.getText());
					carta.setDaño(daño);
					carta.setCantidadEnergia(cE);
					
				}
				else if (tipo.equalsIgnoreCase("Item")) {
					int bonificacion = Integer.valueOf(txtfield.getText());
					carta.setBonificacion(bonificacion);
				}
				else if (tipo.equalsIgnoreCase("Supporter")) {
					int efect = Integer.valueOf(txtfield.getText());
					carta.setEfectorPorTurno(efect);
				}
				else if (tipo.equalsIgnoreCase("Energy")) {
					String energy = txtfield.getText();
					carta.setElemento(energy);
				}
				
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Por Favor ingrese valores válidos en los campos correspondientes");
			}
			JOptionPane.showMessageDialog(this, "Carta Modificada Con Exito, Reinicie la ventana para ver los efectos reflejados :D");
			getOwner().dispose();
			
		});
		
	}
	
	/**
	 * Metodo que se encarga de mostrar el dialogo y su posicion relativa
	 */
	public void showDialog() {
		pack();
		setLocationRelativeTo(getParent());
		
		setVisible(true);
	}
}
