package sample;

public class Utils {
    public static void waiteFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Была ошибка!!!");
        }
    }
}
