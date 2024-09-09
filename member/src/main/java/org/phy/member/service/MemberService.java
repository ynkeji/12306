package org.phy.member.service;

import cn.hutool.core.util.ObjectUtil;
import jakarta.annotation.Resource;
import org.phy.common.exception.BusinessException;
import org.phy.common.exception.BusinessExceptionEnum;
import org.phy.member.domain.Member;
import org.phy.member.domain.MemberExample;
import org.phy.member.mapper.MemberMapper;
import org.phy.member.req.MemberRegisterReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

//    @Resource
//    private userMapper userMapper;
    @Resource
    private MemberMapper memberMapper;

    public  int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }


    public long register(MemberRegisterReq mobile){
        MemberExample example = new MemberExample();
        example.createCriteria().andMobileEqualTo(mobile.getMobile());
        List<Member> members = memberMapper.selectByExample(example);
        if (ObjectUtil.isNotEmpty(members)) {
            // return list.get(0).getId();
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }
        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile.getMobile());
        memberMapper.insert(member);
        return member.getId();
    }
}
