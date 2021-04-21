public class Principale {

    public static void main(String[] args) {

        Arbre A1 = new Arbre(new Valeur(15, 15, null));
        Arbre A2 = new Arbre(new Valeur(7, 7, null));
        Arbre A3 = new Arbre(new Valeur(18, 18, null));
        Arbre A4 = new Arbre(new Valeur(10, 10, null), A2, A1);
        Arbre A = new Arbre(new Valeur(17, 17, null), A4, A3);

    }
}



