package com.sapient.interfaces;

import java.util.List;

import com.sapient.entity.Group;

public interface IGroupDAO {
	public boolean saveGroup(Group group);

	// get message
	public Group getGroup(int group_Id);

	// get all messages
	public List<Group> getAllGroups();

	public Boolean deleteGroup(int group_Id);

	public Boolean renameGroup(String groupName, int groupId);

	public Boolean changedescrption(String groupdescrp, int groupId);

}
