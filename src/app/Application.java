package app;

/**
 * Application "Application". Découverte des classes en Java.
 *
 * @author <a href="mailto:friedlip@edufr.ch">Paul Friedli</a>
 * @since 18 octobre 2023
 * @version 0.1
 */
public class Application {

    /**
     * LA méthode main() de l'application, là où tout commence mais... tout se finit-il bien là ?
     *
     * @param args les arguments pour le programme passés sur la ligne de commande
     */
    public static void main( String[] args ) {

        // Une classe d'élèves
        Classe classe = new Classe( "300211" );

        // Y mettre les élèves souhaités aux endroits définis
        Eleve e1 = new Eleve( "James", "Cameron" );
        classe.ajouteEleve( e1 );
        Eleve vireDeLEMF = new Eleve( "Ri", "Golo" );
        classe.ajouteEleve( vireDeLEMF );
        Eleve e2 = new Eleve( "Mac", "Haroni" );
        classe.ajouteEleve( e2 );
        classe.ajouteEleve( new Eleve( "John", "D'Oeuf" ) );
        classe.ajouteEleve( new Eleve( "Alex", "Terrieur" ) );
        classe.ajouteEleve( new Eleve( "Alain", "Terrieur" ) );
        classe.supprimeEleve( vireDeLEMF );

        // Afficher le contenu de la classe
        classe.afficheClasseEtSonContenu();
        
        // Obtenir la liste des élèves (et uniquement les élèves sans les "trous")
        Eleve[] eleves = classe.getEleves();
        for ( int i = 0; i < eleves.length; i++ ) {
            System.out.println( eleves[ i ] );
        }
    }

}
