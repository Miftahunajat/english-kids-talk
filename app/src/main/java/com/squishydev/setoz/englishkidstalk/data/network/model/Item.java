package com.squishydev.setoz.englishkidstalk.data.network.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

@Generated("com.robohorse.robopojogenerator")
public class Item {

	@SerializedName("snippet")
	private String snippet;

	@SerializedName("image")
	private String image;

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("InventoryItem")
	private InventoryItem inventoryItem;

	@SerializedName("item_desc")
	private String itemDesc;

	@SerializedName("gender")
	private int gender;

	public InventoryItem getInventoryItem() {
		return inventoryItem;
	}

	public void setInventoryItem(InventoryItem inventoryItem) {
		this.inventoryItem = inventoryItem;
	}

	@SerializedName("star")
	private int star;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("item_category_id")
	private int itemCategoryId;

	@SerializedName("updatedAt")
	private String updatedAt;

	@BindingAdapter({"imageUrl"})
	public static void loadImage(ImageView view, String imageUrl){
		Picasso.get().load(imageUrl).into(view);
	}

	public void setSnippet(String snippet){
		this.snippet = snippet;
	}

	public String getSnippet(){
		return snippet;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setItemDesc(String itemDesc){
		this.itemDesc = itemDesc;
	}

	public String getItemDesc(){
		return itemDesc;
	}

	public void setStar(int star){
		this.star = star;
	}

	public int getStar(){
		return star;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setItemCategoryId(int itemCategoryId){
		this.itemCategoryId = itemCategoryId;
	}

	public int getItemCategoryId(){
		return itemCategoryId;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Override
 	public String toString(){
		return 
			"Item{" +
			"snippet = '" + snippet + '\'' + 
			",image = '" + image + '\'' + 
			",createdAt = '" + createdAt + '\'' + 
			",item_desc = '" + itemDesc + '\'' + 
			",star = '" + star + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",item_category_id = '" + itemCategoryId + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}