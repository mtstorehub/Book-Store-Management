
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class mainproject extends javax.swing.JFrame {
    Connection con;
    Statement stmt;
    ResultSet rs;
    String sql;
    int count=0;
    int bound;
    int last_start;
    int last_end;
    final int FETCH_ROW=8;
    BookPanel cv;
    static String mail_session;
    static String address_session;
    /**
    
     */
   public mainproject() {
        initComponents();
   }
    public mainproject(String session_email) {
        initComponents();
        System.out.println("main prjecct "+session_email);
        mail_session=session_email;
        lblEmail.setText(mail_session);
        //CustomerLogin cl=new CustomerLogin();
       
        createDB();
        try{
            stmt=con.createStatement();
            
            sql="select Address,Name from Member where Email ='"+session_email+"'";
            rs=stmt.executeQuery(sql);
            rs.next();
            address_session=rs.getString("Address");
            lblName.setText(rs.getString("Name"));
            
            sql="select count(*) as rowcount from Book";
            
            rs=stmt.executeQuery(sql);
            rs.next();
            int row_count=rs.getInt("rowcount");
            System.out.println(row_count);
           
            stmt.close();
            con.close();
       
        bound=(int) Math.ceil((float)row_count/FETCH_ROW);
        last_start=(row_count/FETCH_ROW)*FETCH_ROW;
        last_end=last_start+(row_count%FETCH_ROW);      
        btnPrev.setEnabled(false);
        
        Data_Inflate(0,8);
        
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        
    }
    
    
    
    void createDB(){
          try{
              //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
              con=DriverManager.getConnection("jdbc:ucanaccess://bookshop.accdb","","" );
              System.out.println("OK ***");
              
          }catch(Exception e){
              System.out.println("createDB Error !!!");
              
      
          }
      }
    
    public void Data_Inflate(int start,int end){
        
        
        createDB();
        try {
            stmt=con.createStatement();
            sql="select * from Book limit "+start+","+end;
            rs=stmt.executeQuery(sql);
            while(rs.next()){
            
                String btitle=rs.getString("BookTitle");
                String bauthor=rs.getString("Author");
                String bcategory=rs.getString("Category");
                double price=rs.getInt("Price");
                byte[] image=rs.getBytes("Image");
                int id=rs.getInt("BookID");
                
                cv=new BookPanel(id,btitle,bauthor,bcategory,price,image,address_session);
                cv.setBtitle(btitle);               
                cv.setBauthor(bauthor);
                cv.setBCategory(bcategory);
                cv.setPrice(price);
                cv.setImage(image);
                cv.setId(id);
                cv.lblTitleSet.setText(cv.getBtitle());
                cv.setToolTipText(cv.getBtitle());
                cv.lblAuthorSet.setText(cv.getBauthor());
                cv.lblCategorySet.setText(cv.getBcategory());
                cv.lblPriceSet.setText(cv.getPrice()+"");
                cv.lblImg.setIcon(cv.getImage());

                
                dataFlowPanel.add(cv);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        finally{
            
            try {
                stmt.close();
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(mainproject.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
//       
        getRootPane().revalidate();
        getRootPane().repaint();
    }
    
    
    public void orderByBookTitle(int start,int end){
        createDB();
        try {
            stmt=con.createStatement();
            sql="select * from Book order by BookTitle limit "+start+","+end;
            rs=stmt.executeQuery(sql);
            while(rs.next()){
            
                String btitle=rs.getString("BookTitle");
                String bauthor=rs.getString("Author");
                String bcategory=rs.getString("Category");
                double price=rs.getInt("Price");
                byte[] image=rs.getBytes("Image");
                int id=rs.getInt("BookID");
                
                cv=new BookPanel(id,btitle,bauthor,bcategory,price,image,address_session);
                cv.setBtitle(btitle);               
                cv.setBauthor(bauthor);
                cv.setBCategory(bcategory);
                cv.setPrice(price);
                cv.setImage(image);
                cv.setId(id);
                cv.lblTitleSet.setText(cv.getBtitle());
                cv.setToolTipText(cv.getBtitle());
                cv.lblAuthorSet.setText(cv.getBauthor());
                cv.lblCategorySet.setText(cv.getBcategory());
                cv.lblPriceSet.setText(cv.getPrice()+"");
                cv.lblImg.setIcon(cv.getImage());

                
                dataFlowPanel.add(cv);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        finally{
            
            try {
                stmt.close();
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(mainproject.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
//       
        getRootPane().revalidate();
        getRootPane().repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        porfile2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        spBook = new javax.swing.JScrollPane();
        dataFlowPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        mitBookTitle = new javax.swing.JMenuItem();
        mtiAuthor = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1370, 700));
        setMinimumSize(new java.awt.Dimension(1370, 700));
        setPreferredSize(new java.awt.Dimension(1370, 700));

        porfile2.setBackground(new java.awt.Color(51, 51, 255));
        porfile2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Stop", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Profile");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Name:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Email:");

        jButton5.setText("Log Out");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Setting");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Harlow Solid Italic", 0, 15)); // NOI18N
        lblName.setForeground(new java.awt.Color(0, 255, 0));
        lblName.setText("unknown");

        lblEmail.setFont(new java.awt.Font("Harlow Solid Italic", 0, 15)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 0));
        lblEmail.setText("unknown");

        javax.swing.GroupLayout porfile2Layout = new javax.swing.GroupLayout(porfile2);
        porfile2.setLayout(porfile2Layout);
        porfile2Layout.setHorizontalGroup(
            porfile2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(porfile2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(porfile2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(porfile2Layout.createSequentialGroup()
                        .addGroup(porfile2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(porfile2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, porfile2Layout.createSequentialGroup()
                        .addGap(0, 38, Short.MAX_VALUE)
                        .addGroup(porfile2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(50, 50, 50))))
            .addGroup(porfile2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        porfile2Layout.setVerticalGroup(
            porfile2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(porfile2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addGroup(porfile2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(porfile2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(37, 37, 37)
                        .addGroup(porfile2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblEmail)))
                    .addComponent(lblName))
                .addGap(20, 20, 20)
                .addComponent(jButton6)
                .addGap(30, 30, 30)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(436, Short.MAX_VALUE))
        );

        dataFlowPanel.setLayout(new java.awt.GridLayout(2, 4));
        spBook.setViewportView(dataFlowPanel);

        btnNext.setText("Next>>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrev.setText("<<Prev");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrev)
                .addGap(18, 18, 18)
                .addComponent(btnNext)
                .addContainerGap(992, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnPrev)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spBook)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(porfile2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(spBook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(porfile2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu2.setText("Edit");

        mitBookTitle.setText("Sort by Book Title");
        mitBookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitBookTitleActionPerformed(evt);
            }
        });
        jMenu2.add(mitBookTitle);

        mtiAuthor.setText("Sort by Author");
        jMenu2.add(mtiAuthor);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Books");

        jMenuItem1.setText("Novel");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem2.setText("Cartoon");
        jMenu5.add(jMenuItem2);

        jMenuItem3.setText("Technology");
        jMenu5.add(jMenuItem3);

        jMenuItem4.setText("Computer");
        jMenu5.add(jMenuItem4);

        jMenuItem5.setText("Language");
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        jMenu1.setText("Search");

        jMenuItem8.setText("by Book Title");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem9.setText("by Author Name");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuItem10.setText("by Price($)");
        jMenu1.add(jMenuItem10);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitBookTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitBookTitleActionPerformed
        // TODO add your handling code here:  
        spBook.setVisible(false);
        createDB();
        try{
            stmt=con.createStatement();
            
//            sql="select Address,Name from Member where Email ='"+session_email+"'";
//            rs=stmt.executeQuery(sql);
//            rs.next();
//            address_session=rs.getString("Address");
//            lblName.setText(rs.getString("Name"));
            
            sql="select count(*) as rowcount from Book";
            
            rs=stmt.executeQuery(sql);
            rs.next();
            int row_count=rs.getInt("rowcount");
            System.out.println(row_count);
           
            stmt.close();
            con.close();
       
        bound=(int) Math.ceil((float)row_count/FETCH_ROW);
        last_start=(row_count/FETCH_ROW)*FETCH_ROW;
        last_end=last_start+(row_count%FETCH_ROW);      
        btnPrev.setEnabled(false);
        
        orderByBookTitle(0,8);
        spBook.setVisible(true);
        
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_mitBookTitleActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
         btnPrev.setEnabled(true);
        dataFlowPanel.removeAll();
        
        count++;
        int stPtr;
        int endPtr;
        if(count<bound-1){
            stPtr=count*FETCH_ROW;
            endPtr=FETCH_ROW;  
            
        }
        else{
            stPtr=last_start;
            endPtr=last_end-last_start;
            if(last_start==last_end){
                 stPtr=count*FETCH_ROW;
                 endPtr=FETCH_ROW; 
            }
            btnNext.setEnabled(false);
        }
        Data_Inflate(stPtr, endPtr);
        
        System.out.println("stPtr"+stPtr);
        System.out.println("endPtr"+endPtr);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
         btnNext.setEnabled(true);
        dataFlowPanel.removeAll();
        count--;
        if(count<1)
            btnPrev.setEnabled(false);
        
        int stPtr=count*FETCH_ROW;
        int endPtr=FETCH_ROW;
        Data_Inflate(stPtr, endPtr);
    }//GEN-LAST:event_btnPrevActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        AccSettings as=new AccSettings(mail_session);
        this.dispose();
        as.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        CustomerLogin lgn=new CustomerLogin();
        this.dispose();
        lgn.setVisible(true);
        lgn.txtEmail.setText(mail_session);
        lgn.txtEmail.setForeground(Color.black);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainproject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JPanel dataFlowPanel;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JMenuItem mitBookTitle;
    private javax.swing.JMenuItem mtiAuthor;
    private javax.swing.JPanel porfile2;
    private javax.swing.JScrollPane spBook;
    // End of variables declaration//GEN-END:variables
}
