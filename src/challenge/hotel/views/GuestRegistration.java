package challenge.hotel.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import challenge.hotel.controller.GuestController;

public class GuestRegistration extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane, panel, saveButton, header, backButton, exitButton;
	private JLabel bgImageLabel, logoLabel, nameLabel, surnameLabel, birthLabel, nationalityLabel, phoneLabel,
			reservationIdLabel, saveLabel, backLabel, exitLabel, titleLabel;
	private JTextField nameField, surnameField, nationalityField, phoneField, reservationIdField;
	private JFormattedTextField birthField;
	private JSeparator separator, separator2, separator3, separator4, separator5, separator6;

	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");

	private int mouseX, mouseY;

	private GuestController guestController;

	public GuestRegistration(int reservationId) {
		super("Registro de hóspede");

		this.guestController = new GuestController();

		setBounds(100, 100, 910, 634);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(GuestRegistration.class.getResource("/img/logo/logo-40px.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.text);
		contentPane.setLayout(null);

		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBounds(0, 0, 489, 634);
		panel.setBackground(new Color(12, 138, 199));
		panel.setLayout(null);

		contentPane.add(panel);

		bgImageLabel = new JLabel(
				new ImageIcon(GuestRegistration.class.getResource("/img/registration/registration-img.png")));
		bgImageLabel.setBounds(0, 121, 479, 502);

		panel.add(bgImageLabel);

		logoLabel = new JLabel(new ImageIcon(GuestRegistration.class.getResource("/img/logo/logo-100px.png")));
		logoLabel.setBounds(194, 39, 104, 107);

		panel.add(logoLabel);

		nameField = new JTextField("Digite o nome do hóspede", 10);
		nameField.setBounds(560, 135, 285, 33);
		nameField.setBorder(BorderFactory.createEmptyBorder());
		nameField.setBackground(Color.WHITE);
		nameField.setForeground(SystemColor.activeCaptionBorder);
		nameField.setFont(new Font("Roboto", Font.PLAIN, 16));

		contentPane.add(nameField);

		nameLabel = new JLabel("Nome");
		nameLabel.setBounds(560, 119, 253, 14);
		nameLabel.setForeground(SystemColor.textInactiveText);
		nameLabel.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		contentPane.add(nameLabel);

		surnameField = new JTextField("Digite o sobrenome do hóspede", 10);
		surnameField.setBounds(560, 204, 285, 33);
		surnameField.setBorder(BorderFactory.createEmptyBorder());
		surnameField.setBackground(Color.WHITE);
		surnameField.setForeground(SystemColor.activeCaptionBorder);
		surnameField.setFont(new Font("Roboto", Font.PLAIN, 16));

		contentPane.add(surnameField);

		surnameLabel = new JLabel("Sobreome");
		surnameLabel.setBounds(560, 189, 253, 14);
		surnameLabel.setForeground(SystemColor.textInactiveText);
		surnameLabel.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		contentPane.add(surnameLabel);

		birthField = new JFormattedTextField(dateFormat);
		birthField.setBounds(560, 278, 285, 33);
		birthField.setBorder(new LineBorder(SystemColor.window));
		birthField.setBackground(Color.WHITE);
		birthField.setForeground(SystemColor.activeCaptionBorder);
		birthField.setFont(new Font("Roboto", Font.PLAIN, 16));
		birthField.setText("dd/MM/aaaa");

		contentPane.add(birthField);

		birthLabel = new JLabel("Data de nascimento");
		birthLabel.setBounds(560, 256, 289, 14);
		birthLabel.setForeground(SystemColor.textInactiveText);
		birthLabel.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		contentPane.add(birthLabel);

		nationalityField = new JTextField("Digite a nacionalidade do hóspede", 10);
		nationalityField.setBounds(560, 350, 285, 33);
		nationalityField.setBorder(BorderFactory.createEmptyBorder());
		nationalityField.setBackground(Color.WHITE);
		nationalityField.setForeground(SystemColor.activeCaptionBorder);
		nationalityField.setFont(new Font("Roboto", Font.PLAIN, 16));

		contentPane.add(nationalityField);

		nationalityLabel = new JLabel("Nacionalidade");
		nationalityLabel.setBounds(560, 326, 255, 14);
		nationalityLabel.setForeground(SystemColor.textInactiveText);
		nationalityLabel.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		contentPane.add(nationalityLabel);

		phoneField = new JTextField("(xx) xxxxx-xxxx", 10);
		phoneField.setBounds(560, 424, 285, 33);
		phoneField.setBorder(BorderFactory.createEmptyBorder());
		phoneField.setBackground(Color.WHITE);
		phoneField.setForeground(SystemColor.activeCaptionBorder);
		phoneField.setFont(new Font("Roboto", Font.PLAIN, 16));

		contentPane.add(phoneField);

		phoneLabel = new JLabel("Telefone");
		phoneLabel.setBounds(560, 406, 253, 14);
		phoneLabel.setForeground(SystemColor.textInactiveText);
		phoneLabel.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		contentPane.add(phoneLabel);

		reservationIdField = new JTextField(String.valueOf(reservationId), 10);
		reservationIdField.setBounds(560, 495, 285, 33);
		reservationIdField.setBorder(BorderFactory.createEmptyBorder());
		reservationIdField.setBackground(Color.WHITE);
		reservationIdField.setFont(new Font("Roboto Black", Font.BOLD, 16));

		contentPane.add(reservationIdField);

		reservationIdLabel = new JLabel("Id da reserva");
		reservationIdLabel.setBounds(560, 474, 253, 14);
		reservationIdLabel.setForeground(SystemColor.textInactiveText);
		reservationIdLabel.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		contentPane.add(reservationIdLabel);

		separator = new JSeparator();
		separator.setBounds(560, 170, 289, 2);
		separator.setBackground(new Color(12, 138, 199));
		separator.setForeground(new Color(12, 138, 199));

		contentPane.add(separator);

		separator2 = new JSeparator();
		separator2.setBounds(560, 240, 289, 2);
		separator2.setBackground(new Color(12, 138, 199));
		separator2.setForeground(new Color(12, 138, 199));

		contentPane.add(separator2);

		separator3 = new JSeparator();
		separator3.setBounds(560, 314, 289, 2);
		separator3.setBackground(new Color(12, 138, 199));
		separator3.setForeground(new Color(12, 138, 199));

		contentPane.add(separator3);

		separator4 = new JSeparator();
		separator4.setBounds(560, 386, 289, 2);
		separator4.setBackground(new Color(12, 138, 199));
		separator4.setForeground(new Color(12, 138, 199));

		contentPane.add(separator4);

		separator5 = new JSeparator();
		separator5.setBounds(560, 457, 289, 2);
		separator5.setBackground(new Color(12, 138, 199));
		separator5.setForeground(new Color(12, 138, 199));

		contentPane.add(separator5);

		separator6 = new JSeparator();
		separator6.setBounds(560, 529, 289, 2);
		separator6.setBackground(new Color(12, 138, 199));
		separator6.setForeground(new Color(12, 138, 199));

		contentPane.add(separator6);

		saveButton = new JPanel();
		saveButton.setBounds(723, 560, 122, 35);
		saveButton.setBackground(new Color(12, 138, 199));
		saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		saveButton.setLayout(null);

		contentPane.add(saveButton);

		saveLabel = new JLabel("Salvar", SwingConstants.CENTER);
		saveLabel.setBounds(0, 0, 122, 35);
		saveLabel.setForeground(Color.WHITE);
		saveLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

		saveButton.add(saveLabel);

		header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.setBackground(Color.WHITE);
		header.setOpaque(false);
		header.setLayout(null);

		contentPane.add(header);

		backButton = new JPanel();
		backButton.setBounds(0, 0, 53, 36);
		backButton.setBackground(new Color(12, 138, 199));
		backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backButton.setLayout(null);

		panel.add(backButton);

		backLabel = new JLabel("❮", SwingConstants.CENTER);
		backLabel.setBounds(0, 0, 53, 36);
		backLabel.setForeground(Color.WHITE);
		backLabel.setFont(new Font("Roboto", Font.PLAIN, 23));

		backButton.add(backLabel);

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

		titleLabel = new JLabel("Registro de hóspede");
		titleLabel.setBounds(606, 55, 234, 42);
		titleLabel.setForeground(new Color(12, 138, 199));
		titleLabel.setFont(new Font("Roboto", Font.BOLD, 23));

		contentPane.add(titleLabel);

		nameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (nameField.getText().equals("Digite o nome do hóspede")) {
					nameField.setForeground(Color.BLACK);
					nameField.setText("");
				}

				if (surnameField.getText().isEmpty()) {
					surnameField.setForeground(SystemColor.activeCaptionBorder);
					surnameField.setText("Digite o sobrenome do hóspede");
				}

				if (birthField.getText().isEmpty()) {
					birthField.setForeground(SystemColor.activeCaptionBorder);
					birthField.setText("dd/MM/aaaa");
				}

				if (nationalityField.getText().isEmpty()) {
					nationalityField.setForeground(SystemColor.activeCaptionBorder);
					nationalityField.setText("Digite a nacionalidade do hóspede");
				}

				if (phoneField.getText().isEmpty()) {
					phoneField.setForeground(SystemColor.activeCaptionBorder);
					phoneField.setText("(xx) xxxxx-xxxx");
				}

				if (reservationIdField.getText().isEmpty()) {
					reservationIdField.setText(String.valueOf(reservationId));
				}
			}
		});

		surnameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (surnameField.getText().equals("Digite o sobrenome do hóspede")) {
					surnameField.setForeground(Color.BLACK);
					surnameField.setText("");
				}

				if (nameField.getText().isEmpty()) {
					nameField.setForeground(SystemColor.activeCaptionBorder);
					nameField.setText("Digite o nome do hóspede");
				}

				if (birthField.getText().isEmpty()) {
					birthField.setForeground(SystemColor.activeCaptionBorder);
					birthField.setText("dd/MM/aaaa");
				}

				if (nationalityField.getText().isEmpty()) {
					nationalityField.setForeground(SystemColor.activeCaptionBorder);
					nationalityField.setText("Digite a nacionalidade do hóspede");
				}

				if (phoneField.getText().isEmpty()) {
					phoneField.setForeground(SystemColor.activeCaptionBorder);
					phoneField.setText("(xx) xxxxx-xxxx");
				}

				if (reservationIdField.getText().isEmpty()) {
					reservationIdField.setText(String.valueOf(reservationId));
				}
			}
		});

		birthField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (birthField.getText().equals("dd/MM/aaaa")) {
					birthField.setForeground(Color.BLACK);
					birthField.setText("");
				}

				if (nameField.getText().isEmpty()) {
					nameField.setForeground(SystemColor.activeCaptionBorder);
					nameField.setText("Digite o nome do hóspede");
				}

				if (surnameField.getText().isEmpty()) {
					surnameField.setForeground(SystemColor.activeCaptionBorder);
					surnameField.setText("Digite o sobrenome do hóspede");
				}

				if (nationalityField.getText().isEmpty()) {
					nationalityField.setForeground(SystemColor.activeCaptionBorder);
					nationalityField.setText("Digite a nacionalidade do hóspede");
				}

				if (phoneField.getText().isEmpty()) {
					phoneField.setForeground(SystemColor.activeCaptionBorder);
					phoneField.setText("(xx) xxxxx-xxxx");
				}

				if (reservationIdField.getText().isEmpty()) {
					reservationIdField.setText(String.valueOf(reservationId));
				}
			}
		});

		nationalityField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (nationalityField.getText().equals("Digite a nacionalidade do hóspede")) {
					nationalityField.setForeground(Color.BLACK);
					nationalityField.setText("");
				}

				if (nameField.getText().isEmpty()) {
					nameField.setForeground(SystemColor.activeCaptionBorder);
					nameField.setText("Digite o nome do hóspede");
				}

				if (surnameField.getText().isEmpty()) {
					surnameField.setForeground(SystemColor.activeCaptionBorder);
					surnameField.setText("Digite o sobrenome do hóspede");
				}

				if (birthField.getText().isEmpty()) {
					birthField.setForeground(SystemColor.activeCaptionBorder);
					birthField.setText("dd/MM/aaaa");
				}

				if (phoneField.getText().isEmpty()) {
					phoneField.setForeground(SystemColor.activeCaptionBorder);
					phoneField.setText("(xx) xxxxx-xxxx");
				}

				if (reservationIdField.getText().isEmpty()) {
					reservationIdField.setText(String.valueOf(reservationId));
				}
			}
		});

		phoneField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (phoneField.getText().equals("(xx) xxxxx-xxxx")) {
					phoneField.setForeground(Color.BLACK);
					phoneField.setText("");
				}

				if (nameField.getText().isEmpty()) {
					nameField.setForeground(SystemColor.activeCaptionBorder);
					nameField.setText("Digite o nome do hóspede");
				}

				if (surnameField.getText().isEmpty()) {
					surnameField.setForeground(SystemColor.activeCaptionBorder);
					surnameField.setText("Digite o sobrenome do hóspede");
				}

				if (birthField.getText().isEmpty()) {
					birthField.setForeground(SystemColor.activeCaptionBorder);
					birthField.setText("dd/MM/aaaa");
				}

				if (nationalityField.getText().isEmpty()) {
					nationalityField.setForeground(SystemColor.activeCaptionBorder);
					nationalityField.setText("Digite a nacionalidade do hóspede");
				}

				if (reservationIdField.getText().isEmpty()) {
					reservationIdField.setText(String.valueOf(reservationId));
				}
			}
		});

		reservationIdField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (nameField.getText().isEmpty()) {
					nameField.setForeground(SystemColor.activeCaptionBorder);
					nameField.setText("Digite o nome do hóspede");
				}

				if (surnameField.getText().isEmpty()) {
					surnameField.setForeground(SystemColor.activeCaptionBorder);
					surnameField.setText("Digite o sobrenome do hóspede");
				}

				if (birthField.getText().isEmpty()) {
					birthField.setForeground(SystemColor.activeCaptionBorder);
					birthField.setText("dd/MM/aaaa");
				}

				if (nationalityField.getText().isEmpty()) {
					nationalityField.setForeground(SystemColor.activeCaptionBorder);
					nationalityField.setText("Digite a nacionalidade do hóspede");
				}

				if (phoneField.getText().isEmpty()) {
					phoneField.setForeground(SystemColor.activeCaptionBorder);
					phoneField.setText("(xx) xxxxx-xxxx");
				}
			}
		});

		saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				saveButton.setBackground(new Color(0, 156, 233));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				saveButton.setBackground(SystemColor.textHighlight);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				String name = nameField.getText();
				String surname = surnameField.getText();
				String birthDate = birthField.getText();
				String nationality = nationalityField.getText();
				String phone = phoneField.getText();
				String reservationId = reservationIdField.getText();

				if (checkValues(name, surname, birthDate, nationality, phone, reservationId)) {
					registerGuest(name, surname, birthDate, nationality, phone, reservationId);

					UserMenu userMenu = new UserMenu();
					userMenu.setVisible(true);
					dispose();
				}

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

		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setBackground(new Color(118, 187, 223));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setBackground(new Color(12, 138, 199));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				UserMenu userMenu = new UserMenu();
				userMenu.setVisible(true);
				dispose();
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

	private boolean checkValues(String name, String surname, String birthDate, String nationality, String phone,
			String reservationId) {
		if (name.length() > 25) {
			JOptionPane.showMessageDialog(this, "O nome deve ter, no máximo, 25 caracteres", "Atenção!",
					JOptionPane.WARNING_MESSAGE, null);
			return false;

		} else if (name.length() <= 0 || name.equals("Digite o nome do hóspede")) {
			JOptionPane.showMessageDialog(this, "O nome deve ser informado", "Atenção!", JOptionPane.WARNING_MESSAGE,
					null);
			return false;
		}

		if (surname.length() > 50) {
			JOptionPane.showMessageDialog(this, "O sobrenome deve ter, no máximo, 50 caracteres", "Atenção!",
					JOptionPane.WARNING_MESSAGE, null);
			return false;

		} else if (surname.length() <= 0 || surname.equals("Digite o sobrenome do hóspede")) {
			JOptionPane.showMessageDialog(this, "O sobrenome deve ser informado", "Atenção!",
					JOptionPane.WARNING_MESSAGE, null);
			return false;
		}

		String[] birthArray = birthDate.split("/");

		LocalDate birth = LocalDate.of(Integer.parseInt(birthArray[2]), Integer.parseInt(birthArray[1]),
				Integer.parseInt(birthArray[0]));

		if (birth.isBefore(LocalDate.of(1912, Month.JANUARY, 01))) {
			JOptionPane.showMessageDialog(this, "Data de nascimento inválida", "Atenção!", JOptionPane.WARNING_MESSAGE,
					null);
			return false;

		} else if (birth.isAfter(LocalDate.now().minusYears(21))) {
			JOptionPane.showMessageDialog(this,
					"Data de nascimento inválida:\nÉ preciso ter 21 anos ou mais para fazer o registro", "Atenção!",
					JOptionPane.WARNING_MESSAGE, null);
			return false;
		}

		if (nationality.length() > 25) {
			JOptionPane.showMessageDialog(this, "A nacionalidade deve ter, no máximo, 25 caracteres", "Atenção!",
					JOptionPane.WARNING_MESSAGE, null);
			return false;

		} else if (nationality.length() <= 0 || nationality.equals("Digite a nacionalidade do hóspede")) {
			JOptionPane.showMessageDialog(this, "A nacionalidade deve ser informada", "Atenção!",
					JOptionPane.WARNING_MESSAGE, null);
			return false;
		}

		if (!phone.matches("^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$")) {
			JOptionPane.showMessageDialog(this, "Número de telefone inválido", "Atenção!", JOptionPane.WARNING_MESSAGE,
					null);
			return false;
		}

		if (!reservationId.matches("\\d+")) {
			JOptionPane.showMessageDialog(this, "Id da reserva inválido", "Atenção!", JOptionPane.WARNING_MESSAGE,
					null);
			return false;
		}

		return true;
	}

	private void registerGuest(String name, String surname, String birthDate, String nationality, String phone,
			String reservationId) {
		int id = guestController.registerGuest(name, surname, birthDate, nationality, phone, reservationId);

		if (id > 0) {
			String message = "Hóspede cadastrado com sucesso!\nId: " + id;
			JOptionPane.showMessageDialog(this, message, "Cadastro de hóspede", JOptionPane.INFORMATION_MESSAGE, null);

		} else {
			String message = "Erro ao cadastrar hóspede:\nCódigo " + id;
			JOptionPane.showMessageDialog(this, message, "Atenção!", JOptionPane.ERROR_MESSAGE, null);
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
