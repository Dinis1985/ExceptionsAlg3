import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class RecordFile {
    
    private DataConversion data;

    public RecordFile(DataConversion data) {
        this.data = data;
    }

    private  String getString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String birthdate = this.data.getBirthdate().getBirthdate().format(formatter);
        String string = this.data.getFullName().getSurname() + " " + this.data.getFullName().getName() + " " +
                        this.data.getFullName().getPatronymic() + " " + birthdate + " " + 
                        this.data.getNumberphone().getNumberphone() + " " + this.data.getSex().getSex() + "\n";
        return string;
    }

    public void write() {
        String path = this.data.getFullName().getSurname();

        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(path, true));
            bf.write(getString());
            bf.close();
        } catch (IOException e) {
            new IOException("Ошибка: файл записать не удалось");
        }
    }
}
