package rest;

import bo.BOProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by root on 12.12.15.
 */
@Component
@Path("/product")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(BOProduct product) {
        if (product == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        productService.saveProduct(product);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        if (id.longValue() < 0 || id == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        BOProduct product = productService.getById(id);
        return Response.ok().entity(product).build();
    }

    @GET
    @Path("/barcode/{barcode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByBarcode(@PathParam("barcode") Long barcode) {
        if (barcode.longValue() < 0 || barcode == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        BOProduct product = productService.getBuBarcode(barcode);
        return Response.ok().entity(product).build();
    }

}
