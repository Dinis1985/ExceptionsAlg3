import java.util.Scanner;

public class GetInformation {

    private Scanner input;
    private String dataString;
    private String[] parseData;

    public String[] getParseData() {
        return parseData;
    }

    public GetInformation() {
        System.out.println("Введите данные, используйте пробелы как разделители.");
        this.input = new Scanner(System.in, "cp866");
        this.dataString = this.input.nextLine();
        this.parseData = this.dataString.split(" ");
        if (parseData.length != 6) {
            throw new FormatException(parseData.length);
        }
    }

    public void printParseData() {
        for (int i = 0; i < this.parseData.length; i++) {
            System.out.println(this.parseData[i] + " ");
        }
    }
}