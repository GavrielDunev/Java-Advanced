package rpg_tests;

import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

import static org.junit.Assert.assertEquals;

public class HeroTests {
    private static final int TARGET_EXPERIENCE = 10;
    private static final String HERO_NAME = "Hero";

    @Test
    public void testHeroGainsExperienceWhenAttackIfTargetIsDead() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_EXPERIENCE);

        Hero hero = new Hero(HERO_NAME, weaponMock);
        hero.attack(targetMock);
        assertEquals(TARGET_EXPERIENCE, hero.getExperience());
    }
}
