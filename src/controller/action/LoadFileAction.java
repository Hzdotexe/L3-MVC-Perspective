package controller.action;

import controller.command.LoadFileCommand;
import view.Fenetre;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoadFileAction extends PerspectiveAbstractAction {

    public LoadFileAction(Fenetre view, String text, Icon icon, String description, Integer mnemonic) {
        super(view, text, icon, description, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PerspectiveAbstractAction.cm.execute(new LoadFileCommand(view));
    }
}
