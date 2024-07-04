public class Poezii extends Carte{
    
    int nrPoezii;
    
    public Poezii(String titlu, String autor, int nrPagini, int nrPoezii){
        super(titlu, autor, nrPagini);
        this.nrPoezii = nrPoezii;
    }
    
    @Override 
    public String toString(){
        return titlu + ", de " + autor + ", " + nrPagini + " de pagini, avand " + nrPoezii + " poezie/poezii";
    }
    
}
