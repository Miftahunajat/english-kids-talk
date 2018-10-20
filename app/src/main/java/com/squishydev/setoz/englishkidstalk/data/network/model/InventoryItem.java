package com.squishydev.setoz.englishkidstalk.data.network.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class InventoryItem{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("is_active")
	private boolean isActive;

	@SerializedName("item_id")
	private int itemId;

	@SerializedName("inventory_id")
	private int inventoryId;

	@SerializedName("updatedAt")
	private String updatedAt;



	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}

	public boolean isIsActive(){
		return isActive;
	}

	public void setItemId(int itemId){
		this.itemId = itemId;
	}

	public int getItemId(){
		return itemId;
	}

	public void setInventoryId(int inventoryId){
		this.inventoryId = inventoryId;
	}

	public int getInventoryId(){
		return inventoryId;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	@Override
 	public String toString(){
		return 
			"InventoryItem{" + 
			"createdAt = '" + createdAt + '\'' + 
			",is_active = '" + isActive + '\'' + 
			",item_id = '" + itemId + '\'' + 
			",inventory_id = '" + inventoryId + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}