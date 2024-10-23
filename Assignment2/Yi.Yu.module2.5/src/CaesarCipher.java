import java.util.HashMap;
import java.util.Map;

public class CaesarCipher {
    private int shift;
    private Map<Character, Character> encryptMap;
    private Map<Character, Character> decryptMap;

    public CaesarCipher(int shift) {
        this.shift = shift % 26;
        this.encryptMap = new HashMap<>();
        this.decryptMap = new HashMap<>();
        createCipherMaps();
    }

    private void createCipherMaps() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String upperAlphabet = alphabet.toUpperCase();

        for (int i = 0; i < 26; i++) {
            char plainChar = alphabet.charAt(i);
            char cipherChar = alphabet.charAt((i + shift) % 26);
            encryptMap.put(plainChar, cipherChar);
            decryptMap.put(cipherChar, plainChar);
            char upperPlainChar = upperAlphabet.charAt(i);
            char upperCipherChar = upperAlphabet.charAt((i + shift) % 26);
            encryptMap.put(upperPlainChar, upperCipherChar);
            decryptMap.put(upperCipherChar, upperPlainChar);
        }
    }

    public String encrypt(String message) {
        char[] transformed = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (encryptMap.containsKey(ch)) {
                transformed[i] = encryptMap.get(ch);
            } else {
                transformed[i] = ch;
            }
        }
        return new String(transformed);
    }

    public String decrypt(String message) {
        char[] transformed = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (decryptMap.containsKey(ch)) {
                transformed[i] = decryptMap.get(ch);
            } else {
                transformed[i] = ch;
            }
        }
        return new String(transformed);
    }
}
