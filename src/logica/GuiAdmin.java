package logica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GuiAdmin {
	SistemaImpl sistem;
    private JComboBox<String> comboTipoTransporte;
	
	
	public void createGuiAdmin(SistemaImpl sistem) {
		this.sistem = sistem;
		
		JFrame ventana = new JFrame("Menu Admin");
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		ventana.setSize(220, 290);
		ventana.setLocationRelativeTo(null);
		
		ventana.setContentPane(new ImageBackgroundPanel("rndomImages/backgroundAdmin.png"));
		
		ventana.add(createGui());

		ventana.setVisible(true);

	}

	private JPanel createGui() {
		JPanel mainPanel = new JPanel(new BorderLayout());

		JPanel opcionesPanel = new JPanel(new GridBagLayout());
		
		JLabel titulo = new JLabel("----Menu Admin----", SwingConstants.CENTER);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.insets = new Insets(10, 0, 10, 0);
		gbc.fill = GridBagConstraints.NONE;
		

		JButton boton1 = agregarCarta();
		JButton boton2 = eliminarCarta();
		JButton boton3 = modificarCarta();
		
		gbc.gridy = 0;
		opcionesPanel.add(boton1, gbc);
		gbc.gridy = 1;
		opcionesPanel.add(boton2, gbc);
		gbc.gridy = 2;
		opcionesPanel.add(boton3, gbc);
		
		mainPanel.add(titulo,BorderLayout.NORTH);
		mainPanel.add(opcionesPanel, BorderLayout.CENTER);

		return mainPanel;
		
	
	}

	private JButton agregarCarta() {
		JButton b = new JButton("agregar carta");
		b.addActionListener(e -> {
			new CrearCarta(sistem);
		});

		return b;
	}

	private JButton eliminarCarta() {
		JButton b = new JButton("eliminar carta");
		b.addActionListener(e -> {
			new SeleccionarCarta(sistem);
		});

		return b;
	}

	private JButton modificarCarta() {
		JButton b = new JButton("modificar carta");
		b.addActionListener(e -> {

		});

		return b;
	}
	

}
