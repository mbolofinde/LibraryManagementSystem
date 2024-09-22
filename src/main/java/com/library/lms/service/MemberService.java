package com.library.lms.service;

import com.library.lms.model.Member;
import java.util.List;
import java.util.UUID;

public interface MemberService {
    Member createMember(Member member);
    Member getMemberById(UUID id);
    List<Member> getAllMembers();
    Member updateMember(UUID id, Member member);
    void deleteMember(UUID id);
}
