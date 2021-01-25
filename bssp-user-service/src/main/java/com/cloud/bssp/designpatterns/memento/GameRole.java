package com.cloud.bssp.designpatterns.memento;

/**
 * 游戏角色
 * @date: 2021/1/18
 * @author weirx
 * @version 3.0
 */
public class GameRole {

    /**
     * 攻击力
     */
    private Long atk;

    /**
     * 防御力
     */
    private Long defense;

    /**
     * 生命值
     */
    private Long hp;


    public GameRole(Long atk, Long defense, Long hp) {
        this.atk = atk;
        this.defense = defense;
        this.hp = hp;
    }

    public GameRole() {
    }

    public void state() {
        System.out.println("--------当前角色信息--------");
        System.out.println("攻击力：" + this.atk);
        System.out.println("防御力：" + this.defense);
        System.out.println("血量：" + this.defense);
    }

    public void getInstance() {
        this.atk = 1000L;
        this.defense = 800L;
        this.hp = 10000L;
    }

    public void fight() {
        this.atk = 0L;
        this.defense = 0L;
        this.hp = 0L;
    }

    public Memento save() {
        return new Memento(this.atk, this.defense, this.hp);
    }

    public void read(Memento memento) {
        this.atk = memento.getAtk();
        this.defense = memento.getDefense();
        this.hp = memento.getHp();
    }

    public Long getAtk() {
        return atk;
    }

    public void setAtk(Long atk) {
        this.atk = atk;
    }

    public Long getDefense() {
        return defense;
    }

    public void setDefense(Long defense) {
        this.defense = defense;
    }

    public Long getHp() {
        return hp;
    }

    public void setHp(Long hp) {
        this.hp = hp;
    }
}
