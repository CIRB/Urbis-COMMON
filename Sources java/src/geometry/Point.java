package geometry;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Point extends Geometry {
	
	private double x;
	private double y;
	
	public Point()
	{
		this.setType("point");
	}
	
	public Point(JSONObject jsonPoint) throws JSONException
	{
		this.setType("point");
		this.x = jsonPoint.getDouble("x");
		this.y = jsonPoint.getDouble("y");
	}
	
	public Point(String wktPoint)
	{
		this.setType("point");
		String[] xy = wktPoint.split(" ");

		this.x=Double.parseDouble(xy[0]);
		this.y= Double.parseDouble(xy[1]);
	}
	
	@Override
	public String sdoGeometry()
	{
		return "mdsys.sdo_geometry(2001,NULL,SDO_POINT_TYPE("+this.x+","+this.y+", NULL), NULL, NULL)";
	}
	
}
