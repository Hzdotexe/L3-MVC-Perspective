package controller.action;

import controller.command.LoadImageCommand;
import view.Fenetre;
import java.awt.event.ActionEvent;

public class LoadImageAction extends PerspectiveAbstractAction {
    public LoadImageAction(Fenetre view, String text, String description, Integer mnemonic) {
        super(view,  text, description, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PerspectiveAbstractAction.COMMAND_MANAGER.execute(new LoadImageCommand(view));
    }
}
