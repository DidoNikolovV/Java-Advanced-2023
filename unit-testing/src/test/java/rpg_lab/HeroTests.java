package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.fakeImplementations.FakeTarget;
import rpg_lab.fakeImplementations.FakeWeapon;

public class HeroTests {

    private static String HERO_NAME = "Lich King";
    private static int TARGET_XP = 0;

    private Target fakeTarget;
    private Weapon fakeWeapon;
    private Hero hero;

    private Weapon weaponMock;
    private Target targetMock;
    @Before
    public void setup() {
        this.fakeTarget = new FakeTarget();
        this.fakeWeapon = new FakeWeapon();
        this.hero = new Hero(HERO_NAME, weaponMock);
        this.weaponMock = Mockito.mock(Weapon.class);
        this.targetMock = Mockito.mock(Target.class);

    }

    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        hero.attack(targetMock);

        Assert.assertEquals("Wrong experience", TARGET_XP, hero.getExperience());

    }
}
