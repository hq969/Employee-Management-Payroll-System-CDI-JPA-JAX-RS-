package com.example.employee.rest;

import com.example.employee.entity.Payroll;
import com.example.employee.service.PayrollService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

@Path("/payrolls")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PayrollResource {

    @Inject
    PayrollService service;

    @GET
    public List<Payroll> all() { return service.list(); }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Payroll p = service.find(id);
        if (p == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(p).build();
    }

    @POST
    @Path("generate")
    public Response generate(PayrollRequest req) {
        Payroll p = service.generatePayroll(req.employeeId, req.payDate);
        return Response.status(Response.Status.CREATED).entity(p).build();
    }

    public static class PayrollRequest {
        public Long employeeId;
        public LocalDate payDate;
    }
}
