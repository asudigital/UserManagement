package springBoot.userManagement.springbootrestfulwebservices.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springBoot.userManagement.springbootrestfulwebservices.entity.User;
import springBoot.userManagement.springbootrestfulwebservices.service.UserService;

import java.util.List;

@RestController
//@Controller
//@ResponseBody

//Constructor based DI
@AllArgsConstructor
//@NoArgsConstructor
@RequestMapping("api/users")
public class UserController {
//constructor based dependency injection
    //@Autowired  is not required, whenever Spring will find  spring bean i.e.  UserController , it has only one
// parameterized constructor, it will automatically inject its dependency
//    @Autowired
   private UserService userService;


    //@RequestBody: in Postman we are sending JSON , so this annotation will convert it into java object
   @PostMapping("v1")
   public ResponseEntity<User>  createUser(@RequestBody User user)
   {
       if (user.getId() != null) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new User(2L,"Asu","Sahoo","asu@gmail.com")

                );
       }
     User savedUser = userService.createUser(user);
     return new ResponseEntity<>(savedUser , HttpStatus.CREATED);
   }

   //We have here id as a URI template variable , to bind URI template variable , we are using @PathVariable annotations
   @GetMapping("{id}")
   public ResponseEntity<User> getUserById(@PathVariable("id")  Long userId)
   {
      User savedUser = userService.getUserById(userId);
      return new ResponseEntity<>(savedUser ,HttpStatus.OK );
   }
   @GetMapping("allUsers")
  public ResponseEntity<List<User>> getAllUser()
  {
  List<User> allUsers = userService.getAllUsers();
  return new ResponseEntity<>(allUsers , HttpStatus.OK);
  }

//    @GetMapping("allUsers")
//    public List<User> getAllUser()
//    {
//        return userService.getAllUsers();
//
//    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser ( @PathVariable("id") Long userId ,  @RequestBody User user)
    {
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteUser(@RequestParam Long userId)
    {
      userService.deleteUser(userId);
      return new ResponseEntity<>("User successfully deleted" , HttpStatus.OK);
    }

    //it is for testing
   @GetMapping("v1")
    public  String TestApi(){
        return "ok";
    }
}
