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
import java.time.Duration;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
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

import challenge.hotel.controller.ReservationController;

public class Reservations extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane, panel, panel2, nextButton, header, backButton, exitButton;
	private JLabel bgImageLabel, logoLabel, checkInLabel, checkOutLabel, valueSymbolLabel, valueSymbolLabel2,
			valueLabel, totalLabel, calculateLabel, paymentLabel, nextLabel, backLabel, exitLabel, titleLabel;
	private JFormattedTextField checkInField, checkOutField;
	private JTextField valueField, totalField;
	private JComboBox<String> paymentField;
	private JSeparator separator, separator1, separator2, separator3, separator4;

	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");

	private int mouseX, mouseY;

	private ReservationController reservationController;

	public Reservations() {
		super("Registro de reserva");

		this.reservationController = new ReservationController();

		setBounds(100, 100, 910, 560);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reservations.class.getResource("/img/logo/logo-40px.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(SystemColor.control);
		contentPane.setLayout(null);

		setContentPane(contentPane);

		panel = new JPanel();
		panel.setBounds(0, 0, 910, 560);
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		contentPane.add(panel);

		panel2 = new JPanel();
		panel2.setBounds(428, 0, 482, 560);
		panel2.setBackground(new Color(12, 138, 199));
		panel2.setLayout(null);

		panel.add(panel2);

		bgImageLabel = new JLabel(
				new ImageIcon(Reservations.class.getResource("/img/reservations/reservations-img.png")));
		bgImageLabel.setBounds(0, 140, 500, 409);
		bgImageLabel.setBackground(Color.WHITE);

		panel2.add(bgImageLabel);

		logoLabel = new JLabel(new ImageIcon(Reservations.class.getResource("/img/logo/logo-100px.png")));
		logoLabel.setBounds(197, 68, 104, 107);

		panel2.add(logoLabel);

		checkInField = new JFormattedTextField(dateFormat);
		checkInField.setBounds(68, 120, 289, 33);
		checkInField.setBorder(new LineBorder(SystemColor.window));
		checkInField.setBackground(SystemColor.text);
		checkInField.setForeground(SystemColor.activeCaptionBorder);
		checkInField.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		checkInField.setText("dd/MM/aaaa");

		panel.add(checkInField);

		checkInLabel = new JLabel("Data de check-in");
		checkInLabel.setBounds(68, 95, 289, 14);
		checkInLabel.setForeground(SystemColor.textInactiveText);
		checkInLabel.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		panel.add(checkInLabel);

		checkOutField = new JFormattedTextField(dateFormat);
		checkOutField.setBounds(68, 204, 289, 33);
		checkOutField.setBorder(new LineBorder(SystemColor.window));
		checkOutField.setBackground(SystemColor.text);
		checkOutField.setForeground(SystemColor.activeCaptionBorder);
		checkOutField.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		checkOutField.setText("dd/MM/aaaa");

		panel.add(checkOutField);

		checkOutLabel = new JLabel("Data de check-out");
		checkOutLabel.setBounds(68, 179, 289, 14);
		checkOutLabel.setForeground(SystemColor.textInactiveText);
		checkOutLabel.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		panel.add(checkOutLabel);

		valueField = new JTextField("0.00", 10);
		valueField.setBounds(90, 288, 267, 33);
		valueField.setBorder(BorderFactory.createEmptyBorder());
		valueField.setBackground(SystemColor.text);
		valueField.setForeground(SystemColor.activeCaptionBorder);
		valueField.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		valueField.setHorizontalAlignment(SwingConstants.LEFT);

		panel.add(valueField);

		valueLabel = new JLabel("Valor diário");
		valueLabel.setBounds(68, 263, 289, 14);
		valueLabel.setForeground(SystemColor.textInactiveText);
		valueLabel.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		panel.add(valueLabel);

		totalField = new JTextField("0.00", 10);
		totalField.setBounds(90, 372, 267, 33);
		totalField.setBorder(BorderFactory.createEmptyBorder());
		totalField.setBackground(SystemColor.text);
		totalField.setForeground(SystemColor.activeCaptionBorder);
		totalField.setFont(new Font("Roboto Black", Font.BOLD, 18));
		totalField.setHorizontalAlignment(SwingConstants.LEFT);
		totalField.setEditable(false);

		panel.add(totalField);

		totalLabel = new JLabel("Valor total");
		totalLabel.setBounds(68, 347, 289, 14);
		totalLabel.setForeground(SystemColor.textInactiveText);
		totalLabel.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		panel.add(totalLabel);

		calculateLabel = new JLabel("Calcular", SwingConstants.RIGHT);
		calculateLabel.setBounds(200, 0, 65, 30);
		calculateLabel.setForeground(SystemColor.textHighlight);
		calculateLabel.setFont(new Font("Roboto Black", Font.BOLD, 16));
		calculateLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

		totalField.add(calculateLabel);

		valueSymbolLabel = new JLabel("$");
		valueSymbolLabel.setBounds(68, 291, 17, 25);
		valueSymbolLabel.setForeground(SystemColor.textHighlight);
		valueSymbolLabel.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		panel.add(valueSymbolLabel);

		valueSymbolLabel2 = new JLabel("$");
		valueSymbolLabel2.setBounds(68, 375, 17, 25);
		valueSymbolLabel2.setForeground(SystemColor.textHighlight);
		valueSymbolLabel2.setFont(new Font("Roboto Black", Font.BOLD, 18));

		panel.add(valueSymbolLabel2);

		paymentField = new JComboBox<>();
		paymentField.setBounds(68, 456, 289, 38);
		paymentField.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		paymentField.setBackground(SystemColor.text);
		paymentField.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		paymentField.setModel(new DefaultComboBoxModel<>(
				new String[] { "Dinheiro", "Boleto", "PIX", "Cartão de crédito", "Cartão de débito" }));

		panel.add(paymentField);

		paymentLabel = new JLabel("Forma de pagamento");
		paymentLabel.setBounds(68, 431, 213, 24);
		paymentLabel.setForeground(SystemColor.textInactiveText);
		paymentLabel.setFont(new Font("Roboto Black", Font.PLAIN, 18));

		panel.add(paymentLabel);

		separator = new JSeparator();
		separator.setBounds(68, 154, 289, 2);
		separator.setBackground(SystemColor.textHighlight);
		separator.setForeground(SystemColor.textHighlight);

		panel.add(separator);

		separator1 = new JSeparator();
		separator1.setBounds(68, 238, 289, 2);
		separator1.setBackground(SystemColor.textHighlight);
		separator1.setForeground(SystemColor.textHighlight);

		panel.add(separator1);

		separator2 = new JSeparator();
		separator2.setBounds(68, 322, 289, 2);
		separator2.setBackground(SystemColor.textHighlight);
		separator2.setForeground(SystemColor.textHighlight);

		panel.add(separator2);

		separator3 = new JSeparator();
		separator3.setBounds(68, 406, 289, 2);
		separator3.setBackground(SystemColor.textHighlight);
		separator3.setForeground(SystemColor.textHighlight);

		panel.add(separator3);

		separator4 = new JSeparator();
		separator4.setBounds(68, 490, 289, 2);
		separator4.setBackground(SystemColor.textHighlight);
		separator4.setForeground(SystemColor.textHighlight);

		panel.add(separator4);

		nextButton = new JPanel();
		nextButton.setBounds(238, 510, 122, 35);
		nextButton.setBackground(SystemColor.textHighlight);
		nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nextButton.setLayout(null);

		panel.add(nextButton);

		nextLabel = new JLabel("Próximo", SwingConstants.CENTER);
		nextLabel.setBounds(0, 0, 122, 35);
		nextLabel.setForeground(Color.WHITE);
		nextLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

		nextButton.add(nextLabel);

		header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.setBackground(Color.WHITE);
		header.setLayout(null);

		panel.add(header);

		backButton = new JPanel();
		backButton.setBounds(0, 0, 53, 36);
		backButton.setBackground(new Color(12, 138, 199));
		backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backButton.setLayout(null);

		header.add(backButton);

		backLabel = new JLabel("❮", SwingConstants.CENTER);
		backLabel.setBounds(0, 0, 53, 36);
		backLabel.setForeground(Color.WHITE);
		backLabel.setFont(new Font("Roboto", Font.PLAIN, 23));

		backButton.add(backLabel);

		exitButton = new JPanel();
		exitButton.setBounds(429, 0, 53, 36);
		exitButton.setBackground(new Color(12, 138, 199));
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitButton.setLayout(null);

		panel2.add(exitButton);

		exitLabel = new JLabel("X", SwingConstants.CENTER);
		exitLabel.setBounds(0, 0, 53, 36);
		exitLabel.setForeground(Color.WHITE);
		exitLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

		exitButton.add(exitLabel);

		titleLabel = new JLabel("Sistema de reservas");
		titleLabel.setBounds(109, 25, 219, 42);
		titleLabel.setForeground(new Color(12, 138, 199));
		titleLabel.setFont(new Font("Roboto", Font.BOLD, 20));

		panel.add(titleLabel);

		checkInField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (checkInField.getText().equals("dd/MM/aaaa")) {
					checkInField.setForeground(Color.BLACK);
					checkInField.setText("");
				}

				if (checkOutField.getText().isEmpty()) {
					checkOutField.setForeground(SystemColor.activeCaptionBorder);
					checkOutField.setText("dd/MM/aaaa");
				}

				if (valueField.getText().isEmpty()) {
					valueField.setForeground(SystemColor.activeCaptionBorder);
					valueField.setText("0.00");
				}
			}
		});

		checkOutField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (checkOutField.getText().equals("dd/MM/aaaa")) {
					checkOutField.setForeground(Color.BLACK);
					checkOutField.setText("");
				}

				if (checkInField.getText().isEmpty()) {
					checkInField.setForeground(SystemColor.activeCaptionBorder);
					checkInField.setText("dd/MM/aaaa");
				}

				if (valueField.getText().isEmpty()) {
					valueField.setForeground(SystemColor.activeCaptionBorder);
					valueField.setText("0.00");
				}
			}
		});

		valueField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (valueField.getText().equals("0.00")) {
					valueField.setForeground(Color.BLACK);
					valueField.setText("");
				}

				if (checkInField.getText().isEmpty()) {
					checkInField.setForeground(SystemColor.activeCaptionBorder);
					checkInField.setText("dd/MM/aaaa");
				}

				if (checkOutField.getText().isEmpty()) {
					checkOutField.setForeground(SystemColor.activeCaptionBorder);
					checkOutField.setText("dd/MM/aaaa");
				}
			}
		});

		calculateLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				calculateLabel.setForeground(new Color(0, 156, 233));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				calculateLabel.setForeground(SystemColor.textHighlight);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				String checkInDate = checkInField.getText();
				String checkOutDate = checkOutField.getText();
				String dailyValue = valueField.getText();

				if (checkValues(checkInDate, checkOutDate, dailyValue)) {
					totalField.setText(String.valueOf(calculateTotalValue(checkInDate, checkOutDate, dailyValue)));
					totalField.setForeground(Color.BLACK);
				}
			}
		});

		nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				nextButton.setBackground(new Color(0, 156, 233));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				nextButton.setBackground(SystemColor.textHighlight);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				String checkInDate = checkInField.getText();
				String checkOutDate = checkOutField.getText();
				String totalValue = totalField.getText();

				if (checkValues(checkInDate, checkOutDate, totalValue)) {
					int id = registerReservation(checkInDate, checkOutDate, totalValue,
							paymentField.getSelectedItem().toString());

					GuestRegistration guestRegistration = new GuestRegistration(id);
					guestRegistration.setVisible(true);
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

	private boolean checkValues(String checkInDate, String checkOutDate, String value) {
		if (value.isEmpty() || value.isBlank()) {
			JOptionPane.showMessageDialog(this, "Por favor, insira um valor maior que $ 0.00", "Atenção!",
					JOptionPane.WARNING_MESSAGE, null);
			return false;
		}

		if (checkInDate.isEmpty() || checkInDate.isBlank() || checkOutDate.isEmpty() || checkOutDate.isBlank()) {
			JOptionPane.showMessageDialog(this,
					"Por favor, insira um valor válido para as datas de check-in e check-out", "Atenção!",
					JOptionPane.WARNING_MESSAGE, null);
			return false;
		}

		Double doubleValue = Double.parseDouble(value);

		if (doubleValue == 0) {
			JOptionPane.showMessageDialog(this, "O valor da reserva deve ser maior que $ 0.00", "Atenção!",
					JOptionPane.WARNING_MESSAGE, null);
			return false;
		}

		String[] checkInArray = checkInDate.split("/");
		String[] checkOutArray = checkOutDate.split("/");

		LocalDate checkIn = LocalDate.of(Integer.parseInt(checkInArray[2]), Integer.parseInt(checkInArray[1]),
				Integer.parseInt(checkInArray[0]));
		LocalDate checkOut = LocalDate.of(Integer.parseInt(checkOutArray[2]), Integer.parseInt(checkOutArray[1]),
				Integer.parseInt(checkOutArray[0]));

		if (checkIn.isBefore(LocalDate.now())) {
			JOptionPane.showMessageDialog(this,
					"Valor inválido inserido para datas:\nO check-in não pode ser no passado", "Atenção!",
					JOptionPane.WARNING_MESSAGE, null);
			return false;
		}

		if (checkOut.isBefore(checkIn)) {
			JOptionPane.showMessageDialog(this,
					"Valor inválido inserido para datas:\nO check-out deve ser depois do check-in", "Atenção!",
					JOptionPane.WARNING_MESSAGE, null);
			return false;
		}

		return true;
	}

	private double calculateTotalValue(String checkInDate, String checkOutDate, String dailyValue) {
		Double value = Double.parseDouble(dailyValue);

		String[] checkInArray = checkInDate.split("/");
		String[] checkOutArray = checkOutDate.split("/");

		LocalDate checkIn = LocalDate.of(Integer.parseInt(checkInArray[2]), Integer.parseInt(checkInArray[1]),
				Integer.parseInt(checkInArray[0]));
		LocalDate checkOut = LocalDate.of(Integer.parseInt(checkOutArray[2]), Integer.parseInt(checkOutArray[1]),
				Integer.parseInt(checkOutArray[0]));

		Duration diff = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
		long totalDays = diff.toDays();

		double totalValue = totalDays * value;

		if (totalValue == 0) {
			return value;
		}

		return totalValue;
	}

	private int registerReservation(String checkInDate, String checkOutDate, String totalValue, String paymentMethod) {
		int id = reservationController.registerReservation(checkInDate, checkOutDate, totalValue, paymentMethod);
		
		if (id > 0) {
			String message = "Reserva cadastrada com sucesso!\nId: " + id;
			JOptionPane.showMessageDialog(this, message, "Cadastro de reserva", JOptionPane.INFORMATION_MESSAGE, null);
		
		} else {
			String message = "Erro ao cadastrar reserva:\nCódigo " + id;
			JOptionPane.showMessageDialog(this, message, "Atenção!", JOptionPane.ERROR_MESSAGE, null);
		}
		return id;
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
