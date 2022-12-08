package kim.blog.common.pathInfo.service.impl;

import kim.blog.common.pathInfo.domain.PathInfo;
import kim.blog.common.pathInfo.repository.PathInfoRepository;
import kim.blog.common.pathInfo.service.PathInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PathInfoServiceImpl implements PathInfoService {
    @Autowired
    PathInfoRepository pathInfoRepository;

    @Override
    public PathInfo getPathInfo(String uri) {
        PathInfo pathInfo = pathInfoRepository.selectByUri(uri);
        return pathInfo;
    }

    @Override
    public List<PathInfo> getCommonPathInfo() {
        List<PathInfo> pathInfoList = pathInfoRepository.selectByPart();
        return pathInfoList;
    }
}
