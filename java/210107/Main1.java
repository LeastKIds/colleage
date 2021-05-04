package ch06;

public class Main1
{
  public static void main(String[] args)
  {
  //  Dog dog=new Dog();
    //dog.speak();

    //Animal animal=new Dog();
    //animal.speak(); //dynamic binding

    Animal animal1=new Animal()
    {
      @Override
      public void speak()
      {
        System.out.println("yamm");
      }
    };

    animal1.speak();
  }
}
