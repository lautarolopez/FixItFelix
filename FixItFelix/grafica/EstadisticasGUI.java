package grafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica.Fichero;

public class EstadisticasGUI extends JFrame {

	private JPanel contentPane;
	private JFrame aux;
	private JTextField txtEstadisticas;
	private JTable table;
	
	public EstadisticasGUI(JFrame principal) {
		aux=this;
		Fichero arch = new Fichero();
		arch.leerEstadisticas();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(10, 427, 44, 33);
		btnNewButton.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent e) {
				if(e.getSource().equals(btnNewButton)) {
					principal.setVisible(true);
					aux.dispose();
				}
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setIcon(new ImageIcon(Top5GUI.class.getResource("/img/pantallaprincipal/back-navigational-arrow-button-pointing-to-left.png")));
		contentPane.add(btnNewButton);
		
		txtEstadisticas = new JTextField();
		txtEstadisticas.setEditable(false);
		txtEstadisticas.setBackground(Color.BLACK);
		txtEstadisticas.setForeground(Color.RED);
		txtEstadisticas.setFont(new Font("Arial Black", Font.BOLD, 40));
		txtEstadisticas.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstadisticas.setText("ESTADISTICAS");
		txtEstadisticas.setBounds(231, 42, 696, 94);
		contentPane.add(txtEstadisticas);
		txtEstadisticas.setColumns(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Cantidad de veces que se ejecut\u00F3 la aplicaci\u00F3n", arch.getStats()[0]},
				{"Cantidad de veces que se presion\u00F3 el bot\u00F3n 'Quiero Jugar'", arch.getStats()[1]},
				{"Cantidad de personas que entraron a TOP SCORES", arch.getStats()[2]},
			},
			new String[] {
				"New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(280);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.setForeground(Color.RED);
		table.setFont(new Font("Arial Black", Font.BOLD, 16));
		table.setBackground(Color.BLACK);
		table.setBounds(100, 231, 910, 260);
		table.setRowHeight(50);
		contentPane.add(table);
	}
}
