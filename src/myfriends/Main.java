package myfriends;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  Scanner sc = new Scanner(System.in);

  //ATTRIBUTES
  ArrayList<Friend> friends = new ArrayList<Friend>();
  File friendList;

  //CONSTRUCTOR
  public Main(){
    loadList();
  }

  //METHODS
  public static void main(String[] args) {
    new Main().run();
  }


  void run(){
    String[] menuItems = new String[6];
    menuItems[0] = "1. Show list of friends";
    menuItems[1] = "2. Enter new friend";
    menuItems[2] = "3. Delete friend";
    menuItems[3] = "4. Save list";
    menuItems[4] = "5. Load list";
    menuItems[5] = "9. Quit";

    Menu menu = new Menu("MENU", "PLEASE CHOOSE OPTION: ", menuItems);

    int choice = 0;
    while (choice != 9){
      menu.printMenu();
      choice = menu.readChoice();

      switch (choice){
        case 1:
          // Shows list of friends from file
          showList();
          break;
        case 2:
          //Adds new friend to file
          enterNewFriend();
          break;
        case 3:
          //Removes friend from file
          deleteFriend();
          break;
        case 4:
          //Save list - fill file with information from ArrayList
          saveList();
          break;
        case 5:
          //Load list - fill ArrayList with file information
          loadList();
          break;
        case 9:
          System.out.println("QUIT");
          break;
        default:
          System.out.println("NOT A VALID INPUT");
      }
    }
  }

  private void loadList() {
    friends.clear();
    try {
      friendList = new File("friendList.txt");
      Scanner fileReader = new Scanner(friendList);

      while (fileReader.hasNext()) {
        String name = fileReader.next();
        String phone = fileReader.next();
        String email = fileReader.next();
        Friend friend = new Friend(name, phone, email);
        friends.add(friend);
      }
      fileReader.close();
    } catch(IOException e){
      System.out.println("Exception: " + e);
    }
  }

  private void saveList() {
    try{
      friendList = new File("friendList.txt");
      PrintStream output = new PrintStream(new FileOutputStream(friendList));

      //Line under does the same as FileOutputStream
      //PrintStream output = new PrintStream(new File("friendList.txt"));

      for(Friend f : friends){
        output.println(f.getName());
        output.println(f.getPhone());
        output.println(f.getEmail() + "\n");
      }
      System.out.println("FILE SAVED");
      output.close();
    } catch (IOException e){
      System.out.println("Exception: " + e);
    }
    System.out.println();
  }

  private void deleteFriend() {
    showList();
    System.out.println("Enter the number of the friend you want to delete: ");
    int n = sc.nextInt();
    sc.nextLine();
    friends.remove(n-1);

    System.out.println();
    showList();
    saveList();
  }

  private void enterNewFriend() {
    System.out.println("Enter friend name: ");
    String name = sc.nextLine();
    System.out.println("Enter friends phone number: ");
    String phone = sc.nextLine();
    System.out.println("Enter friends email: ");
    String email = sc.nextLine();

    Friend friend = new Friend(name, phone, email);

    boolean exists = false;

    if(friends.contains(friend)){
      System.out.println("\nFRIEND EXISTS");
      exists = true;
    }

    if(!exists) {
      friends.add(friend);
    }

    System.out.println();
    showList();
    saveList();

  }

  void showList(){
    for(int i = 0; i < friends.size(); i++){
      System.out.println((i+1) + ". " + friends.get(i).toString());
    }
    System.out.println();
  }
}
