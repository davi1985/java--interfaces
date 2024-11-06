package application;

import model.entities.ComboDevice;
import model.entities.ConcretePrinter;
import model.entities.ConcreteScanner;

public class Main4 {

    public static void main(String[] args) {
        ConcretePrinter p = new ConcretePrinter("1080");
        p.processDoc("My letter");
        p.print("My letter");
        System.out.println();

        ConcreteScanner s = new ConcreteScanner("2024");
        s.processDoc("My email");
        System.out.println("Scan result: " + s.scan());
        System.out.println();

        ComboDevice device = new ComboDevice("2346");
        device.processDoc("My book");
        device.print("My book");

        System.out.println("Combo scan result: " + device.scan());
    }
}
