package j210521.ch18;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;
import java.sql.*;

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

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        
        if(e.getSource() == nextBtn)
        {
            try {
                rs.next();
                /** 현재 레코드의 칼럼값을 읽어와,
                 * JTextField의 값으로 설정한다.
                 * idFeild, titleField, publisherField,
                 * yearField, priceField
                 */

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

            } catch (Exception err)
            {
                err.printStackTrace();
            }
            
        }


    }


    
}
