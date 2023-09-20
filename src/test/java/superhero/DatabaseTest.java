package superhero;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    public Database db;


    public DatabaseTest(){
        db = new Database();
    }

//    @BeforeEach
//    void setup() {
//        db.addSuperhero(new Superhero("Superman", "Clark Kent", false, "Super.", 1950, 999));
//        db.addSuperhero(new Superhero("Batman", "Bruce Wayne", true, "Bat", 1940, 100));
//        db.addSuperhero(new Superhero("Arrow", "Joe Spencer", true, "Arrow guy", 1950, 100));
//        db.addSuperhero(new Superhero("Spiderman", "Peter Parker", true, "Spider allergy", 1930, 88));
//        db.addSuperhero(new Superhero("Fat Fury", "Herbie Popnecker", true, "Fat fury, what more to say", 1958, 200));
//    }

//    @AfterEach
//    void teardown() {
//        db.deleteAll();
//    }

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
        ArrayList<Superhero> heroList1 = db.searchMany("man");
        ArrayList<Superhero> heroList2 = db.searchMany("mAn");
        assertAll("Should return ArrayList<Superhero> of size 3",
                ()-> assertEquals(3,heroList1.size()),
                () -> assertEquals(3,heroList2.size()));

    }

    @Test
    void testDelete() {
        //delete by index
        db.delete(0);
        assertAll("Deleting index 0(Superman), should make size 4,and the first object Batman",
                () -> assertEquals(4,db.getSuperheroList().size()),
                () -> assertEquals("Batman",db.getSuperheroList().get(0).getName()));
        //fail();
    }
}