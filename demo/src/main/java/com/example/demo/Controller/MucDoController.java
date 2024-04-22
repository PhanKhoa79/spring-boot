package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.MucDo;
import com.example.demo.Service.MucDoService;

@RestController
@RequestMapping("/api/mucdo")
public class MucDoController {
	@Autowired
	private MucDoService mucDoService;
	
	@GetMapping("/levels")
	public ResponseEntity<List<MucDo>> getAllMucDo() {
		List<MucDo> listMucDo = mucDoService.getlAllMucDo();
		return ResponseEntity.ok(listMucDo);
	}
	
	@GetMapping("/level") 
	public ResponseEntity<String> getIdByName(@RequestParam("name") String name) {
		return ResponseEntity.ok(mucDoService.getIdByName(name));
	}
}
