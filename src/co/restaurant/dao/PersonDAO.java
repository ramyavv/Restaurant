package co.restaurant.dao;

import java.util.ArrayList;
import java.util.List;

import co.restaurant.entities.PersonVO;
import co.restaurant.exception.RestaurantException;
import co.restaurant.util.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAO {

	//get all people
	public List<PersonVO> getAllPeople()  {
		Connection con = DBConnector.getDBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<PersonVO> people = new ArrayList<PersonVO>();

		try {
			ps = con.prepareStatement("SELECT * FROM people");
			rs = ps.executeQuery();

			while (rs.next()) {
				PersonVO person = new PersonVO();
				person.setId(rs.getInt("ID"));
				person.setFirstName(rs.getString("FIRST_NAME"));
				person.setLastName(rs.getString("LAST_NAME"));
				person.setAddress1(rs.getString("ADDRESS1"));
				person.setAddress2(rs.getString("ADDRESS2"));
				person.setCity(rs.getString("CITY"));
				person.setEmail(rs.getString("EMAIL"));
				person.setPhone(rs.getString("PHONE"));
				person.setState(rs.getString("STATE"));
				person.setZip(rs.getInt("ZIP"));

				people.add(person);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RestaurantException("Error" + e.getMessage(),
					e.getCause());
		} finally {
			DBConnector.closeResources(ps, rs, con);
		}
		return people;
	}

	//get ID
	public PersonVO getPerson(String id) throws RestaurantException{

		Connection con = DBConnector.getDBConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		PersonVO person = new PersonVO();
		
		try {
			ps = con.prepareStatement("SELECT * FROM people WHERE ID=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				person.setId(rs.getInt("ID"));
				person.setFirstName(rs.getString("FIRST_NAME"));
				person.setLastName(rs.getString("LAST_NAME"));
				person.setAddress1(rs.getString("ADDRESS1"));
				person.setAddress2(rs.getString("ADDRESS2"));
				person.setCity(rs.getString("CITY"));
				person.setZip(rs.getInt("ZIP"));
				person.setState(rs.getString("STATE"));
				person.setPhone(rs.getString("PHONE"));
				person.setEmail(rs.getString("EMAIL"));
			}
			else {
				throw new RestaurantException("Person with the ID=" + id + " not found in the system.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RestaurantException("Error: " + e.getMessage(), e.getCause());
		}
		finally {
			DBConnector.closeResources(ps, rs, con);
		}
		
		return person;
	}
   //add person
	public PersonVO addPerson(PersonVO person) {
		Connection conn = DBConnector.getDBConnection();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		try{
			preStmt = conn.prepareStatement("INSERT INTO people (FIRST_NAME, LAST_NAME, EMAIL, ADDRESS1, ADDRESS2, CITY, ZIP, PHONE, STATE) VALUES (?,?,?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
	preStmt.setString(1, person.getFirstName());
	preStmt.setString(2, person.getLastName());
	preStmt.setString(3, person.getEmail());
	preStmt.setString(4, person.getAddress1());
	preStmt.setString(5, person.getAddress2());
	preStmt.setString(6, person.getCity());
	preStmt.setInt(7, person.getZip());
	preStmt.setString(8, person.getPhone());
	preStmt.setString(9, person.getState());

	preStmt.executeUpdate();	
	rs = preStmt.getGeneratedKeys();

	if (rs.next()) {
		person.setId(rs.getInt(1));
	}	
		} catch (SQLException e) {
			System.err.println("Error " + e.getMessage());
			e.getStackTrace();
			throw new RestaurantException("Error: " + e.getMessage(), e.getCause());
		} finally {
			DBConnector.closeResources(preStmt, rs, conn);
		}

		return person;
		
	}
//edit person
	public boolean editPerson(PersonVO person) {
		return true;
	}
//delete person
	public boolean deletePerson(int id) {
		return true;
	}

	/*
	 * List <PersonVO> getAllPeople() addPerson(PersonVO) getPerson(id)
	 * editPerson(PersonVO) deletePerson(id)
	 */

}