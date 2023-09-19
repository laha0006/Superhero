package superhero;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    public Database db;


    public DatabaseTest(){
        db = new Database();
    }

    @Test
    void testSearch() {
        Superhero sh = db.search("super");
        //superheroList.add(new Superhero("Superman", "Clark Kent",
        // false, "Super.",
        // 1950, 999));
        assertAll("Search should return Superman object",
                () -> assertEquals("Superman",sh.getName()),
                () -> assertEquals("Clark Kent",sh.getRealName()),
                () -> assertFalse(sh.isHuman()),
                () -> assertEquals("Super.",sh.getSuperPower()),
                () -> assertEquals(1950,sh.getCreationYear()),
                () -> assertEquals(999,sh.getStrength()));

    }

    @Test
    void testSearchMany() {
        //superheroList.add(new Superhero("Superman", "Clark Kent", false, "Super.", 1950, 999));
        //superheroList.add(new Superhero("Batman", "Bruce Wayne", true, "Bat", 1940, 100));
        //superheroList.add(new Superhero("Arrow", "Joe Spencer", true, "Arrow guy", 1950, 100));
        //superheroList.add(new Superhero("Spiderman", "Peter Parker", true, "Spider allergy", 1930, 88));
        //superheroList.add(new Superhero("Fat Fury", "Herbie Popnecker", true, "Fat fury, what more to say", 1958, 200));
        ArrayList<Superhero> heroList1 = db.searchMany("man");
        ArrayList<Superhero> heroList2 = db.searchMany("mAn");
        assertAll("Should return ArrayList<Superhero> of size 3",
                ()-> assertEquals(3,heroList1.size()),
                () -> assertEquals(3,heroList2.size()));

    }
}