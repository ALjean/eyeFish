package com.jean.entity;

public class BaitPropertieType {

    private int id;
    private String BaitPropTypeName;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getBaitPropTypeName() {
	return BaitPropTypeName;
    }

    public void setBaitPropTypeName(String baitPropTypeName) {
	BaitPropTypeName = baitPropTypeName;
    }

    @Override
    public String toString() {
	return "BaitPropertieType [id=" + id + ", BaitPropTypeName=" + BaitPropTypeName + "]";
    }

    public BaitPropertieType() {
	super();
    }

    public BaitPropertieType(int id, String baitPropTypeName) {
	super();
	this.id = id;
	BaitPropTypeName = baitPropTypeName;
    }

}
