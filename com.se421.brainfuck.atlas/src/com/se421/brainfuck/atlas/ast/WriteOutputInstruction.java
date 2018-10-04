package com.se421.brainfuck.atlas.ast;

import org.eclipse.core.runtime.SubMonitor;

import com.ensoftcorp.atlas.core.db.graph.EditableGraph;
import com.ensoftcorp.atlas.core.db.graph.Node;
import com.se421.brainfuck.atlas.common.XCSG;
import com.se421.brainfuck.atlas.parser.support.ParserSourceCorrespondence;

public class WriteOutputInstruction extends Instruction {

	public WriteOutputInstruction(ParserSourceCorrespondence sc) {
		super(sc);
	}

	public String toString(){
		return ".";
	}
	
	@Override
	public Type getType() {
		return Type.WRITE;
	}
	
	@Override
	public Node index(EditableGraph graph, Node containerNode, SubMonitor monitor) {
		// create the instruction node
		Node instructionNode = super.index(graph, containerNode, monitor);
		instructionNode.tag(XCSG.Brainfuck.WriteOutputInstruction);
		return instructionNode;
	}
	
}
