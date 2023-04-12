package myblogapp.payloads;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class PostDto {

    private long id;

    @NotEmpty
    @Size(min = 4, max = 100)
    private String title;
    @NotEmpty
    @Size(min = 4, max = 1000)
    private String content;
    private String imageName;
    private Date addedDate;

    private CategoryDto category;
    private UserDto user;
    private Set<CommentDto> AllComments = new HashSet<>();

}
