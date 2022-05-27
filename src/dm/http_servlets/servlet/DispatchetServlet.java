package dm.http_servlets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatchetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        var requestDispatcher = req.getRequestDispatcher("/flights")
////        req.setAttribute("1", "234");
//        requestDispatcher.forward(req, resp);


//        FORWARD to diff servlet
//        req.getRequestDispatcher("/flights").forward(req, resp);


//        INCLUDE diff servlet (need to remove try-resources from flights (it automatically sends response)
//        req.getRequestDispatcher("/flights").include(req, resp);
//
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        var writer = resp.getWriter();
//        writer.write("Hello 2");


//        REDIRECT (it changes URL also)
        resp.sendRedirect("/flights");
    }
}
