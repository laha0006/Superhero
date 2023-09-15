import java.lang.reflect.Array;
import java.util.ArrayList;

public class Database {
    private final ArrayList<Superhero> superheroList;
    public Database() {
        superheroList = new ArrayList<>();
        superheroList.add(new Superhero("Superman","Clark Kent",false,"Super.",999,1950));
        superheroList.add(new Superhero("Batman","Bruce Wayne",true,"Bat",100,1940));
        superheroList.add(new Superhero("Arrow","Joe Spencer",true,"Arrow guy",20,1950));
        superheroList.add(new Superhero("Spiderman","Peter Parker",true,"Spider allergy",80,1930));
        superheroList.add(new Superhero("Fat Fury","Herbie Popnecker",true,"Fat fury, what more to say",500,1958));
    }
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

    public ArrayList<Superhero> searchMany(String superheroName) {
        ArrayList<Superhero> superheroes = new ArrayList<>();
        for(Superhero superhero : superheroList) {
            if(superhero.getName().contains(superheroName)) {
                System.out.println("Found!");
                superheroes.add(superhero);
            }
        }
        return superheroes;
    }


    @Override
    public String toString() {
        return "Database{" +
                "superheroList=" + superheroList +
                '}';
    }
}
