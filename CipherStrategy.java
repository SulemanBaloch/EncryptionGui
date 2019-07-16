/**
 * CipherStrategy class is abstract class for using different kinds
 * of encryption techniques
 * @author Suleman
 *
 */
public abstract class CipherStrategy {
	
	/**
	 * Encrypts the text passed in
	 * @param text to be encrypted
	 * @return the encrypted text
	 */
	public abstract String encryptText(String text);

	/**
	 * Decrypt the text passed in
	 * @param text to be decrypted
	 * @return the decrypted text
	 */
	public abstract String decryptText(String text);
}
