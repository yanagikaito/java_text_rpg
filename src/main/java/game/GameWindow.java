package game;

import handler.ChoiceHandler;
import handler.TitleScreenHandler;

import javax.swing.*;
import java.awt.*;

public class GameWindow implements Window {
    JFrame window;
    Container con;
    JPanel titleNamePanel;
    JPanel startButtonPanel;
    JPanel mainTextPanel;
    JPanel choiceButtonPanel;
    JPanel playerPanel;
    JLabel titleNameLabel;
    JLabel hpLabel;
    JLabel hpLabelNumber;
    JLabel weaponLabel;
    JLabel weaponLabelName;
    Font titleFont = new Font("アリアル", Font.PLAIN, 70);
    Font normalFont = new Font("アリアル", Font.PLAIN, 25);
    JButton startButton;
    JButton choice1;
    JButton choice2;
    JButton choice3;
    JButton choice4;
    JTextArea mainTextArea;
    int playerHp;
    String weapon;
    private String position;
    TitleScreenHandler tsHandler = new TitleScreenHandler(this);
    ChoiceHandler cHandler = new ChoiceHandler(this);

    @Override
    public void frame() {

        // ウィンドウ作成
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);

        // JFrameのデフォルトのレイアウトを無効
        window.setLayout(null);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        con = window.getContentPane();

        // タイトルパネル作成
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);

        // タイトルラベル作成
        titleNameLabel = new JLabel("テキストRPG");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        // スタートボタンパネル作成
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        // スタートボタン作成
        startButton = new JButton("スタート");

        // ボタン自体の色
        startButton.setBackground(Color.black);

        // ボタンテキストの色
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        // スタートボタンの枠が消える
        startButton.setFocusPainted(false);

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

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("これはメインのテキストエリア。");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);

        // テキストエリアの範囲外に飛び出ないように
        // 自動ロックされており,自動的にテキストが左に表示される
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);

        // row 行　col 列
        // カスタマイズされたレイアウトを設定
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("選択 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");

        // choice1をchoiceButtonPanelの上に配置
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("選択 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");

        // choice2をchoiceButtonPanelの上に配置
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("選択 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");

        // choice3をchoiceButtonPanelの上に配置
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("選択 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");

        // choice4をchoiceButtonPanelの上に配置
        choiceButtonPanel.add(choice4);

        createPlayerPanel();
    }

    @Override
    public void createPlayerPanel() {
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setLayout(new GridLayout(1, 4));
        playerPanel.setBackground(Color.black);
        con.add(playerPanel);
        createHPLabel();
    }

    @Override
    public void createHPLabel() {
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("武器:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetUp();
    }

    @Override
    public void playerSetUp() {
        playerHp = 15;
        weapon = "ナイフ";
        hpLabelNumber.setText("" + playerHp);
        weaponLabelName.setText(weapon);

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
        choice2.setText("門番を攻撃する");
        choice3.setText("立ち去る");
        choice4.setText("");
    }

    public String getPosition() {
        return position;
    }
}
