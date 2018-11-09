package com.squishydev.setoz.englishkidstalk.data.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.squishydev.setoz.englishkidstalk.data.network.model.Inventory;

@Generated("com.robohorse.robopojogenerator")
public class User{

	@SerializedName("password")
	private String password;

	@SerializedName("profile_id")
	private int profileId;

	@SerializedName("inventory_id")
	private int inventoryId;

	@SerializedName("inventory")
	private Inventory inventory;


	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("gender")
	private int gender;

	@SerializedName("star_gained")
	private int starGained;

	@SerializedName("xp_gained")
	private int xpGained;

	@SerializedName("username")
	private String username;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public int getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getStarGained() {
		return starGained;
	}

	public void setStarGained(int starGained) {
		this.starGained = starGained;
	}

	public int getXpGained() {
		return xpGained;
	}

	public void setXpGained(int xpGained) {
		this.xpGained = xpGained;
	}



	@Override
 	public String toString(){
		return 
			"User{" + 
			"password = '" + password + '\'' + 
			",profile_id = '" + profileId + '\'' + 
			",inventory_id = '" + inventoryId + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}