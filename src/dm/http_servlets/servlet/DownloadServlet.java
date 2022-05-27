package dm.http_servlets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Disposition", "attachmet; filename=\"filename.txt\"");
        resp.setContentType("application/json");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

//        Files.readAllBytes(Path.of())
        try (var printpWriter = resp.getOutputStream()) {
            var inputStream = DownloadServlet.class.getClassLoader().getResourceAsStream("first.json");
            printpWriter.write(inputStream.readAllBytes());
        }
    }
}
