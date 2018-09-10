import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Window {

	private JFrame frame;
	private JTextField txtEnterANumber;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Converter converter = new Converter();
		
		frame = new JFrame("Base Converter");
		frame.getContentPane().setBackground(new Color(139, 0, 0));
		frame.getContentPane().setLayout(null);
		
		JLabel lblAndrewsBaseConverter = new JLabel("Andrew's Base Converter");
		lblAndrewsBaseConverter.setForeground(new Color(192, 192, 192));
		lblAndrewsBaseConverter.setVerticalAlignment(SwingConstants.TOP);
		lblAndrewsBaseConverter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAndrewsBaseConverter.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblAndrewsBaseConverter.setBackground(new Color(139, 0, 0));
		lblAndrewsBaseConverter.setBounds(12, 13, 408, 39);
		frame.getContentPane().add(lblAndrewsBaseConverter);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"}));
		comboBox.setSelectedIndex(8);
		comboBox.setBounds(120, 65, 66, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblBaseBase = new JLabel("Base base");
		lblBaseBase.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBaseBase.setForeground(new Color(192, 192, 192));
		lblBaseBase.setBounds(38, 65, 84, 22);
		frame.getContentPane().add(lblBaseBase);
		
		JLabel lblNewBase = new JLabel("New base");
		lblNewBase.setForeground(Color.LIGHT_GRAY);
		lblNewBase.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewBase.setBounds(38, 90, 84, 22);
		frame.getContentPane().add(lblNewBase);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(120, 92, 66, 22);
		frame.getContentPane().add(comboBox_1);
		
		txtEnterANumber = new JTextField();
		if (txtEnterANumber.getText().isEmpty()) {
            txtEnterANumber.setForeground(Color.GRAY);
            txtEnterANumber.setText("Number to convert");
        }
		txtEnterANumber.setBounds(229, 65, 154, 22);
		txtEnterANumber.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (txtEnterANumber.getText().equals("Number to convert")) {
		            txtEnterANumber.setText("");
		            txtEnterANumber.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (txtEnterANumber.getText().isEmpty()) {
		            txtEnterANumber.setForeground(Color.GRAY);
		            txtEnterANumber.setText("Number to convert");
		        }
		    }
		    });
		frame.getContentPane().add(txtEnterANumber);
		txtEnterANumber.setColumns(10);
		
		JButton btnConvert = new JButton("Convert!");
		btnConvert.setAction(action);
		btnConvert.setBounds(162, 127, 97, 25);
		frame.getContentPane().add(btnConvert);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(73, 165, 282, 62);
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					textPane.setText(converter.convert(Integer.parseInt((String)comboBox.getSelectedItem()),Integer.parseInt((String)comboBox_1.getSelectedItem()), txtEnterANumber.getText()));
				}catch (Exception e) {
					textPane.setText("Please input a number");
				}
			}
		});
		frame.getContentPane().add(textPane);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getRootPane().setDefaultButton(btnConvert);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Convert!");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
