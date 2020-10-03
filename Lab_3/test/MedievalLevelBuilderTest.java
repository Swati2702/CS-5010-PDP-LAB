import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

import dungeon.Level;
import dungeon.MedievalLevelBuilder;

/**
 * Tests for Medieval Level Builder.
 *
 **/

public class MedievalLevelBuilderTest {
  private static Level level;

  @Test
  public void testInitialization() throws IOException {

    level = new MedievalLevelBuilder(1, 1, 1,
            1).addRoom("Room 1").addOgre(0).addPotion(0).build();

    String textToBeCompared = Files.readString(Paths.get("test\\TestStrings"));
    assertEquals(textToBeCompared.replace("\r", ""),level.toString());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsNegativeRoomNumber() {
    level = new MedievalLevelBuilder(1, -1, 1,
            1).addRoom("Room 1").addOgre(0).addPotion(0).build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsNegativeLevelNumber() {
    level = new MedievalLevelBuilder(-1, 1, 1,
            1).addRoom("Room 1").addOgre(0).addPotion(0).build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsNegativeMonsterNumber() {
    level = new MedievalLevelBuilder(1, 1, -1,
            1).addRoom("Room 1").
            addHuman(0, "jack", "man", 10)
            .addPotion(0).build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDisallowsNegativeTreasureNumber() {
    level = new MedievalLevelBuilder(1, 1, 1,
            -1).addRoom("Room 1").addOrc(0).addPotion(0).build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddGoblinsDisallowsNegativeRoomNumber() {
    level = new MedievalLevelBuilder(1, 1, 1,
            1).addRoom("Room 1").addGoblins(0, -1).
            addGold(0, 90).build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddWeaponDisallowsNegativeRoomNumber() {
    level = new MedievalLevelBuilder(1, 1, 1,
            1).addRoom("Room 1").addGoblins(0, -1).
            addWeapon(0, "Sword").build();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddSpecialDisallowsNegativeRoomNumber() {
    level = new MedievalLevelBuilder(1, 1, 1,
            1).addRoom("Room 1").addGoblins(0, -1).
            addSpecial(0, "Swords", 20).build();
  }


}
