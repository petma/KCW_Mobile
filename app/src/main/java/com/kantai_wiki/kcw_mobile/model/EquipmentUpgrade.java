package com.kantai_wiki.kcw_mobile.model;

import java.util.List;

/**
 * Created by Wafer on 2015/8/29.
 */
public class EquipmentUpgrade {

    //Data
    private String category;
    private String position;
    private String name;
    private String star;
    private String consume_fuel;
    private String consume_bullet;
    private String consume_steel;
    private String consume_alum;
    private String consume_material;
    private String consume_screw;
    private String consume_equipment;
    private List<String> upgradeable_day;
    private List<String> assistant_ship;
    private String upgrade_result;
    private String upgrade_result_inventable;


    //getter and setter


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

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

    public String getConsume_steel() {
        return consume_steel;
    }

    public void setConsume_steel(String consume_steel) {
        this.consume_steel = consume_steel;
    }

    public String getConsume_alum() {
        return consume_alum;
    }

    public void setConsume_alum(String consume_alum) {
        this.consume_alum = consume_alum;
    }

    public String getConsume_material() {
        return consume_material;
    }

    public void setConsume_material(String consume_material) {
        this.consume_material = consume_material;
    }

    public String getConsume_screw() {
        return consume_screw;
    }

    public void setConsume_screw(String consume_screw) {
        this.consume_screw = consume_screw;
    }

    public String getConsume_equipment() {
        return consume_equipment;
    }

    public void setConsume_equipment(String consume_equipment) {
        this.consume_equipment = consume_equipment;
    }

    public List<String> getUpgradeable_day() {
        return upgradeable_day;
    }

    public void setUpgradeable_day(List<String> upgradeable_day) {
        this.upgradeable_day = upgradeable_day;
    }

    public String getUpgrade_result() {
        return upgrade_result;
    }

    public void setUpgrade_result(String upgrade_result) {
        this.upgrade_result = upgrade_result;
    }

    public String getUpgrade_result_inventable() {
        return upgrade_result_inventable;
    }

    public void setUpgrade_result_inventable(String upgrade_result_inventable) {
        this.upgrade_result_inventable = upgrade_result_inventable;
    }
}
