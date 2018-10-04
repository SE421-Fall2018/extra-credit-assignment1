package com.se421.brainfuck.regression;

import java.io.File;

import com.se421.brainfuck.interpreter.BrainfuckInterpreter;

public class Test {

	public static void main(String[] args) throws Exception {
		File file = new File("examples" + File.separator + "fib-small.bf");
		BrainfuckInterpreter.execute(file, System.in, System.out/*, System.err*/);
	}
	
}
