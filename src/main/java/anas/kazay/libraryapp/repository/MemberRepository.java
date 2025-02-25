package anas.kazay.libraryapp.repository;

import anas.kazay.libraryapp.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
