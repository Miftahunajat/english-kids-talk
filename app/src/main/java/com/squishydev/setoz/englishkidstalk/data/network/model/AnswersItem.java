package com.squishydev.setoz.englishkidstalk.data.network.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class AnswersItem implements Serializable{

	@SerializedName("answer_text")
	private String answerText;

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("challenge_id")
	private int challengeId;

	@SerializedName("id")
	private int id;

	@SerializedName("is_correct")
	private boolean isCorrect;

	@SerializedName("updatedAt")
	private String updatedAt;

	public void setAnswerText(String answerText){
		this.answerText = answerText;
	}

	public String getAnswerText(){
		return answerText;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setChallengeId(int challengeId){
		this.challengeId = challengeId;
	}

	public int getChallengeId(){
		return challengeId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setIsCorrect(boolean isCorrect){
		this.isCorrect = isCorrect;
	}

	public boolean isIsCorrect(){
		return isCorrect;
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
			"AnswersItem{" + 
			"answer_text = '" + answerText + '\'' + 
			",createdAt = '" + createdAt + '\'' + 
			",challenge_id = '" + challengeId + '\'' + 
			",id = '" + id + '\'' + 
			",is_correct = '" + isCorrect + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}