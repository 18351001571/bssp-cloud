package com.cloud.bssp.designpatterns.memento;

/**
 * 存档备忘录
 * @date: 2021/1/18
 * @author weirx
 * @version 3.0
 */
public class Memento {

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

    public Memento(Long atk, Long defense, Long hp) {
        this.atk = atk;
        this.defense = defense;
        this.hp = hp;
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
