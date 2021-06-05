package com.example.design.build.createor;

public class People {

    private Eye eye;
    private Hair hair;
    private Mouse mouse;

    public Eye getEye() {
        return eye;
    }

    public void setEye(Eye eye) {
        this.eye = eye;
    }

    public Hair getHair() {
        return hair;
    }

    public void setHair(Hair hair) {
        this.hair = hair;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    public String toString() {
        return "People{" +
                "eye=" + eye +
                ", hair=" + hair +
                ", mouse=" + mouse +
                '}';
    }
}
