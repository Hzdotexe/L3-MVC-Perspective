package controller.action;

import controller.command.SaveCommand;
import view.Fenetre;
import java.awt.event.ActionEvent;

public class SaveAction extends PerspectiveAbstractAction{
    public SaveAction(Fenetre view, String text, String description, Integer mnemonic) {
        super(view, text, description, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PerspectiveAbstractAction.COMMAND_MANAGER.execute(new SaveCommand(view));
    }
}
