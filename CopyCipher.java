/**
 * CopyCipher class implements copy cipher encryption and decryption
 * 
 * @author Suleman
 *
 */
public class CopyCipher extends CipherStrategy {

	/**
	 * Encrypts the text passed in using copy cipher
	 * 
	 * @param text
	 *            to be encrypted
	 * @return the encrypted text
	 */
	@Override
	public String encryptText(String text) {
		
		return text;
	}

	/**
	 * Decrypt the text passed in
	 * 
	 * @param text
	 *            to be decrypted
	 * @return the decrypted text
	 */
	public String decryptText(String text) {
		return text;
	}

}
