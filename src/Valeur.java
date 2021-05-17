public class Valeur {
    private int [] bornes;
    private int [] maxtas;

    Valeur(int c1, int c2, int [] v) {
        this.bornes = new int[3];
        this.bornes[1] = c1;
        this.bornes[2] = c2;
        this.maxtas = v;
    }

    public int getMin(){
        int a;
        if(this.bornes[1] < this.bornes[2] ){
            a = this.bornes[1];
        }else a = this.bornes[2];

        return a;
    }

    public int getMax(){
        int a;
        if(this.bornes[1] < this.bornes[2] ){
            a = this.bornes[2];
        }else a = this.bornes[1];

        return a;
    }
}
