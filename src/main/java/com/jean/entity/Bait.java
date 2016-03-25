package com.jean.entity;

import java.util.List;

public class Bait {

    private int id;
    private String name;
    private String description;
    private BaitType baitType;
    private List<BaitPropertie> baitPropertie;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public BaitType getBaitType() {
	return baitType;
    }

    public void setBaitType(BaitType baitType) {
	this.baitType = baitType;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public List<BaitPropertie> getBaitPropertie() {
	return baitPropertie;
    }

    public void setBaitPropertie(List<BaitPropertie> baitPropertie) {
	this.baitPropertie = baitPropertie;
    }

    @Override
    public String toString() {
	return "Bait [id=" + id + ", name=" + name + ", description=" + description + ", baitType=" + baitType + ", baitPropertie=" + baitPropertie
		+ "]";
    }

    public Bait() {
	super();
    }

    public Bait(int id, String name, String description, BaitType baitType, List<BaitPropertie> baitPropertie) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.baitType = baitType;
	this.baitPropertie = baitPropertie;
    }

}
