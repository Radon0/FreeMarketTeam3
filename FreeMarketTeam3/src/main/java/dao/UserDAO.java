package dao;
/*
 * プログラム名：フリマシステム
 * プログラムの説明：userのDAO
 * 作成者：石野朱音
 * 作成日：2025/6/19
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.User;

public class UserDAO {
	//接続用の情報をフィールドに定数として定義
	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost/freemarket_db";
	private static String USER = "root";
	private static String PASSWD = "root123";

	/**
	 * DB接続を行うメソッド
	 * 
	 * @return Connection
	 */
	public Connection getConnection() {
		try {
			// JDBCドライバをロード
			Class.forName(RDB_DRIVE);
			// オブジェクトの生成
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	/**
	 * DBのuserテーブルから全ユーザー情報を検索するメソッド
	 * 
	 * @return list
	 */
	
	public ArrayList<User> selectAll(){
		//変数宣言
		Connection con = null;
		Statement smt = null;
		
		//配列宣言
		ArrayList<User> list = new ArrayList<User>();
		
		//SQL文作成
		String sql = "SELECT * FROM user ORDER BY user_id";
		
		try {
			con = getConnection();
			smt = con.createStatement();
			
			//DBにSQL文を発行
			ResultSet rs = smt.executeQuery(sql);
			
			//取得した検索結果をArrayListに格納
			while(rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setLoginId(rs.getString("login_id"));
				user.setFamilyName(rs.getString("family_name"));
				user.setFirstName(rs.getString("first_name"));
				user.setFamilyNameKana(rs.getString("family_name_kana"));
				user.setFirstNameKana(rs.getString("first_name_kana"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
				user.setNickName(rs.getString("nick_name"));
				user.setPostcode(rs.getString("postcode"));
				user.setAddressPrefecture(rs.getString("address_prefecture"));
				user.setAddressOrder(rs.getString("address_order"));
				user.setApartment(rs.getString("apartment"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setLeaveFlag(rs.getInt("leave_flag"));
				user.setLeaveDate(rs.getString("leave_date"));
				user.setInsertDate(rs.getString("insert_date"));
				user.setUpdateDate(rs.getString("update_date"));
				list.add(user);
				
			}
		}catch(Exception e) {
			throw new IllegalStateException(e);
			
		}finally {
			//リソースの開放
			if(smt != null) {
				try {
					smt.close();
				}catch(SQLException ignore) {}
			}
			if(con != null) {
				try {
					con.close();
				}catch(SQLException ignore) {}
			}
				 
		}
		return list;
	} 
	
	/**
	 * ユーザーIDを元に該当のユーザー情報の検索を行うメソッド
	 */
	public User selectByUserId(int userId) {
		//変数宣言
		Connection con = null;
		Statement smt = null;
		
		//return用Userオブジェクト生成
		User user = new User();
		
		//SQL文作成
		String sql = "SELECT * FROM user WHERE user_id=" + userId;
		
		try {
			con = getConnection();
			smt = con.createStatement();
			
			//DBにSQL文を発行
			ResultSet rs = smt.executeQuery(sql);
			
			//取得した検索結果をUserオブジェクトに格納
			if(rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setLoginId(rs.getString("login_id"));
				user.setFamilyName(rs.getString("family_name"));
				user.setFirstName(rs.getString("first_name"));
				user.setFamilyNameKana(rs.getString("family_name_kana"));
				user.setFirstNameKana(rs.getString("first_name_kana"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
				user.setNickName(rs.getString("nick_name"));
				user.setPostcode(rs.getString("postcode"));
				user.setAddressPrefecture(rs.getString("address_prefecture"));
				user.setAddressOrder(rs.getString("address_order"));
				user.setApartment(rs.getString("apartment"));
				user.setPhoneNumber(rs.getString("phone_number"));
				user.setLeaveFlag(rs.getInt("leave_flag"));
				user.setLeaveDate(rs.getString("leave_date"));
				user.setInsertDate(rs.getString("insert_date"));
				user.setUpdateDate(rs.getString("update_date"));
			}
		}catch(Exception e) {
			throw new IllegalStateException(e);
			
		}finally {
			//リソースの開放
			if(smt != null) {
				try {
					smt.close();
				}catch(SQLException ignore) {}
			}
			if(con != null) {
				try {
					con.close();
				}catch(SQLException ignore) {}
			}
		}
		return user;
	}
	
	/**
	 * userテーブルに引数のユーザー情報の新規登録処理を行うメソッド
	 */
	public void insert(User user) {
		//変数宣言
		Connection con = null;
		Statement smt = null;
		
		//SQL文作成
		String sql = "INSERT INTO user VALUES(" + null + ",'" +
						user.getLoginId() + "','" +
						user.getFamilyName() + "','" +
						user.getFirstName() + "','" +
						user.getFamilyNameKana() + "," + 
						user.getAge() + ",'" +
						user.getEmail() + "','" +
						user.getNickName() + "','" +
						user.getPostcode() + "','" +
						user.getAddressPrefecture() + "','" +
						user.getAddressOrder() + "','" +
						user.getApartment() + "','" +
						user.getPhoneNumber() + "'," +
						0 + ",'" +
						null + "','" + 
						"CURRENT_TIMESTAMP()','" +
						null + "'";
		
		try {
			con = getConnection();
			smt = con.createStatement();
			
			//DBにSQL文を発行
			smt.executeUpdate(sql);
			
		}catch(Exception e) {
			throw new IllegalStateException(e);
			
		}finally {
			if(smt != null) {
				try {
					smt.close();
				}catch(SQLException ignore) {}
			}
			if(con != null) {
				try {
					con.close();
				}catch(SQLException ignore) {}
			}
		}
	}
	
	/**
	 * 引数のユーザー情報を元にuserテーブルの情報を更新するメソッド
	 */
	public void update(User user) {
		//変数宣言
		Connection con = null;
		Statement smt = null;
		
		//SQL文作成
		String sql = "UPDATE user SET login_id='" + user.getLoginId() +
						"',family_name='" + user.getFamilyName() +
						"',first_name='" + user.getFirstName() +
						"',family_name_kana='" + user.getFamilyNameKana() +
						"',first_name_kana='" + user.getFirstNameKana() +
						"',age=" + user.getAge() +
						",email='" + user.getEmail() +
						"',nick_name='" + user.getNickName() +
						"',postcode='" + user.getPostcode() +
						"',address_prefecture='" + user.getAddressPrefecture() +
						"',address_order='" + user.getAddressOrder() +
						"',apartment='" + user.getApartment() +
						"',phone_number='" + user.getPhoneNumber() +
						"',update_date='CURRENT_TIMESTAMP()'";
		
		try {
			con = getConnection();
			smt = con.createStatement();
			
			//DBにSQL文を発行
			smt.executeUpdate(sql);
			
		}catch(Exception e) {
			throw new IllegalStateException(e);
			
		}finally {
			//リソースの開放
			if(smt != null) {
				try {
					smt.close();
				}catch(SQLException ignore) {}
			}
			if(con != null) {
				try {
					con.close();
				}catch(SQLException ignore) {}
			}
		}
	}
	
	/**
	 * 引数のユーザー情報を元に該当ユーザーの退会処理を行うメソッド
	 */
	public void withdrawal(User user) {
		//変数宣言
		Connection con = null;
		Statement smt = null;
		
		//SQL文作成
		String sql = "UPDATE user SET leave_flag=" + 1 + ",leave_date='CURRENT_TIMESTAMP()'";
		
		try {
			con = getConnection();
			smt = con.createStatement();
			
			//DBにSQL文発行
			smt.executeQuery(sql);
			
		}catch(Exception e) {
			throw new IllegalStateException(e);
			
		}finally {
			//リソースの開放
			if(smt != null) {
				try {
					smt.close();
				}catch(SQLException ignore) {}
			}
			if(con != null) {
				try {
					con.close();
				}catch(SQLException ignore) {}
			}
		}
	}
}
