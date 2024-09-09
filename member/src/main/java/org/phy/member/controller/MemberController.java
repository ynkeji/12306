package org.phy.member.controller;


import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.phy.common.resp.CommonResp;
import org.phy.member.req.MemberRegisterReq;
import org.phy.member.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public CommonResp<Integer> test() {
        int cunt =  memberService.count();
        CommonResp<Integer> commonResp = new CommonResp<>();
        commonResp.setContent(cunt);
        return commonResp;
    }


    @PostMapping("/register")
    public Long register(@Valid MemberRegisterReq mobile) throws Exception {
        return memberService.register(mobile);
    }



}
