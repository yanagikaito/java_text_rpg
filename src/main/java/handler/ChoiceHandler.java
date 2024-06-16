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

        // プレイヤーの現在地
        switch (gameWindow.getPosition()) {
            case "町の門" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.talkGuard();
                    case "c2" -> gameWindow.attackGuard();
                    case "c3" -> gameWindow.crossRoad();
                    case "c4" -> {
                    case "c3", "c4" -> {
                    }
                }
            }
            case "門番に話す", "門番に攻撃" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.townGate();
                }
            }
            case "分かれ道" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.north();
                    case "c2" -> gameWindow.east();
                    case "c3" -> gameWindow.townGate();
                    case "c4" -> {
                    }
                }
            }
            case "北" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.crossRoad();
                }
            }
        }
    }
}


