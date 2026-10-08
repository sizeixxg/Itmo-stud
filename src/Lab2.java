
import ru.ifmo.se.pokemon.*;


public class Lab2 {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon p1 = new Kartana("Катана", 1);
        Pokemon p2 = new Happiny("Игнат", 1);
        Pokemon p3 = new Breloom("Брилом", 23);

        Pokemon o1 = new Blissey("Блиси", 3);
        Pokemon o2 = new Chansey("Вася", 2);
        Pokemon o3 = new Shroomish("Чертила", 1);
        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);

        b.addFoe(o1);
        b.addFoe(o2);
        b.addFoe(o3);
        b.go();
        }

}

