package geometry;

import org.codehaus.jettison.json.JSONObject;

public class Polygon extends Geometry {
	
	public Polygon()
	{
		this.setType("Polygon");
	}
	
	public Polygon(String wktPolygon)
	{
		this.setType("Polygon");
	}

	@Override
	public String toSdoGeometry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject toGeoJson() {
		// TODO Auto-generated method stub
		return null;
	}
}
