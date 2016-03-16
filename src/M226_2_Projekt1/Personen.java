package M226_2_Projekt1;

abstract class Person {
    protected String Name, Vorname;
    protected String Abteilung;
    protected int Personalnummer;
    protected int Alter;
    protected int berechneFerien;

        public Person(String Name, String Vorname, String Abteilung, int Personalnummer, int Alter){
            this.Name = Name;
            this.Vorname = Vorname;
            this.Abteilung = Abteilung;
            this.Personalnummer = Personalnummer;
            this.Alter = Alter;
            this.berechneFerien = berechneFerien(Alter);
        }

    public abstract int berechneFerien(int alter);

    public String print(){
        return "Name: " + Name + "Vorname: " + Vorname + "Personalnummer: " + Personalnummer;
    }
}

class Chef extends Person {
    protected String Abteilung;

    public Chef(String Name, String Vorname, int Personalnummer, String Abteilung, int Alter){
        super(Name, Vorname,Abteilung, Personalnummer, Alter);
        this.Abteilung = Abteilung;
    }
    @Override
    public int berechneFerien(int alter) {
        int ferien = 4;
        if (alter >= 45)
            ferien++;
        if (alter >= 55)
            ferien++;
        return ferien;
    }

    @Override
    public String print() {
        return super.print() + "Abteilung: " + Abteilung;
    }
}
class Fachangestellter extends Person {
    protected Chef Vorgesetzter;
    public Fachangestellter(String Name, String Vorname,String Abteilung, int Personalnummer, Chef Vorgesetzter, int Alter) {
        super(Name, Vorname,Abteilung, Personalnummer, Alter);
        this.Vorgesetzter = Vorgesetzter;
    }
    @Override
    public int berechneFerien(int alter) {
        int ferien = 4;
        if (alter >= 50)
            ferien++;
        if (alter >= 60)
            ferien++;
        return ferien;

    }
}


class Lehrling extends Person {
    protected int Lehrjahr;
    public Lehrling(String Name, String Vorname,String Abteilung, int Personalnummer, int Lehrjahr, int Alter) {
        super(Name, Vorname,Abteilung, Personalnummer, Alter);
        this.Lehrjahr = Lehrjahr;
    }
    @Override
    public int berechneFerien(int alter) {
        int ferien = 4;
        if (alter >= 45)
            ferien++;
        if (alter >= 55)
            ferien++;
        return ferien;
    }

    @Override
    public String print() {
        return super.print() + "Lehrjahr: " + Lehrjahr;
    }
}

class Firma {
    private Person[] Mitarbeiter;

    public Firma(Person[] p) {
        Mitarbeiter = p;
    }
}
public class Personen {
    public static void main (String args[]) {
        Person[] personen = new Person[4];
        personen[0] = new Chef("Chef", "Peter", 1, "Administration",47);
        personen[1] = new Fachangestellter("Muster", "Hans","Entwickler", 2,(Chef) personen[0], 20);
        personen[2] = new Fachangestellter("Muster", "Fritz","Verkauf", 3, (Chef) personen[0],63);
        personen[3] = new Lehrling("Ingold", "Marc","Entwickler", 4, 16, 2);

        for (Person person : personen) {
            person.print();
            System.out
                    .println("----------------------------------------------------");
        }
        /*Chef chef1 = new Chef("Cossandey", "Johnas", "Verkauf", 2245);
        Fachangestellter personal1 = new Fachangestellter("Weissman", "Beat", "Verkauf", 4512, chef1);
        Fachangestellter personal2 = new Fachangestellter("Haldemann", "Patrick", "Entwicklung", 1337, chef1);
        Person person1 = new Person("Hilfiger", "Thomas", "Entwicklung", 7784);
        Lehrling lehrling1 = new Lehrling("Steiger", "Max", "Entwicklung", 0505, 2);

        chef1.Name = "Sattler";
        chef1.Abteilung = "Entwicklung";
        personal1.Name = "Klein";
        personal1.Vorname = "Thomas";*/

        /*personal1.Vorgesetzter=personal3;
        personal4 = personal1;
        personal4.Vorgesetzter = personal3;
        personal1 = personal4;
        personal1 = (Fachangestellter) personal4;*/

        //Firma f = new Firma(
                //new Person[] {new Chef("Sattler", "Beatrice", "Verkauf", 2599)} );

//        System.out.println(chef1.print());
//        System.out.println(personal1.print());
//        System.out.println(lehrling1.print());
    }
}
