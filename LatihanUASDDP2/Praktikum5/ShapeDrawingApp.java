package LatihanUASDDP2.Praktikum5;
import java.util.ArrayList;
class Canvas { // canvas nya
    private char[][] grid; // ini (row, col)
    public static final int ROWS = 20; // 20 baris
    public static final int COLS = 20; // 20 kolom 

    public Canvas() {
        this.grid = new char[ROWS][COLS]; 
        clear();
    }
    
    // nge clear setiap row dan kolom dnegan ngisi "."
    public void clear() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                this.grid[r][c] = '.';
            }
        }
    }

    // untuk menggambar satu titik
    public void setPixel(int row, int col, char ch) {
        if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            grid[row][col] = ch;
        }
    }

    //ini untuk mengebalikna karakter yang ada di row dan col tertentu 
    public char getPixel(int row, int col) {
        if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            return this.grid[row][col];
        }
        throw new IndexOutOfBoundsException("Pixel di luar kanvas");
    }

    // menampilkan isi kanvas ke terminal
    public void render() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                System.out.print(this.grid[r][c]);
            }
            System.out.println();
        }
    }
}

// parent dari rectangel dan riight triangle , setiap shape mempunyai atribut karakter yang unik * atau #
// setiap objek harus digambar ke kanvas sebelum di print ke terminal 
class Shape {
    protected String name;
    protected char fillChar;
    
    public Shape(String name, char fillChar) {
        this.name = name;
        this.fillChar = fillChar;
    }

    // di implementasi subclass, ini untuk draw ke canvas, harus melewati canvas
    public void draw(Canvas canvas) {
        // default implementation
    }

    // ini untuk enghitung perkiraan luas(ounded down integer)
    public int getAreaEstimate() {
    // default implementation
        return 0;
    }

    public String toString() {
        return "Shape: " + name + ", fillChar: " + fillChar;
    }
}

//
class Rectangle extends Shape {
    private int startRow; //di 0
    private int startCol; // di 0
    private int height;// tinggi shape
    private int width; // panjang shapenya

    public Rectangle(int startRow, int startCol, int height, int width, char
    fillChar) {
        super("Rectangle", fillChar);
        this.startRow = startRow;
        this.startCol = startCol;
        this.height = height;
        this.width = width;
    }

    public void draw(Canvas canvas) {
        // Jalankan perulangan sebanyak tinggi (height) kotak
        for (int i = 0; i < height; i++) {
            // Jalankan perulangan sebanyak lebar (width) kotak
            for (int j = 0; j < width; j++) {
                int targetRow = startRow + i;
                int targetCol = startCol + j;
                canvas.setPixel(targetRow, targetCol, this.fillChar);
            }
        }
    }

    public int getAreaEstimate() {
        // TODO
        int are = height *width;
        return are;
    }
}


class RightTriangle extends Shape {
    private int startRow;
    private int startCol;
    private int height; // ini tinggi dan lebar sama

    public RightTriangle(int startRow, int startCol, int height, char fillChar) {
        super("RightTriangle", fillChar);
        this.startRow = startRow;
        this.startCol = startCol;
        this.height = height;
    }

    public void draw(Canvas canvas) {
    // i mengontrol baris segitiga (dari 0 sampai height-1)
        for (int i = 0; i < height; i++) {
            // j mengontrol kolom (membentuk siku-siku: baris ke-i menggambar i+1 karakter)
            for (int j = 0; j <= i; j++) {
                int targetRow = startRow + i;
                int targetCol = startCol + j;
                canvas.setPixel(targetRow, targetCol, this.fillChar);
            }
    }
}


    public int getAreaEstimate() {
        int are = height * height / 2;
        return are;
    }
}

// menggambar semua shape ke kanvas, menghitung total luas semua shape
class ShapeRenderer {
    public static void drawAll(Canvas canvas, Shape[] shapes) {
        for (Shape shape : shapes) {
            shape.draw(canvas);
        }
    }

    public static void printShapeInfo(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("Area estimate: " + shape.getAreaEstimate());
        }
    }
}


public class ShapeDrawingApp {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        // inimal 1 dan maksimal 5 yang di gambar bersamaan 
        Shape[] shapes = {
        new Rectangle(1, 2, 3, 5, '#'),
        new RightTriangle(5, 1, 4, '*'),
        new Rectangle(8, 10, 4, 6, '@')
        };
        ShapeRenderer.printShapeInfo(shapes);
        ShapeRenderer.drawAll(canvas, shapes);
        System.out.println("\nCanvas result:");
        canvas.render();
    }
}
