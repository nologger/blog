package kim.blog.common.interceptor;

import kim.blog.common.pathInfo.domain.PathInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kim.blog.common.pathInfo.service.PathInfoService;

@Component
@Slf4j
public class PathInfoInterceptor implements HandlerInterceptor {
    @Autowired
    PathInfoService pathInfoService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

        // set pathInfoList
        List<PathInfo> pathInfoList = getPathInfoList(request.getRequestURI().toString());
        modelAndView.addObject("pathInfoList", pathInfoList);

        // set pathInfo
        PathInfo pathInfo = pathInfoService.getPathInfo(request.getRequestURI().toString());
        modelAndView.addObject("pathInfo", pathInfo);
    }

    /**
     * URI의 모든 토큰을 이용하여 토큰별 정보 리스트를 반환한다.
     * @param uri
     * @return
     */
    private List<PathInfo> getPathInfoList(String uri) {
        List<PathInfo> pathInfoList = new ArrayList<>();

        String[] uriTokens = Arrays.stream(uri.split("/")).filter(token -> !token.isEmpty()).toArray(String[]::new);
        StringBuilder path = new StringBuilder();
        for (String uriToken : uriTokens) {
            path.append("/").append(uriToken);
            pathInfoList.add(pathInfoService.getPathInfo(path.toString()));
        }

        return pathInfoList;
    }
}
