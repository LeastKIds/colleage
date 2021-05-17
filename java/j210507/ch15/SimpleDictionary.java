package j210507.ch15;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class SimpleDictionary extends JPanel implements ActionListener{
    
    // 입력 필드, 버튼 2개
    private JTextField inputField=new JTextField(30);
    private JButton searchBtn=new JButton("검색");
    private JButton addBtn=new JButton("추가");

    private static final String JDBC_CLASS_NAME = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/oop3";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    // 한영사전 : 한글단어와 대응되는 영어단어의 쌍을 저장
    // Map<String, String> dict=new HashMap<>();
    // private static final String DIC_FILE_NAME = "./j210507/ch15/dict.props";

    String key="";
    String value="";


    public SimpleDictionary()
    {
        this.add(inputField);
        this.add(searchBtn);
        this.add(addBtn);
        
        searchBtn.addActionListener(this);
        addBtn.addActionListener(this);

        this.setPreferredSize(new Dimension(600,50));
        // buildDictionaryFromFile();
        
        // JDBC 드라이버를 메모리에 적재하기
        // JDBC 드라이버 클래스 이름은 DBMS 마다 다르다.
        try {
            Class.forName(JDBC_CLASS_NAME);
            // buildDictionaryFromDB();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        

        
    }

    // private void buildDictionaryFromFile()
    // {
    //     Properties props = new Properties();
    //     try(FileReader fReader = new FileReader(DIC_FILE_NAME))
    //     {
    //         props.load(fReader);
    //     } catch(Exception e)
    //     {
    //         System.out.println(e.getMessage());
    //     }
        
    //     Set<Object> set = props.keySet();
    //     for(Object key : set)
    //     {
    //         System.out.println("key : " + key);
    //         Object value = props.get(key);
    //         dict.put((String) key, (String) value);
    //     }
    // }


    @Override
    public void actionPerformed(ActionEvent e) {

        key=inputField.getText();    // 공통적으로 수행하는 것
        // System.out.println("[" + key + "]");
        if(key.trim().length()==0)
            return;
        
        // TODO Auto-generated method stub
        if(e.getSource() == searchBtn)
        {   // 검색 버튼이 클릭 된 경우
            /*
                inputField에 입력된 단어를 추출
                dict 맵 객체에서 그 단어에 대응되는 
                영어 단어를 찾아 디스플레이.
            */
            // String value = dict.get(key);

            buildDictionaryFromDB("search",key,"");
            if(value == null)   // 그 key에 대응되는 영단어가 없는 경우
            {   // 없다고 디스플레이
                JOptionPane.showMessageDialog(this, "단어를 찾을 수 없습니다.", key, JOptionPane.ERROR_MESSAGE);
            }else
            {   // 대응되는 단어를 디스플레이
                JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);

            }
        }else if(e.getSource() == addBtn)
        {   // 추가 버튼이 클릭된 경우
            /*
                imputField에 입력된 단어를 추출
                그 단어에 대응되는 영어 단어를 입력받고
                dict 맵 객체에 <한글단어, 영어단어>의 쌍을 추가
            */
            value=JOptionPane.showInputDialog(this, key + "에 대응되는 영어단어를 입력하세요.");
            if(value==null || value.trim().length() == 0 )
                return;
            
            // dict.put(key,value);
            // dict.put(value,key);

            buildDictionaryFromDB("add",key,value);
            JOptionPane.showMessageDialog(this, "영어 단어가 추가되었습니다.", "성공", JOptionPane.INFORMATION_MESSAGE);

        }

        inputField.requestFocus();
        
    }

    // private void addWordToFile(String key, String value)
    // {
    //     try(FileWriter fWriter = new FileWriter(DIC_FILE_NAME)){
    //         String str=key + " = " +value + "\n";
    //         fWriter.write(str);
    //     }catch(Exception e){
    //         System.out.println(e.getMessage());
    //     }
    // }

    public static void main(String[] args)
    {
        JFrame frame=new JFrame();
        frame.add(new SimpleDictionary());

        frame.setTitle("나의 한영사전");
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void buildDictionaryFromDB(String button, String key, String value)
    {
        // 데이터베이스 연결하기
        try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);) {
            if(button.equals("search"))
            {
                // where 절 보단 전부다 불러와서 따로 map 을 만들어서 해야 할 듯
                String sql="select * from dict where kor = '" + key + "'";
                // PreparedStatement 객체는 실행 준비가 완료된 SQL 객체
                PreparedStatement pStatement = con.prepareStatement(sql);

                // Insert, Delete, Update 문 의 실행은
                // executeUpdate() 메소드를 호출 하고
                // select 문의 실행은 executeQuery() 메서드를 호출`
                ResultSet rs= pStatement.executeQuery();
                value = rs.getString("eng");
                // while(rs.next())
                // {
                //     // rs.getString(1);
                //     String key = rs.getString("kor");
                //     String value = rs.getString("eng");

                //     System.out.println(key + " : " + value);
                // }
            }else if(button.equals("add"))
            {
                String sql = "insert into dict values(?,?)";
                /**
                 *  실행준비
                 *  1. 문법 검사
                 *  2. 정당성 검사(테이블, 칼럼 등이 실제로 있는지, 있다면 이 사용자가 레코드를 삽
                 *  3. 실행계획을 세운다. (execution plan)
                 */
                PreparedStatement pStatement = con.prepareStatement(sql);

                /**
                 *  ? 자리의 칼럼 데이터 타입에 따라
                 *  적절한 setXXX() 메서드를 호출해야 한다.
                 *  예를 들어, 칼럼이 char 또는 varChar타입이면 setString()
                 *  칼럼이 TimeStamp 타입이면 setData(), setTimestamp(),
                 *  칼럼이 int 타입이면 setInt()...
                 */
                pStatement.setString(1,key);
                pStatement.setString(2, value);
                // Insert, Delete, Update 문을 실행할 때는 executeUpdate() 문을 생성
                System.out.println(pStatement.executeUpdate());
            }
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
