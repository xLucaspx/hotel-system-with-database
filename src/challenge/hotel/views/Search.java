package challenge.hotel.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import challenge.hotel.controller.GuestController;
import challenge.hotel.controller.ReservationController;
import challenge.hotel.models.Guest;
import challenge.hotel.models.Reservation;

public class Search extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane, searchButton, editButton, deleteButton, header, backButton, exitButton;
	private JTabbedPane panel;
	private JScrollPane reservationsPanel, guestsPanel;
	private JLabel logoLabel, searchLabel, editLabel, deleteLabel, backLabel, exitLabel, titleLabel;
	private JTextField searchField;
	private JSeparator separator;
	private DefaultTableModel reservationsModel, guestsModel;
	private JTable reservationsTable, guestsTable;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private int mouseX, mouseY;

	private ReservationController reservationController;
	private GuestController guestController;

	public Search() {
		super("White Lotus - Busca");

		this.reservationController = new ReservationController();
		this.guestController = new GuestController();

		setBounds(100, 100, 910, 571);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Search.class.getResource("/img/logo/logo-40px.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);

		setContentPane(contentPane);

		panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBounds(20, 169, 865, 328);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));

		contentPane.add(panel);

		logoLabel = new JLabel(new ImageIcon(Search.class.getResource("/img/logo/logo-100px.png")));
		logoLabel.setBounds(56, 51, 104, 107);

		contentPane.add(logoLabel);

		searchField = new JTextField(10); // text: buscar?
		searchField.setBounds(536, 127, 193, 31);
		searchField.setBorder(BorderFactory.createEmptyBorder());

		contentPane.add(searchField);

		searchButton = new JPanel();
		searchButton.setBounds(748, 125, 122, 35);
		searchButton.setBackground(new Color(12, 138, 199));
		searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchButton.setLayout(null);

		contentPane.add(searchButton);

		searchLabel = new JLabel("Buscar", SwingConstants.CENTER);
		searchLabel.setBounds(0, 0, 122, 35);
		searchLabel.setForeground(Color.WHITE);
		searchLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

		searchButton.add(searchLabel);

		separator = new JSeparator();
		separator.setBounds(535, 159, 195, 2);
		separator.setBackground(new Color(12, 138, 199));
		separator.setForeground(new Color(12, 138, 199));

		contentPane.add(separator);

		String[] reservationsColumnsNames = { "Id reserva", "Check-in", "Check-out", "Valor", "Forma de pagamento" };
		reservationsModel = new DefaultTableModel(reservationsColumnsNames, 0);

		reservationsTable = new JTable(reservationsModel);
		reservationsTable.setFont(new Font("Roboto", Font.PLAIN, 14));
		reservationsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		TableColumn reservationsColumn0 = reservationsTable.getColumnModel().getColumn(0);
		TableColumn reservationsColumn1 = reservationsTable.getColumnModel().getColumn(1);
		TableColumn reservationsColumn2 = reservationsTable.getColumnModel().getColumn(2);
		TableColumn reservationsColumn3 = reservationsTable.getColumnModel().getColumn(3);
		TableColumn reservationsColumn4 = reservationsTable.getColumnModel().getColumn(4);

		reservationsColumn0.setPreferredWidth(110);
		reservationsColumn1.setPreferredWidth(130);
		reservationsColumn2.setPreferredWidth(130);
		reservationsColumn3.setPreferredWidth(200);
		reservationsColumn4.setPreferredWidth(295);

		reservationsPanel = new JScrollPane(reservationsTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		panel.addTab("Reservas", new ImageIcon(Search.class.getResource("/img/icons/reserves-icon.png")),
				reservationsPanel, null);

		String[] guestsColumnsNames = { "Id", "Nome", "Sobrenome", "Data de nascimento", "Nacionalidade", "Telefone",
				"Id reserva" };
		guestsModel = new DefaultTableModel(guestsColumnsNames, 0);

		guestsTable = new JTable(guestsModel);
		guestsTable.setFont(new Font("Roboto", Font.PLAIN, 14));
		guestsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		TableColumn guestsColumn0 = guestsTable.getColumnModel().getColumn(0);
		TableColumn guestsColumn1 = guestsTable.getColumnModel().getColumn(1);
		TableColumn guestsColumn2 = guestsTable.getColumnModel().getColumn(2);
		TableColumn guestsColumn3 = guestsTable.getColumnModel().getColumn(3);
		TableColumn guestsColumn4 = guestsTable.getColumnModel().getColumn(4);
		TableColumn guestsColumn5 = guestsTable.getColumnModel().getColumn(5);
		TableColumn guestsColumn6 = guestsTable.getColumnModel().getColumn(6);

		guestsColumn0.setPreferredWidth(64);
		guestsColumn1.setPreferredWidth(134);
		guestsColumn2.setPreferredWidth(160);
		guestsColumn3.setPreferredWidth(117);
		guestsColumn4.setPreferredWidth(140);
		guestsColumn5.setPreferredWidth(180);
		guestsColumn6.setPreferredWidth(70);

		guestsPanel = new JScrollPane(guestsTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		panel.addTab("Hóspedes", new ImageIcon(Search.class.getResource("/img/icons/search-icon.png")), guestsPanel,
				null);

		editButton = new JPanel();
		editButton.setBounds(635, 508, 122, 35);
		editButton.setBackground(new Color(12, 138, 199));
		editButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		editButton.setLayout(null);

		contentPane.add(editButton);

		editLabel = new JLabel("Editar", SwingConstants.CENTER);
		editLabel.setBounds(0, 0, 122, 35);
		editLabel.setForeground(Color.WHITE);
		editLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

		editButton.add(editLabel);

		deleteButton = new JPanel();
		deleteButton.setBounds(767, 508, 122, 35);
		deleteButton.setBackground(new Color(12, 138, 199));
		deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		deleteButton.setLayout(null);

		contentPane.add(deleteButton);

		deleteLabel = new JLabel("Deletar", SwingConstants.CENTER);
		deleteLabel.setBounds(0, 0, 122, 35);
		deleteLabel.setForeground(Color.WHITE);
		deleteLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

		deleteButton.add(deleteLabel);

		header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.setBackground(Color.WHITE);
		header.setLayout(null);

		contentPane.add(header);

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
		exitButton.setBounds(857, 0, 53, 36);
		exitButton.setBackground(Color.WHITE);
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitButton.setLayout(null);

		header.add(exitButton);

		exitLabel = new JLabel("X", SwingConstants.CENTER);
		exitLabel.setBounds(0, 0, 53, 36);
		exitLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

		exitButton.add(exitLabel);

		titleLabel = new JLabel("Sistema de busca");
		titleLabel.setBounds(331, 62, 280, 42);
		titleLabel.setForeground(new Color(12, 138, 199));
		titleLabel.setFont(new Font("Roboto Black", Font.BOLD, 24));

		contentPane.add(titleLabel);

		editButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				editButton.setBackground(new Color(0, 156, 233));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				editButton.setBackground(SystemColor.textHighlight);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				editTable();
			}
		});
		
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				deleteButton.setBackground(new Color(0, 156, 233));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				deleteButton.setBackground(SystemColor.textHighlight);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				deleteSelectedRow();
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

		clearTables();
		fillTables();
	}

	private List<Reservation> listReservations() {
		return reservationController.listReservations();
	}

	private List<Guest> listGuests() {
		return guestController.listGuests();
	}

	private void fillTables() {
		List<Reservation> reservations = listReservations();
		List<Guest> guests = listGuests();

		reservations.forEach(reservation -> reservationsModel.addRow(new Object[] { reservation.getId(),
				reservation.getCheckInDate().format(formatter), reservation.getCheckOutDate().format(formatter),
				reservation.getValue(), reservation.getPaymentMethod() }));

		guests.forEach(guest -> guestsModel.addRow(new Object[] { guest.getId(), guest.getName(), guest.getSurname(),
				guest.getBirthDate().format(formatter), guest.getNationality(), guest.getPhone(),
				guest.getReservationId() }));
	}
	
	private void clearTables() {
		reservationsModel.getDataVector().clear();
		guestsModel.getDataVector().clear();
	}

	private void editTable() {
		if (reservationsTable.isFocusOwner()) {
			int id = (int) reservationsModel.getValueAt(reservationsTable.getSelectedRow(), 0);
			String checkIn = (String) reservationsModel.getValueAt(reservationsTable.getSelectedRow(), 1);
			String checkOut = (String) reservationsModel.getValueAt(reservationsTable.getSelectedRow(), 2);
			String value = (String) reservationsModel.getValueAt(reservationsTable.getSelectedRow(), 3);
			String paymentMethod = (String) reservationsModel.getValueAt(reservationsTable.getSelectedRow(), 4);

			reservationController.editReservation(id, checkIn, checkOut, value, paymentMethod);

			clearTables();
			fillTables();

			JOptionPane.showMessageDialog(this, "Reserva " + id + " editada com sucesso!", "Edição de reserva",
					JOptionPane.INFORMATION_MESSAGE, null);

		} else if (guestsTable.isFocusOwner()) {
			int id = (int) guestsModel.getValueAt(guestsTable.getSelectedRow(), 0);
			String name = (String) guestsModel.getValueAt(guestsTable.getSelectedRow(), 1);
			String surname = (String) guestsModel.getValueAt(guestsTable.getSelectedRow(), 2);
			String birthDate = (String) guestsModel.getValueAt(guestsTable.getSelectedRow(), 3);
			String nationality = (String) guestsModel.getValueAt(guestsTable.getSelectedRow(), 4);
			String phone = (String) guestsModel.getValueAt(guestsTable.getSelectedRow(), 5);
			int reservationId = (int) guestsModel.getValueAt(guestsTable.getSelectedRow(), 6);

			guestController.editGuest(id, name, surname, birthDate, nationality, phone, reservationId);

			clearTables();
			fillTables();

			JOptionPane.showMessageDialog(this, "Hóspede " + id + " editado com sucesso!", "Edição de hóspede",
					JOptionPane.INFORMATION_MESSAGE, null);
		}
	}
	
	private void deleteSelectedRow() {
		if (reservationsTable.isFocusOwner()) {
			int id = (int) reservationsModel.getValueAt(reservationsTable.getSelectedRow(), 0);
			
			reservationController.deleteReservation(id);
			
			clearTables();
			fillTables();
			
			JOptionPane.showMessageDialog(this, "Reserva " + id + " deletada com sucesso!", "Exclusão de reserva",
					JOptionPane.INFORMATION_MESSAGE, null);
		
		} else if (guestsTable.isFocusOwner()) {
			int id = (int) guestsModel.getValueAt(guestsTable.getSelectedRow(), 0);
			
			guestController.deleteGuest(id);
			
			clearTables();
			fillTables();
			
			JOptionPane.showMessageDialog(this, "Hóspede " + id + " deletado com sucesso!", "Exclusão de hóspede",
					JOptionPane.INFORMATION_MESSAGE, null);
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
