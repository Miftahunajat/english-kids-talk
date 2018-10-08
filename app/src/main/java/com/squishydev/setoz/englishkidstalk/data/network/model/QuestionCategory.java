package com.squishydev.setoz.englishkidstalk.data.network.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class QuestionCategory{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("challenges")
	private List<Object> challenges;

	@SerializedName("learningTopics")
	private List<LearningTopicsItem> learningTopics;

	@SerializedName("question_difficulty_id")
	private int questionDifficultyId;

	@SerializedName("id")
	private int id;

	@SerializedName("questionDifficulty")
	private QuestionDifficulty questionDifficulty;

	@SerializedName("question_category_name")
	private String questionCategoryName;

	@SerializedName("updatedAt")
	private String updatedAt;

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setChallenges(List<Object> challenges){
		this.challenges = challenges;
	}

	public List<Object> getChallenges(){
		return challenges;
	}

	public void setLearningTopics(List<LearningTopicsItem> learningTopics){
		this.learningTopics = learningTopics;
	}

	public List<LearningTopicsItem> getLearningTopics(){
		return learningTopics;
	}

	public void setQuestionDifficultyId(int questionDifficultyId){
		this.questionDifficultyId = questionDifficultyId;
	}

	public int getQuestionDifficultyId(){
		return questionDifficultyId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setQuestionDifficulty(QuestionDifficulty questionDifficulty){
		this.questionDifficulty = questionDifficulty;
	}

	public QuestionDifficulty getQuestionDifficulty(){
		return questionDifficulty;
	}

	public void setQuestionCategoryName(String questionCategoryName){
		this.questionCategoryName = questionCategoryName;
	}

	public String getQuestionCategoryName(){
		return questionCategoryName;
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
			"QuestionCategory{" + 
			"createdAt = '" + createdAt + '\'' + 
			",challenges = '" + challenges + '\'' + 
			",learningTopics = '" + learningTopics + '\'' + 
			",question_difficulty_id = '" + questionDifficultyId + '\'' + 
			",id = '" + id + '\'' + 
			",questionDifficulty = '" + questionDifficulty + '\'' + 
			",question_category_name = '" + questionCategoryName + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}