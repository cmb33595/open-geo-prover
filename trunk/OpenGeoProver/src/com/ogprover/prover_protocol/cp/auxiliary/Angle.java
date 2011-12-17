/* 
 * DISCLAIMER PLACEHOLDER 
 */

package com.ogprover.prover_protocol.cp.auxiliary;

import com.ogprover.prover_protocol.cp.geoconstruction.Point;


/**
* <dl>
* <dt><b>Class description:</b></dt>
* <dd>Class for angle</dd>
* </dl>
* 
* @version 1.00
* @author Ivan Petrovic
*/
public class Angle {
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
	 * Vertex of angle
	 */
	private Point vertex;
	/**
	 * Point from first ray of angle
	 */
	private Point firstRayPoint;
	/**
	 * Point from second ray of angle
	 */
	private Point secondRayPoint;
	
	
	
	
	/*
	 * ======================================================================
	 * ========================== GETTERS/SETTERS ===========================
	 * ======================================================================
	 */
	/**
	 * @param vertex the vertex to set
	 */
	public void setVertex(Point vertex) {
		this.vertex = vertex;
	}

	/**
	 * @return the vertex
	 */
	public Point getVertex() {
		return vertex;
	}
	
	/**
	 * @param firstRayPoint the firstRayPoint to set
	 */
	public void setFirstRayPoint(Point firstRayPoint) {
		this.firstRayPoint = firstRayPoint;
	}

	/**
	 * @return the firstRayPoint
	 */
	public Point getFirstRayPoint() {
		return firstRayPoint;
	}
	
	/**
	 * @param secondRayPoint the secondRayPoint to set
	 */
	public void setSecondRayPoint(Point secondRayPoint) {
		this.secondRayPoint = secondRayPoint;
	}

	/**
	 * @return the secondRayPoint
	 */
	public Point getSecondRayPoint() {
		return secondRayPoint;
	}
	
	
	
	/*
	 * ======================================================================
	 * ========================== CONSTRUCTORS ==============================
	 * ======================================================================
	 */
	
	public Angle(Point firstRayPoint, Point vertex, Point secondRayPoint) {
		this.vertex = vertex;
		this.firstRayPoint = firstRayPoint;
		this.secondRayPoint = secondRayPoint;
	}
	
	
	
	/*
	 * ======================================================================
	 * ========================== SPECIFIC METHODS ==========================
	 * ======================================================================
	 */
	/**
	 * Check whether first ray of this angle is perpendicular to x-axis.
	 * This ray position is specific for calculation of angle tangent.
	 * 
	 * @return	True if first ray is perpendicular to x-axis, false otherwise
	 */
	public boolean isFirstRayPerpendicularToXAxis() {
		// ray is perpendicular to x-axis if both its points have same x coordinates
		return this.vertex.getX().equals(this.firstRayPoint.getX());
	}
	
	/**
	 * Check whether second ray of this angle is perpendicular to x-axis.
	 * This ray position is specific for calculation of angle tangent.
	 * 
	 * @return	True if second ray is perpendicular to x-axis, false otherwise
	 */
	public boolean isSecondRayPerpendicularToXAxis() {
		// ray is perpendicular to x-axis if both its points have same x coordinates
		return this.vertex.getX().equals(this.secondRayPoint.getX());
	}
	
	/**
	 * Method that retrieves the description of this angle.
	 * 
	 * @return	Textual description of angle.
	 */
	public String getDescription() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.firstRayPoint.getGeoObjectLabel());
		sb.append(this.vertex.getGeoObjectLabel());
		sb.append(this.secondRayPoint.getGeoObjectLabel());
		return sb.toString();
	}

}


