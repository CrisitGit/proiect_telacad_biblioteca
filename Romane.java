public class Romane extends Carte{
    
    String tip;
    
    public Romane(String titlu, String autor, int nrPagini, String tip){
        super(titlu, autor, nrPagini);
        this.tip = tip;
    }
    
    @Override
    public String toString(){
        return titlu + ", de " + autor + ", " + nrPagini + " pagini, " + tip;
    }
}
