// package userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Menu window = new Main_Menu();
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
	public Main_Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 665, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblHotelReservationManager = new JLabel("Hotel Reservation Manager");
		lblHotelReservationManager.setForeground(Color.WHITE);
		lblHotelReservationManager.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHotelReservationManager.setBounds(305, 61, 299, 29);
		frame.getContentPane().add(lblHotelReservationManager);

		JButton btnShowReservationMenu = new JButton("Show Reservation Menu");
		btnShowReservationMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				btnShowReservationMenu.addMouseListener(new java.awt.event.MouseAdapter(){
					public void mouseEntered(java.awt.event.MouseEvent evt) {
						btnShowReservationMenu.setBackground(Color.GREEN);
					}
					public void mouseExited(java.awt.event.MouseEvent evt){
						btnShowReservationMenu.setBackground(Color.GREEN);
					}

			});
				}

		});
		btnShowReservationMenu.setBounds(44, 61, 225, 29);
		frame.getContentPane().add(btnShowReservationMenu);

		JButton btnCreateReservationForm = new JButton("Create Reservation Form");
		btnCreateReservationForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new Reservation();


			}
		});
		btnCreateReservationForm.setBounds(44, 106, 225, 29);
		frame.getContentPane().add(btnCreateReservationForm);

		JButton btnEditReservationForm = new JButton("Edit Reservation Form");
		btnEditReservationForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// editReservation();

			}
		});
		btnEditReservationForm.setBounds(44, 151, 225, 29);
		frame.getContentPane().add(btnEditReservationForm);

		JButton btnNewButton = new JButton("Reservation Checkout Form");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(323, 151, 260, 29);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Show Customer Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(44, 196, 225, 29);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnShowRoomMenu = new JButton("Show Room Menu");
		btnShowRoomMenu.setBounds(44, 241, 225, 29);
		frame.getContentPane().add(btnShowRoomMenu);

		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(403, 318, 225, 29);
		frame.getContentPane().add(btnNewButton_2);
	}
}
