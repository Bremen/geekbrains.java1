package com.company.homework8.core;

import com.company.homework8.core.domain.MatrixCoordinate;
import com.company.homework8.enums.DotType;

public interface GameService {

    MatrixCoordinate aiTurn();

    void humanTurn(int rowIndex, int columnIndex);

    boolean checkWin(DotType dotType);

    boolean isMapFull();

}
