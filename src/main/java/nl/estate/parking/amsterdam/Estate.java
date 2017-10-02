package nl.estate.parking.amsterdam;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * Entity implementation class for Entity: Estate
 *
 */
@Entity
@Table
//@NamedQueries({ @NamedQuery(name = "Estate.finaAll", query = "SELECT e FROM estate e") })

public class Estate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8537804008150181609L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.TABLE)
	private int estateId;
	 //FEATURE OBJECT
    private String type;
    private String estateIdName;    
    //GEOMETRY OBJECT
    private String geometryType;   
    private BigDecimal latitude;
    private BigDecimal longitude;
    //PROPERTY OBJECT
    private String name;
    private String locationType;

    
    /*
     * Empty constructor for JPA 
     */
	public Estate() {
		super();
	}

	public Estate(String type, String estateIdName, String geometryType, BigDecimal latitude,
			BigDecimal longitude, String name,  String locationType ) {
		super();
		this.type = type;
		this.estateIdName = estateIdName;
		this.geometryType = geometryType;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;	
		this.locationType = locationType;	
	}

	public int getEstateId() {
		return estateId;
	}

	public void setEstateId(int estateId) {
		this.estateId = estateId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEstateIdName() {
		return estateIdName;
	}

	public void setEstateIdName(String estateIdName) {
		this.estateIdName = estateIdName;
	}

	public String getGeometryType() {
		return geometryType;
	}

	public void setGeometryType(String geometryType) {
		this.geometryType = geometryType;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
}
