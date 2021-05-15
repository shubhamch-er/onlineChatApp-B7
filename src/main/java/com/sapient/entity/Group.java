package com.sapient.entity;

import java.sql.Date;

public class Group {
	private int groupId;
	private String createdAt;
	private String updatedAt;
	private String groupName;
	private int createdBy;
	private String groupDescription;

	public Group() {
	}

	public Group(int group_id, String Created_at, String Updated_at, String group_name, int Created_by,
			String group_description) {
		super();
		this.groupId = group_id;
		this.createdAt = Created_at;
		this.createdAt = Updated_at;
		this.groupName = group_name;
		this.createdBy = Created_by;
		this.groupDescription = group_description;

	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupID(int group_id) {
		this.groupId = group_id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String created_at) {
		createdAt = created_at;
	}

	public String getUpdatedAt() {
		return createdAt;
	}

	public void setUpdatedAt(String updated_at) {
		updatedAt = updated_at;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String group_name) {
		this.groupName = group_name;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int created_by) {
		createdBy = created_by;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String group_description) {
		this.groupDescription = group_description;
	}

	@Override
	public String toString() {
		return "group_id=" + groupId + "group_name=" + groupName;
	}

}
