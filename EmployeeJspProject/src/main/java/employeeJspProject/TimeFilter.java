package employeeJspProject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TimeFilter implements Filter {
    private Map<String, Long> responseTimeMap;

    public void init(FilterConfig filterConfig) throws ServletException {
        responseTimeMap = new HashMap<>();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        long startTimeMillis = System.currentTimeMillis();
        long startTimeNanos = System.nanoTime();

        chain.doFilter(request, response);

        long endTimeMillis = System.currentTimeMillis();
        long endTimeNanos = System.nanoTime();

        String uri = request.getServletContext().getContextPath() + request.getServletContext();
        long elapsedTimeMillis = endTimeMillis - startTimeMillis;
        long elapsedTimeNanos = endTimeNanos - startTimeNanos;

        responseTimeMap.put(uri, elapsedTimeMillis);

        // Log the results (you can customize this part)
        System.out.println("URI: " + uri);
        System.out.println("Start Time of Request");
        System.out.println("Time (milliseconds): " + startTimeMillis);
        System.out.println("Time (nanoseconds): " + startTimeNanos);
        System.out.println("Response Time of the Server");
        System.out.println("Time (milliseconds): " + endTimeMillis);
        System.out.println("Time (nanoseconds): " + endTimeNanos);
        System.out.println("Time Elapsed");
        System.out.println("Time (milliseconds): " + elapsedTimeMillis);
        System.out.println("Time (nanoseconds): " + elapsedTimeNanos);
    }

    public void destroy() {
        // Clean up resources if needed
    }
}

