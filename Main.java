public class Main {
    public static void main(String[] args) {
        DataConversion newData = new DataConversion(new GetInformation());
        System.out.println(newData.getNumberphone() + " " + newData.getSex() + " " + newData.getBirthdate() + " " + newData.getFullName());
        RecordFile cFile = new RecordFile(newData);
        cFile.write();
    }
}
