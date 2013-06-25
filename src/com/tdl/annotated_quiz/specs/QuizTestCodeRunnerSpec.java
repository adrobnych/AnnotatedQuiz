package com.tdl.annotated_quiz.specs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tdl.annotated_quiz.quiz_tests.QuizTest;
import com.tdl.annotated_quiz.quiz_tests.QuizTestType;
import com.tdl.annotated_quiz.quiz_tests.SimpleMath;
import com.tdl.annotated_quiz.runners.QuizTestCodeRunner;

public class QuizTestCodeRunnerSpec {

	@Test
	public void itShouldRunSingleTests() {
		QuizTest test = new SimpleMath();
		QuizTestCodeRunner runner = new QuizTestCodeRunner(test);
		String result = runner.start();
		assertEquals(QuizTestType.SINGLE_RIGHT_ANSWER, test.getQuizTestType());
		assertEquals(test.getRightAnswer(), result);
	}

}
