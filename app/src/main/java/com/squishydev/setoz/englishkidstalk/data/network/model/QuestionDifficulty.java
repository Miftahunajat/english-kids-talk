package com.squishydev.setoz.englishkidstalk.data.network.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class QuestionDifficulty{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("question_difficulty_name")
	private String questionDifficultyName;

	@SerializedName("updatedAt")
	private String updatedAt;

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setQuestionDifficultyName(String questionDifficultyName){
		this.questionDifficultyName = questionDifficultyName;
	}

	public String getQuestionDifficultyName(){
		return questionDifficultyName;
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
			"QuestionDifficulty{" + 
			"createdAt = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",question_difficulty_name = '" + questionDifficultyName + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}