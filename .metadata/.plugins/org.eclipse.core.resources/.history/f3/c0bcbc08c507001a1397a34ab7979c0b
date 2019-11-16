package grafica;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica.Fichero;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.Dimension;
public class Top5GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTop;
	private JFrame aux;
	private JTable table;



	public Top5GUI(JFrame principal) {
		Fichero datos = new Fichero();
		datos.leer();
		aux=this;
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		txtTop = new JTextField();
		txtTop.setBorder(null);
		txtTop.setHorizontalAlignment(SwingConstants.CENTER);
		txtTop.setBackground(Color.BLACK);
		txtTop.setForeground(Color.RED);
		txtTop.setFont(new Font("Arial Black", Font.BOLD, 25));
		txtTop.setText("TOP 5");
		txtTop.setBounds(170, 300, 700, 40);
		contentPane.add(txtTop);
		txtTop.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		
		btnNewButton.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				if(e.getSource().equals(btnNewButton)) {
					principal.setVisible(true);
					aux.setVisible(false);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(Top5GUI.class.getResource("/img/pantallaprincipal/back-navigational-arrow-button-pointing-to-left.png")));
		btnNewButton.setBounds(10, 427, 44, 33);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ConfiguracionGUI.class.getResource("/img/pantallaprincipal/Fix-It-Felix-Jr-PNG-Pic.png")));
		label.setBounds(144, 10, 800, 300);
		contentPane.add(label);
		
		table = new JTable();
		table.setShowGrid(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFont(new Font("Arial Black", Font.BOLD, 24));
		table.setForeground(Color.RED);
		table.setBorder(null);
		table.setRowHeight(50);
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{datos.getNombres()[0], datos.getPuntos()[0]},
				{datos.getNombres()[1], datos.getPuntos()[1]},
				{datos.getNombres()[2], datos.getPuntos()[2]},
				{datos.getNombres()[3], datos.getPuntos()[3]},
				{datos.getNombres()[4], datos.getPuntos()[4]},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setBackground(Color.BLACK);
		table.setBounds(170, 351, 700, 249);
		contentPane.add(table);
	}
		
}

