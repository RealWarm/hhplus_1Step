package io.hhplus.tdd.point.service;


import io.hhplus.tdd.point.domain.PointHistory;
import io.hhplus.tdd.point.TransactionType;
import io.hhplus.tdd.point.domain.UserPoint;
import io.hhplus.tdd.point.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    private final PointRepository pointRepository;

    @Autowired
    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }//init

    //포인트 조회
    public UserPoint getPoint(long id) {
        if (id < 0) {
            throw new IllegalArgumentException("userId는 0보다 커야합니다.");
        }//if
        // 유저 정보가 없으면 만들어서 반환하므로 없는건 어떻게 표현해야하지?
        return pointRepository.selectById(id);
    }//point

    // 포인트 내역조회
    public List<PointHistory> getAllHistories(long id) {
        if (id < 0) {
            throw new IllegalArgumentException("userId는 0보다 커야합니다.");
        }//if
        return pointRepository.selectAllByUserId(id);
    }//getAllHistories

    // 포인트 충전
    public UserPoint charge(long id, long amount) {
        if (id < 0) {
            throw new IllegalArgumentException("userId는 0보다 커야합니다.");
        }//if
        if (amount < 0) {
            throw new IllegalArgumentException("충전포인트는 0이상 이어야합니다.");
        }//if
        UserPoint origin = pointRepository.selectById(id);
        pointRepository.insert(id, amount, TransactionType.CHARGE);
        return pointRepository.insertOrUpdate(id, origin.point() + amount);
    }//Charge

    // 포인트 사용
    public UserPoint spend(long id, long amount) {
        if (id < 0) {
            throw new IllegalArgumentException("userId는 0보다 커야합니다.");
        }//if
        if (amount < 0) {
            throw new IllegalArgumentException("사용포인트는 0이상 이어야합니다.");
        }//if
        UserPoint origin = pointRepository.selectById(id);
        if (amount > origin.point()) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }//if
        pointRepository.insert(id, amount, TransactionType.USE);
        return pointRepository.insertOrUpdate(id, origin.point()-amount);
    }//spend




}//end