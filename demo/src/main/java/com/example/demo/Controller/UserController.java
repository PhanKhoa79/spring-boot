package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/taikhoan")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/add/user")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		User createUser = userService.createUser(user);
		if(createUser != null) {
			return new ResponseEntity<User>(createUser, HttpStatus.CREATED);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Tài khoản đã tồn tại");
		}
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUser();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable String id) {
		User user = userService.getUserById(id);
		if(user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tài khoản không tồn tại!");
		} else {
			return ResponseEntity.ok(user);
		}
	}

	@PutMapping("/update/user")
	public ResponseEntity<?> updateUser(@RequestParam("id") String id, @RequestBody User user) {
		User updateUser = userService.updateUser(id, user);
		if(updateUser != null) {
			return ResponseEntity.ok(updateUser);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Không thể cập nhật câu hỏi"); 
		}
	}
	
	@DeleteMapping("/delete/user") 
	public ResponseEntity<?> deleteUser(@RequestParam("id") String id) {
		if(userService.deleteUser(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("Xóa thành công!");
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Không thể xóa tài khoản này!");
		}
	}
	
	@GetMapping("/login/{taiKhoan}/{matKhau}")
	public ResponseEntity<?> login(@PathVariable String taiKhoan, @PathVariable String matKhau) {
		if(userService.login(taiKhoan, matKhau)) {
			return ResponseEntity.ok("Đăng nhập thành công!");
		} 
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tài Khoản mật khẩu không chính xác!");
	}
	
	@GetMapping("/user/role/{taiKhoan}")
	public ResponseEntity<Integer> phanQuyen(@PathVariable String taiKhoan) {
		return ResponseEntity.ok(userService.phanQuyen(taiKhoan));
	}
}
