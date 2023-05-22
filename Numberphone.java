public class Numberphone {
    
    private long numberphone;

    public Numberphone(long numberphone) {
        this.numberphone = numberphone;
    }

    public long getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(long nunberphone) {
        this.numberphone = numberphone;
    }

    @Override
    public String toString() {
        return "{" + numberphone + "}";
    }
}