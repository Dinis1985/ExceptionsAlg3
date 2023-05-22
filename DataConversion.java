import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class DataConversion {
    
    private GetInformation data;
    private FullName fullName;
    private Birthdate birthdate;
    private Sex sex;
    private Numberphone numberphone;
   
    public DataConversion(GetInformation data) {
        this.data = data;
        setNumberphone(numberphone);
        setSex(sex);
        setBirthdate(birthdate);
        setFullName(fullName);
    }

    private boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.UnicodeBlock.of(s.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC) || s.charAt(i) == '-') {
                return true;
            }
        }
        return false;
    }

    public FullName getFullName() {
        return fullName;
    }

    private void setFullName(FullName fullName) {
        int counter = 0;
        for (int i = 0; i < data.getParseData().length; i++) {
            if(isValid(data.getParseData()[i]) && i + 2 < data.getParseData().length && isValid(data.getParseData()[i + 1]) && isValid(data.getParseData()[i + 2])) {
                this.fullName = new FullName(data.getParseData()[i], data.getParseData()[i + 1], data.getParseData()[i + 2]);
                counter++;
            }
        }
        if (counter == 0) {
            throw new NumberFormatException("Отсутствует фамилия, имя, отчество в формате - Фамилия Имя Отчество!");
        }
    }

    public Birthdate getBirthdate() {
        return birthdate;
    }

    private void setBirthdate(Birthdate birthdate) {
        int counter = 0;
        for (int i = 0; i < data.getParseData().length; i++) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
                this.birthdate = new Birthdate(LocalDate.parse(data.getParseData()[i], formatter));
            } catch (DateTimeParseException e) {
                counter++;
                continue;
            }
        }
        if (counter == data.getParseData().length) {
            throw new NumberFormatException("Отсутствует дата_рождения в формате - строка dd.mm.yyyy!");
        } 
    }

    public Sex getSex() {
        return sex;
    }

    private void setSex(Sex sex) {
        int counter = 0;
        for (int i = 0; i < data.getParseData().length; i++) {
            if(data.getParseData()[i].equals("f") || data.getParseData()[i].equals("m")) {
                 this.sex = new Sex(data.getParseData()[i].charAt(0));
                counter++;
            }
        }
        if (counter == 0) {
            throw new NumberFormatException("Отсутствует пол в формате - символ латиницей f или m!");
        } 
    }

    public Numberphone getNumberphone() {
        return numberphone;
    }

    private void setNumberphone(Numberphone numberphone) {
        int counter = 0;
        for (int i = 0; i < data.getParseData().length; i++) {
            try {
                this.numberphone = new Numberphone(Long.parseLong(data.getParseData()[i]));
            } catch (NumberFormatException e) {
                counter++;
                continue;
            }
        }
        if (counter == data.getParseData().length) {
            throw new NumberFormatException("Отсутствует номер_телефона в формате - целое беззнаковое число без форматирования!");
        } 
    }

}