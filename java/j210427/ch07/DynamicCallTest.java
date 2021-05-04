package j210427.ch07;

public class DynamicCallTest {
    public static void main(String[] args)
    {
        Animal1 animal=new Animal1();
        Dog dog=new Dog();
        Cat cat=new Cat();

        Animal1 obj;

        obj=animal;
        obj.sound();
        obj=dog;
        obj.sound();
        obj=cat;
        obj.sound();
    }
}

class Animal1
{
    void sound()
    {
        System.out.println("Animal1 : sound() = ");
    }
}

class Cat extends Animal1
{
    void sound()
    {
        System.out.println("cat");
    }
}

class Dog extends Animal1
{
    void sound()
    {
        System.out.println("Dog");
    }
}
