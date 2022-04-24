package com.company;

import com.company.classes.CharacterClass;
import com.company.classes.MonsterClass;
import com.company.classes.MonstersFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class GameField extends JPanel {
    private Team team;
    private CharacterClass[] players;
    private ArrayList <MonsterClass> monsters = new ArrayList<>();
    public GameField(Team team) {
        this.team = team;
        this.players = team.getTeamMembers();

        setFocusable(true);
        addKeyListener(new FieldKeyListener());

        MonstersFactory monstersFactory = new MonstersFactory(monsters, this);
        Timer timer = new Timer();
        timer.schedule(monstersFactory, 0, 2000);
//        if(MonsterCount >= 5){
//            timer.cancel();
//        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (CharacterClass player : players) {
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
            g.drawString("" + player.getHealthPoints(), player.getX(), player.getY() + 12);
            g.drawString("∞", player.getX(), player.getY() + 26);
        }

        for (MonsterClass monster : monsters) {
            g.drawImage(monster.getImage(), monster.getX(), monster.getY(), this);
            //g.drawString("" + player.getHealthPoints(), player.getX(), player.getY() + 12);
            //g.drawString("∞", player.getX(), player.getY() + 26);
        }
    }

    public class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            for (CharacterClass player : players) {
                if (key == player.leftKey) {
                    player.left();
                }
                if (key == player.rightKey) {
                    player.right();
                }
                if (key == player.upKey) {
                    player.up();
                }
                if (key == player.downKey) {
                    player.down();
                }
                if (key == player.leftAttackKey) {
                    player.setAttackLeftImage();
                    player.leftAttack(players);


                    //timer
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    player.setBaseImage();
                                    repaint();
                                }
                            }, 200
                    );
                }
                if (key == player.rightAttackKey) {
                    player.setAttackRightImage();
                    player.rightAttack(players);

                    //timer
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    player.setBaseImage();
                                    repaint();
                                }
                            }, 200
                    );
                }
            }
            repaint();
        }
    }
}
