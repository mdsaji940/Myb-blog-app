package myblogapp.services;

import myblogapp.entity.Post;
import myblogapp.payloads.PostDto;
import myblogapp.payloads.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, long userId, long categoryId);

    PostDto updatePost(PostDto postDto, long postId);

    void deletePost(long postId);

    PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    PostDto getPostById(long postId);

    List<PostDto> getPostsByCategory(long categoryId);

    List<PostDto> getPostsByUser(long userId);

    List<PostDto> searchPosts(String keyword);
}
