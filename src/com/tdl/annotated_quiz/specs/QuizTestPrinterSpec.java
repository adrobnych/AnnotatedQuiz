package com.tdl.annotated_quiz.specs;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tdl.annotated_quiz.quiz_tests.QuizTest;
import com.tdl.annotated_quiz.quiz_tests.SimpleMath;
import com.tdl.annotated_quiz.runners.QuizTestPrinter;
import com.tdl.annotated_quiz.runners.Runner;


public class QuizTestPrinterSpec {

	QuizTest test = new SimpleMath();
	Runner runner = new QuizTestPrinter(test);
	
	@Test
	public void itShouldPrintQuestionOfSingleTest() {
		String result = runner.start();
		assertTrue(result + " DOESN'T CONTAIN EXPECTED SUBSTRING",
			result.contains("What will be the result of this expression?"));
	}
	
	@Test
	public void itShouldPrintCodeOfSingleTest(){
		String result = runner.start();
		assertTrue(result + " DOESN'T CONTAIN EXPECTED SUBSTRING",
			result.contains("int result = 1+1;"));
	}

}
