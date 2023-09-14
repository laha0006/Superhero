import java.util.ArrayList;

public class Database {
    private final ArrayList<Superhero> superheroList = new ArrayList<>();
    public Database() {}
    public void addSuperhero(Superhero superhero) {
        superheroList.add(superhero);
    }

    public Superhero search(String superheroName) {
        for (Superhero superhero : superheroList) {
            if(superhero.getName().equals(superheroName)) {
                return superhero;
            }
        }

        return null;
    }


    @Override
    public String toString() {
        return "Database{" +
                "superheroList=" + superheroList +
                '}';
    }
}
