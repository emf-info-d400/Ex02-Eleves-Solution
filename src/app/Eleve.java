package app;

/**
 * Cette classe représente un élève.
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 18 octobre 2023
 * @version 0.1
 */
public class Eleve {

    /**
     * Le constructeur de l'élève.
     *
     * @param prenom le prénom de l'élève
     * @param nom    le nom de l'élève
     */
    public Eleve( String prenom, String nom ) {
        this.prenom = prenom;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }

    /**
     * Getter du prénom de l'élève.
     *
     * @return le prénom de l'élève
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Getter du nom de l'élève.
     *
     * @return le nom de l'élève
     */
    public String getNom() {
        return nom;
    }

    /**
     * L'attribut prénom de l'objet élève.
     */
    private final String prenom;

    /**
     * L'attribut nom de l'objet élève.
     */
    private final String nom;
}
