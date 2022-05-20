public class CD extends Medium {
  

  private String musikstil;

  public CD(String titel, int inventarnummer, String musikstil) {

    super(titel,inventarnummer);
    this.musikstil = musikstil;

  }

  public CD(String titel, int inventarnummer) {
    this(titel, inventarnummer, "unbekannt");
  }

public String wasIchBin(){
  return "CD";
}

public String toString() {

  String s = super.toString();
  return s+" ,Musikstil: "+musikstil;
}

}