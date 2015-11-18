package group8.com.e_learning.common;

/**
 * Created by nomore on 18/11/2015.
 */
public class Constant {
    public static final String API_USER = "{\n" +
            "  \"user\": {\n" +
            "    \"id\": 102,\n" +
            "    \"name\": \"Hung\",\n" +
            "    \"email\": \"fsdgfhd@gmail.com\",\n" +
            "    \"admin\": null,\n" +
            "    \"created_at\": \"2015-11-17T12:34:39.510Z\",\n" +
            "    \"updated_at\": \"2015-11-17T12:34:39.510Z\",\n" +
            "    \"password_digest\": \"$2a$10$aiKgtuCSkBC7hJKkL3QVgeg0YPmuGeQZdktessAYLVgl7rbnpogpi\",\n" +
            "    \"remember_digest\": null\n" +
            "  }";
    public static final String API_WORD = "{\\\"words\\\":[{\\\"id\\\":1,\\\"content\\\":\\\"test1\\\",\\\"category_id\\\":1,\\\"created_at\\\":\\\"2015-11-16T16:33:46.651Z\\\",\\\"updated_at\\\":\\\"2015-11-16T16:33:46.651Z\\\"},{\\\"id\\\":2,\\\"content\\\":\\\"test2\\\",\\\"category_id\\\":1,\\\"created_at\\\":\\\"2015-11-16T16:33:47.655Z\\\",\\\"updated_at\\\":\\\"2015-11-16T16:33:47.655Z\\\"},{\\\"id\\\":3,\\\"content\\\":\\\"test3\\\",\\\"category_id\\\":2,\\\"created_at\\\":\\\"2015-11-16T16:33:48.584Z\\\",\\\"updated_at\\\":\\\"2015-11-16T16:33:48.584Z\\\"},{\\\"id\\\":4,\\\"content\\\":\\\"test4\\\",\\\"category_id\\\":2,\\\"created_at\\\":\\\"2015-11-16T16:33:49.255Z\\\",\\\"updated_at\\\":\\\"2015-11-16T16:33:49.255Z\\\"}]}";

    public static final String API_ERROR = "{\n" +
            "  \\\"error\\\": [\n" +
            "    \\\"Email can't be blank\\\",\n" +
            "    \\\"Email is invalid\\\",\n" +
            "    \\\"Password can't be blank\\\",\n" +
            "    \\\"Password can't be blank\\\",\n" +
            "    \\\"Password is too short (minimum is 6 characters)\\\"\n" +
            "  ]\n" +
            "}";

}
