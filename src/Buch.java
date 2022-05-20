public class Buch extends Medium {

  private String uebersetzer=null;

  public Buch(String titel, int inventarnummer) {
    super(titel,inventarnummer);
  }

  public void setUebersetzer(String uebersetzer) {
    this.uebersetzer = uebersetzer;
  }

  public String getUebersetzer() {
    return uebersetzer;
  }

public String wasIchBin(){
  return "Buch";
}

}