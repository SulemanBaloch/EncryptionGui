/**
 * Encryption Class is main class for encryption of text in the application. It
 * helps select the encryption type according to the user's choice.
 * 
 * @author Suleman
 *
 */
public class Encryption {
	/* the encryption strategy the user selects. */
	private CipherStrategy selectedStrategy;

	/**
	 * Encrypts the text
	 * 
	 * @param text
	 *            passed in to be encrypted
	 * @return encrypted text
	 */
	public String encrypt(String text) {

		return selectedStrategy.encryptText(text);
	}

	/**
	 * SelectStrategy selects the type of encryption the user wants to use
	 * 
	 * @param cipherMethod
	 *            type of encryption
	 */
	public void selectStrategy(String cipherMethod) {
		if (cipherMethod.equals("Copy")) {
			selectedStrategy = new CopyCipher();
		} else if (cipherMethod.equals("Caesar Cipher")) {
			selectedStrategy = new CaesarCipher();
		} else if (cipherMethod.equals("Atbash Cipher")) {
			selectedStrategy = new AtbashCipher();
		} else {
			selectedStrategy = new RailFenceCipher();
		}

	}

	/**
	 * Decrypts the text
	 * 
	 * @param text
	 *            passed in to be Decrypted
	 * @return Decrypted text
	 */
	public String decrypt(String text) {

		return selectedStrategy.decryptText(text);
	}

}
