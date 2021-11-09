package com.cadastro.interfaces.resource;

import com.cadastro.application.dto.ClienteDTO;
import com.cadastro.domain.model.Cliente;
import com.cadastro.infraestructure.repository.ClienteRepository;
import com.cadastro.interfaces.dto.ClienteFormDTO;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/clientes")
public class ClienteResource {

    @Inject
    ClienteRepository repository;

    //listAll
    @GET
    public List<ClienteDTO> list() {
        return ClienteDTO.converterLista(repository.listAll());
    }

    @GET
    @Path("/{id}")
    public Response getOne(@PathParam Long id) {
        Optional<Cliente> cliente = repository.findByIdOptional(id);
        if(cliente.isPresent())
            return Response.ok(cliente.get()).status(200).build();
        return Response.ok().status(404).build();
    }

    @POST
    @Transactional
    public Response create(@Valid ClienteFormDTO formDTO) {
        repository.persist(formDTO.converter());
        return Response.ok().status(201).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam Long id, @Valid ClienteFormDTO formDTO) {
        Optional<Cliente> cliente = repository.findByIdOptional(id);
        if (cliente.isPresent()) {
            formDTO.atualizar(cliente.get());
            return Response.ok(formDTO).status(200).build();
        }
        return Response.ok(formDTO).status(404).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(Long id) {
        repository.deleteById(id);
        return Response.ok().status(202).build();
    }

}
