package game;

public interface Window {

    void frame();

    void createGameScreen();

    void createPlayerPanel();

    void createHPLabel();

    void playerSetUp();

    void playerAttack();

    int monsterSetUp();

    void townGate();

    void talkGuard();

    void attackGuard();

    void crossRoad();

    void north();

    void east();

    void west();

    void fight();
}
