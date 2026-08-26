package Matrix_Questions;

import java.util.Objects;

public class Pair {

    int i;
    int j;

    public Pair(int i,int j){
        this.i=i;
        this.j=j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i,j);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(obj==null || getClass()!=obj.getClass())return false;
        Pair pair=(Pair) obj;
        return ((i==pair.i) && (j==pair.j));
    }
}
