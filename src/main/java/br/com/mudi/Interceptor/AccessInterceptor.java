package br.com.mudi.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccessInterceptor implements HandlerInterceptor {

    public static List<Access> accesses = new ArrayList<>();

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Access access = new Access();
        access.path = request.getRequestURI();
        access.date = LocalDateTime.now();

        request.setAttribute("access", access);

        System.out.println(access);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
        Access access = (Access) request.getAttribute("access");
        access.duration = Duration.between(access.date, LocalDateTime.now());
        System.out.println(access);
        accesses.add(access);
    }

    public static class Access {
        private String path;
        private LocalDateTime date;
        private Duration duration;

        @Override
        public String toString() {
            return "Access{" +
                    "path='" + path + '\'' +
                    ", date=" + date +
                    ", duration=" + duration +
                    '}';
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public LocalDateTime getDate() {
            return date;
        }

        public void setDate(LocalDateTime date) {
            this.date = date;
        }

        public Duration getDuration() {
            return duration;
        }

        public void setDuration(Duration duration) {
            this.duration = duration;
        }
    }
}
