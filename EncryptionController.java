import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * EncryptionController class controls the encryption application and allows
 * user to interact with the application
 * 
 * @author Suleman
 *
 */
public class EncryptionController extends JPanel implements ActionListener {

	private static String[] ciphers = { "Copy", "Caesar Ciper", "Rail Fence", "Atbash Cipher" };

	// JCombo box
	private JComboBox cipherList;

	// Encrypt button
	private JButton encryptButton;

	// Decrypt button
	private JButton decryptButton;

	// Encryption method
	private String cipherMethod;

	// Encryption text
	private Encryption encryptText;


	// Area for plain text area
	private JTextArea textArea = new JTextArea(150, 150);

	// Area for cipher text
	private JTextArea cipherArea = new JTextArea(150, 150);

	/**
	 * Constructor of EnrollmentManager
	 *
	 */
	public EncryptionController() {

		// Creates a border layout
		super(new BorderLayout());
		setFocusable(true);

		// setups up the text areas and J labels
		setuptextArea();
		// creates an encryption object
		encryptText = new Encryption();
		// Creates buttons and JCombobox
		createButtonsAndMenu();

		repaint();
		validate();
	}

	/**
	 * Sets up the text areas and JLabels
	 */
	private void setuptextArea() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(new JLabel("Plain text"));
		mainPanel.add(textArea);
		mainPanel.add(new JLabel("Cipher text"));
		mainPanel.add(cipherArea);
		add(mainPanel, BorderLayout.CENTER);
	}

	/**
	 * Creates the buttons and the menu for the encryption application
	 * 
	 */
	public void createButtonsAndMenu() {

		// Creates a encrypt to button
		encryptButton = new JButton("encrypt");
		encryptButton.setBackground(Color.pink);
		encryptButton.setOpaque(true);
		encryptButton.addActionListener(this);

		// Creates a decrypt to button
		decryptButton = new JButton("decrypt");
		decryptButton.setBackground(Color.pink);
		decryptButton.setOpaque(true);
		decryptButton.addActionListener(this);
		// add the button to the button Panel

		// create menu for ciphers
		cipherList = new JComboBox(ciphers);
		cipherList.addActionListener(this);
		// selects a cipher type
		selectCipherType();

		// adds buttons and menu to button panelf
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		buttonPanel.add(encryptButton);
		buttonPanel.add(decryptButton);
		buttonPanel.add(cipherList);

		// Creates a panel that is displayed in the north
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		// Adds to the north of the panel
		add(northPanel, BorderLayout.SOUTH);

		// Add button panel to the north panel
		northPanel.add(buttonPanel);

	}

	/**
	 * Allows user to select different ciphers
	 */
	private void selectCipherType() {

		int selectedCipher = cipherList.getSelectedIndex();

		switch (selectedCipher) {

		case 1:
			cipherMethod = ciphers[1];
			break;

		case 0:
			cipherMethod = ciphers[0];

			break;

		case 2:

			cipherMethod = ciphers[2];
			break;

		case 3:
			cipherMethod = ciphers[3];
			break;
		default:
			// do nothing
		}

		encryptText.selectStrategy(cipherMethod);

	}

	/**
	 * Give a output according to user input
	 * 
	 * @param evt
	 *            is event when user presses a button
	 */
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource() == encryptButton) {

			cipherArea.setText(encryptText.encrypt(textArea.getText()));

		}

		else if (evt.getSource() == decryptButton) {

			textArea.setText(encryptText.decrypt(cipherArea.getText()));

		} else if (evt.getSource() == cipherList) {
			selectCipherType();
		}
	}

}
