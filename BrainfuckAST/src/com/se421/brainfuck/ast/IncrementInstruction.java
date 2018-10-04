package com.se421.brainfuck.ast;

import com.se421.brainfuck.parser.support.ParserSourceCorrespondence;

public class IncrementInstruction extends Instruction {

	public IncrementInstruction(ParserSourceCorrespondence sc) {
		super(sc);
	}

	public String toString(){
		return "+";
	}
	
	@Override
	public Type getType() {
		return Type.INCREMENT;
	}
	
}
