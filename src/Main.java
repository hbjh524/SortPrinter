import java.util.ArrayList;

interface Sort{
    void run(ArrayList<Integer> lst);
}
class BubbleSort implements Sort{
    @Override
    public void run(ArrayList<Integer> lst) {
        //버블소트
        for(int cycle = 0 ;cycle < lst.size(); cycle ++) {
            for(int i = 0 ; i < lst.size() - 1 - cycle; i ++) {
                if(lst.get(i) > lst.get(i + 1)){
                    //swap
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(i + 1));
                    lst.set(i + 1, tmp);
                }
            }
        }
    }
}
class SelectionSort implements Sort{
    @Override
    public void run(ArrayList<Integer> lst) {
        //선택정렬
        for(int i = 0 ; i < lst.size(); i++) {
            for(int j = i + 1 ; j < lst.size(); j ++) {
                if(lst.get(i) > lst.get(j)){
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(j));
                    lst.set(j, tmp);
                }
            }
        }
    }
}
class SortPrinter {
    Sort sort;
    ArrayList<Integer> arrayList = new ArrayList<>();
    public void insert(int a){
        arrayList.add(a);
    }
    public void selection(Sort sort){
        this.sort = sort;
    }
    public void run(){
        sort.run(arrayList);
    }
    public void show(){
        for (Integer i : arrayList) {
            System.out.print(i);
        }

    }

}
public class Main {
    public static void main(String[] args) {
        SortPrinter machine = new SortPrinter();
        machine.insert(3);
        machine.insert(5);
        machine.insert(1);
        machine.insert(8);
        machine.insert(4);
        machine.insert(2);
        Sort s = new BubbleSort();
        machine.selection(s);
        machine.run();
        machine.show();
        System.out.println(",");
        machine.insert(9);
        machine.insert(6);
        machine.insert(1);
        s = new SelectionSort();
        machine.selection(s);
        machine.run();
        machine.show();
    }
}
