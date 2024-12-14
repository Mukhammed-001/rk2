package com.example.emailsearch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private List<User> users = new ArrayList<>();

    public UserController() {
        users.add(new User("Amirkhan Shonov", "amirkhan.shonov@example.com"));
        users.add(new User("Alikhan Rakhmet", "alikhan.rakhmet@example.com"));
        users.add(new User("Mukhammed Lazgiyev", "mukhammed.lazgiyev@example.com"));
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam String email, Model model) {
        User foundUser = users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
        if (foundUser != null) {}
        model.addAttribute("user", foundUser);
        return "search";
    }

    private User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
}
