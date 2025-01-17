import java.util.Random;
import java.util.Scanner;


class GuessGameWithMethods {

    private final int MAX_NUMBER = 10;
    private final int MIN_NUMBER = 0;
    private int amountOfAttempts = 3;
    private boolean gameIsOn;
    private Scanner scanner;

    void playTheGame() {
        scanner = new Scanner(System.in);
        startTheGame();

        int randomNumber = generateAndGetNumber();
        do {
            int userNumber = getUserNumber();
            analiseNumbers(randomNumber, userNumber);
        } while (amountOfAttempts > 0 && gameIsOn);
        ifStartAgain();
    }

    private void startTheGame() {
        gameIsOn = true;
        amountOfAttempts = 3;
        greeting();
    }

    private void analiseNumbers(int randomNumber, int userNumber) {
        if (randomNumber > userNumber) {
            System.out.println("Загаданное число больше");
            amountOfAttempts--;
        } else if (randomNumber < userNumber) {
            System.out.println("Загаданное число меньше");
            amountOfAttempts--;
        } else {
            System.out.println("Победа!!!");
            gameIsOn = false;
        }
    }

    private void greeting() {
        System.out.printf("Привет, давай сыграем  в игру! Я загадал число от %d до %d, и у тебя есть %d попыток угадать его!\n", MIN_NUMBER, MAX_NUMBER, amountOfAttempts);
    }

    //ввод от пользователя делаем безопасным!
    private int getUserNumber() {
        System.out.printf("Введите число, у тебя еще %d попыток:\n", amountOfAttempts);
        while (!scanner.hasNextInt()) {
            System.out.println("Упс, что-то не то, попробуйте ещё раз");
            scanner.next();// Очищаем буфер ввода
        }
        return scanner.nextInt();
    }

    private int generateAndGetNumber() {
        Random random = new Random();
        return random.nextInt(MIN_NUMBER, MAX_NUMBER);
    }

    private void ifStartAgain() {
        System.out.println("Хотите сыграть снова? 1 - Да, 0 - Нет: ");
        checkTheAnswer(scanner.next());
    }

    //ввод от пользователя делаем безопасным!
    private void checkTheAnswer(String next) {
        while (!next.equals("1") && !next.equals("0")) {
            System.out.println("Неверный ввод. Пожалуйста, введите 1 или 0.");
            next = scanner.next();
        }
        if (next.equals("1")) {
            playTheGame();
        } else {
            finishTheGame();
        }
    }

    private void finishTheGame() {
        System.out.println("Круто сыграли, приходи еще!");
        scanner.close();
    }
}
