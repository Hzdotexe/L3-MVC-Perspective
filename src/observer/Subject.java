package observer;

/**
 * Implementation du patron Observer pour implementer les functionalities "addObserver" et "notifyObservers"
 * Ajouter les observers et faire la mise à jour
 */
public interface Subject {
    void addObserver(Observer observer);
    void notifyObservers();
}
