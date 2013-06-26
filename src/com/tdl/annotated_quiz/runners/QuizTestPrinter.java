package com.tdl.annotated_quiz.runners;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.tdl.annotated_quiz.annotations.Question;
import com.tdl.annotated_quiz.quiz_tests.QuizTest;

public class QuizTestPrinter extends Runner {
	public final String PATH_TO_SRC = "C:/Users/a.drobnych/workspace/AnnotatedQuiz/src/";

	public QuizTestPrinter(QuizTest test) {
		super(test);
	}

	public String start(){
		StringBuilder result = new StringBuilder();
		result.append(executeMethodAnnotatedWith(Question.class));
		
		Class<?> clazz = test.getClass();
		String path = clazz.getPackage().getName().replaceAll("\\.","/");
		File sourceFile = new File(PATH_TO_SRC + path, clazz.getSimpleName() + ".java");
		try{
			Scanner fileScanner = new Scanner(sourceFile);
			while (fileScanner.hasNextLine()){
				result.append(fileScanner.nextLine());
			}
			fileScanner.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result.toString();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> testClass = Class.forName(args[0]);
		Runner runner = new QuizTestPrinter( (QuizTest) testClass.newInstance() );
		System.out.println(runner.start());
	}
	
}
