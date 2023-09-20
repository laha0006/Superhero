package superhero;

import java.util.ArrayList;
import java.util.Objects;

public class Database {
    private final ArrayList<Superhero> superheroList;

    public Database() {
        superheroList = new ArrayList<>();
        superheroList.add(new Superhero("Superman", "Clark Kent", false, "Super.", 1950, 999));
        superheroList.add(new Superhero("Batman", "Bruce Wayne", true, "Bat", 1940, 100));
        superheroList.add(new Superhero("Arrow", "Joe Spencer", true, "Arrow guy", 1950, 100));
        superheroList.add(new Superhero("Spiderman", "Peter Parker", true, "Spider allergy", 1930, 88));
        superheroList.add(new Superhero("Fat Fury", "Herbie Popnecker", true, "Fat fury, what more to say", 1958, 200));
    }

    public void addSuperhero(Superhero superhero) {
        superheroList.add(superhero);
    }

    public Superhero search(String superheroName) {
        for (Superhero superhero : superheroList) {
            if (superhero.getName().toLowerCase().contains(superheroName.toLowerCase())) {
                return superhero;
            }
        }
        return null;
    }

    public ArrayList<Superhero> searchMany(String superheroName) {
        ArrayList<Superhero> superheroes = new ArrayList<>();
        for (Superhero superhero : superheroList) {
            if (superhero.getName().toLowerCase().contains(superheroName.toLowerCase())) {
                superheroes.add(superhero);
            }
        }
        return superheroes;
    }

    public ArrayList<Superhero> getSuperheroList() {
        return superheroList;
    }

    @Override
    public String toString() {
        return "superhero.Database{" +
                "superheroList=" + superheroList +
                '}';
    }

    public void delete(int index) {
        superheroList.remove(index);
    }

}
