package com.company.classes.Monsters;

import com.company.Constants;
import com.company.classes.AttackType;
import com.company.classes.CharacterClass;
import com.company.classes.MonsterClass;

public class Ghoul extends MonsterClass {
    public Ghoul(int x, int y){
        super(x,y);

        this.setAttackType(AttackType.PHYSICAL);
        this.setMaxHealthPoints(1000);
        this.monsterClass = "ghoul";
        this.uploadImage();
        this.setAttackAmount(100);
    }

    @Override
    public void left() { }

    @Override
    public void right() { }

    @Override
    public void up() { }

    @Override
    public void down() { }

    public void leftAttack(CharacterClass[] players) {
        if (this.getX() >= Constants.CHARACTER_IMG_WIDTH) {
            int neighbourId = CharacterClass.occupiedCells[this.getX() - Constants.CHARACTER_IMG_WIDTH][this.getY()];
            if (neighbourId > 0){
                this.attack(players[neighbourId - 1]);
            }
        }
    }
    public void rightAttack(CharacterClass[] players) {
        if (this.getX() < Constants.MAX_RIGHT_POSITION) {
            int neighbourId = CharacterClass.occupiedCells[this.getX() + Constants.CHARACTER_IMG_WIDTH][this.getY()];
            if (neighbourId > 0) {
                this.attack(players[neighbourId - 1]);
            }
        }
    }

    public void followPlayers(){
        boolean follows = false;
    }


}
