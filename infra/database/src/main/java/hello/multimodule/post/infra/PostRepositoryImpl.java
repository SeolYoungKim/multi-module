package hello.multimodule.post.infra;

import hello.multimodule.post.Post;
import hello.multimodule.post.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {
    private final PostEntityRepository postEntityRepository;

    public PostRepositoryImpl(PostEntityRepository postEntityRepository) {
        this.postEntityRepository = postEntityRepository;
    }

    @Override
    public void save(Post post) {
        postEntityRepository.save(PostEntity.from(post));
    }

    @Override
    public List<Post> getAll() {
        return postEntityRepository.findAll().stream()
                .map(PostEntity::toModel)
                .toList();
    }
}
