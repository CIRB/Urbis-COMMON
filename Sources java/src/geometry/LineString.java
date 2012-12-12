package geometry;

import org.codehaus.jettison.json.JSONObject;

public class LineString extends Geometry {
	
	public LineString(){
		this.setType("LineString");
	}
	
	public LineString(String wktLine)
	{
		this.setType("LineString");
	}

	@Override
	public String toSdoGeometry() {
		return null;
	}

	@Override
	public JSONObject toGeoJson() {
		// TODO Auto-generated method stub
		return null;
	}
}
