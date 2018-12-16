package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Boat")
@XmlType(propOrder = {"Type", "Length", "Name", "mmsi"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Boat {
	
	@XmlElement(name = "Type")
	private BoatType Type;
	
	@XmlElement(name = "Length")
	private double Length;
	
	@XmlElement(name = "Name")
	private String Name; 
	
	/*Maritime Mobile Service Identity*/
	@XmlElement(name = "mmsi")
	private String mmsi;

	
	public Boat (BoatType boatType, double boatLength, String boatName, String boatMmsi) {
		Type = boatType;
		Length = boatLength;
		Name = boatName;
		mmsi = boatMmsi;
	}
	
	public Boat () {}
	
	public void update(Boat boat) {
		this.Type = boat.Type;
		this.Length = boat.Length;
		this.Name = boat.Name;
	}
	
	public BoatType getType() {
		return Type;
	}
	public double getLength() {
		return Length;
	}
	public String getName() {
		return Name;
	}
	public String getMMSI() {
		return mmsi;
	}

}
