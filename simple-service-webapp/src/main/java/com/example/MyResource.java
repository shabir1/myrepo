package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getIt() {
        return  "<html>\n" +
                "<body>\n" +
                "<form method='GET' action='localhost:8080/hello'>\n" +
                "<input type='text' name='fname' size='25' maxlength='35' value='type first name here'>\n" +
                "<input type='text' name='mname' size='25' maxlength='35' value='type middle here'>\n" +
                "<input type='text' name='lname' size='25' maxlength='35' value='type last name here'>\n" +
                "<input type='submit' name='submitButton' value='Submit'>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>\n";
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public  void postClichedMessage(MultivaluedMap<String, String> formParams)
    {

        System.out.println(formParams.getFirst("fname"));
        System.out.println(formParams.getFirst("mname"));
        System.out.println(formParams.getFirst("lname"));
    }


}

