package Game;

import java.util.Scanner;
import java.util.Objects;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
public class Game {

  /* Instance Variables */
   private Player player;
  /* Main Method */
  public static void main(String[] args) {
    
    Art art = new Art();
    Scanner console = new Scanner(System.in);
    Game game = new Game();

    game.player = game.start(console);

    game.addDelay(500);
    System.out.println("\nLet's take a quick look at you to make sure you're ready to head out the door.");
    System.out.println(game.player);

    game.addDelay(1000);
    System.out.println("\nWell, you're off to a good start, let's get your game saved so we don't lose it.");
    game.save();

    game.addDelay(2000);
    System.out.println("We just saved your game...");
    System.out.println("Now we are going to try to load your character to make sure the save worked...");

    game.addDelay(1000);
    System.out.println("Deleting character...");
    String charName = game.player.getName();
    game.player = null;

    game.addDelay(1500);
    game.player = game.load(charName, console);
    System.out.println("Loading character...");

    game.addDelay(2000);
    System.out.println("Now let's print out your character again to make sure everything loaded:");

    game.addDelay(500);
    System.out.println(game.player);
  } // End of main

  /* Instance Methods */
  private Player start(Scanner console) {
    // Add start functionality here
    Player player;
    
    Art.homeScreen();

    System.out.println("Would You like to start.Answer in y & n");
    char answer = console.next().charAt(0);

    while(true){
      if(answer == 'y'){
        System.out.println("Can you give me your name again");
        String name = console.next();
        player = load(name,console);
        break;
      }
      else if(answer == 'n'){
        System.out.println("Can you give me your name");
        String name = console.next();
        player = new Player(name);
        break;
      }
    }
    return player;
  } // End of start

  private void save() {
    // Add save functionality here
  String fileName = player.getName() + ".svr";
  try{
  FileOutputStream fos = new FileOutputStream(fileName);
  ObjectOutputStream oos = new ObjectOutputStream(fos);
  oos.writeObject(player);
  }
  catch(IOException e){
    System.out.println("Unable to save!!");
  }
  } // End of save

  private Player load(String playerName, Scanner console) {
    // Add load functionality here
    Player loadedPlayer;
    try{
       FileInputStream fis = new FileInputStream(playerName + ".srv");
       ObjectInputStream ois = new ObjectInputStream(fis);
       loadedPlayer =  (Player)ois.readObject();
    }
    catch(IOException | ClassNotFoundException e){
      addDelay(1500);
      System.out.println("File not found!!!");
      addDelay(2000);
      loadedPlayer = new Player(playerName);
    }
    return loadedPlayer;
  } // End of load

  // Adds a delay to the console so it seems like the computer is "thinking"
  // or "responding" like a human, not instantly like a computer.
  private void addDelay(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}