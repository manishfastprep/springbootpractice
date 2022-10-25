package com.example.demo.model;

import java.util.Objects;

public class Author
{
	public Author(long id, String firstName, String lastName)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	private long id;
	private String firstName;
	private String lastName;
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
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
	public int hashCode()
	{
		return Objects.hash(firstName, id, lastName);
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName);
	}
	
}
