import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws LengthException {
        String[] personData = {"25.09.1989 321412 ivanov ivan ivanovich m ", "25.09.1989 3214212 ivanov ivan ivanovich m ", "25.09.1989 3211412 ivanov ivan ivanovich m ", "f popova 12.03.2000 olga 435423 sergeevna", "sergeev viktor 32213223 nikolaevich 05.11.1980 m", "kuznetsova 345672 30.12.1990 ekaterina f igorevna"};
        for (String str : personData) {
            Person person = new Person(str);
            try (FileWriter writer = new FileWriter(person.getSurname(), true)) {
                    writer.write(person.toString());
                    System.out.printf("Данные добавлены в файл: %s\n", person.getSurname());
                } catch (Exception e) {
                    System.out.println("Ошибка, данные не добавлены");
                }

        }
        System.out.println();
        inputData();
    }




    private static Person inputData() throws LengthException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные: ");
        String personData = scanner.nextLine();
        try {Person person = new Person(personData);
            System.out.println("Данные добавлены");
            return person;
        } catch (LengthException e) {
            System.out.println("Некорректные данные, введите еще раз: ");
            inputData();
        }
        return null;
    }


}