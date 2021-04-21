public class Principale {

    public static void main(String[] args) {
        int [] maxtas = {75,60,62,55};

        Arbre A1 = new Arbre(new Valeur(15));
        Arbre A2 = new Arbre(new Valeur(7));
        Arbre A3 = new Arbre(new Valeur(18));
        Arbre A4 = new Arbre(new Valeur(10), A2, A1);
        Arbre A = new Arbre(new Valeur(17), A4, A3);

    }
}



