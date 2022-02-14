package Views;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.Border;

import Controllers.PolynomController;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Interface {

	private JFrame frame;
	private JTextField polinom1;
	private JTextField polinom2;
	private JTextField RezultatText;
	private PolynomController Controller;
	private JButton butonIntegrare;
	private JButton butonInmultire;
	private JButton butonAdunare;
	private JButton butonScadere;
	private JButton butonImpartire;
	private JButton butonDerivare;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
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
	public Interface() {
		Controller = new PolynomController(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CALCULATOR OPERATII POLINOAME");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Nirmala UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(153, 10, 368, 57);
		frame.getContentPane().add(lblNewLabel_1);
		
		butonAdunare = new JButton("Adunare");

		butonAdunare.setBackground(Color.BLACK);
		butonAdunare.setForeground(UIManager.getColor("desktop"));
		butonAdunare.setFont(new Font("Tahoma", Font.BOLD, 15));
		butonAdunare.setBounds(54, 276, 202, 44);
		frame.getContentPane().add(butonAdunare);
		
		butonInmultire = new JButton("Inmultire");
		butonInmultire.setBackground(Color.BLACK);
		butonInmultire.setForeground(UIManager.getColor("desktop"));
		butonInmultire.setFont(new Font("Tahoma", Font.BOLD, 15));
		butonInmultire.setBounds(54, 345, 202, 44);
		frame.getContentPane().add(butonInmultire);
		
		butonIntegrare = new JButton("Integrare Polinom 1");
		butonIntegrare.setBackground(Color.BLACK);
		butonIntegrare.setForeground(Color.WHITE);
		butonIntegrare.setFont(new Font("Tahoma", Font.BOLD, 15));
		butonIntegrare.setBounds(54, 412, 202, 45);
		frame.getContentPane().add(butonIntegrare);
		
		butonScadere = new JButton("Scadere");
		butonScadere.setForeground(Color.WHITE);
		butonScadere.setBackground(Color.BLACK);
		butonScadere.setFont(new Font("Tahoma", Font.BOLD, 15));
		butonScadere.setBounds(377, 276, 202, 44);
		frame.getContentPane().add(butonScadere);
		
		butonImpartire = new JButton("Impartire");
		butonImpartire.setForeground(Color.WHITE);
		butonImpartire.setBackground(Color.BLACK);
		butonImpartire.setFont(new Font("Tahoma", Font.BOLD, 15));
		butonImpartire.setBounds(377, 345, 202, 44);
		frame.getContentPane().add(butonImpartire);
		
		butonDerivare = new JButton("Derivare Polinom 1");
		butonDerivare.setForeground(Color.WHITE);
		butonDerivare.setBackground(Color.BLACK);
		butonDerivare.setFont(new Font("Tahoma", Font.BOLD, 15));
		butonDerivare.setBounds(375, 412, 204, 44);
		frame.getContentPane().add(butonDerivare);
		
		polinom1 = new JTextField();
		polinom1.setFont(new Font("Tahoma", Font.BOLD, 15));
		polinom1.setBounds(250, 97, 271, 33);
		frame.getContentPane().add(polinom1);
		polinom1.setColumns(10);
		
		polinom2 = new JTextField();
		polinom2.setFont(new Font("Tahoma", Font.BOLD, 15));
		polinom2.setBounds(250, 140, 271, 33);
		frame.getContentPane().add(polinom2);
		polinom2.setColumns(10);
		
		RezultatText = new JTextField();
		RezultatText.setFont(new Font("Tahoma", Font.BOLD, 15));
		RezultatText.setForeground(Color.BLACK);
		RezultatText.setBounds(250, 183, 271, 33);
		frame.getContentPane().add(RezultatText);
		RezultatText.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Polinom 1");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(137, 95, 83, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Polinom 2");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(137, 143, 83, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rezultat");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(137, 186, 66, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Alege operatia:");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBackground(new Color(255, 0, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(250, 239, 174, 27);
		frame.getContentPane().add(lblNewLabel_4);
		frame.setBounds(100, 100, 657, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Border b  = BorderFactory.createLineBorder(Color.BLACK, 6);
        // set the border of this component
		((JPanel) frame.getContentPane()).setBorder(b);
		AddListeners();
		
		
	}
	public void Afisare(String Text)
	{
		RezultatText.setText(Text);
	}
	private void AddListeners()
	{
		butonAdunare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.OnAdunare(polinom1.getText(), polinom2.getText());
			}
		});	
		
		butonScadere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.OnScadere(polinom1.getText(), polinom2.getText());
			}
		});		
		butonInmultire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.OnInmultire(polinom1.getText(), polinom2.getText());
			}
		});	
		butonImpartire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.OnImpartire(polinom1.getText(), polinom2.getText());
			}
		});	
		butonDerivare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.OnDerivare(polinom1.getText());
			}
		});
		butonIntegrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.OnIntegrare(polinom1.getText());
			}
		});	
	}
}
