package kim.blog.common.pathInfo.service;

import kim.blog.common.pathInfo.domain.PathInfo;

import java.util.List;

public interface PathInfoService {
    PathInfo getPathInfo(String uri);
    List<PathInfo> getCommonPathInfo();
}
