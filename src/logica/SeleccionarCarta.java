package logica;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dominio.Carta;

/**
 * Clase que se encarga de instanciar una ventana que selecciona una carta de la coleccion para eliminar o modificar
 * dependiendo de la seleccion en el menu de administrador
 */
public class SeleccionarCarta extends JFrame {
	SistemaImpl sistem;
	ArrayList<Carta> listaCartas;
	private String tipoSelection;
	private CalculadorPoder  calc = new CalculadorPoder();
	
	/**
	 * Constructor de la clase
	 * 
	 * @param sistem Sistema en donde se encuentra la coleccion de cartas
	 * @param tipo Si se busca eliminar o modificar una carta
	 * 
	 */
	public SeleccionarCarta(SistemaImpl sistem,String tipo) {
		this.sistem = sistem;
		listaCartas = sistem.getCarta();
		tipoSelection =tipo;
		configurarVentana();
		iniciar();
	}
	
	/**
	 * Configuracion de la ventana
	 */
	private void configurarVentana() {
		setTitle("Seleccionar Carta");
		setSize(600,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);
	}
	
	/**
	 * Metodo que se encarga de iniciar los componentes de la ventana
	 */
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
	
	/**
 	 * Metodo que se encarga de cargar y escalar la imagen de la carta
 	 * 
 	 * @param nombreCarta Nombre de la carta para poder buscarla en los archivos
 	 * @return la imagen escalada
 	 */
	private JLabel  imagen(String nombreCarta) {
		ImageIcon imagenOriginal = new ImageIcon(nombreCarta);
		if (imagenOriginal.getIconWidth() == -1) {
			ImageIcon imagenDefault = new ImageIcon("rndomImages/backCard.jpg");
			Image imagen = imagenDefault.getImage();
			Image escalado = imagen.getScaledInstance(50, 70, 0);
			ImageIcon imagenFinal = new ImageIcon(escalado);
			
			
			JLabel label = new JLabel(imagenFinal);
			
			return label;
		}
		
		Image imagen = imagenOriginal.getImage();
		Image escalado = imagen.getScaledInstance(50, 70, 0);
		ImageIcon imagenFinal = new ImageIcon(escalado);
		
		
		JLabel label = new JLabel(imagenFinal);
		
		return label;
	}
	
	/**
	 * Metodo que instancia un boton que selecciona la carta deseada y envia al usuario a la ventana correspondiente 
	 * a lo que desea hacer (Eliminar o Modificar una carta)
	 * @param carta La carta seleccionada
	 * @return la instancia del boton creado
	 */
	private JButton crearBoton(Carta carta) {
		JButton b = new JButton("Seleccionar");
		b.addActionListener(e->{
			if (tipoSelection.equalsIgnoreCase("Eliminar")) {
				sistem.listaCartas.remove(carta);
				JOptionPane.showMessageDialog(this, "Carta Eliminada Con Exito");
				dispose();
			}
			else if (tipoSelection.equalsIgnoreCase("Modificar")) {
			 new ModificarCarta(carta).showDialog();
		
			 
			}
		});
		return b;
	}
	
	
}
