package com.blanchard.musicstore.datatypes;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Stores the info for a <code>Customer</code>'s name
 */
@Embeddable
public class CustomerName
{
	@Column(name="first_name")
	private String firstName;
	@Column(name="middle_initial")
	private String middleInitial;
	@Column(name="last_name")
	private String lastName;

	public CustomerName() {}
	
	public CustomerName(String firstName, String middleInitial, String lastName)
	{
		super();
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getMiddleInitial()
	{
		return middleInitial;
	}
	
	public void setMiddleInitial(String middleInitial) 
	{
		this.middleInitial = middleInitial;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	@Override
	public String toString() 
	{
		return firstName + " " + middleInitial + " " + lastName;
	}	
}
