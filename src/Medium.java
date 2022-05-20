public class Medium {
  
  private int inventarNummer;
  protected String titel;

  private String ausleiher;

  public Medium(String titel, int inventarNummer) {
    this.titel = titel;
    this.inventarNummer = inventarNummer;
  } 

public int getInventarNummer() {
  return inventarNummer;
}

public String getTitel() {
    return titel;
}

public void ausleihen(String a) {
  this.ausleiher = a;
}

public void zurueckbringen() {
  this.ausleiher = null;
}

public String getAusleiher(){
  return ausleiher;
}

public String wasIchBin(){
  return "Medium";
}

public String toString() {
  return "Inventarnummer: "+inventarNummer+", Titel: "+titel;
}



}