public class Sex {
    
    private char sex;

    public Sex(char sex) {
        this.sex = sex;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "{" + sex + "}";
    }
}