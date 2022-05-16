package com.company.classes.characters;

import com.company.Constants;
import com.company.classes.AttackType;
import com.company.classes.CharacterClass;

public class Healer  extends CharacterClass {
    public Healer(String name, int x, int y, int leftKey, int rightKey, int upKey, int downKey, int leftAttackKey, int rightAttackKey) {
        super(name, x, y, leftKey, rightKey, upKey, downKey, leftAttackKey, rightAttackKey);
        this.setLevel(1);
        this.setMaxHealthPoints(1000);
        this.setHealthPoints(1000);
        this.setManaPoints(200);
        this.setMaxManaPoints(200);
        this.setAttackType(AttackType.PHYSICAL);
        this.setAttackAmount(5);
        this.setName(name);

        this.setX(0);
        this.setY(300);
        this.uploadImage();
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
            }
            restoreHealth(Constants.HEALTH_RESTORE);
        }
    }
    public void rightAttack(CharacterClass[] players) {
        if (this.getX() < Constants.MAX_RIGHT_POSITION) {
            int neighbourId = CharacterClass.occupiedCells[this.getX() + Constants.CHARACTER_IMG_WIDTH][this.getY()];
            if (neighbourId > 0) {
                this.attack(players[neighbourId - 1]);
            }
            restoreHealth(Constants.HEALTH_RESTORE);
        }
    }
}