package com.example.demo.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	@Override
	public User getUserById(String id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	@Override
	public User createUser(User user) {
		String idUser = user.getTaiKhoan();
		Optional<User> checkUser = userRepository.findById(idUser);
		if(!checkUser.isPresent()) {
			return userRepository.save(user);
		}
		return null;
	}
	
	@Override
	public User updateUser(String id, User user) {
		User checkUser = userRepository.getReferenceById(id);
		if(checkUser != null) {
			checkUser.setEmail(user.getEmail());
			checkUser.setMatKhau(user.getMatKhau());
			checkUser.setIdPhanQuyen(user.getIdPhanQuyen());
			
			return userRepository.save(checkUser);
		}
		return null;
	}
	
	@Override
	public boolean deleteUser(String id) {
		 Optional<User> optionalUser = userRepository.findById(id);
		    if (optionalUser.isPresent()) {
		        try {
		            userRepository.delete(optionalUser.get());
		            return true;
		        } catch (Exception e) {
		            return false;
		        }
		    }
		    return false;
	}

	@Override
	public boolean login(String taiKhoan, String matKhau) {
		User user = userRepository.findByTaiKhoanAndMatKhau(taiKhoan, matKhau);
		return (user != null);
	}

	@Override
	public Integer phanQuyen(String taiKhoan) {
		return userRepository.findIdPhanQuyenByTaiKhoan(taiKhoan);
	}

}
