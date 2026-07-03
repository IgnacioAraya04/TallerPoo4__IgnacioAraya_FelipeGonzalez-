package logica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SeleccionarCarta extends JFrame {
	ArrayList<String> listaCartas = new ArrayList<String>();
	public SeleccionarCarta() {
		configurarVentana();
		iniciar();
	}
	
	private void configurarVentana() {
		setTitle("Seleccionar Carta");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);
	}
	
	private void iniciar() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVisible(true);
		JPanel gridPanel = new JPanel(new GridLayout(20,1,5,5));		
		gridPanel.setVisible(true);

		for (int i = 0; i < 20; i++) {
			JPanel contenedor = new JPanel(new BorderLayout());
			JLabel imagen = imagen("rndomImage/backCard");
			JLabel texto = new JLabel("blablabalblablabalblabalbalbal");
			JButton boton = crearBoton();
			contenedor.add(imagen,BorderLayout.WEST);
			contenedor.add(texto,BorderLayout.CENTER);
			contenedor.add(boton,BorderLayout.EAST);
			gridPanel.add(contenedor);
		}
		scrollPane.add(gridPanel);
		add(scrollPane);
		
		
	}
	
	private JLabel  imagen(String nombreCarta) {
		ImageIcon imagenOriginal = new ImageIcon(nombreCarta);
		Image imagen = imagenOriginal.getImage();
		Image escalado = imagen.getScaledInstance(50, 70, 0);
		ImageIcon imagenFinal = new ImageIcon(escalado);
		
		JLabel label = new JLabel(imagenFinal);
		
		return label;
	}
	
	private JButton crearBoton() {
		JButton b = new JButton("Seleccionar");
		b.addActionListener(e -> {
			
			
			
		});
		
		return b;
	}
	
}
