package game;

import handler.ChoiceHandler;
import handler.TitleScreenHandler;
import screen.BattleScreenElementFactory;
import screen.EnumGameScreen;
import screen.ScreenElementFactory;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class GameWindow implements Window {
    private GameElementFactory factory = new ConcreteGameElementFactory();
    private ScreenElementFactory battleScreenFactory = new BattleScreenElementFactory();
    private JFrame window;
    private Container con;
    private JPanel titleNamePanel;
    private JPanel startButtonPanel;
    private JPanel mainTextPanel;
    private JPanel choiceButtonPanel;
    private JPanel playerPanel;
    private JLabel titleNameLabel;
    private JLabel hpLabel;
    private JLabel lvLabel;
    private JLabel lvLabelNumber;
    private JLabel hpLabelNumber;
    private JLabel weaponLabel;
    private JLabel weaponLabelName;
    private Font titleFont = new Font("アリアル", Font.PLAIN, 70);
    private Font normalFont = new Font("アリアル", Font.PLAIN, 25);
    private JButton startButton;
    private JButton choice1;
    private JButton choice2;
    private JButton choice3;
    private JButton choice4;
    private JTextArea mainTextArea;
    private int playerHp;
    private int playerLv;
    private int playerExp;
    private int monsterHp;
    private int monsterExp;
    private int goblinAttack;
    private String weaponName;
    private int weaponKnife;
    private int weaponLongSword;
    private String position;
    private TitleScreenHandler tsHandler = new TitleScreenHandler(this);
    private ChoiceHandler cHandler = new ChoiceHandler(this);
    private EnumGameScreen enumGameStart = EnumGameScreen.getById(1);
    private EnumGameScreen enumGameBattle = EnumGameScreen.getById(2);
    private EnumGameScreen enumGameGameOver = EnumGameScreen.getById(3);
    private List<String> monsterName = List.of("ゴブリン", "スライム", "オーク", "ドラゴン");
    private Random random = new Random();
    private int monsterNum = random.nextInt(4);

    @Override
    public void frame() {

        // ウィンドウ作成
        window = factory.createFrame();
        con = window.getContentPane();

        // タイトルパネル作成
        titleNamePanel = factory.createPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);

        // タイトルラベル作成
        titleNameLabel = new JLabel("テキストRPG");
        titleNameLabel.setBackground(Color.black);
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        // スタートボタンパネル作成
        startButtonPanel = factory.createPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);

        // スタートボタン作成
        startButton = new JButton(enumGameStart.getJButton());
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(tsHandler);

        titleNamePanel.add(titleNameLabel);

        // startButtonをstartButtonPanelの上に配置
        startButtonPanel.add(startButton);

        // titleNamePanelをContainerの上に配置
        con.add(titleNamePanel);

        // startButtonPanelをContainerの上に配置
        con.add(startButtonPanel);
    }

    @Override
    public void createGameScreen() {

        // 2つのパネルを無効にする
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = factory.createPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        con.add(mainTextPanel);

        mainTextArea = factory.createTextArea("これはメインのテキストエリア。");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setFont(normalFont);

        // テキストエリアの範囲外に飛び出ないように
        // 自動ロックされており,自動的にテキストが左に表示される
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = factory.createPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);

        // row 行　col 列
        // カスタマイズされたレイアウトを設定
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);

        choice1 = factory.createButton("選択 1");
        choice1.setFont(normalFont);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");

        // choice1をchoiceButtonPanelの上に配置
        choiceButtonPanel.add(choice1);

        choice2 = factory.createButton("選択 2");
        choice2.setFont(normalFont);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");

        // choice2をchoiceButtonPanelの上に配置
        choiceButtonPanel.add(choice2);

        choice3 = factory.createButton("選択 3");
        choice3.setFont(normalFont);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");

        // choice3をchoiceButtonPanelの上に配置
        choiceButtonPanel.add(choice3);

        choice4 = factory.createButton("選択 4");
        choice4.setFont(normalFont);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");

        // choice4をchoiceButtonPanelの上に配置
        choiceButtonPanel.add(choice4);

        createPlayerPanel();
    }

    @Override
    public void createPlayerPanel() {
        playerPanel = factory.createPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setLayout(new GridLayout(1, 4));
        playerPanel.setBackground(Color.black);
        con.add(playerPanel);
        createHPLabel();
    }

    @Override
    public void createHPLabel() {
        hpLabel = battleScreenFactory.createHPlabelText("HP:");
        hpLabel.setFont(normalFont);
        playerPanel.add(hpLabel);

        hpLabelNumber = battleScreenFactory.createHPlabelNumber();
        hpLabelNumber.setFont(normalFont);
        playerPanel.add(hpLabelNumber);

        lvLabel = battleScreenFactory.createLVlabelText("LV:");
        lvLabel.setFont(normalFont);
        playerPanel.add(lvLabel);

        lvLabelNumber = battleScreenFactory.createLVlabelNumber();
        lvLabelNumber.setFont(normalFont);
        playerPanel.add(lvLabelNumber);

        weaponLabel = battleScreenFactory.createWEAPONlabelText("武器:");
        weaponLabel.setFont(normalFont);
        playerPanel.add(weaponLabel);

        weaponLabelName = battleScreenFactory.createWEAPONlabelName();
        weaponLabelName.setFont(normalFont);
        playerPanel.add(weaponLabelName);

        playerSetUp();
    }

    @Override
    public void playerSetUp() {
        playerHp = 15;
        playerExp = 10;
        playerLv = 1;
        weaponName = "ナイフ";
        weaponKnife = 3;
        weaponLongSword = 5;
        hpLabelNumber.setText("" + playerHp * playerLv);
        lvLabelNumber.setText("" + playerLv);
        weaponLabelName.setText(weaponName);

        townGate();
    }

    @Override
    public void townGate() {
        position = "町の門";
        mainTextArea.setText("あなたは町の門の前にいる。\nあなたの前に門番が立っている。\n\nどうしますか？");

        choice1.setText("門番に話しかける");
        choice2.setText("門番を攻撃する");
        choice3.setText("立ち去る");
        choice4.setText("");

    }

    @Override
    public void talkGuard() {
        position = "門番に話す";
        mainTextArea.setText("門番：こんにちは、見知らぬ人。\n私はあなたの顔を見たことがない。\n申し訳ないが、見知らぬ人を町に入れることはできない。");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    @Override
    public void attackGuard() {
        position = "門番に攻撃";
        mainTextArea.setText("門番：おい、バカなことを言うな。\n門番は反撃し、プレイヤーを攻撃した。\n(あなたは3ダメージを受けた。)");
        playerHp = playerHp - 3;
        if (playerHp < 0) {
            playerHp = 0;
        }
        hpLabelNumber.setText("" + playerHp);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

  　@Override
    public void crossRoad() {
        position = "分かれ道";
        mainTextArea.setText("ここからは分かれ道になっている。\n 南に行けば、町に戻れる。");
        choice1.setText("北へ進む");
        choice2.setText("東へ進む");
        choice3.setText("南へ進む");
        choice4.setText("西へ進む");
    }

    @Override
    public void north() {
        int recovery = random.nextInt(5) + 1;
        position = "北";
        mainTextArea.setText("川がある。\n水を飲み、川辺で休んだ。\n\nプレイヤーのHPが" + recovery + " 回復した。");
        playerHp = playerHp + recovery;
        if (playerHp >= 20) {
            playerHp = 20;
        }
        hpLabelNumber.setText("" + playerHp);
        choice1.setText("南へ進む");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    @Override
    public void east() {
        position = "東";
        int weaponDrop = random.nextInt(3) + 1;
        if (weaponDrop == 3) {
            mainTextArea.setText("森に入り、ロングソードを見つける。\n\nロングソードを手に入れた");
            weaponName = "ロングソード";
            weaponLabelName.setText(weaponName);
        } else {
            mainTextArea.setText("森に入り,何も見つからなかった");
        }
        choice1.setText("西へ進む");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    @Override
    public void west() {
        random = new Random();
        monsterNum = random.nextInt(4);
        position = "西";
        monsterHp = 20;
        monsterExp = 10;
        mainTextArea.setText(monsterName.get(monsterNum) + "に遭遇した");
        choice1.setText("たたかう");
        choice2.setText("逃げる");
        choice3.setText("");
        choice4.setText("");
    }

    @Override
    public void fight() {
        position = "たたかう";
        mainTextArea.setText(monsterName.get(monsterNum) + " HP : " + monsterHp * playerLv + "\n\n 何をする？");
        choice1.setText("攻撃");
        choice2.setText("逃げる");
        choice3.setText("");
        choice4.setText("");
    }

    @Override
    public void playerAttack() {
        position = "プレイヤーの攻撃";
        int playerDamage = 0;
        if (weaponName.equals("ナイフ")) {
            playerDamage = random.nextInt(weaponKnife * playerLv) + 1;
        } else if (weaponName.equals("ロングソード")) {
            playerDamage = random.nextInt(weaponLongSword * playerLv) + 1;
        }
        mainTextArea.setText(monsterName.get(monsterNum) + "を攻撃し、" + playerDamage + "ダメージを与えた。");
        monsterHp = monsterHp - playerDamage;
        choice1.setText(enumGameBattle.getJButton());
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    @Override
    public void monsterAttack() {
        position = monsterName.get(monsterNum) + "の攻撃";
        goblinAttack = 3;
        int monsterDamage = 0;
        monsterDamage = random.nextInt(goblinAttack * playerLv) + 1;
        mainTextArea.setText(monsterName.get(monsterNum) + "はプレイヤーに" + monsterDamage + "ダメージ与えた");
        playerHp = playerHp - monsterDamage;
        if (playerHp <= 0) {
            playerHp = 0;
        }
        hpLabelNumber.setText("" + playerHp);
        choice1.setText(enumGameBattle.getJButton());
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    @Override
    public void win() {
        playerExp = playerExp + monsterExp;
        playerLv = playerExp / monsterExp;
        position = "勝ち";
        mainTextArea.setText("プレイヤーは" + monsterName.get(monsterNum) + "を倒しました" + monsterExp + "経験値を入手しました。\n" +
                "プレイヤーのレベルが" + playerLv + "なりました。");
        playerHp += playerLv;
        lvLabelNumber.setText("" + playerLv);
        hpLabelNumber.setText("" + playerHp);
        choice1.setText("東");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    @Override
    public void lose() {
        playerHp = 1;
        hpLabelNumber.setText("" + playerHp);
        position = "負け";
        mainTextArea.setText("プレイヤーは" + monsterName.get(monsterNum) + "に負けました。" + enumGameGameOver.getJButton());
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }


    public String getPosition() {
        return position;
    }

    public int getPlayerHp() {
        return playerHp;
    }

    public int getMonsterHp() {
        return monsterHp;
    }
}
