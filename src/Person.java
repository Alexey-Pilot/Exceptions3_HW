import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate;
    private String phoneNumber;
    private String gender;

    public String getSurname() {
        return surname;
    }

    public Person(String surname, String name, String patronymic, String birthDate, String phoneNumber, String gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }


    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%s><%s>\n", surname, name, patronymic, birthDate, phoneNumber, gender);
    }

    public Person(String personData) throws LengthException {
        String[] info = personData.split(" ");
                if (info.length != 6)throw new LengthException();
                ArrayList<String> fullName = new ArrayList<>();
                for (String string : info) {
                    if (isDate(string)) {
                        this.birthDate = string;
                    } else if (isNumber(string)) {
                        this.phoneNumber = string;
                    } else if (isGender(string)) {
                        this.gender = string;
                    } else if (isChars(string)) {
                        fullName.add(string);
                    }
                }
                this.surname = fullName.get(0);
                this.name = fullName.get(1);
                this.patronymic = fullName.get(2);

        }


    private boolean isDate(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            format.parse(date);

        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String num) {
        if (num.length() < 5) {
            return false;
        }
        try {
            Integer.parseInt(num);

        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    boolean isGender(String male) {
        return male.equals("f") || male.equals("m");
    }

    private boolean isChars(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i)) && !name.contains("-")) return false;
        }
        return true;
    }

}
