package com.squishydev.setoz.englishkidstalk.data.network.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

@Generated("com.robohorse.robopojogenerator")
public class LearningTopicsItem{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("learning_topic_name")
	private String learningTopicName;

	@SerializedName("learning_topic_image")
	private String learningTopicImage;

	@SerializedName("id")
	private int id;

	@SerializedName("question_category_id")
	private int questionCategoryId;

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

	public void setLearningTopicName(String learningTopicName){
		this.learningTopicName = learningTopicName;
	}

	public String getLearningTopicName(){
		return learningTopicName;
	}

	public void setLearningTopicImage(String learningTopicImage){
		this.learningTopicImage = learningTopicImage;
	}

	public String getLearningTopicImage(){
		return learningTopicImage;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setQuestionCategoryId(int questionCategoryId){
		this.questionCategoryId = questionCategoryId;
	}

	public int getQuestionCategoryId(){
		return questionCategoryId;
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
			"LearningTopicsItem{" + 
			"createdAt = '" + createdAt + '\'' + 
			",learning_topic_name = '" + learningTopicName + '\'' + 
			",learning_topic_image = '" + learningTopicImage + '\'' + 
			",id = '" + id + '\'' + 
			",question_category_id = '" + questionCategoryId + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}