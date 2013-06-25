package com.tdl.annotated_quiz.specs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tdl.annotated_quiz.quiz_tests.QuizTest;
import com.tdl.annotated_quiz.quiz_tests.SimpleMath;
import com.tdl.annotated_quiz.runners.QuizTestPrinter;


public class QuizTestPrinterSpec {

	@Test
	public void itShouldPrintQuestionOfSingleTest() {
		QuizTest test = new SimpleMath();
		QuizTestPrinter runner = new QuizTestPrinter(test);
		String result = runner.start();
		assertEquals("What will be the result of this expression?", result);
	}

}
