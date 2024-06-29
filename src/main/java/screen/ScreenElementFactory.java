package screen;

import javax.swing.*;

public abstract class ScreenElementFactory {

    public abstract JLabel createHPlabelText(String text);

    public abstract JLabel createHPlabelNumber();

    public abstract JLabel createLVlabelText(String text);

    public abstract JLabel createLVlabelNumber();

    public abstract JLabel createWEAPONlabelText(String text);

    public abstract JLabel createWEAPONlabelName();
}
