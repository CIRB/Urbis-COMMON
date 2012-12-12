package geometry;

import org.codehaus.jettison.json.JSONObject;

public abstract class Geometry {
	private String type;
	
	public Geometry() {	}
	
	public static Geometry createGeometryFromJson(JSONObject jsonGeom) throws Exception
	{
		String type = jsonGeom.getString("type");
		if(type.equalsIgnoreCase("POINT"))
		{
			Point point = new Point(jsonGeom);
			return point;
		}
		else if(type.equalsIgnoreCase("LINE"))
		{
			return null;
		}
		else
		{
			throw new Exception("Unknow geometry type: "+type);
		}
	}
	
	/*public static Geometry createGeometry(String geomWkt) throws Exception
	{

	}*/

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String sdoGeometry(){
		return "";
	}
}
