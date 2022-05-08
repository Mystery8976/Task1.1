package jason_model;

import lombok.Data;

@Data
public class AllPosts {
    private int userId;
    private int id;
    private String title;
    private String body;
}
