import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Database {
    private final ArrayList<Superhero> superheroList = new ArrayList<>();
    public Database() {}

//    public Database(Superhero[] superheroList) {
//        this.superheroList = superheroList;
//    }

    public void addSuphero(String name, String realName, boolean isHuman, String superPower, int creationYear, int strength) {
        superheroList.add(new Superhero(name,realName,isHuman,superPower,creationYear,strength));
    }

    @Override
    public String toString() {
        return "Database{" +
                "superheroList=" + superheroList +
                '}';
    }
}
