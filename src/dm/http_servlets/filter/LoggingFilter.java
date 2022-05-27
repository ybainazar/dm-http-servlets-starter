package dm.http_servlets.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;


@WebFilter("/*")
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.getParameterMap().forEach((k, v) -> System.out.println(k + ": " + Arrays.toString(v)));
//        var attributeNames = servletRequest.getAttributeNames();
//        while (attributeNames.hasMoreElements()) {
//            var element = attributeNames.nextElement();
//            System.out.println(element + ":" + servletRequest.getAttribute(element));
//        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

