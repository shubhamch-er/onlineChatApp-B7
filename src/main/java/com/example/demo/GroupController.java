package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.dao.GroupDAO;
import com.sapient.entity.Group;
import com.sapient.interfaces.IGroupDAO;


// http://localhsot:8080/health 
// http://localhost:8080/api/message - GET 
//http://localhost:8080/api/message/101 - GET
//http://localhost:8080/api/message/102 - GET
//http://localhost:8080/api/message - POST 

@RestController
@RequestMapping("/api")
public class GroupController {

	private IGroupDAO dao = new GroupDAO(); 
	
	@GetMapping("/health")
	public String health() {
		return "Chat Service is UP... "; 
	}
	
	@GetMapping("/group")
	public List<Group> getAllGroups() {
		return dao.getAllGroups();
	}
	
	@GetMapping("/group/{gId}")
	public Group getGroup( @PathVariable int gId) {
		
		return dao.getGroup(gId); 
	}
	
	@PostMapping("/group")
	public String insertGroup(@RequestBody Group g) {
		System.out.println(g);
		return dao.saveGroup(g) ?"Inserted":"Not Inserted"; 
	}
	
//	public Group deleteGroup(int group_Id);
//	public Group nameGroup(String  groupName,int groupId);
//	public Group changedescrption(String  groupdescrp,int groupId);
	
	@GetMapping("/deleteGroup/{gId}")
	public String deleteGroup( @PathVariable int gId) {
		
		return dao.deleteGroup(gId)?"group deleted":"fail to delete";
	}
	@GetMapping("/renameGroup/{gId}/{newName}")
	public String renameGroup( @PathVariable int gId,@PathVariable String newName) {
		
		return dao.renameGroup(newName,gId)?"renamed ":"fail to rename";
	}
	@GetMapping("/changeGroupDescription/{gId}/{newText}")
	public String changeGroupDescription( @PathVariable int gId,@PathVariable String newText) {
		
		return dao.changedescrption(newText,gId)?"group description changed":"fail to change group description";
	}

	
	
}













