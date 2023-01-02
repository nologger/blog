package kim.blog.admin.service;

import kim.blog.admin.repository.AdminRepository;
import kim.blog.common.exception.UnknownIpInformation;
import kim.blog.common.service.HttpRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Service
public class AdminAccessServiceImpl {
    @Autowired
    HttpRequestService httpRequestService;
    @Autowired
    AdminRepository adminRepository;

    public boolean checkAccess(HttpServletRequest request) {
        // Get ip information
        String accessIp = "";
        try {
            accessIp = httpRequestService.getRequestIp(request);
        } catch (UnknownIpInformation e) {
            log.info("Unknown ip information...");
            log.info("request information: {}", request.toString());
            return false;
        } catch (Exception e) {
            log.info("Unknown Exception...");
            log.info("request information: {}", request.toString());
            e.printStackTrace();
            return false;
        }

        // Check ip information
        if (!adminRepository.isExistIp(accessIp)) {
            log.info("invalid access: {}", accessIp);
            return false;
        }

        return true;
    }
}
