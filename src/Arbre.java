public class Arbre {
    protected Noeud myRacine;

    /**
     * Crée un arbre sans élément. Sa racine est null.
     * /
     * public Arbre() {
     * this.myRacine = null;
     * }
     * <p>
     * /**
     * Crée et retourne un arbre avec un seul noeud qui s'approprie la donnée \a d.
     *
     * @param d une donnée instanciée.
     */
    public Arbre(Valeur d) {
        this.myRacine = new Noeud(d, null, null);
    }


    /**
     * Crée l'arbre qui l'union de deux sous-arbres plus un
     * noeud qui référence la donnée \a d.
     *
     * @param d  une donnée instanciée.
     * @param AG le sous-arbre gauche. Attention il
     *           ne faut plus s'en servir après, car il est intégré à l'arbre créé.
     * @param AD le sous-arbre droit. Attention il ne faut plus s'en
     *           servir après, car il est intégré à l'arbre créé.
     */
    public Arbre(Valeur d, Arbre AG, Arbre AD) {
        this.myRacine = new Noeud(d, AG.racine(), AD.racine());
    }

    /**
     * @return le noeud racine de l'arbre (éventuellement NULL si arbre vide).
     */
    public Noeud racine() {
        return this.myRacine;
    }

    /**
     * @param N un noeud valide.
     * @return le noeud fils gauche du noeud N (éventuellement NULL si N n'avait
     * pas de fils gauche).
     */
    public Noeud gauche(Noeud N) {
        return N.getGauche();
    }

    /**
     * @param N un noeud valide.
     * @return le noeud fils droit du noeud N (éventuellement NULL si N n'avait
     * pas de fils droit).
     */
    public Noeud droit(Noeud N) {
        return N.getDroite();
    }

    /**
     * Modifie le noeud N de façon à ce que SG devienne sous nouveau
     * sous-arbre gauche. L'ancien sous-arbre gauche de N est perdu.
     *
     * @param N  un noeud valide.
     * @param SG le nouveau sous-arbre, éventuellement vide ou réduit à un noeud.
     */
    public void modifieGauche(Noeud N, Arbre SG) {
        N.gauche = SG.racine();
    }

    /**
     * Modifie le noeud N de façon à ce que SG devienne sous nouveau
     * sous-arbre droit. L'ancien sous-arbre droit de N est perdu.
     *
     * @param N  un noeud valide.
     * @param SG le nouveau sous-arbre, éventuellement vide ou réduit à un noeud.
     */
    public void modifieDroit(Noeud N, Arbre SG) {
        N.droite = SG.racine();
    }

    /**
     * Retourne la donnée stockée dans le noaud N.
     *
     * @param N un noeud valide.
     * @return la donnée du noeud \a N.
     */
    public Valeur valeur(Noeud N) {
        return N.valeur;
    }

    /**
     * Remplace la donnée stockée dans le noaud N par d.
     *
     * @param N un noeud valide.
     * @param d une donnée.
     */
    public void modifieValeur(Noeud N, Valeur d) {
        N.valeur = d;
    }

    public void afficherArbre(){
        boolean fin = false;
        while(fin != true) {
            System.out.println("allo");
        }
    }

    public void afficherArbreFichier(String s) {

    }
}