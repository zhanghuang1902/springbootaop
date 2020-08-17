package com.example.recovery.mapper;

import com.example.recovery.dto.MessageBean;
import com.example.recovery.dto.ShareDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:RecoverMapper
 * Package:com.example.recovery.mapper
 * Description:
 *
 * @date:2020/8/13 10:55
 * @author:zh
 */
@Mapper
public interface RecoverMapper {
    String select();

    List<ShareDto> selectShareMessage();

    Integer addMessage(List<MessageBean> beans);
}
