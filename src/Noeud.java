public class Noeud {
    Valeur valeur;
    Noeud gauche;
    Noeud droite;

    Noeud(Valeur v, Noeud g, Noeud d) {
        this.valeur = v;
        this.gauche = g;
        this.droite = d;
    }

    public Valeur getValeur() {
        return valeur;
    }

    public void setValeur(Valeur valeur) {
        this.valeur = valeur;
    }

    public Noeud getGauche() {
        return gauche;
    }

    public void setGauche(Noeud gauche) {
        this.gauche = gauche;
    }

    public Noeud getDroite() {
        return droite;
    }

    public void setDroite(Noeud droite) {
        this.droite = droite;
    }
}
