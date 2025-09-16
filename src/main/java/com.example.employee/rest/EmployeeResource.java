package com.example.employee.rest;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    EmployeeService service;

    @GET
    public List<Employee> all() {
        return service.list();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Employee e = service.find(id);
        if (e == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(e).build();
    }

    @POST
    public Response create(Employee e) {
        Employee created = service.create(e);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Employee e) {
        Employee existing = service.find(id);
        if (existing == null) return Response.status(Response.Status.NOT_FOUND).build();
        e.setId(id);
        Employee updated = service.update(e);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
