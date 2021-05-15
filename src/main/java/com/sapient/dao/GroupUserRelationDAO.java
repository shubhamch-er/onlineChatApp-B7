package com.sapient.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.entity.GroupUserRelation;
import com.sapient.interfaces.IGroupUserRelationDAO;
import com.sapient.utils.GetConnection;

public class GroupUserRelationDAO implements IGroupUserRelationDAO {

	@Override
	public boolean saveGroupUserRelation(GroupUserRelation groupUser) {
		String sql = "Insert into group_user_relation(group_id,user_id,is_admin) values(?,?,?)";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			// ps.setInt(1, group.getGroup_id());
			// ps.setString(2, group. getCreated_at());
			// ps.setString(3, group.getUpdated_at());
			ps.setInt(1, groupUser.getGroupId());
			ps.setInt(2, groupUser.getUserId());
			ps.setBoolean(3, groupUser.getIsAdmin());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<GroupUserRelation> getAllGroupUserRelation() {
		String sql = "select group_id,user_id,is_admin" + " from group_user_relation";
		List<GroupUserRelation> list = null;
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<GroupUserRelation>();
			while (rs.next()) {
				GroupUserRelation gu = new GroupUserRelation();
				gu.setGroupId(rs.getInt(1));
				gu.setUserId(rs.getInt(2));
				gu.setIsAdmin(rs.getBoolean(3));
				list.add(gu);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Boolean removeUser(int groupId, int userId, int adminId) {
		if (isMember(groupId, adminId) && isAdmin(groupId, adminId) && isMember(groupId, userId)) {
			String sql = "delete from group_user_relation where group_id =? and user_id =?";

			try {
				PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
				ps.setInt(1, groupId);
				ps.setInt(2, userId);

				int rs = ps.executeUpdate();
				if (rs > 0) {
					System.out.println("" + adminId + " has removed " + userId);
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

	@Override
	public boolean isAdmin(int groupId, int adminId) {
		String query = "select is_Admin from group_user_relation where group_id = ? and user_id = ?";
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(query);
			ps.setInt(1, groupId);
			ps.setInt(2, adminId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getBoolean(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean isMember(int groupId, int userId) {
		String query = "select * from group_user_relation where group_id = ? and user_id = ?";
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(query);
			ps.setInt(1, groupId);
			ps.setInt(2, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean exitGroup(int groupId, int userId) {
		String sql = "delete from group_user_relation where group_id =? and user_id =?";

		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, groupId);
			ps.setInt(2, userId);

			int rs = ps.executeUpdate();
			if (rs > 0) {
				System.out.println("suceesfully exited the group");
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean makeGroupAdmin(int groupId, int userId, int adminId) {
		if (isMember(groupId, adminId) && isAdmin(groupId, adminId) && isMember(groupId, userId)) {

			String sql = "update group_user_relation  set is_admin=true where group_id =? and user_id =?";

			try {
				PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);

				ps.setInt(1, groupId);
				ps.setInt(2, userId);

				int rs = ps.executeUpdate();
				if (rs > 0) {
					System.out.println("suceesfully changed admin");
					return true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<Integer> getAllUser(int gId) {
		String sql = "select user_id from group_user_relation where group_id = ?";
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, gId);
			List<Integer> res = new ArrayList<Integer>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res.add(rs.getInt(1));
			}
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Integer> getAllGroupAdmin(int groupId) {
		String sql = "select user_id from group_user_relation where group_id = ? and is_admin=true";
		try {
			PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, groupId);
			List<Integer> res = new ArrayList<Integer>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				res.add(rs.getInt(1));
			}
			return res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Boolean addGroupUser(int groupId, int userId, int adminId) {
		if (isMember(groupId, adminId) && isAdmin(groupId, adminId)) {
			String sql = "Insert into group_user_relation(group_id,user_id,is_admin) values(?,?,false)";

			try {
				PreparedStatement ps = GetConnection.getMySQLConn().prepareStatement(sql);
				ps.setInt(1, groupId);
				ps.setInt(2, userId);

				int rs = ps.executeUpdate();
				if (rs > 0) {
					System.out.println("" + adminId + " has added " + userId);
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
