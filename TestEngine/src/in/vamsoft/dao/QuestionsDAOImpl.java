package in.vamsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vamsoft.model.Question;

public class QuestionsDAOImpl implements QuestionsDAO {
  Connection con = null;
  public QuestionsDAOImpl(){
    con = DBConnectionUtil.getConnection();
    
  }
  /* (non-Javadoc)
   * @see in.vamsoft.dao.QuestionsDAO#getQuestions()
   */
  @Override
  public List<Question> getQuestions() {
    List<Question> list = new ArrayList<>();
    
    try(PreparedStatement ps = con.prepareStatement("select * from questions")) {
      ResultSet rs = ps.executeQuery();
      Question e = null;
      int quesno = 1;
      while (rs.next()) {
        e= new Question();
        e.setqNo(quesno);
        e.setQuestion(rs.getString(1));
        e.setOp1(rs.getString(2));
        e.setOp2(rs.getString(3));
        e.setOp3(rs.getString(4));
        e.setOp4(rs.getString(5));
        quesno++;
        list.add(e);
      }
      return list;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public boolean getAnswers(String question,String answer) {
    
    try(PreparedStatement preparedStatement = con.prepareStatement("select ques,answer from questions")){
      
      ResultSet rs = preparedStatement.executeQuery();
      while(rs.next()) {
        if(question.equals(rs.getString(1))&&answer.equals(rs.getString(2))) {
          return true;
        }
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return false;
    
  }
}
