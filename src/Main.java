class Main {
    public static void main(String[] args) {

        /*
         Bis jetzt hatte die Variable immer den Datentyp der Klasse, in diesem Beispiel CD.
         */
        CD cd = new CD("The wall", 1, "Classic Rock");

        /*
         Man kann als Datentyp aber auch alle Superklassen verwenden. Eine CD ist ja auch ein Medium. Daher kann ich eine CD auch in einer Variable vom Typ Medium speichern.
         */
        Medium medium = new CD("The wall", 1, "Classic Rock");

        /*
         Das funktioniert auch über mehrere Vererbungsschritte (Ebook -> Buch -> Medium).
         */
        Medium medium2 = new Ebook("Alice im Wunderland", 34323);

        /*
         Das Beispiel funktioniert nicht. Ebook ist abgeleitet von Buch. Ich kann die "speziellere" Klasse Ebook nicht als Typ für ein Objekt der "allgemeineren" Klasse Buch verwenden.
         */
        //Ebook ebook = new Buch("Moby Dick", 43434);

        /*
         Speichert man ein Objekt in einer Variable mit einem anderen (allgemeineren) Datentyp, dann besitzt dieses Objekt zwar noch alle Attribute und Methoden wie gewohnt, es sind aber nur die Attribute und Methoden sichtbar, die der allgemeinere Typ auch hat.
         D.h. im folgenden Beispiel sind nur die Methoden und Attribute sichtbar, die Medium hat.
         */
        Medium medium3 = new Buch("Eating animals", 8390483);

        /*
         getTitel() aufzurufen ist kein Problem, weil es eine Methode der Klasse Medium ist.
         */
        medium3.getTitel();

        /*
         getUebersetzer() kann allerdings nicht so einfach aufgerufen werden. Es ist eine Methode der Klasse Buch - ist also im Datentyp Medium nicht sichtbar.
         */
        //medium3.getUebersetzer();

        /*
         Allerdings wissen wir ja, dass das Objekt selbst ja ein Buch ist und nur in einer Variable mit einem allgemeineren Datentyp gespeichert.
         Wenn wir das Objekt also auf den Datentyp Buch casten, kann können wir wieder die Methode getUebersetzer() aufrufen.
         */
        ((Buch) medium3).setUebersetzer("Don John");

        /*
         Der Cast würde fehlschlagen (und das Programm abstürzen) wenn das Objekt jetzt doch kein Buch wäre. Daher ist es ratsam es vorher mit dem Operator instanceof zu überprüfen.
         */
        if (medium3 instanceof Buch) {
            System.out.println("medium3 ist ein Buch");
            Buch b = (Buch) medium3;
            System.out.println(b.getUebersetzer());
        }

        /*
         instanceof ist auch true, wenn ich auf eine Superklasse teste.
         */
        if (medium3 instanceof Medium) {
            System.out.println("medium3 ist ein Medium");
        }

        if (medium3 instanceof Ebook) {
            System.out.println("medium3 ist ein Ebook");
        } else {
            System.out.println("medium3 ist KEIN Ebook");
        }

        /*
         Jetzt kommt die wahre Magie namens Polymorphismus. Wir wissen ja bereits, dass wir Methoden in Subklassen überschreiben können.

         Auch wenn ich ein Objekt in einer Variable mit dem Typ einer Superklasse speichere, wird zur Laufzeit festgestellt, welches Objekt
         eigentlich wirklich gespeichert ist und immer die überschriebene Methode aufgerufen!

         Im Beispiel wird also nicht die Methode wasIchBin() in Medium aufgerufen, sondern in CD bzw. Buch.
         */
        Medium einMedium = new CD("Smash", 3434, "Punk Rock");
        Medium anderesMedium = new Buch("1984", 3434);
        System.out.println(einMedium.wasIchBin());
        System.out.println(anderesMedium.wasIchBin());

        /*
        Besonders praktisch dieses Verhalten auch für Parameter. Ich definiere als Parametertyp den allgemeinsten Typ, den ich in der Methode benötige.

         Aufrufen kann ich diese Methode dann mit allen Objekten von diesem Typ, aber auch mit allen Subtypen!
         */
        CD eineCD = new CD("The Black", 344, "Heavy Metal");
        Buch einBuch = new Buch("Animal farm", 38934);
        einBuch.ausleihen("Sebastian S.");
        erinnereAusleiher(eineCD);
        erinnereAusleiher(einBuch);

        /*
         Auch ist es so möglich Objekte von verschiedenen Subklassen in einem Array zu speichern.
         */
        Medium[] medien = new Medium[]{eineCD, einBuch};
        for (Medium m : medien) {
            System.out.println("[Iteration Array] " + m);
        }
    }

    public static void erinnereAusleiher(Medium medium) {
        if (medium.getAusleiher() != null) {
            System.out.println(medium.getAusleiher() + ", bring mein(e) " + medium.wasIchBin() + " zurück!");
        } else {
            System.out.println("Medium nicht ausgeliehen.");
        }
    }


}