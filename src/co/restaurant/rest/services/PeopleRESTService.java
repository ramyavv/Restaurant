package co.restaurant.rest.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.restaurant.dao.PersonDAO;
import co.restaurant.entities.PersonVO;
import co.restaurant.exception.RestaurantException;
import co.restaurant.util.RestaurantResponse;

@Path("/people")
public class PeopleRESTService {

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public RestaurantResponse getAllPeople() {

		PersonDAO dao = new PersonDAO();
		RestaurantResponse resp = new RestaurantResponse();
		try {
			List<PersonVO> list = dao.getAllPeople();
			resp.setStatus("SUCCESS");
			resp.setData(list);
		} catch (RestaurantException e) {
			resp.setStatus("ERROR");
			resp.setMsg(e.getMessage());
			// TODO Auto-generated catch block
		}
		return resp;

	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public RestaurantResponse addPerson(PersonVO person) {
		
		

			PersonDAO dao = new PersonDAO();
			RestaurantResponse resp = new RestaurantResponse();
			try {
				person = dao.addPerson(person);
				resp.setStatus("SUCCESS");
				resp.setData(person);
			} catch (RestaurantException e) {
				resp.setStatus("ERROR");
				resp.setMsg(e.getMessage());
				// TODO Auto-generated catch block
			}
			return resp;
		

	}
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public RestaurantResponse getPerson(@PathParam("id") String id) {
		PersonDAO dao = new PersonDAO();
		RestaurantResponse resp = new RestaurantResponse();
		
		
		return resp;
	}
	
	/*
	 * 
	 * deletePerson()  editPerson()
	 */

}
