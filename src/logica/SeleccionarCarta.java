package logica;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import dominio.Carta;

public class SeleccionarCarta extends JFrame {
	SistemaImpl sistem;
	ArrayList<Carta> listaCartas;
	private String tipoSelection;
	private CalculadorPoder  calc = new CalculadorPoder();
	public SeleccionarCarta(SistemaImpl sistem,String tipo) {
		this.sistem = sistem;
		listaCartas = sistem.getCarta();
		tipoSelection =tipo;
		configurarVentana();
		iniciar();
	}
	
	private void configurarVentana() {
		setTitle("Seleccionar Carta");
		setSize(600,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);
	}
	
	private void iniciar() {

		
		JPanel gridPanel = new JPanel(new GridLayout(listaCartas.size(),1,5,5)) ;
		JLabel titulo = new JLabel("===== Seleccionar Carta =====", SwingConstants.CENTER);
		// Cambiar por datos de la carta
		for (int i = 0; i < listaCartas.size(); i++) {
			Carta carta = listaCartas.get(i);
			JPanel contenedor = new JPanel(new BorderLayout());
			JLabel imagen = imagen("Cartas/"+carta.getNombre()+".jpg");
			JLabel texto = new JLabel(carta.getNombre()+"| Rareza: "+carta.getRareza()+"| Tipo de Carta: "+carta.getTipo()+"| Poder: "+carta.accept(calc));
			JButton boton = crearBoton(carta);
			contenedor.add(imagen,BorderLayout.WEST);
			contenedor.add(texto,BorderLayout.CENTER);
			contenedor.add(boton,BorderLayout.EAST);
			gridPanel.add(contenedor);
		}
		JScrollPane scrollPane = new JScrollPane(gridPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(titulo,BorderLayout.NORTH);
		
		add(scrollPane,BorderLayout.CENTER);
		
		
	}
	
	private JLabel  imagen(String nombreCarta) {
		ImageIcon imagenOriginal = new ImageIcon(nombreCarta);
		Image imagen = imagenOriginal.getImage();
		Image escalado = imagen.getScaledInstance(50, 70, 0);
		ImageIcon imagenFinal = new ImageIcon(escalado);
		
		JLabel label = new JLabel(imagenFinal);
		
		return label;
	}
	
	private JButton crearBoton(Carta carta) {
		JButton b = new JButton("Seleccionar");
		b.addActionListener(e->{
			if (tipoSelection.equalsIgnoreCase("Eliminar")) {
				sistem.listaCartas.remove(carta);
				JOptionPane.showMessageDialog(this, "Carta Eliminada, Recarge la pagina para verlo reflejado.");
			}
			else if (tipoSelection.equalsIgnoreCase("Modificar")) {
			 new ModificarCarta(carta.getTipo(),carta);
			}
		});
		return b;
	}
	
}
