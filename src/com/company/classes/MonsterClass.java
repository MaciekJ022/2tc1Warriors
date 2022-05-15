package com.company.classes;

import com.company.Constants;

import javax.swing.*;
import java.awt.*;

public class MonsterClass implements BaseClass {
    public static int[][] occupiedCells = new int[Constants.WINDOW_WIDTH][Constants.WINDOW_HEIGHT];
    public static int MonsterCount = 0;
    private int healthPoints = 200;
    private int manaPoints;
    private int level;
    private AttackType attackType;
    private int attackAmount;
    private int id;
    protected String name, monsterClass;
    private int maxHealthPoints;
    private int x,y;

    public MonsterClass(int x, int y){
        this.id = ++MonsterCount;
        occupiedCells[x][y] = this.id;
        this.name = name;
        this.x = x;
        this.y = y;
        uploadImage();

    }

    public void setHealthPoints(int healthPoints) {
        if (healthPoints < 0) {
            this.healthPoints = 0;
        } else if (healthPoints > this.maxHealthPoints) {
            this.healthPoints = this.maxHealthPoints;
        }
        else {
            this.healthPoints = healthPoints;
        }
    }

    public void setLevel(int level) {
        if (level < 1) {
            System.out.println("We can't lose level");
        } else {
            this.level = level;
        }
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    public void setAttackAmount(int attackAmount) {
        this.attackAmount = attackAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public int getLevel() {
        return level;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public int getAttackAmount() {
        return attackAmount;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
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

    public void tryChangePosition(int newX, int newY) {
        if (occupiedCells[newX][newY] == 0) {
            occupiedCells[this.x][this.y] = 0;
            this.x = newX;
            this.y = newY;
            occupiedCells[this.x][this.y] = this.id;
        } else {
            loseHealth(50);
        }
    }

    @Override
    public void attack(CharacterClass p) {

    }

    @Override
    public void restoreHealth(int amount) {

    }

    @Override
    public void loseHealth(int amount) {

    }

    @Override
    public void restoreMana(int amount) {

    }

    @Override
    public void loseMana(int amount) {

    }

    @Override
    public void levelUp() {

    }

    @Override
    public void info() {

    }
}
