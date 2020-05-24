package by.gsu.pms;

public class Simvol {
    public Simvol(String word) {
        this.word = word;
    }

    private String word;



    public String numSim(){
        StringBuffer s = new StringBuffer(word);
        int num = 1;
        for (int i=0; i<s.length()-1; i++){
            if (s.charAt(i)== s.charAt(i+1)){
                num++;
                s.delete(i,i+1);
                i--;
            }else{
                if (num!=1) {
                    s.insert(i+1, num);
                }
                num = 1;
            }
        }
        if (num!=1){
            s.insert((s.length()-1), num);
        }
        return s.toString();
    }
}
