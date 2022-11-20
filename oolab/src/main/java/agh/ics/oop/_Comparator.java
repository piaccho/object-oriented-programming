package agh.ics.oop;

public class _Comparator implements java.util.Comparator<Vector2d> {

    // compare by X (true) or by Y (false)
    private boolean compareBy;

    public _Comparator(boolean flag){
        this.compareBy = flag;
    }
    @Override
    public int compare(Vector2d v1, Vector2d v2){
        if (compareBy){
            if (v1.x< v2.x)
                return -1;
            else if (v1.x > v2.x)
                return 1;
            else if (v1.y < v2.y)
                return -1;
            else if (v1.y > v2.y)
                return 1;
        }
        else{
            if (v1.y< v2.y)
                return -1;
            else if (v1.y > v2.y)
                return 1;
            else if (v1.x < v2.x)
                return -1;
            else if (v1.x > v2.x)
                return 1;
        }
        return 0;
    }
}
