package com.example.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE BookingEntity b" +
            "           SET b.userEntity = :userPass," +
            "               b.modifiedAt = CURRENT TIMESTAMP " +
            "         WHERE b.passSeq = :passSeq")
    int updateUsedPass(Integer passSeq, boolean usedPass);
}
