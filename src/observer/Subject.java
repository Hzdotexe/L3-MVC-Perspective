/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s:  Anyin Zhang, Isaac David Zolana,
                Hanz Sami, Fatsy Ramampiarison,
                Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: Subject.java
 Date créé: 2021-11-22
 *******************************************************/
package observer;

/**
 * Implementation du patron Observer pour implementer les functionalities "addObserver" et "notifyObservers"
 * Ajouter les observers et faire la mise à jour
 */
public interface Subject {
    void addObserver(Observer observer);
    void notifyObservers();
}
