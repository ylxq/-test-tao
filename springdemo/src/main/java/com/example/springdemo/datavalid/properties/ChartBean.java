package com.example.springdemo.datavalid.properties;

import javax.swing.JPanel;
import static javax.swing.border.TitledBorder.CENTER;

public class ChartBean extends JPanel {
    private int titlePosition = CENTER;
    private boolean inverse;


    public int getTitlePosition() {
        return titlePosition;
    }

    public void setTitlePosition(int titlePosition) {
        this.titlePosition = titlePosition;
    }

    public boolean isInverse() {
        return inverse;
    }

    public void setInverse(boolean inverse) {
        this.inverse = inverse;
    }
}
