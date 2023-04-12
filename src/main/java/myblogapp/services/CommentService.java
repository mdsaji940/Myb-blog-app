package myblogapp.services;

import myblogapp.entity.Comment;
import myblogapp.payloads.CommentDto;

public interface CommentService {
    // create comment
    CommentDto createComment(CommentDto commentDto, long postId);
    // delete comment
    void deleteComment(long commentId);
}
