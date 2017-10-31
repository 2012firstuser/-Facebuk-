import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserTests {
    private Person _personA, _personB, _personC, _personD, _personE;
    private Pet _petA, _petB, _petC;
    private Moment _momentA, _momentB, _momentC;

    @Before
    public void init() {
        this.initPeople();
        this.initPets();
        this.createConnections();
        this.createMoments();
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

    private void createConnections() {

        // Person A is friends with E, D, and C
        final ArrayList<Account> personAFriends = new ArrayList<>();

        personAFriends.add(this._personE);
        personAFriends.add(this._personD);
        personAFriends.add(this._personC);
        personAFriends.add(this._petB);

        // Person B is friends with E, D, and C
        final ArrayList<Account> personBFriends = new ArrayList<>();

        personBFriends.add(this._personE);
        personBFriends.add(this._personD);
        personBFriends.add(this._personC);

        // Person C is friends with B, A, and D, and E
        final ArrayList<Account> personCFriends = new ArrayList<>();

        personCFriends.add(this._personB);
        personCFriends.add(this._personA);
        personCFriends.add(this._personD);
        personCFriends.add(this._personE);

        // Person D is friends with E, A, B, & C
        final ArrayList<Account> personDFriends = new ArrayList<>();

        personDFriends.add(this._personE);
        personDFriends.add(this._personA);
        personDFriends.add(this._personB);
        personDFriends.add(this._personC);

        // Person E is friends with A, B, D
        final ArrayList<Account> personEFriends = new ArrayList<>();

        personEFriends.add(this._personA);
        personEFriends.add(this._personB);
        personEFriends.add(this._personC);
        personEFriends.add(this._personD);

        this._personA.setFriends(personAFriends);
        this._personB.setFriends(personBFriends);
        this._personC.setFriends(personCFriends);
        this._personD.setFriends(personDFriends);
        this._personE.setFriends(personEFriends);
    }
    private void createMoments() {

        this._momentA = new Moment("A",new Image("A.png" ),
                new ArrayList<Account>(Stream.of(this._personA, this._personB, this._petA, this._petB).collect(Collectors.toList())),
                new ArrayList<Float>(Stream.of( 1f,10f,3f,4f).collect(Collectors.toList())));
        this._personA.addMoment(_momentA);
        this._personB.addMoment(_momentA);
        this._petA.addMoment(_momentA);
        this._petB.addMoment(_momentA);

        this._momentB = new Moment("A",new Image("A.png" ),
                new ArrayList<Account>(Stream.of(this._personA, this._personC, this._petA, this._petB).collect(Collectors.toList())),
                new ArrayList<Float>(Stream.of( 1f,2f,3f,4f).collect(Collectors.toList())));
        this._personA.addMoment(_momentA);
        this._personB.addMoment(_momentA);
        this._petA.addMoment(_momentA);
        this._petB.addMoment(_momentA);

        this._personA.setMoments(new ArrayList<Moment>(Stream.of(this._momentA).collect(Collectors.toList())));
    }

    @Test
    public void testHappiestFriend(){
        assertEquals(this._personA.getFriendWithWhomIAmHappiest(), this._petB);
    }
    @Test
    public void testPeopleInits() {
        assertEquals(this._personA.getName(), "A");
    }

    @Test
    public void testFriends() {
        // Person A is friends with E, D, and C
        final ArrayList<Account> personAFriends = new ArrayList<>();

        personAFriends.add(this._personE);
        personAFriends.add(this._personD);
        personAFriends.add(this._personC);
        personAFriends.add(this._petB);

        assertEquals(this._personA.getFriends(), personAFriends);

    }

    @Test
    public void testSameObjects() {
        assertEquals("sweg", "sweg");
        assertEquals(new Person("test", new Image("Dank")), new Person("test", new Image("Dank")));
        assertEquals(this._personA, new Person("A", new Image("A.png")));
    }

    @Test
    public void testCliques() {
        final ArrayList<Account> personAMaxClique = new ArrayList<>();

        personAMaxClique.add(this._personA);
        personAMaxClique.add(this._personC);
        personAMaxClique.add(this._personE);
        personAMaxClique.add(this._personD);

        assertTrue(personAMaxClique.containsAll(this._personA.findMaximumCliqueOfFriends()) &&
                (this._personA.findMaximumCliqueOfFriends()).containsAll(personAMaxClique));

        assertTrue(Account.isClique(personAMaxClique));
    }

    //Checks that the function only works on friends, not pets or non-friends.
    //Also checks that the null returns work correctly.
    @Test
    public void testOverallHappiestFriend()
    {
        assertTrue(_personA.getFriendWithWhomIAmHappiest() == _personC);
        assertTrue(new Person("T",new Image("test.png")).getFriendWithWhomIAmHappiest() == null);
        assertTrue(_personA.getOverallHappiestMoment()==_momentA);
        assertTrue(new Person("T",new Image("test.png")).getOverallHappiestMoment() == null);
    }


}
