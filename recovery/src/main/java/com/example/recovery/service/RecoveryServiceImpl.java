package com.example.recovery.service;


import com.example.recovery.dto.MessageBean;
import com.example.recovery.dto.ShareDto;
import com.example.recovery.mapper.RecoverMapper;
import com.example.recovery.util.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:RecoveryServiceImpl
 * Package:com.example.recovery.service
 * Description:
 *
 * @date:2020/8/13 10:54
 * @author:zh
 */
@Service
public class RecoveryServiceImpl implements RecoveryService {

    private static final String SHARE_MSG = "%s完成一次%s%s%s的预约，请完成预约分享";

    public static final List<String> COMPOUND_SURNAME = Arrays.asList("欧阳","太史","端木","上官","司马","东方","独孤",
            "南宫","万俟","闻人","夏侯","诸葛","尉迟","公羊","赫连","澹台","皇甫","宗政","濮阳","公冶","太叔","申屠","公孙",
            "慕容","仲孙","钟离","长孙","宇文","司徒","鲜于","司空","闾丘","子车","亓官","司寇","巫马","公西","颛孙","壤驷",
            "公良","漆雕","乐正","宰父","谷梁","拓跋","夹谷","轩辕","令狐","段干","百里","呼延","东郭","南门","羊舌","微生",
            "公户","公玉","公仪","梁丘","公仲","公上","公门","公山","公坚","左丘","公伯","西门","公祖","第五","公乘","贯丘",
            "公皙","南荣","东里","东宫","仲长","子书","子桑","即墨","淳于","达奚","褚师","吴铭","纳兰","归海");

    @Autowired
    private RecoverMapper recoverMapper;

    @Override
    public Integer recovery() {
        List<MessageBean> beans = new ArrayList<>();
        //查询分享信息表信息
        List<ShareDto> shareDtos= recoverMapper.selectShareMessage();
        for (ShareDto shareDto : shareDtos) {
            MessageBean msgBean = new MessageBean();
            msgBean.setId(IdWorker.getId());
            msgBean.setTitle("预约完成分享通知");
            msgBean.setContent(String.format(SHARE_MSG,encName(shareDto.getPatientName()),shareDto.getHospitalName(),
                    shareDto.getDoctorName(), shareDto.getDoctorTitle()));
            msgBean.setRelationId(shareDto.getShareId());
            msgBean.setRelationType("4");
            msgBean.setDeleteFlag("1");
            msgBean.setReadFlag(shareDto.getReadFlag());
            msgBean.setUserId(shareDto.getUserId());
            msgBean.setUserDiv("2");
            msgBean.setCreateTime(shareDto.getCreateTime());
            beans.add(msgBean);
        }
        return recoverMapper.addMessage(beans);
    }


    @Override
    public void recoverTest() {
        List<String> list = new ArrayList<>();
        //查询Test店员id
        List<String> clerkIds=recoverMapper.searchClerkIds();
        //查询Test医生id
        List<String> doctorIds=recoverMapper.searchDoctorIds();
        //查询Test咨询师id
        List<String> consultantIds=recoverMapper.consultantIds();
        //查询Test客服id
        List<String> customerIds=recoverMapper.customerIds();
        list.addAll(customerIds);
        list.addAll(clerkIds);
        list.addAll(doctorIds);
        list.addAll(consultantIds);
        recoverMapper.updateTest(list);
    }

    private String encName(String patientName){
        if(StringUtils.isBlank(patientName)||patientName.length()==1){
            return patientName;
        }
        patientName = patientName.trim();
        String sub = patientName.substring(0,2);
        if(COMPOUND_SURNAME.contains(sub)){
            StringBuilder surname = new StringBuilder(sub);
            int index = 2;
            while(index < patientName.length()){
                surname.append("×");
                index ++;
            }
            return surname.toString();
        }else{
            StringBuilder surname = new StringBuilder(patientName.substring(0, 1));
            int index = 1;
            while(index < patientName.length()){
                surname.append("×");
                index ++;
            }
            return surname.toString();
        }
    }
}
