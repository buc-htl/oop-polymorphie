public class Ebook extends Buch {

  public Ebook(String titel, int inventarnummer){
    super(titel, inventarnummer);
  }

@Override
public void ausleihen(String a) {
    System.out.println("Fehler: E-Book kann nicht ausgeborgt werden");
}

public String wasIchBin(){
  return "Ebook";
}
}