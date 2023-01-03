import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit>{

    private List<Produit> ListProduit = new ArrayList<>();

    public List<Produit> getListProduit() {
        return ListProduit;
    }

    public void setListProduit(List<Produit> listProduit) {
        ListProduit = listProduit;
    }

    @Override
    public void add(Produit o) {
        Produit p1 = findById(o.getId());
        if(p1 == null) {
            this.ListProduit.add(o);
        }else {
            System.out.println("id existant !! ");
        }

    }

    @Override
    public List<Produit> getAll() {
        return this.ListProduit;
    }

    @Override
    public Produit findById(long id) {
        for (Produit p: this.ListProduit) {
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {

        if(getListProduit().size() == 0){
            System.out.println("la liste de produit est vide");
        }else {
            for (Produit p : ListProduit) {
                if (p.getId() == id) {
                    this.ListProduit.remove(p);
                    System.out.println("Produit supprimée!!");
                }

            }
        }

    }
}
