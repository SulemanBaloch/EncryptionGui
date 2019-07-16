/**
 * AtbashCipher class implements atbash cipher encryption and decryption
 * @author Suleman
 *
 */
public class AtbashCipher extends CipherStrategy {

	/*text array*/
	private static final String TEXT = "abcdefghijklmnopqrstuvwxyz";
	/*ciphered text array*/
	private static final String CIPHEREDTEXT = "zyxwvutsrqponmlkjihgfedcba";

	/**
	 * Encrypts the text passed in using atbash cipher
	 * 
	 * @param text
	 *            to be encrypted
	 * @return the encrypted text
	 */
	@Override
	public String encryptText(String text) {

		char[] stringArray = text.toCharArray();
		char[] encryptArray = new char[stringArray.length];

		for (int i = 0; i < stringArray.length; i++) {
			char character = stringArray[i];
			int index = TEXT.indexOf(character);
			encryptArray[i] = CIPHEREDTEXT.toCharArray()[index];
		}

		String str = String.valueOf(encryptArray);

		return str;
	}
	
	/**
	 * Decrypt the text passed in using atbash cipher
	 * 
	 * @param text
	 *            to be decrypted
	 * @return the decrypted text
	 */
	@Override
	public String decryptText(String text) {

		char[] encryptArray = text.toCharArray();
		char[] chars = new char[encryptArray.length];

		for (int i = 0; i < chars.length; i++) {
			char character = encryptArray[i];
			int index = CIPHEREDTEXT.indexOf(character);
			chars[i] = TEXT.toCharArray()[index];

		}

		String str = String.valueOf(chars);

		return str;
	}

}
