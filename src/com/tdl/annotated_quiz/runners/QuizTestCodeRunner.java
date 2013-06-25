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
					result = "" + m.invoke(null);
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
