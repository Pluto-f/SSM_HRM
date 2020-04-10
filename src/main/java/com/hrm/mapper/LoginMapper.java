package com.hrm.mapper;

import com.hrm.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import static com.hrm.util.Constants.USERTABLE;

@Component
public interface LoginMapper {

    @Select("select * from "+USERTABLE+"  where loginname = #{loginname} AND password = #{password}")
    User get_login(@Param("loginname") String loginname,
                   @Param("password") String password);

}
