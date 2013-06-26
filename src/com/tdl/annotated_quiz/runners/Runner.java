package com.tdl.annotated_quiz.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.tdl.annotated_quiz.quiz_tests.QuizTest;

public abstract class Runner {
	protected QuizTest test;
	
	public Runner(QuizTest test) {
		this.test = test;
	}

	public String executeMethodAnnotatedWith(Class<? extends Annotation> annotation) {
		String result = null;
		for (Method m : test.getClass().getDeclaredMethods()) {
			if (m.isAnnotationPresent(annotation)) {
				try {
					result = "" + m.invoke(test, (Object[])null);
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + " failed: " + exc);
				} catch (Exception exc) {
					System.out.println("INVALID annotation: " + m);
				}
			}
		}
		return result;
	}

	abstract public String start();
}
