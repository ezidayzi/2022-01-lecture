public class Rectangle {
    private int x, y, width, height;

    private boolean inRect(int x, int y) {
        return (x > this.x && x < this.x + this.width) && (y > this.y && y < this.y + this.height);
    }

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int square() {
        return  width * height;
    }

    public void show() {
        System.out.println("("+x+","+y+")에서 크기가 "+width+"x"+height+"인 사각형");
    }

    public boolean contains(Rectangle r) {
        return inRect(r.x, r.y)
                && inRect(r.x, r.y + r.height)
                && inRect(r.x + r.width, r.y)
                && inRect(r.x + r.width, r.y + r.height);
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(2, 2, 8, 7);
        Rectangle s = new Rectangle(5, 5, 6, 6);
        Rectangle t = new Rectangle(1, 1, 10, 10);

        r.show();
        System.out.println("s의 면적은 " + s.square());
        if (t.contains(r)) System.out.println("t는 r을 포함합니다");
        if (t.contains(s)) System.out.println("t는 s를 포함합니다");
    }
}
