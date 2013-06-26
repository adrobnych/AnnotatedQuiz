package com.tdl.annotated_quiz.runners;

import com.tdl.annotated_quiz.annotations.Code;
import com.tdl.annotated_quiz.quiz_tests.QuizTest;

public class QuizTestCodeRunner extends Runner{
	
	public QuizTestCodeRunner(QuizTest test) {
		super(test);
	}

	public String start() {
		return executeMethodAnnotatedWith(Code.class);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> testClass = Class.forName(args[0]);
		Runner runner = new QuizTestCodeRunner( (QuizTest) testClass.newInstance() );
		System.out.println(runner.start());
	}
}
