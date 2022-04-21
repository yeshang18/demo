package com.example.czxt;

import org.apache.commons.lang.StringUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RandSort {
    private int[] ran;//随机
    private int[] sor;//顺序
    private int[] sht;//最短
    private int[] scal;//向左扫描
    private int[] scar;//向右扫描
    private int[] cscal;//向左循环
    private int[] cscar;//向右循环扫描

    public int[] getScal() {
        return scal;
    }

    public void setScal(int[] scal) {
        this.scal = scal;
    }

    public int[] getScar() {
        return scar;
    }

    public void setScar(int[] scar) {
        this.scar = scar;
    }

    public int[] getCscal() {
        return cscal;
    }

    public void setCscal(int[] cscal) {
        this.cscal = cscal;
    }

    public int[] getCscar() {
        return cscar;
    }

    public void setCscar(int[] cscar) {
        this.cscar = cscar;
    }

    public int[] getSht() {
        return sht;
    }

    public void setSht(int[] sht) {
        this.sht = sht;
    }

    public int[] getRan() {
        return ran;
    }

    public void setRan(int[] ran) {
        this.ran = ran;
    }

    public int[] getSor() {
        return sor;
    }

    public void setSor(int[] sor) {
        this.sor = sor;
    }

    public int[] stringcl(String s)
    {
        String str1 = s.replace("[","").replace("]","").replace("\"","");
        String[] a=str1.split(",");
        int[] num=new int[a.length];
        for (int i=0;i<a.length;i++)
        {
            num[i]=Integer.parseInt(a[i]);
        }
        return num;
    }
    public int[] rand(){
        Random ran = new Random();
        int[] a=new int[11];
        int[] rand=new int[200];
        for(int i=0;i<rand.length;i++)
            rand[i]=i+1;
        for (int i=0;i<a.length;i++)
        {
            int k =ran.nextInt(200-i);
            a[i]=rand[k];
            int tem = rand[k];
            rand[k]=rand[200-i-1];
            rand[200-i-1]=tem;
        }
        return a;
    }
    public int[] sort(int[] a){
        Arrays.sort(a);
        return a;
    }
    public  int[] shortest(int[] a){
        int f=0;
        int tem1;
        int tem2;
        for(int i=0;i<10;i++) {
            f=i+1;
            tem1=Math.abs(a[i+1]-a[i]);
            for (int j=i+2;j<11;j++){
                tem2=Math.abs(a[j]-a[i]);
                if(tem2<tem1)
                {
                    tem1=tem2;
                    f=j;
                    //System.out.println("当前最小的数为:"+f+" "+a[f]);
                }
            }
            int s=a[f];
            a[f]=a[i+1];
            a[i+1]=s;
        }
        return a;
    }
    public int[] scan(int[] a,String s){
        int k=a[0];
        int j=0;
        int t=0;
        this.sort(a);
        for(int i=0;i<11;i++){
            if (a[i]==k){
                j=i;
                break;
            }
        }
        int[] b=new int[11];
        if(Objects.equals(s, "r")) {
            for (int i = j; i < 11; i++) {
                b[t] = a[i];
                t++;
            }
            for (int i = j - 1; i >= 0; i--) {
                b[t] = a[i];
                t++;
            }
        }
        if(Objects.equals(s, "l")) {
            for (int i = j; i >=0; i--) {
                b[t] = a[i];
                t++;
            }
            for (int i = j + 1; i <11; i++) {
                b[t] = a[i];
                t++;
            }
        }
        return b;
    }
    public int[] cscan(int[] a,String s){
        int k=a[0];
        int j=0;
        int t=0;
        this.sort(a);
        for(int i=0;i<11;i++){
            if (a[i]==k){
                j=i;
                break;
            }
        }
        int[] b = new int[11];
        if(Objects.equals(s, "r")) {
            for (int i = j; i < 11; i++) {
                b[t] = a[i];
                t++;
            }
            for (int i = 0; i < j; i++) {
                b[t] = a[i];
                t++;
            }
        }
        else if(Objects.equals(s, "l")){
            for (int i = j; i >=0; i--) {
                b[t] = a[i];
                t++;
            }
            for (int i = 10; i > j; i--) {
                b[t] = a[i];
                t++;
            }
        }
        return b;
    }
}
