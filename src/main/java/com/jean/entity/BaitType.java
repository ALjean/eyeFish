package com.jean.entity;

public class BaitType {

    private int typeId;
    private String typeName;

    public int getTypeId() {
	return typeId;
    }

    public void setTypeId(int typeId) {
	this.typeId = typeId;
    }

    public String getTypeName() {
	return typeName;
    }

    public void setTypeName(String typeName) {
	this.typeName = typeName;
    }

    public BaitType() {
	super();
    }

    public BaitType(int typeId, String typeName) {
	super();
	this.typeId = typeId;
	this.typeName = typeName;
    }

    @Override
    public String toString() {
	return "BaitType [typeId=" + typeId + ", typeName=" + typeName + "]";
    }

}
