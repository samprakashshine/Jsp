import java.util.*;  
import java.sql.*;  
  
public class DiaryDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dairyday", "root", "");
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Diary d){  
        int status=0;  
        try{  
            Connection con=DiaryDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into day(date,time,data) values (?,?,?)"); 
           
            ps.setString(1,d.getDate());  
            ps.setString(2,d.getTime());  
            ps.setString(3,d.getData());  
         
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
        
    public static List<Diary> getAllDiary(){  
        List<Diary> list=new ArrayList<Diary>();  
          
        try{  
            Connection con=DiaryDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from day  ");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Diary d=new Diary();  
              
                d.setDate(rs.getString(1));  
                d.setTime(rs.getString(2));  
                d.setData(rs.getString(3));  
                list.add(d);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
public static int delete(String date){  
        int status=0;  
        try{  
            Connection con=DiaryDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from day where date=?");  
            ps.setString(1,date);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 
     public static int update(Diary d){  
        int status=0;  
        try{  
            Connection con=DiaryDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update day set time=?,data=? where date=?");  
            ps.setString(1,d.getTime());  
            ps.setString(2,d.getData()); 
               ps.setString(3,d.getDate());   
           //  ps.setString(4,d.getTime()); 

              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static Diary getDiaryByDate(String date){  
        Diary d=new Diary();  
          
        try{  
            Connection con=DiaryDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from day where date=? ");  
            ps.setString(1,date);  
         
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                d.setDate(rs.getString(1));  
                d.setTime(rs.getString(2));  
                d.setData(rs.getString(3));  
                 
            }  
              con.close(); 
        }catch(Exception ex){ex.printStackTrace();}  
          
        return d;  
       
    }  
}