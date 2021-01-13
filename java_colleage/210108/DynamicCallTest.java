package ch07;

class Animal
{
    void sound()
    {
        System.out.println("animal sound");
    }
}

class Dog extends Animal
{
    void sound()
    {
        System.out.println("munmum");
    }
}

class Cat extends Animal
{
    void sound()
    {
        System.out.println("yammaya");
    }
}

public class DynamicCallTest {
    public static void main(String[] args)
    {
        Animal animal=new Animal();
        Dog dog=new Dog();
        Cat cat=new Cat();

        Animal obj;
        obj=animal;
        obj.sound();

        obj=dog;
        obj.sound();

        obj=cat;
        obj.sound();
    }
}
