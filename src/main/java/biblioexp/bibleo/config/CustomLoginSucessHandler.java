package biblioexp.bibleo.config;

import biblioexp.bibleo.Entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.servlet.http.Cookie;

@Configuration
public class CustomLoginSucessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) return;

        // Set the user ID in a cookie
        setUserCookie(request, response, authentication);

        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
    private void setUserCookie(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String userId = getUserIdFromAuthentication(authentication);

        if (userId != null) {
            Cookie userIdCookie = new Cookie("userId", userId);
            userIdCookie.setMaxAge(24 * 60 * 60); // Set the cookie to expire in 24 hours (adjust as needed)
            userIdCookie.setPath("/"); // Set the cookie path
            response.addCookie(userIdCookie);
        }
    }

    public static Long getUserIDFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userId".equals(cookie.getName())) {
                    return Long.parseLong(cookie.getValue());
                }
            }
        }
        return null;
    }
    public static void setUserId(Long userId) {
        userIdThreadLocal.set(userId);
    }

    public static Long getUserId() {
        return userIdThreadLocal.get();
    }
    private static final ThreadLocal<Long> userIdThreadLocal = new ThreadLocal<>();
    private String getUserIdFromAuthentication(Authentication authentication) {
        Object principal = authentication.getPrincipal();

        if (principal instanceof User) {
            return String.valueOf(((User) principal).getId());
        }

        return null;
    }

    protected String determineTargetUrl(Authentication authentication){
        String url = "/login?error=true";
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<String>();
        for(GrantedAuthority a : authorities){
            roles.add(a.getAuthority());
        }
        if(roles.contains("ADMIN")){
            url = "/";
        }else if(roles.contains("USER")) {
            url = "/";
        }
        return url;
    }
}
