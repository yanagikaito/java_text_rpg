package screen;


public enum EnumGameScreen {
    START("スタート", 1),
    BATTLE(">", 2),
    GAMEOVER("\n\nGAME OVER", 3);

    private String text;
    private int id;

    EnumGameScreen(String text, int id) {
        this.text = text;
        this.id = id;
    }

    public static EnumGameScreen getById(int id) {
        for (EnumGameScreen screen : EnumGameScreen.values()) {
            if (screen.getId() == id) {
                return screen;
            }
        }
        return null;
    }

    public String getJButton() {
        return text;
    }

    public int getId() {
        return id;
    }
}
