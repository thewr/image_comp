/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

interface List<T> {
    public int size();            
    public void add(int pos, T x);  
    public void add(T x);                 
    public T get(int pos);             
    public T remove();                   
}


public class Window extends LinkedList {
    //FOR WINDOW
    LinkedList<Double> elements = new LinkedList<>(); 
    LinkedList<Double> weights = new LinkedList<>();
    private Window queueInstance = null;
    private final static int DEFAULT_N = 7;
    private final int N;
    public static double v=0.0;

    boolean implosion = false;
        
    public Window getStreamInstance(int N) {

            if (queueInstance == null) {
                   queueInstance = new Window(N);
            }
           elements.clear();
           return queueInstance;
    }
    
    public Window(){
        this(DEFAULT_N);
        elements.clear();
    }
    
    public double getPred(){
        return v;
    }
    

    public Window(int maxN){
        N=maxN;
        elements.clear();
        for(int i = 0; i < N; i++)
            weights.add(hamming(i));
    }
    
    public Queue<Double> get() {
            return elements;
    }
    
    public void clear(){
        elements.clear();
    }
    
    // Inserts the specified element into this queue if it is possible to do so
    // immediately without violating capacity restrictions
    public void add(double value) {
        if(isFull())
            elements.removeFirst();
        elements.addLast(value);   
        //sort();
    }
    
    
    public double[] PCI(){
        
        int n = elements.size();
        int k = 6;
        int[] weights = new int[n];
        double sumtotal = 0.0;
        double sumweights = 0.0;
        //twosided
        /*
        for(int i=0; i<2*k; i++)
        {
            if(i<k)
                arr[i] = (i+1);
            else
                arr[i] = 2*k-i;
        }
        */
        //one sided
        for(int i =0;i<2*k;i++)
        {
            weights[i] = i+1;
            sumweights += weights[i];
        }
        for(int i = 0; i<2*k;i++)
        {
            sumtotal += elements.get(i)*weights[i];
        }
        
        v = sumtotal/(double)sumweights;
        
        for(int i = 0; i<2*k;i++)
        {
            sumtotal += Math.pow(elements.get(i)-v,2.0);
        }
        double s = Math.sqrt(sumtotal/(2*k-2));
        double lower = v-0.868*s*Math.sqrt(1+1/(2*k));
        double upper =v+0.692*s*Math.sqrt(1+1/(2*k));
        double[] CI = {round(lower,2), round(upper,2)};
        return CI;
    }
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

            BigDecimal bd = BigDecimal.valueOf(value);
            bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public void sort()
    {
        int n = elements.size(); 
        for (int i = 1; i < n; ++i) { 
            double key = elements.get(i); 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && elements.get(j) > key) { 
                elements.set(j + 1, elements.get(j)); 
                j = j - 1; 
            } 
            elements.set(j + 1, key); 
        } 
    }
        
    
    /*
    public double getQuartile(int k){
       int size = list.size();
       if(size==1){
           return list.get(size);
       }
       if(size%2!=0){
           return list.get(k*size/4);
       }
       return 0.5*(list.get(k*size/4-1)+list.get(k*size/4));
   }*/
    
    public void append(int value) {
        elements.removeFirst();
        add(value);
    }
        
    // Removes a single instance of the specified element from this collection
    public void replace(double value) {
        elements.removeLast();
        elements.addLast(value);
    }
    
    public int size(){
        return elements.size();
    }
    
    public long[] corr(int p){
        int M = elements.size();
        Integer[] x = elements.toArray(new Integer[elements.size()]);
        long[] R = new long[M];
        long r = 0;
        for(int i = 0; i <= p; i++) {
          R[i] = 0;
          long temp = 0;
          for(int j = 0; j < M-i; j++) {
            temp += (long)x[j]*(long)x[j+i];
          }
          R[i] += temp;
        }
        return R;
    }
    

    // Returns true if this collection contains no elements
    public boolean isEmpty() {
            return elements.isEmpty();
    }

    // Returns the number of elements in this collection. If this collection
    // contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE
    public int getTotalSize() {
            return elements.size();
    }
   

    public double median(){
        int M = elements.size();
        Integer[] a = elements.toArray(new Integer[elements.size()]);
        Arrays.sort(a);
        if(M%2!=0)
            return (double)a[M/2];
        return (double)(a[(M-1)/2] + a[M/2]) / 2.0; 
    }
    
    public double median(double[] a)
    {
        Arrays.sort(a);
        int M = a.length;
        
        if(M%2!=0)
            return (double)a[M/2];
        return (double)(a[(M-1)/2] + a[M/2]) / 2.0; 
    }
    
    public double median(LinkedList<Integer> v)
    {
        int M = v.size();
        Integer[] a = elements.toArray(new Integer[v.size()]);
        Arrays.sort(a);        
        
        if(M%2!=0)
            return (double)a[M/2];
        return (double)(a[(M-1)/2] + a[M/2]) / 2.0; 
    }
    
    public double MAD(){
        int M = elements.size();
        Integer[] a = elements.toArray(new Integer[elements.size()]);
        Arrays.sort(a);
        double xm = median();
        double[] A = new double[M];
        for(int i = 0; i<M; i++)
            A[i] = Math.abs(a[i]-xm);
        double MAD = median(A);
        if((MAD==0.0))//&&(xm==elements.peekLast()))
            implosion = true;
        else
            implosion = false;
        return MAD;// mSk;
    }
    
    
    public boolean isFull(){
        return elements.size()==N;
    }
    
    public double triangle(int t){
        double den = (N)*(N+1)/2.0;
        return 1/den;
    }
    
    public double hamming(int t){
        return 0.54-.46*Math.cos(2*Math.PI*t/N);
    }
    
    public double blackman(int t){
        return 0.427-0.497*Math.cos(2*Math.PI*t/N)+0.077*Math.cos(4*Math.PI*t/N);
    }
    
    public double smooth(){
        double sumxw, sumw, w;
        sumxw = sumw = w = 0.0;
        double x;
        x = 0;
        ListIterator<Double> it = elements.listIterator();
        int M = elements.size();
            for(int k = 0; k < M; k++){
                w = weights.get(k);
                sumw += w;
                x = it.next();
                sumxw += x*w;
            }
     //   }
        return sumxw/(double)sumw;
    }
    
    @Override
    public String toString(){
        ListIterator<Double> it = elements.listIterator();
        String out = " ";
        while(it.hasNext()){
            double value = it.next();
            out += String.format("%8d", value);
        }
        return out;
    }
}