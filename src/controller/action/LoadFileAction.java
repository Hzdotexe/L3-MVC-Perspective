package controller.action;

import controller.command.LoadFileCommand;
import view.Fenetre;
import java.awt.event.ActionEvent;

public class LoadFileAction extends PerspectiveAbstractAction {
    public LoadFileAction(Fenetre view, String text, String description, Integer mnemonic) {
        super(view, text, description, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PerspectiveAbstractAction.COMMAND_MANAGER.execute(new LoadFileCommand(view));
    }
}
