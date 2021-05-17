public class Noeud {
    Valeur valeur;
    Arbre gauche;
    Arbre droite;

    Noeud(Valeur v, Arbre g, Arbre d) {
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

    public Arbre getGauche() {
        return gauche;
    }

    public void setGauche(Arbre gauche) {
        this.gauche = gauche;
    }

    public Arbre getDroite() {
        return droite;
    }

    public void setDroite(Arbre droite) {
        this.droite = droite;
    }
}
