package com.kantai_wiki.kcw_mobile.model;

/**
 * Created by Wafer on 2015/8/29.
 */
public class Quest {

    //Data
    private String category;
    private String type;
    private String id;
    private String prequest_id;
    private String name;
    private String reward_fuel;
    private String reward_bullet;
    private String reward_steel;
    private String reward_alum;
    private String reward_other;
    private String condition;
    private String notice;

    //getter and setter

    //#category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //#type

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //#id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //#prquest_id

    public String getPrequest_id() {
        return prequest_id;
    }

    public void setPrequest_id(String prequest_id) {
        this.prequest_id = prequest_id;
    }

    //#name

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getReward_other() {
        return reward_other;
    }

    public void setReward_other(String reward_other) {
        this.reward_other = reward_other;
    }

    //#condition

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    //#notice

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
