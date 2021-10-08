package e2;

public class Slopes {

    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way.
     * @param slopeMap A square matrix representing the slope with spaces
     * represented as "." and trees represented as "#".
     * @param right Movement to the right.
     * @param down Downward movement.
     * @return Number of trees.
     * @throws IllegalArgumentException if the matrix is incorrect because:
     *      - It is not square.
     *      - It has characters other than "." and "#".
     *      - right >= number of columns or right < 1.
     *      - down >= number of rows of the matrix or down < 1.
     */

    public static int downTheSlope(char[][] slopeMap, int right, int down) {
        int stopbr = 0, stopbd = 0, trees = 0, i = 0, iter = 0, ited = 0, longc = slopeMap[0].length, longf = slopeMap.length;

        if (((right < 1) || (right >= longc)) || ((down < 1) || (down >= longf))) {
            throw new IllegalArgumentException();
        } else {
            for (int c = 0; c < longc; c++) {
                if (slopeMap[c].length != longf) {
                    throw new IllegalArgumentException();
                }
            }
        }

        for (int j = 0; (j < longf); j++) {
            if (iter == 0) {
                stopbr += right;
            }

            if (i == 0 && j != 0 && down != 1) {
                stopbr = iter;
            } else if (i == 0 && j != 0) {
                stopbr = iter - 1;
            }

            if (ited == 0 && j != 0 && iter == 0 && down != 1) {
                stopbr--;
            }

            for (; (i < longc) && (i <= stopbr); i++) {
                if (slopeMap[j][i] == '.' || slopeMap[j][i] == '#') {
                    if (slopeMap[j][i] == '#') {
                        trees++;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            i--;
            iter = stopbr - i;
            ited = stopbd - j;
            if (ited == 0) {
                stopbd += down;
            }
            if (i == (longc - 1) && iter != 0 && ited == 0) {
                i = 0;
                j--;
            }
        }
        return trees;
    }

    /*
     downTheSlope(char slopeMap[][], int r, int d) {
        int arboles = 0;

        if (!argumentosValidos()) {
            throw new IllegalArgumentException();
        }

        int n = calcularPosiciones(tamh, tamv, right, down);

        for (int i = 0; i < n; ++i) {
            if (hayArbolEnPosicion(n)) {
                arboles++;
            }
        }

        return arboles;
     }
     */

    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way.
     * Since it " jumps " from the initial position to the final position,
     * only takes into account the trees on those initial / final positions.
     * Params, return value and thrown expections as in downTheSlope...
     */

    public static int jumpTheSlope(char[][] slopeMap, int right, int down) {
        int stopbr = 0, trees = 0, i = 0, longc = slopeMap[0].length, longf = slopeMap.length, aux;

        // Illegals
        if (((1 > right) || (right >= longc)) || ((1 > down) || (down >= longf))) {
            throw new IllegalArgumentException();
        } else {
            for (int c = 0; c < longc; c++) {
                if (slopeMap[c].length != longf) {
                    throw new IllegalArgumentException();
                }
            }
        }

        for (int j = 0; (j < longf); j = j + down) {
            stopbr += right;
            for (; (i < longc) && (i < stopbr); i = i + right) {
                if (slopeMap[j][i] == '.' || slopeMap[j][i] == '#') {
                    if (slopeMap[j][i] == '#') {
                        trees++;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            if (i > (longc - 1)) {
                stopbr = 0;
                aux = i - right;
                if (aux == (longc - 1)) {
                    i = right - 1;
                } else {
                    i = i - longc;
                }
            }
        }
        return trees;
    }
}

/*
     jumpTheSlope(char slopeMap[], int r, int d) {
        int arboles = 0;

        if (!argumentosValidos()) {
            throw new IllegalArgu...;
        }

        int n = calcularPosiciones(tamh, tamv, right, down);

        for (int i = 0; i > n; (r + d) + i) {
             if (hayArbolEnPosicion(n) {
                 arboles++;
             }
        }
        return arboles;
     }
     */