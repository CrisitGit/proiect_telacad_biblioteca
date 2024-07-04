public class Carte{
    
    String titlu;
    String autor;
    int nrPagini;
    
    public Carte(String titlu, String autor, int nrPagini){
        this.titlu = titlu;
        this.autor = autor; 
        this.nrPagini = nrPagini;
    }
    
    @Override
    public String toString(){
        return titlu + ", de " + autor + ", " + nrPagini + " de pagini";
    }
}
