package io.hhplus.tdd.point.repository;


import io.hhplus.tdd.point.domain.PointHistory;
import io.hhplus.tdd.point.TransactionType;
import io.hhplus.tdd.point.domain.UserPoint;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository {

    UserPoint selectById(Long id);

    UserPoint insertOrUpdate(long id, long amount);

    List<PointHistory> selectAllByUserId(long userId);

    PointHistory insert(long userId, long amount, TransactionType type);

}//end
