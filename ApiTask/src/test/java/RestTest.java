import enums.StatusCode;
import enums.TypeOfPath;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import json_model.AllPosts;
import json_model.User;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;
import utils.LoadProperty;
import utils.RandomWord;
import java.util.List;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class RestTest {
    private static final String ID_OF_USER_POSITION = "99";
    private static final String ID_OF_USER = "10";

    private static final int SECOND_NEEDED_USER = 150;
    private static final String EMPTY_BODY = "{}";
    private static final int LETTERS_COUNT = 5;
    private static final int NUMBER_OF_POST_USER = 1;
    private static final int NEEDED_USER = 5;
    User expectedUser = new User();

    public RestTest() {
        expectedUser.setId(NEEDED_USER);
        expectedUser.setName("Chelsey Dietrich");
        expectedUser.setUsername("Kamren");
        expectedUser.setEmail("Lucio_Hettinger@annie.ca");
        expectedUser.setWebsite("demarco.info");
        expectedUser.setPhone("(254)954-1289");
    }

    @Test
    public void getAllPosts() {
        List<AllPosts> posts = given()
                .baseUri(LoadProperty.getProperty("url"))
                .basePath(TypeOfPath.FULL_POSTS.path)
                .when().get()
                .then().statusCode(StatusCode.GET_OK_RESPONSE.code).and().contentType(ContentType.JSON)
                .extract().jsonPath().getList(basePath, AllPosts.class);
        assertThat(posts).extracting(AllPosts::getId).isSorted();
    }

    @Test
    public void getPreLastPost() {
        Response response = given()
                .baseUri(LoadProperty.getProperty("url"))
                .basePath(TypeOfPath.POST_WITH_NUMBER.postId(Integer.parseInt(ID_OF_USER_POSITION)))
                .when().get()
                .then().statusCode(StatusCode.GET_OK_RESPONSE.code)
                .extract().response();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String userId = jsonPathEvaluator.get("userId").toString();
        String title = jsonPathEvaluator.get("title");
        String body = jsonPathEvaluator.get("body");
        String id = jsonPathEvaluator.get("id").toString();
        Assert.assertFalse(title.isEmpty());
        Assert.assertFalse(body.isEmpty());
        Assert.assertEquals(userId, ID_OF_USER);
        Assert.assertEquals(id, ID_OF_USER_POSITION);
    }

    @Test
    public void bodyIsEmpty() {
        Response response = given()
                .baseUri(LoadProperty.getProperty("url"))
                .basePath(TypeOfPath.POST_WITH_NUMBER.postId(SECOND_NEEDED_USER))
                .when().get()
                .then().statusCode(StatusCode.GET_ERROR_RESPONSE.code)
                .extract().response();
        ResponseBody getEmptyBody = response.body();
        String emptyBody = getEmptyBody.asString();
        Assert.assertEquals(emptyBody, EMPTY_BODY, "Body is not empty");
    }

    @Test
    public void createNewUser() {
        JSONObject requestParams = new JSONObject();
        String randomTitle = RandomWord.generateRandomWord(LETTERS_COUNT);
        String randomBody = RandomWord.generateRandomWord(LETTERS_COUNT);
        requestParams.put("title", randomTitle);
        requestParams.put("body", randomBody);
        requestParams.put("userId", String.valueOf(NUMBER_OF_POST_USER));
        Response response = given()
                .baseUri(LoadProperty.getProperty("url"))
                .header("Content-type", "application/json")
                .body(requestParams.toString())
                .when().post(TypeOfPath.FULL_POSTS.path)
                .then().statusCode(StatusCode.POST_OK_RESPONSE.code)
                .extract().response();
        JsonPath jsonPathEvaluator = response.jsonPath();
        String title = jsonPathEvaluator.get("title");
        String body = jsonPathEvaluator.getString("body");
        String userId = jsonPathEvaluator.getString("userId");
        String id = (jsonPathEvaluator.getString("id"));
        Assert.assertEquals(title, randomTitle);
        Assert.assertEquals(body, randomBody);
        Assert.assertEquals(userId, String.valueOf(NUMBER_OF_POST_USER));
        Assert.assertFalse(id.isEmpty());
    }

    @Test
    public void getAllUsers() {
        List<User> users = given()
                .baseUri(LoadProperty.getProperty("url"))
                .basePath(TypeOfPath.USER_RESPONSE.path)
                .when().get()
                .then().statusCode(StatusCode.GET_OK_RESPONSE.code)
                .extract().jsonPath().getList(basePath, User.class);
        User user = users.stream().filter(x -> x.getId() == NEEDED_USER).findAny().orElse(null);
        Assert.assertEquals(user, expectedUser, "Users are different");
    }

    @Test
    public void getFiveUser() {
        String user = given()
                .baseUri(LoadProperty.getProperty("url"))
                .basePath(TypeOfPath.USER_WITH_ID.userId(NEEDED_USER))
                .when().get()
                .then().statusCode(StatusCode.GET_OK_RESPONSE.code)
                .extract().asString();
        Assert.assertEquals(ApiUtils.getJson(), user, "Users are different");
    }
}
