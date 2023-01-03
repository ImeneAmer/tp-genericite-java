import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        int x = 0;
        long id = 0;
        String nom = "";
        String marque = "";
        double prix = 0d;
        String description = "";
        int qte = 0;

        MetierProduitImpl a = new MetierProduitImpl();
        Produit p1 = new Produit(1, "produit1", "marque1", 1530.3d, "discription1", 100);
        a.add(p1);

        do {
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Quitter ce programme.");

            Scanner sc = new Scanner(System.in);
            x = sc.nextInt();

            switch (x){
                case 1:
                    System.out.println(a.getAll());
                    break;
                case 2:
                    System.out.println("entrez l\'id :");
                    Scanner scId = new Scanner(System.in);
                    System.out.println(a.findById(scId.nextLong()).toString());
                    break;
                case 3:
                    Produit produit = new Produit();

                    System.out.println("entrez l\'id :");
                    id = sc.nextLong();
                    produit.setId(id);
                    if(a.findById(id) != null){
                        System.out.println("id existant !!");
                        break;
                    }
                    System.out.println("entrez le nom de produit :");
                    nom = sc.next();
                    produit.setNom(nom);

                    System.out.println("entrez la marque :");
                    marque = sc.next();
                    produit.setMarque(marque);

                    System.out.println("entrez le prix :");
                    prix = sc.nextDouble();
                    produit.setPrix(prix);

                    System.out.println("entrez la description :");
                    description = sc.next();
                    produit.setDescription(description);

                    System.out.println("entrez la quantite de stock :");
                    qte = sc.nextInt();
                    produit.setNbrStock(qte);
                    a.add(produit);

                    for (Produit p : a.getAll()) {
                        System.out.println(p);
                    }
                    System.out.println("Produit ajouté avec succée ");
                    break;
                case 4:
                    System.out.println("entrez l\'id :");
                    id = sc.nextLong();
                    a.delete(id);

                    break;
                case 5:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("nombre inconnu !!, choisissez un autre nombre");
                    break;
            }
        }while (x != 5);
    }
    }

