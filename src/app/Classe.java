package app;

/**
 * Cette classe représente une classe d'élèves.
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 18 octobre 2023
 * @version 0.1
 */
public class Classe {

    /**
     * La taille maximale de notre tableau d'élèves (=contenu de notre classe d'élèves).
     */
    public final static int NBRE_MAX_ELEVES = 20;

    /**
     * L'attribut de la classe qui stocke tous les élèves de celle-ci.
     */
    private Eleve[] eleves;

    /**
     * L'attribut nom de la classe qu'on représente.
     */
    private String nom;

    /**
     * Constructeur d'une classe d'élève.
     *
     * @param nom le nom de cette classe d'élèves
     */
    public Classe( String nom ) {
        this.nom = nom;
        this.eleves = new Eleve[ NBRE_MAX_ELEVES ];
    }

    /**
     * Ajoute un élève à cette classe s'il reste de la place disponible.
     *
     * @param eleve l'élève à rajouter
     *
     * @return vrai si une place libre a été trouvée dans cette classe pour y mettre cet élève, faux
     *         autrement
     */
    public boolean ajouteEleve( Eleve eleve ) {

        // Par défaut, on dit qu'on n'a pas réussi (=pas trouvé de place pour y mettre cet élève)
        boolean resultat = false;

        // On fouille toutes les places assises à la recherche d'une place libre
        for ( int i = 0; i < eleves.length; i++ ) {

            // Cette place est-elle libre ou occuppée ?
            if ( eleves[ i ] == null ) {

                // Elle est libre, alors on y met l'élève
                eleves[ i ] = eleve;

                // On indique qu'on a réussi notre travail
                resultat = true;

                // On arrête de chercher de la place, l'élève a été placé !
                break;
            }

        }

        return resultat;
    }

    /**
     * Supprime un élève de cette classe.
     *
     * @param eleve l'élève à supprimer
     *
     * @return vrai si l'élève figurait bien dans cette classe et qu'il a pu en être retiré, faux
     *         autrement
     */
    public boolean supprimeEleve( Eleve eleve ) {

        // Par défaut, on dit qu'on n'a pas réussi (=pas trouvé cet élève)
        boolean resultat = false;

        // On fouille toutes les places assises à la recherche de cet élève
        for ( int i = 0; i < eleves.length; i++ ) {

            // Cet élève se trouve-t-il à cette place ?
            if ( eleves[ i ] == eleve ) {

                // Oui, on l'a trouvé, alors on va l'enlever et marquer cette place comme désormais libre 
                eleves[ i ] = null;

                // On indique qu'on a réussi notre travail
                resultat = true;

                // On arrête de le chercher cet élève car on l'a déjà trouvé !
                break;
            }

        }

        return resultat;
    }

    /**
     * Indique le nombre de place occupées (=le nombre d'élèves) dans cette classe.
     *
     * @return le nombre de place occupées
     */
    public int getNombreDePlacesOccupees() {

        // Jusqu'à preuve du contraire, il n'y a pas de places occupées
        int nbre = 0;

        // On fouille toutes les places de la classe
        for ( int i = 0; i < eleves.length; i++ ) {

            // Cette place est-elle occupée ?
            if ( eleves[ i ] != null ) {

                // Oui, on a trouvé une place occupée de plus
                nbre++;
            }

        }

        return nbre;
    }

    /**
     * Indique le nombre de place libres dans cette classe.
     *
     * @return le nombre de place libres
     */
    public int getNombreDePlacesLibres() {

        // Jusqu'à preuve du contraire, il n'y a pas de places encore libres
        int nbre = 0;

        // On fouille toutes les places de la classe
        for ( int i = 0; i < eleves.length; i++ ) {

            // Cette place est-elle libre ?
            if ( eleves[ i ] == null ) {

                // Oui, on a trouvé une place libre de plus
                nbre++;
            }

        }

        return nbre;
    }

    /**
     * Affiche toutes les informations sur cette classe, son nom, les places libres et occupées,
     * ainsi que les élèves qui s'y trouvent en ce moment.
     */
    public void afficheClasseEtSonContenu() {

        System.out.println( "Contenu de la classe [" + nom + "] avec ses [" + getNombreDePlacesOccupees() + "] places occupées et [" + getNombreDePlacesLibres() + "] places libres :" );

        // On fouille toutes les places de la classe
        for ( int i = 0; i < eleves.length; i++ ) {

            // Mettre la main sur le contenu du tableau à cet endroit
            Eleve eleve = eleves[ i ];

            // Cette place est-elle occupée ?
            if ( eleve != null ) {

                // Oui, alors l'afficher
                System.out.println( " - L'élève N°" + i + " s'appelle => " + eleve.getPrenom() + " " + eleve.getNom() );
            }
        }

    }

    /**
     * Getter du nom de la classe.
     *
     * @return le nom de la classe
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter modifié de la liste de tous les élèves dans cette classe. La liste retournée ne
     * contient aucun "trou" (=pas de vides, =pas d'absence d'élève, =pas de null quoi).
     *
     * @return un tableau ne contenant que la liste exhaustive des élèves de cette classe
     */
    public Eleve[] getEleves() {

        // Combien d'élèves y a-t-il ?
        int nbreEleves = getNombreDePlacesOccupees();

        // Préparer un tableau permettant de transporter ce nombre d'élèves-là
        Eleve[] resultat = new Eleve[ nbreEleves ];

        // Préparer un indice qui dira où il faudra mettre le prochain élève dans le tableau résultat
        int position = 0;

        // On fouille toutes les places de la classe         
        for ( int i = 0; i < eleves.length; i++ ) {

            // Cette place est-elle occupée ?
            if ( eleves[ i ] != null ) {

                // Oui, alors mettre cet élève dans le tableau à retourner
                resultat[ position ] = eleves[ i ];

                // Le prochaine élève faudra le mettre dans la case suivante
                position++;
            }

        }

        return resultat;
    }


}
