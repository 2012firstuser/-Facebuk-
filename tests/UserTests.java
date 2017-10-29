import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTests {
    private Person _personA, _personB, _personC, _personD, _personE;
    private Pet _petA, _petB, _petC;

    @Before
    public void init() {
        this.initPeople();
        this.initPets();
    }

    private void initPeople() {
        _personA = new Person("A", new Image("A.png"));
        _personB = new Person("B", new Image("B.png"));
        _personC = new Person("C", new Image("C.png"));
        _personD = new Person("D", new Image("D.png"));
        _personE = new Person("E", new Image("E.png"));
    }

    private void initPets() {
        _petA = new Pet("Pet A", new Image("PetA.png"));
        _petB = new Pet("Pet B", new Image("Pet B.png"));
        _petC = new Pet("Pet C", new Image("Pet C.png"));
    }

    @Test
    public void DummyTest() {
        assertEquals(1, 1);
    }
}
