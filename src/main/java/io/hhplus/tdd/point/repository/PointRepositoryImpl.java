package io.hhplus.tdd.point.repository;

import io.hhplus.tdd.database.PointHistoryTable;
import io.hhplus.tdd.database.UserPointTable;
import io.hhplus.tdd.point.domain.PointHistory;
import io.hhplus.tdd.point.TransactionType;
import io.hhplus.tdd.point.domain.UserPoint;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PointRepositoryImpl implements PointRepository{

    private final UserPointTable userPointTable;
    private final PointHistoryTable pointHistoryTable;

    @Autowired
    public PointRepositoryImpl(UserPointTable userPointTable, PointHistoryTable pointHistoryTable) {
        this.userPointTable = userPointTable;
        this.pointHistoryTable = pointHistoryTable;
    }//init

    @Override
    public UserPoint selectById(Long id) {
        return userPointTable.selectById(id);
    }//selectById

    @Override
    public UserPoint insertOrUpdate(long id, long amount) {
        return userPointTable.insertOrUpdate(id, amount);
    }//insertOrUpdate

    @Override
    public List<PointHistory> selectAllByUserId(long userId) {
        return pointHistoryTable.selectAllByUserId(userId);
    }//selectAllByUserId

    @Override
    public PointHistory insert(long userId, long amount, TransactionType type) {
        return pointHistoryTable.insert(userId,amount, type, System.currentTimeMillis());
    }//insert

}//end
