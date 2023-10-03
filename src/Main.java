import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws LengthException {
        String[] personData = {"25.09.1989 321412 ivanov ivan ivanovich m ","25.09.1989 3214212 ivanov ivan ivanovich m ","25.09.1989 3211412 ivanov ivan ivanovich m ","f popova 12.03.2000 olga 435423 sergeevna", "sergeev viktor 3221 m", "kuznetsova 345672 30.12.1990 ekaterina f igorevna"};
        for (String str :personData){
            try{
                Person person = new Person(str);
                try (FileWriter writer = new FileWriter(person.getSurname(), true)) {
                    writer.write(person.toString());
                    System.out.printf("Данные добавлены в файл: %s\n", person.getSurname());
                } catch (Exception e){
                    System.out.println("Ошибка, данные не добавлены");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }


}