import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.lang.Object.*;

public class Principale {

    private static String[] tabVal;
    private static Arbre A;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean mainLoop = true;

        int choice;
        while (true) {
            System.out.println("Menu Principal\n");
            System.out.println("Le programme traitera (si besoin) chaque option avec le fichier fourni dans chaque fonction init<non_de_la_fonction> (voir fin du fichier Main.java).");
            System.out.print("(N'oubliez donc pas de spécifier le chemin absolu de votre fichier dans le code de la fonction voulue) \n\n");
            System.out.print("1.) Fichier vers ABRTB\n");
            System.out.print("2.) ABRTB vers fichier\n"); //TODO
            System.out.print("3.) Affichage à l'écran\n");
            System.out.print("4.) ABRTB aléatoire\n");
            System.out.print("5.) Vérification\n");
            System.out.print("6.) Recherche d'un entier\n");
            System.out.print("7.) Suppression d'un entier\n");
            System.out.print("8.) Insertion d'un entier\n");
            System.out.print("9.) ABRTB vers ABR\n"); //TODO
            System.out.print("10.) ABRTB vers ABR des k-ièmes plus grands éléments\n"); //TODO
            System.out.print("0.) Fin\n");
            System.out.print("\nChoisissez une option : ");

            choice = input.nextInt();


            switch (choice) {

                case 1:
                    FicVersABRTB();
                    break;
                case 2:
                    System.out.print("\n");
                    break;
                case 3:
                    afficherEcran();
                    break;
                case 4:

                    Scanner entree = new Scanner(System.in);
                    int choixP;
                    int choixQ;

                    System.out.print("Rentrez la variable p:\n");
                    choixP = input.nextInt();
                    System.out.print("Rentrez la variable q:\n");
                    choixQ = input.nextInt();
                    afficherABRlikeFic(generateABRTB(choixP, choixQ));
                    break;

                case 5:
                    initVerifABRTB();
                    break;

                case 6:
                    Scanner entreeRecherche = new Scanner(System.in);
                    int valeurRecherchee;
                    System.out.print("Rentrez la valeur recherchée :\n");
                    valeurRecherchee = entreeRecherche.nextInt();
                    initRechercheVal(valeurRecherchee);
                    break;

                case 7:
                    Scanner entreeAsuppr = new Scanner(System.in);
                    int valeurAsuppr;
                    System.out.print("Rentrez la valeur à supprimer :\n");
                    valeurAsuppr = entreeAsuppr.nextInt();
                    initSupprVal(valeurAsuppr);
                    break;
                case 8:
                    Scanner entreeAinser = new Scanner(System.in);
                    int valeurAinser;
                    System.out.print("Rentrez la valeur à insérer :\n");
                    valeurAinser = entreeAinser.nextInt();
                    initInserVal(valeurAinser);

                    break;
                case 9:
                    initABRTBversABR();

                    break;
                case 10:
                    System.out.print("TEST\n");

                    break;

                case 0:
                    System.out.println("Sortie...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ce n'est pas une option valide, choisissez-en une autre.");
                    break;

            }


        }


    }


    //2.1.1 Fichier vers ABRTB
    public static void FicVersABRTB() {
        ReadFile read = new ReadFile("F:\\AFTER_13_MAI_19\\bullshit\\L3\\Algo\\ProjetTasBinaireFix\\sourceArbre.txt");
        read.read();
        tabVal = read.getTabArbre();
        String[] tabinit = decoupeVal(0, tabVal);
        String[] borneinit = getBorne(tabinit);
        String[] tasinit = getTas(tabinit);
        int borneAinit = Integer.parseInt(borneinit[0]);
        int borneBinit = Integer.parseInt(borneinit[1]);
        int[] tasIinit = new int[tasinit.length];
        for (int j = 0; j < tasinit.length; j++) {
            tasIinit[j] = Integer.parseInt(tasinit[j]);
        }
        ABRTB monArbre = new ABRTB();
        monArbre.setTB(tasIinit);
        monArbre.setM(borneBinit);
        monArbre.setm(borneAinit);
        for (int i = 1; i < tabVal.length; i++) {

            tabVal = read.getTabArbre();
            String[] tab = decoupeVal(i, tabVal);
            String[] borne = getBorne(tab);
            String[] tas = getTas(tab);
            int borneA = Integer.parseInt(borne[0]);
            int borneB = Integer.parseInt(borne[1]);
            int[] tasI = new int[tas.length];
            for (int j = 0; j < tas.length; j++) {
                tasI[j] = Integer.parseInt(tas[j]);
            }
            monArbre.insererABR(monArbre, new ABRTB(borneA, borneB, tasI, null, null));
        }

//        afficherABRlikeFic(generateABRTB(20, 100));
//        ABRTB myRandomArbre = generateABRTB(1,150);
//        myRandomArbre.displayArbre(myRandomArbre);
        monArbre.displayArbre(monArbre);
//        TasVersABR(monArbre);




    }
    //2.1.3
    public static void afficherEcran(){
        ReadFile read = new ReadFile("F:\\AFTER_13_MAI_19\\bullshit\\L3\\Algo\\ProjetTasBinaireFix\\sourceArbre.txt");
        read.read();
        tabVal = read.getTabArbre();
        String[] tabinit = decoupeVal(0, tabVal);
        String[] borneinit = getBorne(tabinit);
        String[] tasinit = getTas(tabinit);
        int borneAinit = Integer.parseInt(borneinit[0]);
        int borneBinit = Integer.parseInt(borneinit[1]);
        int[] tasIinit = new int[tasinit.length];
        for (int j = 0; j < tasinit.length; j++) {
            tasIinit[j] = Integer.parseInt(tasinit[j]);
        }
        ABRTB monArbre = new ABRTB();
        monArbre.setTB(tasIinit);
        monArbre.setM(borneBinit);
        monArbre.setm(borneAinit);
        for (int i = 1; i < tabVal.length; i++) {

            tabVal = read.getTabArbre();
            String[] tab = decoupeVal(i, tabVal);
            String[] borne = getBorne(tab);
            String[] tas = getTas(tab);
            int borneA = Integer.parseInt(borne[0]);
            int borneB = Integer.parseInt(borne[1]);
            int[] tasI = new int[tas.length];
            for (int j = 0; j < tas.length; j++) {
                tasI[j] = Integer.parseInt(tas[j]);
            }
            monArbre.insererABR(monArbre, new ABRTB(borneA, borneB, tasI, null, null));
        }
        afficherABRlikeFic(monArbre);
    }

    public static String[] getBorne(String[] val) {
        String SEPARATEUR = ":";
        String valeurBorne[] = val[0].split(SEPARATEUR);
        return valeurBorne;
    }

    public static String[] getTas(String[] val) {
        String SEPARATEUR = ":";
        String valeurTas[] = val[1].split(SEPARATEUR);
        return valeurTas;
    }

    public static String[] decoupeVal(int index, String[] val) {
        String SEPARATEUR = ";";
        String valDecoupe[] = val[index].split(SEPARATEUR);
        return valDecoupe;
    }


    //2.2.4 ABRTB vers ABR
    public static void TasVersABR(ABRTB arbre) {
        if (arbre == null) {
            System.out.println("Arbre vide");
        } else {
            if (arbre.getTB() != null) {
                generateABR(arbre.getTB(), new ABR(arbre.getTB()[0]));
            }
            if (arbre.getSag() != null) {
                generateABR(arbre.getSag().getTB(), new ABR(arbre.getSag().getTB()[0]));
            }
            if (arbre.getSad() != null) {
                generateABR(arbre.getSad().getTB(), new ABR(arbre.getSad().getTB()[0]));
            }
        }
    }

    public static void generateABR(int[] tas, ABR arbre) {
        for (int i = 1; i < tas.length; i++) {
            insererABR(arbre, tas[i]);
        }
        System.out.println("Génération de l'ABR terminée\n");
        arbre.displayABR(arbre);
    }

    public static void insererABR(ABR arbre, int valeur) {
        if (arbre.getValeur() == 0) {
            arbre.setValeur(valeur);
        } else {
            if (arbre.getValeur() > valeur) {
                insererABR(arbre.getSag(), valeur);
            }
            if (arbre.getValeur() < valeur) {
                insererABR(arbre.getSad(), valeur);
            }
        }
    }


    //2.2.1 Recherche d'un entier
    public static boolean rechercheVal(ABRTB arbre, int x) {
        boolean trouve;
        trouve = false;
        if (arbre == null) {
            System.out.println("Cet arbre est vide\n");
        } else {
            int i = 0;
            while (i < arbre.getTB().length && !trouve) {
                if (arbre.getTB()[i] == x) {
                    System.out.println("Valeur trouvée dans un tas\n");
                    System.out.println("Il se trouve dans la noeud aux bornes " + arbre.getm() + ":" + arbre.getM());
                    trouve = true;
                    return trouve;
                }
                i++;

            }
            if (x == arbre.getm() || x == arbre.M) {
                System.out.println("La valeur correspond à une des bornes d'un noeud\n");
                trouve = false;
                return trouve;
            }
            System.out.println("Valeur non trouvée dans le tas du noeud actuel\n");
            System.out.println("Recherche parmi les enfants existants\n");
            if (arbre.getSag() == null) {
                System.out.println("Pas de sous-arbre gauche\n");
                System.out.println("Recherche dans l'autre sous-arbre\n");
            } else {
                rechercheVal(arbre.getSag(), x);
            }
            if (arbre.getSad() == null) {
                System.out.println("Pas de sous-arbre droit\n");
            } else {
                rechercheVal(arbre.getSad(), x);
            }
        }
        return trouve;
    }


    //2.2.3 Insertion d'un entier
    public static void inserVal(ABRTB arbre, int x) {
        if (insertionVal(arbre, x)) {
            afficherABRlikeFic(arbre);
        } else {
            System.out.println("L'élément n'a pas pu être inséré\n");
        }
    }

    public static boolean insertionVal(ABRTB arbre, int x) {
        boolean trouve = false;
        System.out.println("Lancement de la fonction rechercheVal pour vérifier que votre valeur n'est pas déjà dans l'arbre\n");
        if (rechercheVal(arbre, x)) {
            System.out.println("La valeur que vous avez rentrée est donc déjà dans cet arbre\n");
        } else {
            System.out.println("La valeur rentrée n'est pas encore dans l'arbre, on va essayer de l'insérer...\n");
            if (x < arbre.getM() && x > arbre.getm()) {
                arbre.setTB(addElement(arbre.getTB(), x));
                System.out.println("Valeur insérée");
                return trouve = true;
            } else {
                System.out.println("La valeur ne peut pas être insérée dans le tas actuel, recherche dans les sous-arbre si possible...\n");
            }
            if (arbre.getSag() == null) {
                System.out.println("\n");
            } else {
                insertionVal(arbre.getSag(), x);
            }
            if (arbre.getSad() == null) {
                System.out.println("\n");
            } else {
                insertionVal(arbre.getSad(), x);
            }
        }

        return trouve;
    }

    //2.2.2 Suppression d'un entier
    public static void supprVal(ABRTB arbre, int x) {
        if (suppressionVal(arbre, x)) {
            afficherABRlikeFic(arbre);
        } else {
            System.out.println("L'élément n'a pas pu être supprimé\n");
        }
    }

    public static boolean suppressionVal(ABRTB arbre, int x) {
        boolean state = false;
        int i = 0;
        boolean trouve = false;
        if (!rechercheVal(arbre, x)) {
            System.out.println("Cette valeur n'est pas dans l'arbre\n");
            return state = false;
        } else {
            while (i < arbre.getTB().length && !trouve) {
                if (x == arbre.getTB()[i]) {
                    trouve = true;
                    arbre.setTB(removeElements(arbre.getTB(), i));
                    System.out.println("Element supprimé\n");
                }
                i++;
            }
            if (arbre.getSag() == null) {
                System.out.println("\n");
            } else {
                suppressionVal(arbre.getSag(), x);
            }
            if (arbre.getSad() == null) {
                System.out.println("\n");
            } else {
                suppressionVal(arbre.getSad(), x);
            }
        }

        return state;

    }

    //2.1.5 Verification
    public static boolean verifABRTB(ABRTB racine) {
        boolean verif = true;
        System.out.println("Début de la vérification \n");

        if (!verifABR(racine)) {
            verif = false;
            return verif;
        }

        if (racine == null) {
            System.out.println("Cet arbre ou sous-arbre est vide");
        } else {
            if (racine.getm() < racine.getSag().getM()) {
                System.out.println("Une des règles n'est pas respectée, les intervales sont disjoints");
                verif = false;
            } else {
                if (verifTB(racine.getTB(), racine.getm(), racine.getM())) {
                    if (racine.getSag() == null) {
                        System.out.println("\n");
                    } else {
                        verifABRTB(racine.getSag());
                    }
                } else {
                    verif = false;
                    System.out.println("Une des règles n'est pas respectée, les valeurs du tas ne sont pas comprise entre les bornes");

                }
            }
            if (racine.getM() > racine.getSad().getm()) {
                System.out.println("Une des règles n'est pas respectée, les intervales sont disjoints");
                verif = false;
            } else {
                if (verifTB(racine.getTB(), racine.getm(), racine.getM())) {

                    if (racine.getSad() == null) {
                        System.out.println("\n");
                    } else {
                        verifABRTB(racine.getSad());
                    }
                } else {
                    verif = false;
                    System.out.println("Une des règles n'est pas respectée, les valeurs du tas ne sont pas comprise entre les bornes");

                }
            }
        }
        return verif;
    }

    public static boolean verifTB(int[] tas, int m, int M) {
        boolean verif = true;
        for (int i = 0; i < tas.length; i++) {
            if (m > tas[i] || M < tas[i]) {
                verif = false;
            }
        }
        return verif;
    }

    public static boolean verifABR(ABRTB arbre) {
        boolean verif = true;

        if (arbre == null) {
            System.out.println("Cet arbre est vide");
            verif = false;
        } else {
            if (arbre.getm() < arbre.getSag().getM()) {
                verif = false;
                System.out.println("Une des règles n'est pas respectée, cet arbre n'est pas un ABR");
            } else {
                verifABR(arbre.getSag());
            }
            if (arbre.getM() > arbre.getSad().getm()) {
                verif = false;
                System.out.println("Une des règles n'est pas respectée, cet arbre n'est pas un ABR");
            } else {
                verifABR(arbre.getSad());
            }
        }
        return verif;
    }

    //2.1.3 Affichage à l'écran
    public static void afficherABRlikeFic(ABRTB arbre) {
        if (arbre == null) {
            System.out.println("\n\nFin de l'arbre");
        } else {
            System.out.println(arbre.getm() + ":" + arbre.getM() + ";" + arbre.getTBforAfficherABR());
            if (arbre.getSad() != null) {
                afficherABRlikeFic(arbre.getSad());
            }
            if (arbre.getSag() != null) {
                afficherABRlikeFic(arbre.getSag());
            }
        }

    }


    //2.1.4 ABRTB Aléatoire
    public static ABRTB generateABRTB(int p, int q) {
        ABRTB arbre = new ABRTB();
        int xinit = getRandom(1, q);
        int Minit = getRandom(xinit, q);
        int minit = getRandom(1, Minit);
        int[] tasinit = new int[Minit - minit]; // On initialise la taille du tas au nombre de valeurs possibles
        for (int j = 0; j < Minit - minit; j++) {
            tasinit = addElement(tasinit, getRandom(minit, Minit));
        }
        tasinit = removeElements(tasinit, 0);
        for (int k = 0; k < tasinit.length; k++) {
            tasinit = eliminateDuplicates(tasinit);
        }

        arbre.setm(minit);
        arbre.setM(Minit);
        arbre.setTB(tasinit);
//        ABRTB arbre = new ABRTB(minit, Minit, tasinit);

        for (int i = 0; i < p; i++) {
            int x = getRandom(1, q - 1);
            int M = getRandom(x, q - 1);
            int m = getRandom(1, M - 1);
            //gerer longueur du tas M - m
            //Gerer valeurs du tas != m et M
            //gerer bornes disjointes
            int[] tas = new int[M - m]; // On initialise la taille du tas au nombre de valeurs possibles
            for (int j = 0; j < M - m; j++) {
                tas = addElement(tas, getRandom(m, M));
            }
            tas = removeElements(tas, 0);
            for (int k = 0; k < tas.length; k++) {
                tas = eliminateDuplicates(tas);
            }

            ABRTB enfant = new ABRTB(m, M, tas, null, null);
            arbre.insererABR(arbre, enfant);
        }

        return arbre;
    }

    public static int getRandom(int min, int max) {
        if (min >= max) {
            System.out.println("Veuillez choisir une valeur pour Q plus grande que 1");
        }
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    static int[] addElement(int[] a, int e) {
        a = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }

    public static int[] removeElements(int[] arr, int key) {
        // Move all other elements to beginning
        int index = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != key)
                arr[index++] = arr[i];

        // Create a copy of arr[]
        return Arrays.copyOf(arr, index);
    }

    public static int[] eliminateDuplicates(int[] list) {
        int newLength = list.length;
        // find length w/o duplicates:
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < i; j++) {
                if (list[i] == list[j]) {   // if duplicate founded then decrease length by 1
                    newLength--;
                    break;
                }
            }
        }

        int[] newArray = new int[newLength]; // create new array with new length
        newArray[0] = list[0];  // 1st element goes to new array
        int inx = 1;            // index for 2nd element of new array
        boolean isDuplicate;

        for (int i = 1; i < list.length; i++) {
            isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (list[i] == list[j]) {  // if duplicate founded then change boolean variable and break
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {     // if it's not duplicate then put it to new array
                newArray[inx] = list[i];
                inx++;
            }
        }
        return newArray;
    }


//
//    public static Arbre insert(Arbre a, Noeud n) {
//
//        if (a == null) {
//            a = new Arbre(n.getValeur());
//        } else {
//            if (n.getValeur().getMax() < a.racine().getValeur().getMin()) {
//                if (a.racine().getGauche() == null) {
//                    Arbre b = new Arbre(n.getValeur(), null, null);
//                    a.racine().setGauche(b);
//
//                } else insert(a.racine().getGauche(), n);
//            } else if (n.getValeur().getMin() > a.racine().getValeur().getMax()) {
//                if (a.racine().getDroite() == null) {
//                    Arbre c = new Arbre(n.getValeur(), null, null);
//                    a.racine().setDroite(c);
//                } else insert(a.racine().getDroite(), n);
//            }
//        }
//        return a;
//    }

    public static void prefixe(Arbre a, char g, int i) {
        Arbre gene[][] = new Arbre[5][3];
        if (a != null) {
            if (g == 'r') {
                gene[i][0] = a;
            } else if (g == 'g') {
                gene[i][1] = a;
            } else {
                gene[i][2] = a;
            }
            //System.out.println(i);
            i++;

            if (a.racine().getGauche() != null) {
                prefixe(a.racine().getGauche(), 'g', i);
            }
            if (a.racine().getDroite() != null) {
                prefixe(a.racine().getDroite(), 'd', i);
            }
        }
        affiche(gene);


    }

    public static void affiche(Arbre gene[][]) {
        //  System.out.println(gene.length);
        for (int j = 0; j < gene.length; j++) {

            if (gene[j][0] != null) {
                // System.out.println("         "+gene[j][0].racine().getValeur().getMax()+"  "+gene[j][0].racine().getValeur().getMin());
            }
            if (gene[j][1] != null) {
                //  System.out.println(gene[j][1].racine().getValeur().getMax()+"  "+gene[j][1].racine().getValeur().getMin()+"\n");
            }
            if (gene[j][2] != null) {
                //   System.out.println("                         "+gene[j][2].racine().getValeur().getMax()+"  "+gene[j][2].racine().getValeur().getMin());
            }
        }
    }


    //Ci dessous toutes les fonctions prenant en compte le fichier voulu
    //Il est donc nécessaire de modifier chaque chemin absolu en fonction du fichier que vous voulez traiter


    public static void initVerifABRTB(){
        ReadFile read = new ReadFile("F:\\AFTER_13_MAI_19\\bullshit\\L3\\Algo\\ProjetTasBinaireFix\\sourceArbre.txt");
        read.read();
        tabVal = read.getTabArbre();
        String[] tabinit = decoupeVal(0, tabVal);
        String[] borneinit = getBorne(tabinit);
        String[] tasinit = getTas(tabinit);
        int borneAinit = Integer.parseInt(borneinit[0]);
        int borneBinit = Integer.parseInt(borneinit[1]);
        int[] tasIinit = new int[tasinit.length];
        for (int j = 0; j < tasinit.length; j++) {
            tasIinit[j] = Integer.parseInt(tasinit[j]);
        }
        ABRTB monArbre = new ABRTB();
        monArbre.setTB(tasIinit);
        monArbre.setM(borneBinit);
        monArbre.setm(borneAinit);
        for (int i = 1; i < tabVal.length; i++) {

            tabVal = read.getTabArbre();
            String[] tab = decoupeVal(i, tabVal);
            String[] borne = getBorne(tab);
            String[] tas = getTas(tab);
            int borneA = Integer.parseInt(borne[0]);
            int borneB = Integer.parseInt(borne[1]);
            int[] tasI = new int[tas.length];
            for (int j = 0; j < tas.length; j++) {
                tasI[j] = Integer.parseInt(tas[j]);
            }
            monArbre.insererABR(monArbre, new ABRTB(borneA, borneB, tasI, null, null));
        }
        verifABR(monArbre);
    }

    public static void initRechercheVal(int x) {
        ReadFile read = new ReadFile("F:\\AFTER_13_MAI_19\\bullshit\\L3\\Algo\\ProjetTasBinaireFix\\sourceArbre.txt");
        read.read();
        tabVal = read.getTabArbre();
        String[] tabinit = decoupeVal(0, tabVal);
        String[] borneinit = getBorne(tabinit);
        String[] tasinit = getTas(tabinit);
        int borneAinit = Integer.parseInt(borneinit[0]);
        int borneBinit = Integer.parseInt(borneinit[1]);
        int[] tasIinit = new int[tasinit.length];
        for (int j = 0; j < tasinit.length; j++) {
            tasIinit[j] = Integer.parseInt(tasinit[j]);
        }
        ABRTB monArbre = new ABRTB();
        monArbre.setTB(tasIinit);
        monArbre.setM(borneBinit);
        monArbre.setm(borneAinit);
        for (int i = 1; i < tabVal.length; i++) {

            tabVal = read.getTabArbre();
            String[] tab = decoupeVal(i, tabVal);
            String[] borne = getBorne(tab);
            String[] tas = getTas(tab);
            int borneA = Integer.parseInt(borne[0]);
            int borneB = Integer.parseInt(borne[1]);
            int[] tasI = new int[tas.length];
            for (int j = 0; j < tas.length; j++) {
                tasI[j] = Integer.parseInt(tas[j]);
            }
            monArbre.insererABR(monArbre, new ABRTB(borneA, borneB, tasI, null, null));
        }
        rechercheVal(monArbre, x);
    }

    public static void initSupprVal(int x) {
        ReadFile read = new ReadFile("F:\\AFTER_13_MAI_19\\bullshit\\L3\\Algo\\ProjetTasBinaireFix\\sourceArbre.txt");
        read.read();
        tabVal = read.getTabArbre();
        String[] tabinit = decoupeVal(0, tabVal);
        String[] borneinit = getBorne(tabinit);
        String[] tasinit = getTas(tabinit);
        int borneAinit = Integer.parseInt(borneinit[0]);
        int borneBinit = Integer.parseInt(borneinit[1]);
        int[] tasIinit = new int[tasinit.length];
        for (int j = 0; j < tasinit.length; j++) {
            tasIinit[j] = Integer.parseInt(tasinit[j]);
        }
        ABRTB monArbre = new ABRTB();
        monArbre.setTB(tasIinit);
        monArbre.setM(borneBinit);
        monArbre.setm(borneAinit);
        for (int i = 1; i < tabVal.length; i++) {

            tabVal = read.getTabArbre();
            String[] tab = decoupeVal(i, tabVal);
            String[] borne = getBorne(tab);
            String[] tas = getTas(tab);
            int borneA = Integer.parseInt(borne[0]);
            int borneB = Integer.parseInt(borne[1]);
            int[] tasI = new int[tas.length];
            for (int j = 0; j < tas.length; j++) {
                tasI[j] = Integer.parseInt(tas[j]);
            }
            monArbre.insererABR(monArbre, new ABRTB(borneA, borneB, tasI, null, null));
        }
        supprVal(monArbre, x);

    }

    public static void initInserVal(int x) {
        ReadFile read = new ReadFile("F:\\AFTER_13_MAI_19\\bullshit\\L3\\Algo\\ProjetTasBinaireFix\\sourceArbre.txt");
        read.read();
        tabVal = read.getTabArbre();
        String[] tabinit = decoupeVal(0, tabVal);
        String[] borneinit = getBorne(tabinit);
        String[] tasinit = getTas(tabinit);
        int borneAinit = Integer.parseInt(borneinit[0]);
        int borneBinit = Integer.parseInt(borneinit[1]);
        int[] tasIinit = new int[tasinit.length];
        for (int j = 0; j < tasinit.length; j++) {
            tasIinit[j] = Integer.parseInt(tasinit[j]);
        }
        ABRTB monArbre = new ABRTB();
        monArbre.setTB(tasIinit);
        monArbre.setM(borneBinit);
        monArbre.setm(borneAinit);
        for (int i = 1; i < tabVal.length; i++) {

            tabVal = read.getTabArbre();
            String[] tab = decoupeVal(i, tabVal);
            String[] borne = getBorne(tab);
            String[] tas = getTas(tab);
            int borneA = Integer.parseInt(borne[0]);
            int borneB = Integer.parseInt(borne[1]);
            int[] tasI = new int[tas.length];
            for (int j = 0; j < tas.length; j++) {
                tasI[j] = Integer.parseInt(tas[j]);
            }
            monArbre.insererABR(monArbre, new ABRTB(borneA, borneB, tasI, null, null));
        }
        inserVal(monArbre, x);
    }

    public static void initABRTBversABR() {
        ReadFile read = new ReadFile("F:\\AFTER_13_MAI_19\\bullshit\\L3\\Algo\\ProjetTasBinaireFix\\sourceArbre.txt");
        read.read();
        tabVal = read.getTabArbre();
        String[] tabinit = decoupeVal(0, tabVal);
        String[] borneinit = getBorne(tabinit);
        String[] tasinit = getTas(tabinit);
        int borneAinit = Integer.parseInt(borneinit[0]);
        int borneBinit = Integer.parseInt(borneinit[1]);
        int[] tasIinit = new int[tasinit.length];
        for (int j = 0; j < tasinit.length; j++) {
            tasIinit[j] = Integer.parseInt(tasinit[j]);
        }
        ABRTB monArbre = new ABRTB();
        monArbre.setTB(tasIinit);
        monArbre.setM(borneBinit);
        monArbre.setm(borneAinit);
        for (int i = 1; i < tabVal.length; i++) {

            tabVal = read.getTabArbre();
            String[] tab = decoupeVal(i, tabVal);
            String[] borne = getBorne(tab);
            String[] tas = getTas(tab);
            int borneA = Integer.parseInt(borne[0]);
            int borneB = Integer.parseInt(borne[1]);
            int[] tasI = new int[tas.length];
            for (int j = 0; j < tas.length; j++) {
                tasI[j] = Integer.parseInt(tas[j]);
            }
            monArbre.insererABR(monArbre, new ABRTB(borneA, borneB, tasI, null, null));
        }
        TasVersABR(monArbre);
    }



}
