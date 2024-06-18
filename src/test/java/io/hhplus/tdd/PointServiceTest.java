package io.hhplus.tdd;

import io.hhplus.tdd.database.PointHistoryTable;
import io.hhplus.tdd.database.UserPointTable;
import io.hhplus.tdd.point.domain.UserPoint;
import io.hhplus.tdd.point.repository.PointRepository;
import io.hhplus.tdd.point.repository.PointRepositoryImpl;
import io.hhplus.tdd.point.service.PointService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointServiceTest {

    private PointService pointService;

    @BeforeEach
    void setUp() {
        pointService = new PointService(new PointRepositoryImpl(
                new UserPointTable(),
                new PointHistoryTable()
        ));
    }


    @Test
    @DisplayName("포인트_조회")
    void 포인트_조회(){
        // given
        long id = 1L;
        // when
        UserPoint userPoint = pointService.getPoint(id);
        // then
        Assertions.assertThat(userPoint).isNotNull();
        System.out.println("포인트_조회 :: 성공");
    }

    @Test
    @DisplayName("포인트_내역_조회")
    void 포인트_내역_조회(){
        System.out.println("hello");

    }

    @Test
    @DisplayName("포인트_충전")
    void 포인트_충전(){

    }

    @Test
    @DisplayName("포인트_사용")
    void 포인트_사용(){


    }

}//end class
