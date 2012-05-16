/* 
 * DISCLAIMER PLACEHOLDER 
 */

package com.ogprover.prover_protocol;

/**
 * <dl>
 * <dt><b>Class description:</b></dt>
 * <dd>Class for input prover protocol</dd>
 * </dl>
 * 
 * @version 1.00
 * @author Ivan Petrovic
 */
public class OGPInputProverProtocol extends OGPProverProtocol {
	/*
	 * TODO
	 * 
	 * Input prover protocol should contain following information:
	 * 
	 * 1. Construction Protocol (CP) with description of theorem:
	 * 		theorem name, construction steps and theorem statement.
	 * 2. Prover execution parameters like:
	 * 		names and format of input files and output reports, 
	 * 		type of prover to be used for execution, time and space
	 *		limits to limit the prover execution and avoid crashing of
	 * 		application, log level etc.
	 */
	
	/*
	 * ======================================================================
	 * ========================== VARIABLES =================================
	 * ======================================================================
	 */
	/**
	 * <i><b>
	 * Version number of class in form xx.yy where
	 * xx is major version/release number and yy is minor
	 * release number.
	 * </b></i>
	 */
	public static final String VERSION_NUM = "1.00"; // this should match the version number from class comment
	
	

	/*
	 * ======================================================================
	 * ========================== GETTERS/SETTERS ===========================
	 * ======================================================================
	 */
	/**
	 * Method that retrieves prover protocol type
	 * 
	 * @return	The type of prover protocol
	 */
	public int getProverProtocolType() {
		return OGPProverProtocol.PP_TYPE_INPUT;
	}
	
	
	
	
	/*
	 * ======================================================================
	 * ========================== CONSTRUCTORS ==============================
	 * ======================================================================
	 */
	
	
	

	/*
	 * ======================================================================
	 * ========================== SPECIFIC METHODS ==========================
	 * ======================================================================
	 */

	
}
