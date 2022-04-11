package com.company.classes;

import com.company.Constants;

import javax.swing.*;
import java.awt.*;

public class MonsterClass {
    public static int[][] occupiedCells = new int[Constants.WINDOW_WIDTH][Constants.WINDOW_HEIGHT];
    private static int MonsterCount = 0;
    private int healthPoints = 200;
    private int manaPoints;
    private int level;
    private AttackType attackType;
    private int attackAmount;
    private int id;
    protected String name, monsterClass;
    private int maxHealthPoints;
    private int x,y;

    public MonsterClass( int x, int y){
        this.id = ++MonsterCount;
        occupiedCells[x][y] = this.id;
        this.name = name;
        this.x = x;
        this.y = y;
        uploadImage();

    }

    private Image image, baseImage, attackLeftImage, attackRightImage;

    public void setImage(Image image) {
        this.image = image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void uploadImage() {
        String baseImage = Constants.IMG_FOLDER + "/ghoul/base.png";
        String attackLeftImage = Constants.IMG_FOLDER + this.monsterClass + "/left.png";
        String attackRightImage = Constants.IMG_FOLDER + this.monsterClass + "/right.png";
        this.baseImage = new ImageIcon(baseImage).getImage();
        this.attackLeftImage = new ImageIcon(attackLeftImage).getImage();
        this.attackRightImage = new ImageIcon(attackRightImage).getImage();
        setBaseImage();
    }

    public void setBaseImage() {
        this.image = this.baseImage;
    }

    public void setAttackLeftImage() {
        this.image = this.attackLeftImage;
    }

    public void setAttackRightImage() {
        this.image = this.attackRightImage;
    }
}
