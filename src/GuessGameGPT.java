import java.util.Random;
import java.util.Scanner;

class GuessGameGPT {

    static void playTheGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess;
        int userInput;
        boolean playAgain;
        String response;

        do {
            // Загадали случайное число от 0 до 9
            numberToGuess = random.nextInt(10); // Генерируем число от 0 до 9

            System.out.println("Угадайте число от 0 до 9. У вас есть 3 попытки.");

            for (int attempt = 1; attempt <= 3; attempt++) {
                System.out.print("Введите ваше предположение: ");

                // Проверяем, что пользователь ввёл целое число
                while (!scanner.hasNextInt()) {
                    System.out.println("Вы ввели неверный формат числа. Попробуйте ещё раз:");
                    scanner.next(); // Очищаем буфер ввода
                }

                userInput = scanner.nextInt();

                if (userInput == numberToGuess) {
                    System.out.println("Верно! Вы угадали число.");
                    break;
                } else if (attempt != 3) { // Если попытка не последняя
                    if (userInput > numberToGuess) {
                        System.out.println("Ваше число больше загаданного.");
                    } else {
                        System.out.println("Ваше число меньше загаданного.");
                    }
                } else {
                    System.out.println("К сожалению, вы исчерпали все три попытки. Правильный ответ был: " + numberToGuess);
                }
            }

            System.out.println("\nХотите сыграть снова?");
            System.out.print("1 - Да, 0 - Нет: ");

            // Проверка корректности введенного значения для повтора игры
            while (!scanner.hasNextInt() || (response = scanner.next()).equals("1") && !response.equals("0")) {
                System.out.println("Неверный ввод. Пожалуйста, введите 1 или 0.");
                scanner.next(); // Очистим буфер ввода
            }

            playAgain = response.equals("1");
        } while (playAgain);

        System.out.println("Спасибо за игру!");
        scanner.close();
    }
}
/*Объяснение кода:
Импорт библиотек:
Scanner используется для получения данных от пользователя.
Random нужен для генерации случайных чисел.
Основная логика:
Программа генерирует случайное число от 0 до 9 при помощи метода nextInt(10) класса Random.
Пользователь получает три попытки угадать число.
После каждого неправильного ответа программа сообщает, больше или меньше введенное число, чем загаданное.
Если пользователь угадывает число раньше трёх попыток, цикл прерывается.
В конце каждой игры спрашивается, хочет ли игрок продолжить. Если он выбирает вариант "Да" (1), игра продолжается, иначе программа завершает работу.
Проверки:
Программа проверяет, является ли введённое значение целым числом. Если нет, она запрашивает новое значение.
Для выбора продолжения игры также проводится проверка, чтобы убедиться, что вводится либо 1, либо 0.*/