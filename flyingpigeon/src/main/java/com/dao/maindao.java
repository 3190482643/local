package com.dao;
import com.domain.message;
import com.domain.msg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface maindao {
    @Select("select*from fpmessage where recipient=#{username};")
    List<message> selectmessage(String username);

    @Insert("insert into fpmessage values(now(),#{sender},#{recipient},#{message});")
    void add(msg m);

    @Delete("delete from fpmessage where recipient=#{username};")
    void delete(String username);
}
