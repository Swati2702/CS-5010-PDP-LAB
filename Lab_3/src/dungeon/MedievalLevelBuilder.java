package dungeon;


/**
 * Builder class that can be used to construct a level in a game that is set in a medieval fantasy.
 * This class will be used to not only build a level for a game, but it will also ensure that all
 * of the details of the game are consistent.
 * */
public class MedievalLevelBuilder {

  private final int numberOfRooms;
  private final int numberOfMonsters;
  private final int numberOfTreasures;
  private final Level level;
  private int roomCount = 0;
  private int monsterCount = 0;
  private int treasureCount = 0;

  /**
   * Constructor for MedievalLevelBuilder.
   * @param levelNumber a numeric representing which level this is.
   * @param numberOfRooms the target number of rooms in level {@code levelNumber}
   * @param numberOfMonsters the target number of monsters in level {@code levelNumber}
   * @param numberOfTreasures the target number of treasures in level {@code levelNumber}
   *
   * @throws IllegalArgumentException if any of the arguments os negative
   * */
  public MedievalLevelBuilder(int levelNumber, int numberOfRooms,int numberOfMonsters,
                              int numberOfTreasures) throws IllegalArgumentException {

    if (levelNumber < 0 || numberOfRooms < 0 || numberOfMonsters < 0
            || numberOfTreasures < 0) {
      throw new IllegalArgumentException("Negative values not allowed. ");
    }

    this.numberOfMonsters = numberOfMonsters;
    this.numberOfRooms = numberOfRooms;
    this.numberOfTreasures = numberOfTreasures;
    this.level = new Level(levelNumber);
  }

  /**
   * Adds a new room to the level.
   *
   * @param description the description of the room
   * @throws IllegalStateException if target number of rooms for that level is already reached
   * */
  public MedievalLevelBuilder addRoom(String description) throws IllegalStateException {
    if (roomCount == numberOfRooms) {
      throw new IllegalStateException("Target number of rooms reached.");
    }

    level.addRoom(description);
    roomCount += 1;
    return this;
  }


  /**
   * Adds a monster of type goblin to the specified room.
   *
   * @param roomNumber the room number to add the goblin to
   * @param numberOfGoblins the number of goblins to add to {@code roonNumber}
   *
   * @throws IllegalStateException if target number of rooms for that level is already reached
   * @throws IllegalStateException if target number of monsters for that level is already reached
   * */

  public MedievalLevelBuilder addGoblins(int roomNumber, int numberOfGoblins)
          throws IllegalArgumentException,IllegalStateException {

    if (roomNumber < 0 || numberOfGoblins < 0) {
      throw new IllegalArgumentException(" Negative arguments not allowed");
    }
    if (roomNumber + 1 > roomCount) {
      throw  new IllegalArgumentException("Target room not created yet.");
    }

    if (monsterCount + numberOfGoblins > this.numberOfMonsters ) {
      throw new IllegalStateException("Cannot add" + numberOfGoblins + " goblins as it will  "
              + "exceed the target number of monsters.");
    }

    final String description = "mischievous and very unpleasant, vengeful,"
            + " and greedy creature whose primary purpose is to cause trouble to humankind";
    final int goblinHitPoints = 7;
    final String name = "goblin";

    for (int i = 0; i < numberOfGoblins; i++) {

      Monster monster = new Monster(name, description, goblinHitPoints);
      level.addMonster(roomNumber, monster);
      monsterCount += 1;

    }

    return this;
  }

  /**
   * Adds a monster of type orc to the specified room.
   *
   * @param roomNumber the room number to add the orc to
   *
   * @throws IllegalStateException if target number of rooms for that level is already reached
   * @throws IllegalStateException if target number of monsters for that level is already reached
   * */

  public MedievalLevelBuilder addOrc(int roomNumber)
          throws IllegalArgumentException, IllegalStateException {

    if (roomNumber + 1 > roomCount) {
      throw  new IllegalArgumentException("Target room not created yet.");
    }

    if (monsterCount == this.numberOfMonsters) {
      throw new IllegalStateException("The target number of monsters has already been reached.");
    }
    final String description = "brutish, aggressive, malevolent being serving evil";
    final int orcHitPoints = 20;
    final String name = "orc";

    Monster monster = new Monster(name, description, orcHitPoints);
    level.addMonster(roomNumber, monster);
    monsterCount += 1;

    return this;
  }

  /**
   * Adds a monster of type ogre to the specified room.
   *
   * @param roomNumber the room number to add the ogre to
   *
   * @throws IllegalStateException if target number of rooms for that level is already reached
   * @throws IllegalStateException if target number of monsters for that level is already reached
   * */

  public MedievalLevelBuilder addOgre(int roomNumber)
          throws IllegalArgumentException, IllegalStateException {

    if (roomNumber + 1 > roomCount) {
      throw  new IllegalArgumentException("Target room not created yet.");
    }

    if (monsterCount == this.numberOfMonsters) {
      throw new IllegalStateException("The target number of monsters has already been reached.");
    }
    final String description = "large, hideous man-like being that likes to eat humans for lunch";
    final int ogreHitPoints = 50;
    final String name = "ogre";

    Monster monster = new Monster(name, description, ogreHitPoints);
    level.addMonster(roomNumber, monster);
    monsterCount += 1;

    return this;
  }

  /**
   * Adds a monster of type human to the specified room.
   * @param roomNumber the room number to add the goblin to
   * @param  name the name of the human
   * @param  description the description of the human
   * @param humanHitPoints the number of hit points the human has
   *
   * @throws IllegalStateException if target number of rooms for that level is already reached
   * @throws IllegalStateException if target number of monsters for that level is already reached
   * */

  public MedievalLevelBuilder addHuman(int roomNumber, String name, String description,
                                       final int humanHitPoints)
          throws IllegalArgumentException,IllegalStateException {

    if (roomNumber + 1 > roomCount) {
      throw  new IllegalArgumentException("Target room not created yet.");
    }

    if (monsterCount == this.numberOfMonsters) {
      throw new IllegalStateException("The target number of monsters has already been reached.");
    }

    Monster monster = new Monster(name, description, humanHitPoints);
    level.addMonster(roomNumber,monster);
    monsterCount += 1;

    return this;
  }

  /**
   * Adds a treasure of type potion to the specified room.
   *
   * @param roomNumber the room number to add the potion to
   *
   * @throws IllegalStateException if target number of rooms for that level is already reached
   * @throws IllegalStateException if target number of treasures for that level is already reached
   * */

  public MedievalLevelBuilder addPotion(int roomNumber)
          throws IllegalArgumentException, IllegalStateException {

    if (roomNumber + 1 > roomCount) {
      throw  new IllegalArgumentException("Target room not created yet.");
    }

    if (treasureCount == this.numberOfTreasures) {
      throw new IllegalStateException("The target number of treasures has already been reached.");
    }

    final String description = "a healing potion";
    final int potionValue = 1;
    Treasure treasure = new Treasure(description, potionValue);
    level.addTreasure(roomNumber,treasure);
    treasureCount += 1;

    return this;
  }

  /**
   * Adds a treasure of type gold to the specified room.
   *
   * @param roomNumber the room number to add the gold pieces to
   * @param goldValue the value of each piece of gold
   *
   * @throws IllegalStateException if target number of rooms for that level is already reached
   * @throws IllegalStateException if target number of treasures for that level is already reached
   * */
  public MedievalLevelBuilder addGold(int roomNumber, final int goldValue)
          throws IllegalArgumentException, IllegalStateException {

    if (roomNumber + 1 > roomCount) {
      throw  new IllegalArgumentException("Target room not created yet.");
    }

    if (treasureCount == this.numberOfTreasures) {
      throw new IllegalStateException("The target number of treasures has already been reached.");
    }

    final String description = "pieces of gold";
    Treasure treasure = new Treasure(description, goldValue);
    level.addTreasure(roomNumber,treasure);
    treasureCount += 1;

    return this;
  }

  /**
   * Adds a treasure of type weapon to the specified room.
   *
   * @param roomNumber the room number to add the weapon to
   * @param weaponDescription the description of weapon
   *
   * @throws IllegalStateException if target number of rooms for that level is already reached
   * @throws IllegalStateException if target number of treasures for that level is already reached
   * */

  public MedievalLevelBuilder addWeapon(int roomNumber, final String weaponDescription)
          throws IllegalArgumentException, IllegalStateException {


    if (roomNumber < 0) {
      throw new IllegalArgumentException(" Negative arguments not allowed");
    }
    if (roomNumber + 1 > roomCount) {
      throw  new IllegalArgumentException("Target room not created yet.");
    }

    if (treasureCount == this.numberOfTreasures) {
      throw new IllegalStateException("The target number of treasures has already been reached.");
    }

    final int weaponValue = 10;
    Treasure treasure = new Treasure(weaponDescription, weaponValue);
    level.addTreasure(roomNumber,treasure);
    treasureCount += 1;

    return this;
  }

  /**
   * Add the most exclusive treasures to the specified room.
   *
   * @param roomNumber the room number to add the weapon to
   * @param treasureDescription the description of treasure
   * @param treasureValue the value of the treasure
   *
   * @throws IllegalStateException if target number of rooms for that level is already reached
   * @throws IllegalStateException if target number of treasures for that level is already reached
   * */

  public MedievalLevelBuilder addSpecial(int roomNumber, final String treasureDescription,
                                         final int treasureValue)
          throws IllegalArgumentException, IllegalStateException {

    if (roomNumber < 0) {
      throw new IllegalArgumentException(" Negative arguments not allowed");
    }

    if (roomNumber + 1 > roomCount) {
      throw  new IllegalArgumentException("Target room not created yet.");
    }

    if (treasureCount == this.numberOfTreasures) {
      throw new IllegalStateException("The target number of treasures has already been reached.");
    }

    Treasure treasure = new Treasure(treasureDescription, treasureValue);
    level.addTreasure(roomNumber,treasure);
    treasureCount += 1;
    return this;

  }

  /**
   * Build the level with the designed rooms.
   * A level will have the specified number of rooms.
   * Each room will have the monsters and treasures that was added.
   *
   * @return {@code Level}
   *
   * @throws IllegalStateException if called before filling the target number of
   *          rooms, monsters or treasures specified
   * */
  public Level build() throws IllegalStateException {

    if (monsterCount != numberOfMonsters || treasureCount != numberOfTreasures
            || roomCount != numberOfRooms) {
      throw new IllegalStateException("build called before completion of targets specified. ");
    }
    return level;

  }

}
