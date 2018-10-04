package com.se421.brainfuck.atlas.ast;

import java.util.List;

import org.eclipse.core.runtime.SubMonitor;

import com.ensoftcorp.atlas.core.db.graph.EditableGraph;
import com.ensoftcorp.atlas.core.db.graph.Node;
import com.se421.brainfuck.atlas.parser.support.ParserSourceCorrespondence;

public class LoopInstruction extends Instruction {

	private List<Instruction> instructions;

	public LoopInstruction(ParserSourceCorrespondence sc, List<Instruction> instructions) {
		super(sc);
		this.instructions = instructions;
	}
	
	public List<Instruction> getInstructions(){
		return instructions;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Instruction instruction : instructions) {
			if(instruction instanceof LoopInstruction) {
				result.append(" ");
			}
			result.append(instruction.toString());
		}
		return "Loop: [" + result + "]";
	}
	
	@Override
	public Type getType() {
		return Type.LOOP;
	}
	
	@Override
	public Node index(EditableGraph graph, Node containerNode, SubMonitor monitor) {
		throw new RuntimeException("Not Implemented!");
	}
	
}
