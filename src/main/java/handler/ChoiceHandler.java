package handler;

import game.GameWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceHandler implements ActionListener {

    GameWindow gameWindow;

    public ChoiceHandler(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // 選択されたボタンのコマンドの文字列がこの変数に入る
        String yourChoice = e.getActionCommand();

        switch (yourChoice) {
            case "c1":
                gameWindow.talkGuard();
                break;
            case "c2":
                break;
            case "c3":
                break;
            case "c4":
                break;
        }
    }
}
