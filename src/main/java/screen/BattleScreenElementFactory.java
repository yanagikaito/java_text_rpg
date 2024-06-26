package screen;

import javax.swing.*;
import java.awt.*;

public class BattleScreenElementFactory extends ScreenElementFactory {

    @Override
    public JLabel createHPlabelText(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.white);
        return label;
    }

    @Override
    public JLabel createHPlabelNumber() {
        JLabel label = new JLabel();
        label.setForeground(Color.white);
        return label;
    }

    @Override
    public JLabel createLVlabelText(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.white);
        return label;
    }

    @Override
    public JLabel createLVlabelNumber() {
        JLabel label = new JLabel();
        label.setForeground(Color.white);
        return label;
    }

    @Override
    public JLabel createWEAPONlabelText(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.white);
        return label;
    }

    @Override
    public JLabel createWEAPONlabelName() {
        JLabel label = new JLabel();
        label.setForeground(Color.white);
        return label;
    }
}
