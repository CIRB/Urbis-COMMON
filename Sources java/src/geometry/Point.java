package geometry;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Point extends Geometry {
	
	private double x;
	private double y;
	
	public Point()
	{
		this.setType("Point");
	}
	
	public Point(JSONObject jsonPoint) throws JSONException
	{
		this.setType("Point");
		JSONArray coordinates = jsonPoint.getJSONArray("coordinates");
		this.x = (Double) coordinates.get(0);
		this.y = (Double) coordinates.get(1);
	}
	
	public Point(String wktPoint)
	{
		this.setType("Point");
		String[] xy = wktPoint.split(" ");

		this.x=Double.parseDouble(xy[0]);
		this.y= Double.parseDouble(xy[1]);
	}
	
	@Override
	public String toSdoGeometry()
	{
		return "mdsys.sdo_geometry(2001,NULL,SDO_POINT_TYPE("+this.x+","+this.y+", NULL), NULL, NULL)";
	}

	@Override
	public JSONObject toGeoJson() {
		return null;
	}
	
}
