/* 
 * DISCLAIMER PLACEHOLDER 
 */

package com.ogprover.prover_protocol.cp.auxiliary;

import java.util.Vector;

import com.ogprover.polynomials.XPolynomial;
import com.ogprover.prover_protocol.cp.geoconstruction.Point;
import com.ogprover.prover_protocol.cp.ndgcondition.NDGCondition;
import com.ogprover.prover_protocol.cp.thmstatement.IdenticalPoints;


/**
* <dl>
* <dt><b>Class description:</b></dt>
* <dd>Class for checking whether certain points' positions 
*     of two points correspond to specified NDG condition</dd>
* </dl>
* 
* @version 1.00
* @author Ivan Petrovic
*/
public class TwoPointsPositionChecker extends PointsPositionChecker {
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
	 * Constructor method
	 * 
	 * @param ndgCond	NDG condition associated to this points position checker
	 */
	public TwoPointsPositionChecker(NDGCondition ndgCond){
		this.initializePointsPositionChecker(ndgCond);
	}
	
	
	
	
	/*
	 * ======================================================================
	 * ========================== SPECIFIC METHODS ==========================
	 * ======================================================================
	 */
	/*
	 * Specific positions for two points
	 */
	/**
	 * Method that checks if some position of two given points can
	 * generate polynomial for attached NDG condition. If can, text of 
	 * this NDG condition is populated with appropriate readable
	 * form that describes specific position of these two points
	 * that generates this NDG condition. The text actually corresponds 
	 * to the negation of this NDG condition.
	 * 
	 * @param pointList		List with two points
	 * @return		        True if some position generates attached NDG condition,
	 * 				        false otherwise
	 * 
	 * @see com.ogprover.prover_protocol.cp.auxiliary.PointsPositionChecker#checkPositions(java.util.Vector)
	 * 
	 */
	public boolean checkPositions(Vector<Point> pointList) {
		if (pointList == null || pointList.size() != 2)
			return false;
		
		// we clone points since they will be added to new CP
		Point A = pointList.get(0).clone();
		Point B = pointList.get(1).clone();
		
		// Check if points are equal
		this.clearAuxCP();
		this.auxiliaryCP.addGeoConstruction(A);
		this.auxiliaryCP.addGeoConstruction(B);
		this.auxiliaryCP.addThmStatement(new IdenticalPoints(A, B));
		XPolynomial statementPoly = this.auxiliaryCP.getTheoremStatement().getAlgebraicForm();
		
		if (statementPoly != null && statementPoly.matchesNDGCPolynomial(this.ndgCond.getPolynomial())) {
			StringBuilder sb = new StringBuilder();
			sb.append("Points ");
			sb.append(A.getGeoObjectLabel());
			sb.append(" and ");
			sb.append(B.getGeoObjectLabel());
			sb.append(" are not identical");
			this.ndgCond.addNewText(pointList, sb.toString());
			return true;
		}
		
		return false;
	}
}
