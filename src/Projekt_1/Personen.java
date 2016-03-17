package Projekt_1;

abstract class Person {
    protected String Name, Vorname;
    protected String Abteilung;
    protected int Personalnummer;
    protected int Alter;
    protected int berechneFerien;

    public Person(String Name, String Vorname, String Abteilung, int Personalnummer, int Alter) {
        this.Name = Name;
        this.Vorname = Vorname;
        this.Abteilung = Abteilung;
        this.Personalnummer = Personalnummer;
        this.Alter = Alter;
        this.berechneFerien = berechneFerien(Alter);
    }

    public abstract int berechneFerien(int alter);

    public String print() {
        return "Name: " + Name + " Vorname: " + Vorname + " Personalnummer: " + Personalnummer + " ";
    }
}

class Chef extends Person {
    protected String Abteilung;

    public Chef(String Name, String Vorname, int Personalnummer, String Abteilung, int Alter) {
        super(Name, Vorname, Abteilung, Personalnummer, Alter);
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
        return super.print() + "Abteilung: " + Abteilung + " ";
    }
}

class Fachangestellter extends Person {
    protected Chef Vorgesetzter;

    public Fachangestellter(String Name, String Vorname, String Abteilung, int Personalnummer, Chef Vorgesetzter, int Alter) {
        super(Name, Vorname, Abteilung, Personalnummer, Alter);
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

    public Lehrling(String Name, String Vorname, String Abteilung, int Personalnummer, int Lehrjahr, int Alter) {
        super(Name, Vorname, Abteilung, Personalnummer, Alter);
        this.Lehrjahr = Lehrjahr;
    }

    @Override
    public int berechneFerien(int alter) {
        return 5;
    }

    @Override
    public String print() {
        return super.print() + "Lehrjahr: " + Lehrjahr + " ";
    }
}

class Firma {
    private Person[] Mitarbeiter;

    public Firma(Person[] p) {
        Mitarbeiter = p;
    }
}

public class Personen {
    public static void main(String args[]) {
        Person[] personen = new Person[4];
        personen[0] = new Chef("Meier", "Peter", 4456, "Administration", 47);
        personen[1] = new Fachangestellter("Stadler", "Hans", "Entwickler", 7169, (Chef) personen[0], 20);
        personen[2] = new Fachangestellter("Muster", "Fritz", "Verkauf", 3741, (Chef) personen[0], 63);
        personen[3] = new Lehrling("Steiger", "Max", "Entwickler", 4652, 16, 2);

        for (int i = 0; i < personen.length; i++) {
            System.out.println(personen[i].print());
            System.out.println(personen[i].berechneFerien + " Wochen");
            System.out.println("----------------------------------------------------");
        }
    }
}
