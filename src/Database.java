import java.sql.Array;

public class Database {
    private Superhero[] superheroList = new Superhero[5];
    private int count = 0;

    public Database() {}
    public Database(Superhero[] superheroList) {
        this.superheroList = superheroList;
    }

    public void addSuphero(Superhero superhero) {
        superheroList[count++] = superhero;
    }

    public Superhero[] getSuperheroList() {
        return superheroList;
    }
}
