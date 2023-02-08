import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoreService {
    public List<List<Float>> matrix = IOService.matrix;
    public List<Float> answers = new ArrayList<>();
    private boolean flag = false;
    public void gaussTriangle(int n) {
        List<Float> temp = new ArrayList<>(n + 1);
        for (int z = 0; z < n-1; z++) {
            for (int i = z+1; i < n; i++) {
                if (matrix.get(z).get(z) == 0)  {
                    for(int m = z+1; m<n; m++) {
                        if (matrix.get(m).get(z) != 0) {
                            Collections.swap(matrix, z, m);
                            flag = true;
                        }
                    }
                        if(!flag){
                            z++;
                            System.out.println(z);
                            continue;
                        }
                    }
                Float coefficient = -(matrix.get(i).get(z) / matrix.get(z).get(z));
                System.out.println(coefficient);
                for (int j = 0; j <= n; j++) {
                    temp.add(matrix.get(z).get(j) * coefficient);
                    Float el = matrix.get(i).get(j);
                    matrix.get(i).set(j, el + temp.get(j));
                }
                temp.clear();
            }
            System.out.println(Arrays.toString(matrix.toArray()));
        }
        gaussResolving(3);
    }

    public void gaussResolving(int size){
        int n = size - 1;
        if(matrix.get(n).get(size-1)!=0) {
            answers.add(matrix.get(n).get(size) / matrix.get(n).get(size - 1));
        } else {
            answers.add((float) 0);
        }
        for(int i = n-1; i>=0; i--){
            Float x = matrix.get(i).get(size);
            for(int j = i+1; j>i; j--){
                x -= (matrix.get(i).get(j)) * answers.get(n-i-1);
            }
            x = x/matrix.get(i).get(i);
            answers.add(x);
        }
        Collections.reverse(answers);
        System.out.println(Arrays.toString(answers.toArray()));
    }
}
