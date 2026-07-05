package logica;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que muestra el gui principal, permite al usuario elegir entre el menu admin y el de colección
 */
public class Gui {
	SistemaImpl sistem;
	
	/**
	 * Metodo que instancia el frame de la nueva ventana y sus configuraciones
	 * @param sistem
	 */
	public void menuPrincipa(SistemaImpl sistem) {
		this.sistem = sistem;
		JFrame ventana = new JFrame("Menu principal");
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ventana.setSize(230, 350);
		ventana.setLocationRelativeTo(null);
		
		ventana.getContentPane().add(createGui(ventana));
		
		ventana.setVisible(true);

	}
	
	/**
	 * Metodo que agrega el resto de componentes a un panel principal para añadirlos a la ventana
	 * 
	 * @param ventana La ventana en la que se añaden el resto de componentes
	 * @return El panel principal que conteien el resto de componentes 
	 */
	private JPanel createGui(JFrame ventana) {
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		JLabel imagen = imagenPrincipal();
		JPanel botonera = new JPanel();
		
		botonera.setLayout(new BoxLayout(botonera, BoxLayout.LINE_AXIS));
		
		JButton boton1 = adminButton();
		JButton boton2 = colectionButton();
		
		botonera.add(boton1);
		botonera.add(boton2);
		mainPanel.add(botonera, BorderLayout.SOUTH);
		mainPanel.add(imagen,BorderLayout.NORTH);
		
		return mainPanel;
	}
	
	/**
	 * 
	 * Metodo para instanciar el boton que abre el menu de administrado
	 * @return la instancia de boton creada
	 */
	private JButton adminButton() {
		JButton b = new JButton("Menú Admin");
		
		b.addActionListener(e ->{

			GuiAdmin a = new GuiAdmin();
			a.createGuiAdmin(sistem);

		});
		
		return b;
	}
	/**
	 * Metodo que instancia un boton que abre el menu de coleccion
	 * 
	 * @return la instancia del boton
	 */
	private JButton colectionButton() {
		JButton b = new JButton("Colección");
		b.addActionListener(e ->{
			new OrdenarCartas(sistem);
		});
		
		return b;
	}
	
	/**
	 * Metodo que instancia una imagen que acompaña el menu, escalada para conveniencia
	 * 
	 * @return
	 */
	private JLabel imagenPrincipal() {
		ImageIcon imagenOriginal = new ImageIcon("rndomImages/backCard.jpg");
		Image imagen = imagenOriginal.getImage();
		Image escalado = imagen.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
		ImageIcon imagenFinal = new ImageIcon(escalado);
		
		JLabel label = new JLabel(imagenFinal);
		
		return label;
	}
	
	
}
 
