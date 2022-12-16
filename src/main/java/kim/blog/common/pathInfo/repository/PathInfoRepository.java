package kim.blog.common.pathInfo.repository;

import kim.blog.common.pathInfo.domain.PathInfo;

import java.util.List;

public interface PathInfoRepository {
    PathInfo selectByUri(String uri);
    List<PathInfo> selectByPart(String part);
}
