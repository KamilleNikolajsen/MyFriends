package myfriends;

import java.util.Scanner;
import java.util.function.BooleanSupplier;

public class Menu {

  //ATTRIBUTES
  private String menuHeader;
  private String leadText;
  private String[] menuItems;
  Scanner sc = new Scanner(System.in);

  //CONSTRUCTOR
  public Menu(String menuHeader, String leadText, String[] menuItems){
    setMenuHeader(menuHeader);
    setLeadText(leadText);
    setMenuItems(menuItems);
  }

  //GETTER
  public String getMenuHeader(){return menuHeader;}

  public String getLeadText(){return leadText;}

  public String[] getMenuItems() {
    return menuItems;
  }

  //SETTER
  public void setMenuHeader(String menuHeader){
    this.menuHeader = menuHeader;
  }

  public void setLeadText(String leadText){
    this.leadText = leadText;
  }

  public void setMenuItems(String[] menuItems){
    this.menuItems = menuItems;
  }

  //METHODS
  public void printMenu(){
    System.out.println(getMenuHeader());
    for(String s : getMenuItems()){
      System.out.println(s);
    }
    System.out.println(getLeadText());
  }

  public int readChoice(){

    int choice;
    if(!sc.hasNextInt()){
      System.out.println(getLeadText());
      sc.hasNextInt();
      sc.nextLine();
    }
    choice = sc.nextInt();
    sc.nextLine();

    return choice;
  }
}
