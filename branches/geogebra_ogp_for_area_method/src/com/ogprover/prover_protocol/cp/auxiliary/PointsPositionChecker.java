/* 
 * DISCLAIMER PLACEHOLDER 
 */

package com.ogprover.prover_protocol.cp.auxiliary;

import java.util.Vector;

import com.ogprover.prover_protocol.cp.OGPCP;
import com.ogprover.prover_protocol.cp.geoconstruction.Point;
import com.ogprover.prover_protocol.cp.ndgcondition.NDGCondition;


/**
* <dl>
* <dt><b>Class description:</b></dt>
* <dd>Abstract class for checking whether certain points' positions 
*     correspond to specified NDG condition</dd>
* </dl>
* 
* @version 1.00
* @author Ivan Petrovic
*/
public abstract class PointsPositionChecker {
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
	 * Attached NDG condition
	 */
	protected NDGCondition ndgCond = null;
	/**
	 * Construction protocol used for process of translation of 
	 * NDG condition to readable form.
	 */
	protected OGPCP auxiliaryCP = null;
	/**
	 * Initial value of u-index in auxiliary CP.
	 */
	protected int acpUIndex = 1;
	/**
	 * Initial value of x-index in auxiliary CP.
	 */
	protected int acpXIndex = 1;
	
	
	
	
	/*
	 * ======================================================================
	 * ========================= ABSTRACT METHODS ===========================
	 * ======================================================================
	 */
	/**
	 * Method that checks points positions
	 * 
	 * @return	True if some position generates attached NDG condition,
	 * 		    false otherwise
	 */
	public abstract boolean checkPositions(Vector<Point> pointList);
	
	
	
	/*
	 * ======================================================================
	 * ========================== GETTERS/SETTERS ===========================
	 * ======================================================================
	 */
	/**
	 * @param ndgCond the ndgCond to set
	 */
	public void setNDGCond(NDGCondition ndgCond) {
		this.ndgCond = ndgCond;
	}
	
	/**
	 * @return the ndgCond
	 */
	public NDGCondition getNDGCond() {
		return ndgCond;
	}
	
	/**
	 * @param auxiliaryCP the auxiliaryCP to set
	 */
	public void setAuxiliaryCP(OGPCP auxiliaryCP) {
		this.auxiliaryCP = auxiliaryCP;
	}

	/**
	 * @return the auxiliaryCP
	 */
	public OGPCP getAuxiliaryCP() {
		return auxiliaryCP;
	}
	
	
	
	
	/*
	 * ======================================================================
	 * ========================== SPECIFIC METHODS ==========================
	 * ======================================================================
	 */
	/**
	 * Method for clearing auxiliary CP and setting initial values for indices.
	 */
	public void clearAuxCP() {
		this.auxiliaryCP.clear();
		this.auxiliaryCP.setUIndex(this.acpUIndex);
		this.auxiliaryCP.setXIndex(this.acpXIndex);
	}
	
	/**
	 * Method for initialization of auxiliary CP that must be called
	 * within constructors of derived classes.
	 */
	protected void initializeAuxiliaryCP() {
		this.auxiliaryCP = new OGPCP();
		/* 
		 * Set u and x indices from CP of NDG condition for the case 
		 * when new points are generated within this new CP. This is
		 * because this new CP will contain points from NDGC's CP and
		 * new points should be generated with coordinates that follow
		 * already added points.
		 */
		this.acpUIndex = this.ndgCond.getConsProtocol().getUIndex();
		this.acpXIndex = this.ndgCond.getConsProtocol().getXIndex();
		this.auxiliaryCP.setUIndex(this.acpUIndex);
		this.auxiliaryCP.setXIndex(this.acpXIndex);
	}
	
	/**
	 * Main method that must be called within each constructor of derived classes.
	 * 
	 * @param ndgCond	NDG condition associated to this points position checker
	 */
	protected void initializePointsPositionChecker(NDGCondition ndgCond) {
		this.ndgCond = ndgCond;
		this.initializeAuxiliaryCP();
	}
}
