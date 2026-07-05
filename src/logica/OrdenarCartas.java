package logica;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dominio.Carta;

/**
 * Clase encargada de instanciar una ventana que contiene una lista de las cartas, se puede elejir como ordenar las
 * cartas por orden de poder, rareza o nombre
 */
public class OrdenarCartas extends JFrame{
 	private JComboBox<String> comboTipodeOrdenBox;
 	private ArrayList<Carta> listaCarta;
 	private SistemaImpl sistem;
 	private JPanel gridPanel1, gridPanel2, gridPanel3;
 	private JScrollPane scrollPaneRareza, scrollPaneNombre, scrollPanePoder;
 	private CardLayout cardLayout = new CardLayout();
 	private JPanel cardsPanel = new JPanel(cardLayout);
 	private CalculadorPoder calc = new CalculadorPoder();
 	
 	/**
 	 * Constructor de la clase 
 	 * @param sistem Instancia del sistema para obtener la coleccion de cartas para poder mostrarlas
 	 */
 	public OrdenarCartas(SistemaImpl sistem) {
 		this.sistem = sistem ;
 		listaCarta = sistem.getCarta();
 		configurarVentana();
 		iniciar();
 	}
 	
 	/**
 	 * Metodo para configurar la ventana
 	 */
 	private void configurarVentana() {
		setTitle("Ordenar Cartas");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);
	}
 	/**
 	 * Metodo que se encarga de inicializar los componentes de la ventana
 	 */
 	private void iniciar() {
 		
 		JPanel panelFormulario = new JPanel(new GridLayout(1,2));
 		panelFormulario.setBorder(BorderFactory.createTitledBorder("Ordenar Cartas"));
	
 		comboTipodeOrdenBox = new JComboBox<>(new String[] {"Rareza","Nombre","Poder"});
	
		panelFormulario.add(new JLabel("Seleccionar Orden por"));
		panelFormulario.add(comboTipodeOrdenBox);
		add(panelFormulario,BorderLayout.NORTH);
 		
 		gridPanel1 = new JPanel(new GridLayout(listaCarta.size(),1,5,5));
 		for (int i = 0; i < listaCarta.size(); i++) {
 			Carta carta = listaCarta.get(i);
 			JPanel contenedor = new JPanel(new BorderLayout());
			JLabel imagen = imagen("Cartas/"+carta.getNombre()+".jpg");
			if (imagen ==null) {
				imagen = imagen("rndomImages/backCard.jpg");
			}
			JLabel texto = new JLabel(carta.getNombre()+"| Rareza: "+carta.getRareza()+"| Tipo de Carta: "+carta.getTipo()+"| Poder: "+carta.accept(calc));
			contenedor.add(imagen,BorderLayout.WEST);
			contenedor.add(texto,BorderLayout.CENTER);
			gridPanel1.add(contenedor);
 		}
 		sistem.ordenPorName();
 		gridPanel2 = new JPanel(new GridLayout(listaCarta.size(),1,5,5));
			for (int i = 0; i < listaCarta.size(); i++) {
				Carta carta = listaCarta.get(i);
				JPanel contenedor = new JPanel(new BorderLayout());
				JLabel imagen = imagen("Cartas/"+carta.getNombre()+".jpg");
				if (imagen ==null) {
					imagen = imagen("rndomImages/backCard.jpg");
				}
				JLabel texto = new JLabel(carta.getNombre()+"| Rareza: "+carta.getRareza()+"| Tipo de Carta: "+carta.getTipo()+"| Poder: "+carta.accept(calc));
				contenedor.add(imagen,BorderLayout.WEST);
				contenedor.add(texto,BorderLayout.CENTER);
				gridPanel2.add(contenedor);
			}
		sistem.ordenPorPoder();
		gridPanel3 = new JPanel(new GridLayout(listaCarta.size(),1,5,5));
			for (int i = 0; i < listaCarta.size(); i++) {
				Carta carta = listaCarta.get(i);
				JPanel contenedor = new JPanel(new BorderLayout());
				JLabel imagen = imagen("Cartas/"+carta.getNombre()+".jpg");
				if (imagen == null) {
					imagen = imagen("rndomImages/backCard.jpg");
				}
				JLabel texto = new JLabel(carta.getNombre()+"| Rareza: "+carta.getRareza()+"| Tipo de Carta: "+carta.getTipo()+"| Poder: "+carta.accept(calc));
				contenedor.add(imagen,BorderLayout.WEST);
				contenedor.add(texto,BorderLayout.CENTER);
				gridPanel3.add(contenedor);
			}
 		
 		scrollPaneRareza = new JScrollPane(gridPanel1);
 		scrollPaneNombre = new JScrollPane(gridPanel2);
 		scrollPanePoder = new JScrollPane(gridPanel3);
		

 		cardsPanel.add(scrollPaneRareza, "Rareza");
 		cardsPanel.add(scrollPaneNombre, "Nombre");
 		cardsPanel.add(scrollPanePoder, "Poder");
 	
 		add(cardsPanel, BorderLayout.CENTER);

 		configurarEventos();
 		
 	}
 	/**
 	 * Metodo que se encarga de configurar los eventos de la ventana, dependiendo de la forma de ordenar,
 	 * mostrara una coleccion en distinto orden
 	 */
 	private void configurarEventos() {
 		comboTipodeOrdenBox.addItemListener(e ->{
 			if (e.getStateChange() == ItemEvent.SELECTED) {
				String seleccionado = (String) comboTipodeOrdenBox.getSelectedItem();
				switch (seleccionado) {
				case "Rareza":
					cardLayout.show(cardsPanel, seleccionado);
					break;
				case "Nombre":
					cardLayout.show(cardsPanel, seleccionado);
					break;
				case "Poder":
					cardLayout.show(cardsPanel, seleccionado);
					break;
				}
			}
 				
 		});
		
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
}
