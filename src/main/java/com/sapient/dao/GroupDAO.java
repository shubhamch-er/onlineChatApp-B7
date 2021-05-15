package com.sapient.dao;

import com.sapient.entity.Group;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.entity.Group;

import com.sapient.interfaces.IGroupDAO;

import com.sapient.utils.GetConnection;

public class GroupDAO implements IGroupDAO {
	@Override
	public boolean saveGroup(Group group) {
		String sql = "Insert into group_details(created_at,updated_at,group_name,Created_by,Group_description) values(?,?,?,?,?);";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			// ps.setInt(1, group.getGroup_id());
			ps.setString(1, group.getCreatedAt());
			ps.setString(2, group.getUpdatedAt());
			ps.setString(3, group.getGroupName());
			ps.setInt(4, group.getCreatedBy());
			ps.setString(5, group.getGroupDescription());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Group getGroup(int gid) {

		String sql = "select group_id, created_at,updated_at,group_name,group_description"
				+ " from group_details where group_id = ?";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, gid);
			// CTRL + 2 + L
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

//				Message message = new Message();
//				message.setmId(rs.getInt(1));
//				message.setSenderId(rs.getInt(2));
//				message.setRecevrId(rs.getInt(3));
//				message.setMessage(rs.getString(4));
//				message.setIsAccepted(rs.getString(5));
				Group g = new Group();
				g.setGroupID(rs.getInt(1));
				g.setCreatedAt(rs.getString(2));
				g.setUpdatedAt(rs.getString(3));
				g.setGroupName(rs.getString(4));
				g.setGroupDescription(rs.getString(4));

				return g;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<Group> getAllGroups() {
		String sql = "select group_id,group_name" + " from group_details";
		List<Group> list = null;
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<Group>();
			while (rs.next()) {
				Group g = new Group();
				g.setGroupID(rs.getInt(1));
				g.setGroupName(rs.getString(2));
				list.add(g);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Boolean deleteGroup(int group_Id) {
		String sql = "delete from group_details where group_id = ?";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, group_Id);
			// CTRL + 2 + L
			int rs = ps.executeUpdate();

			if (rs > 0)
				// System.out.println(" Successfully deleted group ");
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Boolean renameGroup(String groupName, int groupId) {
		String sql = " update group_details set group_name=? where group_id= ?";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, groupName);
			ps.setInt(2, groupId);
			// CTRL + 2 + L
			int rs = ps.executeUpdate();

			if (rs > 0)
				// System.out.println(" Successfully updated groupName ");
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Boolean changedescrption(String groupdescrp, int groupId) {
		String sql = " update group_details set group_description=? where group_id= ?";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setString(1, groupdescrp);
			ps.setInt(2, groupId);
			// CTRL + 2 + L
			int rs = ps.executeUpdate();

			if (rs > 0)
				// System.out.println(" Successfully updated groupdescription ");
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
