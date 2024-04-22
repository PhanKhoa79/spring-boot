package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.User;

public interface UserService {
	public List<User> getAllUser();
	
	public User getUserById(String id);
	
	public User createUser(User user);
	
	public User updateUser(String id, User user);
	
	public boolean deleteUser(String id);
	
	public boolean login(String taiKhoan, String matKhau);
	
	public Integer phanQuyen(String taiKhoan);
}
