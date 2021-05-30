import java.util.Arrays;
import java.util.Random;

public class ABRTB {

    public int m;
    public int M;
    public int[] TB;

    public ABRTB sag;
    public ABRTB sad;

    public ABRTB(ABRTB a) {
        this.m = a.getm();
        this.M = a.getM();
        this.TB = a.getTB();
        if (a.getSad() != null) {
            this.sad = a.getSad();
        }

        if (a.getSag() != null) {
            this.sag = a.getSag();
        }
    }

    public ABRTB(int m, int M, int[] TB, ABRTB sag, ABRTB sad) {
        if (m <= M) {
            this.m = m;
            this.M = M;
        } else {
            System.out.println("Erreur : vos bornes sont incohérentes. \n Veuillez choisir une borne M supérieure ou égale à m.\n");
        }

        this.TB = TB;
        if (sad != null) {
            this.sad = sad;
        }

        if (sag != null) {
            this.sag = sag;
        }
    }

    public ABRTB(int m, int M, int[] TB) {
        if (m <= M) {
            this.m = m;
            this.M = M;
        } else {
            System.out.println("Erreur : vos bornes sont incohérentes. \n Veuillez choisir une borne M supérieure ou égale à m.\n");
        }
        this.TB = TB;
    }


    public ABRTB() {

    }

    public void insererABR(ABRTB racine, ABRTB enfant) {
        System.out.println("Chargement de l'arbre...\n");

        if (racine == null) {
            racine.setM(enfant.getM());
            racine.setm(enfant.getm());
            racine.setTB(enfant.getTB());

        } else {
            //cas d'arbre non vide

            if (racine.getm() > enfant.getM()) {

                //cas d'insertion à gauche
                if (racine.getSag() == null) {
                    racine.setSag(enfant);
                } else {
                    insererABR(racine.getSag(), enfant);
                }


            } else if (racine.getM() < enfant.getm()) {

                //cas d'insertion à droite
                if (racine.getSad() == null) {
                    racine.setSad(enfant);
                } else {
                    insererABR(racine.getSad(), enfant);
                }

            } else if (enfant.getM() >= racine.getm() && enfant.getM() <= racine.getM()) {

                //cas d'erreur 1 --> Borne supérieure de l'enfant à insérer se trouvant dans celles du parent
                System.out.print("Valeur à insérer impossible \n");
                System.out.print("Les bornes doivent être disjointes \n");

            } else if (enfant.getm() >= racine.getm() && enfant.getm() <= racine.getM()) {

                //cas d'erreur 2 --> Borne inférieure de l'enfant à insérer se trouvant dans celles du parent
                System.out.print("Valeur à insérer impossible \n");
                System.out.print("Les bornes doivent être disjointes \n");

            }
        }
        System.out.println("Insertion de l'élément terminée \n");

    }


    //ci dessous les fonctions génériques classiques pour la manipulation d'objets en java


    public void setM(int M) {
        this.M = M;
    }

    public void setm(int m) {
        this.m = m;
    }

    public void setTB(int[] TB) {
        this.TB = TB;
    }

    public void setSag(ABRTB sag) {
        this.sag = sag;
    }

    public void setSad(ABRTB sad) {
        this.sad = sad;
    }

    public int getm() {
        return m;
    }

    public int getM() {
        return M;
    }

    public int[] getTB() {
        return TB;
    }

    public ABRTB getSag() {
        return sag;
    }

    public ABRTB getSad() {
        return sad;
    }

    public void displayTB() {
        if (this.TB != null) {
            System.out.println("Tas binaire : ");
            for (int i = 0; i < this.TB.length; i++) {
                System.out.println(this.TB[i]);
            }
            System.out.println("\n");
        }
    }

    public String TBtoString() {
        return Arrays.toString(TB);

    }

    public String getTBforAfficherABR() {
        StringBuffer sb = new StringBuffer();
        String str = "";
        if (this.TB != null) {
            for (int i = 0; i < this.TB.length; i++) {
                sb.append(this.TB[i]);
                sb.append(":");
            }
            str = sb.toString();
        }
        return str;
    }

    public void displayBornes() {
        if ((this.m != 0) && (this.M != 0)) {
            System.out.println("Borne m : " + this.getm());
            System.out.println("Borne M : " + this.getM());
        }
    }

    public void displayArbre(ABRTB abr) {
        if (abr != null) {
            abr.displayBornes();
            abr.displayTB();

            if (abr.getSad() != null) {
                System.out.println(" sous arbre droit pour :" + abr.getm() + " / " + abr.getM() + "\n");

                displayArbre(abr.getSad());
            } else {
                System.out.println("Plus de sous arbre droit pour :" + abr.getm() + " / " + abr.getM() + "\n");
            }
            if (abr.getSag() != null) {
                System.out.println(" sous arbre gauche pour : \n" + abr.getm() + " / " + abr.getM() + "\n");

                displayArbre(abr.getSag());
            } else {
                System.out.println("Plus de sous arbre gauche pour : " + abr.getm() + " / " + abr.getM() + "\n");
            }


        } else {
            System.out.println("Fin de l'arbre");

        }

    }
}