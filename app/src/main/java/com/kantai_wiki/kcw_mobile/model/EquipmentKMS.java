package com.kantai_wiki.kcw_mobile.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wafer on 2015/8/29.
 */
public class EquipmentKMS {

    //Data
    private int id;
    private String rare_rate;
    private String name;
    private String category;
    private String value_firepower;
    private String value_torpedo;
    private String value_explosion;
    private String value_antiaircraft;
    private String value_antisubmarine;
    private String value_tracking;
    private String value_accuracy;
    private String value_evasion;
    private String range;
    private List<String> equippable;
    private String notice;

    //getter and setter

    //#id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //#rare_rate

    public String getRare_rate() {
        return rare_rate;
    }

    public void setRare_rate(String rare_rate) {
        this.rare_rate = rare_rate;
    }

    //#name

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //#category

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //#value

    public String getValue_firepower() {
        return value_firepower;
    }

    public void setValue_firepower(String value_firepower) {
        this.value_firepower = value_firepower;
    }

    public String getValue_torpedo() {
        return value_torpedo;
    }

    public void setValue_torpedo(String value_torpedo) {
        this.value_torpedo = value_torpedo;
    }

    public String getValue_explosion() {
        return value_explosion;
    }

    public void setValue_explosion(String value_explosion) {
        this.value_explosion = value_explosion;
    }

    public String getValue_antiaircraft() {
        return value_antiaircraft;
    }

    public void setValue_antiaircraft(String value_antiaircraft) {
        this.value_antiaircraft = value_antiaircraft;
    }

    public String getValue_antisubmarine() {
        return value_antisubmarine;
    }

    public void setValue_antisubmarine(String value_antisubmarine) {
        this.value_antisubmarine = value_antisubmarine;
    }

    public String getValue_tracking() {
        return value_tracking;
    }

    public void setValue_tracking(String value_tracking) {
        this.value_tracking = value_tracking;
    }

    public String getValue_accuracy() {
        return value_accuracy;
    }

    public void setValue_accuracy(String value_accuracy) {
        this.value_accuracy = value_accuracy;
    }

    public String getValue_evasion() {
        return value_evasion;
    }

    public void setValue_evasion(String value_evasion) {
        this.value_evasion = value_evasion;
    }

    //#range
    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    //#equippable
    public List<String> getEquippable() {
        return equippable;
    }

    public void setEquippable(List<String> equippable) {
        this.equippable = equippable;
    }

    //#notice

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
