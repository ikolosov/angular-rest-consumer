package com.ikolosov.rest.angular.resource;

import com.ikolosov.rest.angular.model.Item;
import com.ikolosov.rest.angular.service.ItemService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/item")
@RequestScoped
public class ItemResource {

	@Inject
	private ItemService itemService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Item> getItems() {
		return itemService.getItems();
	}

	@POST
	@Consumes("application/x-www-form-urlencoded")
	public Response addItem(@FormParam("name") String name,
							@FormParam("flag") boolean flag) {
		itemService.addItem(new Item(name, flag));
		return Response.ok().build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteItem(@PathParam("id") int id) {
		itemService.deleteItem(id);
		return Response.ok().build();
	}
}
