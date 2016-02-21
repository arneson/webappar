package edu.gu.hajo.wss;

import edu.gu.hajo.wss.core.SingletonShop;
import edu.chl.hajo.shop.core.IShop;
import edu.chl.hajo.shop.core.Product;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service connection to the ProductCatalogue (like an Adapter) 
 * We always use Response as return value (probably easier to modify)
 * 
*          ***  A LOT TO DO HERE ***
 *
 * @author hajo
 */
@Path("products") // Leading trailing slash doesn't matter, see web.xml
public class ProductCatalogueResource {

    // Provides access to application and request URI information. 
    // Relative URIs are relative to the base URI of the application
    @Context
    private UriInfo uriInfo;
    private final IShop shop = SingletonShop.INSTANCE.getShop();

    //find
    @GET
    @Path("{id: \\d+}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Long id,
            @Context Request request) {
        Product p = shop.getProductCatalogue().find(id);
        if (p != null) {
            return Response.ok(new ProductWrapper(p)).build(); // 200
        } else {
            return Response.noContent().build();  // 204
        }
    }
    //findAll
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll(@Context Request request) {
        ArrayList<ProductWrapper> productWrappers = new ArrayList<ProductWrapper>();
        for (Product p:shop.getProductCatalogue().findAll()) {
            productWrappers.add(new ProductWrapper(p));
        }
        GenericEntity<Collection<ProductWrapper>> ge = new GenericEntity<Collection<ProductWrapper>>(productWrappers){};
        if (productWrappers.size()>-1) {
            return Response.ok(ge).build(); // 200
        } else {
            return Response.noContent().build();  // 204
        }
    }
    //delete
    @DELETE
    @Path("{id: \\d+}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") Long id,
                         @Context Request request) {
        //to be able to check if exists
        Product p = shop.getProductCatalogue().find(id);
        if (p != null) {
            shop.getProductCatalogue().delete(id);
            return Response.ok(new ProductWrapper(p)).build(); // 200
        } else {
            return Response.noContent().build();  // 204
        }
    }

    //create
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response create(JsonObject obj,
                         @Context Request request) {
        String name = obj.getString("name");
        Double price = obj.getJsonNumber("price").doubleValue();
        Product p = new Product(name,price);
        shop.getProductCatalogue().create(p);
        if (p != null) {
            return Response.ok(new ProductWrapper(p)).build(); // 200
        } else {
            return Response.noContent().build();  // 204
        }
    }

    //update
   @PUT
   @Path("{id: \\d+}")
   @Produces({MediaType.APPLICATION_JSON})
   @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
   public Response update(@PathParam("id") Long id,
                          JsonObject obj,@Context Request request) {
       String name = obj.getString("name");
       Double price = obj.getJsonNumber("price").doubleValue();
       Product p = new Product(id, name, price);
       shop.getProductCatalogue().update(p);
       if (p != null) {
           return Response.ok(new ProductWrapper(p)).build(); // 200
       } else {
           return Response.noContent().build();  // 204
       }
   }

    //findRange
    @GET
    @Path("range")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findRange(@QueryParam("fst") int first,
                              @QueryParam("max") int max,
                              @Context Request request) {
        ArrayList<ProductWrapper> productWrappers = new ArrayList<ProductWrapper>();
        for (Product p:shop.getProductCatalogue().findRange(first,max)) {
            productWrappers.add(new ProductWrapper(p));
        }
        GenericEntity<Collection<ProductWrapper>> ge = new GenericEntity<Collection<ProductWrapper>>(productWrappers){};
        if (productWrappers.size()>-1) {
            return Response.ok(ge).build(); // 200
        } else {
            return Response.noContent().build();  // 204
        }
    }

    //count
    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_JSON})
    public Response count(@Context Request request) {
        int count = shop.getProductCatalogue().count();
        JsonObject value = Json.createObjectBuilder().add("value", count).build();
        return Response.ok(value).build(); // 200
    }
   
}
