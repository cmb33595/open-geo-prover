/* 
 * DISCLAIMER PLACEHOLDER 
 */

package com.ogprover.area_method;

import java.util.Vector;

/**
 * <dl>
 * <dt><b>Class description:</b></dt>
 * <dd>Class for construction of a P-ratio point in an area method construction</dd>
 * </dl>
 * 
 * @version 1.00
 * @author Damien Desfontaines
 */
public class AMTratioPoint extends AMPoint {
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
	 * Points used to construct this point
	 */
	protected final AMPoint y,u,v;
	/**
	 * Ratio used to construct this point
	 */
	protected final AMRatio r;

	
	/*
	 * ======================================================================
	 * ========================== CONSTRUCTORS ==============================
	 * ======================================================================
	 */
	/**
	 * Constructor method
	 * 
	 * @param pointLabel	Label of point
	 * @param y				Previously constructed point
	 * @param u				Previously constructed point
	 * @param v 			Previously constructed point
	 * @param r				Ratio
	 * @return The point of label pointLabel, constructed as TRATIO(y,u,v,r)
	 * @see http://hal.inria.fr/hal-00426563/PDF/areaMethodRecapV2.pdf
	 */
	public AMTratioPoint(String label,AMPoint y,AMPoint w,AMPoint u, AMPoint v) {
		type = 2;
		this.label = label;
		this.y = y;
		this.u = u;
		this.v = v;
		dependantPoints = new Vector<AMPoint>();
		dependantPoints.add(y);
		dependantPoints.add(u);
		dependantPoints.add(v);
	}
	
	/**
	 * Constructor method
	 * 
	 * @param y				Previously constructed point
	 * @param u				Previously constructed point
	 * @param v 			Previously constructed point
	 * @param r				Ratio
	 * @return The point of label automatically generated, constructed as TRATIO(y,u,v,r)
	 * @see http://hal.inria.fr/hal-00426563/PDF/areaMethodRecapV2.pdf
	 */
	public AMTratioPoint(AMPoint y,AMPoint w,AMPoint u, AMPoint v) {
		type = 2;
		this.label = nextAvailableName();
		this.y = y;
		this.u = u;
		this.v = v;
		dependantPoints = new Vector<AMPoint>();
		dependantPoints.add(y);
		dependantPoints.add(u);
		dependantPoints.add(v);
	}
}