package org.orinaldaramg.models.board;

import lombok.RequiredArgsConstructor;
import org.orinaldaramg.entities.BoardData;
import org.orinaldaramg.repositories.BoardDataRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardDataInfoService {

    private final BoardDataRepository boardDataRepository;

    public BoardData get(Long id){

        BoardData boardData = boardDataRepository.findById(id).orElseThrow(BoardDataNotExistsException::new);

        return null;
    }
}
