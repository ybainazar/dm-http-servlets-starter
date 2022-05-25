package dmdev.http_servlets.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

//@WebFilter("/*") // by URL pattern. Mostly
@WebFilter(servletNames = {"RegistrationServlet"}, // by Servlet name
        initParams = {@WebInitParam(name = "param1", value = "paramVal")}, // init params
        dispatcherTypes = DispatcherType.REQUEST // based on dispatcher types (default = REQUEST)
        )
public class CharsetFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(StandardCharsets.UTF_8.name());
        servletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
