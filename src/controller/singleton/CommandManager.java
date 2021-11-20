package controller.singleton;
import java.util.ArrayList;

public class CommandManager {

        private final static CommandManager manager = new CommandManager();
        private final LinkedList history = new LinkedList<PerspectiveCommand>();
        private final ArrayList redoCommands = new ArrayList<PerspectiveCommand>();
        private final ArrayList undoCommands = new ArrayList<PerspectiveCommand>();

        // Constructeur du singleton
        private CommandManager() {};

        public static CommandManager getInstance(){
            return manager;
        };

        public void dispose(){} // TODO

        public void addUndo(PerspectiveCommand command){
        undoCommands.add(0, command);
        }

        public void addRedo(PerspectiveCommand command){
        redoCommands.add(0, command);
        }
}
