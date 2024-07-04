import java.util.*;

public class Biblioteca{

    private List<Carte> carti = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    private Biblioteca(){
        System.out.println("Biblioteca s-a deschis!");
    }
    
    private static Biblioteca singleton;
    
    public static Biblioteca getInstance(){
        if (singleton == null){
            singleton = new Biblioteca();
        }
        return singleton;
    }
    
    public void adaugaRoman(String titlu, String autor, int nrPagini, String tip){
        carti.add(new Romane(titlu, autor, nrPagini, tip));
        System.out.println("Adaugat!");
    }

    public void adaugaPoezie(String titlu, String autor, int nrPagini, int nrPoezii){
        carti.add(new Poezii(titlu, autor, nrPagini, nrPoezii));
        System.out.println("Adaugat!");
    }
    
    public void afiseazaCarti(){
        for(Carte carte : carti) {
            System.out.println(carte);
        }
    }
    
    public void afiseazaCartiSortat(){
        Collections.sort(carti, Comparator.comparing(carte -> carte.titlu));
        afiseazaCarti();
    }
    
    public void afiseazaAutor(String titluCarte) throws CarteInexistentaException{
        boolean match = false; 
        for(Carte carte : carti){
            if(carte.titlu.equals(titluCarte)){
                System.out.println("Cartea " + titluCarte + " a fost scrisa de " + carte.autor);
                match = true;
                break;
            }
        }
        if(match == false){
            throw new CarteInexistentaException("Cartea " + titluCarte + " nu se afla in biblioteca");
        }
    }
    
    public void exit(){
        String input;
        String[] param;
        
        do{
            System.out.println("Actiuni: ADD_POEZII, ADD_ROMAN, AF_CARTI, AF_CARTI_SORTATE, AF_AUTOR, EXIT");
            input = sc.nextLine();
            param = input.split("\\s+");
            try{
                switch(param[0].toUpperCase()){
                    case "ADD_POEZII":
                        if(param.length != 5)
                        throw new IllegalArgumentException("Nu ati introdus 5 parametri!");
                        adaugaPoezie(param[1], param[2], Integer.parseInt(param[3]), Integer.parseInt(param[4]));
                        break;
                    case "ADD_ROMANE":
                        if(param.length != 5)
                        throw new IllegalArgumentException("Nu ati introdus 5 parametri!");
                        adaugaRoman(param[1], param[2], Integer.parseInt(param[3]), param[4]);
                        break;
                    case "AF_CARTI":
                        afiseazaCarti();
                        break;
                    case "AF_CARTI_SORTATE":
                        afiseazaCartiSortat();
                        break;
                    case "AF_AUTOR":
                        if(param.length != 2)
                        throw new IllegalArgumentException("Nu ati introdus 2 parametri!");
                        afiseazaAutor(param[1]);
                        break;
                    case "EXIT":
                        System.out.println("Biblioteca s-a inchis!");
                        break;
                    default:
                        System.out.println("Input eronat!");
                }
            }
            catch(IllegalArgumentException | CarteInexistentaException e){
                System.out.println(e.getMessage());
            }
        }
        while(!input.toUpperCase().equals("EXIT"));
        sc.close();
    }
}
