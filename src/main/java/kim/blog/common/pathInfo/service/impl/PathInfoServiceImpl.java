package kim.blog.common.pathInfo.service.impl;

import kim.blog.common.pathInfo.domain.PathInfo;
import kim.blog.common.pathInfo.repository.PathInfoRepository;
import kim.blog.common.pathInfo.service.PathInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PathInfoServiceImpl implements PathInfoService {
    @Autowired
    PathInfoRepository pathInfoRepository;

    @Override
    public PathInfo getPathInfo(String uri) {
        try {
            PathInfo pathInfo = pathInfoRepository.selectByUri(uri);
            return pathInfo;
        } catch (EmptyResultDataAccessException e) {
            log.info("EmptyResultDataAccessException: {}", uri);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<PathInfo> getCommonPathInfo() {
        List<PathInfo> pathInfoList = pathInfoRepository.selectByPart();
        return pathInfoList;
    }
}
