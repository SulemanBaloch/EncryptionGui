/**
 * RailCipher class implements Rail cipher encryption and decryption
 * 
 * @author Suleman
 *
 */
public class RailFenceCipher extends CipherStrategy {

	/* number of rails */
	private static final int NUMRAILS = 3;

	/**
	 * Encrypts the text passed in using rail fence cipher
	 * 
	 * @param text
	 *            to be encrypted
	 * @return the encrypted text
	 */
	public String encryptText(String text) {
		char[] textArray = text.toCharArray();
		char[][] encryptedArray = new char[NUMRAILS][textArray.length];
		int movementDirection = 1;
		int numRow = 0;
		int numCol = 0;
		for (int i = 0; i < textArray.length; i++) {
			numRow = numRow % 3;
			numCol = i;
			// positive direction; down the rows
			if (movementDirection == 1) {
				encryptedArray[numRow][numCol] = textArray[i];
				numRow++;
			}
			// negative direction
			else {
				encryptedArray[numRow][numCol] = textArray[i];
				numRow--;
			}
			if (numRow == 0 && (movementDirection == -1)) {
				movementDirection = 1;
			} else if (numRow == 3 && (movementDirection == 1)) {
				movementDirection = -1;
				numRow = numRow - 2;
			}

		}

		String encryptedString = "";
		char nullChar = '\u0000';
		for (int m = 0; m < encryptedArray.length; m++) {
			for (int n = 0; n < encryptedArray[m].length; n++) {
				if (encryptedArray[m][n] != nullChar) {
					encryptedString += encryptedArray[m][n];
				}
			}
		}

		return encryptedString;
	}

	/**
	 * Decrypt the text passed in using Rail fence cipher
	 * 
	 * @param text
	 *            to be decrypted
	 * @return the decrypted text
	 */
	@Override
	public String decryptText(String text) {

		char[] decryptText = new char[text.length()];
		String[] lines = separateLines(text.length());

		for (int rows = 0; rows < NUMRAILS; rows++) {
			int start = 0;
			for (int j = 0; j < rows; j++) {
				start = start + lines[j].length();
			}
			int end = start + lines[rows].length();
			lines[rows] = text.substring(start, end);
		}

		int numLine = 0;
		// moving positively or negatively
		int movementDirection = 1;
		int[] posArray = new int[lines.length];
		for (int i = 0; i < posArray.length; i++) {
			posArray[i] = 0;
		}
		for (int i = 0; i < text.length(); i++) {
			decryptText[i] = lines[numLine].charAt(posArray[numLine]);
			posArray[numLine]++;
			numLine = numLine + movementDirection;
			if (numLine == 0 || numLine == NUMRAILS - 1) {
				movementDirection = movementDirection * (-1);
			}
		}
		String decryptedString = new String(decryptText);
		return decryptedString;
	}

	/**
	 * Separate the rails in rail fence cipher
	 * 
	 * @param stringLength
	 *            total word length
	 * @return array of string with lines
	 */
	public String[] separateLines(int stringLength) {
		String[] lines = new String[NUMRAILS];
		for (int i = 0; i < NUMRAILS; i++) {
			lines[i] = "";
		}
		int numLine = 0;
		int oppositeDirection = -1;
		int movementDirection = 1;
		for (int i = 0; i < stringLength; i++) {
			lines[numLine] = lines[numLine] + "?";
			numLine = numLine + movementDirection;
			if (numLine == 0 || numLine == NUMRAILS - 1) {
				movementDirection = movementDirection * oppositeDirection;
			}
		}
		return lines;
	}

}
