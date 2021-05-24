package j210521.ch18;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class TableViewer extends JFrame implements ActionListener{

    private JTextField idField, titleField, publisherField, yearField, priceField;
    private JButton previousBtn, nextBtn, insertBtn, finishBtn;
    private ResultSet rs=null;
    private Connection con=null;

    public TableViewer()
    {

        // **************************************************************
        // TableViewer 객체가 생성될 때, DB의 Books 테이블의
        // 레코드들을 읽어 온다.
        // 1. 데이터베이스와 연결
        // 2. select 문 실행하고 반환된 ResultSet 객체를 가지고 있어야 함.
        // **************************************************************

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/oop","root","root");
            String sql="select * from books";
            PreparedStatement pStmt=con.prepareStatement(sql);
            rs=pStmt.executeQuery();
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("DB 연결에 문제가 있어 프로그램을 종료합니다.");
            e.printStackTrace();
            System.exit(0);
        }


        // 각 컴포넌트를 frame에 추가하기
        this.setLayout(new GridLayout(0,2));
        this.add(new JLabel("ID",JLabel.CENTER));
        idField = new JTextField(10);
        this.add(idField);

        this.add(new JLabel("Title",JLabel.CENTER));
        titleField = new JTextField(10);
        this.add(titleField);

        this.add(new JLabel("Publisher",JLabel.CENTER));
        publisherField = new JTextField(10);
        this.add(publisherField);

        this.add(new JLabel("Year",JLabel.CENTER));
        yearField = new JTextField(10);
        this.add(yearField);

        this.add(new JLabel("Price",JLabel.CENTER));
        priceField = new JTextField(10);
        this.add(priceField);

        previousBtn = new JButton("Previous");
        previousBtn.addActionListener(this);
        this.add(previousBtn);

        nextBtn = new JButton("Next");
        nextBtn.addActionListener(this);
        this.add(nextBtn);

        insertBtn = new JButton("Insert");
        insertBtn.addActionListener(this);
        this.add(insertBtn);

        finishBtn = new JButton("Finish");
        finishBtn.addActionListener(this);
        this.add(finishBtn);

        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(350,200);
        this.setVisible(true);

        
        

    }
    public static void main(String[] args)
    {
        new TableViewer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
            if(e.getSource() == nextBtn || e.getSource() == previousBtn)
            {
                if(e.getSource() == nextBtn)
                {
                    rs.next();
                    /** 현재 레코드의 칼럼값을 읽어와,
                     * JTextField의 값으로 설정한다.
                     * idFeild, titleField, publisherField,
                     * yearField, priceField
                     */
                } else if(e.getSource() == previousBtn) {
                    rs.previous();
                }

                int bookId = rs.getInt("book_id");
                idField.setText(String.valueOf(bookId));
                String title =rs.getString("title");
                titleField.setText(title);
                String publisher = rs.getString("publisher");
                publisherField.setText(publisher);
                Date year = rs.getDate("year"); //java.sql.Date
                yearField.setText(year.toString());
                int price = rs.getInt("price");
                priceField.setText(String.valueOf(price));
            } else if (e.getSource() == insertBtn) {
                // 이미 연결은 되어 있고...
                // 이미 연결 정보를 가지고 있는 Connection 객체를
                // insert 문을
                // 이용해 prepare하고
                // 반환된 PreparedStatement 객체를 이용해서
                // 실행요청을 서버에 보낸다

                // Statement 또는 PreparedStatement 객체를 사용할 수 있다.
                // 그런데, PreparedStatement 객체사용을 권고한다.
                // 왜냐하면 Statement 객체를 사용해 프로그래밍을 잘 못하면
                // 보안상의 취약점을 만들 수 있다.
                // SQL Injection 방법을 사용한 해커의 공격을 받을 수 있다.
                // PreparedStatement의 경우에는 ???? 를 사용할 수 있지만 Statement는 사용 못함

                String sql = "insert into books(title,publisher,year,price) values(?,?,?,?)";
                PreparedStatement pStmt = con.prepareStatement(sql);


                /**
                 * ? 자리에 들어갈 값을 설장을 먼저 한 후에, 실행 요청을 서버에 보내야 한다.
                 * ? 자리에 값을 설정할 때, 대응되는 칼럼의 데이터 타입에 따라 적절한 setXXX 메서드를 호출해야 한다.
                 * 예를 들어, ?에 대응되는 칼럼이 title이고, 그 칼럼의 데이터타입이 varchar이면 setString
                 * ?에 대응되는 칼럼이 price이고, 그 칼럼의 데이터 타입이 int이면 setInt 메서드를 호출...
                 */

                String title = titleField.getText();
                pStmt.setString(1,title);
                String publisher = publisherField.getText();
                pStmt.setString(2,publisher);
                String year = yearField.getText();
                // 문자열로부터 java.util.Date 객체를 생성할 수 있는
                // SimpleDateFormat 객체를 생성한다.
                // 이 때, date 값을 포맷을 알려준다.

                // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                // // import java.sql.*;
                // // Date date = new Date(sdf.parse(year).getTime());    // sdf.pase는 java.util.Date 반환
                // // 문자열을 parsing 해서 java.util.Date 객체를 생성
                // java.util.Date date=sdf.parse(year);
                // // java.util.Date 객체로 부터 java.sql.Date 객체 생성
                // java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                // // java.sql.Date 객체 값을 3번째 ? 자리에 설정

                pStmt.setDate(3,Date.valueOf(year));

                String price = priceField.getText();
                pStmt.setInt(4,Integer.valueOf(price));


                // 실행할 SQL문이 select 문인 경우에는 executeQuery 메서드를 호출
                // 실행할 SQL문이 insert, delete, 또는 update일 경우에,
                // executeUpdate 메서드를 호출
                pStmt.executeUpdate();
                reloading();
            } else if(e.getSource() == finishBtn) {
                System.out.println("프로그램을 종료합니다.");
                con.close();
                this.dispose();
                System.exit(0);
            }
            
            


        } catch (Exception err)
        {
            JOptionPane.showMessageDialog(this, "오류발생["+err.getMessage()+"]");
            err.printStackTrace();
        }


    }

    private void reloading() throws Exception
    {
        String sql = "select * from books order by book_id desc";
        PreparedStatement pStmt = con.prepareStatement(sql);
        rs.close();
        rs=pStmt.executeQuery();
       
        
    }


    
}
