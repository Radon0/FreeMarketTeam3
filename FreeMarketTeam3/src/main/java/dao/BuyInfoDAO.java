/*
 * 作成日：6/19
 * 作成者：川野里花
 * プログラム：購入関連のDAO
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.BuyInfo;

public class BuyInfoDAO {
	//DB接続のための情報を設定
	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost/freemarket_db";
	private static String USER = "root";
	private static String PASSWD = "root123";
	
	
	/**
	 * DB接続を行うメソッド
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
	 * 購入一覧表示メソッド
	 * DBから購入情報を検索し、結果セットをArrayListに格納する。buylistを戻り値として返す。
	 * @return buyList
	 */
		public ArrayList<BuyInfo> selectAll() {

			Connection con = null;
			Statement smt = null;
			// 検索した購入情報を格納するAllayListオブジェクトを生成
			ArrayList<BuyInfo> buylist = new ArrayList<BuyInfo>();

			try {
				// select文を文字列として定義
				String sql = "SELECT*FROM buy ORDER BY orderId";

				con = getConnection();
				smt = con.createStatement();

				// SQL送信
				ResultSet rs = smt.executeQuery(sql);

				// 結果セットから書籍データを検索件数分全て取り出し、Arraylistに格納
				while (rs.next()) {
					BuyInfo buyinfo = new BuyInfo();

					
					buyinfo.setOrderId(rs.getInt("orderId"));
					buyinfo.setProductId(rs.getInt("productId"));
					buyinfo.setSellerUserId(rs.getInt("sellerUserId"));
					buyinfo.setOrderQuantity(rs.getInt("orderQuantity"));
					buyinfo.setOrderedDate(rs.getString("orderedDate"));
					buyinfo.setShippingFlag(rs.getInt("shippingFlag"));
					buylist.add(buyinfo);
				}
				// リソースの開放
			} catch (Exception e) {
				throw new IllegalStateException(e);
			} finally {
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
			return buylist;
		}
		
		/**
		 * 文字列の登録
		 * @param buyinfo
		 */
			public void insert(BuyInfo buyinfo) {
				Connection con = null;
				Statement smt = null;

				try {

					String sql = "INSERT INTO buy VALUES(NULL,'" 
							 +buyinfo.getOrderId()+"','"
							 + buyinfo.getProductId() + "','"
							 + buyinfo.getSellerUserId() + "','"
							 + buyinfo.getOrderQuantity() + ','
							+buyinfo.getOrderedDate()+"','"
							+buyinfo.getShippingFlag()+",CURDATE())";

					con = getConnection();
					smt = con.createStatement();

					smt.executeUpdate(sql);

				} catch (Exception e) {
					throw new IllegalStateException(e);
				} finally {
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
			}
	
}
