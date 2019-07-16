import javax.swing.JFrame;

/**
 * EnrollmentApplication is the class that runs the program
 * @author Suleman
 *
 */
public class EncryptionApplication{

	// Creates a panel
	private EncryptionController panel;

	/**
	 * Constructor of EnrollmentApplication Creates a Jframe and adds view panel
	 * to the frame
	 *
	 */
	public EncryptionApplication() {

		panel = new EncryptionController();
		// Creates a JFrame
		JFrame frame = new JFrame();
		// Resize Frame
		frame.setSize(600, 600);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add panel to frame
		frame.add(panel);

		frame.setVisible(true);
	}

	/**
	 * Runs the application
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {

		EncryptionApplication application = new EncryptionApplication();
			
	        
	        
	   

	}
}
