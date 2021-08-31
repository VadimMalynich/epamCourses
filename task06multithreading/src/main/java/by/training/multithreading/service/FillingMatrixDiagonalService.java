package by.training.multithreading.service;

import by.training.multithreading.bean.Matrix;

public interface FillingMatrixDiagonalService {
    /**
     * Filling main matrix diagonal by different ways using threads
     *
     * @throws ServiceException
     */
    void fillingMainDiagonal();

    /**
     * Method checks how many times was changed elements on main diagonal
     *
     * @return {@code true} if all diagonal elements was changed once, {@code false} otherwise
     * @throws ServiceException
     */
    default boolean checkNumberChanges() {
        Matrix matrix = Matrix.getInstance();
        for (int i = 0; i < matrix.getSize(); i++) {
            if (matrix.getElement(i, i).getChangeCounter() != 1) {
                return false;
            }
        }
        return true;
    }
}
