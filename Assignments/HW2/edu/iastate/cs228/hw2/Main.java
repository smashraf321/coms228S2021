package edu.iastate.cs228.hw2;

import java.util.ListIterator;

class Main {
  public static void main(String[] args)
  {

      PrimeFactorization pfTester = new PrimeFactorization();

      pfTester.iterTester();

      System.out.println(pfTester.toString());

//      for(PrimeFactor pf : pfTester)
//      {
//          System.out.println(pf.toString());
//      }





















//      cloneTester();

//      for(int i = 2; i < 101; i++)
//      {
//          long n = 2147483659L;//i;
//          System.out.println("N: ["+n+"]");
//          long divisor = 2L;
//          long multiplicity = 0L;
//          long previousMultiplicity = 0L;
//
//          while(divisor * divisor <= n)
//          {
//              if(n % divisor == 0)
//              {
//                  n = n / divisor;
//                  multiplicity++;
//                  previousMultiplicity = multiplicity;
//              }
//              else
//              {
//                  // if multiplicity > 0, then add new node with
//                  // Prime number = divisor
//                  // Multiplicity = multiplicity
//                  if(multiplicity > 0)
//                  {
////                  System.out.println("P["+divisor+"] M["+multiplicity+"]");
//                      System.out.print(divisor+"^"+multiplicity+" * ");
//                  }
//
//                  // reset multiplicity
//                  multiplicity = 0;
//
//                  // increment divisor
//                  if(divisor == 2)
//                  {
//                      divisor++;
//                  }
//                  else
//                  {
//                      divisor += 2;
//                  }
//              }
//          }
//          // add node with
//          // Prime number = n
//          // Multiplicity = 1 if n != prev divisor, else final multiplicity + 1
//
//          if(multiplicity > 0 && n != divisor)
//          {
////          System.out.println("P["+divisor+"] M["+multiplicity+"]");
//              System.out.print(divisor+"^"+multiplicity+" * ");
//          }
//
//          if(n != divisor)
//          {
////          System.out.println("P["+n+"] M["+1+"]");
//              System.out.print(n+"^"+1+" * ");
//          }
//          else
//          {
////          System.out.println("P["+n+"] M["+(1+previousMultiplicity)+"]");
//              System.out.print(n+"^"+(1+previousMultiplicity)+" * ");
//          }
//          System.out.println("\n---------------------------------------------");
//      }

//    int count = 0;
//    for(int i = 0; i < 1000; i++)
//    {
//      if(PrimeFactorization.isPrime(i))
//      {
//          count++;
//          String displayString = " ";
//          if(i < 10)
//          {
//              displayString += " ";
//          }
//          if(i < 100)
//          {
//              displayString += " ";
//          }
//          displayString += i;
//          if(count % 25 == 0)
//          {
//              displayString += "\n";
//          }
//          System.out.print(displayString);
//      }
//    }
//    System.out.println("\n\n count: " + count);

  }

  public static void cloneTester()
  {
      class Dog{

          private String name;

          public Dog(String name) {
              super();
              this.name = name;
          }

          public Dog(Dog otherDog) {

              this.name = otherDog.name;
          }

          public String getName() {
              return name;
          }

          public void setName(String name) {
              this.name = name;
          }

      }

      Dog[] myDogs = new Dog[4];

      myDogs[0] = new Dog("Wolf");
      myDogs[1] = new Dog("Pepper");
      myDogs[2] = new Dog("Bullet");
      myDogs[3] = new Dog("Sadie");

      Dog[] myDogsClone = myDogs.clone();

//      System.out.println(myDogs[0] == myDogsClone[0] ? "Same":"Different");
//      System.out.println(myDogs[1] == myDogsClone[1] ? "Same":"Different");
//      System.out.println(myDogs[2] == myDogsClone[2] ? "Same":"Different");
//      System.out.println(myDogs[3] == myDogsClone[3] ? "Same":"Different");

      Dog temp;
      temp = myDogs[0];
      myDogs[0] = myDogs[1];
      myDogs[1] = temp;
//      System.out.println(myDogs[0].getName());
//      System.out.println(myDogs[1].getName());
//      System.out.println(myDogsClone[0].getName());
//      System.out.println(myDogsClone[1].getName());

      Dog d1 = new Dog("Bolt");
      Dog d2 = new Dog("Trevor");

      System.out.println(d1.getName());
      System.out.println(d2.getName());

      Dog td;

      td = new Dog(d2);
      d2 = new Dog(d1);
//      System.out.println(d1.getName());
//      System.out.println(d2.getName());
//      System.out.println(td.getName());
      d1 = new Dog(td);


      System.out.println(d1.getName());
      System.out.println(d2.getName());

      td.setName("nnnnn");
      System.out.println(d1.getName());
      System.out.println(d2.getName());

  }
}
