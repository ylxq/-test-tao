package com.example.design.build.createor;

public class Direct {

    private Builer builer;

    public Direct(Builer builer) {
        this.builer = builer;
    }

    public People consturt() {
        builer.buildHair();
        builer.buildEye();
        builer.buildMouse();
        return builer.getResult();
    }

    public static void main(String[] args) {
        Builer peopleBuiler = new WestPeopleBuilder();
        Direct peopleDirect = new Direct(peopleBuiler);
        System.out.println(peopleDirect.consturt());

    }
}
