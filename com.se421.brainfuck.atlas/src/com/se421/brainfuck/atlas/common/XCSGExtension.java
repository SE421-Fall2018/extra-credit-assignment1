package com.se421.brainfuck.atlas.common;

import org.eclipse.ui.IStartup;

import com.ensoftcorp.atlas.core.xcsg.XCSG;
import com.se421.brainfuck.atlas.log.Log;

/**
 * A wrapper and extension for relevant XCSG tag and attribute constants
 * 
 * @author Ben Holland
 */
public class XCSGExtension implements IStartup {

	public static class Language {
		/**
		 * A tag applied to nodes/edges in a Brainfuck program
		 */
		public static final String Brainfuck = "XCSG.Language.Brainfuck";
	}
	
	public static class Brainfuck {
		/**
		 * A tag applied to a container node of a Brainfuck program. To allow smart views to function normally we 
		 * create an imaginary function container, although Brainfuck officially has not concept of functions
		 */
		public static final String ImplictFunction = "XCSG.Brainfuck.ImplictFunction";
		
		/**
		 * A tag applied to all 8 Brainfuck instruction node
		 */
		public static final String Instruction = "XCSG.Brainfuck.Instruction";
		
		/**
		 * A tag applied to a control flow node that is representing multiple Brainfuck instructions
		 * This tag should only be applied for just used for coalesced basic blocks
		 */
		public static final String Instructions = "XCSG.Brainfuck.Instructions";
		
		/**
		 * A tag applied to a [ instruction node
		 */
		public static final String LoopHeader = com.ensoftcorp.atlas.core.xcsg.XCSG.Loop;
		
		/**
		 * A tag applied to a ] instruction node
		 */
		public static final String LoopFooter = "XCSG.Brainfuck.LoopFooter";
		
		/**
		 * A tag applied to a + instruction node
		 */
		public static final String IncrementInstruction = "XCSG.Brainfuck.IncrementInstruction";
		
		/**
		 * A tag applied to a +- instruction node
		 */
		public static final String DecrementInstruction = "XCSG.Brainfuck.DecrementInstruction";
		
		/**
		 * A tag applied to a < instruction node
		 */
		public static final String MoveLeftInstruction = "XCSG.Brainfuck.MoveLeftInstruction";
		
		/**
		 * A tag applied to a > instruction node
		 */
		public static final String MoveRightInstruction = "XCSG.Brainfuck.MoveRightInstruction";
		
		/**
		 * A tag applied to a , instruction node
		 */
		public static final String ReadInputInstruction = "XCSG.Brainfuck.ReadInputInstruction";
		
		/**
		 * A tag applied to a . instruction node
		 */
		public static final String WriteOutputInstruction = "XCSG.Brainfuck.WriteOutputInstruction";
	}
	
	/**
	 * A container node that represents a Brainfuck project
	 */
	public static final String Project = com.ensoftcorp.atlas.core.xcsg.XCSG.Project;
	
	/**
	 * A container node that represents a Brainfuck program file
	 */
	public static final String Namespace = com.ensoftcorp.atlas.core.xcsg.XCSG.Namespace;
	
	/**
	 * A Brainfuck control flow node
	 */
	public static final String ControlFlow_Node = com.ensoftcorp.atlas.core.xcsg.XCSG.ControlFlow_Node;
	
	/**
	 * A Brainfuck control flow root. All Brainfuck programs have a single control flow root.
	 */
	public static final String ControlFlowRoot = com.ensoftcorp.atlas.core.xcsg.XCSG.controlFlowRoot;
	
	/**
	 * A Brainfuck control flow exit. All Brainfuck programs have a single control flow exit.
	 */
	public static final String ControlFlowExit = com.ensoftcorp.atlas.core.xcsg.XCSG.controlFlowExitPoint;
	
	/**
	 * A Brainfuck control flow condition. This could be either a [ instruction or a ] instruction
	 */
	public static final String ControlFlowCondition = com.ensoftcorp.atlas.core.xcsg.XCSG.ControlFlowCondition;
	
	
	/**
	 * A Brainfuck container relationship edge
	 */
	public static final String Contains = com.ensoftcorp.atlas.core.xcsg.XCSG.Contains;
	
	/**
	 * A Brainfuck control flow relationship edge
	 */
	public static final String ControlFlow_Edge = com.ensoftcorp.atlas.core.xcsg.XCSG.ControlFlow_Edge;
	
	/**
	 * A Brainfuck loop back relationship edge
	 */
	public static final String ControlFlowBackEdge = com.ensoftcorp.atlas.core.xcsg.XCSG.ControlFlowBackEdge;
	
	/**
	 * A Brainfuck loop child edge creates an edge from the loop header to each of the loop children
	 */
	public static final String LoopChild = com.ensoftcorp.atlas.core.xcsg.XCSG.LoopChild;
	
	/**
	 * A node or edge name attribute key. Values are string values for the node or edge name.
	 */
	public static String name = com.ensoftcorp.atlas.core.xcsg.XCSG.name;
	
	/**
	 * A control flow edges condition value attribute key. In Brainfuck program's this is only ever a boolean true or boolean false value.
	 */
	public static final String conditionValue = com.ensoftcorp.atlas.core.xcsg.XCSG.conditionValue;
	
	/**
	 * A node's source correspondence attribute key.
	 */
	public static final String sourceCorrespondence = com.ensoftcorp.atlas.core.xcsg.XCSG.sourceCorrespondence;
	
	/**
	 * This runs on Eclipse startup and registers the XCSG extension tag hierarchy
	 */
	@Override
	public void earlyStartup() {
		try {
			registerSchema();
		} catch (Exception e){
			Log.error("Unable to build tag hierarchy.", e);
		}
	}
	
	private static boolean isTagHierarchyInitialized = false;
	
	public static void registerSchema(){
		if(!isTagHierarchyInitialized){
			isTagHierarchyInitialized = true;
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSGExtension.Brainfuck.ImplictFunction, XCSG.Function);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSGExtension.Brainfuck.Instruction, XCSG.ControlFlow_Node);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSGExtension.Brainfuck.Instructions, XCSG.ControlFlow_Node);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSGExtension.Brainfuck.IncrementInstruction, XCSGExtension.Brainfuck.Instruction);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSGExtension.Brainfuck.DecrementInstruction, XCSGExtension.Brainfuck.Instruction);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSGExtension.Brainfuck.MoveLeftInstruction, XCSGExtension.Brainfuck.Instruction);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSGExtension.Brainfuck.MoveRightInstruction, XCSGExtension.Brainfuck.Instruction);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSGExtension.Brainfuck.ReadInputInstruction, XCSGExtension.Brainfuck.Instruction);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSGExtension.Brainfuck.WriteOutputInstruction, XCSGExtension.Brainfuck.Instruction);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSGExtension.Brainfuck.LoopFooter, XCSG.ControlFlowCondition);
		}
	}
	
}
