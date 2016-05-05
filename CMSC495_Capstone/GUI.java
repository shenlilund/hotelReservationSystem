

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.sql.Date;;

public class GUI {

	private JFrame frame;
	private JTextField newReservationCustomerIDField;
	private JFormattedTextField newReservationCheckInDateField;
	private JFormattedTextField newReservationCheckOutDateField;
	private JTextField editReservationID;
	private JTextField editCheckInDate;
	private JTextField editCheckOutDate;
	private JTextField checkOutReservationID;
	private JPanel mainMenu;
	private JPanel createReservationMenu;
	private JPanel editReservationMenu;
	private JPanel customerMenu;
	private JPanel roomMenu;
	private JPanel reservationCheckOutMenu;
	private JTextField customerMenuLastName;
	private JTextField customerMenuFirstName;
	private JTextField textField;
	private JTextField customerMenuStreetAddress;
	// private JTextField customerMenuCity;
	// private JTextField customerMenuPhoneNumber;
	private JTextField customerMenuState;
	private JTextField customerMenuZip;
	private JTextField roomMenuRoomNumber;
	private BusinessLogic bLogic;
	private JFormattedTextField findRoomCheckIn;
	private JFormattedTextField findRoomCheckOut;
	private JTextField newReservationRoomIDField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		bLogic = new BusinessLogic();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 707, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		//Initialize Main Menu -----------------------------------------------------
		final JPanel mainMenu = new JPanel();
		mainMenu.setForeground(Color.WHITE);
		mainMenu.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(mainMenu, "name_1079663997017016");
		mainMenu.setLayout(null);
		mainMenu.setVisible(true);

		JLabel lblHotelReservationSystem = new JLabel("Hotel Reservation System");
		lblHotelReservationSystem.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblHotelReservationSystem.setForeground(Color.WHITE);
		lblHotelReservationSystem.setBounds(291, 62, 339, 35);
		mainMenu.add(lblHotelReservationSystem);

		JButton showReservationMenu = new JButton("Show Reservation Menu");
		showReservationMenu.setBounds(43, 140, 235, 29);
		mainMenu.add(showReservationMenu);


		JButton exitProgram = new JButton("Close");
		exitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitProgram.setBounds(435, 367, 235, 29);
		mainMenu.add(exitProgram);

		//Create Reservation Menu --------------------------------------------------
		final JPanel createReservationMenu = new JPanel();
		createReservationMenu.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(createReservationMenu, "name_1079664005828921");
		createReservationMenu.setLayout(null);
		createReservationMenu.setVisible(false);

		JButton createReservationForm = new JButton("Create Reservation");
		createReservationForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createReservationMenu.setVisible(true);
				mainMenu.setVisible(false);
			}
		});
		createReservationForm.setBounds(335, 140, 235, 29);
		mainMenu.add(createReservationForm);

		JLabel lblNewLabel = new JLabel("New Reservation");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(481, 16, 189, 40);
		createReservationMenu.add(lblNewLabel);

		JLabel lblCustomerId = new JLabel("Customer Id");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustomerId.setForeground(Color.WHITE);
		lblCustomerId.setBounds(15, 96, 114, 27);
		createReservationMenu.add(lblCustomerId);

		JLabel lblRoomId = new JLabel("Room Id");
		lblRoomId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRoomId.setForeground(Color.WHITE);
		lblRoomId.setBounds(360, 96, 114, 27);
		createReservationMenu.add(lblRoomId);

		newReservationRoomIDField = new JTextField();
		newReservationRoomIDField.setBounds(450, 96, 146, 26);
		createReservationMenu.add(newReservationRoomIDField);
		newReservationRoomIDField.setColumns(10);

		JLabel lblCheckinDate = new JLabel("Check-in Date");
		lblCheckinDate.setForeground(Color.WHITE);
		lblCheckinDate.setBounds(15, 139, 98, 20);
		createReservationMenu.add(lblCheckinDate);

		JLabel lblCheckoutDate = new JLabel("Check-out Date");
		lblCheckoutDate.setForeground(Color.WHITE);
		lblCheckoutDate.setBounds(15, 175, 119, 20);
		createReservationMenu.add(lblCheckoutDate);

		JLabel lblNumerOfOccupants = new JLabel("Numer of Occupants");
		lblNumerOfOccupants.setForeground(Color.WHITE);
		lblNumerOfOccupants.setBounds(15, 211, 145, 20);
		createReservationMenu.add(lblNumerOfOccupants);

		newReservationCustomerIDField = new JTextField();
		newReservationCustomerIDField.setBounds(149, 96, 146, 26);
		createReservationMenu.add(newReservationCustomerIDField);
		newReservationCustomerIDField.setColumns(10);


		newReservationCheckInDateField = new JFormattedTextField(df);
		newReservationCheckInDateField.setBounds(149, 136, 146, 26);
		createReservationMenu.add(newReservationCheckInDateField);
		newReservationCheckInDateField.setColumns(10);

		newReservationCheckOutDateField = new JFormattedTextField(df);
		newReservationCheckOutDateField.setBounds(149, 172, 146, 26);
		createReservationMenu.add(newReservationCheckOutDateField);
		newReservationCheckOutDateField.setColumns(10);

		JTextField newReservationOccupants = new JTextField();
		newReservationOccupants.setBounds(205, 208, 50, 26);
		createReservationMenu.add(newReservationOccupants);

		JButton reservationFormBack = new JButton("Back");
		reservationFormBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.setVisible(true);
				createReservationMenu.setVisible(false);
			}
		});
		reservationFormBack.setBounds(555, 367, 115, 29);
		createReservationMenu.add(reservationFormBack);

		JButton newReservationCreateReservationButton = new JButton("Create Reservation");
		newReservationCreateReservationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//check that roomId, customerId, and occupants are numbers
				try
				{
					int theRoomNum = Integer.parseInt(newReservationRoomIDField.getText());
					int customerNum = Integer.parseInt(newReservationCustomerIDField.getText());
					int occupantsNum = Integer.parseInt(newReservationOccupants.getText());

					String checkInStr = newReservationCheckInDateField.getText();
					String checkOutStr = newReservationCheckOutDateField.getText();

					//check that date is in correct format
					if ((checkInStr.equals("")) || (checkOutStr.equals(""))) //textfield is empty
					{
						JOptionPane.showMessageDialog(null, "Please input date using yyyy-MM-dd");
					}
					else
					{
						Date checkInD = Date.valueOf(checkInStr);
						Date checkOutD = Date.valueOf(checkOutStr);

						bLogic.createReservation(customerNum, theRoomNum, occupantsNum, checkInD, checkOutD);
						JOptionPane.showMessageDialog(null, "Reservation created successfully");

						//make all fields blank
						newReservationRoomIDField.setText("");
						newReservationCustomerIDField.setText("");
						newReservationOccupants.setText("");
						newReservationCheckInDateField.setText("");
						newReservationCheckOutDateField.setText("");
					}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "Customer Id, Room Id, and Number of occupants must be numbers");
				}

			}
		});
		newReservationCreateReservationButton.setBounds(134, 275, 189, 29);
		createReservationMenu.add(newReservationCreateReservationButton);


		//Edit Reservation Menu-----------------------------------------------------
		final JPanel editReservationMenu = new JPanel();
		editReservationMenu.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(editReservationMenu, "name_1079664011450164");
		editReservationMenu.setLayout(null);
		editReservationMenu.setVisible(false);

		JButton editReservationForm = new JButton("Edit Reservation");
		editReservationForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editReservationMenu.setVisible(true);
				mainMenu.setVisible(false);

			}
		});
		editReservationForm.setBounds(335, 186, 235, 29);
		mainMenu.add(editReservationForm);

		JLabel lblEditReservation = new JLabel("Edit Reservation");
		lblEditReservation.setForeground(Color.WHITE);
		lblEditReservation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEditReservation.setBounds(481, 16, 189, 40);
		editReservationMenu.add(lblEditReservation);

		JLabel editReservationIDLabel = new JLabel("Reservation Id");
		editReservationIDLabel.setForeground(Color.WHITE);
		editReservationIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		editReservationIDLabel.setBounds(15, 96, 114, 27);
		editReservationMenu.add(editReservationIDLabel);

		JLabel label_2 = new JLabel("Check-in Date");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(15, 139, 98, 20);
		editReservationMenu.add(label_2);

		JLabel label_3 = new JLabel("Check-out Date");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(15, 175, 119, 20);
		editReservationMenu.add(label_3);

		JLabel label_4 = new JLabel("Numer of Occupants");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(15, 211, 145, 20);
		editReservationMenu.add(label_4);

		JComboBox editOccupants = new JComboBox();
		editOccupants.setBounds(208, 208, 36, 26);
		editReservationMenu.add(editOccupants);

		editReservationID = new JTextField();
		editReservationID.setBounds(154, 96, 146, 26);
		editReservationMenu.add(editReservationID);
		editReservationID.setColumns(10);

		editCheckInDate = new JTextField();
		editCheckInDate.setBounds(154, 136, 146, 26);
		editReservationMenu.add(editCheckInDate);
		editCheckInDate.setColumns(10);

		editCheckOutDate = new JTextField();
		editCheckOutDate.setBounds(154, 172, 146, 26);
		editReservationMenu.add(editCheckOutDate);
		editCheckOutDate.setColumns(10);

		JButton editBack = new JButton("Back");
		editBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.setVisible(true);
				editReservationMenu.setVisible(false);
			}
		});
		editBack.setBounds(555, 367, 115, 29);
		editReservationMenu.add(editBack);

		JButton btnEditReservation = new JButton("Edit Reservation");
		btnEditReservation.setBounds(143, 285, 180, 29);
		editReservationMenu.add(btnEditReservation);

		//Customer Menu ------------------------------------------------------------
		final JPanel customerMenu = new JPanel();
		customerMenu.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(customerMenu, "name_1079664017197885");
		customerMenu.setLayout(null);
		customerMenu.setVisible(false);

		JButton showCustomerMenu = new JButton("Customer Menu");
		showCustomerMenu.setBounds(43, 186, 235, 29);
		mainMenu.add(showCustomerMenu);
		showCustomerMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customerMenu.setVisible(true);
				mainMenu.setVisible(false);
			}
		});

		JLabel lblCustomerMenu = new JLabel("Customer Menu");
		lblCustomerMenu.setForeground(Color.WHITE);
		lblCustomerMenu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCustomerMenu.setBounds(503, 16, 167, 20);
		customerMenu.add(lblCustomerMenu);

		JButton btnCustomerMenuBack = new JButton("Back");
		btnCustomerMenuBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.setVisible(true);
				customerMenu.setVisible(false);

			}
		});
		btnCustomerMenuBack.setBounds(555, 367, 115, 29);
		customerMenu.add(btnCustomerMenuBack);

		JLabel lblCustomerLastName = new JLabel("Customer Last Name");
		lblCustomerLastName.setForeground(Color.WHITE);
		lblCustomerLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustomerLastName.setBounds(15, 51, 147, 20);
		customerMenu.add(lblCustomerLastName);

		customerMenuLastName = new JTextField();
		customerMenuLastName.setBounds(177, 48, 186, 26);
		customerMenu.add(customerMenuLastName);
		customerMenuLastName.setColumns(10);

		JButton btnFindCustomer = new JButton("Find Customer");
		btnFindCustomer.setBounds(177, 90, 186, 29);
		customerMenu.add(btnFindCustomer);

		btnFindCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cLastName = customerMenuLastName.getText();
				if (cLastName.equals("")) //textfield is empty
				{
					JOptionPane.showMessageDialog(null, "Please input the customer's last name");
				}
				else //Something was found in the textfield
				{
					ArrayList<Customer> foundCustomers = bLogic.findCustomer(cLastName);
					if (foundCustomers.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "No customers found with that name");
					}
					else
					{
						String str = "";
						for (Customer c : foundCustomers)
						{
							// System.out.println(c.CustomerId());
							str += "Customer ID: " + c.CustomerId() +
								"\nName: " + c.LastName() + ", " + c.FirstName() +
								"\nAddress: " + c.StreetAddress() +
								"\nState: " + c.State() +
								"\nZip: " + c.Zipcode() +
								"\n\n\n";
						}
						JOptionPane.showMessageDialog(null, str);
					}
				}
				customerMenuLastName.setText("");
			}
		});

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBounds(15, 166, 115, 20);
		customerMenu.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(310, 166, 89, 20);
		customerMenu.add(lblLastName);

		JLabel lblStreetAddress = new JLabel("Street Address");
		lblStreetAddress.setForeground(Color.WHITE);
		lblStreetAddress.setBounds(15, 207, 103, 20);
		customerMenu.add(lblStreetAddress);

		// JLabel lblCity = new JLabel("City");
		// lblCity.setForeground(Color.WHITE);
		// lblCity.setBounds(294, 207, 69, 20);
		// customerMenu.add(lblCity);

		JLabel lblState = new JLabel("State");
		lblState.setForeground(Color.WHITE);
		lblState.setBounds(310, 207, 69, 20);
		customerMenu.add(lblState);

		// JLabel lblPhoneNumber = new JLabel("Phone Number");
		// lblPhoneNumber.setForeground(Color.WHITE);
		// lblPhoneNumber.setBounds(15, 266, 130, 20);
		// customerMenu.add(lblPhoneNumber);

		JLabel lblZip = new JLabel("Zip Code");
		lblZip.setForeground(Color.WHITE);
		lblZip.setBounds(15, 248, 69, 20);
		customerMenu.add(lblZip);

		customerMenuFirstName = new JTextField();
		customerMenuFirstName.setBounds(133, 163, 146, 26);
		customerMenu.add(customerMenuFirstName);
		customerMenuFirstName.setColumns(10);

		textField = new JTextField();
		textField.setBounds(400, 163, 146, 26);
		customerMenu.add(textField);
		textField.setColumns(10);

		customerMenuStreetAddress = new JTextField();
		customerMenuStreetAddress.setBounds(133, 204, 146, 26);
		customerMenu.add(customerMenuStreetAddress);
		customerMenuStreetAddress.setColumns(10);

		// customerMenuCity = new JTextField();
		// customerMenuCity.setBounds(327, 204, 146, 26);
		// customerMenu.add(customerMenuCity);
		// customerMenuCity.setColumns(10);

		// JComboBox customerMenuState = new JComboBox();
		// customerMenuState.setBounds(554, 204, 36, 26);
		// customerMenu.add(customerMenuState);
		JTextField customerMenuState = new JTextField();
		customerMenuState.setBounds(400, 204, 36, 26);
		customerMenu.add(customerMenuState);
		customerMenuState.setColumns(10);

		// customerMenuPhoneNumber = new JTextField();
		// customerMenuPhoneNumber.setBounds(133, 263, 146, 26);
		// customerMenu.add(customerMenuPhoneNumber);
		// customerMenuPhoneNumber.setColumns(10);

		customerMenuZip = new JTextField();
		customerMenuZip.setBounds(133, 248, 146, 26);
		customerMenu.add(customerMenuZip);
		customerMenuZip.setColumns(10);

		JButton btnCustomerMenuCreateCustomer = new JButton("Create Customer");
		btnCustomerMenuCreateCustomer.setBounds(239, 320, 167, 29);
		customerMenu.add(btnCustomerMenuCreateCustomer);

		btnCustomerMenuCreateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int newCustomerId = bLogic.createCustomer(
					textField.getText(),
					customerMenuFirstName.getText(),
					customerMenuStreetAddress.getText(),
					customerMenuState.getText(),
					customerMenuZip.getText()
				);

				JOptionPane.showMessageDialog(null, "New customer created with ID: " + newCustomerId);
				textField.setText("");
				customerMenuFirstName.setText("");
				customerMenuStreetAddress.setText("");
				customerMenuState.setText("");
				customerMenuZip.setText("");
			}
		});


		//Room Menu ----------------------------------------------------------------
		final JPanel roomMenu = new JPanel();
		roomMenu.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(roomMenu, "name_1079664024329636");
		roomMenu.setLayout(null);
		roomMenu.setVisible(false);

		JButton showRoomMenu = new JButton("Room Menu");
		showRoomMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomMenu.setVisible(true);
				mainMenu.setVisible(false);

			}
		});
		showRoomMenu.setBounds(43, 231, 235, 29);
		mainMenu.add(showRoomMenu);

		JLabel lblRoomMenu = new JLabel("Room Menu");
		lblRoomMenu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblRoomMenu.setForeground(Color.WHITE);
		lblRoomMenu.setBounds(543, 16, 127, 20);
		roomMenu.add(lblRoomMenu);

		JButton btnRoomMenuBack = new JButton("Back");
		btnRoomMenuBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.setVisible(true);
				roomMenu.setVisible(false);
			}
		});
		btnRoomMenuBack.setBounds(555, 367, 115, 29);
		roomMenu.add(btnRoomMenuBack);

		JLabel lblFindRoomOfType = new JLabel("Room Type");
		lblFindRoomOfType.setForeground(Color.WHITE);
		lblFindRoomOfType.setBounds(15, 100, 98, 20);
		roomMenu.add(lblFindRoomOfType);

		JLabel lblFindRoomCheckIn = new JLabel("Check-in Date");
		lblFindRoomCheckIn.setForeground(Color.WHITE);
		lblFindRoomCheckIn.setBounds(15, 139, 98, 20);
		roomMenu.add(lblFindRoomCheckIn);

		JLabel lblFindRoomCheckOut = new JLabel("Check-out Date");
		lblFindRoomCheckOut.setForeground(Color.WHITE);
		lblFindRoomCheckOut.setBounds(15, 175, 119, 20);
		roomMenu.add(lblFindRoomCheckOut);

		String[] typeStr = { "Double", "Queen"};
		JComboBox<String> findRoomofType = new JComboBox<>(typeStr);
		findRoomofType.setBounds(154, 100, 146, 26);
		roomMenu.add(findRoomofType);
		// findRoomofType.setColumns(10);


		findRoomCheckIn = new JFormattedTextField(df);
		findRoomCheckIn.setBounds(154, 136, 146, 26);
		roomMenu.add(findRoomCheckIn);
		findRoomCheckIn.setColumns(10);

		findRoomCheckOut = new JFormattedTextField(df);
		findRoomCheckOut.setBounds(154, 172, 146, 26);
		roomMenu.add(findRoomCheckOut);
		findRoomCheckOut.setColumns(10);

		JButton btnFindAvailableRooms = new JButton("Find Available Rooms");
		btnFindAvailableRooms.setBounds(55, 250, 185, 29);
		roomMenu.add(btnFindAvailableRooms);

		btnFindAvailableRooms.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String checkInStr = findRoomCheckIn.getText();
				String checkOutStr = findRoomCheckOut.getText();
				if ((checkInStr.equals("")) || (checkOutStr.equals(""))) //textfield is empty
				{
					JOptionPane.showMessageDialog(null, "Please input date using yyyy-MM-dd");
				}
				else
				{
					RoomTypes r = RoomTypes.doublebed;
					String theType = findRoomofType.getSelectedItem().toString();
					if (theType.equals("Double"))
					{
						r = RoomTypes.doublebed;
					}
					else if (theType.equals("Queen"))
					{
						r = RoomTypes.queen;
					}

					Date checkInD = Date.valueOf(checkInStr);
					Date checkOutD = Date.valueOf(checkOutStr);

					ArrayList<Room> availRooms = bLogic.findAvailableRooms(checkInD, checkOutD, r);
					if (availRooms.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "No rooms available");
					}
					else
					{
						String str = "";
						for(Room aRoom : availRooms)
						{
							RoomTypes rType = aRoom.RoomType();
							str += "Room ID: " + aRoom.RoomId() +
								"\nRoom Type: " + rType +
								"\n\n\n";
						}
						JOptionPane.showMessageDialog(null, str);
					}
				}
			}
		});

		// JLabel lblRoomNumber = new JLabel("Room Number");
		// lblRoomNumber.setForeground(Color.WHITE);
		// lblRoomNumber.setBounds(351, 86, 104, 20);
		// roomMenu.add(lblRoomNumber);

		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setForeground(Color.WHITE);
		lblRoomType.setBounds(365, 122, 104, 20);
		roomMenu.add(lblRoomType);

		// roomMenuRoomNumber = new JTextField();
		// roomMenuRoomNumber.setBounds(462, 83, 146, 26);
		// roomMenu.add(roomMenuRoomNumber);
		// roomMenuRoomNumber.setColumns(10);

		// JComboBox roomMenuRoomType = new JComboBox();
		JComboBox<String> roomMenuRoomType = new JComboBox<>(typeStr);
		roomMenuRoomType.setBounds(462, 119, 110, 26);
		roomMenu.add(roomMenuRoomType);

		JButton btnCreateRoom = new JButton("Create Room");
		btnCreateRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				RoomTypes r = RoomTypes.doublebed;
				String theType = roomMenuRoomType.getSelectedItem().toString();
				if (theType.equals("Queen"))
				{
					r = RoomTypes.queen;
				}
				bLogic.createRoom(r);
			}
		});
		btnCreateRoom.setBounds(462, 161, 146, 29);
		roomMenu.add(btnCreateRoom);

		roomMenuRoomNumber = new JTextField();
		roomMenuRoomNumber.setBounds(462, 230, 146, 26);
		roomMenu.add(roomMenuRoomNumber);
		roomMenuRoomNumber.setColumns(10);

		JComboBox<String> roomMenuRoomTypeEdit = new JComboBox<>(typeStr);
		roomMenuRoomTypeEdit.setBounds(462, 260, 110, 26);
		roomMenu.add(roomMenuRoomTypeEdit);

		JButton btnEditRoom = new JButton("Edit Room");
		btnEditRoom.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int theRoomNum = 0;
				try
				{
					theRoomNum = Integer.parseInt(roomMenuRoomNumber.getText());

					RoomTypes r = RoomTypes.doublebed;
					String theType = roomMenuRoomTypeEdit.getSelectedItem().toString();
					if (theType.equals("Queen"))
					{
						r = RoomTypes.queen;
					}
					if (bLogic.editRoom(theRoomNum, r))
					{
						JOptionPane.showMessageDialog(null, "Room edited successfully");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Room does not exist");
					}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Room Number must be a number");
				}
			}
		});
		btnEditRoom.setBounds(462, 290, 146, 29);
		roomMenu.add(btnEditRoom);

		//Reservation Check-out Menu -----------------------------------------------
		final JPanel reservationCheckoutMenu = new JPanel();
		reservationCheckoutMenu.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(reservationCheckoutMenu, "name_1079664031624391");
		reservationCheckoutMenu.setLayout(null);
		reservationCheckoutMenu.setVisible(false);

		JButton reservationCheckOutForm = new JButton("Reservation Check-out");
		reservationCheckOutForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservationCheckoutMenu.setVisible(true);
				mainMenu.setVisible(false);
			}
		});
		reservationCheckOutForm.setBounds(335, 231, 235, 29);
		mainMenu.add(reservationCheckOutForm);

		JLabel lblReservationCheckOut = new JLabel("Reservation Check Out");
		lblReservationCheckOut.setForeground(Color.WHITE);
		lblReservationCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblReservationCheckOut.setBounds(428, 16, 242, 20);
		reservationCheckoutMenu.add(lblReservationCheckOut);

		JLabel lblReservationId = new JLabel("Reservation ID");
		lblReservationId.setForeground(Color.WHITE);
		lblReservationId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReservationId.setBounds(15, 83, 132, 20);
		reservationCheckoutMenu.add(lblReservationId);

		checkOutReservationID = new JTextField();
		checkOutReservationID.setBounds(162, 82, 318, 26);
		reservationCheckoutMenu.add(checkOutReservationID);
		checkOutReservationID.setColumns(10);

		JButton btnFindId = new JButton("Find ID");
		btnFindId.setBounds(162, 124, 146, 29);
		reservationCheckoutMenu.add(btnFindId);

		JButton reservationCheckOutBack = new JButton("Back");
		reservationCheckOutBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainMenu.setVisible(true);
				reservationCheckoutMenu.setVisible(false);
			}
		});
		reservationCheckOutBack.setBounds(555, 367, 115, 29);
		reservationCheckoutMenu.add(reservationCheckOutBack);

		JButton reservationCheckOut = new JButton("Check Out");
		reservationCheckOut.setBounds(334, 124, 146, 29);
		reservationCheckoutMenu.add(reservationCheckOut);
	}
}
