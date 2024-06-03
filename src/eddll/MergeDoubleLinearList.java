package eddll;

public class MergeDoubleLinearList {
    public DoubleLinearList dll1;
    public DoubleLinearList dll2;
    public DoubleLinearList dllres;

    public MergeDoubleLinearList(DoubleLinearList dll_1, DoubleLinearList dll_2) {
        this.dll1 = new DoubleLinearList();
        this.dll2 = new DoubleLinearList();
        this.dllres = new DoubleLinearList();

        while(!dll_1.empty()){
            Node node = dll_1.remove();
            this.dll1.append(node);
        }

        while(dll_2.empty()){
            Node node = dll_2.remove();
            this.dll2.append(node);
        }
    }

    public DoubleLinearList getMergelist(){
        while (!dll1.empty()) {
            Node node = dll1.remove();
            this.dllres.append(node);
        }

        while (!dll2.empty()) {
            Node node = dll2.remove();
            this.dllres.append(node);
        }
        return this.dllres;
    }
}
