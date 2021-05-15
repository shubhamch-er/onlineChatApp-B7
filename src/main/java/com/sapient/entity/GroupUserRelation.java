package com.sapient.entity;

public class GroupUserRelation {
	int groupId;
	int userId;
	boolean isAdmin;

	public GroupUserRelation() {

	}

	public GroupUserRelation(int group_id, int user_id, boolean isAdmin) {
		super();
		this.groupId = group_id;
		this.userId = user_id;
		this.isAdmin = isAdmin;
	}

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int group_id) {
		this.groupId = group_id;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int user_id) {
		this.userId = user_id;
	}

	public boolean IsAdmin() {
		return this.isAdmin;
	}

	public boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "group_id=" + groupId + "user_id=" + userId + "isAdmin= " + isAdmin;
	}
}