package by.onliner.taf.utils;

import java.security.SecureRandom;
import java.util.Random;

public class Util {
    /**
     * Метод generateNickname(int numberOfCharacters) возвращает произвольную кобинацию букв латинского алфавита
     * (большие и малые) и цифр, например, asD23fD3s.
     *
     * @param numberOfCharacters Общее количество знаков в Nickname
     * @return Cгенерированный Nickname
     */
    public static String generateNickname(int numberOfCharacters) {
        String name = "";
        char ch;

        for (int i = 0; i < numberOfCharacters; i++) {
            do {
                ch = (char) (Math.random() * 74 + 48);
            } while ((57 < ch && ch < 65) || (90 < ch && ch < 97));
            name = name + ch;
        }
        return name;
    }

    /**
     * Метод generateNickname возвращает произвольную кобинацию букв латинского алфавита
     * (большие и малые) и цифр, например, asD23fD3s. Общее количество знаков всегда постоянное и равно 10.
     *  @return Cгенерированный Nickname
     */

    public static String generateNickname() {
        int length = 10;
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        char[] nickname = new char[length];

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            nickname[i] = characters.charAt(index);
        }
        return new String(nickname);
    }
    /**
     * Метод generatePassword возвращает произвольную комбинацию букв латинского алфавита (маленькие \ большие буквы), цифры 0 - 9, спецсимволы !@#$%&*.
     * Например, dkHd!d-#jfd
     * Общее количество знаков пароля может быть случайным от 8 до 16 включительно..
     *  @return Cгенерированный Password
     */
    public static String generatePassword() {
        Random random = new SecureRandom();
        final String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        final String specialCharacters = "!@#$%&*";
        final String allCharacters = letters + digits + specialCharacters;

        int length = random.nextInt(9) + 8;
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            char randomCharacter = allCharacters.charAt(randomIndex);
            password.append(randomCharacter);
        }
        return password.toString();
    }
}
