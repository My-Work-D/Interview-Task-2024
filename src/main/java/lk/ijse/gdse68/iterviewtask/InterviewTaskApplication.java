package lk.ijse.gdse68.iterviewtask;

import lk.ijse.gdse68.iterviewtask.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class InterviewTaskApplication implements CommandLineRunner {
    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(InterviewTaskApplication.class,args);
        System.out.println("hii");
    }

    @Override
    public void run(String... args) throws Exception {
        String user = userService.createUser();
        System.out.println(user);

        String getUserDetails = userService.getUser("user78090");
        System.out.println(getUserDetails);

        String userList = userService.listUsers();
        System.out.println(userList);

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
        String updateUser = userService.updateUser("user78090",json);
        System.out.println(updateUser);
        String delete = userService.deleteUser("user78090");
		System.out.println(delete);
    }

}
