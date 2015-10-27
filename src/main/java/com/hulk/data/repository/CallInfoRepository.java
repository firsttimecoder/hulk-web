package com.hulk.data.repository;

import com.hulk.data.model.CallInfo;
import com.hulk.enums.CallStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by vijayvar on 10/10/15.
 */
public interface CallInfoRepository extends JpaRepository<CallInfo, Long> {

    @Modifying
    @Query("UPDATE CallInfo SET assignedAgentId = ?2 WHERE id = ?1")
    void setAssignedAgentIdForId(Long callInfoId, Long agentId);

    @Modifying
    @Query("UPDATE CallInfo SET lastStatusChangeId = ?2 WHERE id = ?1")
    void setCallStatusChangeIdForId(Long callInfoId, Long callStatusChangeId);

    List<CallInfo> findByAssignedAgentIdAndLastStatusChangeNullOrLastStatusChangeNewStatusNot(
            Long assignedAgentId, CallStatus currentStatus);
}
