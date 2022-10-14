package challenge.hotel.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane, panel, panel1, loginButton, header, exitButton;
	private JLabel bgImageLabel, logoLabel, userLabel, passwordLabel, loginLabel, exitLabel, titleLabel;
	private JTextField userField;
	private JPasswordField passwordField;
	private JSeparator separator, separator1;

	private int mouseX, mouseY;

	public Login() {
		super("White Lotus - Login");
		setBounds(100, 100, 788, 527);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/img/logo/logo-40px.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBounds(0, 0, 788, 527);
		panel.setBackground(SystemColor.window);
		panel.setLayout(null);

		contentPane.add(panel);

		panel1 = new JPanel();
		panel1.setBounds(484, 0, 304, 527);
		panel1.setBackground(new Color(12, 138, 199));
		panel1.setLayout(null);

		panel.add(panel1);

		bgImageLabel = new JLabel(new ImageIcon(Login.class.getResource("/img/login/hotel-login.png")));
		bgImageLabel.setBounds(0, 0, 304, 538);

		panel1.add(bgImageLabel);

		logoLabel = new JLabel(new ImageIcon(Login.class.getResource("/img/logo/logo-50px.png")));
		logoLabel.setBounds(65, 65, 48, 59);

		panel.add(logoLabel);

		userField = new JTextField("Email ou nome de usuário", 10);
		userField.setBounds(65, 256, 324, 32);
		userField.setBorder(BorderFactory.createEmptyBorder());
		userField.setForeground(SystemColor.activeCaptionBorder);
		userField.setFont(new Font("Roboto", Font.PLAIN, 16));

		panel.add(userField);

		userLabel = new JLabel("Usuário");
		userLabel.setBounds(65, 219, 107, 26);
		userLabel.setForeground(SystemColor.textInactiveText);
		userLabel.setFont(new Font("Roboto Black", Font.PLAIN, 20));

		panel.add(userLabel);

		passwordField = new JPasswordField("********");
		passwordField.setBounds(65, 353, 324, 32);
		passwordField.setBorder(BorderFactory.createEmptyBorder());
		passwordField.setForeground(SystemColor.activeCaptionBorder);
		passwordField.setFont(new Font("Roboto", Font.PLAIN, 16));

		panel.add(passwordField);

		passwordLabel = new JLabel("Senha");
		passwordLabel.setBounds(65, 316, 140, 26);
		passwordLabel.setForeground(SystemColor.textInactiveText);
		passwordLabel.setFont(new Font("Roboto Black", Font.PLAIN, 20));

		panel.add(passwordLabel);

		separator = new JSeparator();
		separator.setBounds(65, 292, 324, 2);
		separator.setBackground(new Color(0, 120, 215));

		panel.add(separator);

		separator1 = new JSeparator();
		separator.setBounds(65, 393, 324, 2);
		separator1.setBackground(SystemColor.textHighlight);

		panel.add(separator1);

		loginButton = new JPanel();
		loginButton.setBounds(65, 431, 122, 44);
		loginButton.setBackground(SystemColor.textHighlight);
		loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginButton.setLayout(null);

		panel.add(loginButton);

		loginLabel = new JLabel("Entrar", SwingConstants.CENTER);
		loginLabel.setBounds(0, 0, 122, 44);
		loginLabel.setForeground(SystemColor.controlLtHighlight);
		loginLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

		loginButton.add(loginLabel);

		header = new JPanel();
		header.setBounds(0, 0, 784, 36);
		header.setBackground(SystemColor.window);
		header.setLayout(null);

		panel.add(header);

		exitButton = new JPanel();
		exitButton.setBounds(251, 0, 53, 36);
		exitButton.setBackground(new Color(12, 138, 199));
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitButton.setLayout(null);

		panel1.add(exitButton);

		exitLabel = new JLabel("X", SwingConstants.CENTER);
		exitLabel.setBounds(0, 0, 53, 36);
		exitLabel.setForeground(SystemColor.text);
		exitLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

		exitButton.add(exitLabel);

		titleLabel = new JLabel("Login");
		titleLabel.setBounds(196, 150, 89, 26);
		titleLabel.setForeground(SystemColor.textHighlight);
		titleLabel.setFont(new Font("Roboto Black", Font.PLAIN, 26));

		panel.add(titleLabel);

		userField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (userField.getText().equals("Email ou nome de usuário")) {
					userField.setText("");
					userField.setForeground(Color.BLACK);
				}

				if (String.valueOf(passwordField.getPassword()).isEmpty()) {
					passwordField.setText("********");
					passwordField.setForeground(SystemColor.activeCaptionBorder);
				}
			}
		});

		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(passwordField.getPassword()).equals("********")) {
					passwordField.setText("");
					passwordField.setForeground(Color.BLACK);
				}

				if (userField.getText().isEmpty()) {
					userField.setText("Email ou nome de usuário");
					userField.setForeground(SystemColor.activeCaptionBorder);
				}
			}
		});

		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginButton.setBackground(new Color(0, 156, 233));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				loginButton.setBackground(SystemColor.textHighlight);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				login();
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
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setBackground(new Color(12, 138, 199));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}

	private void login() {
		String inputtedUser = userField.getText();
		String inputtedPassword = new String(passwordField.getPassword());

		if (inputtedUser.equals("admin") && inputtedPassword.equals("admin")) {
			UserMenu userMenu = new UserMenu();
			userMenu.setVisible(true);
			dispose();

		} else {
			String message = "Usuário ou senha inválidos!";
			JOptionPane.showMessageDialog(this, message, "Atenção!", JOptionPane.WARNING_MESSAGE, null);
		}
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
