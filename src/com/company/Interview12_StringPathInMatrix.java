package com.company;

public class Interview12_StringPathInMatrix {

    private static boolean hasPath(char[] matrix, int rows, int cols, char[] path) {
        if (matrix == null || rows < 1 || cols < 1 || path == null) return false;

        boolean[] visited = new boolean[rows * cols];
        int pathLength = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, path, pathLength, visited)) return true;
            }
        }

        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col,
                                       char[] path, int pathLength, boolean[] visited) {
        if (pathLength == path.length) return true;

        boolean hasPath = false;

        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == path[pathLength] && !visited[row * cols + col]) {
            ++pathLength;
            visited[row * cols + col] = true;

            hasPath = hasPathCore(matrix, rows, cols, row - 1, col, path, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, path, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col - 1, path, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, path, pathLength, visited);

            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = false;
            }
        }
        
        return hasPath;
    }

    public static void main(String[] args) {
        //ABCE  //ABCCED
        //SFCS
        //ADEE
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "ABCCED".toCharArray()) + "[true]");// true

        //ABCE  //SEE
        //SFCS
        //ADEE
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "SEE".toCharArray()) + "[true]");// true

        //ABCE  //ABCB
        //SFCS
        //ADEE
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(), 3, 4,
                "ABCB".toCharArray()) + "[false]");// false

        //ABCEHJIG  //SLHECCEIDEJFGGFIE
        //SFCSLOPQ
        //ADEEMNOE
        //ADIDEJFM
        //VCEIFGGS
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
                "SLHECCEIDEJFGGFIE".toCharArray()) + "[true]");// true


        //ABCEHJIG  //SGGFIECVAASABCEHJIGQEM
        //SFCSLOPQ  //
        //ADEEMNOE
        //ADIDEJFM
        //VCEIFGGS
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
                "SGGFIECVAASABCEHJIGQEM".toCharArray()) + "[true]");// true

        //ABCEHJIG  //SGGFIECVAASABCEEJIGOEM
        //SFCSLOPQ
        //ADEEMNOE
        //ADIDEJFM
        //VCEIFGGS
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
                "SGGFIECVAASABCEEJIGOEM".toCharArray()) + "[false]");// false


        //ABCEHJIG  //SGGFIECVAASABCEHJIGQEMS
        //SFCSLOPQ
        //ADEEMNOE
        //ADIDEJFM
        //VCEIFGGS
        System.out.println(hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
                "SGGFIECVAASABCEHJIGQEMS".toCharArray()) + "[false]");// false

        //AAAA  //AAAAAAAAAAAA
        //AAAA
        //AAAA
        System.out.println(hasPath("AAAAAAAAAAAA".toCharArray(), 3, 4,
                "AAAAAAAAAAAA".toCharArray()) + "[true]");// true

        //AAAA  //AAAAAAAAAAAAA
        //AAAA
        //AAAA
        System.out.println(hasPath("AAAAAAAAAAAA".toCharArray(), 3, 4,
                "AAAAAAAAAAAAA".toCharArray()) + "[false]");// false
    }
}
