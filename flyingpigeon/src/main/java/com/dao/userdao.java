package com.dao;
import com.domain.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface userdao {
    @Select("select*from fpuser where username=#{u} and password=#{p};")
    user select(@Param("u") String u,@Param("p") String p);

    @Select("select*from fpuser where username=#{u};")
    user addbeforeselect(@Param("u") String u);

    @Insert("insert into fpuser values(#{username},#{password})")
    void add(user u);
}
