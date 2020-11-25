package rpg_tests;

import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;

public class DummyTests {
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 5;
    private static final int EXPECTED_HEALTH = 5;

    private Dummy dummy;

    @Before
    public void initializeTestObject() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void testDummyLosesHealthWhenAttacked() {
        this.dummy.takeAttack(ATTACK_POINTS);
        assertEquals(EXPECTED_HEALTH, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsExceptionWhenAttacked() {
        Dummy dummy = new Dummy(0, DUMMY_EXPERIENCE);
        dummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyCanGiveExperience() {
        Dummy dummy = new Dummy(0, DUMMY_EXPERIENCE);
        assertEquals(10, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyCannotGiveExperience() {
        this.dummy.giveExperience();
    }
}
