/* 
 * DISCLAIMER PLACEHOLDER 
 */

package com.ogprover.pp.tp.thmstatement;

import com.ogprover.polynomials.XPolynomial;
import com.ogprover.pp.tp.OGPTP;


/**
* <dl>
* <dt><b>Class description:</b></dt>
* <dd>Class for statement that is always true</dd>
* </dl>
* 
* @version 1.00
* @author Ivan Petrovic
*/
public class True extends ElementaryThmStatement {
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
	
	
	
	/*
	 * ======================================================================
	 * ========================== CONSTRUCTORS ==============================
	 * ======================================================================
	 */
	/**
	 * Constructor method.
	 * 
	 * @param cp 	Theorem protocol assigned to this statement
	 */
	public True(OGPTP cp) {
		this.geoObjects = cp.getConstructionSteps();
		this.consProtocol = cp;
	}
	
	
	
	/*
	 * ======================================================================
	 * ========================== SPECIFIC METHODS ==========================
	 * ======================================================================
	 */
	/**
	 * @see com.ogprover.pp.tp.thmstatement.ThmStatement#getAlgebraicForm()
	 */
	@Override
	public XPolynomial getAlgebraicForm() {
		// set zero polynomial as statement - it is always true (i.e. equals to zero)
		return new XPolynomial();
	}

	/**
	 * @see com.ogprover.pp.tp.thmstatement.ThmStatement#getStatementDesc()
	 */
	@Override
	public String getStatementDesc() {
		return "True";
	}
}
