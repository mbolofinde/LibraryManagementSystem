package com.library.lms.service.impl;

import com.library.lms.model.Member;
import com.library.lms.repository.MemberRepository;
import com.library.lms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member getMemberById(UUID id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member updateMember(UUID id, Member member) {
        Member existingMember = getMemberById(id);
        existingMember.setName(member.getName());
        existingMember.setEmail(member.getEmail());
        existingMember.setPhone(member.getPhone());
        existingMember.setMembershipDate(member.getMembershipDate());
        return memberRepository.save(existingMember);
    }

    @Override
    public void deleteMember(UUID id) {
        memberRepository.deleteById(id);
    }
}
