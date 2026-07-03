package logica;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui {
	
	public void menuPrincipa() {
		JFrame ventana = new JFrame("Menu principal");
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ventana.setSize(230, 350);
		ventana.setLocationRelativeTo(null);
		
		ventana.setContentPane(new ImageBackgroundPanel("rndomImages/backCard.jpg"));
		
		ventana.getContentPane().add(createGui(ventana));
		
		ventana.setVisible(true);

	}
	
	private JPanel createGui(JFrame ventana) {
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
//		JLabel imagen = imagenPrincipal();
		JPanel botonera = new JPanel();
		
		botonera.setLayout(new BoxLayout(botonera, BoxLayout.LINE_AXIS));
		
		JButton boton1 = adminButton(ventana);
		JButton boton2 = analisisButton();
		
		botonera.add(boton1);
		botonera.add(boton2);
		mainPanel.add(botonera, BorderLayout.SOUTH);
		
		return mainPanel;
	}
	
	private JButton adminButton(JFrame v) {
		JButton b = new JButton("Menú Admin");
		
		b.addActionListener(e ->{

			GuiAdmin a = new GuiAdmin();
			a.createGuiAdmin();

		});
		
		return b;
	}
	private JButton analisisButton() {
		JButton b = new JButton("Menú Análisis");
		b.addActionListener(e ->{
			
		});
		
		return b;
	}
	
//	private JLabel imagenPrincipal() {
//		ImageIcon imagenOriginal = new ImageIcon("rndomImages/backCard.jpg");
//		Image imagen = imagenOriginal.getImage();
//		Image escalado = imagen.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
//		ImageIcon imagenFinal = new ImageIcon(escalado);
//		
//		JLabel label = new JLabel(imagenFinal);
//		
//		return label;
//	}
	
	
}
 
