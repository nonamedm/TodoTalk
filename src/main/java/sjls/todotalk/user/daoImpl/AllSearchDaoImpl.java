package sjls.todotalk.user.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sjls.todotalk.user.dao.AllSearchDao;
import sjls.todotalk.user.vo.RelationVo;
import sjls.todotalk.user.vo.UserVo;

@Repository("allSearchDao")
public class AllSearchDaoImpl implements AllSearchDao {

	@Autowired
	private  SqlSession  sqlSession; 
	
	@Override
	public List<UserVo> getTutorList(HashMap<String, Object> map) {
		map.put("tutorResult", sqlSession.selectList("AllSearch.GetTutorList",map)); //이거 안하는 방법 알아요?
		List<UserVo> tutorVo = (List<UserVo>) map.get("tutorResult");
		return tutorVo;
	}

	@Override
	public List<UserVo> getMentorList(HashMap<String, Object> map) {
		map.put("mentorResult", sqlSession.selectList("AllSearch.GetMentorList",map));
		List<UserVo> mentorVo = (List<UserVo>) map.get("mentorResult");
		return mentorVo;
	}

	@Override
	public List<HashMap<String, Object>> getBoardList(HashMap<String, Object> map) {
		List<HashMap<String, Object>> boardAllSearch = sqlSession.selectList("AllSearch.GetBoardList",map);
		return boardAllSearch;
	}

	@Override
	public UserVo getUserList(String receiver_id) {
		UserVo userVo = sqlSession.selectOne("AllSearch.GetUser", receiver_id);
		return userVo;
	}

	@Override
	public String getPhotoName(String receiver_id) {
		String userPhoto = sqlSession.selectOne("AllSearch.GetPhoto",receiver_id);
		return userPhoto;
	}

	@Override
	public void relationCreate(Map<String, Object> map) {
		try {
			sqlSession.insert("AllSearch.RelationCreate", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<RelationVo> getRelationList(String loginId) {
		List<RelationVo> relationList = sqlSession.selectList("AllSearch.GetRelationList",loginId);
		return relationList;
	}

	@Override
	public List<RelationVo> getRelationRequire(String loginId) {
		List<RelationVo> relationRequire = sqlSession.selectList("AllSearch.GetRelationRequire",loginId);
		return relationRequire;
	}

	@Override
	public List<RelationVo> getRelationCheck(Map<String, Object> check) {
		List<RelationVo> relationCheck = sqlSession.selectList("AllSearch.GetRelationCheck",check);
		return relationCheck;
	}

	
	
	
}
