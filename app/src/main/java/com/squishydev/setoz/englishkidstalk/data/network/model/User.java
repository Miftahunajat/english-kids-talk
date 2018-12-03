package com.squishydev.setoz.englishkidstalk.data.network.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class User implements Serializable {

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("password")
	private String password;

	@SerializedName("gender")
	private int gender;

	@SerializedName("inventory_id")
	private int inventoryId;

	@SerializedName("inventory")
	private Inventory inventory;

	@SerializedName("xp_gained")
	private int xpGained;

	@SerializedName("name")
	private String name;

	@SerializedName("star_gained")
	private int starGained;

	@SerializedName("id")
	private int id;

	@SerializedName("username")
	private String username;

	@SerializedName("updatedAt")
	private String updatedAt;

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setGender(int gender){
		this.gender = gender;
	}

	public int getGender(){
		return gender;
	}

	public void setInventoryId(int inventoryId){
		this.inventoryId = inventoryId;
	}

	public int getInventoryId(){
		return inventoryId;
	}

	public void setXpGained(int xpGained){
		this.xpGained = xpGained;
	}

	public int getXpGained(){
		return xpGained;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setStarGained(int starGained){
		this.starGained = starGained;
	}

	public int getStarGained(){
		return starGained;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"createdAt = '" + createdAt + '\'' + 
			",password = '" + password + '\'' + 
			",gender = '" + gender + '\'' + 
			",inventory_id = '" + inventoryId + '\'' + 
			",xp_gained = '" + xpGained + '\'' + 
			",name = '" + name + '\'' + 
			",star_gained = '" + starGained + '\'' + 
			",id = '" + id + '\'' + 
			",username = '" + username + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}