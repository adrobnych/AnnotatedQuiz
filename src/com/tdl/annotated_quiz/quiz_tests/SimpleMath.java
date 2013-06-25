package com.tdl.annotated_quiz.quiz_tests;

import com.tdl.annotated_quiz.annotations.Code;
import com.tdl.annotated_quiz.annotations.Question;

public class SimpleMath extends QuizTest{
	
	@Question
	public static String printQuestion(){
		return "What will be the result of this expression?";
	}
	
	@Code
	public static String run(){
		int result =  1+1;
		return "" + result; 
	}

	@Override
	public QuizTestType getQuizTestType() {
		return QuizTestType.SINGLE_RIGHT_ANSWER;
	}

	@Override
	public String getRightAnswer() {
		return "2";
	}

}
