package enums;

public enum TypeOfPath {
    FULL_POSTS("/posts"),
    POST_WITH_NUMBER("/posts/"),
    USER_RESPONSE("/users"),
    USER_WITH_ID("/users/")
    ;
    public String path;

    TypeOfPath(String path) {
        this.path = path;
    }

    public String postId (int postId) {
        String numberOfPost = String.valueOf(postId);
        return String.format("/posts/" + numberOfPost);
    }

    public String userId (int userId) {
        String idOfTheUser = String.valueOf(userId);
        return String.format("/users/" + idOfTheUser);
    }

}
