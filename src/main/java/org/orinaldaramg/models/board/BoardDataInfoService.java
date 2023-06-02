package org.orinaldaramg.models.board;

import lombok.RequiredArgsConstructor;
import org.orinaldaramg.entities.Board;
import org.orinaldaramg.entities.BoardData;
import org.orinaldaramg.models.board.config.BoardConfigInfoService;
import org.orinaldaramg.repositories.BoardDataRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardDataInfoService {

    private final BoardDataRepository boardDataRepository;
    private final BoardConfigInfoService configInfoService;

    public BoardData get(Long id){

        BoardData boardData = boardDataRepository.findById(id).orElseThrow(BoardDataNotExistsException::new);

        // 게시판 설정 조회 + 접근 권한 체크
        configInfoService.get(boardData.getBoard().getBId(), "view");

        return boardData;
    }
}
