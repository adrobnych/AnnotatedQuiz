package com.tdl.annotated_quiz.runners;

import com.tdl.annotated_quiz.annotations.Question;
import com.tdl.annotated_quiz.quiz_tests.QuizTest;

public class QuizTestPrinter extends Runner {

	public QuizTestPrinter(QuizTest test) {
		super(test);
	}

	public String start() {
		return executeMethodAnnotatedWith(Question.class);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> testClass = Class.forName(args[0]);
		Runner runner = new QuizTestPrinter( (QuizTest) testClass.newInstance() );
		System.out.println(runner.start());
	}
	
}
