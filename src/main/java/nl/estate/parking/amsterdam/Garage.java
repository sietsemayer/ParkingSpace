package nl.estate.parking.amsterdam;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Garage
 *
 */
@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Garage extends Estate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8537804008150181609L;

	// @Id
	// @GeneratedValue(strategy = GenerationType.TABLE)
	// private int garageId;
	// PROPERTY OBJECT
	private String pubDate;
	private String status;
	private int freeSpaceShort;
	private int freeSpaceLong;
	private int shortCapacity;
	private int longCapacity;

	/*
	 * Empty constructor for JPA
	 */
	public Garage() {
		super();
	}

	/**
	 * @param type
	 * @param estateIdName
	 * @param geometryType
	 * @param latitude
	 * @param longitude
	 * @param name
	 * @param locationType
	 * @param garageId
	 * @param pubDate
	 * @param status
	 * @param freeSpaceShort
	 * @param freeSpaceLong
	 * @param shortCapacity
	 * @param longCapacity
	 */
	public Garage(String type, String estateIdName, String geometryType, BigDecimal latitude, BigDecimal longitude,
			String name, String locationType, String pubDate, String status, int freeSpaceShort, int freeSpaceLong,
			int shortCapacity, int longCapacity) {
		super(type, estateIdName, geometryType, latitude, longitude, name, locationType);
		this.pubDate = pubDate;
		this.status = status;
		this.freeSpaceShort = freeSpaceShort;
		this.freeSpaceLong = freeSpaceLong;
		this.shortCapacity = shortCapacity;
		this.longCapacity = longCapacity;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getFreeSpaceShort() {
		return freeSpaceShort;
	}

	public void setFreeSpaceShort(int freeSpaceShort) {
		this.freeSpaceShort = freeSpaceShort;
	}

	public int getFreeSpaceLong() {
		return freeSpaceLong;
	}

	public void setFreeSpaceLong(int freeSpaceLong) {
		this.freeSpaceLong = freeSpaceLong;
	}

	public int getShortCapacity() {
		return shortCapacity;
	}

	public void setShortCapacity(int shortCapacity) {
		this.shortCapacity = shortCapacity;
	}

	public int getLongCapacity() {
		return longCapacity;
	}

	public void setLongCapacity(int longCapacity) {
		this.longCapacity = longCapacity;
	}
}
