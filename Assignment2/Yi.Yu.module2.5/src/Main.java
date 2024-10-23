public class Main {
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(27);
        String plaintext = "defend the east wall of the castle";
        String encrypted = cipher.encrypt(plaintext);
        String decrypted = cipher.decrypt(encrypted);

        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}