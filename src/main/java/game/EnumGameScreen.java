package game;


public enum EnumGameScreen {
    START("スタート", 1),
    BATTLE(">", 2);

    private String button;
    private int id;

    EnumGameScreen(String button, int id) {
        this.button = button;
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
        return button;
    }

    public int getId() {
        return id;
    }
}
