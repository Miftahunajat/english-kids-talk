package com.squishydev.setoz.englishkidstalk.data.network.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ItemCategory{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("item_category_image")
	private String itemCategoryImage;

	@SerializedName("item_category_name")
	private String itemCategoryName;

	@SerializedName("id")
	private int id;

	@SerializedName("items")
	private List<Item> items;

	@SerializedName("item_category_color")
	private String itemCategoryColor;

	@SerializedName("updatedAt")
	private String updatedAt;

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setItemCategoryImage(String itemCategoryImage){
		this.itemCategoryImage = itemCategoryImage;
	}

	public String getItemCategoryImage(){
		return itemCategoryImage;
	}

	public void setItemCategoryName(String itemCategoryName){
		this.itemCategoryName = itemCategoryName;
	}

	public String getItemCategoryName(){
		return itemCategoryName;
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

	public void setItemCategoryColor(String itemCategoryColor){
		this.itemCategoryColor = itemCategoryColor;
	}

	public String getItemCategoryColor(){
		return itemCategoryColor;
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
			"ItemCategory{" + 
			"createdAt = '" + createdAt + '\'' + 
			",item_category_image = '" + itemCategoryImage + '\'' + 
			",item_category_name = '" + itemCategoryName + '\'' + 
			",id = '" + id + '\'' + 
			",items = '" + items + '\'' + 
			",item_category_color = '" + itemCategoryColor + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}