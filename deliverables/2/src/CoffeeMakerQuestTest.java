import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.mockito.*;
import static org.mockito.Mockito.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CoffeeMakerQuestTest {

	CoffeeMakerQuest cmq;
	Player player;
	Room room1;	// Small room
	Room room2;	// Funny room
	Room room3;	// Refinanced room
	Room room4;	// Dumb room
	Room room5;	// Bloodthirsty room
	Room room6;	// Rough room

	@Before
	public void setup() {
		// 0. Turn on bug injection for Player and Room.
		Config.setBuggyPlayer(true);
		Config.setBuggyRoom(true);
		
		// 1. Create the Coffee Maker Quest object and assign to cmq.
		cmq = CoffeeMakerQuest.createInstance();

		// TODO: 2. Create a mock Player and assign to player and call cmq.setPlayer(player). 
		// Player should not have any items (no coffee, no cream, no sugar)

		// TODO: 3. Create mock Rooms and assign to room1, room2, ..., room6.
		// Mimic the furnishings / adjectives / items of the rooms in the original Coffee Maker Quest.
		Room room1 = Mockito.mock(Room.class);
		Mockito.when(room1.getAdjective()).thenReturn("Small");
		Mockito.when(room1.getFurnishing()).thenReturn("Quaint sofa");
		Mockito.when(room1.getItem()).thenReturn(Item.CREAM);
		Room room2 = Mockito.mock(Room.class);
		Mockito.when(room2.getAdjective()).thenReturn("Funny");
		Mockito.when(room2.getFurnishing()).thenReturn("Sad record player");
		Mockito.when(room1.getItem()).thenReturn(Item.NONE);
		Room room3 = Mockito.mock(Room.class);
	
		Mockito.when(room3.getAdjective()).thenReturn("Refinanced");
		Mockito.when(room3.getFurnishing()).thenReturn("Tight pizza");
		Mockito.when(room1.getItem()).thenReturn(Item.COFFEE);
		Room room4 = Mockito.mock(Room.class);
		Mockito.when(room4.getAdjective()).thenReturn("Dumb");
		Mockito.when(room4.getFurnishing()).thenReturn("Flat energy drink");
		Mockito.when(room1.getItem()).thenReturn(Item.NONE);
		Room room5 = Mockito.mock(Room.class);
		Mockito.when(room5.getAdjective()).thenReturn("Bloodthirsty");
		Mockito.when(room5.getFurnishing()).thenReturn("Beautiful bag of money");
		Mockito.when(room1.getItem()).thenReturn(Item.NONE);
		Room room6 = Mockito.mock(Room.class);
		Mockito.when(room6.getAdjective()).thenReturn("Rough");
		Mockito.when(room6.getFurnishing()).thenReturn("Perfect air hockey table");
		Mockito.when(room1.getItem()).thenReturn(Item.SUGAR);
		
		// TODO: 4. Add the rooms created above to mimic the layout of the original Coffee Maker Quest.
		cmq.addFirstRoom(room1);	
		cmq.addRoomAtNorth(room2,"Magenta", "Massive");
		cmq.addRoomAtNorth(room3,"Beige", "Smart");
		cmq.addRoomAtNorth(room4,"Dead", "Slim");
		cmq.addRoomAtNorth(room5,"Vivacious", "Sandy");
		cmq.addRoomAtNorth(room6,"Purple", "Minimalist");
	}

	@After
	public void tearDown() {
	}
	
	/**
	 * Test case for String getInstructionsString().
	 * Preconditions: None.
	 * Execution steps: Call cmq.getInstructionsString().
	 * Postconditions: Return value is " INSTRUCTIONS (N,S,L,I,D,H) > ".
	 */
	@Test
	public void testGetInstructionsString() {
		// TODO
		assertEquals("Instructions are printed"," INSTRUCTIONS (N,S,L,I,D,H) > ",cmq.getInstructionsString());
		
		
	}
	
	/**
	 * Test case for boolean addFirstRoom(Room room).
	 * Preconditions: room1 ~ room6 have been added to cmq.
	 *                Create a mock room and assign to myRoom.
	 * Execution steps: Call cmq.addFirstRoom(myRoom).
	 * Postconditions: Return value is false.
	 */
	@Test
	public void testAddFirstRoom() {
		// TODO
		Room myRoom = Mockito.mock(Room.class);
	    assertFalse("The Room was not added",cmq.addFirstRoom(myRoom));
	}
	
	/**
	 * Test case for boolean addRoomAtNorth(Room room, String northDoor, String southDoor).
	 * Preconditions: room1 ~ room6 have been added to cmq.
	 *                Create a mock "Fake" room with "Fake bed" furnishing with no item, and assign to myRoom.
	 * Execution steps: Call cmq.addRoomAtNorth(myRoom, "North", "South").
	 * Postconditions: Return value is true.
	 *                 room6.setNorthDoor("North") is called.
	 *                 myRoom.setSouthDoor("South") is called.
	 */
	@Test
	public void testAddRoomAtNorthUnique() {
		// TODO
		Room myRoom = Mockito.mock(Room.class);
		Mockito.when(myRoom.getFurnishing()).thenReturn("Fake bed");
		Mockito.when(myRoom.getAdjective()).thenReturn("Fake");
		Mockito.when(myRoom.getItem()).thenReturn(Item.NONE);
		assertTrue("The Room was successfully added",cmq.addRoomAtNorth(myRoom, "North", "South"));
		room6.setNorthDoor("North");
		myRoom.setSouthDoor("South");
		
	}
	
	/**
	 * Test case for boolean addRoomAtNorth(Room room, String northDoor, String southDoor).
	 * Preconditions: room1 ~ room6 have been added to cmq.
	 *                Create a mock "Fake" room with "Flat energy drink" furnishing with no item, and assign to myRoom.
	 * Execution steps: Call cmq.addRoomAtNorth(myRoom, "North", "South").
	 * Postconditions: Return value is false.
	 *                 room6.setNorthDoor("North") is not called.
	 *                 myRoom.setSouthDoor("South") is not called.
	 */
	@Test
	public void testAddRoomAtNorthDuplicate() {
		// TODO
		Room myRoom = Mockito.mock(Room.class);
		Mockito.when(myRoom.getFurnishing()).thenReturn("Flat energy drink");
		Mockito.when(myRoom.getAdjective()).thenReturn("Fake");
		Mockito.when(myRoom.getItem()).thenReturn(Item.NONE);
		assertFalse("The Room was not added",cmq.addRoomAtNorth(myRoom, "North", "South"));
		
		
	}
	
	/**
	 * Test case for Room getCurrentRoom().
	 * Preconditions: room1 ~ room6 have been added to cmq.
	 *                cmq.setCurrentRoom(Room) has not yet been called.
	 * Execution steps: Call cmq.getCurrentRoom().
	 * Postconditions: Return value is null.
	 */
	@Test
	public void testGetCurrentRoom() {
		// TODO
		
		assertNull("No Room is set",cmq.getCurrentRoom());
	}
	
	/**
	 * Test case for void setCurrentRoom(Room room) and Room getCurrentRoom().
	 * Preconditions: room1 ~ room6 have been added to cmq.
	 *                cmq.setCurrentRoom(Room room) has not yet been called.
	 * Execution steps: Call cmq.setCurrentRoom(room3).
	 *                  Call cmq.getCurrentRoom().
	 * Postconditions: Return value of cmq.setCurrentRoom(room3) is true. 
	 *                 Return value of cmq.getCurrentRoom() is room3.
	 */
	@Test
	public void testSetCurrentRoom() {
		// TODO
		
		cmq.setCurrentRoom(room3);
		cmq.getCurrentRoom();
		assertTrue("Room is set",cmq.setCurrentRoom(room3));
		assertEquals(room3,cmq.getCurrentRoom());
		
		
	}
	
	/**
	 * Test case for String processCommand("I").
	 * Preconditions: Player does not have any items.
	 * Execution steps: Call cmq.processCommand("I").
	 * Postconditions: Return value is "YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n".
	 */
	@Test
	public void testProcessCommandI() {
		// TODO
	}
	
	/**
	 * Test case for String processCommand("l").
	 * Preconditions: room1 ~ room6 have been added to cmq.
	 *                cmq.setCurrentRoom(room1) has been called.
	 * Execution steps: Call cmq.processCommand("l").
	 * Postconditions: Return value is "There might be something here...\nYou found some creamy cream!\n".
	 *                 player.addItem(Item.CREAM) is called.
	 */
	@Test
	public void testProcessCommandLCream() {
		// TODO
	}
	
	/**
	 * Test case for String processCommand("n").
	 * Preconditions: room1 ~ room6 have been added to cmq.
	 *                cmq.setCurrentRoom(room4) has been called.
	 * Execution steps: Call cmq.processCommand("n").
	 *                  Call cmq.getCurrentRoom().
	 * Postconditions: Return value of cmq.processCommand("n") is "".
	 *                 Return value of cmq.getCurrentRoom() is room5.
	 */
	@Test
	public void testProcessCommandN() {
		// TODO
	}
	
	/**
	 * Test case for String processCommand("s").
	 * Preconditions: room1 ~ room6 have been added to cmq.
	 *                cmq.setCurrentRoom(room1) has been called.
	 * Execution steps: Call cmq.processCommand("s").
	 *                  Call cmq.getCurrentRoom().
	 * Postconditions: Return value of cmq.processCommand("s") is "A door in that direction does not exist.\n".
	 *                 Return value of cmq.getCurrentRoom() is room1.
	 */
	@Test
	public void testProcessCommandS() {
		// TODO
	}
	
	/**
	 * Test case for String processCommand("D").
	 * Preconditions: Player has no items.
	 * Execution steps: Call cmq.processCommand("D").
	 *                  Call cmq.isGameOver().
	 * Postconditions: Return value of cmq.processCommand("D") is "YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n\nYou drink the air, as you have no coffee, sugar, or cream.\nThe air is invigorating, but not invigorating enough. You cannot study.\nYou lose!\n".
	 *                 Return value of cmq.isGameOver() is true.
	 */
	@Test
	public void testProcessCommandDLose() {
		// TODO
	}
	
	/**
	 * Test case for String processCommand("D").
	 * Preconditions: Player has all 3 items (coffee, cream, sugar).
	 * Execution steps: Call cmq.processCommand("D").
	 *                  Call cmq.isGameOver().
	 * Postconditions: Return value of cmq.processCommand("D") is "You have a cup of delicious coffee.\nYou have some fresh cream.\nYou have some tasty sugar.\n\nYou drink the beverage and are ready to study!\nYou win!\n".
	 *                 Return value of cmq.isGameOver() is true.
	 */
	@Test
	public void testProcessCommandDWin() {
		// TODO
	}
	
	// TODO: Put in more unit tests of your own making to improve coverage!
	
}
