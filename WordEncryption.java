public class StringEncryptor {

    public static String encryptText(String plainText, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char character : plainText.toCharArray()) {
            if (Character.isLetter(character)) {
                int baseValue = Character.isLowerCase(character) ? character - 'a' : character - 'A';
                int shiftedValue = (baseValue + shift) % 26;
                char shiftedCharacter = (char) ((Character.isLowerCase(character) ? 'a' : 'A') + shiftedValue);
                if (Character.isLowerCase(character)) {
                    shiftedCharacter = Character.toUpperCase(shiftedCharacter);
                } else {
                    shiftedCharacter = Character.toLowerCase(shiftedCharacter);
                }

                encryptedText.append(shiftedCharacter);
            } else {
                encryptedText.append(character);
            }
        }

        return encryptedText.toString();
    }

    public static void main(String[] args) {
        String plainText = "Wipro Tech";
        int shift = 20;
        String encryptedResult = encryptText(plainText, shift);
        System.out.println("Encrypted text: " + encryptedResult);
    }
}
