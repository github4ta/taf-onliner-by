package by.onliner.taf.utils;

public class Util {
    /**
     * Метод generateNickname(int numberOfCharacters) возвращает произвольную кобинацию букв латинского алфавита
     * (большие и малые) и цифр, например, asD23fD3s.
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
}
