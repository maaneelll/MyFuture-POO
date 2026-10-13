
public class CompteBancaire {

    private String numeroCompte;
    private double solde;
    private Client titulaire;
    private static int nombreComptes = 0;

    // Constructeur
    public CompteBancaire(String numeroCompte, double soldeInitial, Client titulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = soldeInitial;
        this.titulaire = titulaire;
        nombreComptes++;
    }

    // Getters
    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public Client getTitulaire() {
        return titulaire;
    }

    public static int getNombreComptes() {
        return nombreComptes;
    }

    // Setters
    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setTitulaire(Client titulaire) {
        this.titulaire = titulaire;
    }

    // Dépôt
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant
                    + " TND effectué sur le compte " + numeroCompte + ".");
        } else {
            System.out.println("Erreur : montant invalide.");
        }
    }

    // Retrait
    public void retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            System.out.println("Retrait de " + montant
                    + " TND effectué sur le compte " + numeroCompte + ".");
        } else {
            System.out.println("Échec : Solde insuffisant sur le compte "
                    + numeroCompte + " (Solde actuel : " + solde + " TND).");
        }
    }

    // Virement
    public void virement(CompteBancaire destination, double montant) {
        System.out.println("\nTentative de virement de " + montant
                + " TND vers le compte " + destination.getNumeroCompte() + "...");

        if (montant > 0 && montant <= solde) {
            retirer(montant);
            destination.deposer(montant);
            System.out.println("Virement réussi !");
        } else {
            System.out.println("Échec du virement : montant invalide ou solde insuffisant.");
        }
    }

    // Affichage des détails
    public void afficherDetails() {
        System.out.println("Compte N° : " + numeroCompte);
        titulaire.afficherClient();
        System.out.println("Solde Actuel : " + solde + " TND");
    }
}
