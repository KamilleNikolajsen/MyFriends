package myfriends;

public class Friend {
  //ATTRIBUTES
  private String name;
  private String phone;
  private String email;

  //CONSTRUCTOR
  public Friend(String name, String phone, String email){
    setName(name);
    setPhone(phone);
    setEmail(email);
  }

  //GETTER
  public String getName(){
    return name;
  }

  public String getPhone(){
    return phone;
  }

  public String getEmail(){
    return email;
  }

  //SETTER
  public void setName(String name){
    this.name = name;
  }

  public void setPhone(String phone){
    this.phone = phone;
  }

  public void setEmail(String email){
    this.email = email;
  }


  //METHODS

  @Override
  public boolean equals(Object input) {
    if (!(input instanceof Friend)) {
      return false;
    }
    Friend friend = (Friend) input;

    return
        name.equalsIgnoreCase(friend.name)
        && phone.equalsIgnoreCase(friend.phone)
        && email.equalsIgnoreCase(friend.email);
  }

  @Override
  public String toString(){
    return "NAME: " + name + " PHONE: " + phone + " EMAIL: " + email;
  }

}
