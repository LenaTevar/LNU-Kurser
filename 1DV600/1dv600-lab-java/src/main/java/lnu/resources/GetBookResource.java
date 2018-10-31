package lnu.resources;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonView;
import org.codehaus.jackson.map.DeserializationConfig;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import lnu.dao.*;
import lnu.models.book;

@Produces(MediaType.APPLICATION_JSON)
@Path("/books")
public class GetBookResource {

}
