package com.kantai_wiki.kcw_mobile.model;

/**
 * Created by Wafer on 2015/8/29.
 */
public class Expedition {

    //Data
    private int id;
    private String name;
    private String flagship_lv;
    private String time;
    private String consume_fuel;
    private String consume_bullet;
    private String teitoku_exp;
    private String kanmusu_exp;
    private String reward_fuel;
    private String reward_bullet;
    private String reward_steel;
    private String reward_alum;
    private String reward_bucket;
    private String reward_lighter;
    private String reward_material;
    private String reward_furniture_box;
    private String fleet_condition;
    private String notice;

    //getter and setter


    public String getTeitoku_exp() {
        return teitoku_exp;
    }

    public void setTeitoku_exp(String teitoku_exp) {
        this.teitoku_exp = teitoku_exp;
    }

    public String getKanmusu_exp() {
        return kanmusu_exp;
    }

    public void setKanmusu_exp(String kanmusu_exp) {
        this.kanmusu_exp = kanmusu_exp;
    }

    //#id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //#name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //#flagship_lv
    public String getFlagship_lv() {
        return flagship_lv;
    }

    public void setFlagship_lv(String flagship_lv) {
        this.flagship_lv = flagship_lv;
    }

    //#time

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    //#consume


    public String getConsume_fuel() {
        return consume_fuel;
    }

    public void setConsume_fuel(String consume_fuel) {
        this.consume_fuel = consume_fuel;
    }

    public String getConsume_bullet() {
        return consume_bullet;
    }

    public void setConsume_bullet(String consume_bullet) {
        this.consume_bullet = consume_bullet;
    }

    //#reward


    public String getReward_fuel() {
        return reward_fuel;
    }

    public void setReward_fuel(String reward_fuel) {
        this.reward_fuel = reward_fuel;
    }

    public String getReward_bullet() {
        return reward_bullet;
    }

    public void setReward_bullet(String reward_bullet) {
        this.reward_bullet = reward_bullet;
    }

    public String getReward_steel() {
        return reward_steel;
    }

    public void setReward_steel(String reward_steel) {
        this.reward_steel = reward_steel;
    }

    public String getReward_alum() {
        return reward_alum;
    }

    public void setReward_alum(String reward_alum) {
        this.reward_alum = reward_alum;
    }

    public String getReward_bucket() {
        return reward_bucket;
    }

    public void setReward_bucket(String reward_bucket) {
        this.reward_bucket = reward_bucket;
    }

    public String getReward_lighter() {
        return reward_lighter;
    }

    public void setReward_lighter(String reward_lighter) {
        this.reward_lighter = reward_lighter;
    }

    public String getReward_material() {
        return reward_material;
    }

    public void setReward_material(String reward_material) {
        this.reward_material = reward_material;
    }

    public String getReward_furniture_box() {
        return reward_furniture_box;
    }

    public void setReward_furniture_box(String reward_furniture_box) {
        this.reward_furniture_box = reward_furniture_box;
    }

    //#fleet_condition

    public String getFleet_condition() {
        return fleet_condition;
    }

    public void setFleet_condition(String fleet_condition) {
        this.fleet_condition = fleet_condition;
    }

    //#notice

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
