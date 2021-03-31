package org.itstep.blog.dao;

import org.itstep.blog.entity.Blog;
import org.itstep.blog.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbManager {

    private static Connection connection;

    private static final String URL = "jdbc:sqlite:C:/Users/Sten/Desktop/STEP/Java/CW/Blog/identifier.sqlite";

    private static final String GET_USER_BY_EMAIL = "SELECT * FROM USERS where email = ?";
    private static final String INSERT_NEW_USER = "INSERT INTO USERS(email, full_name, password) VALUES(?, ?, ?)";
    private static final String INSERT_NEW_BLOG = "INSERT INTO BLOGS(title, content, author, date) VALUES(?, ?, ?, current_date)";
    private static final String GET_ALL_BLOGS = "SELECT b.id, b.title, b.content, b.author, b.date, u.full_name, u.email FROM BLOGS b JOIN USERS u ON u.id = b.author";
    private static final String DELETE_BLOG_BY_ID = "DELETE from BLOGS where id = ?";
    private static final String UPDATE_BLOG = "UPDATE BLOGS set title = ?, content = ?, date = current_date where id = ?";
    private static final String UPDATE_USER_FULLNAME = "UPDATE USERS set full_name=? where email = ?";
    private static final String UPDATE_USER_PASSWORD = "UPDATE USERS set password=? where email = ?";
    private static final String UPDATE_USER_PHOTO = "UPDATE USERS set photo=? where id = ?";


    static {
        try {
            Class.forName("org.sqlite.JDBC"); // определяем драйвер
            connection = DriverManager.getConnection(URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUserByEmail(String email) {
        User user = null;
        try {

            PreparedStatement statement = connection.prepareStatement(GET_USER_BY_EMAIL);
            statement.setString(1, email);
            ResultSet set = statement.executeQuery();

            if (set.next()) {
                user = new User(
                        set.getLong(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                    set.getString(5)

                    /*
                    *  set.getLong("id"),
                    set.getString("email"),
                    set.getString("ful_name"),
                    set.getString("password")
                    * */
                );
            }

            set.close();
            statement.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }

    public static void createNewUser(User user) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_NEW_USER);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getFullName());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Blog> GetAllBlogs() {
        List<Blog> allBlogs = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_ALL_BLOGS);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                allBlogs.add(
                        new Blog(resultSet.getLong("id"),
                                resultSet.getString("title"),
                                resultSet.getString("content"),
                                new User(
                                        resultSet.getLong("id"),
                                        resultSet.getString("email"),
                                        resultSet.getString("full_name"),
                                        null),
                                resultSet.getString("date"))
                );
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allBlogs;
    }

    public static boolean createNewBlog(Blog blog) {
        int row = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_NEW_BLOG);
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setLong(3, blog.getAuthor().getId());
            row = statement.executeUpdate();

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    public static boolean deleteBlogById(Long id) {
        int row = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_BLOG_BY_ID);
            statement.setLong(1, id);

            row = statement.executeUpdate();

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    public static boolean updateBlog(String title, String content, Long id) {
        int row = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_BLOG);
            statement.setString(1, title);
            statement.setString(2, content);
            statement.setLong(3, id);

            row = statement.executeUpdate();

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    public static boolean UpdateUserFullName(String fullname, String email) {
        int row = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER_FULLNAME);
            statement.setString(1, fullname);
            statement.setString(2, email);
            row = statement.executeUpdate();

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row > 0;
    }

    public static boolean UpdateUserPassword(String password, String email) {
        int row = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER_PASSWORD);
            statement.setString(1, password);
            statement.setString(2, email);
            row = statement.executeUpdate();

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row > 0;
    }

    public static boolean UpdateUserPhoto(String photo, Long id) {
        int row = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER_PHOTO);
            statement.setString(1, photo);
            statement.setLong(2, id);
            row = statement.executeUpdate();

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row > 0;
    }

}
