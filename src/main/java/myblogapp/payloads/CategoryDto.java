package myblogapp.payloads;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Data
public class CategoryDto {

    private long id;
    @NotEmpty
    @Size(min = 4, max = 20)
    private String categoryTitle;
    @NotEmpty
    @Size(min = 10, max = 500)
    private String categoryDescription;
}
