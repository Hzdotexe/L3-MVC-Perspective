package controller.singleton;

import controller.command.Command;
import controller.command.Redo;
import controller.command.Undo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;

public class CommandManager {

    private final static CommandManager manager = new CommandManager();
    private LinkedList<Command> history = new LinkedList<>();
    private LinkedList<Command> toRedo = new LinkedList<>();
    private boolean undoStatus;
    private boolean redoStatus;
    private final PropertyChangeSupport properties = new PropertyChangeSupport(this);

    // Singleton's constructor
    private CommandManager() {
    }

    public static CommandManager getInstance() {
        return manager;
    }

    public boolean canUndo() {
        return history.size() > 0;
    }

    public boolean canRedo() {
        return toRedo.size() > 0;
    }

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

    /*
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

    /*
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        properties.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        properties.removePropertyChangeListener(listener);
    }
}
