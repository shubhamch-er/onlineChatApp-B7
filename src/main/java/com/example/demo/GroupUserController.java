package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.dao.GroupDAO;
import com.sapient.dao.GroupUserRelationDAO;
import com.sapient.entity.Group;
import com.sapient.entity.GroupUserRelation;
import com.sapient.interfaces.IGroupDAO;
@RestController
@RequestMapping("/api")
public class GroupUserController {
private GroupUserRelationDAO dao = new GroupUserRelationDAO(); 
	
	
	@GetMapping("/groupuser/{gId}")
	public List<Integer> getAllUser(@PathVariable int gId) {
		
		return dao.getAllUser(gId);
	}
	
	@GetMapping("/groupAdmin/{gId}")
	public List<Integer> getAllAdmin(@PathVariable int gId) {
		
		return dao.getAllGroupAdmin(gId);
	}
	
//	@GetMapping("/groupuser/{gId}/{uId}")
//	public GroupUserRelation getGroupuser( @PathVariable int gId,@PathVariable int uId) {
//		
//		return dao.getGroupUserRelation(gId,uId); 
//	}
	@GetMapping("/exitGroupUser/{gId}/{uId}")
	public String exitGroupUser( @PathVariable  int gId,@PathVariable  int uId) {
		return dao.exitGroup(gId, uId) ?"Exited":"fail to exit"; 
	}
	
	@GetMapping("/removeGroupUser/{gId}/{uId}/{adminId}")
	public String removeUser( @PathVariable  int gId,@PathVariable  int uId,@PathVariable  int adminId) {
		//System.out.println(gu);
		return dao.removeUser(gId, uId, adminId) ?"Removed":"fail to remove"; 
	}
	
	@GetMapping("/makeGroupadmin/{gId}/{uId}/{adminId}")
	public String makeGroupAdmin( @PathVariable  int gId,@PathVariable  int uId,@PathVariable  int adminId) {
		//System.out.println(gu);
		return dao.makeGroupAdmin(gId, uId, adminId) ?"Admin changed":"fail to make admin"; 
	}
	@GetMapping("/addGroupUser/{gId}/{uId}/{adminId}")
	public String addUser( @PathVariable  int gId,@PathVariable  int uId,@PathVariable  int adminId) {
		System.out.println(gId);
		return dao.addGroupUser(gId, uId, adminId) ?"added":"fail to added"; 
	}
	
//	@PostMapping("/groupuser")
//	public String insertGroup(@RequestBody GroupUserRelation gu) {
//		System.out.println(gu);
//		return dao.saveGroupUserRelation(gu) ?"Inserted":"Not Inserted"; 
//	}
	
	
}
