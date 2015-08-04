package com.example;
 
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;



public class HelloServlet extends HttpServlet {


    protected void service(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException
    {

        String method = req.getMethod();

        if (method.equals("GET")) {
            doGet(req, resp);
        } else if (method.equals("POST")) {
            doPost(req, resp);
        } else if (method.equals("PUT"))
        {
            doPut(req, resp);
        } else
        {
            // Servlet doesn't currently support
            // other types of request.
            String errMsg = "Method Not Supported";
            resp.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, errMsg);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/jsp");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Hello Servlet</h1>");
        response.getWriter().println(request.getMethod());
        reportType("doGet", response);
    }




    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException
    {

        String name = request.getParameterValues("mname")[0];
        response.getWriter().println(name);
        String lname = request.getParameterValues("lname")[0];
        response.getWriter().println(lname);

    }


    public void reportType(String requestType, HttpServletResponse response)
            throws IOException, ServletException {
        // set the MIME type
        response.setContentType("text/html");

        // use this to print to browser
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("<form method='GET' action='localhost:8080/hello'>");
        out.println("<input type='text' name='fname' size='25' maxlength='35' value='type first name here'>");
        out.println("<input type='text' name='mname' size='25' maxlength='35' value='type middle here'>");
        out.println("<input type='text' name='lname' size='25' maxlength='35' value='type last name here'>");
        out.println("<input type='submit' name='submitButton' value='Submit'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");


    }




/*
    static final String dir = "/home/shabir/JettyMavenHelloWorld";
    public void doPut(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {

        reportType3("doGet", res);
        PrintWriter outHTML = res.getWriter();
        outHTML.println("done");

        try {
            int i;
            InputStream input;
            input = req.getInputStream();
            BufferedInputStream in = new BufferedInputStream(input);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            File outputFile = new File("out.txt");
            FileWriter out = new FileWriter(outputFile);

            while ((i = reader.read()) != -1) {
                out.write(i);
            }

            out.close();
            in.close();

        } catch (IOException e) {
        }
    }

    public void reportType3(String requestType, HttpServletResponse response)
            throws IOException, ServletException
    {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<form enctype='multipart/form-data' method='PUT' action='localhost:8080/hello'>");
        out.println("<input type='file' name='fileupload' size='25' value='select file'>");
        out.println("<input type='submit' name='uploadfile' value='upload'>");
        out.println("<input type='reset' value='RESET");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
        out.println("<html>");

    }*/
}
