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
                    case "c1" -> {
                        if (gameWindow.getExcalibur() == 1) {
                            gameWindow.ending();
                        } else {
                            gameWindow.talkGuard();
                        }
                    }
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
                    case "c4" -> gameWindow.west();
                }
            }
            case "北", "東", "勝ち", "負け" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.crossRoad();
                }
            }
            case "西" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.fight();
                    case "c2" -> gameWindow.crossRoad();
                }
            }
            case "たたかう" -> {
                switch (yourChoice) {
                    case "c1" -> gameWindow.playerAttack();
                    case "c2" -> gameWindow.crossRoad();
                }
            }
            case "プレイヤーの攻撃" -> {
                switch (yourChoice) {
                    case "c1" -> {
                        if (gameWindow.getMonsterHp() < 1) {
                            gameWindow.win();
                        } else {
                            gameWindow.monsterAttack();
                        }
                    }
                }
            }
            case "ゴブリンの攻撃", "スライムの攻撃", "ドラゴンの攻撃", "オークの攻撃" -> {
                switch (yourChoice) {
                    case "c1" -> {
                        if (gameWindow.getPlayerHp() < 1) {
                            gameWindow.lose();
                        } else {
                            gameWindow.fight();
                        }
                    }
                }
            }
        }
    }
}


