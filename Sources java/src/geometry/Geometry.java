package geometry;

import org.codehaus.jettison.json.JSONObject;

public abstract class Geometry {
	private String type;
	
	public Geometry() {	}
	
	abstract public String toSdoGeometry();
	abstract public JSONObject toGeoJson();
	
	public static Geometry fromJson(JSONObject jsonGeom) throws Exception
	{
		String type = jsonGeom.getString("type");
		
		if(type.equalsIgnoreCase("Point"))
			return new Point(jsonGeom);
		else if(type.equalsIgnoreCase("LineString"))
			return new LineString();
		else if(type.equalsIgnoreCase("Polygon"))
			return new Polygon();
		else
			throw new Exception("Unknow geometry type: "+type);
	}
	
	public static Geometry fromWkt(String geomWkt) throws Exception
	{
		if(geomWkt == null) 
			throw new Exception("WKT NULL");
		if(geomWkt.isEmpty())
			throw new Exception("WKT EMPTY");
		
		String type="";
		String ordinnates="";
		
		boolean typeFound = false;
		
		for(int c=0;c<geomWkt.length();c++)
		{
			String value= geomWkt.substring(c,c+1);
			if(!typeFound  && value.equals("("))
				typeFound = true;
			
			if(!typeFound)
				type+=value;
			else
				ordinnates+=value;
		}
		
		type = type.trim();
		ordinnates = ordinnates.substring(1,ordinnates.length()-1);
		
		if(type.equals("POINT"))
			return new Point(ordinnates);
		else if(type.equals("LINESTRING"))
			return new LineString(ordinnates);
		else if(type.equals("POLYGON"))
			return new Polygon(ordinnates);
		else
			throw new Exception("Unknow geometry type: "+type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
