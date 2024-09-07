package lk.ijse.gdse68.iterviewtask.sevice;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {
    private static final String API_URL = "https://541680cdf54b4d298b0d660da574ad94.weavy.io/api/users";
    private static final String API_KEY = "wys_d3xOs1h1jcYfEy0PwfAoGCuTXGck6G0UxP7X";
    private final OkHttpClient client = new OkHttpClient();
    public String createUser() throws IOException {
        String json = "{\n" +
                "    \"uid\": \"user78090\",\n" +
                "    \"email\": \"asachi@gmail.com\",\n" +
                "    \"given_name\": \"Sachini\",\n" +
                "    \"middle_name\": \"Apsara\",\n" +
                "    \"name\": \"Sachini Apsara Witharana\",\n" +
                "    \"family_name\": \"Witharana\",\n" +
                "    \"nickname\": \"Sachi\",\n" +
                "    \"phone_number\": \"+0987654321\",\n" +
                "    \"comment\": \"Account created for new project development.\",\n" +
                "    \"picture\": \"https://example.com/profile-pic-jane.jpg\",\n" +
                "    \"directory\": \"project-team\",\n" +
                "    \"metadata\": {\n" +
                "        \"color\": \"red\",\n" +
                "        \"size\": \"M\"\n" +
                "    },\n" +
                "    \"tags\": [\"developer\", \"team-lead\"],\n" +
                "    \"is_suspended\": true,\n" +
                "    \"is_bot\": true\n" +
                "}\n";
    RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
    Request request = new Request.Builder()
            .url(API_URL)
            .addHeader("Authorization", "Bearer " + API_KEY)
            .post(body)
            .build();

        try (Response response = client.newCall(request).execute()) {

        return response.body().string();
    }
}

    public String getUser(String uid) throws IOException {
        Request request = new Request.Builder()
                .url(API_URL + "/" + uid)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    public String updateUser(String uid, String updatedJson) throws IOException {
        RequestBody body = RequestBody.create(updatedJson, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(API_URL + "/" + uid)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .put(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }
}
