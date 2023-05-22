import java.time.LocalDate;

public class Birthdate {

    private LocalDate birthdate;

    public Birthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    } 

    @Override
    public String toString() {
        return "{" + birthdate + "}";
    }
}