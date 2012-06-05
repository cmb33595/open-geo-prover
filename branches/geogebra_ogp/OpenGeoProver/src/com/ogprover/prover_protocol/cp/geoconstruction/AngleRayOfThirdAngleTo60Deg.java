/* 
 * DISCLAIMER PLACEHOLDER 
 */

package com.ogprover.prover_protocol.cp.geoconstruction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.ogprover.main.OGPConstants;
import com.ogprover.main.OpenGeoProver;
import com.ogprover.polynomials.Power;
import com.ogprover.polynomials.SymbolicPolynomial;
import com.ogprover.polynomials.SymbolicTerm;
import com.ogprover.polynomials.SymbolicVariable;
import com.ogprover.polynomials.Variable;
import com.ogprover.polynomials.XPolynomial;
import com.ogprover.prover_protocol.cp.auxiliary.GeneralizedAngleTangent;
import com.ogprover.prover_protocol.cp.auxiliary.PointSetRelationshipManager;
import com.ogprover.prover_protocol.cp.geoobject.Angle;
import com.ogprover.utilities.io.OGPOutput;
import com.ogprover.utilities.logger.ILogger;

/**
* <dl>
* <dt><b>Class description:</b></dt>
* <dd>Class for construction of second angle ray for given 
*     first ray of angle which is third angle to 60 degrees</dd>
* </dl>
* 
* @version 1.00
* @author Ivan Petrovic
*/
public class AngleRayOfThirdAngleTo60Deg extends Line {
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
	
	// This line is angle ray OB of angle <AOB which is congruent to angle <A1O1B1
	/**
	 * <i><b>Symbolic label for generic point from this line</b></i>
	 */
	private static final String M0Label = "0"; // zero
	/**
	 * <i><b>Symbolic label for given angle vertex</b></i>
	 */
	private static final String OLabel = "O"; // 'O' letter
	/**
	 * <i><b>Symbolic label for given point from first ray of angle</b></i>
	 */
	private static final String ALabel = "A";
	/**
	 * <i><b>Symbolic label for vertex of first angle</b></i>
	 */
	private static final String O1Label = "O1"; // 'O' letter
	/**
	 * <i><b>Symbolic label for point from first ray of first angle</b></i>
	 */
	private static final String A1Label = "A1";
	/**
	 * <i><b>Symbolic label for point from second ray of first angle</b></i>
	 */
	private static final String B1Label = "B1";
	/**
	 * <i><b>Symbolic label for vertex of second angle</b></i>
	 */
	private static final String O2Label = "O2"; // 'O' letter
	/**
	 * <i><b>Symbolic label for point from first ray of second angle</b></i>
	 */
	private static final String A2Label = "A2";
	/**
	 * <i><b>Symbolic label for point from second ray of second angle</b></i>
	 */
	private static final String B2Label = "B2";
	/**
	 * First angle
	 */
	private Angle firstAngle;
	/**
	 * Second angle
	 */
	private Angle secondAngle;
	/**
	 * First ray point
	 */
	private Point firstRayPoint;
	/**
	 * Angle of 60 degrees from construction protocol
	 */
	private AngleOf60Deg angle60Deg;
	
	
	
	
	/*
	 * ======================================================================
	 * ========================== GETTERS/SETTERS ===========================
	 * ======================================================================
	 */
	/**
	 * Method that gives the type of this construction
	 * 
	 * @see com.ogprover.prover_protocol.cp.geoconstruction.GeoConstruction#getConstructionType()
	 */
	@Override
	public int getConstructionType() {
		return GeoConstruction.GEOCONS_TYPE_ANGLE_RAY_TO_60_DEG;
	}
	
	/**
	 * @param angle the firstAngle to set
	 */
	public void setFirstAngle(Angle angle) {
		this.firstAngle = angle;
	}

	/**
	 * @return the firstAngle
	 */
	public Angle getFirstAngle() {
		return firstAngle;
	}
	
	/**
	 * @param angle the secondAngle to set
	 */
	public void setSecondAngle(Angle angle) {
		this.secondAngle = angle;
	}

	/**
	 * @return the secondAngle
	 */
	public Angle getSecondAngle() {
		return secondAngle;
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
	 * @param angle60Deg the angle60Deg to set
	 */
	public void setAngle60Deg(AngleOf60Deg angle60Deg) {
		this.angle60Deg = angle60Deg;
	}

	/**
	 * @return the angle60Deg
	 */
	public AngleOf60Deg getAngle60Deg() {
		return angle60Deg;
	}

	/**
	 * Method that retrieves symbolic polynomial that represents the condition
	 * that some point belongs to this angle ray.
	 * 
	 * @see com.ogprover.prover_protocol.cp.geoconstruction.Line#getCondition()
	 */
	public SymbolicPolynomial getCondition() {
		SymbolicPolynomial conditionForAngRayOfThirdAngle;
		
		ArrayList<SymbolicPolynomial> tan = GeneralizedAngleTangent.getSubstitutedConditionForTangentOfSumOfThreeAngles(A1Label, O1Label, B1Label, A2Label, O2Label, B2Label, ALabel, OLabel, M0Label);
		
		conditionForAngRayOfThirdAngle = tan.get(GeneralizedAngleTangent.TANGENT_NUMERATOR);
		SymbolicTerm angTerm = new SymbolicTerm(1);
		angTerm.addPower(new Power(new SymbolicVariable(Variable.VAR_TYPE_SYMB_X, this.angle60Deg.getParametricPoint().getGeoObjectLabel()), 1));
		conditionForAngRayOfThirdAngle.subtractPolynomial(tan.get(GeneralizedAngleTangent.TANGENT_DENOMINATOR).multiplyByTerm(angTerm));
		
		return conditionForAngRayOfThirdAngle;
	}
	
	
	
	/*
	 * ======================================================================
	 * ========================== CONSTRUCTORS ==============================
	 * ======================================================================
	 */
	/**
	 * Constructor method
	 * 
	 * @param lineLabel					Label of this line
	 * @param firstRayPoint				Point from first ray of angle
	 * @param vertex					Vertex of angle
	 * @param firstRayPointFirstAng		Point from first ray of first angle
	 * @param vertexFirstAng			Vertex of first angle
	 * @param secondRayPointFirstAng	Point from second ray of first angle
	 * @param firstRayPointSecondAng	Point from first ray of second angle
	 * @param vertexSecondAng			Vertex of second angle
	 * @param secondRayPointSecondAng	Point from second ray of second angle
	 */
	public AngleRayOfThirdAngleTo60Deg(String lineLabel, Point firstRayPoint, Point vertex, 
					Point firstRayPointFirstAng, Point vertexFirstAng, Point secondRayPointFirstAng,
					Point firstRayPointSecondAng, Point vertexSecondAng, Point secondRayPointSecondAng,
					AngleOf60Deg angle60Deg) {
		this.geoObjectLabel = lineLabel;
		this.points = new Vector<Point>();
		if (vertex != null)
			this.points.add(vertex); // add at the end - vertex is the first point of this line
		this.firstAngle = new Angle(firstRayPointFirstAng, vertexFirstAng, secondRayPointFirstAng);
		this.secondAngle = new Angle(firstRayPointSecondAng, vertexSecondAng, secondRayPointSecondAng);
		this.firstRayPoint = firstRayPoint;
		this.angle60Deg = angle60Deg;
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
			// Angle ray is valid if all necessary points have been already constructed 
			Point vertex = this.points.get(0);
		
			// All points must exist
			if (vertex == null || this.firstRayPoint == null || this.firstAngle == null || this.secondAngle == null || this.angle60Deg == null ||
				this.firstAngle.getFirstRayPoint() == null || this.firstAngle.getVertex() == null || this.firstAngle.getSecondRayPoint() == null ||
				this.secondAngle.getFirstRayPoint() == null || this.secondAngle.getVertex() == null || this.secondAngle.getSecondRayPoint() == null) {
				output.openItemWithDesc("Error: ");
				output.closeItemWithDesc("Cannot construct angle ray " + this.getGeoObjectLabel() + " because not all necessary points have been constructed.");
				return false;
			}
		
			int indexO = vertex.getIndex();
			int indexA = this.firstRayPoint.getIndex();
			int indexO1 = this.firstAngle.getVertex().getIndex();
			int indexA1 = this.firstAngle.getFirstRayPoint().getIndex();
			int indexB1 = this.firstAngle.getSecondRayPoint().getIndex();
			int indexO2 = this.secondAngle.getVertex().getIndex();
			int indexA2 = this.secondAngle.getFirstRayPoint().getIndex();
			int indexB2 = this.secondAngle.getSecondRayPoint().getIndex();
			int indexang = this.angle60Deg.getIndex();
		
			if (indexO < 0 || indexA < 0 || 
				indexO1 < 0 || indexA1 < 0  || indexB1 < 0|| 
				indexO2 < 0 || indexA2 < 0  || indexB2 < 0 || 
				indexang < 0) {
				output.openItemWithDesc("Error: ");
				output.closeItemWithDesc("Cannot construct angle ray " + this.getGeoObjectLabel() + " because some of necessary points is not added to construction protocol.");
				return false; // some object is not in construction protocol
			}
		
			if (indexO >= this.index || indexA >= this.index || 
				indexO1 >= this.index || indexA1 >= this.index || indexB1 >= this.index || 
				indexO2 >= this.index || indexA2 >= this.index || indexB2 >= this.index || 
				indexang >= this.index) {
				output.openItemWithDesc("Error: ");
				output.closeItemWithDesc("Cannot construct angle ray " + this.getGeoObjectLabel() + " because some of necessary points is not yet constructed.");
				return false; // some object is not constructed before this line
			}
		
			return true;
		} catch (IOException e) {
			logger.error("Failed to write to output file(s).");
			output.close();
			return false;
		}
	}

	/**
	 * Method for finding best points for instantiation of condition
	 * 
	 * @see com.ogprover.prover_protocol.cp.geoconstruction.Line#findBestPointsForInstantation(com.ogprover.prover_protocol.cp.auxiliary.PointSetRelationshipManager)
	 */
	@Override
	public int findBestPointsForInstantation(PointSetRelationshipManager manager) {
		ILogger logger = OpenGeoProver.settings.getLogger();
		
		// First call method from superclass - it implements default behavior considering
		// this line as plain line through two points
		super.findBestPointsForInstantation(manager);
		
		// in case of error exit
		if (manager.isErrorFlag()) {
			logger.error("Failed in findBestPointsForInstantation() method from superclass");
			return OGPConstants.ERR_CODE_GENERAL;
		}
		
		if (manager.getPoint().getPointState() == Point.POINT_STATE_RENAMED)
			return OGPConstants.RET_CODE_SUCCESS;
		
		// NOTE: This method is used to find best elements for process of transformation
		// in algebraic form. It is implemented by calling same methods like in
		// final transformation, but without printing of results to output reports.
		// Also, in order to be able to repeat the good transformation later in
		// final processing, it is necessary to cancel any result i.e. if a polynomial
		// is added to system of polynomials, it has to be removed, and if coordinates
		// are renamed, they have to be back to previous values.
		
		// turn the state of point P to UNCHANGED so it can be reset 
		// according to actions taken on it in this method
		manager.getPoint().setPointState(Point.POINT_STATE_UNCHANGED);
		manager.setCondition(this.getCondition());
		
		// instantiate the condition from this line using its specific condition
		// Note: order of points in angle cannot be changed because it would be different angle
		// i.e here A is always point from first ray and B from second - they cannot be swapped
		Point P = manager.getPoint();
		Map<String, Point> pointsMap = new HashMap<String, Point>(); // collection with current elements
		pointsMap.put(M0Label, P);
		pointsMap.put(OLabel, this.points.get(0));
		pointsMap.put(ALabel, this.firstRayPoint);
		pointsMap.put(O1Label, this.firstAngle.getVertex());
		pointsMap.put(A1Label, this.firstAngle.getFirstRayPoint());
		pointsMap.put(B1Label, this.firstAngle.getSecondRayPoint());
		pointsMap.put(O2Label, this.secondAngle.getVertex());
		pointsMap.put(A2Label, this.secondAngle.getFirstRayPoint());
		pointsMap.put(B2Label, this.secondAngle.getSecondRayPoint());
		pointsMap.put(this.angle60Deg.getParametricPoint().getGeoObjectLabel(), this.angle60Deg.getParametricPoint());
		
		manager.processPointsAndCondition(pointsMap);
		
		if (manager.isErrorFlag()) {
			logger.error("findBestPointsForInstantation() method failed in processing condition for angle ray");
			return OGPConstants.ERR_CODE_GENERAL;
		}

		return OGPConstants.RET_CODE_SUCCESS;
	}

	/**
	 * @see com.ogprover.prover_protocol.cp.geoconstruction.SetOfPoints#instantiateConditionFromBasicElements(com.ogprover.prover_protocol.cp.geoconstruction.Point)
	 */
	public XPolynomial instantiateConditionFromBasicElements(Point P) {
		Map<String, Point> pointsMap = new HashMap<String, Point>();
		pointsMap.put(M0Label, P);
		pointsMap.put(OLabel, this.points.get(0));
		pointsMap.put(ALabel, this.firstRayPoint);
		pointsMap.put(O1Label, this.firstAngle.getVertex());
		pointsMap.put(A1Label, this.firstAngle.getFirstRayPoint());
		pointsMap.put(B1Label, this.firstAngle.getSecondRayPoint());
		pointsMap.put(O2Label, this.secondAngle.getVertex());
		pointsMap.put(A2Label, this.secondAngle.getFirstRayPoint());
		pointsMap.put(B2Label, this.secondAngle.getSecondRayPoint());
		pointsMap.put(this.angle60Deg.getParametricPoint().getGeoObjectLabel(), this.angle60Deg.getParametricPoint());
		
		return this.instantiateCondition(pointsMap); // don't reduce polynomial
	}

	/**
	 * @see com.ogprover.prover_protocol.cp.geoconstruction.Line#getAllPossibleConditionsWithMappings()
	 */
	@Override
	public Map<SymbolicPolynomial, ArrayList<Map<String, Point>>> getAllPossibleConditionsWithMappings() {
		Map<SymbolicPolynomial, ArrayList<Map<String, Point>>> retMap = super.getAllPossibleConditionsWithMappings();
		
		ArrayList<Map<String, Point>> allMappings = new ArrayList<Map<String, Point>>();
		Map<String, Point> pointsMap = new HashMap<String, Point>();
		// there is only one possibility since we cannot change the order of
		// points from angle rays because that will give different oriented angle
		pointsMap.put(OLabel, this.points.get(0));
		pointsMap.put(ALabel, this.firstRayPoint);
		pointsMap.put(O1Label, this.firstAngle.getVertex());
		pointsMap.put(A1Label, this.firstAngle.getFirstRayPoint());
		pointsMap.put(B1Label, this.firstAngle.getSecondRayPoint());
		pointsMap.put(O2Label, this.secondAngle.getVertex());
		pointsMap.put(A2Label, this.secondAngle.getFirstRayPoint());
		pointsMap.put(B2Label, this.secondAngle.getSecondRayPoint());
		pointsMap.put(this.angle60Deg.getParametricPoint().getGeoObjectLabel(), this.angle60Deg.getParametricPoint());
		allMappings.add(pointsMap);
		
		retMap.put((SymbolicPolynomial) this.getCondition().clone(), allMappings);
		return retMap;
	}

	/**
	 * @see com.ogprover.prover_protocol.cp.geoconstruction.GeoConstruction#getConstructionDesc()
	 */
	@Override
	public String getConstructionDesc() {
		StringBuilder sb = new StringBuilder();
		sb.append("Angle ray ");
		sb.append(this.geoObjectLabel);
		sb.append(" of angle with vertex ");
		sb.append(this.points.get(0).getGeoObjectLabel());
		sb.append(" and point ");
		sb.append(this.firstRayPoint.getGeoObjectLabel());
		sb.append(" from first ray, which is third angle to 60 degrees for angles ");
		sb.append(this.firstAngle.getDescription());
		sb.append(" and ");
		sb.append(this.secondAngle.getDescription());
		return sb.toString();
	}

	/**
	 * @see com.ogprover.prover_protocol.cp.geoconstruction.GeoConstruction#getInputLabels()
	 */
	@Override
	public String[] getInputLabels() {
		String[] inputLabels = new String[8];
		inputLabels[0] = this.firstRayPoint.getGeoObjectLabel();
		inputLabels[1] = this.points.get(0).getGeoObjectLabel();
		inputLabels[2] = this.firstAngle.getFirstRayPoint().getGeoObjectLabel();
		inputLabels[3] = this.firstAngle.getVertex().getGeoObjectLabel();
		inputLabels[4] = this.firstAngle.getSecondRayPoint().getGeoObjectLabel();
		inputLabels[5] = this.secondAngle.getFirstRayPoint().getGeoObjectLabel();
		inputLabels[6] = this.secondAngle.getVertex().getGeoObjectLabel();
		inputLabels[7] = this.secondAngle.getSecondRayPoint().getGeoObjectLabel();
		return inputLabels;
	}
}


