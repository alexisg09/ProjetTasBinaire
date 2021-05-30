import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class ABR {
    public int valeur;
    public ABR sag;
    public ABR sad;


    public ABR (ABR arbre) {
        setSad(arbre.getSad());
        setSag(arbre.getSag());
        setValeur(arbre.getValeur());
    }

    public ABR (int valeur, ABR sag, ABR sad){
        setValeur(valeur);
        setSag(sag);
        setSad(sad);
    }

    public ABR(int valeur){
        setValeur(valeur);
    }

    public ABR() {
    }


    public void displayABR(ABR arbre) {
        if (this.getValeur() == 0 && this.getSad() == null && this.getSag() == null){
            System.out.println("Arbre vide\n");
        } else if (this.getValeur() != 0 && this.getSad() == null && this.getSag() == null){
            System.out.println("Feuille, valeur : "+this.getValeur()+"\n");
        }
        System.out.println("Valeur : "+this.getValeur());
        displayABR(this.getSad());
        displayABR(this.getSag());
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void setSag(ABR sag) {
        this.sag = sag;
    }

    public void setSad(ABR sad) {
        this.sad = sad;
    }

    public int getValeur() {
        return valeur;
    }

    public ABR getSag() {
        return sag;
    }

    public ABR getSad() {
        return sad;
    }
}
