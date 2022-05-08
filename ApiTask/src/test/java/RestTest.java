import io.restassured.http.ContentType;
import jason_model.AllPosts;
import org.testng.annotations.Test;
import utils.LoadProperty;

import java.util.List;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class RestTest {

    @Test
    public void getAllPosts() {
        List<AllPosts> posts = given()
                .baseUri(LoadProperty.getProperty("url"))
                .basePath("/posts")
                .when().get()
                .then().statusCode(200).and().contentType(ContentType.JSON)
                .extract().jsonPath().getList(basePath, AllPosts.class);
        assertThat(posts).extracting(AllPosts::getId).isSorted();
    }
}
