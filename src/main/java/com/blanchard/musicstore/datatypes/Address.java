package com.blanchard.musicstore.datatypes;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Stores the info for a <code>Customer</code>'s address
 */
@Embeddable
public class Address 
{
	@Column(name="street_address")
	private String streetAddress;
	@Column(name="street_name")
	private String streetName;
	@Column(name="town")
	private String town;
	@Column(name="state")
	private String state;
	@Column(name="zip_code")
	private int zipCode;
	
	public Address() {}
	
	public Address(String streetAddress, String streetName, String town, String state, int zipCode)
	{
		super();
		this.streetAddress = streetAddress;
		this.streetName = streetName;
		this.town = town;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String getStreetAddress()
	{
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress)
	{
		this.streetAddress = streetAddress;
	}

	public String getStreetName()
	{
		return streetName;
	}

	public void setStreetName(String streetName)
	{
		this.streetName = streetName;
	}

	public String getTown()
	{
		return town;
	}

	public void setTown(String town)
	{
		this.town = town;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public int getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(int zipCode)
	{
		this.zipCode = zipCode;
	}

	@Override
	public String toString()
	{
		return streetAddress + " " + streetName + " " + town + " " + state + " " + zipCode;
	}
}
