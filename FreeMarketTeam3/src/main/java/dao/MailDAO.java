package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Mail;
import bean.User;

public class MailDAO {
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
	 * 全メール情報を取得するメソッド
	 * 
	 * @return mailList
	 */
	public ArrayList<Mail> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Mail> mailList = null;

		try {
			// SQL文
			String sql = "SELECT * FROM mail ORDER BY mail_id";

			// オブジェクトの生成
			con = getConnection();
			smt = con.createStatement();

			// 結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			// インスタンス化
			mailList = new ArrayList<Mail>();

			Mail mail = null;

			// 全書籍データをmailListに格納
			while (rs.next()) {
				mail = new Mail();
				mail.setMailId(rs.getInt("mail_id"));
				mail.setProductId(rs.getInt("product_id"));
				mail.setPlanBuyUserId(rs.getInt("plan_buy_user_id"));
				mail.setMessage(rs.getString("message"));
				mail.setSendDate(rs.getString("send_date"));
				mail.setReadFlag(rs.getInt(rs.getString("read_flag")));
				mail.setDeleteFlag(rs.getInt(rs.getString("delete_flag")));
				mailList.add(mail);
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// クローズ処理
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

		// メールリストを返す
		return mailList;
	}

	/**
	 * 該当するメール情報を取得するメソッド
	 * 
	 * @return mailList
	 */
	public ArrayList<Mail> selectByProduct(int productId, User user) {

		Connection con = null;
		Statement smt = null;

		ArrayList<Mail> mailList = null;

		try {
			// SQL文
			String sql = "SELECT * FROM mail WHERE product_id = " + productId + " AND plan_buy_user_id = "
					+ user.getUserId() + " ORDER BY send_date DESC";

			// オブジェクトの生成
			con = getConnection();
			smt = con.createStatement();

			// 結果セットを取得
			ResultSet rs = smt.executeQuery(sql);

			// インスタンス化
			mailList = new ArrayList<Mail>();

			Mail mail = null;

			// 全書籍データをmailListに格納
			while (rs.next()) {
				mail = new Mail();
				mail.setMailId(rs.getInt("mail_id"));
				mail.setProductId(rs.getInt("product_id"));
				mail.setPlanBuyUserId(rs.getInt("plan_buy_user_id"));
				mail.setMessage(rs.getString("message"));
				mail.setSendDate(rs.getString("send_date"));
				mail.setReadFlag(rs.getInt(rs.getString("read_flag")));
				mail.setDeleteFlag(rs.getInt(rs.getString("delete_flag")));
				mailList.add(mail);
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// クローズ処理
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

		// メールリストを返す
		return mailList;
	}

	/**
	 * メッセージを送信するメソッド
	 * 
	 * @return mailList
	 */
	public int send(int productId, User user, String message, int sendFlag) {

		Connection con = null;
		Statement smt = null;

		int rowCounts = 0;

		try {
			// SQL文
			String sql = "INSERT INTO mail VALUES (NULL, '" + productId + "', '" + user.getUserId() + "', '" + message
					+ "', 'CURRENT_TIMESTAMP', '" + sendFlag + "', '0', '0');";

			// オブジェクトの生成
			con = getConnection();
			smt = con.createStatement();

			// 結果セットを取得
			rowCounts = smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// クローズ処理
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

		// 変更件数を返す
		return rowCounts;
	}
	
	/**
	 * 未完成！！！！！！！！！
	 * 既読フラグを更新するメソッド
	 * 
	 * @param sendFlag
	 * @return rowCounts
	 */
	public int read(int sendFlag) {

		Connection con = null;
		Statement smt = null;

		int rowCounts = 0;

		try {
			// SQL文
			String sql = "UPDATE mail SET read_flag = 1 WHERE send_flag = "+sendFlag;

			// オブジェクトの生成
			con = getConnection();
			smt = con.createStatement();

			// 結果セットを取得
			rowCounts = smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// クローズ処理
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

		// 変更件数を返す
		return rowCounts;
	}
}
