package com.hulk.data.repository;

import com.hulk.data.model.CallStatusChange;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vijayvar on 10/10/15.
 */
public interface CallStatusChangeRepository extends JpaRepository<CallStatusChange, Long> {

    List<CallStatusChange> findByCallInfoId(Long callInfoId, Sort sort);
}
