package servlet;

import java.io.IOException;
import java.util.ArrayList;

import bean.Mail;
import bean.User;
import dao.MailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// エラー
		String error = null;
		String errorCmd = null;

		// 宣言
		HttpSession session = null;
		ArrayList<Mail> messageList = null;

		try {
			// エンコード
			request.setCharacterEncoding("UTF-8");

			session = request.getSession();

			// 入力パラメータの取得
			User user = (User) session.getAttribute("user");
			int productId = Integer.parseInt(request.getParameter("product_id"));
			String cmd = request.getParameter("cmd");
			String text = request.getParameter("message");
			int sendFlag = 0;

			// インスタンス化
			MailDAO mailDaoObj = new MailDAO();

			if (user.getUserId() == 0) {
				sendFlag = 1;
			}

			if (cmd.equals("send")) {
				mailDaoObj.send(productId, user, text, sendFlag);
			}

			// メール情報を取得
			messageList = mailDaoObj.selectByProduct(productId, user);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、メッセージは表示できません。";
			errorCmd = "logout";
		} finally {
			if (error != null) {
				// リクエストスコープに登録
				request.setAttribute("error", error);
				request.setAttribute("errorCmd", errorCmd);
				// error.jspにフォワード
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			} else {
				// リクエストスコープに登録
				request.setAttribute("messageList", messageList);
				// message.jspにフォワード
				request.getRequestDispatcher("/view/message.jsp").forward(request, response);
			}
		}
	}
}
