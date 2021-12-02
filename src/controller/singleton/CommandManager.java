package controller.singleton;

import controller.command.Command;
import controller.command.Redo;
import controller.command.Undo;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;

/**
 * CommandInvoker
 * Implementation du patron Command pour implementer les fonctionalites "do" et "undo"
 */
public class CommandManager {
    private final static CommandManager COMMAND_MANAGER = new CommandManager();
    private LinkedList<Command> history = new LinkedList<>();
    private LinkedList<Command> toRedo = new LinkedList<>();
    private boolean undoStatus;
    private boolean redoStatus;
    private final PropertyChangeSupport properties = new PropertyChangeSupport(this);

    // Singleton's constructor
    private CommandManager() {}

    public static CommandManager getInstance() {
        return COMMAND_MANAGER;
    }

    /**
     * Vérifier si c'est possible de faire Undo
     */
    public boolean canUndo() {
        return history.size() > 0;
    }

    /**
     * Vérifier si c'est possible de faire Redo
     */
    public boolean canRedo() {
        return toRedo.size() > 0;
    }

    /**
     * Faire le command
     * @param command La commande à exécuter
     */
    public void execute(Command command) {
        undoStatus = canUndo();
        redoStatus = canRedo();

        if (command instanceof Undo) {
            undo();
        } else if (command instanceof Redo) {
            redo();
        } else {
            if (command.execute()) {
                history.addFirst(command);
            } else {
                history.clear();
            }
            toRedo.clear();
        }

        if (undoStatus ^ canUndo() || redoStatus ^ canRedo()) {
            properties.firePropertyChange(null, null, null);
        }
    }

    /**
     * Undo the recent command
     */
    private void undo() {
        if (history.size() > 0) {
            Command commandToUndo;
            commandToUndo = history.removeFirst();
            commandToUndo.undo();
            toRedo.addFirst(commandToUndo);
        }
    }

    /**
     * Redo the last command which was defeated
     */
    private void redo() {
        if (toRedo.size() > 0) {
            Command commandToRedo;
            commandToRedo = toRedo.removeFirst();
            commandToRedo.redo();
            history.addFirst(commandToRedo);
        }
    }

    /**
     * Ajouter l'action de command
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        properties.addPropertyChangeListener(listener);
    }

    /**
     * Supprimer l'action de command
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        properties.removePropertyChangeListener(listener);
    }
}
