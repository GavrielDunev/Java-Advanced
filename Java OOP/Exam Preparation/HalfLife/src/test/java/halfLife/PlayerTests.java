package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PlayerTests {
    private Player player;
    private Gun gun1;
    private Gun gun2;

    @Before
    public void setUp() {
        this.player = new Player("Ivan", 100);
        gun1 = new Gun("Makarov", 50);
        gun2 = new Gun("Desert", 30);
    }

    @Test
    public void testConstructor() {
        Assert.assertNotNull(player.getGuns());
        Assert.assertNotNull(player.getUsername());
        Assert.assertTrue(player.getHealth() != 0);
    }

    @Test(expected = NullPointerException.class)
    public void testInvalidUsername() {
        new Player("", 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidHealth() {
        new Player("Pesho", -200);
    }

    @Test
    public void testGetUsername() {
        String expected = player.getUsername();
        Assert.assertEquals(expected, "Ivan");
    }

    @Test
    public void testGetHealth() {
        int expected = player.getHealth();
        Assert.assertEquals(expected, 100);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetGuns() {
        player.addGun(gun1);
        player.addGun(gun2);
        List<Gun> guns = player.getGuns();
        Assert.assertNotNull(guns);
        Assert.assertEquals(guns.size(), 2);
        guns.remove(gun2);
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageWithZeroHealth() {
        player.takeDamage(100);
        player.takeDamage(50);
    }
    
    @Test
    public void testTakeDamage(){
        player.takeDamage(50);
        Assert.assertEquals(player.getHealth(), 50);
    }

    @Test
    public void testTakeDamageMoreThanHealth() {
        player.takeDamage(200);
        Assert.assertEquals(0, player.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullGun() {
        player.addGun(null);
    }

    @Test
    public void testAddGun() {
        player.addGun(gun1);
        Gun gun = player.getGun(gun1.getName());
        Assert.assertNotNull(gun);
        Assert.assertEquals(gun1.getName(), gun.getName());
        Assert.assertEquals(player.getGuns().size(), 1);
    }

    @Test
    public void testRemoveGun() {
        player.addGun(gun1);
        player.addGun(gun2);
        Assert.assertTrue(player.removeGun(gun2));
        int size = player.getGuns().size();
        Assert.assertEquals(size, 1);
    }

    @Test
    public void testGetGun() {
        player.addGun(gun1);
        player.addGun(gun2);
        Gun expected = player.getGun(gun1.getName());
        Assert.assertEquals(expected.getName(), gun1.getName());
    }
}
