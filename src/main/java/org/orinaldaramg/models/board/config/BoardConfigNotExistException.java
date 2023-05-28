package org.orinaldaramg.models.board.config;

import org.orinaldaramg.commons.CommonException;
import org.springframework.http.HttpStatus;

public class BoardConfigNotExistException extends CommonException {
    public BoardConfigNotExistException(){
        super(bundleValidation.getString("Validation.board.notExists"), HttpStatus.BAD_REQUEST);
    }

}
