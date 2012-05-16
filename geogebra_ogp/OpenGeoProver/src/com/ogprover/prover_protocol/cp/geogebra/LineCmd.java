/* 
 * DISCLAIMER PLACEHOLDER 
 */

package com.ogprover.prover_protocol.cp.geogebra;

import java.util.ArrayList;


/**
* <dl>
* <dt><b>Class description:</b></dt>
* <dd>Class for GeoGebra's command used for construction of
*     line through two points or line parallel with given line. 
* </dd>
* </dl>
* 
* @version 1.00
* @author Ivan Petrovic
*/
public class LineCmd extends GeoGebraCommand {
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
	public static final String cmdName = GeoGebraCommand.COMMAND_LINE;
	
	
	
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
		return LineCmd.cmdName;
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
	 */
	public LineCmd(ArrayList<String> inputArgs, ArrayList<String> outputArgs) {
		super(inputArgs, outputArgs, GeoGebraObject.OBJ_TYPE_LINE);
	}
}