package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Person[] PEOPLE = {new Person(1, "First"), new Person(2, "Second"),
    new Person(3, "Third")};
    private Database database;

    @Before
    public void setConstructor() throws OperationNotSupportedException {
        this.database = new Database(PEOPLE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWhenLessThanOneElement() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        Database database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        Database database = new Database(people);
    }

    @Test
    public void testPersonArrayLengthBetweenOneAndSixteen() throws OperationNotSupportedException {
        Person[] databasePeople = database.getElements();
        Assert.assertEquals(databasePeople.length, PEOPLE.length);
        for (int i = 0; i < databasePeople.length; i++) {
            Assert.assertEquals(PEOPLE[i], databasePeople[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddPerson() throws OperationNotSupportedException {
        database.add(new Person(7, "Person"));
        Assert.assertEquals(PEOPLE.length + 1, database.getElements().length);
        Assert.assertEquals(PEOPLE[2].getId(), database.getElements()[2].getId());
        Assert.assertEquals(PEOPLE[2].getUsername(), database.getElements()[2].getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveFromEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveElementAtLastIndex() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(PEOPLE.length - 1, database.getElements().length);
        Person[] peopleInDatabase = database.getElements();
        for (int i = 0; i < peopleInDatabase.length; i++) {
            Assert.assertEquals(peopleInDatabase[i], database.getElements()[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindNonExistingPersonByUsername() throws OperationNotSupportedException {
        database.findByUsername("Fourth");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonWithNullParameter() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testFindExistingPersonByUsername() throws OperationNotSupportedException {
        Person foundPerson = database.findByUsername("First");
        Assert.assertEquals(foundPerson.getUsername(), PEOPLE[0].getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindNonExistingPersonById() throws OperationNotSupportedException {
        database.findById(6);
    }

    @Test
    public void testFindExistingPersonById() throws OperationNotSupportedException {
        Person foundPerson = database.findById(2);
        Assert.assertEquals(foundPerson.getId(), PEOPLE[1].getId());
    }
}
