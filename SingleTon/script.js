/*
usage examples:
  driver objects, database connections.

Types:
  Early initialization : In this method, class is initialized whether it is to be used or not. The main advantage of this method is its simplicity. You initiate the class at the time of class loading. Its drawback is that class is always initialized whether it is being used or not.

  Lazy initialization : In this method, class in initialized only when it is required. It can save you  from instantiating the class when you don’t need it. Generally, lazy initialization is used when we  create a singleton class.

*/


// let singletonInstance = null;

// class SingletonExample {
//   constructor() {
//     // Check if the instance exists or is null
//     if (!singletonInstance) {
//       // If null, set singletonInstance to this Class 
//       singletonInstance = this;
//     }

//     // Returns the initiated Class
//     return singletonInstance;
//   }
// }

// // Create a new instance of singleton Class
// let singletonExample = new SingletonExample();
// let singletonExample2 = new SingletonExample();

// console.log(singletonExample === singletonExample2);


class BankAccount{
  instance = null;
  amount = 0;
  contructor(){}

  deposit(amount){
    this.amount += amount
  }

  withdraw(amount){
    this.amount -= amount    
  }

  getBalance(){
    return this.amount;
  }

  getInstance(){
    if(this.instance){
      return this
    }else{
      this.instance = this;
    }
    return this.instance
  } 
}

let myAcc = new BankAccount();
myAcc.deposit(50);
console.log(myAcc.getBalance());


let acc2 = new BankAccount();
myAcc.deposit(50);
console.log(myAcc.getBalance());
