public class Principale {

    public static void main(String[] args) {

        System.out.println('erererererrer');

        int[] maxtas = {75, 60, 62, 55};

        Arbre A5 = new Arbre(new Valeur());
        Arbre A4 = new Arbre(new Valeur());
        Arbre A3 = new Arbre(new Valeur());
        Arbre A2 = new Arbre(new Valeur(), null, A5);
        Arbre A1 = new Arbre(new Valeur(), A3, A4);
        Arbre A = new Arbre(new Valeur(), A1, A2);
        A.afficherArbre();
    }
}



