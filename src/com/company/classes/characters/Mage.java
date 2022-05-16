package com.company.classes.characters;

import com.company.Constants;
import com.company.classes.AttackType;
import com.company.classes.CharacterClass;

import java.util.Timer;

public class Mage  extends CharacterClass {
    public Mage(String name, int x, int y, int leftKey, int rightKey, int upKey, int downKey, int leftAttackKey, int rightAttackKey) {
        super(name, x, y, leftKey, rightKey, upKey, downKey, leftAttackKey, rightAttackKey);

        this.setAttackType(AttackType.MAGICAL_RANGED);
        this.setMaxHealthPoints(300);
        this.setManaPoints(300);
        this.playerClass = "mage";
        this.uploadImage();
        this.setAttackAmount(70);
    }
    @Override
    public void left() {
        int newPositionX = this.getX() >= Constants.CHARACTER_IMG_WIDTH ? this.getX() - Constants.CHARACTER_IMG_WIDTH : Constants.MAX_RIGHT_POSITION;
        tryChangePosition(newPositionX, getY());

    }

    @Override
    public void right() {
        int newPositionX = this.getX() < Constants.MAX_RIGHT_POSITION ? this.getX() + Constants.CHARACTER_IMG_WIDTH : 0;
        tryChangePosition(newPositionX, getY());
    }

    @Override
    public void up() {
        int newPositionY = this.getY() < Constants.CHARACTER_IMG_HEIGHT ? Constants.MAX_RIGHT_POSITION : this.getY() - Constants.CHARACTER_IMG_HEIGHT;
        tryChangePosition(getX(), newPositionY);
    }

    @Override
    public void down() {
        int newPositionY = this.getY() < Constants.MAX_RIGHT_POSITION ? this.getY() + Constants.CHARACTER_IMG_HEIGHT : 0;
        tryChangePosition(getX(), newPositionY);
    }

    public void ManaRegen(){
        while (1 > 0){
            restoreMana(1);
        }
    }

    public void leftAttack(CharacterClass[] players) {
        if (this.getX() >= Constants.CHARACTER_IMG_WIDTH) {
            int neighbourId = CharacterClass.occupiedCells[this.getX() - Constants.CHARACTER_IMG_WIDTH][this.getY()];
            if (neighbourId > 0){
                this.attack(players[neighbourId - 1]);
            } else {
                neighbourId = CharacterClass.occupiedCells[this.getX() - Constants.CHARACTER_IMG_WIDTH * 2][this.getY()];
                this.attack(players[neighbourId - 1]);
            }
            loseMana(Constants.MANA_COST);
        }
    }
    public void rightAttack(CharacterClass[] players) {
        if (this.getX() < Constants.MAX_RIGHT_POSITION) {
            int neighbourId = CharacterClass.occupiedCells[this.getX() + Constants.CHARACTER_IMG_WIDTH][this.getY()];
            if (neighbourId > 0){
                this.attack(players[neighbourId - 1]);
            } else {
                neighbourId = CharacterClass.occupiedCells[this.getX() + Constants.CHARACTER_IMG_WIDTH * 2][this.getY()];
                this.attack(players[neighbourId - 1]);
            }
            loseMana(Constants.MANA_COST);
        }
    }
}
