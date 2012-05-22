/* 
 * DISCLAIMER PLACEHOLDER 
 */

package com.ogprover.prover_protocol.cp.geoconstruction;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.ogprover.main.OpenGeoProver;
import com.ogprover.polynomials.Power;
import com.ogprover.polynomials.SymbolicPolynomial;
import com.ogprover.polynomials.SymbolicTerm;
import com.ogprover.polynomials.SymbolicVariable;
import com.ogprover.polynomials.Term;
import com.ogprover.polynomials.UXVariable;
import com.ogprover.polynomials.Variable;
import com.ogprover.prover_protocol.cp.geoobject.Segment;
import com.ogprover.utilities.io.OGPOutput;
import com.ogprover.utilities.logger.ILogger;


/**
* <dl>
* <dt><b>Class description:</b></dt>
* <dd>Class for middle point of line segment</dd>
* </dl>
* 
* @version 1.00
* @author Ivan Petrovic
*/
public class MidPoint extends SelfConditionalPoint {
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
	 * <i>Symbolic polynomial representing the condition for x coordinate</i>
	 */
	private static SymbolicPolynomial xConditionForMidPoint = null;
	/**
	 * <i>Symbolic polynomial representing the condition for y coordinate</i>
	 */
	private static SymbolicPolynomial yConditionForMidPoint = null;
	/**
	 * <i><b>Symbolic label for middle point</b></i>
	 */
	private static final String M0Label = "0";
	/**
	 * <i><b>Symbolic label for first point of line segment</b></i>
	 */
	private static final String ALabel = "A";
	/**
	 * <i><b>Symbolic label for second point of line segment</b></i>
	 */
	private static final String BLabel = "B";
	/**
	 * Segment whose midpoint is this point
	 */
	private Segment segment = null;
	
	// Static initializer of condition members
	static {
		/*
		 * x coordinate of middle point is the arithmetic mean of x coordinates of 
		 * segment's end points:
		 * 		x0 = (xA + xB)/2 which gives polynomial 2x0 - xA - xB = 0
		 */
		if (xConditionForMidPoint == null) {
			xConditionForMidPoint = new SymbolicPolynomial();
			
			// Instances of symbolic variables
			SymbolicVariable x0 = new SymbolicVariable(Variable.VAR_TYPE_SYMB_X, M0Label);
			SymbolicVariable xA = new SymbolicVariable(Variable.VAR_TYPE_SYMB_X, ALabel);
			SymbolicVariable xB = new SymbolicVariable(Variable.VAR_TYPE_SYMB_X, BLabel);
			
			// term 2*x0
			Term t = new SymbolicTerm(2);
			t.addPower(new Power(x0, 1));
			xConditionForMidPoint.addTerm(t);
			
			// term -xA
			t = new SymbolicTerm(-1);
			t.addPower(new Power(xA, 1));
			xConditionForMidPoint.addTerm(t);
			
			// term -xB
			t = new SymbolicTerm(-1);
			t.addPower(new Power(xB, 1));
			xConditionForMidPoint.addTerm(t);
		}
		
		/*
		 * y coordinate of middle point is the arithmetic mean of y coordinates of 
		 * segment's end points:
		 * 		y0 = (yA + yB)/2 which gives polynomial 2y0 - yA - yB = 0
		 */
		if (yConditionForMidPoint == null) {
			yConditionForMidPoint = new SymbolicPolynomial();
			
			// Instances of symbolic variables
			SymbolicVariable y0 = new SymbolicVariable(Variable.VAR_TYPE_SYMB_Y, M0Label);
			SymbolicVariable yA = new SymbolicVariable(Variable.VAR_TYPE_SYMB_Y, ALabel);
			SymbolicVariable yB = new SymbolicVariable(Variable.VAR_TYPE_SYMB_Y, BLabel);
			
			// term 2*y0
			Term t = new SymbolicTerm(2);
			t.addPower(new Power(y0, 1));
			yConditionForMidPoint.addTerm(t);
			
			// term -yA
			t = new SymbolicTerm(-1);
			t.addPower(new Power(yA, 1));
			yConditionForMidPoint.addTerm(t);
			
			// term -yB
			t = new SymbolicTerm(-1);
			t.addPower(new Power(yB, 1));
			yConditionForMidPoint.addTerm(t);
		}
	}

	
	
	/*
	 * ======================================================================
	 * ========================== GETTERS/SETTERS ===========================
	 * ======================================================================
	 */
	/**
	 * Method to set the segment
	 * 
	 * @param seg The segment to set
	 */
	public void setSegment(Segment seg) {
		this.segment = seg;
	}

	/**
	 * Method that retrieves the segment
	 * 
	 * @return The segment
	 */
	public Segment getSegment() {
		return segment;
	}
	
	/**
	 * Method that retrieves the type of construction
	 * 
	 * @see com.ogprover.prover_protocol.cp.geoconstruction.GeoConstruction#getConstructionType()
	 */
	@Override
	public int getConstructionType() {
		return GeoConstruction.GEOCONS_TYPE_MIDPOINT;
	}
	
	/**
	 * Method that gives the condition for x coordinate 
	 * 
	 * @see com.ogprover.prover_protocol.cp.geoconstruction.SelfConditionalPoint#getXCondition()
	 */
	@Override
	public SymbolicPolynomial getXCondition() {
		return xConditionForMidPoint;
	}

	@Override
	/**
	 * Method that gives the condition for y coordinate 
	 * 
	 * @see com.ogp.prover_protocol.cp.geoconstruction.Point#getYCondition()
	 */
	public SymbolicPolynomial getYCondition() {
		return yConditionForMidPoint;
	}
	
	
	
	/*
	 * ======================================================================
	 * ========================== CONSTRUCTORS ==============================
	 * ======================================================================
	 */
	/**
	 * Constructor method
	 * 
	 * @param pointLabel	Label of this point
	 * @param A				First segment's point
	 * @param B				Second segment's point
	 */
	public MidPoint(String pointLabel, Point A, Point B) {
		this.geoObjectLabel = pointLabel;
		if (A != null && B != null)
			this.segment = new Segment(A, B);
	}
	
	
	
	/*
	 * ======================================================================
	 * ======================= COMMON OBJECT METHODS ========================
	 * ======================================================================
	 */
	/**
	 * Clone method
	 * 
	 * @see com.ogprover.prover_protocol.cp.geoconstruction.Point#clone()
	 */
	@Override
	public Point clone() {
		Point p = new MidPoint(this.geoObjectLabel, this.segment.getFirstEndPoint(), this.segment.getSecondEndPoint());
		
		if (this.getX() != null)
			p.setX((UXVariable) this.getX().clone());
		if (this.getY() != null)
			p.setY((UXVariable) this.getY().clone());
		p.setInstanceType(this.instanceType);
		p.setPointState(this.pointState);
		p.setConsProtocol(this.consProtocol);
		p.setIndex(this.index);
		
		return p;
	}
	
	
	
	/*
	 * ======================================================================
	 * ========================== SPECIFIC METHODS ==========================
	 * ======================================================================
	 */
	/**
	 * Method to check the validity of this construction step
	 * 
	 * @see com.ogprover.prover_protocol.cp.geoconstruction.GeoConstruction#isValidConstructionStep()
	 */
	@Override
	public boolean isValidConstructionStep() {
		OGPOutput output = OpenGeoProver.settings.getOutput();
		ILogger logger = OpenGeoProver.settings.getLogger();
		
		if (!super.isValidConstructionStep())
			return false;
		
		try {
			int indexA, indexB;
		
			if (this.segment == null || this.segment.getFirstEndPoint() == null || this.segment.getSecondEndPoint() == null) {
				output.openItemWithDesc("Error: ");
				output.closeItemWithDesc("Middle point " + this.getGeoObjectLabel() + " can't be constructed since one or two segment's end points are not constructed");
				return false;
			}
		
			indexA = this.segment.getFirstEndPoint().getIndex();
			indexB = this.segment.getSecondEndPoint().getIndex();
		
			if (indexA < 0 || indexB < 0) {
				output.openItemWithDesc("Error: ");
				output.closeItemWithDesc("Middle point " + this.getGeoObjectLabel() + " can't be constructed since some of segment's end ponts is not added to construction protocol");
				return false; // some point not in construction protocol
			}
		
			boolean valid = this.index > indexA && this.index > indexB;
			
			if (!valid) {
				output.openItemWithDesc("Error: ");
				output.closeItemWithDesc("Middle point " + this.getGeoObjectLabel() + " can't be constructed since some of segment's end points is not yet constructed");
			}
			
			return valid;
		} catch (IOException e) {
			logger.error("Failed to write to output file(s).");
			output.close();
			return false;
		}
	}
	
	/**
	 * Method that transforms the construction of this point into algebraic form
	 * 
	 * @see com.ogprover.prover_protocol.cp.geoconstruction.Point#transformToAlgebraicForm()
	 */
	@Override
	public int transformToAlgebraicForm() {
		Map<String, Point> pointsMap = new HashMap<String, Point>();
		pointsMap.put(M0Label, this);
		pointsMap.put(ALabel, this.segment.getFirstEndPoint());
		pointsMap.put(BLabel, this.segment.getSecondEndPoint());
		
		return this.transformToAlgebraicForm(pointsMap);
	}

	/**
	 * @see com.ogprover.prover_protocol.cp.geoconstruction.GeoConstruction#getConstructionDesc()
	 */
	@Override
	public String getConstructionDesc() {
		StringBuilder sb = new StringBuilder();
		sb.append("Midpoint ");
		sb.append(this.geoObjectLabel);
		sb.append(" of segment ");
		sb.append(this.segment.getDescription());
		return sb.toString();
	}

}

