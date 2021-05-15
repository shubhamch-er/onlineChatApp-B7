package com.sapient.interfaces;

import java.util.List;

import com.sapient.entity.GroupUserRelation;

public interface IGroupUserRelationDAO {
	public boolean saveGroupUserRelation(GroupUserRelation groupUser);

	// get message

	// get all messages
	public List<GroupUserRelation> getAllGroupUserRelation();

	// remove user
	public Boolean removeUser(int groupId, int userId, int adminId);

	// exit user
	public Boolean exitGroup(int groupId, int userId);

	public List<Integer> getAllUser(int gId);

	public boolean isMember(int groupId, int userId);

	public boolean isAdmin(int groupId, int adminId);

	public List<Integer> getAllGroupAdmin(int groupId);

	public Boolean makeGroupAdmin(int groupId, int userId, int adminId);

	public Boolean addGroupUser(int groupId, int userId, int adminId);

}
