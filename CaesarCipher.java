/**
 * CaesarCipher class implements Caesar cipher encryption and decryption
 * 
 * @author Suleman
 *
 */
public class CaesarCipher extends CipherStrategy {

	/**
	 * Encrypts the text passed in using Caesar cipher
	 * 
	 * @param text
	 *            to be encrypted
	 * @return the encrypted text
	 */
	@Override
	public String encryptText(String text) {

		char[] chars = text.toCharArray();
		char[] encryptArray = new char[chars.length];
		char shift = 3;

		for (int i = 0; i < chars.length; i++) {
			encryptArray[i] = (char) ((chars[i] + shift) % 255);

		}

		String str = String.valueOf(encryptArray);
		return str;
	}

	/**
	 * Decrypt the text passed in using Caesar cipher
	 * 
	 * @param text
	 *            to be decrypted
	 * @return the decrypted text
	 */
	@Override
	public String decryptText(String text) {
		char[] chars = text.toCharArray();
		char[] decryptArray = new char[chars.length];
		char shift = 3;

		for (int i = 0; i < chars.length; i++) {

			decryptArray[i] = (char) ((chars[i] - shift) % 255);

		}

		String str = String.valueOf(decryptArray);

		return str;
	}

}
