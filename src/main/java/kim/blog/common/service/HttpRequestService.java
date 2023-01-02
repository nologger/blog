package kim.blog.common.service;

import kim.blog.common.exception.UnknownIpInformation;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class HttpRequestService {
    /**
     * Description: Returns the requested user's IP information.
     * @param request
     * @return ip info
     */
    static public String getRequestIp(HttpServletRequest request) throws UnknownIpInformation {
        String ip = "";

        ip = request.getHeader("X-Forwarded-For");
        if (!isUnknown(ip)) {
            return ip;
        }

        ip = request.getHeader("Proxy-Client-IP");
        if (!isUnknown(ip)) {
            return ip;
        }

        ip = request.getHeader("HTTP_CLIENT_IP");
        if (!isUnknown(ip)) {
            return ip;
        }

        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (!isUnknown(ip)) {
            return ip;
        }

        ip = request.getHeader("X-Real-IP");
        if (!isUnknown(ip)) {
            return ip;
        }

        ip = request.getHeader("X-RealIP");
        if (!isUnknown(ip)) {
            return ip;
        }

        ip = request.getHeader("REMOTE_ADDR");
        if (!isUnknown(ip)) {
            return ip;
        }

        ip = request.getRemoteAddr();
        if (!isUnknown(ip)) {
            return ip;
        }

        throw new UnknownIpInformation();
    }

    static private boolean isUnknown(String ip) {
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip) ) {
            return true;
        }
        return false;
    }
}
