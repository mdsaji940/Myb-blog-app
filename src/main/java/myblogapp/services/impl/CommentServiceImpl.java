package myblogapp.services.impl;

import myblogapp.entity.Comment;
import myblogapp.entity.Post;
import myblogapp.exceptions.ResourceNotFoundException;
import myblogapp.payloads.CommentDto;
import myblogapp.payloads.PostDto;
import myblogapp.repository.CommentRepository;
import myblogapp.repository.PostRepository;
import myblogapp.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post Id", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);

        comment.setPost(post);
        Comment savedComment = commentRepo.save(comment);

        return this.modelMapper.map(savedComment, CommentDto.class);

    }

    @Override
    public void deleteComment(long commentId) {

        Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "comment id", commentId));

        this.commentRepo.delete(comment);
    }
}
