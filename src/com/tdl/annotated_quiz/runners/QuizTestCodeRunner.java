package com.tdl.annotated_quiz.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.tdl.annotated_quiz.annotations.Code;
import com.tdl.annotated_quiz.quiz_tests.QuizTest;

public class QuizTestCodeRunner {

	private QuizTest test;
	
	public QuizTestCodeRunner(QuizTest test) {
		this.test = test;
	}

	public String start() {
		String result = null;
		for (Method m : test.getClass().getDeclaredMethods()) {
			if (m.isAnnotationPresent(Code.class)) {
				try {
					result = "" + m.invoke(test, (Object[])null);
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + " failed: " + exc);
				} catch (Exception exc) {
					System.out.println("INVALID @Code: " + m);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> testClass = Class.forName(args[0]);
		QuizTestCodeRunner runner = new QuizTestCodeRunner( (QuizTest) testClass.newInstance() );
		System.out.println(runner.start());
	}
}
