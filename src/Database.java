import java.sql.Array;
import java.util.Arrays;

public class Database {
    private Superhero[] superheroList = new Superhero[5];
    private int count = 0;

    public Database() {}
    public Database(Superhero[] superheroList) {
        this.superheroList = superheroList;
    }

    public void addSuphero(String name, String realName, boolean isHuman, String superPower, int creationYear, int strength) {
        superheroList[count++] = new Superhero(name,realName,isHuman,superPower,creationYear,strength);
    }

    public Superhero[] getSuperheroList() {
        return superheroList;
    }

    @Override
    public String toString() {
        return "Database{" +
                "superheroList=" + Arrays.toString(superheroList) +
                '}';
    }
}
