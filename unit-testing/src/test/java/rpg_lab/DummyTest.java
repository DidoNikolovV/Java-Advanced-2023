package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 5;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EXPERIENCE = 10;

    private static int EXPECTED_DURABILITY = AXE_DURABILITY - 1;
    private static int EXPECTED_HEALTH = DUMMY_HEALTH - AXE_ATTACK;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setup() {
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);

    }

    @Test
    public void dummyLosesHealthIfAttacked() {
        axe.attack(dummy);
        Assert.assertEquals(EXPECTED_HEALTH, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deathDummyThrowsIfAttacked() {
        axe.attack(dummy);
        axe.attack(dummy);
        axe.attack(dummy);
    }

    @Test
    public void deathDummyGivesXP() {
        axe.attack(dummy);
        Assert.assertEquals(DUMMY_EXPERIENCE, DUMMY_EXPERIENCE);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP() {
        dummy.giveExperience();
    }
}
