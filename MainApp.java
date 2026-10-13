
public class MainApp {
    public static void main(String[] args) {

        // 1. Création des clients
        Client c1 = new Client("07123456", "Ben Salah", "Sonia", "98765432");
        Client c2 = new Client("09876543", "Kacem", "Ahmed", "50112233");

        // 2. Création des comptes bancaires
        CompteBancaire compte1 = new CompteBancaire("CB-1001", 500.0, c1);
        CompteBancaire compte2 = new CompteBancaire("CB-1002", 1500.0, c2);

        // 3. Affichage initial des comptes
        compte1.afficherDetails();
        compte2.afficherDetails();

        // 4. Test des dépôts et retraits
        compte1.deposer(200.0);
        compte1.retirer(1000.0);
        compte1.retirer(300.0);

        // 5. Test du virement
        compte2.virement(compte1, 500.0);

        // 6. État final et statistiques
        compte1.afficherDetails();
        compte2.afficherDetails();

        System.out.println("\nNombre total de comptes créés : "
                + CompteBancaire.getNombreComptes());
    }
}

