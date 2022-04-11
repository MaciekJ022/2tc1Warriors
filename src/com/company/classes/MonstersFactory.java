package com.company.classes;

import com.company.GameField;

import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

public class MonstersFactory extends TimerTask {
    private ArrayList<MonsterClass> monsters;
    private GameField gameField;

    public MonstersFactory(ArrayList<MonsterClass> monsters, GameField gameField) {
        this.monsters = monsters;
        this.gameField = gameField;
    }

    @Override
    public void run() {
        /*int range = (10 - 1) + 1;
        int x = (int)(Math.random() * (40 * range)) , y=(int)(Math.random() * (80 * range));*/
        int x, y;
        Random rnd = new Random();
        x = rnd.nextInt(8) * 40;
        y = rnd.nextInt(5) * 80;
        System.out.println(x);
        System.out.println(y);
        this.monsters.add(new MonsterClass( x,y ));
        gameField.repaint();

    }
}
