package myblogapp.payloads;

import lombok.Data;

@Data
public class CommentDto {

    private long id;
    private String content;
}
