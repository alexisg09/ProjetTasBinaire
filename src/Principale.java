
public class Principale {

    private static String[] tabVal;
    private static Arbre A;

    public static void main(String[] args) {
        ReadFile read = new ReadFile("ProjetTasBinaire/sourceArbre.txt");
        read.read();
        tabVal = read.getTabArbre();

        for(int i = 0; i < tabVal.length; i ++){

            tabVal = read.getTabArbre();
            String[] tab = decoupeVal(i, tabVal);
            String[] borne = getBorne( tab);
            String[] tas = getTas(tab);
            int borneA = Integer.parseInt(borne[0]);
            int borneB = Integer.parseInt(borne[1]);
            int[] tasI = new int[tas.length];
            for (int j = 0; j < tas.length; j++) {
                tasI[j] = Integer.parseInt(tas[j]);
            }
            A = insert(A, new Noeud(new Valeur(borneA,borneB, tasI ), null, null));
        }

        prefixe(A, 'r', 0);





    }

    public static String[] getBorne(String[] val){
        String SEPARATEUR = ":";
        String valeurBorne[] = val[0].split(SEPARATEUR);
        return valeurBorne;
    }
    public static String[] getTas( String[] val){
        String SEPARATEUR = ":";
        String valeurTas[] = val[1].split(SEPARATEUR);
        return valeurTas;
    }

    public static String[] decoupeVal(int index, String[] val){
        String SEPARATEUR = ";";
        String valDecoupe[] = val[index].split(SEPARATEUR);
        return valDecoupe;
    }

    public static Arbre insert(Arbre a, Noeud n){

        if(a == null){
            a = new Arbre(n.getValeur());
        }else{
            if( n.getValeur().getMax() < a.racine().getValeur().getMin() ){
                if(a.racine().getGauche() == null){
                    Arbre b = new Arbre(n.getValeur(), null, null);
                    a.racine().setGauche(b);

                }else insert(a.racine().getGauche(), n);
            }else if(n.getValeur().getMin() > a.racine().getValeur().getMax()){
                if(a.racine().getDroite() == null){
                    Arbre c = new Arbre(n.getValeur(), null, null);
                    a.racine().setDroite(c);
                }else insert(a.racine().getDroite(), n);
            }
        }
        return a;
    }

    public static void prefixe (Arbre a, char g, int i){
        Arbre gene[][][] = new Arbre[5][3][1];
        if(a != null){
            if(g == 'r'){
                gene[i][0][0] = a;
            }
            else if(g == 'g'){
                gene[i][1][0] = a;
            }else {
                gene[i][2][0] = a;
            }
            //System.out.println(i);
            i ++;

            if(a.racine().getGauche() != null) {
                prefixe(a.racine().getGauche(), 'g', i);
            }if(a.racine().getDroite() != null) {
                prefixe(a.racine().getDroite(), 'd', i);
            }
        }
        affiche(gene);


    }

    public static void affiche(Arbre gene[][][]){
        System.out.println(gene.length);
        for(int j = 0; j < gene.length; j ++ ){

            if(gene[j][0][0] != null){
                System.out.println("         "+gene[j][0][0].racine().getValeur().getMax()+"  "+gene[j][0][0].racine().getValeur().getMin());
            }
            if(gene[j][1][0] != null){
                System.out.println(gene[j][1][0].racine().getValeur().getMax()+"  "+gene[j][1][0].racine().getValeur().getMin()+"\n");
            }
            if(gene[j][2][0] != null){
                System.out.println("                         "+gene[j][2][0].racine().getValeur().getMax()+"  "+gene[j][2][0].racine().getValeur().getMin());
            }
        }
    }

}


