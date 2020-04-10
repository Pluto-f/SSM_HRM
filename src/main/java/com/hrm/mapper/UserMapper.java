package com.hrm.mapper;



import com.hrm.domain.Condition;
import com.hrm.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.hrm.util.Constants.USERTABLE;

@Component
public interface UserMapper {

    @Select("SELECT * from "+USERTABLE+" LIMIT #{start},#{end}")
    List<User> getUserList(@Param("start") int start, @Param("end") int end);

    @Select("SELECT COUNT(*) from "+USERTABLE+"")
    int queryUserCount();

    int queryUserCountByContent(Condition condition);

    List<User> getUserLikeList(Condition condition);

    void insertUserInfo(User user);

    @Select("SELECT * from "+USERTABLE+" WHERE id= #{id}")
    User getUserInfo(Integer id);

    void updateUserInfo(User user);
    // 根据id删除部门
    @Delete(" delete from "+USERTABLE+" where id = #{id} ")
    void deleteUserInfo(Integer id);

}
