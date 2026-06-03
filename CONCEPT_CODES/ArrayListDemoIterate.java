import java.util.*;

class ArrayListDemoIterate 
{
    public static void main(String[] args) 
    {
        ArrayList <Float> aobj= new ArrayList<Float>();

        aobj.add(99.3f);
        aobj.add(44.3f);
        aobj.add(68.3f);
        aobj.add(90.78f);

        Iterator iobj = aobj.iterator();

        while(iobj.hasNext())
        {
            System.out.println(iobj.next());
        }


       
    }   
}
