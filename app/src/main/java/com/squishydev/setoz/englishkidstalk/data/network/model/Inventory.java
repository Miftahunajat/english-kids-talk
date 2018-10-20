package com.squishydev.setoz.englishkidstalk.data.network.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Inventory{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("id")
	private int id;

	@SerializedName("items")
	private List<Item> items;

	@SerializedName("user")
	private User user;

	@SerializedName("updatedAt")
	private String updatedAt;

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setItems(List<Item> items){
		this.items = items;
	}

	public List<Item> getItems(){
		return items;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	//Terkadang suka error disini
	public List<Item> getActiveItems(){
        List<Item> result = new ArrayList<>();
        for (Item item : items){
            if (item.getInventoryItem().isIsActive())
                result.add(item);
        }

	    return result;
    }

	@Override
 	public String toString(){
		return 
			"Inventory{" + 
			"createdAt = '" + createdAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",id = '" + id + '\'' + 
			",items = '" + items + '\'' + 
			",user = '" + user + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}