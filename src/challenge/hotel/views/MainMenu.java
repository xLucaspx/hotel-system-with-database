package challenge.hotel.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane, panel1, header, exitButton, loginButton;
	private Panel panel;
	private JLabel bgImageLabel, logoLabel, creditLabel, exitLabel, loginImageLabel, titleLabel;

	private int mouseX, mouseY;

	public MainMenu() {
		super("White Lotus Hotel");
		setBounds(100, 100, 910, 537);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/img/logo/logo-40px.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		panel = new Panel();
		panel.setBounds(0, 0, 910, 537);
		panel.setBackground(SystemColor.window);
		panel.setLayout(null);

		contentPane.add(panel);

		bgImageLabel = new JLabel(new ImageIcon(MainMenu.class.getResource("/img/menu/menu-img.png")));
		bgImageLabel.setBounds(-50, 0, 732, 501);

		panel.add(bgImageLabel);

		logoLabel = new JLabel(new ImageIcon(MainMenu.class.getResource("/img/logo/logo-150px.png")));
		logoLabel.setBounds(722, 80, 150, 156);

		panel.add(logoLabel);

		panel1 = new JPanel();
		panel1.setBounds(0, 500, 910, 37);
		panel1.setBackground(new Color(12, 138, 199));
		panel1.setLayout(null);

		panel.add(panel1);

		creditLabel = new JLabel("Desenvolvido por Lucas da Paz © 2022");
		creditLabel.setBounds(315, 11, 301, 19);
		creditLabel.setForeground(new Color(240, 248, 255));
		creditLabel.setFont(new Font("Roboto", Font.PLAIN, 16));

		panel1.add(creditLabel);

		loginButton = new JPanel();
		loginButton.setBounds(754, 300, 83, 70);
		loginButton.setBackground(SystemColor.window);
		loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginButton.setLayout(null);

		panel.add(loginButton);

		loginImageLabel = new JLabel(new ImageIcon(MainMenu.class.getResource("/img/login/login-img.png")),
				SwingConstants.CENTER);
		loginImageLabel.setBounds(0, 0, 80, 70);

		loginButton.add(loginImageLabel);

		header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.setBackground(Color.WHITE);
		header.setLayout(null);

		panel.add(header);

		exitButton = new JPanel();
		exitButton.setBounds(857, 0, 53, 36);
		exitButton.setBackground(Color.WHITE);
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitButton.setLayout(null);

		header.add(exitButton);

		exitLabel = new JLabel("X", SwingConstants.CENTER);
		exitLabel.setBounds(0, 0, 53, 36);
		exitLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

		exitButton.add(exitLabel);

		titleLabel = new JLabel("Login", SwingConstants.CENTER);
		titleLabel.setBounds(754, 265, 83, 24);
		titleLabel.setBackground(SystemColor.window);
		titleLabel.setForeground(SystemColor.textHighlight);
		titleLabel.setFont(new Font("Roboto Light", Font.PLAIN, 20));

		panel.add(titleLabel);

		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});

		header.addMouseMotionListener(new MouseMotionAdapter() {
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

		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
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
