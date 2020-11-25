package rpg_tests;

import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;

public class AxeTests {
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int AXE_ATTACK_POINTS = 10;
    private static final int AXE_DURABILITY_POINTS = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY_POINTS - 1;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects() {
        this.axe = new Axe(AXE_ATTACK_POINTS, AXE_DURABILITY_POINTS);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void testWeaponLosesDurabilityAfterAttack() {
        this.axe.attack(dummy);
        assertEquals(EXPECTED_DURABILITY, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackingWithBrokenWeapon() {
        Axe axe = new Axe(AXE_ATTACK_POINTS, 0);
        axe.attack(dummy);
    }
}
