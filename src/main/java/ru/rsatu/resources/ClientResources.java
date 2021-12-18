package ru.rsatu.resources;

import ru.rsatu.service.ClientService;
import ru.rsatu.pojo.Clients;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/client")
public class ClientResources {
    @Inject
    ClientService sr;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getClients")
    public Response getClients(){
        return Response.ok(sr.getClients()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getClientById")
    public Response getClientById(@QueryParam("id") Long id){
        return Response.ok(sr.getClientById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/insertClient")
    public Response insertClient(Clients cl){
        return Response.ok(sr.insertClient(cl)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateClient")
    public Response updateClient(Clients cl){
        return Response.ok(sr.updateClient(cl)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteClient")
    public Response deleteClient(Clients cl){
        sr.deleteClient(cl);
        return Response.ok().build();
    }
}
