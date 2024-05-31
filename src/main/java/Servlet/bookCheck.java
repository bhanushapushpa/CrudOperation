package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Connection.crudConnection;
import Entity.book;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
maxFileSize = 1024 * 1024 * 1000, // 1 GB
maxRequestSize = 1024 * 1024 * 1000)
public class bookCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		try {
			
			
			String b_bookName,b_autherName,b_pName, b_price, b_description;
			Part b_image;
			HttpSession session = request.getSession();
			
			
			b_bookName = request.getParameter("BookName");
			b_price = request.getParameter("BookPrice");
			b_autherName = request.getParameter("AuthorName");
			b_pName = request.getParameter("PublicationName");
			b_description = request.getParameter("Description");

			/*Add image in part*/
			b_image = request.getPart("foodImage");
			InputStream is = b_image.getInputStream();
			
			String fileName = b_image.getSubmittedFileName();

			String folderName = "Img";
			String uploadPath = request.getServletContext().getRealPath("") + File.separator + folderName; 
			System.out.println(uploadPath);
			File dir = new File(uploadPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			
			
			Files.copy(is, Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);

			book b = new book(b_bookName,fileName,b_autherName,b_pName,b_description,b_price);
			
			crudConnection conn = new crudConnection();
			
			Boolean check = conn.insertBook(b);

						

			if (check) {
				session.setAttribute("Done", "Updated Successfully");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} else {
				session.setAttribute("Done", "Technical issue");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

		
	}


