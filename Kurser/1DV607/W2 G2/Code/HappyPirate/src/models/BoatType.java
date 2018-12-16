package models;
/*
 * I actually asked my sail club and they said Canoes, even
 * the big ones, go to the dry deck. Katamarans, in other hand
 * are too complicated to move around and get their own berth.
 * */
public enum BoatType {
	SAILBOAT (1), 
	MOTORBOAT (2), 
	KATAMARAN (3),
	OTHER (4);
	
	private final int typeCode;
	BoatType[] types = new BoatType[4];
	
	
	
	private BoatType (int typeCode) {
		this.typeCode = typeCode;
	}

	public int getTypeCode() {
		return typeCode;
	}
	
	public static BoatType getTypeById(int id) {
		BoatType output = null;
		for (BoatType type : BoatType.values()) {
			if (type.getTypeCode()  == id)
				output = type;					
		}		
		return output;
	}
}
