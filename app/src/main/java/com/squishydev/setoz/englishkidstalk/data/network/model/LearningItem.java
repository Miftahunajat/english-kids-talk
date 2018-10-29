package com.squishydev.setoz.englishkidstalk.data.network.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

@Generated("com.robohorse.robopojogenerator")
public class LearningItem implements Serializable {

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("learningTopic")
	private LearningTopicsItem learningTopic;

	@SerializedName("learning_topic_id")
	private int learningTopicId;

	@SerializedName("learning_item_title")
	private String learningItemTitle;

	@SerializedName("id")
	private int id;

	@SerializedName("learning_item_xp")
	private int learningItemXp;

	@SerializedName("learning_item_image")
	private String learningItemImage;

	@SerializedName("users")
	private List<Object> users;

	@SerializedName("updatedAt")
	private String updatedAt;

	@BindingAdapter({"imageUrl"})
	public static void loadImage(ImageView view, String imageUrl){
		Picasso.get().load(imageUrl).into(view);
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setLearningTopic(LearningTopicsItem learningTopic){
		this.learningTopic = learningTopic;
	}

	public LearningTopicsItem getLearningTopic(){
		return learningTopic;
	}

	public void setLearningTopicId(int learningTopicId){
		this.learningTopicId = learningTopicId;
	}

	public int getLearningTopicId(){
		return learningTopicId;
	}

	public void setLearningItemTitle(String learningItemTitle){
		this.learningItemTitle = learningItemTitle;
	}

	public String getLearningItemTitle(){
		return learningItemTitle;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLearningItemXp(int learningItemXp){
		this.learningItemXp = learningItemXp;
	}

	public int getLearningItemXp(){
		return learningItemXp;
	}

	public void setLearningItemImage(String learningItemImage){
		this.learningItemImage = learningItemImage;
	}

	public String getLearningItemImage(){
		return learningItemImage;
	}

	public void setUsers(List<Object> users){
		this.users = users;
	}

	public List<Object> getUsers(){
		return users;
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
			"LearningItem{" + 
			"createdAt = '" + createdAt + '\'' + 
			",learningTopic = '" + learningTopic + '\'' + 
			",learning_topic_id = '" + learningTopicId + '\'' + 
			",learning_item_title = '" + learningItemTitle + '\'' + 
			",id = '" + id + '\'' + 
			",learning_item_xp = '" + learningItemXp + '\'' + 
			",learning_item_image = '" + learningItemImage + '\'' + 
			",users = '" + users + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}