package challenge.hotel.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UserMenu extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane, panel, searchButton, registerButton, datePanel, header, exitButton;
	private JLabel logoLabel, searchLabel, registerLabel, dateLabel, descriptionLabel1, descriptionLabel2,
			descriptionLabel3, descriptionLabel4, descriptionLabel5, titleLabel1, titleLabel2, exitLabel;
	private JSeparator separator;

	private LocalDate today;
	private DateTimeFormatter formatter;

	private String date, descriptionText1, descriptionText2;
	
	private int mouseX, mouseY;

	public UserMenu() {
		super("White Lotus Hotel");
		setBounds(100, 100, 944, 609);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserMenu.class.getResource("/img/logo/logo-40px.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);

		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBounds(0, 0, 257, 609);
		panel.setBackground(new Color(12, 138, 199));
		panel.setLayout(null);

		contentPane.add(panel);

		logoLabel = new JLabel(new ImageIcon(UserMenu.class.getResource("/img/logo/logo-150px.png")));
		logoLabel.setBounds(50, 58, 150, 150);

		panel.add(logoLabel);

		searchButton = new JPanel();
		searchButton.setBounds(0, 312, 257, 56);
		searchButton.setBackground(new Color(12, 138, 199));
		searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchButton.setLayout(null);

		panel.add(searchButton);

		searchLabel = new JLabel("Buscar", new ImageIcon(UserMenu.class.getResource("/img/icons/people-icon.png")),
				SwingConstants.LEFT);
		searchLabel.setBounds(25, 11, 205, 34);
		searchLabel.setForeground(Color.WHITE);
		searchLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

		searchButton.add(searchLabel);

		registerButton = new JPanel();
		registerButton.setBounds(0, 255, 257, 56);
		registerButton.setBackground(new Color(12, 138, 199));
		registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registerButton.setLayout(null);

		panel.add(registerButton);

		registerLabel = new JLabel("Registro de reservas",
				new ImageIcon(UserMenu.class.getResource("/img/icons/reserves-icon.png")), SwingConstants.LEFT);
		registerLabel.setBounds(25, 11, 205, 34);
		registerLabel.setForeground(SystemColor.text);
		registerLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

		registerButton.add(registerLabel);

		separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);

		panel.add(separator);

		datePanel = new JPanel();
		datePanel.setBounds(256, 84, 688, 121);
		datePanel.setBackground(new Color(118, 187, 223));
		datePanel.setLayout(null);

		contentPane.add(datePanel);

		today = LocalDate.now();
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		date = "Hoje é " + today.format(formatter);

		dateLabel = new JLabel(date);
		dateLabel.setBounds(40, 64, 294, 36);
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setFont(new Font("Roboto", Font.PLAIN, 33));

		datePanel.add(dateLabel);

		descriptionText1 = "<html><body>Sistema de reservas de hotéis: controle e gerencie de forma otimizada e fácil"
				+ "<br> o fluxo de reservas e hóspedes do hotel</body></html>";

		descriptionLabel1 = new JLabel(descriptionText1);
		descriptionLabel1.setBounds(300, 291, 598, 66);
		descriptionLabel1.setFont(new Font("Roboto", Font.PLAIN, 17));

		contentPane.add(descriptionLabel1);

		descriptionText2 = "<html><body>Esta ferramenta permite que você mantenha um controle completo e detalhado de suas reservas "
				+ "e hóspedes; você terá acesso a ferramentas especiais para tarefas específicas, como:</body></html>";

		descriptionLabel2 = new JLabel(descriptionText2);
		descriptionLabel2.setBounds(300, 345, 569, 88);
		descriptionLabel2.setFont(new Font("Roboto", Font.PLAIN, 17));

		contentPane.add(descriptionLabel2);

		descriptionLabel3 = new JLabel("• Registro de reservas e hóspedes;");
		descriptionLabel3.setBounds(310, 444, 295, 27);
		descriptionLabel3.setFont(new Font("Roboto", Font.PLAIN, 17));

		contentPane.add(descriptionLabel3);

		descriptionLabel4 = new JLabel("• Edição de reservas e hóspedes existentes;");
		descriptionLabel4.setBounds(310, 482, 355, 27);
		descriptionLabel4.setFont(new Font("Roboto", Font.PLAIN, 17));

		contentPane.add(descriptionLabel4);

		descriptionLabel5 = new JLabel("• Excluir todos os tipos de registros.");
		descriptionLabel5.setBounds(310, 520, 295, 27);
		descriptionLabel5.setFont(new Font("Roboto", Font.PLAIN, 17));

		contentPane.add(descriptionLabel5);
		
		header = new JPanel();
		header.setBounds(0, 0, 944, 36);
		header.setBackground(Color.WHITE);
		header.setLayout(null);
		
		contentPane.add(header);
		
		exitButton = new JPanel();
		exitButton.setBounds(891, 0, 53, 36);
		exitButton.setBackground(Color.WHITE);
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitButton.setLayout(null);
		
		header.add(exitButton);
		
		exitLabel = new JLabel("X", SwingConstants.CENTER);
		exitLabel.setBounds(0, 0, 53, 36);
		exitLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		exitButton.add(exitLabel);
		
		titleLabel1 = new JLabel("Controle de Reservas - White Lotus");
		titleLabel1.setBounds(40, 11, 395, 42);
		titleLabel1.setForeground(Color.WHITE);
		titleLabel1.setFont(new Font("Roboto", Font.PLAIN, 24));
		
		datePanel.add(titleLabel1);
		
		titleLabel2 = new JLabel("Bem-vindo(a)");
		titleLabel2.setBounds(300, 234, 157, 46);
		titleLabel2.setFont(new Font("Roboto", Font.BOLD, 24));
		
		contentPane.add(titleLabel2);
		
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				searchButton.setBackground(new Color(118, 187, 223));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				searchButton.setBackground(new Color(12, 138, 199));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Search search = new Search();
				search.setVisible(true);
				dispose();
			}
		});
		
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				registerButton.setBackground(new Color(118, 187, 223));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				registerButton.setBackground(new Color(12, 138, 199));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Reservations reservations = new Reservations();
				reservations.setVisible(true);
				dispose();
			}
		});
		
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});

		header.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			}
		});
		
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setBackground(Color.RED);
				exitLabel.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setBackground(Color.WHITE);
				exitLabel.setForeground(Color.BLACK);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void headerMousePressed(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	private void headerMouseDragged(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();

		this.setLocation(x - mouseX, y - mouseY);
	}
}
