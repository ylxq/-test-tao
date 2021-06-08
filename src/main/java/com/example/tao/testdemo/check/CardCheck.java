package com.example.tao.testdemo.check;

import java.util.Arrays;

public class CardCheck {

    static String[] add = new String[]{"2", "4", "8", "5", "10", "9", "7", "3", "6", "1"};


    public static void main(String[] args) {
        String card = "";
        String cardNew = getCard(card.substring(0,card.length()-1));
        System.out.println(card);
        System.out.println(cardNew);
        System.out.println(cardNew.equals(card));

    }

    private static String getCard(String card) {
        String[] old = card.split("");
        String[] adds = getAdd(old);

        Integer sum = sum(old, adds);
        Integer mod = sum % 11;
        Integer checkCode = (12 - mod) % 11;

        String cardNew = card;
        if (checkCode == 10) {
            cardNew = card + "X";
        } else {
            cardNew = card + checkCode;
        }
        return cardNew;
    }


    static String[] getAdd(String[] message) {
        String[] addMessage = new String[message.length];
        int j = 0;
        for (int i = message.length - 1; i >= 0; i--) {
            j = j % add.length;
            addMessage[i] = add[j];
            j++;
        }
        return addMessage;
    }

    static Integer sum(String[] a, String[] b) {
        Integer sum = 0;
        for (int i = 0; i < a.length; i++) {
            Integer aa = Integer.valueOf(a[i]);
            Integer bb = Integer.valueOf(b[i]);
            sum += (aa * bb);
        }
        return sum;
    }
}
