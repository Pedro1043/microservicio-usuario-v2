package com.medes.microservicio_usuario_v2.api;

import com.medes.microservicio_usuario_v2.domain.entity.User;
import com.medes.microservicio_usuario_v2.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v2/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/getAll")
    public List<User> fetchAll() {return userService.getAll();}

    @GetMapping("/getById/{idUser}")
    public Optional<User> fetchById (@PathVariable Long idUser) {return userService.getById(idUser);}

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getUser")
    public ResponseEntity<User> fetchUser(@RequestParam String username, @RequestParam String password){
        Optional<User> user = userService.getByUsernameAndPassword(username, password);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/add")
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{idUser}")
    public void delete(@PathVariable Long idUser){
        userService.delete(idUser);
    }
}
