/* 
 * DISCLAIMER PLACEHOLDER 
 */

package com.ogprover.prover_protocol.cp.geogebra;

import java.util.ArrayList;


/**
* <dl>
* <dt><b>Class description:</b></dt>
* <dd>Class for GeoGebra's command used for construction of
*     translated geometry object. 
* </dd>
* </dl>
* 
* @version 1.00
* @author Ivan Petrovic
*/
public class TranslateCmd extends GeoGebraCommand {
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

	/**
	 * <i><b>Name of this command</b></i>
	 */
	public static final String cmdName = GeoGebraCommand.COMMAND_TRANSLATE;
	
	
	
	/*
	 * ======================================================================
	 * ========================== GETTERS/SETTERS ===========================
	 * ======================================================================
	 */
	/**
	 * @see com.ogprover.prover_protocol.cp.geogebra.GeoGebraCommand#getCommandName()
	 */
	@Override
	public String getCommandName() {
		return TranslateCmd.cmdName;
	}
	
	
	
	/*
	 * ======================================================================
	 * ========================== CONSTRUCTORS ==============================
	 * ======================================================================
	 */
	/**
	 * Constructor method.
	 * 
	 * @param inputArgs		List of input arguments - labels of existing objects.
	 * @param outputArgs	List of output arguments - labels of new objects.
	 * @param objType		The type of new constructed object.
	 */
	public TranslateCmd(ArrayList<String> inputArgs, ArrayList<String> outputArgs, String objType) {
		super(inputArgs, outputArgs, objType);
	}
}