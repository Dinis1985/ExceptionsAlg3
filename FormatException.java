public class FormatException extends NumberFormatException {
    
    private int length;

    public FormatException(int length) {
        super(String.format("Введено: %d значений вместо 6 (<Фамилия><Имя><Отчество><датарождения><номертелефона><пол>)", length));
    }

    public int getLength() {
        return length;
    }

}