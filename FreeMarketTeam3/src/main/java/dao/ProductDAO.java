package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Product;

public class ProductDAO {

	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	private static String URL = "jdbc:mariadb://localhost/freemarket_db";
	private static String USER = "root";
	private static String PASSWD = "root123";

	/**
	 * DB接続を行うメソッド
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
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
	 * すべて検索するメソッド(SELECT)
	 * 
	 * @return ArrayList<product>
	 */
	public ArrayList<Product> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Product> productList = new ArrayList<Product>();

		try {
			// SQL文
			String sql = "SELECT * FROM" + "product A RIGHT JOIN image B" + "ON A.product_id = B.product_id";

			// データベース接続の準備
			con = ProductDAO.getConnection();
			smt = con.createStatement();

			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// 1行ずつ確認
			while (rs.next()) {
				// productオブジェクトの生成
				Product product = new Product();

				// 取得した値を設定していく
				product.setProductId(rs.getInt("product_id"));
				product.setSellerUserId(rs.getInt("seller_user_id"));
				product.setCategory(rs.getString("category"));
				product.setLocation(rs.getString("location"));
				product.setProductName(rs.getString("product_name"));
				product.setQuantity(rs.getInt("quantity"));
				product.setPrice(rs.getInt("price"));
				product.setRemarks(rs.getString("remarks"));
				product.setSellDate(rs.getDate("sell_date"));
				product.setUpdateDate(rs.getDate("update_date"));
				product.setStockFlag(rs.getInt("stock_flag"));
				product.setImageId(rs.getInt("image_id"));
				product.setImage(rs.getString("image"));
				product.setDescription(rs.getString("description"));

				// 設定したデータ１行分をListに追加していく
				productList.add(product);
			}

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

		return productList;
	}

	// 出品者のユーザーIDからニックネームを取ってくる必要がある？
	/**
	 * IDをもとに検索するメソッド(SELECT)
	 * 
	 * @return ArrayList<product>
	 */
	public ArrayList<Product> selectByProductId(int productId) {

		Connection con = null;
		Statement smt = null;

		ArrayList<Product> productList = new ArrayList<Product>();

		try {
			// SQL文
			String sql = "SELECT product.product_name, product.price, image.image, image.description, user.nick_name"
					+ "FROM product A" + "INNER JOIN image B ON A.product_id = B.product_id"
					+ "INNER JOIN user C ON A.seller_user_id = C.user_id" + "WHERE product_id = " + productId + ";";

			// データベース接続の準備
			con = ProductDAO.getConnection();
			smt = con.createStatement();

			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// 1行ずつ確認
			while (rs.next()) {
				// productオブジェクトの生成
				Product product = new Product();

				// 取得した値を設定していく
				product.setProductId(rs.getInt("product_id"));
				product.setSellerUserId(rs.getInt("seller_user_id"));
				product.setProductName(rs.getString("product_name"));
				product.setPrice(rs.getInt("price"));
				product.setImage(rs.getString("image"));
				product.setDescription(rs.getString("description"));
				product.setNickName(rs.getString("nick_name"));

				// 設定したデータ１行分をListに追加していく
				productList.add(product);
			}

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

		return productList;
	}

	/**
	 * 登録するメソッド(INSERT)
	 */
	public void insert(Product product) {

		Connection con = null;
		Statement smt = null;

		try {
			// SQL文
			String sql = "INSERT INTO product A" + "INNER JOIN image B" + "ON A.product_id = B.product_id" + "VALUES("
					+ product.getProductId() + ", " + product.getSellerUserId() + ", '" + product.getCategory() + "', '"
					+ product.getLocation() + "', '" + product.getProductName() + "', " + product.getQuantity() + ", "
					+ product.getPrice() + ", '" + product.getRemarks() + "', '" + product.getSellDate() + "', '"
					+ product.getUpdateDate() + "', " + product.getStockFlag() + ", " + product.getImageId() + ", '"
					+ product.getImage() + "', '" + product.getDescription() + "';";

			// データベース接続の準備
			con = ProductDAO.getConnection();
			smt = con.createStatement();

			// SQL文発行
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

	/**
	 * 更新するメソッド(UPDATE)
	 */
	public void update(Product product) {

		Connection con = null;
		Statement smt = null;

		try {
			// SQL文
			String sql = "UPDATE product SET" + "category = '" + product.getCategory() + "', " + "product_name = '"
					+ product.getProductName() + "', " + "quantity = " + product.getQuantity() + ", " + "price = "
					+ product.getPrice() + ", " + "remarks = '" + product.getRemarks() + "'" + "WHERE product_id = "
					+ product.getProductId() + ";";

			// データベース接続の準備
			con = ProductDAO.getConnection();
			smt = con.createStatement();

			// SQL文発行
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

	/**
	 * IDをもとに削除するメソッド(DELETE)
	 */
	public void delete(int productId) {

		Connection con = null;
		Statement smt = null;

		try {
			// SQL文
			String sql = "DELETE FROM product" + "WHERE product_id = " + productId;

			// データベース接続の準備
			con = ProductDAO.getConnection();
			smt = con.createStatement();

			// SQL文発行
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