package org.orinaldaramg.models.board;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.orinaldaramg.commons.MemberUtil;
import org.orinaldaramg.entities.BoardData;
import org.orinaldaramg.entities.BoardView;
import org.orinaldaramg.repositories.BoardDataRepository;
import org.orinaldaramg.repositories.BoardViewRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 조회수 업데이트
 */

@Service
@RequiredArgsConstructor
public class UpdateHitService {
    private final BoardViewRepository boardViewRepository;
    private final BoardDataRepository boardDataRepository;
    private final HttpServletRequest request;
    private final MemberUtil memberUtil;

    public void update(Long id){
        try{
            BoardView boardView = new BoardView();
            boardView.setId(id);
            boardView.setUid("" + getUid());
            boardViewRepository.saveAndFlush(boardView);
        } catch (Exception E) {
            long cnt = boardViewRepository.getHit();
            BoardData boardData = boardDataRepository.findById(id).orElse(null);
            if(boardData != null){
                boardData.setHit((int)cnt);
                boardDataRepository.flush();
            }
        }
    }

    private int getUid(){
        String ip = request.getRemoteAddr();
        String  ua = request.getHeader("User-Agent");
        Long userNo = memberUtil.isLogin() ? memberUtil.getMember().getUserNo() : 0L;

        return Objects.hash(ip, ua, userNo);
    }
}
