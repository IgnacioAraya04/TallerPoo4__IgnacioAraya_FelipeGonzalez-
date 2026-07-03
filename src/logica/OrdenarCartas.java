package logica;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dominio.Carta;

public class OrdenarCartas extends JFrame{
 	private JComboBox<String> comboTipodeOrdenBox;
 	private ArrayList<Carta> listaCarta;
 	private SistemaImpl sistem;
 	private JPanel gridPanel1, gridPanel2, gridPanel3;
 	private JScrollPane scrollPaneRareza, scrollPaneNombre, scrollPanePoder;
 	private CardLayout cardLayout = new CardLayout();
 	private JPanel cardsPanel = new JPanel(cardLayout);
 	
 	public OrdenarCartas(SistemaImpl sistem) {
 		this.sistem = sistem ;
 		configurarVentana();
 		iniciar();
 	}
 	
 	private void configurarVentana() {
		setTitle("Ordenar Cartas");
		setSize(400,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);
	}
 	private void iniciar() {
 		
 		JPanel panelFormulario = new JPanel(new GridLayout(1,2));
 		panelFormulario.setBorder(BorderFactory.createTitledBorder("Ordenar Cartas"));
	
 		comboTipodeOrdenBox = new JComboBox<>(new String[] {"Rareza","Nombre","Poder"});
	
		panelFormulario.add(new JLabel("Seleccionar Orden por"));
		panelFormulario.add(comboTipodeOrdenBox);
		add(panelFormulario,BorderLayout.NORTH);
 		
 		gridPanel1 = new JPanel(new GridLayout(20,1,5,5));
 		//System ordenar por rareza antes de este de aca !!!
 		for (int i = 0; i < 20; i++) {
			JPanel contenedor = new JPanel(new BorderLayout());
			JLabel imagen = imagen("rndomImages/backCard.jpg");
			JLabel texto = new JLabel("Rareza");
			contenedor.add(imagen,BorderLayout.WEST);
			contenedor.add(texto,BorderLayout.CENTER);
			gridPanel1.add(contenedor);
 		}
 		
 		gridPanel2 = new JPanel(new GridLayout(50,1,5,5));
			for (int i = 0; i < 20; i++) {
				JPanel contenedor = new JPanel(new BorderLayout());
				JLabel imagen = imagen("rndomImages/backCard.jpg");
				JLabel texto = new JLabel("nombre");
				contenedor.add(imagen,BorderLayout.WEST);
				contenedor.add(texto,BorderLayout.CENTER);
				gridPanel2.add(contenedor);
			}
		
		gridPanel3 = new JPanel(new GridLayout(50,1,5,5));
			for (int i = 0; i < 20; i++) {
				JPanel contenedor = new JPanel(new BorderLayout());
				JLabel imagen = imagen("rndomImages/backCard.jpg");
				JLabel texto = new JLabel("Poder");
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
 	private JLabel  imagen(String nombreCarta) {
		ImageIcon imagenOriginal = new ImageIcon(nombreCarta);
		Image imagen = imagenOriginal.getImage();
		Image escalado = imagen.getScaledInstance(50, 70, 0);
		ImageIcon imagenFinal = new ImageIcon(escalado);
		
		JLabel label = new JLabel(imagenFinal);
		
		return label;
	}
}
