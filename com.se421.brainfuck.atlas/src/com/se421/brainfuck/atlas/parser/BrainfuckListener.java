// Generated from Brainfuck.g4 by ANTLR 4.4

package com.se421.brainfuck.atlas.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BrainfuckParser}.
 */
public interface BrainfuckListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BrainfuckParser#instruction}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterInstruction(@NotNull BrainfuckParser.InstructionContext ctx);

	/**
	 * Exit a parse tree produced by {@link BrainfuckParser#instruction}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitInstruction(@NotNull BrainfuckParser.InstructionContext ctx);

	/**
	 * Enter a parse tree produced by {@link BrainfuckParser#instruction_list}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterInstruction_list(@NotNull BrainfuckParser.Instruction_listContext ctx);

	/**
	 * Exit a parse tree produced by {@link BrainfuckParser#instruction_list}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitInstruction_list(@NotNull BrainfuckParser.Instruction_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link BrainfuckParser#program}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void enterProgram(@NotNull BrainfuckParser.ProgramContext ctx);

	/**
	 * Exit a parse tree produced by {@link BrainfuckParser#program}.
	 * 
	 * @param ctx
	 *            the parse tree
	 */
	void exitProgram(@NotNull BrainfuckParser.ProgramContext ctx);
}