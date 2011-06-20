package com.baizhi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baizhi.commons.component.VerificationCodeUtils;

public class ImageCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 4432412104500525850L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("VerificationCode", new VerificationCodeUtils().generateImageCode(response.getOutputStream()));
	}

}
