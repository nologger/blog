package kim.post.service.impl;

import kim.post.model.Post;
import kim.post.repository.PostRepository;
import kim.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Post getPost(String postId) {
        // postRepository.selectById(postId)

        return null;
    }
}
