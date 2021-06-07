package J210531.ch18;

import java.net.*;
import java.sql.DriverManager;

import com.google.gson.Gson;
import java.sql.*;
import java.io.*;

public class RemoteJson {

    public static void main(String[] args) throws Exception {
        String site = "https://jsonplaceholder.typicode.com/posts";
        URL url = new URL(site);

        URLConnection con = url.openConnection();
        
        InputStream stream = con.getInputStream();
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = null;
        StringBuffer buf=new StringBuffer();
        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            buf.append(line);
        }

        Gson gson = new Gson();
        Post[] posts = gson.fromJson(buf.toString(),Post[].class);
        insertIntoDB(posts);
        // 각 사용자의 포스트 총 합과 타이틀 글 자 수 합하기
        // 그리고 DB에 넣기 (DB에 넣고 수를 구하기)

        // gson.fromJson("{'name' : 'gdhon', 'age' : 10, 'graudated' : false }", Person.class);
        
        /**
         * Person p = new Person();
         * p.setName("gdhon");
         * p.setAge(10);
         */

        // for(Post post : posts)
        // {
        //     System.out.println("userId : " + post.getUserId()+ ", id : " + post.getId());
        // }


        bufferedReader.close();
    }

    private static void insertIntoDB(Post[] posts) throws Exception
    {
        // 드라이버 로딩
        // DB 서버에 연결하고
        // Connection con = DriverManager.getConnection(url, user, password);
        /**
         * create table posts ( userId int,
         *                      id int, primary key,
         *                      title varchar(50),
         *                      body text)
         */

         Class.forName("org.mariadb.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/oop","root","root");
         String sql = "insert into posts(userId, id, title, body) values(?,?,?,?)";
         PreparedStatement pStmt = con.prepareStatement(sql);

         for(Post post : posts)
         {
             pStmt.setInt(1,post.getUserId());
             pStmt.setInt(2,post.getId());
             pStmt.setString(3, post.getTitle());
             pStmt.setString(4,post.getBody());
             pStmt.executeUpdate();
         }

    }
    
}

class Person {
    // JavaBean 형태로 클래스 정의
    // 1. private member 변수에 대한 public getter와 setter를 가진다.
    // 2. default 생성자를 가진다.
    private String name;
    private int age;
    private boolean graduated;

    private void setName(String name)
    {
        this.name = name;
    }
    private String getName()
    {
        return name;
    }
    private void setAge(int age)
    {
        this.age = age;
    }
    private int getAge()
    {
        return age;
    }
    private void setGraduated(boolean graduated)
    {
        this.graduated = graduated;
    }
    private boolean getGraduated()
    {
        return graduated;
    }
}
