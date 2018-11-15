package com.squishydev.setoz.englishkidstalk.data.network.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

@Generated("com.robohorse.robopojogenerator")
public class Challenge implements Serializable{

	@SerializedName("challenge_type")
	private int challengeType;

	@SerializedName("challenge_xp")
	private int challengeXp;

	@SerializedName("question_difficulty_id")
	private int questionDifficultyId;

	@SerializedName("answers")
	private List<AnswersItem> answers;

	@SerializedName("questionDifficulty")
	private QuestionDifficulty questionDifficulty;

	@SerializedName("question_category_id")
	private int questionCategoryId;

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("challenge_image")
	private String challengeImage;

	@SerializedName("id")
	private int id;

	@SerializedName("challenge_star")
	private int challengeStar;

	@SerializedName("challenge_question")
	private String challengeQuestion;

	@SerializedName("updatedAt")
	private String updatedAt;

	@SerializedName("questionCategory")
	private QuestionCategory questionCategory;

	@BindingAdapter({"imageUrl"})
	public static void loadImage(ImageView view, String imageUrl){
		Picasso.get().load(imageUrl).into(view);
	}

	public void setQuestionCategory(QuestionCategory questionCategory){
		this.questionCategory= questionCategory;
	}

	public QuestionCategory getQuestionCategory(){
		return questionCategory;
	}

	public void setChallengeType(int challengeType){
		this.challengeType = challengeType;
	}

	public int getChallengeType(){
		return challengeType;
	}

	public void setChallengeXp(int challengeXp){
		this.challengeXp = challengeXp;
	}

	public int getChallengeXp(){
		return challengeXp;
	}

	public void setQuestionDifficultyId(int questionDifficultyId){
		this.questionDifficultyId = questionDifficultyId;
	}

	public int getQuestionDifficultyId(){
		return questionDifficultyId;
	}

	public void setAnswers(List<AnswersItem> answers){
		this.answers = answers;
	}

	public List<AnswersItem> getAnswers(){
		return answers;
	}

	public void setQuestionDifficulty(QuestionDifficulty questionDifficulty){
		this.questionDifficulty = questionDifficulty;
	}

	public QuestionDifficulty getQuestionDifficulty(){
		return questionDifficulty;
	}

	public void setQuestionCategoryId(int questionCategoryId){
		this.questionCategoryId = questionCategoryId;
	}

	public int getQuestionCategoryId(){
		return questionCategoryId;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setChallengeImage(String challengeImage){
		this.challengeImage = challengeImage;
	}

	public String getChallengeImage(){
		return challengeImage;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setChallengeStar(int challengeStar){
		this.challengeStar = challengeStar;
	}

	public int getChallengeStar(){
		return challengeStar;
	}

	public void setChallengeQuestion(String challengeQuestion){
		this.challengeQuestion = challengeQuestion;
	}

	public String getChallengeQuestion(){
		return challengeQuestion;
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
			"Challenge{" + 
			"challenge_type = '" + challengeType + '\'' + 
			",challenge_xp = '" + challengeXp + '\'' + 
			",question_difficulty_id = '" + questionDifficultyId + '\'' + 
			",answers = '" + answers + '\'' + 
			",questionDifficulty = '" + questionDifficulty + '\'' + 
			",question_category_id = '" + questionCategoryId + '\'' +
			",createdAt = '" + createdAt + '\'' + 
			",challenge_image = '" + challengeImage + '\'' + 
			",id = '" + id + '\'' + 
			",challenge_star = '" + challengeStar + '\'' + 
			",challenge_question = '" + challengeQuestion + '\'' + 
			",updatedAt = '" + updatedAt + '\'' + 
			"}";
		}
}